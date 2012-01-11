package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import java.math.BigInteger;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * Visitor used to clone an ASTNode recursively.
 * 
 * @author Leon Handreke
 * 
 */
public class ASTNodeCloneVisitor extends HierarchialASTNodeVisitor {
	/**
	 * The "return stack" for visit methods.
	 */
	private Stack<ASTNode> cloneStack = new Stack<ASTNode>();

	/**
	 * Factory used to construct new nodes.
	 */
	private AstFactory nodeFactory = AstFactory.init();

	/**
	 * @return the cloned ASTNode that was last visited
	 */
	public final ASTNode getClone() {
		return this.cloneStack.get(0);
	}

	/**
	 * Convenience method to clone the Expressions of a {@link BinaryExpression}.
	 * 
	 * @param oldBinaryExpression
	 *                the {@link BinaryExpression} to take the {@link Expression}s from
	 * @param newBinaryExpression
	 *                the {@link BinaryExpression} to clone the {@link Expression}s to
	 */
	private void cloneBinaryExpressionOperands(final BinaryExpression oldBinaryExpression,
	                final BinaryExpression newBinaryExpression) {
		oldBinaryExpression.getLeft().accept(this);
		oldBinaryExpression.getRight().accept(this);
		newBinaryExpression.setRight((Expression) this.cloneStack.pop());
		newBinaryExpression.setLeft((Expression) this.cloneStack.pop());
	}

	/**
	 * Convenience method to clone the Expression of a {@link UnaryExpression}.
	 * 
	 * @param oldUnaryExpression
	 *                the {@link UnaryExpression} to take the {@link Expression} from
	 * @param newUnaryExpression
	 *                the {@link UnaryExpression} to clone the {@link Expression} to
	 */
	private void cloneUnaryExpressionOperand(final UnaryExpression oldUnaryExpression,
	                final UnaryExpression newUnaryExpression) {
		oldUnaryExpression.getOperand().accept(this);
		newUnaryExpression.setOperand((Expression) this.cloneStack.pop());
	}

	/**
	 * Convenience method to clone the Expression of an {@link Annotation}.
	 * 
	 * @param oldAnnotation
	 *                the {@link Annotation} to take the {@link Expression} from
	 * @param newAnnotation
	 *                the {@link Annotation} to clone the {@link Expression} to
	 */
	private void cloneAnnotationExpression(final Annotation oldAnnotation, final Annotation newAnnotation) {
		oldAnnotation.accept(this);
		newAnnotation.setExpression((Expression) this.cloneStack.pop());
	}

	/**
	 * Visit an {@link Addition} to clone it.
	 * 
	 * @param a
	 *                the {@link Addition} to clone
	 */
	@Override
	public final void visit(final Addition a) {
		Addition newAddition = this.nodeFactory.createAddition();
		this.cloneBinaryExpressionOperands(a, newAddition);
		this.cloneStack.push(newAddition);
	}

	/**
	 * Visit an {@link ArrayLength} to clone it.
	 * 
	 * @param a
	 *                the {@link ArrayLength} to clone
	 */
	@Override
	public final void visit(final ArrayLength a) {
		ArrayLength newArrayLength = this.nodeFactory.createArrayLength();
		a.getOperand().accept(this);
		newArrayLength.setOperand((Expression) this.cloneStack.pop());
		this.cloneStack.push(newArrayLength);
	}

	/**
	 * Visit an {@link ArrayLiteral} to clone it.
	 * 
	 * @param a
	 *                the {@link ArrayLiteral} to clone
	 */
	@Override
	public final void visit(final ArrayLiteral a) {
		ArrayLiteral newArrayLiteral = this.nodeFactory.createArrayLiteral();
		for (Expression e : a.getValues()) {
			e.accept(this);
			newArrayLiteral.getValues().add((Expression) this.cloneStack.pop());
		}
		this.cloneStack.push(newArrayLiteral);
	}

	/**
	 * Visit an {@link Assertion} to clone it.
	 * 
	 * @param a
	 *                the {@link Assertion} to clone
	 */
	@Override
	public final void visit(final Assertion a) {
		Assertion newAnnotation = this.nodeFactory.createAssertion();
		this.cloneAnnotationExpression(a, newAnnotation);
		this.cloneStack.push(newAnnotation);
	}

	/**
	 * Visit an {@link Assignment} to clone it.
	 * 
	 * @param a
	 *                the {@link Assignment} to clone
	 */
	@Override
	public final void visit(final Assignment a) {
		Assignment newAssignment = this.nodeFactory.createAssignment();
		a.getValue().accept(this);
		a.getVariable().accept(this);
		newAssignment.setVariable((VariableReference) this.cloneStack.pop());
		newAssignment.setValue((Expression) this.cloneStack.pop());
		this.cloneStack.push(newAssignment);
	}

	/**
	 * Visit an {@link Assumption} to clone it.
	 * 
	 * @param a
	 *                the {@link Assumption} to clone
	 */
	@Override
	public final void visit(final Assumption a) {
		Assumption newAssumption = this.nodeFactory.createAssumption();
		this.cloneAnnotationExpression(a, newAssumption);
		this.cloneStack.push(newAssumption);
	}

	/**
	 * Visit an {@link Axiom} to clone it.
	 * 
	 * @param a
	 *                the {@link Axiom} to clone
	 */
	@Override
	public final void visit(final Axiom a) {
		Axiom newAxiom = this.nodeFactory.createAxiom();
		this.cloneAnnotationExpression(a, newAxiom);
		this.cloneStack.push(newAxiom);
	}

	/**
	 * Visit a {@link Block} to clone it.
	 * 
	 * @param b
	 *                the {@link Block} to clone
	 */
	@Override
	public final void visit(final Block b) {
		Block newBlock = this.nodeFactory.createBlock();
		for (Statement s : b.getStatements()) {
			s.accept(this);
			newBlock.getStatements().add((Statement) this.cloneStack.pop());
		}
		this.cloneStack.push(newBlock);
	}

	/**
	 * Visit a {@link BooleanLiteral} to clone it.
	 * 
	 * @param b
	 *                the {@link BooleanLiteral} to clone
	 */
	@Override
	public final void visit(final BooleanLiteral b) {
		BooleanLiteral newBooleanLiteral = this.nodeFactory.createBooleanLiteral();
		newBooleanLiteral.setValue(b.getValue());
		this.cloneStack.push(newBooleanLiteral);
	}

	/**
	 * Visit a {@link BooleanType} to clone it.
	 * 
	 * @param b
	 *                the {@link BooleanType} to clone
	 */
	@Override
	public final void visit(final BooleanType b) {
		BooleanType newBooleanType = this.nodeFactory.createBooleanType();
		this.cloneStack.push(newBooleanType);
	}

	/**
	 * Visit a {@link Conditional} to clone it.
	 * 
	 * @param c
	 *                the {@link Conditional} to clone
	 */
	@Override
	public final void visit(final Conditional c) {
		Conditional newConditional = this.nodeFactory.createConditional();
		c.getCondition().accept(this);
		newConditional.setCondition((Expression) this.cloneStack.pop());
		c.getTrueBlock().accept(this);
		newConditional.setTrueBlock((Block) this.cloneStack.pop());
		c.getFalseBlock().accept(this);
		newConditional.setFalseBlock((Block) this.cloneStack.pop());
		this.cloneStack.push(newConditional);
	}

	/**
	 * Visit a {@link Conjunction} to clone it.
	 * 
	 * @param c
	 *                the {@link Conjunction} to clone
	 */
	@Override
	public final void visit(final Conjunction c) {
		Conjunction newConjunction = this.nodeFactory.createConjunction();
		this.cloneBinaryExpressionOperands(c, newConjunction);
		this.cloneStack.push(newConjunction);
	}

	/**
	 * Visit a {@link Disjunction} to clone it.
	 * 
	 * @param d
	 *                the {@link Disjunction} to clone
	 */
	@Override
	public final void visit(final Disjunction d) {
		Disjunction newDisjunction = this.nodeFactory.createDisjunction();
		this.cloneBinaryExpressionOperands(d, newDisjunction);
		this.cloneStack.push(newDisjunction);
	}

	/**
	 * Visit a {@link Division} to clone it.
	 * 
	 * @param d
	 *                the {@link Division} to clone
	 */
	@Override
	public final void visit(final Division d) {
		Division newDivision = this.nodeFactory.createDivision();
		this.cloneBinaryExpressionOperands(d, newDivision);
		this.cloneStack.push(newDivision);
	}

	/**
	 * Visit a {@link Equal} to clone it.
	 * 
	 * @param e
	 *                the {@link Equal} to clone
	 */
	@Override
	public final void visit(final Equal e) {
		Equal newEqual = this.nodeFactory.createEqual();
		this.cloneBinaryExpressionOperands(e, newEqual);
		this.cloneStack.push(newEqual);
	}

	/**
	 * Visit a {@link Greater} to clone it.
	 * 
	 * @param g
	 *                the {@link Greater} to clone
	 */
	@Override
	public final void visit(final Greater g) {
		Greater newGreater = this.nodeFactory.createGreater();
		this.cloneBinaryExpressionOperands(g, newGreater);
		this.cloneStack.push(newGreater);
	}

	/**
	 * Visit a {@link GreaterOrEqual} to clone it.
	 * 
	 * @param g
	 *                the {@link GreaterOrEqual} to clone
	 */
	@Override
	public final void visit(final GreaterOrEqual g) {
		GreaterOrEqual newGreaterOrEqual = this.nodeFactory.createGreaterOrEqual();
		this.cloneBinaryExpressionOperands(g, newGreaterOrEqual);
		this.cloneStack.push(newGreaterOrEqual);
	}

	/**
	 * Visit a {@link Implication} to clone it.
	 * 
	 * @param i
	 *                the {@link Implication} to clone
	 */
	@Override
	public final void visit(final Implication i) {
		Implication newImplication = this.nodeFactory.createImplication();
		this.cloneBinaryExpressionOperands(i, newImplication);
		this.cloneStack.push(newImplication);
	}

	/**
	 * Visit a {@link IntegerLiteral} to clone it.
	 * 
	 * @param i
	 *                the {@link IntegerLiteral} to clone
	 */
	@Override
	public final void visit(final IntegerLiteral i) {
		IntegerLiteral newIntegerLiteral = this.nodeFactory.createIntegerLiteral();
		newIntegerLiteral.setValue(new BigInteger(i.getValue().toString()));
		this.cloneStack.push(newIntegerLiteral);
	}

	/**
	 * Visit a {@link IntegerType} to clone it.
	 * 
	 * @param i
	 *                the {@link IntegerType} to clone
	 */
	@Override
	public final void visit(final IntegerType i) {
		this.cloneStack.push(this.nodeFactory.createIntegerType());
	}

	/**
	 * Visit a {@link Invariant} to clone it.
	 * 
	 * @param i
	 *                the {@link Invariant} to clone
	 */
	@Override
	public final void visit(final Invariant i) {
		Invariant newInvariant = this.nodeFactory.createInvariant();
		this.cloneAnnotationExpression(i, newInvariant);
		this.cloneStack.push(newInvariant);
	}

	/**
	 * Visit a {@link Less} to clone it.
	 * 
	 * @param l
	 *                the {@link Less} to clone
	 */
	@Override
	public final void visit(final Less l) {
		Less newLess = this.nodeFactory.createLess();
		this.cloneBinaryExpressionOperands(l, newLess);
		this.cloneStack.push(newLess);
	}

	/**
	 * Visit a {@link LessOrEqual} to clone it.
	 * 
	 * @param l
	 *                the {@link LessOrEqual} to clone
	 */
	@Override
	public final void visit(final LessOrEqual l) {
		LessOrEqual newLessOrEqual = this.nodeFactory.createLessOrEqual();
		this.cloneBinaryExpressionOperands(l, newLessOrEqual);
		this.cloneStack.push(newLessOrEqual);
	}

	/**
	 * Visit a {@link Loop} to clone it.
	 * 
	 * @param l
	 *                the {@link Loop} to clone
	 */
	@Override
	public final void visit(final Loop l) {
		Loop newLoop = this.nodeFactory.createLoop();
		l.getCondition().accept(this);
		newLoop.setCondition((Expression) this.cloneStack.pop());
		l.getBody().accept(this);
		newLoop.setBody((Block) this.cloneStack.pop());
		this.cloneStack.push(newLoop);
	}

	/**
	 * Visit a {@link Minus} to clone it.
	 * 
	 * @param m
	 *                the {@link Minus} to clone
	 */
	@Override
	public final void visit(final Minus m) {
		Minus newMinus = this.nodeFactory.createMinus();
		this.cloneUnaryExpressionOperand(m, newMinus);
		this.cloneStack.push(newMinus);
	}

	/**
	 * Visit a {@link Modulus} to clone it.
	 * 
	 * @param m
	 *                the {@link Modulus} to clone
	 */
	@Override
	public final void visit(final Modulus m) {
		Modulus newModulus = this.nodeFactory.createModulus();
		this.cloneBinaryExpressionOperands(m, newModulus);
		this.cloneStack.push(newModulus);
	}

	/**
	 * Visit a {@link Multiplication} to clone it.
	 * 
	 * @param m
	 *                the {@link Multiplication} to clone
	 */
	@Override
	public final void visit(final Multiplication m) {
		Multiplication newMultiplication = this.nodeFactory.createMultiplication();
		this.cloneBinaryExpressionOperands(m, newMultiplication);
		this.cloneStack.push(newMultiplication);
	}

	/**
	 * Visit a {@link Negation} to clone it.
	 * 
	 * @param n
	 *                the {@link Negation} to clone
	 */
	@Override
	public final void visit(final Negation n) {
		Negation newNegation = this.nodeFactory.createNegation();
		this.cloneUnaryExpressionOperand(n, newNegation);
		this.cloneStack.push(newNegation);
	}

	/**
	 * Visit a {@link Plus} to clone it.
	 * 
	 * @param p
	 *                the {@link Plus} to clone
	 */
	@Override
	public final void visit(final Plus p) {
		Plus newPlus = this.nodeFactory.createPlus();
		this.cloneUnaryExpressionOperand(p, newPlus);
		this.cloneStack.push(newPlus);
	}

	/**
	 * Visit a {@link Postcondition} to clone it.
	 * 
	 * @param p
	 *                the {@link Postcondition} to clone
	 */
	@Override
	public final void visit(final Postcondition p) {
		Postcondition newPostcondition = this.nodeFactory.createPostcondition();
		this.cloneAnnotationExpression(p, newPostcondition);
		this.cloneStack.push(newPostcondition);
	}

	/**
	 * Visit a {@link Precondition} to clone it.
	 * 
	 * @param p
	 *                the {@link Precondition} to clone
	 */
	@Override
	public final void visit(final Precondition p) {
		Precondition newPrecondition = this.nodeFactory.createPrecondition();
		this.cloneAnnotationExpression(p, newPrecondition);
		this.cloneStack.push(newPrecondition);
	}

	/**
	 * Visit a {@link Program} to clone it.
	 * 
	 * @param p
	 *                the {@link Program} to clone
	 */
	@Override
	public final void visit(final Program p) {
		Program newProgram = this.nodeFactory.createProgram();
		p.getMainBlock().accept(this);
		newProgram.setMainBlock((Block) this.cloneStack.pop());
		// FIXME: also clone axioms
		this.cloneStack.push(newProgram);
	}

	/**
	 * Visit a {@link ReturnStatement} to clone it.
	 * 
	 * @param r
	 *                the {@link ReturnStatement} to clone
	 */
	@Override
	public final void visit(final ReturnStatement r) {
		ReturnStatement newReturnStatement = this.nodeFactory.createReturnStatement();
		r.getReturnValue().accept(this);
		newReturnStatement.setReturnValue((Expression) this.cloneStack.pop());
		this.cloneStack.push(newReturnStatement);
	}

	/**
	 * Visit a {@link Subtraction} to clone it.
	 * 
	 * @param s
	 *                the {@link Subtraction} to clone
	 */
	@Override
	public final void visit(final Subtraction s) {
		Subtraction newSubtraction = this.nodeFactory.createSubtraction();
		this.cloneBinaryExpressionOperands(s, newSubtraction);
		this.cloneStack.push(newSubtraction);
	}

	/**
	 * Visit a {@link Unequal} to clone it.
	 * 
	 * @param u
	 *                the {@link Unequal} to clone
	 */
	@Override
	public final void visit(final Unequal u) {
		Unequal newUnequal = this.nodeFactory.createUnequal();
		this.cloneBinaryExpressionOperands(u, newUnequal);
		this.cloneStack.push(newUnequal);
	}

	/**
	 * Visit a {@link VariableDeclaration} to clone it.
	 * 
	 * @param v
	 *                the {@link VariableDeclaration} to clone
	 */
	@Override
	public final void visit(final VariableDeclaration v) {
		VariableDeclaration newVariableDeclaration = this.nodeFactory.createVariableDeclaration();
		v.getType().accept(this);
		newVariableDeclaration.setType((Type) this.cloneStack.pop());
		newVariableDeclaration.setName(new String(v.getName()));
		v.getInitialValue().accept(this);
		newVariableDeclaration.setInitialValue((Expression) this.cloneStack.pop());
		this.cloneStack.push(newVariableDeclaration);
	}

	/**
	 * Visit a {@link VariableReference} to clone it.
	 * 
	 * @param v
	 *                the {@link VariableReference} to clone
	 */
	@Override
	public final void visit(final VariableReference v) {
		VariableReference newVariableReference = this.nodeFactory.createVariableReference();
		newVariableReference.setVariable(v.getVariable());
		if (v.getIndex() != null) {
			v.getIndex().accept(this);
			newVariableReference.setIndex((Expression) this.cloneStack.pop());
		}
		this.cloneStack.push(newVariableReference);
	}
}