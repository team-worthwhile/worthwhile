package edu.kit.iti.formal.pse.worthwhile.prover.caller;

import java.math.BigInteger;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.UnboundVariableFinderVisitor;
import edu.kit.iti.formal.pse.worthwhile.typesystem.WorthwhileTypesystem;

/**
 * @author Leon Handreke, fabian
 */
public class SMTLIBStrategy extends HierarchialASTNodeVisitor implements FormulaCompiler {

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
		return declarationsString + "(assert " + formulaString + ")\n(check-sat)\n(get-model)\n";
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
	 * @param constraintFunction
	 *                the {@link String} that defines <code>function</code> in
	 *                <code>(quantifier (param) (function condition expr))</code>
	 */
	private void pushQuantifier(final QuantifiedExpression quantifiedExpression, final String quantifierString,
	                final String constraintFunction) {
		quantifiedExpression.getExpression().accept(this);

		String expression;
		Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			quantifiedExpression.getCondition().accept(this);
			// condition is a constraint on the type domain elements and compiled into an implication or
			// conjunction
			expression = "(" + constraintFunction + " " + this.formulaCompileStack.pop() + " "
			                + this.formulaCompileStack.pop() + ")";
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
	public void visit(final ArrayFunction arrayFunction) {
		String arrayString;

		if (arrayFunction.getIndex() == null) {
			final Expression value = arrayFunction.getValue();

			arrayString = new ASTNodeReturnVisitor<String>() {
				// array literal (ArrayFunction) or array reference
				@Override
				public void visit(final ArrayType arrayType) {
					value.accept(SMTLIBStrategy.this);
					this.setReturnValue(SMTLIBStrategy.this.formulaCompileStack.pop());
				}

				// constant
				@Override
				public void visit(final PrimitiveType primitiveType) {
					primitiveType.accept(SMTLIBStrategy.this);
					final String typeString = SMTLIBStrategy.this.formulaCompileStack.pop();

					value.accept(SMTLIBStrategy.this);
					final String valueString = SMTLIBStrategy.this.formulaCompileStack.pop();

					this.setReturnValue("((as const (Array Int " + typeString + ")) " + valueString
					                + ")");
				}
			}.apply((new WorthwhileTypesystem()).typeof(value));
		} else {
			arrayFunction.getChainedFunction().accept(this);
			final String chainedArrayString = this.formulaCompileStack.pop();

			arrayFunction.getIndex().accept(this);
			final String keyString = this.formulaCompileStack.pop();

			arrayFunction.getValue().accept(this);
			final String valueString = this.formulaCompileStack.pop();

			arrayString = "(store " + chainedArrayString + " " + keyString + " " + valueString + ")";
		}

		this.formulaCompileStack.push(arrayString);
	}

	@Override
	public void visit(final ArrayAccess arrayAccess) {
		arrayAccess.getIndex().accept(this);
		final String indexString = this.formulaCompileStack.pop();
		arrayAccess.getArray().accept(this);
		final String functionString = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("(select " + functionString + " " + indexString + ")");
	}

	@Override
	public void visit(final ArrayType arrayType) {
		arrayType.getBaseType().accept(this);
		this.formulaCompileStack.push("(Array Int " + this.formulaCompileStack.pop() + ")");
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
		this.pushBinaryOperation(division, "div");
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
		this.pushQuantifier(existsQuantifier, "exists", "and");
	}

	@Override
	public void visit(final ForAllQuantifier forAllQuantifier) {
		this.pushQuantifier(forAllQuantifier, "forall", "=>");
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
		if (integerLiteral.getValue().compareTo(BigInteger.ZERO) < 0) {
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
		String varrefString = variableReference.getVariable().getName();

		final Expression index = variableReference.getIndex();
		if (index != null) {
			index.accept(this);
			varrefString = "(select " + varrefString + " " + this.formulaCompileStack.pop() + ")";
		}

		this.formulaCompileStack.push(varrefString);
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
