package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeBottomUpVisitor;
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

		ASTNodeBottomUpVisitor<Boolean> visitor = new ASTNodeBottomUpVisitor<Boolean>() {

			public void visit(final Postcondition postcondition) {
				setReturnValue(true);
			}
		};
		if (visitor.apply(returnValueReference) == null) {
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

		ASTNodeBottomUpVisitor<Type> visitor = new ASTNodeBottomUpVisitor<Type>() {

			public void visit(final FunctionDeclaration func) {
				setReturnValue(func.getReturnType());
			}
		};

		Type type = visitor.apply(returnStatement);
		// no function declaration found
		if (type == null) {
			error("The return statement has to be in a function block.", returnStatement, null, -1);

			// compare the type of the function declaration and the returnStatement
		} else if (!ts.isSameType(returnStatement, ts.typeof(returnStatement, new TypeCalculationTrace()),
		                type, type, new TypeCalculationTrace())) {
			error("Type mismatch. Expected " + ts.typeString(type) + ", but found "
			                + ts.typeString(ts.typeof(returnStatement, new TypeCalculationTrace())) + ".",
			                returnStatement, null, -1);
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
					error("Expected parameter "
					                + ts.typeString(ts.typeof(parameters.get(i), trace))
					                + " , but found "
					                + ts.typeString(ts.typeof(actuals.get(i), trace)) + ".",
					                actuals.get(i), null, -1);

				}
			}
		}
	}

	/**
	 * Checks if all elements of the {@link ArrayLiteral} have the same type. The type may not be {@link ArrayType}
	 * 
	 * @param arrayLiteral
	 *                The array literal to be checked.
	 */
	@Check
	public final void checkArrayLiteral(final ArrayLiteral arrayLiteral) {

		ASTNodeBottomUpVisitor<Boolean> visitor = new ASTNodeBottomUpVisitor<Boolean>() {

			public void visit(final ArrayLiteral arrayLiteral) {
				setReturnValue(true);
			}
		};
		// if this array literal is contained in an other one
		if (visitor.apply((ASTNode) arrayLiteral.eContainer())) {
			error("An array may not contain an other array.", arrayLiteral, null, -1);
		} else {
			EList<Expression> actuals = arrayLiteral.getValues();
			TypeCalculationTrace trace = new TypeCalculationTrace();

			Type type = ((ArrayType) ts.typeof(arrayLiteral, trace)).getBaseType();

			for (int i = 0; i < actuals.size(); i++) {
				if (!ts.isSameType(type, type, actuals.get(i), ts.typeof(actuals.get(i), trace), trace)) {
					error("Element doesn't match type of the array. Expected "
					                + ts.typeString(type) + ", but found "
					                + ts.typeString(ts.typeof(actuals.get(i), trace)) + ".",
					                actuals.get(i), null, -1);
				}
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
