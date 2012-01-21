package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
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
			error("The return statement has to be in a function block.", returnStatement, null, -1);
		} else {
			WorthwhileTypesystem wts = (WorthwhileTypesystem) ts;
			if (!equalTypes(wts.type(returnStatement), wts.type((FunctionDeclaration) current))) {
				error("The return type has to be the same as the type of its function.",
				                returnStatement, null, -1);
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
			error("The amount of parameters is incorrect.", functionCall, null, -1);
		} else {
			WorthwhileTypesystem wts = (WorthwhileTypesystem) ts;
			EList<Expression> actuals = functionCall.getActuals();
			EList<VariableDeclaration> parameters = functionCall.getFunction().getParameters();

			for (int i = 0; i < actuals.size(); i++) {
				if (!equalTypes(wts.type(actuals.get(i)), wts.type(parameters.get(i)))) {
					error("The " + (i + 1) + ". parameter has the wrong type.", functionCall, null,
					                -1);
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
	 * Checks if the the two given types are the same.
	 * 
	 * @param type1
	 *                the first type to be checked
	 * @param type2
	 *                the second type to be checked
	 * @return true if the types are the same, otherwise false
	 */
	private boolean equalTypes(final EObject type1, final EObject type2) {
		String type = type1.toString().substring(0, type1.toString().indexOf("@"));
		return type2.toString().contains(type);
	}
}
