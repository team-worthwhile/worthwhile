package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * A visitor for AST nodes.
 * 
 * @author Joachim
 * 
 */
public interface IASTNodeVisitor {

	/**
	 * Visits an AST node of type Addition.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Addition node);

	/**
	 * Visits an AST node of type Annotation.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Annotation node);

	/**
	 * Visits an AST node of type ArrayLiteral.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(ArrayLiteral node);

	/**
	 * Visits an AST node of type ArrayType.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(ArrayType node);

	/**
	 * Visits an AST node of type Assertion.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Assertion node);

	/**
	 * Visits an AST node of type Assignment.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Assignment node);

	/**
	 * Visits an AST node of type Assumption.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Assumption node);

	/**
	 * Visits an AST node of type ASTNode.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(ASTNode node);

	/**
	 * Visits an AST node of type Axiom.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Axiom node);

	/**
	 * Visits an AST node of type BinaryExpression.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(BinaryExpression node);

	/**
	 * Visits an AST node of type Block.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Block node);

	/**
	 * Visits an AST node of type BooleanLiteral.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(BooleanLiteral node);

	/**
	 * Visits an AST node of type BooleanType.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(BooleanType node);

	/**
	 * Visits an AST node of type Conditional.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Conditional node);

	/**
	 * Visits an AST node of type Conjunction.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Conjunction node);

	/**
	 * Visits an AST node of type Disjunction.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Disjunction node);

	/**
	 * Visits an AST node of type Division.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Division node);

	/**
	 * Visits an AST node of type Equal.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Equal node);

	/**
	 * Visits an AST node of type Equivalence.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Equivalence node);

	/**
	 * Visits an AST node of type ExistsQuantifier.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(ExistsQuantifier node);

	/**
	 * Visits an AST node of type Expression.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Expression node);

	/**
	 * Visits an AST node of type ForAllQuantifier.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(ForAllQuantifier node);

	/**
	 * Visits an AST node of type FunctionCall.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(FunctionCall node);

	/**
	 * Visits an AST node of type FunctionDeclaration.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(FunctionDeclaration node);

	/**
	 * Visits an AST node of type Greater.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Greater node);

	/**
	 * Visits an AST node of type GreaterOrEqual.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(GreaterOrEqual node);

	/**
	 * Visits an AST node of type Implication.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Implication node);

	/**
	 * Visits an AST node of type IntegerLiteral.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(IntegerLiteral node);

	/**
	 * Visits an AST node of type IntegerType.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(IntegerType node);

	/**
	 * Visits an AST node of type Invariant.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Invariant node);

	/**
	 * Visits an AST node of type Less.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Less node);

	/**
	 * Visits an AST node of type LessOrEqual.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(LessOrEqual node);

	/**
	 * Visits an AST node of type Literal.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Literal node);

	/**
	 * Visits an AST node of type Loop.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Loop node);

	/**
	 * Visits an AST node of type Minus.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Minus node);

	/**
	 * Visits an AST node of type Modulus.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Modulus node);

	/**
	 * Visits an AST node of type Multiplication.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Multiplication node);

	/**
	 * Visits an AST node of type Negation.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Negation node);

	/**
	 * Visits an AST node of type Plus.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Plus node);

	/**
	 * Visits an AST node of type Postcondition.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Postcondition node);

	/**
	 * Visits an AST node of type Precondition.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Precondition node);

	/**
	 * Visits an AST node of type PrimitiveType.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(PrimitiveType node);

	/**
	 * Visits an AST node of type Program.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Program node);

	/**
	 * Visits an AST node of type QuantifiedExpression.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(QuantifiedExpression node);

	/**
	 * Visits an AST node of type ReturnStatement.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(ReturnStatement node);

	/**
	 * Visits an AST node of type Sign.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Sign node);

	/**
	 * Visits an AST node of type Statement.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Statement node);

	/**
	 * Visits an AST node of type Subtraction.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Subtraction node);

	/**
	 * Visits an AST node of type Type.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Type node);

	/**
	 * Visits an AST node of type UnaryExpression.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(UnaryExpression node);

	/**
	 * Visits an AST node of type Unequal.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(Unequal node);

	/**
	 * Visits an AST node of type VariableDeclaration.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(VariableDeclaration node);

	/**
	 * Visits an AST node of type VariableReference.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(VariableReference node);
	
	/**
	 * Visits an AST node of type ReturnVariableReference.
	 * 
	 * @param node
	 *                The AST node to visit
	 */
	void visit(ReturnValueReference node);

}