package edu.kit.iti.formal.pse.worthwhile.prover;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Visitor to insert Assertion statements above every {@link Division} to ensure the divisor is not zero.
 * 
 * @author Leon Handreke
 */
public class DivisionByZeroAssertionInserter extends HierarchialASTNodeVisitor {
	/**
	 * Divisors found inside an expression that have to be checked.
	 */
	private final Stack<Set<Expression>> foundDivisorsStack = new Stack<Set<Expression>>();

	@Override
	public final void visit(final Annotation annotation) {
		// we don't do fancy stuff in Annotations - they are directly passed to Z3
		// TODO: If we can do this for quantified expressions, we could actually do this
	}

	@Override
	public final void visit(final Assignment assignment) {
		assignment.getValue().accept(this);
	}

	@Override
	public final void visit(final BinaryExpression binaryExpression) {
		binaryExpression.getLeft().accept(this);
		binaryExpression.getRight().accept(this);
	}

	@Override
	public final void visit(final Block block) {
		/*
		 * initialize a new stack the statement containing this block might contain a division itself that we
		 * want to check for *before* the statement
		 */
		this.foundDivisorsStack.push(new HashSet<Expression>());

		for (int i = 0; i < block.getStatements().size(); i++) {
			Expression divisorCheck = null;
			Statement s = block.getStatements().get(i);
			// find all divisors in the statement
			s.accept(this);
			// go through all of the found divisors
			for (Expression divisor : this.foundDivisorsStack.peek()) {
				// create (not (divisor equals zero))
				IntegerLiteral zero = AstNodeCreatorHelper.createIntegerLiteral(new BigInteger("0"));
				Expression equalsZero = AstNodeCreatorHelper.createEqual(zero,
				                AstNodeCloneHelper.clone(divisor));
				Expression notEqualsZero = AstNodeCreatorHelper.createNegation(equalsZero);
				// add it to the expression to be asserted conjuntively
				if (divisorCheck == null) {
					divisorCheck = notEqualsZero;
				} else {
					divisorCheck = AstNodeCreatorHelper.createConjunction(divisorCheck,
					                notEqualsZero);
				}
			}

			// if divisors were found, add the check expression as an assertion
			if (divisorCheck != null) {
				block.getStatements().add(i, AstNodeCreatorHelper.createAssertion(divisorCheck));
				/*
				 * advance the loop past the statement just read that is now at i + 1 because the
				 * assertion was inserted at index i
				 */
				i++;
			}
			// clear the stack for the next statement
			this.foundDivisorsStack.peek().clear();
		}
		this.foundDivisorsStack.pop();
	}

	@Override
	public final void visit(final Conditional conditional) {
		conditional.getCondition().accept(this);
		conditional.getTrueBlock().accept(this);
		if (conditional.getFalseBlock() != null) {
			conditional.getFalseBlock().accept(this);
		}
	}

	@Override
	public final void visit(final Division division) {
		this.foundDivisorsStack.peek().add(division.getRight());
		division.getLeft().accept(this);
		division.getRight().accept(this);
	}

	@Override
	public final void visit(final Expression expression) {
		// this only happens for quantified expressions that we don't want to visit
		// TODO: maybe visit them too?
		// we'd have to do some heuristics to stop checking bound variables
	}

	@Override
	public final void visit(final FunctionDeclaration functionDeclaration) {
		functionDeclaration.getBody().accept(this);
	}

	@Override
	public final void visit(final Literal literal) {
		// no Division can hide in a literal
	}

	@Override
	public final void visit(final Loop loop) {
		loop.getCondition().accept(this);
		loop.accept(this);
	}

	@Override
	public final void visit(final Program program) {
		program.getMainBlock().accept(this);
		for (FunctionDeclaration d : program.getFunctionDeclarations()) {
			d.accept(this);
		}
	}

	@Override
	public final void visit(final ReturnStatement returnStatement) {
		returnStatement.getReturnValue().accept(this);
	}

	@Override
	public final void visit(final UnaryExpression unaryExpression) {
		unaryExpression.getOperand().accept(this);
	}

	@Override
	public final void visit(final VariableDeclaration variableDeclaration) {
		if (variableDeclaration.getInitialValue() != null) {
			variableDeclaration.getInitialValue().accept(this);
		}
	}
}
