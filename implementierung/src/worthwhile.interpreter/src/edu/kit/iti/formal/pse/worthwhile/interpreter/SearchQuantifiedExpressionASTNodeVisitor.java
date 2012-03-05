/**
 *
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * The AST-visitor searching for a quantified expression in an expression
 * 
 * @author Chris
 * 
 */
class SearchQuantifiedExpressionASTNodeVisitor extends HierarchialASTNodeVisitor {

	/**
	 * indicates whether a quantified expression was found
	 */
	private boolean foundQuantifiedExpression = false;

	/**
	 * Returns the indicator whether a quantified expression was found.
	 * 
	 * @return the indicator whether a quantified expression was found
	 */
	public boolean getFoundQuantifiedExpression() {
		return this.foundQuantifiedExpression;
	}

	/**
	 * sets the indicator indicating whether a quantified expression was found.
	 * 
	 * @param quantifiedExpression
	 *                the visited quantifiedExpression
	 */
	public void visit(QuantifiedExpression quantifiedExpression) {
		this.foundQuantifiedExpression = true;
	}

	/**
	 * visits the subexpressions of a binary expression.
	 * 
	 * @param binaryExpression
	 *                the visited binary expression
	 */
	public void visit(BinaryExpression binaryExpression) {
		binaryExpression.getLeft().accept(this);
		binaryExpression.getRight().accept(this);
	}

	/**
	 * visits the subexpression of a unary expression.
	 * 
	 * @param unaryExpression
	 *                the visited unary expression
	 */
	public void visit(UnaryExpression unaryExpression) {
		unaryExpression.getOperand().accept(this);
	}

	/**
	 * visits everything else and does nothing.
	 * 
	 * @param astNode
	 *                the visited ASTNode
	 */
	public void visit(ASTNode astNode) {

	}
}