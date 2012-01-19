package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Substitute {@link ReturnValueReference}s in an {@link Expression} with another {@link Expression}.
 * 
 * @see ReturnValueReferenceSubstitution#substitute(VariableDeclaration, Expression)
 * @author fabian
 * 
 */
class ReturnValueReferenceSubstitution extends HierarchialASTNodeVisitor {
	/**
	 * Substitutes {@link ReturnValueReference}s with the given {@link Expression}.
	 * 
	 * A clone of the <code>substitute</code> is used for substitution.
	 * 
	 * @param expression
	 *                the <code>Expression</code> to search for <code>ReturnValueReferences</code>
	 * @param substitute
	 *                the <code>Expression</code> <code>ReturnValueReferences</code> are substituted with
	 * @return the substituted <code>expression</code>, which differs from the passed <code>expression</code> when
	 *         the <code>expression</code> itself was an <code>ReturnValueReference</code>
	 */
	public static Expression substitute(final Expression expression, final Expression substitute) {
		final ReturnValueReferenceSubstitution substitutor = new ReturnValueReferenceSubstitution(substitute);
		expression.accept(substitutor);
		if (substitutor.found) {
			substitutor.found = false;
			return AstNodeCloneHelper.clone(substitute);
		}
		return expression;
	}

	/**
	 * The {@link Expression} {@link ReturnValueReference}s are substituted with.
	 */
	private Expression substitute;

	/**
	 * Indicates whether a matching {@link ReturnValueReference} has been found and has to be substituted in the
	 * parent {@link ASTNode}.
	 */
	private Boolean found = false;

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} {@link ReturnValueReference}s are substituted with
	 */
	ReturnValueReferenceSubstitution(final Expression substitute) {
		this.substitute = substitute;
	}

	@Override
	public void visit(final BinaryExpression binaryExpression) {
		binaryExpression.getLeft().accept(this);
		if (found) {
			binaryExpression.setLeft(AstNodeCloneHelper.clone(substitute));
			found = false;
		}

		binaryExpression.getRight().accept(this);
		if (found) {
			binaryExpression.setRight(AstNodeCloneHelper.clone(substitute));
			found = false;
		}
	}

	@Override
	public void visit(final UnaryExpression unaryExpression) {
		unaryExpression.getOperand().accept(this);
		if (found) {
			unaryExpression.setOperand(AstNodeCloneHelper.clone(substitute));
			found = false;
		}
	}

	@Override
	public void visit(Expression node) {
		// we reached a not a ReturnValueReference leaf, ignore default operation
	}

	@Override
	public void visit(final ReturnValueReference returnValueReference) {
		this.found = true;
	}
}
