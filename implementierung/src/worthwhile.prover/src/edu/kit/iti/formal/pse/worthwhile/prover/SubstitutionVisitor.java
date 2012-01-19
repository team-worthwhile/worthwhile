package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Substitutes a child reference with some {@link Expression} in the parent {@link ASTNode} when indicated so by the
 * child.
 * 
 * Implements {@link HierarchialASTNodeVisitor#visit(BinaryExpression)} and
 * {@link HierarchialASTNodeVisitor#visit(UnaryExpression)} to traverse {@link Expression}s and substitute the
 * respective child references when the visited children called {@link SubstitutionVisitor#setFound(Boolean)}.
 * {@link HierarchialASTNodeVisitor#visit(Expression)} is implemented with an empty body so that the default visit
 * operation is ignored and subclasses just have to override the visit methods in which they want to actually call
 * {@link SubstitutionVisitor#setFound(Boolean)}.
 * 
 * @author fabian
 * 
 */
class SubstitutionVisitor extends HierarchialASTNodeVisitor {
	/**
	 * The {@link Expression} children are substituted with when {@link SubstitutionVisitor#found} was set.
	 */
	private Expression substitute;

	/**
	 * Indicates whether a matching child has been found and has to be substituted in the parent {@link ASTNode}.
	 */
	private Boolean found = false;

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} {@link ReturnValueReference}s are substituted with
	 */
	SubstitutionVisitor(final Expression substitute) {
		this.substitute = substitute;
	}

	/**
	 * @return the found
	 */
	final Boolean getFound() {
		return this.found;
	}

	/**
	 * @param found
	 *                the found to set
	 */
	final void setFound(final Boolean found) {
		this.found = found;
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
	public void visit(final Expression node) {
		// we reached a not a VariableReference leaf, ignore default operation
	}
}