package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.typesystem.WorthwhileTypesystem;

/**
 * Performs semantic validation on a Worthwhile program.
 * 
 */
public class WorthwhileJavaValidator extends AbstractWorthwhileJavaValidator {

	/**
	 * The language typesystem.
	 */
	@Inject
	private ITypesystem ts;

	/**
	 * Checks if a function declaration contains a return statement on all code paths.
	 * 
	 * @param functionDeclaration
	 *                The function declaration to check.
	 */
	@Check
	public final void checkFunctionDeclarationValidReturnStatment(final FunctionDeclaration functionDeclaration) {
		ValidatorASTNodeVisitor validatorASTNodeVisitor = new ValidatorASTNodeVisitor();
		validatorASTNodeVisitor.visit(functionDeclaration);
		if (!validatorASTNodeVisitor.getValidReturnFound()) {
			error("Function has no valid return statement.", functionDeclaration,
			                AstPackage.eINSTANCE.getFunctionDeclaration_Name(), 0);
		}
	}

	/**
	 * Checks that a return value reference is only used in the postcondition of a function.
	 * 
	 * @param returnValueReference
	 *                The return value reference to check.
	 */
	@Check
	public final void checkReturnValueReference(final ReturnValueReference returnValueReference) {
		EObject current = returnValueReference;

		do {
			current = current.eContainer();
		} while (current != null && !(current instanceof Postcondition));

		if (current == null) {
			error("The return value of a function may only be referenced in the postcondition.",
			                returnValueReference, null, -1);
		}
	}

	/**
	 * Checks if a return statement is only contained by a function block. If so the type of the return statement
	 * and its function will also be checked.
	 * 
	 * @param returnStatement
	 *                The return statement to check.
	 */
	@Check
	public final void checkReturnStatementOnlyFunction(final ReturnStatement returnStatement) {

		EObject current = returnStatement;

		do {
			current = current.eContainer();
		} while (current != null && !(current instanceof FunctionDeclaration));

		if (current == null) {
			// No FunctionDeclaration found
			error("The return statement has to be in a function block.", returnStatement, null, -1);
		} else {
			// Check if the type of the return statement is the same as the type of the function
			TypeCalculationTrace trace = new TypeCalculationTrace();
			if (!ts.isSameType(returnStatement, ts.typeof(returnStatement.getReturnValue(), trace),
			                current, ts.typeof(current, trace), trace)) {
				error("Type mismatch. Expected " + ts.typeString(ts.typeof(current, trace))
				                + ", but found "
				                + ts.typeString(ts.typeof(returnStatement.getReturnValue(), trace))
				                + ".", returnStatement.getReturnValue(), null, -1);
			}
		}
	}

	/**
	 * Checks if the function call parameters match with the ones of the called function.
	 * 
	 * @param functionCall
	 *                The function call to be checked.
	 */
	@Check
	public final void checkFunctionCallParameter(final FunctionCall functionCall) {

		if (functionCall.getActuals().size() != functionCall.getFunction().getParameters().size()) {
			error("The amount of parameters is incorrect. Expecting "
			                + functionCall.getFunction().getParameters().size() + " parameters, but found "
			                + functionCall.getActuals().size() + ".", functionCall, null, -1);
		} else {
			TypeCalculationTrace trace = new TypeCalculationTrace();
			EList<Expression> actuals = functionCall.getActuals();
			EList<VariableDeclaration> parameters = functionCall.getFunction().getParameters();

			for (int i = 0; i < actuals.size(); i++) {
				if (!((WorthwhileTypesystem) ts).isSameType(functionCall,
				                ts.typeof(actuals.get(i), trace), functionCall.getFunction(),
				                ts.typeof(parameters.get(i), trace), trace)) {
					error("Expected parameter " + ts.typeString(ts.typeof(parameters.get(i), trace))
					                + " , but found " + ts.typeString(ts.typeof(actuals.get(i), trace)) + ".",
					                actuals.get(i), null, -1);

				}
			}
		}
	}

	/**
	 * Checks if the arrayLiteral is used in an initialization and if all entries have the same type as the variable
	 * which get initialized.
	 * 
	 * @param arrayLiteral
	 *                The array literal to be checked.
	 */
	@Check
	public final void checkArrayLiteral(final ArrayLiteral arrayLiteral) {
		EObject current = arrayLiteral;
		boolean inVariableDec = false;
		boolean inAssignment = false;
		EList<Expression> actuals = arrayLiteral.getValues();
		TypeCalculationTrace trace = new TypeCalculationTrace();
		// Check which container the arrayLiteral has
		current = current.eContainer();
		if (current instanceof VariableDeclaration) {
			inVariableDec = true;
		} else if (current instanceof Assignment) {
			inAssignment = true;
		}
		EObject type = ts.typeof(actuals.get(0), trace);

		if (ts.isInstanceOf(ts.typeof(current, trace), AstPackage.eINSTANCE.getArrayType(), trace)) {

			if (inAssignment) {

				type = ((ArrayType) ((Assignment) current).getVariable().getVariable().getType())
				                .getBaseType();
			} else if (inVariableDec) {
				type = ((ArrayType) ((VariableDeclaration) current).getType()).getBaseType();
			}
		}
		for (int i = 0; i < actuals.size(); i++) {
			if (!ts.isSameType(type, type, actuals.get(i), ts.typeof(actuals.get(i), trace), trace)) {
				error("Element doesn't match type of the array. Expected " + ts.typeString(type)
				                + ", but found " + ts.typeString(ts.typeof(actuals.get(i), trace))
				                + ".", actuals.get(i), null, -1);
			}
		}

	}

	/**
	 * Checks if the given AST node conforms to the typesystem rules.
	 * 
	 * @param node
	 *                The AST node to check.
	 */
	@Check
	public final void checkTypesystemRules(final ASTNode node) {
		ts.checkTypesystemConstraints(node, this);
	}

	/**
	 * Check that function and variable name identifiers are unique.
	 * 
	 * @param node
	 *                The AST node to check.
	 */
	@Check
	public final void checkNamesAreUnique(final ASTNode node) {
		NamesAreUniqueValidator val = new NamesAreUniqueValidator();
		val.checkUniqueNamesInResourceOf(node);
	}
}
