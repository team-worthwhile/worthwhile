package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;

/**
 * Substitute {@link VariableReference}s in an {@link Expression} with another {@link Expression}.
 * 
 * @see VariableReferenceSubstitution#substitute(VariableDeclaration, Expression)
 * @author fabian
 * 
 */
public class VariableReferenceSubstitution extends SubstitutionVisitor<Expression> {
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
			return substitutor.getSubstitute();
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
	 * 
	 * @param variable
	 *                the {@link VariableDeclaration} the substituted {@link VariableReference}s have to be
	 *                occurrences of
	 * @param substitute
	 *                the {@link Expression} occurrences of {@link VariableReferenceSubstitution#variable} are
	 *                substituted with
	 */
	VariableReferenceSubstitution(final VariableDeclaration variable, final Expression substitute) {
		super(null);
		this.variable = variable;
		this.substitute = substitute;
	}

	@Override
	public void visit(final VariableReference variableReference) {
		// visit index before maybe replacing the VariableReference
		super.visit(variableReference);

		final VariableDeclaration referencedVariable = variableReference.getVariable();

		if (referencedVariable == this.variable) {
			final Expression index = variableReference.getIndex();
			if (index != null) {
				this.setSubstitute(AstNodeCreatorHelper.createArrayAccess(index,
				                AstNodeCloneHelper.clone(this.substitute)));
			} else {
				this.setSubstitute(this.substitute);
			}
			this.setFound(true);
		}
	}
}
