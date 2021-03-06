package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import java.util.Iterator;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Greater;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LetExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.AssociativityVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.OperatorHierarchyVisitor;

/**
 * Implements toString methods for {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
public class AstNodeToStringHelper extends HierarchialASTNodeVisitor {
	/**
	 * A single instance of {@link ASTNodeToStringHelper}.
	 */
	private static AstNodeToStringHelper singleton = new AstNodeToStringHelper();

	/**
	 * The state of the {@link String} result returned by {@link toString}.
	 */
	private StringBuffer buf;

	/**
	 * Returns the internal buffer.
	 * 
	 * @return the internal buffer.
	 */
	protected final StringBuffer getBuffer() {
		return buf;
	}

	/**
	 * Sets the internal buffer.
	 * 
	 * @param buf
	 *                The internal buffer to set.
	 */
	protected final void setBuffer(final StringBuffer buf) {
		this.buf = buf;
	}

	/**
	 * Appends the specified string to the output buffer.
	 * 
	 * @param str
	 *                The string to append to the output buffer.
	 */
	protected final void append(final String str) {
		this.buf.append(str);
	}

	/**
	 * Protected default constructor.
	 */
	protected AstNodeToStringHelper() {
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
		if (node != null) {
			AstNodeToStringHelper.singleton.buf = new StringBuffer();
			node.accept(AstNodeToStringHelper.singleton);
			return AstNodeToStringHelper.singleton.buf.toString();
		} else {
			return "";
		}
	}

	/**
	 * Adds parentheses around an expression, if necessary.
	 * 
	 * @param parentNode
	 *                The parent node of the current node
	 * @param childNode
	 *                The current node
	 */
	private void parenthesize(final ASTNode parentNode, final ASTNode childNode) {
		if (parentNode == null || childNode == null) {
			return;
		}

		OperatorHierarchyVisitor hierarchyVisitor = new OperatorHierarchyVisitor();
		int currentPositionInHierarchy = hierarchyVisitor.apply(parentNode);
		int childPositionInHierarchy = hierarchyVisitor.apply(childNode);
		boolean needsParentheses = false;

		if (childPositionInHierarchy < currentPositionInHierarchy) {
			needsParentheses = true;
		} else if (childPositionInHierarchy == currentPositionInHierarchy) {
			// @formatter:off
			needsParentheses = (parentNode instanceof BinaryExpression
			                && childNode == ((BinaryExpression) parentNode).getRight()
			                && !new AssociativityVisitor().apply(parentNode))
				|| (parentNode instanceof QuantifiedExpression
					&& childNode == ((QuantifiedExpression) parentNode).getCondition())
				|| (parentNode instanceof TernaryExpression); 
			// @formatter:on
		}

		if (needsParentheses) {
			this.buf.append("(");
		}

		childNode.accept(this);

		if (needsParentheses) {
			this.buf.append(")");
		}
	}

	/**
	 * Appends <code>`(' binaryExpression.left operatorString binaryExpression.right `)'</code> to the buffer.
	 * 
	 * @param binaryExpression
	 *                the {@link BinaryExpression} that is to be represented as {@link String}
	 * @param operatorString
	 *                the <code>String</code> representation for the <code>binaryExpression</code>'s operator
	 */
	private void appendBinaryExpression(final BinaryExpression binaryExpression, final String operatorString) {
		this.parenthesize(binaryExpression, binaryExpression.getLeft());
		this.buf.append(" " + operatorString + " ");
		this.parenthesize(binaryExpression, binaryExpression.getRight());
	}

	@Override
	public void visit(final ASTNode aSTNode) {
		this.buf.append(aSTNode.toString());
	}

	@Override
	public void visit(final Addition addition) {
		this.appendBinaryExpression(addition, "+");
	}

	@Override
	public void visit(final Subtraction subtraction) {
		this.appendBinaryExpression(subtraction, "-");
	}

	@Override
	public void visit(final ArrayFunction arrayFunction) {
		this.buf.append("{ ");

		if (arrayFunction.getIndex() != null) {
			arrayFunction.getIndex().accept(this);
		} else {
			this.buf.append("any");
		}

		this.buf.append(" => ");

		arrayFunction.getValue().accept(this);

		if (arrayFunction.getChainedFunction() != null) {
			this.buf.append(", ");
			arrayFunction.getChainedFunction().accept(this);
		}

		this.buf.append(" }");
	}

	@Override
	public void visit(final ArrayAccess arrayAccess) {
		if (arrayAccess.getArray() != null) {
			arrayAccess.getArray().accept(this);
		}

		if (arrayAccess.getIndex() != null) {
			this.buf.append("[");
			arrayAccess.getIndex().accept(this);
			this.buf.append("]");
		}
	}

	@Override
	public void visit(final ArrayLiteral arrayLiteral) {
		this.buf.append("{ ");
		final Iterator<Expression> i = arrayLiteral.getValues().iterator();
		if (i.hasNext()) {
			i.next().accept(this);
			while (i.hasNext()) {
				this.buf.append(", ");
				i.next().accept(this);
			}
		}
		this.buf.append(" }");
	}

	@Override
	public void visit(final ArrayType arrayType) {
		arrayType.getBaseType().accept(this);
		this.buf.append("[]");
	}

	@Override
	public void visit(final Assertion assertion) {
		this.buf.append("_assert ");
		assertion.getExpression().accept(this);
	}

	@Override
	public void visit(final Assignment assignment) {
		assignment.getVariable().accept(this);
		this.buf.append(" := ");
		assignment.getValue().accept(this);
	}

	@Override
	public void visit(final Assumption assumption) {
		this.buf.append("_assume ");
		assumption.getExpression().accept(this);
	}

	@Override
	public void visit(final Block block) {
		this.buf.append("{\n");
		for (Statement stmt : block.getStatements()) {
			stmt.accept(this);
			this.buf.append("\n");
		}
		this.buf.append("}\n");
	}

	@Override
	public void visit(final BooleanLiteral booleanLiteral) {
		this.buf.append(booleanLiteral.getValue());
	}

	@Override
	public void visit(final BooleanType booleanType) {
		this.buf.append("Boolean");
	}

	@Override
	public void visit(final Conjunction conjunction) {
		this.appendBinaryExpression(conjunction, "∧");
	}

	@Override
	public void visit(final Equal equal) {
		this.appendBinaryExpression(equal, "=");
	}

	@Override
	public void visit(final FunctionCall functionCall) {
		this.buf.append(functionCall.getFunction().getName());
		this.buf.append("(");
		final List<Expression> actuals = functionCall.getActuals();
		if (!actuals.isEmpty()) {
			final Iterator<Expression> i = actuals.iterator();
			i.next().accept(this);
			while (i.hasNext()) {
				this.buf.append(", ");
				i.next().accept(this);
			}
		}
		this.buf.append(")");
	}

	@Override
	public void visit(final IntegerLiteral integerLiteral) {
		this.buf.append(integerLiteral.getValue());
	}

	@Override
	public void visit(final IntegerType integerType) {
		this.buf.append("Integer");
	}

	@Override
	public void visit(final Less less) {
		this.appendBinaryExpression(less, "<");
	}

	@Override
	public void visit(final LessOrEqual lessOrEqual) {
		this.appendBinaryExpression(lessOrEqual, "≤");
	}

	@Override
	public void visit(final Loop loop) {
		this.buf.append("while ");
		loop.getCondition().accept(this);
		for (final Invariant i : loop.getInvariants()) {
			this.buf.append("\n_invariant ");
			i.getExpression().accept(this);
		}
		this.buf.append(" ");
		loop.getBody().accept(this);
	}

	@Override
	public void visit(final Conditional conditional) {
		this.buf.append("if ");
		conditional.getCondition().accept(this);
		conditional.getTrueBlock().accept(this);

		if (conditional.getFalseBlock() != null) {
			this.buf.append("else ");
			conditional.getFalseBlock().accept(this);
		}
	}

	@Override
	public void visit(final Minus minus) {
		this.buf.append("-");
		this.parenthesize(minus, minus.getOperand());
	}

	@Override
	public void visit(final Plus plus) {
		this.buf.append("+");
		this.parenthesize(plus, plus.getOperand());
	}

	@Override
	public void visit(final Program program) {
		for (final Axiom a : program.getAxioms()) {
			a.accept(this);
			this.buf.append("\n");
		}

		for (final FunctionDeclaration f : program.getFunctionDeclarations()) {
			f.accept(this);
		}

		if (program.getMainBlock() != null) {
			program.getMainBlock().accept(this);
		}
	}

	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		if (variableDeclaration.getType() != null) {
			variableDeclaration.getType().accept(this);
			this.buf.append(" ");
		}
		this.buf.append(variableDeclaration.getName());

		Expression initialValue = variableDeclaration.getInitialValue();
		if (initialValue != null) {
			this.buf.append(" := ");
			initialValue.accept(this);
		}
	}

	@Override
	public void visit(final VariableReference variableReference) {
		this.buf.append(variableReference.getVariable().getName());

		if (variableReference.getIndex() != null) {
			this.buf.append("[");
			variableReference.getIndex().accept(this);
			this.buf.append("]");
		}
	}

	@Override
	public void visit(final Implication implication) {
		this.appendBinaryExpression(implication, "⇒");
	}

	@Override
	public void visit(final Equivalence equivalence) {
		this.appendBinaryExpression(equivalence, "⇔");
	}

	@Override
	public void visit(final Negation negation) {
		this.buf.append("¬");
		this.parenthesize(negation, negation.getOperand());
	}

	@Override
	public void visit(final Multiplication multiplication) {
		this.appendBinaryExpression(multiplication, "∙");
	}

	@Override
	public void visit(final Division division) {
		this.appendBinaryExpression(division, "/");
	}

	@Override
	public void visit(final Modulus modulus) {
		this.appendBinaryExpression(modulus, "%");
	}

	@Override
	public void visit(final Axiom axiom) {
		this.buf.append("_axiom ");
		axiom.getExpression().accept(this);
	}

	/**
	 * Visits a quantified expression.
	 * 
	 * @param quantifiedExpression
	 *                The quantified expression to visit
	 * @param quantifier
	 *                A string representation of the quantifier.
	 */
	private void visitQuantifiedExpression(final QuantifiedExpression quantifiedExpression, final String quantifier) {
		this.buf.append(quantifier + " ");
		quantifiedExpression.getParameter().accept(this);

		Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			this.buf.append(", ");
			this.parenthesize(quantifiedExpression, condition);
		}

		if (quantifiedExpression.getExpression() instanceof QuantifiedExpression) {
			this.buf.append(" ");
		} else {
			this.buf.append(" : ");
		}
		quantifiedExpression.getExpression().accept(this);
	}

	@Override
	public void visit(final ForAllQuantifier forAllQuantifier) {
		this.visitQuantifiedExpression(forAllQuantifier, "∀");
	}

	@Override
	public void visit(final ExistsQuantifier existsQuantifier) {
		this.visitQuantifiedExpression(existsQuantifier, "∃");
	}

	@Override
	public void visit(final FunctionDeclaration functionDeclaration) {
		this.buf.append("function ");
		functionDeclaration.getReturnType().accept(this);
		this.buf.append(" ");
		this.buf.append(functionDeclaration.getName());
		this.buf.append("(");

		List<VariableDeclaration> params = functionDeclaration.getParameters();
		if (!params.isEmpty()) {
			Iterator<VariableDeclaration> i = functionDeclaration.getParameters().iterator();
			// params is not empty, i has next
			i.next().accept(this);
			while (i.hasNext()) {
				this.buf.append(", ");
				i.next().accept(this);
			}
		}

		this.buf.append(") ");

		for (final Precondition p : functionDeclaration.getPreconditions()) {
			this.buf.append("\n");
			p.accept(this);
		}

		for (final Postcondition p : functionDeclaration.getPostconditions()) {
			this.buf.append("\n");
			p.accept(this);
		}

		functionDeclaration.getBody().accept(this);
	}

	@Override
	public void visit(final Postcondition postcondition) {
		this.buf.append("_ensures ");
		postcondition.getExpression().accept(this);
	}

	@Override
	public void visit(final Precondition precondition) {
		this.buf.append("_requires ");
		precondition.getExpression().accept(this);
	}

	@Override
	public void visit(final ReturnStatement returnStatement) {
		this.buf.append("return ");
		returnStatement.getReturnValue().accept(this);
	}

	@Override
	public void visit(final ReturnValueReference node) {
		this.buf.append("_return");

		if (node.getIndex() != null) {
			this.buf.append("[");
			node.getIndex().accept(this);
			this.buf.append("]");
		}
	}

	@Override
	public void visit(final Unequal unequal) {
		this.appendBinaryExpression(unequal, "≠");
	}

	@Override
	public void visit(final GreaterOrEqual greaterOrEqual) {
		this.appendBinaryExpression(greaterOrEqual, "≥");
	}

	@Override
	public void visit(final Greater greater) {
		this.appendBinaryExpression(greater, ">");
	}

	@Override
	public void visit(final Disjunction disjunction) {
		this.appendBinaryExpression(disjunction, "∨");
	}

	@Override
	public void visit(final LetExpression letExpression) {
		letExpression.getExpression().accept(this);

		if (letExpression.getParameters() != null) {
			this.buf.append(", where ");

			for (int i = 0; i < letExpression.getParameters().size(); i++) {
				letExpression.getParameters().get(i).accept(this);

				if (i < letExpression.getParameters().size() - 1) {
					this.buf.append(", ");
				}
			}
		}
	}

	@Override
	public void visit(final TernaryExpression ternaryExpression) {
		ternaryExpression.getCondition().accept(this);
		this.buf.append(" ? ");
		this.parenthesize(ternaryExpression, ternaryExpression.getWhenTrue());
		this.buf.append(" : ");
		this.parenthesize(ternaryExpression, ternaryExpression.getWhenFalse());
	}
}