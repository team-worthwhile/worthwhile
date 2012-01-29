package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.LinkedHashMap;
import java.util.Map;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * A visitor to replace all {@link VariableDeclaration} with new instances with the same name and type.
 * 
 * @author Leon Handreke
 */
public class FreshVariableSetVisitor extends HierarchialASTNodeVisitor {

	/**
	 * Map old variables to the new, fresh variables.
	 * 
	 * Use a LinkedHashMap here because the ordering of the keys is stable, which is needed to make the results
	 * deterministic
	 */
	private Map<VariableDeclaration, VariableDeclaration> variableMap = new LinkedHashMap<VariableDeclaration, VariableDeclaration>();

	/**
	 * A mapping from the substituted to the substitute {@link VariableDeclaration}s.
	 * 
	 * @return the mapping from old to new variables
	 */
	public final Map<VariableDeclaration, VariableDeclaration> getVariableMap() {
		return this.variableMap;
	}

	@Override
	public final void visit(final Literal literal) {
		// do nothing for Literals
	}

	@Override
	public final void visit(final BinaryExpression b) {
		b.getLeft().accept(this);
		b.getRight().accept(this);
	}

	@Override
	public final void visit(final FunctionCall functionCall) {
		for (final Expression e : functionCall.getActuals()) {
			e.accept(this);
		}
	}

	@Override
	public final void visit(final UnaryExpression u) {
		u.getOperand().accept(this);
	}

	@Override
	public final void visit(final QuantifiedExpression quantifiedExpression) {
		// since QuantifiedExpression#parameters are bound in the respective QuantifiedExpression#expression we
		// do not need to clone them, therefore add them temporarily to the variableMap so that
		// visit(VariableReference) does not create a copy we cannot remove from the variableMap anymore
		final VariableDeclaration parameter = quantifiedExpression.getParameter();
		this.variableMap.put(parameter, parameter);

		final Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			condition.accept(this);
		}

		quantifiedExpression.getExpression().accept(this);

		this.variableMap.remove(parameter);
	}

	@Override
	public final void visit(final VariableReference v) {
		if (!this.variableMap.containsKey(v.getVariable())) {
			// if the VariableDeclaration was first seen, create a new one with the same name
			VariableDeclaration newVariable = AstNodeCloneHelper.clone(v.getVariable());
			newVariable.setInitialValue(null);
			this.variableMap.put(v.getVariable(), newVariable);
		}
		// substitute the old VariableDeclaration with a fresh one
		v.setVariable(this.variableMap.get(v.getVariable()));
	}
}
