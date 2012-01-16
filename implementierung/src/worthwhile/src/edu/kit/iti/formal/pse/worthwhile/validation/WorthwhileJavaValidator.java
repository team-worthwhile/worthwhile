package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;

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
	public final void checkFunctionDeclerationValidReturnStatment(final FunctionDeclaration functionDeclaration) {
		ValidatorASTNodeVisitor validatorASTNodeVisitor = new ValidatorASTNodeVisitor();
		validatorASTNodeVisitor.visit(functionDeclaration);
		if (!validatorASTNodeVisitor.getValidReturnFound()) {
			error("Function has no valid return statement.", null);
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
