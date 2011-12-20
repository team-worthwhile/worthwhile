/**
 * 
 */
package prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

/** 
 * 
 */
protected class SMTLIBStrategy implements FormulaCompiler, ASTNodeVisitor {
	/** 
	 * 
	 */
	private String compilation;

	/** 
	 * @return the compilation
	 */
	public String getCompilation() {
		// begin-user-code
		return compilation;
		// end-user-code
	}

	/** 
	 * @param compilation the compilation to set
	 */
	public void setCompilation(String compilation) {
		// begin-user-code
		this.compilation = compilation;
		// end-user-code
	}

	/** 
	 * 
	 */
	protected SMTLIBStrategy() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	 * @see FormulaCompiler#compileFormula(Expression formula)
	 */
	public String compileFormula(Expression formula) {
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