package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Substitutes a child reference with some {@link Expression} in the parent {@link ASTNode} when indicated so by the
 * child.
 * 
 * Implements {@link HierarchialASTNodeVisitor#visit(FunctionCall}, {@link
 * HierarchialASTNodeVisitor#visit(QuantifiedExpression}, {@link HierarchialASTNodeVisitor#visit(BinaryExpression)} and
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
	 *                the {@link Expression} found child {@link ASTNode}s are substituted with
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

	/**
	 * @return a clone of the {@link SubstitutionVisitor#substitute}
	 */
	final Expression getSubstitute() {
		return AstNodeCloneHelper.clone(this.substitute);
	}

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} found child {@link ASTNode}s are substituted with
	 */
	final void setSubstitute(final Expression substitute) {
		this.substitute = substitute;
	}

	@Override
	public void visit(final QuantifiedExpression quantifiedExpression) {
		final Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			condition.accept(this);

			if (found) {
				quantifiedExpression.setCondition(this.getSubstitute());
				found = false;
			}
		}

		quantifiedExpression.getExpression().accept(this);
		if (found) {
			quantifiedExpression.setExpression(this.getSubstitute());
			found = false;
		}
	}

	@Override
	public void visit(final BinaryExpression binaryExpression) {
		binaryExpression.getLeft().accept(this);
		if (found) {
			binaryExpression.setLeft(this.getSubstitute());
			found = false;
		}

		binaryExpression.getRight().accept(this);
		if (found) {
			binaryExpression.setRight(this.getSubstitute());
			found = false;
		}
	}

	@Override
	public void visit(final FunctionCall functionCall) {
		for (final Expression a : functionCall.getActuals()) {
			a.accept(this);
		}
	};

	@Override
	public void visit(final UnaryExpression unaryExpression) {
		unaryExpression.getOperand().accept(this);
		if (found) {
			unaryExpression.setOperand(this.getSubstitute());
			found = false;
		}
	}

	@Override
	public void visit(final Literal literal) {
		// we reached an Expression leaf, ignore default operation
	}

	@Override
	public void visit(final VariableReference variableReference) {
		// we reached an Expression leaf, ignore default operation
	}
}