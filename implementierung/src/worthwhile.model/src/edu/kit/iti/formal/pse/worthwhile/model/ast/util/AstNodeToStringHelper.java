package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import java.util.Iterator;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Greater;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Implements toString methods for {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
public final class AstNodeToStringHelper extends HierarchialASTNodeVisitor {
	/**
	 * A single instance of {@link ASTNodeToStringHelper}.
	 */
	private static AstNodeToStringHelper singleton = new AstNodeToStringHelper();

	/**
	 * The state of the {@link String} result returned by {@link toString}.
	 */
	private StringBuffer buf;

	/**
	 * Private default constructor.
	 */
	private AstNodeToStringHelper() {
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
		AstNodeToStringHelper.singleton.buf = new StringBuffer();
		node.accept(AstNodeToStringHelper.singleton);
		return AstNodeToStringHelper.singleton.buf.toString();
	}

	private void appendBinaryExpression(final BinaryExpression binaryExpression, final String operatorString) {
		this.buf.append("(");
		binaryExpression.getLeft().accept(this);
		this.buf.append(" " + operatorString + " ");
		binaryExpression.getRight().accept(this);
		this.buf.append(")");
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
	public void visit(final Conjunction conjunction) {
		this.appendBinaryExpression(conjunction, "&&");
	}

	@Override
	public void visit(final Equal equal) {
		this.appendBinaryExpression(equal, "=");
	}

	@Override
	public void visit(FunctionCall functionCall) {
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
		this.appendBinaryExpression(lessOrEqual, "<=");
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

		program.getMainBlock().accept(this);
	}

	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		variableDeclaration.getType().accept(this);
		this.buf.append(" ");
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
	}

	@Override
	public void visit(final Implication implication) {
		this.appendBinaryExpression(implication, "=>");
	}

	@Override
	public void visit(final Negation negation) {
		this.buf.append("!");
		negation.getOperand().accept(this);
	}

	@Override
	public void visit(final Multiplication multiplication) {
		this.appendBinaryExpression(multiplication, "*");
	}

	@Override
	public void visit(final Axiom axiom) {
		this.buf.append("_axiom ");
		axiom.getExpression().accept(this);
	}

	@Override
	public void visit(final ForAllQuantifier forAllQuantifier) {
		this.buf.append("forall ");
		forAllQuantifier.getParameter().accept(this);

		Expression condition = forAllQuantifier.getCondition();
		if (condition != null) {
			this.buf.append(", ");
			condition.accept(this);
		}

		this.buf.append(" : ");
		forAllQuantifier.getExpression().accept(this);
	}

	@Override
	public void visit(FunctionDeclaration functionDeclaration) {
		this.buf.append("function ");
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
	public void visit(ReturnStatement returnStatement) {
		this.buf.append("return ");
		returnStatement.getReturnValue().accept(this);
	}

	@Override
	public void visit(ReturnValueReference node) {
		this.buf.append("_return");
	}

	@Override
	public void visit(Unequal unequal) {
		this.appendBinaryExpression(unequal, "!=");
	}

	@Override
	public void visit(GreaterOrEqual greaterOrEqual) {
		this.appendBinaryExpression(greaterOrEqual, ">=");
	}

	@Override
	public void visit(Greater greater) {
		this.appendBinaryExpression(greater, ">");
	}

	@Override
	public void visit(Disjunction disjunction) {
		this.appendBinaryExpression(disjunction, "||");
	}
}