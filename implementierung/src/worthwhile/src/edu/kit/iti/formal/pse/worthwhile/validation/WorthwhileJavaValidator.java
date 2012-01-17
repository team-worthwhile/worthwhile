package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;

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
			error("Function has no valid return statement.", null);
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
	 * Checks if a return statement is only contained by a function block.
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

}
