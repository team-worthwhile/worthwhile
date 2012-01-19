package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Greater;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * @author Leon Handreke, fabian
 */
class SMTLIBStrategy extends HierarchialASTNodeVisitor implements FormulaCompiler {

	private final Stack<String> formulaCompileStack = new Stack<String>();

	/**
	 * @see FormulaCompiler#compileFormula(Expression formula)
	 */
	@Override
	public String compileFormula(final Expression formula) {
		// this should push a String object to the compilation stack
		formula.accept(this);
		String formulaString = this.formulaCompileStack.pop();

		// declare unbound variables ahead of all assertions
		UnboundVariableFinderVisitor unboundVariableFinder = new UnboundVariableFinderVisitor();
		formula.accept(unboundVariableFinder);
		String declarationsString = "";
		for (VariableDeclaration declaration : unboundVariableFinder.getUnboundVariables()) {
			declaration.getType().accept(this);
			declarationsString += "(declare-const " + declaration.getName() + " "
			                + this.formulaCompileStack.pop() + ")\n";
		}

		// wrap the formulaString in a command for the prover that tells the prover
		// what we want to know about the formula
		// TODO: Make this more intelligent, maybe wrap the Expression in an
		// Assert and then visit it just like all the other nodes...?
		return declarationsString + "(assert " + formulaString + ")\n(check-sat)";
	}

	private void pushBinaryOperation(final BinaryExpression binaryExpression, final String compiledOperationSymbol) {
		binaryExpression.getLeft().accept(this);
		binaryExpression.getRight().accept(this);
		String right = this.formulaCompileStack.pop();
		String left = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("(" + compiledOperationSymbol + " " + left + " " + right + ")");
	}

	private void pushUnaryOperation(final UnaryExpression unaryExpression, final String compiledOperationSymbol) {
		unaryExpression.getOperand().accept(this);
		String operand = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("(" + compiledOperationSymbol + " " + operand + ")");
	}

	/**
	 * Pushes <code>(type identifier)</code> on top of {@link formulaCompileStack}.
	 * 
	 * @param variableDeclaration
	 *                the {@link VariableDeclaration} that defines <code>type</code> and <code>identifier</code> in
	 *                <code>(type identifier)</code>
	 */
	private void pushParameter(final VariableDeclaration variableDeclaration) {
		variableDeclaration.getType().accept(this);
		this.formulaCompileStack.push("(" + variableDeclaration.getName() + " "
		                + this.formulaCompileStack.pop() + ")");
	}

	/**
	 * Pushes <code>(quantifier (param) (expr))</code> on top of {@link formulaCompileStack}.
	 * 
	 * @param quantifiedExpression
	 *                the {@link QuantifiedExpression} that defines <code>param</code> and <code>expr</code> in
	 *                <code>(quantifier (param) (expr))</code>
	 * @param quantifierString
	 *                the {@link String} that defines <code>quantifier</code> in
	 *                <code>(quantifier (param) (expr))</code>
	 */
	private void pushQuantifier(final QuantifiedExpression quantifiedExpression, final String quantifierString) {
		quantifiedExpression.getExpression().accept(this);

		String expression;
		Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			quantifiedExpression.getCondition().accept(this);
			// condition is a constraint on the type domain elements and compiled into an implication
			expression = "(=> " + this.formulaCompileStack.pop() + " " + this.formulaCompileStack.pop()
			                + ")";
		} else {
			expression = this.formulaCompileStack.pop();
		}

		this.pushParameter(quantifiedExpression.getParameter());
		this.formulaCompileStack.push("(" + quantifierString + " (" + this.formulaCompileStack.pop() + ") "
		                + expression + ")");
	}

	@Override
	public void visit(final Addition addition) {
		this.pushBinaryOperation(addition, "+");
	}

	@Override
	public void visit(final ArrayLength arrayLength) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(final ArrayLiteral arrayLiteral) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(final ArrayType arrayType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(final Assertion assertion) {
		assertion.getExpression().accept(this);
		String expr = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("assert(" + expr + ")");
	}

	@Override
	public void visit(final Assumption assumption) {
		assumption.getExpression().accept(this);
		String expr = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("assume(" + expr + ")");
	}

	@Override
	public void visit(final BooleanLiteral booleanLiteral) {
		if (booleanLiteral.isValue()) {
			this.formulaCompileStack.push("true");
		} else {
			this.formulaCompileStack.push("false");
		}
	}

	@Override
	public void visit(final BooleanType booleanType) {
		this.formulaCompileStack.push("Bool");
	}

	/**
	 * @see ASTNodeVisitor#visit(Conjunction conjunction)
	 */
	@Override
	public void visit(final Conjunction conjunction) {
		this.pushBinaryOperation(conjunction, "and");
	}

	/**
	 * @see ASTNodeVisitor#visit(Disjunction disjunction)
	 */
	@Override
	public void visit(final Disjunction disjunction) {
		this.pushBinaryOperation(disjunction, "or");
	}

	/**
	 * @see ASTNodeVisitor#visit(Division division)
	 */
	@Override
	public void visit(final Division division) {
		this.pushBinaryOperation(division, "/");
	}

	/**
	 * @see ASTNodeVisitor#visit(Equal equal)
	 */
	@Override
	public void visit(final Equal equal) {
		this.pushBinaryOperation(equal, "=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Equivalence equivalence)
	 */
	@Override
	public void visit(final Equivalence equivalence) {
		this.pushBinaryOperation(equivalence, "iff");
	}

	/**
	 * @see ASTNodeVisitor#visit(ExistsQuantifier existsQuantifier)
	 */
	@Override
	public void visit(final ExistsQuantifier existsQuantifier) {
		this.pushQuantifier(existsQuantifier, "exists");
	}

	/**
	 * @see ASTNodeVisitor#visit(ForAllQuantifier forAllQuantifier)
	 */
	@Override
	public void visit(final ForAllQuantifier forAllQuantifier) {
		this.pushQuantifier(forAllQuantifier, "forall");
	}

	/**
	 * @see ASTNodeVisitor#visit(FunctionCall functionCall)
	 */
	@Override
	public void visit(final FunctionCall functionCall) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Greater greater)
	 */
	@Override
	public void visit(final Greater greater) {
		this.pushBinaryOperation(greater, ">");
	}

	/**
	 * @see ASTNodeVisitor#visit(GreaterOrEqual greaterOrEqual)
	 */
	@Override
	public void visit(final GreaterOrEqual greaterOrEqual) {
		this.pushBinaryOperation(greaterOrEqual, ">=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Implication implication)
	 */
	@Override
	public void visit(final Implication implication) {
		this.pushBinaryOperation(implication, "=>");
	}

	/**
	 * @see ASTNodeVisitor#visit(IntegerLiteral integerLiteral)
	 */
	@Override
	public void visit(final IntegerLiteral integerLiteral) {
		this.formulaCompileStack.push(integerLiteral.getValue().toString());
	}

	/**
	 * @see ASTNodeVisitor#visit(IntegerType integerType)
	 */
	@Override
	public void visit(final IntegerType integerType) {
		this.formulaCompileStack.push("Int");
	}

	/**
	 * @see ASTNodeVisitor#visit(Less less)
	 */
	@Override
	public void visit(final Less less) {
		this.pushBinaryOperation(less, "<");
	}

	/**
	 * @see ASTNodeVisitor#visit(LessOrEqual lessOrEqual)
	 */
	@Override
	public void visit(final LessOrEqual lessOrEqual) {
		this.pushBinaryOperation(lessOrEqual, "<=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Minus minus)
	 */
	@Override
	public void visit(final Minus minus) {
		this.pushUnaryOperation(minus, "-");
	}

	@Override
	public void visit(final Modulus modulus) {
		this.pushBinaryOperation(modulus, "mod");
	}

	/**
	 * @see ASTNodeVisitor#visit(Multiplication multiplication)
	 */
	@Override
	public void visit(final Multiplication multiplication) {
		this.pushBinaryOperation(multiplication, "*");
	}

	/**
	 * @see ASTNodeVisitor#visit(Negation negation)
	 */
	@Override
	public void visit(final Negation negation) {
		this.pushUnaryOperation(negation, "not");
	}

	/**
	 * @see ASTNodeVisitor#visit(VariableReference variableReference)
	 */
	@Override
	public void visit(final VariableReference variableReference) {
		this.formulaCompileStack.push(variableReference.getVariable().getName());
	}

	/**
	 * @see ASTNodeVisitor#visit(Plus plus)
	 */
	@Override
	public void visit(final Plus plus) {
		this.pushUnaryOperation(plus, "+");
	}

	/**
	 * @see ASTNodeVisitor#visit(QuantifiedExpression quantifiedExpression)
	 */
	@Override
	public void visit(final QuantifiedExpression quantifiedExpression) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Subtraction subtraction)
	 */
	@Override
	public void visit(final Subtraction subtraction) {
		this.pushBinaryOperation(subtraction, "-");
	}

	/**
	 * @see ASTNodeVisitor#visit(Unequal unequal)
	 */
	@Override
	public void visit(final Unequal unequal) {
		this.pushBinaryOperation(unequal, "=");

		// there is no function `!=' in SMTLIB
		this.formulaCompileStack.push("(not (" + this.formulaCompileStack.pop() + ")");
	}
}
