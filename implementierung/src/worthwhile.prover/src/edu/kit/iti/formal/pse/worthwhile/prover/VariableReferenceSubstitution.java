package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;

/**
 * Substitute {@link VariableReference}s in an {@link Expression} with another {@link Expression}.
 * 
 * @see VariableReferenceSubstitution#substitute(VariableDeclaration, Expression)
 * @author fabian
 * 
 */
class VariableReferenceSubstitution extends SubstitutionVisitor {
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
		if (substitutor.getFound()) {
			substitutor.setFound(false);
			return AstNodeCloneHelper.clone(substitute);
		}
		return expression;
	}

	/**
	 * The {@link VariableDeclaration} the substituted {@link VariableReference}s have to be occurrences of.
	 */
	private VariableDeclaration variable;

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
		super(substitute);
		this.variable = variable;
	}

	@Override
	public void visit(final VariableReference variableReference) {
		if (variableReference.getVariable() == this.variable) {
			this.setFound(true);
		}
	}
}