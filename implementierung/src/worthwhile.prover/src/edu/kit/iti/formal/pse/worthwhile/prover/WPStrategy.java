package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Applies the Weakest Precondition calculus to a {@link Program}.
 */
class WPStrategy extends HierarchialASTNodeVisitor implements FormulaGenerator {
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
		// clear weakestPrecondition state from a previous transformation
		this.weakestPreconditionStack.clear();

		// initialize the weakest precondition to true
		BooleanLiteral trueLiteral = AstFactory.init().createBooleanLiteral();
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
		Conjunction conjunction = AstFactory.init().createConjunction();
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
	 * Transforms
	 * 
	 * <pre>
	 * if condition
	 *     if-block
	 * else
	 *     else-block
	 * </pre>
	 * 
	 * to
	 * 
	 * <pre>
	 * condition => wp(if-block, wp) && !condition => wp(else-block, wp)
	 * </pre>
	 * 
	 * If a <code>else-block</code> is missing <code>wp(else-block, wp)</code> is <code>true</code>.
	 * 
	 * @param conditional
	 *                the {@link Conditional} to visit
	 */
	public void visit(final Conditional conditional) {
		// the updated weakest precondition
		Conjunction conjunction = AstFactory.init().createConjunction();

		// build first implication: condition => wp(if-block, wp)
		Implication implication = AstFactory.init().createImplication();
		implication.setLeft(conditional.getCondition());

		Expression wp = this.weakestPreconditionStack.peek();

		// will calculate new wp for if-block and replace wp on top of stack with it
		conditional.getTrueBlock().accept(this);
		implication.setRight(this.weakestPreconditionStack.pop());

		conjunction.setLeft(implication);

		// build second implication: !condition => wp(else-block, wp)
		implication = AstFactory.init().createImplication();
		Negation negation = AstFactory.init().createNegation();
		negation.setOperand(conditional.getCondition());
		implication.setLeft(negation);

		if (conditional.getFalseBlock() != null) {
			this.weakestPreconditionStack.push(wp);

			// will calculate new wp for else-block and replace wp on top of stack with it
			conditional.getFalseBlock().accept(this);
			implication.setRight(this.weakestPreconditionStack.pop());
		} else {
			BooleanLiteral trueLiteral = AstFactory.init().createBooleanLiteral();
			trueLiteral.setValue(true);
			implication.setRight(trueLiteral);
		}

		conjunction.setRight(implication);

		// put updated weakest precondition on top of stack
		this.weakestPreconditionStack.push(conjunction);
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
		AstFactory factory = AstFactory.init();

		// and all the loop invariants
		BooleanLiteral trueLiteral = factory.createBooleanLiteral();
		trueLiteral.setValue(true);
		Expression invariant = trueLiteral;

		for (Invariant i : loop.getInvariants()) {
			Conjunction conj = factory.createConjunction();
			conj.setLeft(invariant);
			conj.setRight(i.getExpression());
			invariant = conj;
		}


		// (condition and invariant) implies wp(body, invariant)
		Conjunction conditionAndInvariant = factory.createConjunction();
		conditionAndInvariant.setLeft(new AstNodeCloneHelper<Expression>().clone(loop.getCondition()));
		conditionAndInvariant.setRight(new AstNodeCloneHelper<Expression>().clone(invariant));

		// generate weakest precondition for the body given the invariant as the postcondition
		this.weakestPreconditionStack.push(invariant);
		loop.getBody().accept(this);
		Expression bodyPrecondition = this.weakestPreconditionStack.pop();

		Implication conditionAndInvariantImpliesBodyPrecondition = factory.createImplication();
		conditionAndInvariantImpliesBodyPrecondition.setLeft(conditionAndInvariant);
		conditionAndInvariantImpliesBodyPrecondition.setRight(new AstNodeCloneHelper<Expression>()
		                .clone(bodyPrecondition));

		// ((not condition) and invariant) implies postcondition
		Negation notCondition = factory.createNegation();
		notCondition.setOperand(new AstNodeCloneHelper<Expression>().clone(loop.getCondition()));

		Conjunction notConditionAndInvariant = factory.createConjunction();
		notConditionAndInvariant.setLeft(notCondition);
		notConditionAndInvariant.setRight(new AstNodeCloneHelper<Expression>().clone(invariant));

		Implication notConditionAndInvariantImpliesPostcondition = factory.createImplication();
		notConditionAndInvariantImpliesPostcondition.setLeft(notConditionAndInvariant);
		notConditionAndInvariantImpliesPostcondition.setRight(this.getWeakestPrecondition());

		// refresh variables
		ASTNodeVisitor refreshVisitor = new FreshVariableSetVisitor();
		conditionAndInvariantImpliesBodyPrecondition.accept(refreshVisitor);
		refreshVisitor = new FreshVariableSetVisitor();
		notConditionAndInvariantImpliesPostcondition.accept(refreshVisitor);

		// assemble the weakest precondition from the three conditions
		Conjunction invariantAndConditionTrueCase = factory.createConjunction();
		invariantAndConditionTrueCase.setLeft(new AstNodeCloneHelper<Expression>().clone(invariant));
		invariantAndConditionTrueCase.setRight(conditionAndInvariantImpliesBodyPrecondition);

		Conjunction loopPrecondition = factory.createConjunction();
		loopPrecondition.setLeft(invariantAndConditionTrueCase);
		loopPrecondition.setRight(notConditionAndInvariantImpliesPostcondition);

		// replace the weakest precondition on the stack
		this.weakestPreconditionStack.pop();
		this.weakestPreconditionStack.push(loopPrecondition);
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