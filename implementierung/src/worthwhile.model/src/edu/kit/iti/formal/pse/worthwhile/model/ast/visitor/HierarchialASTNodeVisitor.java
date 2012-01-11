package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * A visitor that can visit any ASTNode object. If the visit() method for a specific type is not implemented, the
 * supertype’s visit() method is tried and so forth.
 * 
 * @author Joachim
 * 
 */
public class HierarchialASTNodeVisitor extends ASTNodeVisitor {

	/**
	 * Visits an AST node of type ASTNode.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final ASTNode node) {
		this.throwUnsupportedASTNodeTypeException();
	}

	/**
	 * Visits an AST node of type Addition.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Addition node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Annotation.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Annotation node) {
		this.visit((Statement) node);
	}

	/**
	 * Visits an AST node of type ArrayLength.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final ArrayLength node) {
		this.visit((UnaryExpression) node);
	}

	/**
	 * Visits an AST node of type ArrayLiteral.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final ArrayLiteral node) {
		this.visit((Literal) node);
	}

	/**
	 * Visits an AST node of type ArrayType.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final ArrayType node) {
		this.visit((Type) node);
	}

	/**
	 * Visits an AST node of type Assertion.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Assertion node) {
		this.visit((Annotation) node);
	}

	/**
	 * Visits an AST node of type Assignment.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Assignment node) {
		this.visit((Statement) node);
	}

	/**
	 * Visits an AST node of type Assumption.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Assumption node) {
		this.visit((Annotation) node);
	}

	/**
	 * Visits an AST node of type Axiom.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Axiom node) {
		this.visit((Annotation) node);
	}

	/**
	 * Visits an AST node of type BinaryExpression.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final BinaryExpression node) {
		this.visit((Expression) node);
	}

	/**
	 * Visits an AST node of type Block.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Block node) {
		this.visit((ASTNode) node);
	}

	/**
	 * Visits an AST node of type BooleanLiteral.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final BooleanLiteral node) {
		this.visit((Literal) node);
	}

	/**
	 * Visits an AST node of type BooleanType.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final BooleanType node) {
		this.visit((PrimitiveType) node);
	}

	/**
	 * Visits an AST node of type Conditional.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Conditional node) {
		this.visit((Statement) node);
	}

	/**
	 * Visits an AST node of type Conjunction.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Conjunction node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Disjunction.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Disjunction node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Division.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Division node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Equal.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Equal node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Equivalence.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Equivalence node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type ExistsQuantifier.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final ExistsQuantifier node) {
		this.visit((QuantifiedExpression) node);
	}

	/**
	 * Visits an AST node of type Expression.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Expression node) {
		this.visit((ASTNode) node);
	}

	/**
	 * Visits an AST node of type ForAllQuantifier.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final ForAllQuantifier node) {
		this.visit((QuantifiedExpression) node);
	}

	/**
	 * Visits an AST node of type FunctionCall.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final FunctionCall node) {
		this.visit((Expression) node);
	}

	/**
	 * Visits an AST node of type FunctionDeclaration.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final FunctionDeclaration node) {
		this.visit((ASTNode) node);
	}

	/**
	 * Visits an AST node of type Greater.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Greater node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type GreaterOrEqual.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final GreaterOrEqual node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Implication.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Implication node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type IntegerLiteral.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final IntegerLiteral node) {
		this.visit((Literal) node);
	}

	/**
	 * Visits an AST node of type IntegerType.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final IntegerType node) {
		this.visit((PrimitiveType) node);
	}

	/**
	 * Visits an AST node of type Invariant.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Invariant node) {
		this.visit((Annotation) node);
	}

	/**
	 * Visits an AST node of type Less.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Less node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type LessOrEqual.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final LessOrEqual node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Literal.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Literal node) {
		this.visit((Expression) node);
	}

	/**
	 * Visits an AST node of type Loop.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Loop node) {
		this.visit((Statement) node);
	}

	/**
	 * Visits an AST node of type Minus.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Minus node) {
		this.visit((Sign) node);
	}

	/**
	 * Visits an AST node of type Modulus.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Modulus node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Multiplication.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Multiplication node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Negation.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Negation node) {
		this.visit((UnaryExpression) node);
	}

	/**
	 * Visits an AST node of type Plus.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Plus node) {
		this.visit((Sign) node);
	}

	/**
	 * Visits an AST node of type Postcondition.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Postcondition node) {
		this.visit((Annotation) node);
	}

	/**
	 * Visits an AST node of type Precondition.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Precondition node) {
		this.visit((Annotation) node);
	}

	/**
	 * Visits an AST node of type PrimitiveType.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final PrimitiveType node) {
		this.visit((Type) node);
	}

	/**
	 * Visits an AST node of type Program.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Program node) {
		this.visit((ASTNode) node);
	}

	/**
	 * Visits an AST node of type QuantifiedExpression.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final QuantifiedExpression node) {
		this.visit((Expression) node);
	}

	/**
	 * Visits an AST node of type ReturnStatement.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final ReturnStatement node) {
		this.visit((Statement) node);
	}

	/**
	 * Visits an AST node of type Sign.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Sign node) {
		this.visit((UnaryExpression) node);
	}

	/**
	 * Visits an AST node of type Statement.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Statement node) {
		this.visit((ASTNode) node);
	}

	/**
	 * Visits an AST node of type Subtraction.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Subtraction node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type Type.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Type node) {
		this.visit((ASTNode) node);
	}

	/**
	 * Visits an AST node of type UnaryExpression.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final UnaryExpression node) {
		this.visit((Expression) node);
	}

	/**
	 * Visits an AST node of type Unequal.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final Unequal node) {
		this.visit((BinaryExpression) node);
	}

	/**
	 * Visits an AST node of type VariableDeclaration.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final VariableDeclaration node) {
		this.visit((Statement) node);
	}

	/**
	 * Visits an AST node of type VariableReference.
	 * 
	 * @param node
	 *                The AST node to visit.
	 */
	public void visit(final VariableReference node) {
		this.visit((Expression) node);
	}

	/**
	 * Throws an exception indicating that an unsupported type of AST node was tried to be visited.
	 */
	private void throwUnsupportedASTNodeTypeException() {
		throw new UnsupportedOperationException("Visitor cannot Handle this type of ASTNode!");
	}
	
}
