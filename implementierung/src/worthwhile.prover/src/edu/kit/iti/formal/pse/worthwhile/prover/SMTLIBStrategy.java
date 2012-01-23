package edu.kit.iti.formal.pse.worthwhile.prover;

import java.math.BigInteger;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.typesystem.WorthwhileTypesystem;

/**
 * @author Leon Handreke, fabian
 */
class SMTLIBStrategy extends HierarchialASTNodeVisitor implements FormulaCompiler {

	/**
	 * Stack to pass compiled formula elements up to caller.
	 */
	private final Stack<String> formulaCompileStack = new Stack<String>();

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
		return "(declare-const integer_array (Array Int Int))\n(declare-const boolean_array (Array Int Bool))\n"
		                + declarationsString + "(assert " + formulaString + ")\n(check-sat)";
	}

	/**
	 * Push a compiled {@link BinaryExpression} to the stack.
	 * 
	 * @param binaryExpression
	 *                the {@link BinaryExpression} to compile
	 * @param compiledOperationSymbol
	 *                the symbol to use in the SMTLIB compiled expression
	 */
	private void pushBinaryOperation(final BinaryExpression binaryExpression, final String compiledOperationSymbol) {
		binaryExpression.getLeft().accept(this);
		binaryExpression.getRight().accept(this);
		String right = this.formulaCompileStack.pop();
		String left = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("(" + compiledOperationSymbol + " " + left + " " + right + ")");
	}

	/**
	 * Push a compiled {@link UnaryExpression} to the stack.
	 * 
	 * @param unaryExpression
	 *                the {@link UnaryExpression} to compile
	 * @param compiledOperationSymbol
	 *                the symbol to use in the SMTLIB compiled expression
	 */
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
		String literalString = "";
		Type arrayType = (Type) (new WorthwhileTypesystem()).type(arrayLiteral.getValues().get(0));
		if (arrayType instanceof IntegerType) {
			literalString = "integer_array";
		} else if (arrayType instanceof BooleanType) {
			literalString = "boolean_array";
		}
		for (int i = 0; i < arrayLiteral.getValues().size(); i++) {
			arrayLiteral.getValues().get(i).accept(this);
			String valueAtIndex = this.formulaCompileStack.pop();
			literalString = "(store " + literalString + " " + Integer.toString(i) + " " + valueAtIndex + ")";
		}
		this.formulaCompileStack.push(literalString);
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

	@Override
	public void visit(final Conjunction conjunction) {
		this.pushBinaryOperation(conjunction, "and");
	}

	@Override
	public void visit(final Disjunction disjunction) {
		this.pushBinaryOperation(disjunction, "or");
	}

	@Override
	public void visit(final Division division) {
		this.pushBinaryOperation(division, "/");
	}

	@Override
	public void visit(final Equal equal) {
		this.pushBinaryOperation(equal, "=");
	}

	@Override
	public void visit(final Equivalence equivalence) {
		this.pushBinaryOperation(equivalence, "iff");
	}

	@Override
	public void visit(final ExistsQuantifier existsQuantifier) {
		this.pushQuantifier(existsQuantifier, "exists");
	}

	@Override
	public void visit(final ForAllQuantifier forAllQuantifier) {
		this.pushQuantifier(forAllQuantifier, "forall");
	}

	@Override
	public void visit(final FunctionCall functionCall) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(final Greater greater) {
		this.pushBinaryOperation(greater, ">");
	}

	@Override
	public void visit(final GreaterOrEqual greaterOrEqual) {
		this.pushBinaryOperation(greaterOrEqual, ">=");
	}

	@Override
	public void visit(final Implication implication) {
		this.pushBinaryOperation(implication, "=>");
	}

	@Override
	public void visit(final IntegerLiteral integerLiteral) {
		String literalString = integerLiteral.getValue().abs().toString();
		if (integerLiteral.getValue().compareTo(new BigInteger("0")) < 0) {
			literalString = "(- " + literalString + ")";
		}
		this.formulaCompileStack.push(literalString);
	}

	@Override
	public void visit(final IntegerType integerType) {
		this.formulaCompileStack.push("Int");
	}

	@Override
	public void visit(final Less less) {
		this.pushBinaryOperation(less, "<");
	}

	@Override
	public void visit(final LessOrEqual lessOrEqual) {
		this.pushBinaryOperation(lessOrEqual, "<=");
	}

	@Override
	public void visit(final Minus minus) {
		this.pushUnaryOperation(minus, "-");
	}

	@Override
	public void visit(final Modulus modulus) {
		this.pushBinaryOperation(modulus, "mod");
	}

	@Override
	public void visit(final Multiplication multiplication) {
		this.pushBinaryOperation(multiplication, "*");
	}

	@Override
	public void visit(final Negation negation) {
		this.pushUnaryOperation(negation, "not");
	}

	@Override
	public void visit(final VariableReference variableReference) {
		this.formulaCompileStack.push(variableReference.getVariable().getName());
	}

	@Override
	public void visit(final Plus plus) {
		this.pushUnaryOperation(plus, "+");
	}

	@Override
	public void visit(final Subtraction subtraction) {
		this.pushBinaryOperation(subtraction, "-");
	}

	@Override
	public void visit(final Unequal unequal) {
		this.pushBinaryOperation(unequal, "=");

		// there is no function `!=' in SMTLIB
		this.formulaCompileStack.push("(not " + this.formulaCompileStack.pop() + ")");
	}
}
