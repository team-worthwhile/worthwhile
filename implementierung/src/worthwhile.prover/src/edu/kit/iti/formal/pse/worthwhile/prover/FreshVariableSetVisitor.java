package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;

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

	public void visit(BinaryExpression b) {
		b.getLeft().accept(this);
		b.setLeft(this.substituteExpressionStack.pop());
		b.getRight().accept(this);
		b.setRight(this.substituteExpressionStack.pop());
		this.substituteExpressionStack.push(b);
	}

	public void visit(Literal a) {
		this.substituteExpressionStack.push(a);
	}

	public void visit(UnaryExpression u) {
		u.getOperand().accept(this);
		u.setOperand(this.substituteExpressionStack.pop());
		this.substituteExpressionStack.push(u);
	}

	public void visit(VariableReference v) {
		if(!this.variableMap.containsKey(v.getVariable())) {
			VariableDeclaration newVariable = AstNodeCloneHelper.clone(v.getVariable());
			newVariable.setName(v.getVariable().getName() + "-fresh-" + UUID.randomUUID().toString());
			this.variableMap.put(v.getVariable(), newVariable);
		}
		v.setVariable(this.variableMap.get(v.getVariable()));

		this.substituteExpressionStack.push(v);
	}
}
