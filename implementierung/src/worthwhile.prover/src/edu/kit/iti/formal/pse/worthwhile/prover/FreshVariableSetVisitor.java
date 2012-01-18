package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
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
	 * Stack to hand expressions back up the calling visit method.
	 */
	private Stack<Expression> substituteExpressionStack = new Stack<Expression>();

	/**
	 * A mapping from the substituted to the substitute {@link VariableDeclaration}s.
	 * 
	 * @return the mapping from old to new variables
	 */
	public final Map<VariableDeclaration, VariableDeclaration> getVariableMap() {
		return this.variableMap;
	}

	@Override
	public final void visit(final BinaryExpression b) {
		b.getLeft().accept(this);
		b.setLeft(this.substituteExpressionStack.pop());
		b.getRight().accept(this);
		b.setRight(this.substituteExpressionStack.pop());
		this.substituteExpressionStack.push(b);
	}

	@Override
	public final void visit(final Literal a) {
		this.substituteExpressionStack.push(a);
	}

	@Override
	public final void visit(final UnaryExpression u) {
		u.getOperand().accept(this);
		u.setOperand(this.substituteExpressionStack.pop());
		this.substituteExpressionStack.push(u);
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

		this.substituteExpressionStack.push(v);
	}
}
