package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.SubstitutionVisitor;

/**
 * A substitution visitor that replaces macro-like functions, i.e. functions which ensure exactly one return value, with
 * their ensured return value.
 * 
 * @author Joachim
 * 
 */
public class MacroSubstitution extends SubstitutionVisitor<Expression> {

	/**
	 * Default constructor.
	 */
	public MacroSubstitution() {
		super(null);
	}

	@Override
	public void visit(final FunctionCall functionCall) {
		// visit actuals, which are Expressions and could contain FunctionCalls themselves
		super.visit(functionCall);

		// Check whether the postcondition is simple and if yes, substitute it by the ensured return value.
		Expression postcondition = AstNodeCreatorHelper.createPostconditionConjunction(functionCall);
		Expression replacement = this.getSimplePostconditionReplacement(postcondition);

		if (replacement != null) {
			super.setFound(true);
			super.setSubstitute(replacement);
		}
	}

	/**
	 * Checks whether the given postcondition consists of only one equal with a {@link ReturnValueReference} on the
	 * left hand side and no {@code ReturnValueReference} in the right-hand side.
	 * 
	 * If that is the case we can replace the postcondition by the ensured value and do not need a quantifier. This
	 * clears up cluttered formulas when using helper function such as
	 * <code>function Integer double(Integer i)<br />_ensures _return = 2 * i</code>
	 * 
	 * @param postcondition
	 *                The postcondition to check
	 * @return The expression we can replace the postcondition with, or {@code null} if we cannot replace the
	 *         postcondition by a simple expression.
	 */
	private Expression getSimplePostconditionReplacement(final Expression postcondition) {
		if (postcondition == null) {
			return null;
		}

		if (!(postcondition instanceof Equal)) {
			return null;
		}

		Equal equalPC = (Equal) postcondition;

		if (!(equalPC.getLeft() instanceof ReturnValueReference)) {
			return null;
		}

		// Perform a deep search for a ReturnValueReference. If none is found, return true.
		Boolean isSimple = new ASTNodeReturnVisitor<Boolean>() {

			@Override
			public void defaultOperation(final ASTNode node) {
			}

			@Override
			public void visit(final ArrayAccess node) {
				if (node.getIndex() != null) {
					node.getIndex().accept(this);
				}
			}

			@Override
			public void visit(final BinaryExpression node) {
				if (node.getLeft() != null) {
					node.getLeft().accept(this);
				}

				if (node.getRight() != null) {
					node.getRight().accept(this);
				}
			}

			@Override
			public void visit(final FunctionCall node) {
				if (node.getActuals() != null) {
					for (Expression actual : node.getActuals()) {
						if (actual != null) {
							actual.accept(this);
						}
					}
				}
			}

			@Override
			public void visit(final QuantifiedExpression node) {
				if (node.getCondition() != null) {
					node.getCondition().accept(this);
				}

				if (node.getExpression() != null) {
					node.getExpression().accept(this);
				}
			}

			@Override
			public void visit(final UnaryExpression node) {
				if (node.getOperand() != null) {
					node.getOperand().accept(this);
				}
			}

			@Override
			public void visit(final ReturnValueReference node) {
				this.setReturnValue(false);
			}

		}.apply(equalPC.getRight(), true);

		if (isSimple) {
			return equalPC.getRight();
		} else {
			return null;
		}
	}

}
