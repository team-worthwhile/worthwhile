package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Substitute {@link VariableReference}s in an {@link Expression} with another {@link Expression}.
 * 
 * @see VariableReferenceSubstitution#substitute(VariableDeclaration, Expression)
 * @author fabian
 * 
 */
class VariableReferenceSubstitution extends HierarchialASTNodeVisitor {
	/**
	 * Substitutes occurrences of a {@link VariableDeclaration} in an {@link Expression} with another
	 * <code>Expression</code>.
	 * 
	 * A clone of the <code>substitute</code> is used for substitution.
	 * 
	 * @param expression
	 *                the <code>Expression</code> to search for occurrences of <code>variable</code>
	 * @param variable
	 *                the <code>VariableDeclaration</code> the substituted {@link VariableReference}s have to be
	 *                occurrences of
	 * @param substitute
	 *                the <code>Expression</code> occurrences of <code>variable</code> are substituted with
	 * @return the substituted <code>expression</code>, which differs from the passed <code>expression</code> when
	 *         the <code>expression</code> itself was an occurrence of <code>variable</code>
	 */
	public static Expression substitute(final Expression expression, final VariableDeclaration variable,
	                final Expression substitute) {
		final VariableReferenceSubstitution substitutor = new VariableReferenceSubstitution(variable,
		                substitute);
		expression.accept(substitutor);
		if (substitutor.found) {
			substitutor.found = false;
			return AstNodeCloneHelper.clone(substitute);
		}
		return expression;
	}

	/**
	 * The {@link VariableDeclaration} the substituted {@link VariableReference}s have to be occurrences of.
	 */
	private VariableDeclaration variable;

	/**
	 * The {@link Expression} occurrences of {@link VariableReferenceSubstitution#variable} are substituted with.
	 */
	private Expression substitute;

	/**
	 * Indicates whether a matching {@link VariableReference} has been found and has to be substituted in the parent
	 * {@link ASTNode}.
	 */
	private Boolean found = false;

	/**
	 * 
	 * @param variable
	 *                the {@link VariableDeclaration} the substituted {@link VariableReference}s have to be
	 *                occurrences of
	 * @param substitute
	 *                the {@link Expression} occurrences of {@link VariableReferenceSubstitution#variable} are
	 *                substituted with
	 */
	VariableReferenceSubstitution(final VariableDeclaration variable, final Expression substitute) {
		this.variable = variable;
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
		// we reached a not a VariableReference leaf, ignore default operation
	}

	@Override
	public void visit(final VariableReference variableReference) {
		if (variableReference.getVariable() == this.variable) {
			this.found = true;
		}
	}
}
