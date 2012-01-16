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
 * A default implementation of the {@link IASTNodeVisitor} interface.
 * 
 * Implementors can specify a default operation that is executed when no other operation is defined.
 * 
 * @author Joachim
 * 
 * @nocheckstyle:designforextension
 * 
 */
public abstract class ASTNodeVisitor implements IASTNodeVisitor {

	/**
	 * The default operation to be executed when no operation is defined for a type of AST node.
	 * 
	 * @param node
	 *                The node for which the operation was called.
	 */
	protected void defaultOperation(final ASTNode node) {
		throw new UnsupportedOperationException("Visitor cannot handle this type of AST node: "
		                + node.eClass().toString());
	}

	@Override
	public void visit(final Addition node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Annotation node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final ArrayLength node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final ArrayLiteral node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final ArrayType node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Assertion node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Assignment node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Assumption node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final ASTNode node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Axiom node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final BinaryExpression node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Block node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final BooleanLiteral node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final BooleanType node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Conditional node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Conjunction node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Disjunction node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Division node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Equal node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Equivalence node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final ExistsQuantifier node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Expression node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final ForAllQuantifier node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final FunctionCall node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final FunctionDeclaration node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Greater node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final GreaterOrEqual node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Implication node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final IntegerLiteral node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final IntegerType node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Invariant node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Less node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final LessOrEqual node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Literal node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Loop node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Minus node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Modulus node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Multiplication node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Negation node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Plus node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Postcondition node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Precondition node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final PrimitiveType node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Program node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final QuantifiedExpression node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final ReturnStatement node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Sign node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Statement node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Subtraction node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Type node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final UnaryExpression node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final Unequal node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final VariableDeclaration node) {
		this.defaultOperation(node);
	}

	@Override
	public void visit(final VariableReference node) {
		this.defaultOperation(node);
	}
	
	@Override
	public void visit(final ReturnValueReference node) {
		this.defaultOperation(node);
	}

}
