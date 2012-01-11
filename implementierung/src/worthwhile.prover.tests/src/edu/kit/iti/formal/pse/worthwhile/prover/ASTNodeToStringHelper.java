package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Implements toString methods for {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
final class ASTNodeToStringHelper extends HierarchialASTNodeVisitor {
	/**
	 * A single instance of {@link ASTNodeToStringHelper}.
	 */
	private static ASTNodeToStringHelper singleton = new ASTNodeToStringHelper();

	/**
	 * The state of the {@link String} result returned by {@link toString}.
	 */
	private StringBuffer buf;

	/**
	 * Private default constructor.
	 */
	private ASTNodeToStringHelper() {
		super();
	}

	/**
	 * Returns a {@link String} representing an {@link ASTNode}.
	 * 
	 * @param node
	 *                the ASTNode that is represented by the returned String
	 * @return a String representing <code>node</code>
	 */
	public static String toString(final ASTNode node) {
		singleton.buf = new StringBuffer();
		node.accept(singleton);
		return singleton.buf.toString();
	}

	private void appendBinaryExpression(BinaryExpression binaryExpression, String operatorString) {
		buf.append("(");
		binaryExpression.getLeft().accept(this);
		buf.append(" " + operatorString + " ");
		binaryExpression.getRight().accept(this);
		buf.append(")");
	}

	@Override
	public void visit(final ASTNode aSTNode) {
		buf.append(aSTNode.toString());
	}

	@Override
	public void visit(final Addition addition) {
		this.appendBinaryExpression(addition, "+");
	}

	@Override
	public void visit(final Assertion assertion) {
		buf.append("_assert ");
		assertion.getExpression().accept(this);
	}

	@Override
	public void visit(final Assignment assignment) {
		assignment.getVariable().accept(this);
		buf.append(" := ");
		assignment.getValue().accept(this);
	}

	@Override
	public void visit(final Block block) {
		buf.append("{\n");
		for (Statement stmt : block.getStatements()) {
			stmt.accept(this);
			buf.append("\n");
		}
		buf.append("}");
	}

	@Override
	public void visit(final BooleanLiteral booleanLiteral) {
		buf.append(booleanLiteral.getValue());
	}

	@Override
	public void visit(final Conjunction conjunction) {
		this.appendBinaryExpression(conjunction, "&&");
	}

	@Override
	public void visit(final Equal equal) {
		this.appendBinaryExpression(equal, "=");
	}

	@Override
	public void visit(final IntegerLiteral integerLiteral) {
		buf.append(integerLiteral.getValue());
	}

	@Override
	public void visit(final IntegerType integerType) {
		buf.append("Integer");
	}

	@Override
	public void visit(final Less less) {
		this.appendBinaryExpression(less, "<");
	}

	@Override
	public void visit(final LessOrEqual lessOrEqual) {
		this.appendBinaryExpression(lessOrEqual, "<=");
	}

	@Override
	public void visit(final Program program) {
		program.getMainBlock().accept(this);
	}

	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		variableDeclaration.getType().accept(this);
		buf.append(" ");
		buf.append(variableDeclaration.getName());
		buf.append(" := ");
		variableDeclaration.getInitialValue().accept(this);
	}

	@Override
	public void visit(final VariableReference variableReference) {
		buf.append(variableReference.getVariable().getName());
	}

	@Override
	public void visit(final Implication implication) {
		this.appendBinaryExpression(implication, "=>");
	}

	@Override
	public void visit(final Negation negation) {
		buf.append("!");
		negation.getOperand().accept(this);
	}
}