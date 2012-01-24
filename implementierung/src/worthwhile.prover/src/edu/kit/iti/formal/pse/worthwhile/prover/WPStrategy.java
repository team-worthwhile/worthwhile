package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
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
	 * The postcondition when visitor is inside an {@link FunctionDeclaration}.
	 */
	private Expression postcondition;

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
		return this.weakestPreconditionStack.peek();
	}

	/**
	 * @param program
	 *                the {@link Program} to calculate the weakest precondition for
	 * @return the weakest precondition that implies the correctness of <code>program</code>
	 * @see FormulaGenerator#transformProgram(Program program)
	 */
	@Override
	public Expression transformProgram(final Program program) {
		// initialize the weakest precondition of the main block to true
		BooleanLiteral trueLiteral = AstFactory.init().createBooleanLiteral();
		trueLiteral.setValue(true);
		return this.transformProgram(program, trueLiteral);
	}

	/**
	 * Transform the weakest precondition for a given program so that the given postcondition holds.
	 * 
	 * @param program the {@link Program} to transform
	 * @param postcondition the postcondition that the weakest precondition should be calculated for
	 * @return the calculated weakest precondition
	 */
	private Expression transformProgram(final Program program, final Expression postcondition) {
		// clear weakestPrecondition state from a previous transformation
		this.weakestPreconditionStack.clear();
		this.weakestPreconditionStack.push(postcondition);
		program.accept(this);
		return this.getWeakestPrecondition();
	}

	/**
	 * Visit a {@link Assertion}.
	 * 
	 * @param assertion
	 *                the {@link Assertion} to visit
	 */
	@Override
	public void visit(final Assertion assertion) {
		Conjunction conjunction = AstFactory.init().createConjunction();
		conjunction.setRight(this.weakestPreconditionStack.pop());
		conjunction.setLeft(AstNodeCloneHelper.clone(assertion.getExpression()));
		this.weakestPreconditionStack.push(conjunction);
	}

	/**
	 * Visit a {@link Assignment} to generate the weakest precondition.
	 * 
	 * @param assignment
	 *                the {@link Assignment} to visit
	 */
	@Override
	public void visit(final Assignment assignment) {
		final Expression value = assignment.getValue();
		final VariableDeclaration variableDeclaration = assignment.getVariable().getVariable();

		Expression wp = this.weakestPreconditionStack.pop();
		wp = VariableReferenceSubstitution.substitute(wp, variableDeclaration, value);

		this.weakestPreconditionStack.push(wp);
	}

	/**
	 * Visit an {@link Assumption}.
	 * 
	 * <code><pre>
	 * _assume assumption
	 * </pre></code>
	 * 
	 * to
	 * 
	 * <code><pre>
	 * assumption => wp
	 * </pre></code>
	 * 
	 * @param assumption
	 *                the <code>Assumption</code> to visit
	 */
	@Override
	public void visit(final Assumption assumption) {
		Implication implication = AstFactory.init().createImplication();
		implication.setLeft(AstNodeCloneHelper.clone(assumption.getExpression()));
		implication.setRight(this.weakestPreconditionStack.pop());
		this.weakestPreconditionStack.push(implication);
	}

	/**
	 * Visit an {@link Axiom}.
	 * 
	 * <code><pre>
	 * _axiom axiom
	 * </pre></code>
	 * 
	 * to
	 * 
	 * <code><pre>
	 * axiom => wp
	 * </pre></code>
	 * 
	 * @param axiom
	 *                the <code>Axiom</code> to visit
	 */
	@Override
	public void visit(final Axiom axiom) {
		Implication implication = AstFactory.init().createImplication();
		implication.setLeft(AstNodeCloneHelper.clone(axiom.getExpression()));
		implication.setRight(this.weakestPreconditionStack.pop());
		this.weakestPreconditionStack.push(implication);
	}

	/**
	 * Visit a {@link Block} to generate the weakest precondition.
	 * 
	 * @param block
	 *                the {@link Block} to visit
	 */
	@Override
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
	@Override
	public void visit(final Conditional conditional) {
		// the updated weakest precondition
		Conjunction conjunction = AstFactory.init().createConjunction();

		// build first implication: condition => wp(if-block, wp)
		Implication implication = AstFactory.init().createImplication();
		implication.setLeft(AstNodeCloneHelper.clone(conditional.getCondition()));

		Expression wp = this.weakestPreconditionStack.peek();

		// will calculate new wp for if-block and replace wp on top of stack with it
		conditional.getTrueBlock().accept(this);
		implication.setRight(this.weakestPreconditionStack.pop());

		conjunction.setLeft(implication);

		// build second implication: !condition => wp(else-block, wp)
		implication = AstFactory.init().createImplication();
		Negation negation = AstFactory.init().createNegation();
		negation.setOperand(AstNodeCloneHelper.clone(conditional.getCondition()));
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
	@Override
	public void visit(final FunctionDeclaration functionDeclaration) {
		// the factory used to create ASTNodes in the following
		AstFactory model = AstFactory.init();

		BooleanLiteral trueLiteral = model.createBooleanLiteral();
		trueLiteral.setValue(true);

		List<List<? extends Annotation>> lists = new ArrayList<List<? extends Annotation>>();
		lists.add(functionDeclaration.getPreconditions());
		lists.add(functionDeclaration.getPostconditions());

		for (List<? extends Annotation> l : lists) {
			if (l.isEmpty()) {
				this.weakestPreconditionStack.push(AstNodeCloneHelper.clone(trueLiteral));
			} else {
				Expression conjunction;

				Iterator<? extends Annotation> i = l.iterator();
				conjunction = AstNodeCloneHelper.clone(i.next().getExpression());
				while (i.hasNext()) {
					Conjunction c = model.createConjunction();
					c.setLeft(conjunction);
					c.setRight(AstNodeCloneHelper.clone(i.next().getExpression()));
					conjunction = c;
				}

				this.weakestPreconditionStack.push(conjunction);
			}
		}

		this.postcondition = this.weakestPreconditionStack.peek();

		// postconditions conjunction is on top of weakestPreconditionStack
		functionDeclaration.getBody().accept(this);

		this.postcondition = null;

		// build the weakest precondition for this function: preconditions => wp(body, postconditions)
		Implication implication = model.createImplication();

		// pops body weakest precondition wp(body, postconditions)
		implication.setRight(this.weakestPreconditionStack.pop());

		// pops preconditions conjunction
		implication.setLeft(this.weakestPreconditionStack.pop());

		Expression wp = implication;

		final FreshVariableSetVisitor freshVariableSet = new FreshVariableSetVisitor();
		wp.accept(freshVariableSet);

		for (final VariableDeclaration v : freshVariableSet.getVariableMap().values()) {
			ForAllQuantifier forall = model.createForAllQuantifier();
			forall.setParameter(v);
			forall.setExpression(wp);
			wp = forall;
		}
		this.weakestPreconditionStack.push(wp);
	}

	/**
	 * Visit a {@link Loop} to generate the weakest precondition.
	 * 
	 * @param loop
	 *                the {@link Loop} to visit
	 */
	@Override
	public void visit(final Loop loop) {
		AstFactory factory = AstFactory.init();

		Expression invariant = null;
		for (Invariant i : loop.getInvariants()) {
			// and the new invariant with the existing if needed
			if (invariant == null) {
				invariant = i.getExpression();
			} else {
				Conjunction conj = factory.createConjunction();
				conj.setLeft(invariant);
				conj.setRight(i.getExpression());
				invariant = conj;
			}
		}

		// (condition and invariant) implies wp(body, invariant)
		Conjunction conditionAndInvariant = factory.createConjunction();
		conditionAndInvariant.setLeft(AstNodeCloneHelper.clone(loop.getCondition()));
		conditionAndInvariant.setRight(AstNodeCloneHelper.clone(invariant));

		// generate weakest precondition for the body given the invariant as the postcondition
		// we have to copy the invariant because what happens inside the loop should not be reflected outside of
		// it
		this.weakestPreconditionStack.push(AstNodeCloneHelper.clone(invariant));
		loop.getBody().accept(this);
		Expression bodyPrecondition = this.weakestPreconditionStack.pop();

		Implication conditionAndInvariantImpliesBodyPrecondition = factory.createImplication();
		conditionAndInvariantImpliesBodyPrecondition.setLeft(conditionAndInvariant);
		conditionAndInvariantImpliesBodyPrecondition.setRight(AstNodeCloneHelper.clone(bodyPrecondition));

		// ((not condition) and invariant) implies postcondition
		Negation notCondition = factory.createNegation();
		notCondition.setOperand(AstNodeCloneHelper.clone(loop.getCondition()));

		Conjunction notConditionAndInvariant = factory.createConjunction();
		notConditionAndInvariant.setLeft(notCondition);
		notConditionAndInvariant.setRight(AstNodeCloneHelper.clone(invariant));

		Implication notConditionAndInvariantImpliesPostcondition = factory.createImplication();
		notConditionAndInvariantImpliesPostcondition.setLeft(notConditionAndInvariant);
		notConditionAndInvariantImpliesPostcondition.setRight(this.getWeakestPrecondition());

		/*
		 * the two implications have to be true for all values of all referenced variables because we don't look
		 * inside the loop body. Therefore, we have to choose a fresh set of VariableDeclarations and modify the
		 * expression so that it has to hold for all possible values of these new variables
		 */
		FreshVariableSetVisitor refreshVisitor = new FreshVariableSetVisitor();
		conditionAndInvariantImpliesBodyPrecondition.accept(refreshVisitor);

		Expression forAllValuesConditionAndInvariantImpliesBodyPrecondition = conditionAndInvariantImpliesBodyPrecondition;
		for (VariableDeclaration newDeclaration : refreshVisitor.getVariableMap().values()) {
			QuantifiedExpression forAllValuesOfNewDeclaration = factory.createForAllQuantifier();
			forAllValuesOfNewDeclaration.setParameter(newDeclaration);
			forAllValuesOfNewDeclaration
			                .setExpression(forAllValuesConditionAndInvariantImpliesBodyPrecondition);
			forAllValuesConditionAndInvariantImpliesBodyPrecondition = forAllValuesOfNewDeclaration;
		}

		// TODO: figure out a way to remove this copy-paste from above
		refreshVisitor = new FreshVariableSetVisitor();
		notConditionAndInvariantImpliesPostcondition.accept(refreshVisitor);

		Expression forAllValuesNotConditionAndInvariantImpliesPostcondition = notConditionAndInvariantImpliesPostcondition;
		for (VariableDeclaration newDeclaration : refreshVisitor.getVariableMap().values()) {
			QuantifiedExpression forAllValuesOfNewDeclaration = factory.createForAllQuantifier();
			forAllValuesOfNewDeclaration.setParameter(newDeclaration);
			forAllValuesOfNewDeclaration
			                .setExpression(forAllValuesNotConditionAndInvariantImpliesPostcondition);
			forAllValuesNotConditionAndInvariantImpliesPostcondition = forAllValuesOfNewDeclaration;
		}

		// assemble the weakest precondition from the three conditions
		Conjunction invariantAndConditionTrueCase = factory.createConjunction();
		invariantAndConditionTrueCase.setLeft(AstNodeCloneHelper.clone(invariant));
		invariantAndConditionTrueCase.setRight(forAllValuesConditionAndInvariantImpliesBodyPrecondition);

		Conjunction loopPrecondition = factory.createConjunction();
		loopPrecondition.setLeft(invariantAndConditionTrueCase);
		loopPrecondition.setRight(forAllValuesNotConditionAndInvariantImpliesPostcondition);

		// replace the weakest precondition on the stack
		this.weakestPreconditionStack.pop();
		this.weakestPreconditionStack.push(loopPrecondition);
	}

	/**
	 * Visit a {@link Program} to generate the weakest precondition.
	 * 
	 * @param program
	 *                the {@link Program} to visit
	 */
	@Override
	public void visit(final Program program) {
		// if there are FunctionDeclarations specified this will hold a conjunction of the function bodies' and
		// main block's weakest preconditions, otherwise the program's weakest precondition will consist of the
		// main block's one, which is always defined, only
		Conjunction conjunction = null;

		/*
		 * pass us as visitor from statement to statement in function body or main block:
		 * 
		 * 1. get the weakest precondition, 2. apply the appropriate calculus rule, 3. set the weakest
		 * precondition, 4. forward us to the next statement
		 * 
		 * finally the weakest precondition implies the correctness of the function body or main block
		 */

		for (FunctionDeclaration f : program.getFunctionDeclarations()) {
			if (conjunction == null) {
				conjunction = AstFactory.init().createConjunction();
			}

			// visit function declaration, pushes its weakest precondition on top (does not replace)
			f.accept(this);

			// add function declaration's weakest precondition to program's weakest precondition
			Conjunction c = AstFactory.init().createConjunction();
			c.setLeft(this.weakestPreconditionStack.pop());
			conjunction.setRight(c);
			conjunction = c;
		}

		// visit program's main block
		program.getMainBlock().accept(this);

		// add main block's weakest precondition to program's weakest precondition
		if (conjunction != null) {
			conjunction.setRight(this.weakestPreconditionStack.pop());
			this.weakestPreconditionStack.push(conjunction);
		}

		// assume axioms for the function bodies' and main block's weakest preconditions
		for (Axiom a : program.getAxioms()) {
			a.accept(this);
		}
	}

	/**
	 * Visit a {@link ReturnStatement}.
	 * 
	 * @param returnStatement
	 *                the {@link ReturnStatement} to visit
	 */
	@Override
	public void visit(final ReturnStatement returnStatement) {
		final Expression returnValue = returnStatement.getReturnValue();

		this.weakestPreconditionStack.pop();

		Expression postcondition = AstNodeCloneHelper.clone(this.postcondition);
		postcondition = ReturnValueReferenceSubstitution.substitute(postcondition, returnValue);

		this.weakestPreconditionStack.push(postcondition);
	}

	/**
	 * Visit a {@link VariableDeclaration} to generate the weakest precondition.
	 * 
	 * @param variableDeclaration
	 *                the {@link VariableDeclaration} to visit
	 */
	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		// TODO treat missing initial value
		final Expression initialValue = variableDeclaration.getInitialValue();

		Expression wp = this.weakestPreconditionStack.pop();
		wp = VariableReferenceSubstitution.substitute(wp, variableDeclaration, initialValue);

		this.weakestPreconditionStack.push(wp);
	}
}