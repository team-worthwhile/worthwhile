package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashSet;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * A visitor to find variables that are unbound and have to be declared.
 * 
 * @author Leon Handreke
 * 
 */
public class UnboundVariableFinderVisitor extends HierarchialASTNodeVisitor {

	/**
	 * The set of variables that is bound in the current visitor state.
	 */
	private Set<VariableDeclaration> boundVariables = new HashSet<VariableDeclaration>();

	/**
	 * The set of unbound variables that have to be declared.
	 */
	private Set<VariableDeclaration> unboundVariables = new HashSet<VariableDeclaration>();

	/**
	 * @return the set of unbound variables in the visited {@link Expression}s
	 */
	public final Set<VariableDeclaration> getUnboundVariables() {
		return this.unboundVariables;
	}

	@Override
	public final void visit(final BinaryExpression binaryExpression) {
		binaryExpression.getLeft().accept(this);
		binaryExpression.getRight().accept(this);
	}

	@Override
	public final void visit(final UnaryExpression unaryExpression) {
		unaryExpression.getOperand().accept(this);
	}

	@Override
	public final void visit(final Literal literal) {
		// literals can't really have any unbound variables...
	}

	@Override
	public final void visit(final QuantifiedExpression quantifiedExpression) {
		// a quantifiedExpression binds a variable
		this.boundVariables.add(quantifiedExpression.getParameter());
		quantifiedExpression.getCondition().accept(this);
		quantifiedExpression.getExpression().accept(this);
		this.boundVariables.remove(quantifiedExpression.getParameter());
	}

	@Override
	public final void visit(final VariableReference variableReference) {
		variableReference.getVariable().accept(this);
	}

	@Override
	public final void visit(final VariableDeclaration variableDeclaration) {
		if (!this.boundVariables.contains(variableDeclaration)) {
			this.unboundVariables.add(variableDeclaration);
		}
	}
}