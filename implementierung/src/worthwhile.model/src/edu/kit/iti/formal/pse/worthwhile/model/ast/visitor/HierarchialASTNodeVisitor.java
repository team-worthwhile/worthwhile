package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
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
 * A visitor that can visit any ASTNode object. If the visit() method for a specific type is not implemented, the
 * supertype’s visit() method is tried and so forth.
 * 
 * @author Joachim
 * 
 * @nocheckstyle:designforextension
 * 
 */
public abstract class HierarchialASTNodeVisitor extends ASTNodeVisitor {

	@Override
	public void visit(final Addition node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Annotation node) {
		this.visit((Statement) node);
	}

	@Override
	public void visit(final ArrayFunction node) {
		this.visit((Literal) node);
	}

	@Override
	public void visit(final ArrayLiteral node) {
		this.visit((Literal) node);
	}

	@Override
	public void visit(final ArrayType node) {
		this.visit((Type) node);
	}

	@Override
	public void visit(final Assertion node) {
		this.visit((Annotation) node);
	}

	@Override
	public void visit(final Assignment node) {
		this.visit((Statement) node);
	}

	@Override
	public void visit(final Assumption node) {
		this.visit((Annotation) node);
	}

	@Override
	public void visit(final Axiom node) {
		this.visit((Annotation) node);
	}

	@Override
	public void visit(final BinaryExpression node) {
		this.visit((Expression) node);
	}

	@Override
	public void visit(final Block node) {
		this.visit((ASTNode) node);
	}

	@Override
	public void visit(final BooleanLiteral node) {
		this.visit((Literal) node);
	}

	@Override
	public void visit(final BooleanType node) {
		this.visit((PrimitiveType) node);
	}

	@Override
	public void visit(final Conditional node) {
		this.visit((Statement) node);
	}

	@Override
	public void visit(final Conjunction node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Disjunction node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Division node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Equal node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Equivalence node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final ExistsQuantifier node) {
		this.visit((QuantifiedExpression) node);
	}

	@Override
	public void visit(final Expression node) {
		this.visit((ASTNode) node);
	}

	@Override
	public void visit(final ForAllQuantifier node) {
		this.visit((QuantifiedExpression) node);
	}

	@Override
	public void visit(final FunctionCall node) {
		this.visit((Expression) node);
	}

	@Override
	public void visit(final FunctionDeclaration node) {
		this.visit((ASTNode) node);
	}

	@Override
	public void visit(final Greater node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final GreaterOrEqual node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Implication node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final IntegerLiteral node) {
		this.visit((Literal) node);
	}

	@Override
	public void visit(final IntegerType node) {
		this.visit((PrimitiveType) node);
	}

	@Override
	public void visit(final Invariant node) {
		this.visit((Annotation) node);
	}

	@Override
	public void visit(final Less node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final LessOrEqual node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Literal node) {
		this.visit((Expression) node);
	}

	@Override
	public void visit(final Loop node) {
		this.visit((Statement) node);
	}

	@Override
	public void visit(final Minus node) {
		this.visit((Sign) node);
	}

	@Override
	public void visit(final Modulus node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Multiplication node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Negation node) {
		this.visit((UnaryExpression) node);
	}

	@Override
	public void visit(final Plus node) {
		this.visit((Sign) node);
	}

	@Override
	public void visit(final Postcondition node) {
		this.visit((Annotation) node);
	}

	@Override
	public void visit(final Precondition node) {
		this.visit((Annotation) node);
	}

	@Override
	public void visit(final PrimitiveType node) {
		this.visit((Type) node);
	}

	@Override
	public void visit(final Program node) {
		this.visit((ASTNode) node);
	}

	@Override
	public void visit(final QuantifiedExpression node) {
		this.visit((Expression) node);
	}

	@Override
	public void visit(final ReturnStatement node) {
		this.visit((Statement) node);
	}

	@Override
	public void visit(final Sign node) {
		this.visit((UnaryExpression) node);
	}

	@Override
	public void visit(final Statement node) {
		this.visit((ASTNode) node);
	}

	@Override
	public void visit(final Subtraction node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final Type node) {
		this.visit((ASTNode) node);
	}

	@Override
	public void visit(final UnaryExpression node) {
		this.visit((Expression) node);
	}

	@Override
	public void visit(final Unequal node) {
		this.visit((BinaryExpression) node);
	}

	@Override
	public void visit(final VariableDeclaration node) {
		this.visit((Statement) node);
	}

	@Override
	public void visit(final VariableReference node) {
		this.visit((Expression) node);
	}
	
	@Override
	public void visit(final ReturnValueReference node) {
		this.visit((VariableReference) node);
	}

}
