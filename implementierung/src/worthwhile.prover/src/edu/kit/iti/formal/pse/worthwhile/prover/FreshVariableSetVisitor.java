package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashMap;
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

public class FreshVariableSetVisitor extends HierarchialASTNodeVisitor {

	private Map<VariableDeclaration, VariableDeclaration> variableMap = new HashMap<VariableDeclaration, VariableDeclaration>();

	private Stack<Expression> substituteExpressionStack = new Stack<Expression>();

	public Map<VariableDeclaration, VariableDeclaration> getVariableMap() {
		return this.variableMap;
	}

	@Override
	public void visit(final BinaryExpression b) {
		b.getLeft().accept(this);
		b.setLeft(this.substituteExpressionStack.pop());
		b.getRight().accept(this);
		b.setRight(this.substituteExpressionStack.pop());
		this.substituteExpressionStack.push(b);
	}

	@Override
	public void visit(final Literal a) {
		this.substituteExpressionStack.push(a);
	}

	@Override
	public void visit(final UnaryExpression u) {
		u.getOperand().accept(this);
		u.setOperand(this.substituteExpressionStack.pop());
		this.substituteExpressionStack.push(u);
	}

	@Override
	public void visit(final VariableReference v) {
		if(!this.variableMap.containsKey(v.getVariable())) {
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
