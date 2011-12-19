/**
 * 
 */
package prover;

import AST.ASTNodeVisitor;
import AST.Expression;
import AST.Program;
import AST.Addition;
import AST.ArrayAccess;
import AST.ArrayLength;
import AST.ArrayLiteral;
import AST.ArrayType;
import AST.Assertion;
import AST.Assignment;
import AST.Assumption;
import AST.Axiom;
import AST.Block;
import AST.BooleanLiteral;
import AST.BooleanType;
import AST.Conditional;
import AST.Conjunction;
import AST.Disjunction;
import AST.Division;
import AST.Equal;
import AST.Equivalence;
import AST.ExistsQuantifier;
import AST.ForAllQuantifier;
import AST.FunctionCall;
import AST.FunctionDeclaration;
import AST.Greater;
import AST.GreaterOrEqual;
import AST.Implication;
import AST.IntegerLiteral;
import AST.IntegerType;
import AST.Invariant;
import AST.Less;
import AST.LessOrEqual;
import AST.Loop;
import AST.Minus;
import AST.Modulus;
import AST.Multiplication;
import AST.Negation;
import AST.ASTNode;
import AST.Parameter;
import AST.Plus;
import AST.Postcondition;
import AST.Precondition;
import AST.Predicates;
import AST.QuantifiedExpression;
import AST.ReturnStatement;
import AST.Subtraction;
import AST.Unequal;
import AST.VariableDeclaration;

/** 
 * 
 */
protected class WPStrategy implements FormulaGenerator, ASTNodeVisitor {
	/** 
	 * 	
	 */
	private Expression weakestPrecondition;

	/** 
	 * @return the weakestPrecondition
	 */
	public Expression getWeakestPrecondition() {
		// begin-user-code
		return weakestPrecondition;
		// end-user-code
	}

	/** 
	 * @param weakestPrecondition the weakestPrecondition to set
	 */
	public void setWeakestPrecondition(Expression weakestPrecondition) {
		// begin-user-code
		this.weakestPrecondition = weakestPrecondition;
		// end-user-code
	}

	/** 
	 * 
	 */
	protected WPStrategy() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	 * @see FormulaGenerator#transformProgram(Program program)
	 */
	public Expression transformProgram(Program program) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Addition addition)
	 */
	public void visit(Addition addition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ArrayAccess arrayAccess)
	 */
	public void visit(ArrayAccess arrayAccess) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ArrayLength arrayLength)
	 */
	public void visit(ArrayLength arrayLength) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ArrayLiteral arrayLiteral)
	 */
	public void visit(ArrayLiteral arrayLiteral) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ArrayType arrayType)
	 */
	public void visit(ArrayType arrayType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Assertion assertion)
	 */
	public void visit(Assertion assertion) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Assignment assignment)
	 */
	public void visit(Assignment assignment) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Assumption assumption)
	 */
	public void visit(Assumption assumption) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Axiom axiom)
	 */
	public void visit(Axiom axiom) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Block block)
	 */
	public void visit(Block block) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(BooleanLiteral booleanLiteral)
	 */
	public void visit(BooleanLiteral booleanLiteral) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(BooleanType booleanType)
	 */
	public void visit(BooleanType booleanType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Conditional conditional)
	 */
	public void visit(Conditional conditional) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Conjunction conjunction)
	 */
	public void visit(Conjunction conjunction) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Disjunction disjunction)
	 */
	public void visit(Disjunction disjunction) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Division division)
	 */
	public void visit(Division division) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Equal equal)
	 */
	public void visit(Equal equal) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Equivalence equivalence)
	 */
	public void visit(Equivalence equivalence) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ExistsQuantifier existsQuantifier)
	 */
	public void visit(ExistsQuantifier existsQuantifier) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ForAllQuantifier forAllQuantifier)
	 */
	public void visit(ForAllQuantifier forAllQuantifier) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(FunctionCall functionCall)
	 */
	public void visit(FunctionCall functionCall) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(FunctionDeclaration functionDeclaration)
	 */
	public void visit(FunctionDeclaration functionDeclaration) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Greater greater)
	 */
	public void visit(Greater greater) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(GreaterOrEqual greaterOrEqual)
	 */
	public void visit(GreaterOrEqual greaterOrEqual) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Implication implication)
	 */
	public void visit(Implication implication) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(IntegerLiteral integerLiteral)
	 */
	public void visit(IntegerLiteral integerLiteral) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(IntegerType integerType)
	 */
	public void visit(IntegerType integerType) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Invariant invariant)
	 */
	public void visit(Invariant invariant) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Less less)
	 */
	public void visit(Less less) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(LessOrEqual lessOrEqual)
	 */
	public void visit(LessOrEqual lessOrEqual) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Loop loop)
	 */
	public void visit(Loop loop) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Minus minus)
	 */
	public void visit(Minus minus) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Modulus modulus)
	 */
	public void visit(Modulus modulus) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Multiplication multiplication)
	 */
	public void visit(Multiplication multiplication) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Negation negation)
	 */
	public void visit(Negation negation) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ASTNode node)
	 */
	public void visit(ASTNode node) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Parameter parameter)
	 */
	public void visit(Parameter parameter) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Plus plus)
	 */
	public void visit(Plus plus) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Postcondition postcondition)
	 */
	public void visit(Postcondition postcondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Precondition precondition)
	 */
	public void visit(Precondition precondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Predicates predicates)
	 */
	public void visit(Predicates predicates) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Program program)
	 */
	public void visit(Program program) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(QuantifiedExpression quantifiedExpression)
	 */
	public void visit(QuantifiedExpression quantifiedExpression) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(ReturnStatement returnStatement)
	 */
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
	public void visit(Unequal unequal) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(VariableDeclaration variableDecleration)
	 */
	public void visit(VariableDeclaration variableDecleration) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @see ASTNodeVisitor#visit(Object variableReference)
	 */
	public void visit(Object variableReference) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}