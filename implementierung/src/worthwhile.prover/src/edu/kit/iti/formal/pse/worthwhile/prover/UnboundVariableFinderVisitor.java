package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.LinkedHashSet;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
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
	private Set<VariableDeclaration> boundVariables = new LinkedHashSet<VariableDeclaration>();

	/**
	 * The set of unbound variables that have to be declared.
	 */
	private Set<VariableDeclaration> unboundVariables = new LinkedHashSet<VariableDeclaration>();

	/**
	 * @return the set of unbound variables in the visited {@link Expression}s
	 */
	public final Set<VariableDeclaration> getUnboundVariables() {
		return this.unboundVariables;
	}

	@Override
	public final void visit(final ArrayFunction arrayFunction) {
		final Expression index = arrayFunction.getIndex();
		if (index != null) {
			index.accept(this);
		}

		arrayFunction.getValue().accept(this);

		final ArrayFunction chainedFunction = arrayFunction.getChainedFunction();
		if (chainedFunction != null) {
			chainedFunction.accept(this);
		}
	}

	@Override
	public final void visit(final ArrayFunctionAccess arrayFunctionAccess) {
		arrayFunctionAccess.getFunction().accept(this);
		arrayFunctionAccess.getIndex().accept(this);
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
		// since QuantifiedExpression#parameters are bound in the respective QuantifiedExpression#expression we
		// do not need to clone them, therefore add them temporarily to the variableMap so that
		// visit(VariableReference) does not create a copy we cannot remove from the variableMap anymore
		this.boundVariables.add(quantifiedExpression.getParameter());
		if (quantifiedExpression.getCondition() != null) {
			quantifiedExpression.getCondition().accept(this);
		}
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
