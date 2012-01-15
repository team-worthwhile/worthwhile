package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * When visiting an {@link Expression} this {@link ASTNodeVisitor} substitutes variable occurrences with some other
 * {@link Expression}.
 * 
 * @author fabian
 * 
 */
class VariableSubstitution extends HierarchialASTNodeVisitor {
	/**
	 * Encapsulates the substitute process.
	 * 
	 * @author fabian
	 * 
	 */
	static class SubstituteCommand {
		/**
		 * Executes the substitute process.
		 */
		void substitute() {
			// empty by default
		}
	}

	/**
	 * The command to be called when {@link VariableSubstitution#variable} occurs.
	 */
	private SubstituteCommand substituteCommand;

	/**
	 * The variable to substitute with {@link VariableSubstitution#substitute}.
	 */
	private VariableDeclaration variable;

	/**
	 * The {@link Expression} {@link VariableSubstitution#variable} is substituted with.
	 */
	private Expression substitute;

	/**
	 * Private default constructor.
	 * 
	 * {@link VariableSubstitution#variable} and {@link VariableSubstitution#substitute} must be initialized at
	 * construction time.
	 */
	private VariableSubstitution() {
		// left empty intentionally
	}

	/**
	 * Creates a new {@link VariableSubstitution} that substitutes <code>variable</code> with <code>substitute</code>.
	 * 
	 * @param variable
	 *            the variable whose occurencces are to be substituted with <code>substitute</code>
	 * 
	 * @param substitute
	 *            the {@link Expression} occurrences of <code>variable</code> are to substituted with
	 * 
	 * @param substituteCommand
	 *            the {@link SubstituteCommand} to be called when an occurrence of <code>variable</code> is visited
	 */
	public VariableSubstitution(final VariableDeclaration variable, final Expression substitute, final SubstituteCommand substituteCommand) {
		this.variable = variable;
		this.substitute = substitute;
		this.substituteCommand = substituteCommand;
	}

	/**
	 * @return a cloned copy of the substitute
	 */
	private Expression getClonedSubsitute() {
		return AstNodeCloneHelper.clone(this.substitute);
	}

	/**
	 * 
	 * @param conjunction
	 *            the node to be visited
	 */
	public void visit(final Expression conjunction) {
		// ignore Expressions for that no children have to be substituted and that do not have to be tested for variable
		// occurrence
	}

	/**
	 * 
	 * @param unaryExpression
	 *            the node to be visited
	 */
	public void visit(final UnaryExpression unaryExpression) {
		this.substituteCommand = new SubstituteCommand() {
			@Override
			void substitute() {
				unaryExpression.setOperand(VariableSubstitution.this.getClonedSubsitute());
			}
		};
		unaryExpression.getOperand().accept(this);
	}

	/**
	 * 
	 * @param binaryExpression
	 *            the node to be visited
	 */
	public void visit(final BinaryExpression binaryExpression) {
		this.substituteCommand = new SubstituteCommand() {
			@Override
			void substitute() {
				binaryExpression.setLeft(VariableSubstitution.this.getClonedSubsitute());
			}
		};
		binaryExpression.getLeft().accept(this);

		this.substituteCommand = new SubstituteCommand() {
			@Override
			void substitute() {
				binaryExpression.setRight(VariableSubstitution.this.getClonedSubsitute());
			}
		};
		binaryExpression.getRight().accept(this);
	}

	/**
	 * 
	 * @param variableReference
	 *            the node to be visited
	 */
	public void visit(final VariableReference variableReference) {
		if (variableReference.getVariable().equals(variable)) {
			this.substituteCommand.substitute();
		}
	}
}
