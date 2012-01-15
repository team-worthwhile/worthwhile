/**
 *
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * @author Leon Handreke, fabian
 */
// TODO: This doesn't really implement all of ASTNodeVisitor, it should only
// compile expressions!
class SMTLIBStrategy extends HierarchialASTNodeVisitor implements FormulaCompiler {

	private final Stack<String> formulaCompileStack = new Stack<String>();

	// TODO: use VariableDeclaration here once it's got a better equals method
	private final Set<String> declarations = new HashSet<String>();

	/**
	 * @see FormulaCompiler#compileFormula(Expression formula)
	 */
	@Override
	public String compileFormula(final Expression formula) {
		// this should push a String object to the compilation stack
		formula.accept(this);
		String formulaString = this.formulaCompileStack.pop();

		String declarationsString = "";
		for (String s : this.declarations) {
			declarationsString += s + "\n";
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
		this.formulaCompileStack.push("(" + " " + variableDeclaration.getName()
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
		this.formulaCompileStack.push("(" + quantifierString + "(" + this.formulaCompileStack.pop() + ") "
		                + expression + ")");
	}

	public void visit(final Addition addition) {
		this.pushBinaryOperation(addition, "+");
	}

	public void visit(final ArrayLength arrayLength) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void visit(final ArrayLiteral arrayLiteral) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void visit(final ArrayType arrayType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void visit(final Assertion assertion) {
		assertion.getExpression().accept(this);
		String expr = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("assert(" + expr + ")");
	}

	public void visit(final Assignment assignment) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void visit(final Assumption assumption) {
		assumption.getExpression().accept(this);
		String expr = this.formulaCompileStack.pop();
		this.formulaCompileStack.push("assume(" + expr + ")");
	}

	public void visit(final Axiom axiom) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void visit(final Block block) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void visit(final BooleanLiteral booleanLiteral) {
		if (booleanLiteral.isValue()) {
			this.formulaCompileStack.push("true");
		} else {
			this.formulaCompileStack.push("false");
		}
	}

	public void visit(final BooleanType booleanType) {
		this.formulaCompileStack.push("Bool");
	}

	/**
	 * @see ASTNodeVisitor#visit(Conditional conditional)
	 */
	public void visit(final Conditional conditional) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Conjunction conjunction)
	 */
	public void visit(final Conjunction conjunction) {
		this.pushBinaryOperation(conjunction, "and");
	}

	/**
	 * @see ASTNodeVisitor#visit(Disjunction disjunction)
	 */
	public void visit(final Disjunction disjunction) {
		this.pushBinaryOperation(disjunction, "or");
	}

	/**
	 * @see ASTNodeVisitor#visit(Division division)
	 */
	public void visit(final Division division) {
		this.pushBinaryOperation(division, "/");
	}

	/**
	 * @see ASTNodeVisitor#visit(Equal equal)
	 */
	public void visit(final Equal equal) {
		this.pushBinaryOperation(equal, "=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Equivalence equivalence)
	 */
	public void visit(final Equivalence equivalence) {
		this.pushBinaryOperation(equivalence, "iff");
	}

	/**
	 * @see ASTNodeVisitor#visit(ExistsQuantifier existsQuantifier)
	 */
	public void visit(final ExistsQuantifier existsQuantifier) {
		this.pushQuantifier(existsQuantifier, "exists");
	}

	/**
	 * @see ASTNodeVisitor#visit(ForAllQuantifier forAllQuantifier)
	 */
	public void visit(final ForAllQuantifier forAllQuantifier) {
		this.pushQuantifier(forAllQuantifier, "forall");
	}

	/**
	 * @see ASTNodeVisitor#visit(FunctionCall functionCall)
	 */
	public void visit(final FunctionCall functionCall) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(FunctionDeclaration functionDeclaration)
	 */
	public void visit(final FunctionDeclaration functionDeclaration) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Greater greater)
	 */
	public void visit(final Greater greater) {
		this.pushBinaryOperation(greater, ">");
	}

	/**
	 * @see ASTNodeVisitor#visit(GreaterOrEqual greaterOrEqual)
	 */
	public void visit(final GreaterOrEqual greaterOrEqual) {
		this.pushBinaryOperation(greaterOrEqual, ">=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Implication implication)
	 */
	public void visit(final Implication implication) {
		this.pushBinaryOperation(implication, "=>");
	}

	/**
	 * @see ASTNodeVisitor#visit(IntegerLiteral integerLiteral)
	 */
	public void visit(final IntegerLiteral integerLiteral) {
		this.formulaCompileStack.push(integerLiteral.getValue().toString());
	}

	/**
	 * @see ASTNodeVisitor#visit(IntegerType integerType)
	 */
	public void visit(final IntegerType integerType) {
		this.formulaCompileStack.push("Int");
	}

	/**
	 * @see ASTNodeVisitor#visit(Invariant invariant)
	 */
	public void visit(final Invariant invariant) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Less less)
	 */
	public void visit(final Less less) {
		this.pushBinaryOperation(less, "<");
	}

	/**
	 * @see ASTNodeVisitor#visit(LessOrEqual lessOrEqual)
	 */
	public void visit(final LessOrEqual lessOrEqual) {
		this.pushBinaryOperation(lessOrEqual, "<=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Loop loop)
	 */
	public void visit(final Loop loop) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Minus minus)
	 */
	public void visit(final Minus minus) {
		this.pushUnaryOperation(minus, "-");
	}

	public void visit(final Modulus modulus) {
		this.pushBinaryOperation(modulus, "mod");
	}

	/**
	 * @see ASTNodeVisitor#visit(Multiplication multiplication)
	 */
	public void visit(final Multiplication multiplication) {
		this.pushBinaryOperation(multiplication, "*");
	}

	/**
	 * @see ASTNodeVisitor#visit(Negation negation)
	 */
	public void visit(final Negation negation) {
		this.pushUnaryOperation(negation, "not");
	}

	/**
	 * @see ASTNodeVisitor#visit(VariableReference variableReference)
	 */
	public void visit(final VariableReference variableReference) {
		variableReference.getVariable().accept(this);
		this.formulaCompileStack.push(variableReference.getVariable().getName());
	}

	/**
	 * @see ASTNodeVisitor#visit(Plus plus)
	 */
	public void visit(final Plus plus) {
		this.pushUnaryOperation(plus, "+");
	}

	/**
	 * @see ASTNodeVisitor#visit(Postcondition postcondition)
	 */
	public void visit(final Postcondition postcondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Precondition precondition)
	 */
	public void visit(final Precondition precondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Program program)
	 */
	public void visit(final Program program) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(QuantifiedExpression quantifiedExpression)
	 */
	public void visit(final QuantifiedExpression quantifiedExpression) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(ReturnStatement returnStatement)
	 */
	public void visit(final ReturnStatement returnStatement) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Subtraction subtraction)
	 */
	public void visit(final Subtraction subtraction) {
		this.pushBinaryOperation(subtraction, "-");
	}

	/**
	 * @see ASTNodeVisitor#visit(Unequal unequal)
	 */
	public void visit(final Unequal unequal) {
		this.pushBinaryOperation(unequal, "=");

		// there is no function `!=' in SMTLIB
		this.formulaCompileStack.push("(not (" + this.formulaCompileStack.pop() + ")");
	}

	/**
	 * @see ASTNodeVisitor#visit(VariableDeclaration variableDeclaration)
	 */
	public void visit(final VariableDeclaration variableDeclaration) {
		variableDeclaration.getType().accept(this);
		this.declarations.add("(declare-const " + variableDeclaration.getName() + " "
		                + this.formulaCompileStack.pop() + ")");
	}

}
