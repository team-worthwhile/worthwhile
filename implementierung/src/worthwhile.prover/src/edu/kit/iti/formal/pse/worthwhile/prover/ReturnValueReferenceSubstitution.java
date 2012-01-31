package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;

/**
 * Substitute {@link ReturnValueReference}s in an {@link Expression} with another {@link Expression}.
 * 
 * @see ReturnValueReferenceSubstitution#substitute(VariableDeclaration, Expression)
 * @author fabian
 * 
 */
class ReturnValueReferenceSubstitution extends SubstitutionVisitor {
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
		if (substitutor.getFound()) {
			substitutor.setFound(false);
			return substitutor.getSubstitute();
		}
		return expression;
	}

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} {@link ReturnValueReference}s are substituted with
	 */
	ReturnValueReferenceSubstitution(final Expression substitute) {
		super(substitute);
	}

	@Override
	public void visit(final ReturnValueReference returnValueReference) {
		this.setFound(true);
	}
}
