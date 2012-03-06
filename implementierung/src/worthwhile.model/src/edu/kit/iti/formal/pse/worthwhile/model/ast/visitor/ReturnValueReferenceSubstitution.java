package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;

/**
 * Substitute {@link ReturnValueReference}s referring to a specific {@link FunctionDeclaration} in an {@link Expression}
 * with another {@link Expression}.
 * 
 * @see ReturnValueReferenceSubstitution#substitute(FunctionDeclaration, Expression, Expression)
 * @author fabian
 * 
 */
public class ReturnValueReferenceSubstitution extends SubstitutionVisitor<Expression> {
	/**
	 * The {@link FunctionDeclaration} the substituted {@link ReturnValueReference}s refer to.
	 */
	private final FunctionDeclaration function;

	/**
	 * The {@link Expression} {@link ReturnValueReference}s are substituted with.
	 */
	private final Expression substitute;

	/**
	 * Substitutes {@link ReturnValueReference}s referring to a specific {@link FunctionDeclaration} with the given
	 * {@link Expression}.
	 * 
	 * A clone of the <code>substitute</code> is used for substitution.
	 * 
	 * @param function
	 *                the <code>FunctionDeclaration</code> the substituted <code>ReturnValueReference</code>s refer
	 *                to
	 * @param expression
	 *                the <code>Expression</code> to search for <code>ReturnValueReferences</code>
	 * @param substitute
	 *                the <code>Expression</code> <code>ReturnValueReferences</code> are substituted with
	 * @return the substituted <code>expression</code>, which differs from the passed <code>expression</code> when
	 *         the <code>expression</code> itself was an <code>ReturnValueReference</code>
	 */
	public static Expression substitute(final FunctionDeclaration function, final Expression expression,
	                final Expression substitute) {
		final ReturnValueReferenceSubstitution substitutor = new ReturnValueReferenceSubstitution(function,
		                substitute);
		expression.accept(substitutor);
		if (substitutor.getFound()) {
			substitutor.setFound(false);
			return substitutor.getSubstitute();
		}
		return expression;
	}

	/**
	 * @param function
	 *                the {@link FunctionDeclaration} the substituted {@link ReturnValueReference}s refer to
	 * @param substitute
	 *                the {@link Expression} <code>ReturnValueReference</code>s are substituted with
	 */
	ReturnValueReferenceSubstitution(final FunctionDeclaration function, final Expression substitute) {
		super(null);
		this.function = function;
		this.substitute = substitute;
	}

	@Override
	public void visit(final ReturnValueReference returnValueReference) {
		// visit index before maybe inserting the return value here
		super.visit(returnValueReference);

		if (returnValueReference.getFunction().equals(this.function)) {
			final Expression index = returnValueReference.getIndex();
			if (index != null) {
				this.substitute.accept(new HierarchialASTNodeVisitor() {
					@Override
					public void visit(final ArrayFunction arrayFunction) {
						final ArrayAccess substitute = AstNodeCreatorHelper.createArrayAccess(
						                index, arrayFunction);
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
}
