package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Substitute {@link ReturnValueReference}s in an {@link Expression} with another {@link Expression}.
 * 
 * @see ReturnValueReferenceSubstitution#substitute(VariableDeclaration, Expression)
 * @author fabian
 * 
 */
class ReturnValueReferenceSubstitution extends SubstitutionVisitor<Expression> {
	/**
	 * The <code>Expression</code> <code>ReturnValueReferences</code> are substituted with.
	 */
	private final Expression substitute;

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
		super(null);
		this.substitute = substitute;
	}

	@Override
	public void visit(final ReturnValueReference returnValueReference) {
		final Expression index = returnValueReference.getIndex();
		if (index != null) {
			this.substitute.accept(new HierarchialASTNodeVisitor() {
				@Override
				public void visit(final ArrayFunction arrayFunction) {
					final ArrayFunctionAccess substitute = AstNodeCreatorHelper
					                .createArrayFunctionAccess(index, arrayFunction);
					ReturnValueReferenceSubstitution.this.setSubstitute(substitute);
				}

				@Override
				public void visit(final VariableReference variableReference) {
					final VariableReference substitute = AstNodeCloneHelper
					                .clone(variableReference);
					substitute.setIndex(returnValueReference.getIndex());
					ReturnValueReferenceSubstitution.this.setSubstitute(substitute);
				}
			});
		} else {
			this.setSubstitute(this.substitute);
		}

		this.setFound(true);
	}
}
