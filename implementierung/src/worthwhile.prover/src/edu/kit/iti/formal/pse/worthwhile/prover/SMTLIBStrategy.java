/**
 *
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 *
 */
// TODO: This doesn't really implement all of ASTNodeVisitor, it should only
// compile expressions!
class SMTLIBStrategy extends ASTNodeVisitor implements FormulaCompiler {

	private final Stack<String> compileStack = new Stack<String>();

	/**
	 * @see FormulaCompiler#compileFormula(Expression formula)
	 */
	@Override
	public String compileFormula(Expression formula) {
		// this should push a String object to the compilation stack
		formula.accept(this);
		return this.compileStack.pop();
	}

	private void pushBinaryOperation(BinaryExpression binaryExpression,
			String compiledOperationSymbol) {
		binaryExpression.getLeft().accept(this);
		binaryExpression.getRight().accept(this);
		String right = this.compileStack.pop();
		String left = this.compileStack.pop();
		this.compileStack.push("(" + compiledOperationSymbol + " " + left + " "
				+ right + ")");
	}

	private void pushUnaryOperation(UnaryExpression unaryExpression,
			String compiledOperationSymbol) {
		unaryExpression.getOperand().accept(this);
		String operand = this.compileStack.pop();
		this.compileStack.push("(" + compiledOperationSymbol + " " + operand
				+ ")");
	}

	@Override
	public void visit(Addition addition) {
		this.pushBinaryOperation(addition, "+");
	}

	@Override
	public void visit(ArrayAccess arrayAccess) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(ArrayLength arrayLength) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(ArrayLiteral arrayLiteral) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(ArrayType arrayType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(Assertion assertion) {
		assertion.getExpression().accept(this);
		String expr = this.compileStack.pop();
		this.compileStack.push("assert(" + expr + ")");
	}

	@Override
	public void visit(Assignment assignment) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(Assumption assumption) {
		assumption.getExpression().accept(this);
		String expr = this.compileStack.pop();
		this.compileStack.push("assume(" + expr + ")");
	}

	@Override
	public void visit(Axiom axiom) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(Block block) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	@Override
	public void visit(BooleanLiteral booleanLiteral) {
		if (booleanLiteral.isValue()) {
			this.compileStack.push("true");
		}
		else {
			this.compileStack.push("false");
		}
	}

	@Override
	public void visit(BooleanType booleanType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Conditional conditional)
	 */
	@Override
	public void visit(Conditional conditional) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Conjunction conjunction)
	 */
	@Override
	public void visit(Conjunction conjunction) {
		this.pushBinaryOperation(conjunction, "and");
	}

	/**
	 * @see ASTNodeVisitor#visit(Disjunction disjunction)
	 */
	@Override
	public void visit(Disjunction disjunction) {
		this.pushBinaryOperation(disjunction, "or");
	}

	/**
	 * @see ASTNodeVisitor#visit(Division division)
	 */
	@Override
	public void visit(Division division) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Equal equal)
	 */
	@Override
	public void visit(Equal equal) {
		this.pushBinaryOperation(equal, "=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Equivalence equivalence)
	 */
	@Override
	public void visit(Equivalence equivalence) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(ExistsQuantifier existsQuantifier)
	 */
	@Override
	public void visit(ExistsQuantifier existsQuantifier) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(ForAllQuantifier forAllQuantifier)
	 */
	@Override
	public void visit(ForAllQuantifier forAllQuantifier) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(FunctionCall functionCall)
	 */
	@Override
	public void visit(FunctionCall functionCall) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(FunctionDeclaration functionDeclaration)
	 */
	@Override
	public void visit(FunctionDeclaration functionDeclaration) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Greater greater)
	 */
	@Override
	public void visit(Greater greater) {
		this.pushBinaryOperation(greater, ">");
	}

	/**
	 * @see ASTNodeVisitor#visit(GreaterOrEqual greaterOrEqual)
	 */
	@Override
	public void visit(GreaterOrEqual greaterOrEqual) {
		this.pushBinaryOperation(greaterOrEqual, ">=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Implication implication)
	 */
	@Override
	public void visit(Implication implication) {
		this.pushBinaryOperation(implication, "=>");
	}

	/**
	 * @see ASTNodeVisitor#visit(IntegerLiteral integerLiteral)
	 */
	@Override
	public void visit(IntegerLiteral integerLiteral) {
		this.compileStack.push(integerLiteral.getValue().toString());
	}

	/**
	 * @see ASTNodeVisitor#visit(IntegerType integerType)
	 */
	@Override
	public void visit(IntegerType integerType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Invariant invariant)
	 */
	@Override
	public void visit(Invariant invariant) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Less less)
	 */
	@Override
	public void visit(Less less) {
		this.pushBinaryOperation(less, "<");
	}

	/**
	 * @see ASTNodeVisitor#visit(LessOrEqual lessOrEqual)
	 */
	@Override
	public void visit(LessOrEqual lessOrEqual) {
		this.pushBinaryOperation(lessOrEqual, "<=");
	}

	/**
	 * @see ASTNodeVisitor#visit(Loop loop)
	 */
	@Override
	public void visit(Loop loop) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Minus minus)
	 */
	@Override
	public void visit(Minus minus) {
	}

	@Override
	public void visit(Modulus modulus) {
		this.pushBinaryOperation(modulus, "mod");
	}

	/**
	 * @see ASTNodeVisitor#visit(Multiplication multiplication)
	 */
	@Override
	public void visit(Multiplication multiplication) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Negation negation)
	 */
	@Override
	public void visit(Negation negation) {
		this.pushUnaryOperation(negation, "not");
	}

	/**
	 * @see ASTNodeVisitor#visit(Object variableReference)
	 */
	public void visit(Object variableReference) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Plus plus)
	 */
	@Override
	public void visit(Plus plus) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Postcondition postcondition)
	 */
	@Override
	public void visit(Postcondition postcondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Predicates predicates)
	 */
	/*
	 * public void visit(Predicates predicates) { // begin-user-code // TODO
	 * Auto-generated method stub
	 *
	 * // end-user-code }
	 */

	/**
	 * @see ASTNodeVisitor#visit(Precondition precondition)
	 */
	@Override
	public void visit(Precondition precondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Program program)
	 */
	@Override
	public void visit(Program program) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(QuantifiedExpression quantifiedExpression)
	 */
	@Override
	public void visit(QuantifiedExpression quantifiedExpression) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(ReturnStatement returnStatement)
	 */
	@Override
	public void visit(ReturnStatement returnStatement) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Subtraction subtraction)
	 */
	public void visit(Subtraction subtraction) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Unequal unequal)
	 */
	@Override
	public void visit(Unequal unequal) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(VariableDeclaration variableDecleration)
	 */
	@Override
	public void visit(VariableDeclaration variableDecleration) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

}
