package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstFactoryImpl;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 * Applies the Weakest Precondition calculus to a {@link Program}.
 */
class WPStrategy extends ASTNodeVisitor implements FormulaGenerator {
	/**
	 * The stack of weakest preconditions that implies the correctness of the remainder {@link Block}.
	 */
	private Stack<Expression> weakestPreconditionStack;

	/**
	 * Construct a new weakest precondition strategy object.
	 */
	public WPStrategy() {
		this.weakestPreconditionStack = new Stack<Expression>();
	}

	/**
	 * @return the weakestPrecondition
	 */
	public Expression getWeakestPrecondition() {
		return this.weakestPreconditionStack.get(0);
	}

	/**
	 * @param program
	 *                the {@link Program} to calculate the weakest precondition for
	 * @return the weakest precondition that implies the correctness of <code>program</code>
	 * @see FormulaGenerator#transformProgram(Program program)
	 */
	public Expression transformProgram(final Program program) {
		// initialize the weakest precondition to true
		BooleanLiteral trueLiteral = AstFactoryImpl.init().createBooleanLiteral();
		trueLiteral.setValue(true);
		this.weakestPreconditionStack.push(trueLiteral);

		/*
		 * pass us as visitor from statement to statement:
		 * 
		 * 1. get the weakest precondition, 2. apply the appropriate calculus rule, 3. set the weakest
		 * precondition, 4. forward us to the next statement
		 * 
		 * finally the weakest precondition implies the correctness of the whole program
		 */
		program.accept(this);

		return this.getWeakestPrecondition();
	}

	/**
	 * Visit a {@link Assertion}.
	 * 
	 * @param assertion
	 *                the {@link Assertion} to visit
	 */
	public void visit(final Assertion assertion) {
		Conjunction conjunction = AstFactoryImpl.init().createConjunction();
		conjunction.setRight(this.weakestPreconditionStack.pop());
		conjunction.setLeft(assertion.getExpression());
		this.weakestPreconditionStack.push(conjunction);
	}

	/**
	 * Visit a {@link Assignment} to generate the weakest precondition.
	 * 
	 * @param assignment
	 *                the {@link Assignment} to visit
	 */
	public void visit(final Assignment assignment) {
		VariableDeclaration variableDeclaration = assignment.getVariable().getVariable();
		this.getWeakestPrecondition().accept(
		                new VariableSubstitution(variableDeclaration, assignment.getValue(),
		                                new VariableSubstitution.SubstituteCommand() {
			                                @Override
			                                void substitute() {
				                                /*
								 * In case the current postcondition only consists of a
								 * VariableReference that has to be replaced, substitute
								 * it directly
								 */
				                                WPStrategy.this.weakestPreconditionStack.pop();
				                                WPStrategy.this.weakestPreconditionStack
				                                                .push(assignment.getValue());
			                                }
		                                }));

	}

	/**
	 * Visit a {@link Assumption}.
	 * 
	 * @param assumption
	 *                the {@link Assumption} to visit
	 */
	public void visit(final Assumption assumption) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link Axiom}.
	 * 
	 * @param axiom
	 *                the {@link Axiom} to visit
	 */
	public void visit(final Axiom axiom) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link Block} to generate the weakest precondition.
	 * 
	 * @param block
	 *                the {@link Block} to visit
	 */
	public void visit(final Block block) {
		// visit all block statements in the order they were parsed reversed
		List<Statement> stmts = new ArrayList<Statement>(block.getStatements());
		Collections.reverse(stmts);
		for (Statement stmt : stmts) {
			stmt.accept(this);
		}
	}

	/**
	 * Visit a {@link Conditional} to generate the weakest precondition.
	 * 
	 * @param conditional
	 *                the {@link Conditional} to visit
	 */
	public void visit(final Conditional conditional) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link FunctionDeclaration}.
	 * 
	 * @param functionDeclaration
	 *                the {@link FunctionDeclaration} to visit
	 */
	public void visit(final FunctionDeclaration functionDeclaration) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit an {@link Invariant}.
	 * 
	 * @param invariant
	 *                the Invariant to visit
	 */
	public void visit(final Invariant invariant) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link Loop} to generate the weakest precondition.
	 * 
	 * @param loop
	 *                the {@link Loop} to visit
	 */
	public void visit(final Loop loop) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link Postcondition}.
	 * 
	 * @param postcondition
	 *                the {@link Postcondition} to visit
	 */
	public void visit(final Postcondition postcondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link Precondition}.
	 * 
	 * @param precondition
	 *                the {@link Precondition} to visit
	 */
	public void visit(final Precondition precondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link Program} to generate the weakest precondition.
	 * 
	 * @param program
	 *                the {@link Program} to visit
	 */
	public void visit(final Program program) {
		// visit program's main block
		program.getMainBlock().accept(this);
	}

	/**
	 * Visit a {@link ReturnStatement}.
	 * 
	 * @param returnStatement
	 *                the {@link ReturnStatement} to visit
	 */
	public void visit(final ReturnStatement returnStatement) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * Visit a {@link VariableDeclaration} to generate the weakest precondition.
	 * 
	 * @param variableDeclaration
	 *                the {@link VariableDeclaration} to visit
	 */
	public void visit(final VariableDeclaration variableDeclaration) {
		this.getWeakestPrecondition().accept(
		                new VariableSubstitution(variableDeclaration, variableDeclaration.getInitialValue(),
		                                new VariableSubstitution.SubstituteCommand() {
			                                @Override
			                                void substitute() {
				                                /*
								 * In case the current postcondition only consists of a
								 * VariableReference that has to be replaced, substitute
								 * it directly
								 */
				                                WPStrategy.this.weakestPreconditionStack.pop();
				                                WPStrategy.this.weakestPreconditionStack
				                                                .push(variableDeclaration
				                                                                .getInitialValue());
			                                }
		                                }));
	}
}