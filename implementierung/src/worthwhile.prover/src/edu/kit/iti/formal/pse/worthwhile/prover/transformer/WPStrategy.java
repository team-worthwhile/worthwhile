package edu.kit.iti.formal.pse.worthwhile.prover.transformer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.AssignedVariableFinderVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ReturnValueReferenceSubstitution;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VariableDeclarationSubstitutionVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VariableReferenceSubstitution;

/**
 * Applies the Weakest Precondition calculus to a {@link Program}.
 */
public class WPStrategy extends HierarchialASTNodeVisitor implements FormulaGenerator {
	/**
	 * The stack of weakest preconditions that implies the correctness of the remainder {@link Block}.
	 */
	private Stack<List<Proof>> weakestPreconditionStack;

	/**
	 * The postcondition when visitor is inside an {@link FunctionDeclaration}. This is needed because the original
	 * postcondition may be needed again while proving a function, e.g. when a return statement occurs
	 */
	private List<Proof> currentFunctionPostcondition;

	/**
	 * Construct a new weakest precondition strategy object.
	 */
	public WPStrategy() {
		this.weakestPreconditionStack = new Stack<List<Proof>>();
	}

	/**
	 * @param program
	 *                the {@link Program} to calculate the weakest precondition for
	 * @return the weakest precondition that implies the correctness of <code>program</code>
	 * @see FormulaGenerator#transformProgram(Program program)
	 */
	@Override
	public List<Proof> transformProgram(final Program program) {
		// clear weakestPrecondition state from a previous transformation
		this.weakestPreconditionStack.clear();
		program.accept(this);
		return this.weakestPreconditionStack.pop();
	}

	/**
	 * Visit a {@link Assertion}.
	 * 
	 * @param assertion
	 *                the {@link Assertion} to visit
	 */
	@Override
	public void visit(final Assertion assertion) {
		// add this assertion to the list of things that have to be proven
		this.weakestPreconditionStack.peek().add(
		                new Proof(AstNodeCloneHelper.clone(assertion.getExpression()),
		                                ProofImplication.ASSERTION_VALID, assertion));
	}

	@Override
	public void visit(final DivisorNotZeroAssertion assertion) {
		this.weakestPreconditionStack.peek().add(
		                new Proof(AstNodeCloneHelper.clone(assertion.getExpression()),
		                                ProofImplication.DIVISOR_NOT_ZERO, assertion.getGuardedNode()));
	}

	@Override
	public void visit(final FunctionCallPreconditionAssertion assertion) {
		this.weakestPreconditionStack.peek().add(
		                new Proof(AstNodeCloneHelper.clone(assertion.getExpression()),
		                                ProofImplication.FUNCTION_CALL_PRECONDITION_VALID, assertion
		                                                .getGuardedNode()));
	}

	/**
	 * Visit a {@link Assignment} to generate the weakest precondition.
	 * 
	 * @param assignment
	 *                the {@link Assignment} to visit
	 */
	@Override
	public void visit(final Assignment assignment) {
		for (Proof condition : this.weakestPreconditionStack.peek()) {
			final Expression value = assignment.getValue();
			final VariableDeclaration variableDeclaration = assignment.getVariable().getVariable();
			// in every provable condition, substitute the variable declaration
			condition.setExpression(VariableReferenceSubstitution.substitute(condition.getExpression(),
			                variableDeclaration, value));
		}
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
		for (Proof condition : this.weakestPreconditionStack.peek()) {
			// add the assumption to every provable expression
			Implication implication = AstNodeCreatorHelper
			                .createImplication(AstNodeCloneHelper.clone(assumption.getExpression()),
			                                condition.getExpression());
			condition.setExpression(implication);
		}
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
		for (Proof condition : this.weakestPreconditionStack.peek()) {
			// add the assumption to every provable expression
			Implication implication = AstNodeCreatorHelper.createImplication(
			                AstNodeCloneHelper.clone(axiom.getExpression()), condition.getExpression());
			condition.setExpression(implication);
		}
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
		List<Proof> preconditionList = new ArrayList<Proof>();
		List<Proof> postconditionList = this.weakestPreconditionStack.pop();
		List<Proof> trueBlockPostconditionList = new ArrayList<Proof>();
		List<Proof> falseBlockPostconditionList = new ArrayList<Proof>();

		// clone the postcondition list because it's bound to be mangled up by substitutions when calculating
		// the preconditions for each of the two blocks.
		for (Proof postcondition : postconditionList) {
			Proof trueProof = postcondition.clone();
			trueProof.setExpression(AstNodeCloneHelper.clone(postcondition.getExpression()));
			trueBlockPostconditionList.add(trueProof);

			Proof falseProof = postcondition.clone();
			falseProof.setExpression(AstNodeCloneHelper.clone(postcondition.getExpression()));
			falseBlockPostconditionList.add(falseProof);
		}

		// calculate weakest precondition so that the true block implies the postcondition
		this.weakestPreconditionStack.push(trueBlockPostconditionList);
		conditional.getTrueBlock().accept(this);
		List<Proof> trueBlockPreconditionList = this.weakestPreconditionStack.pop();

		for (Proof trueBlockPrecondition : trueBlockPreconditionList) {
			// build first implication: condition => wp(if-block, wp)
			Implication conditionImpliesBlockPrecondition = AstNodeCreatorHelper.createImplication(
			                AstNodeCloneHelper.clone(conditional.getCondition()),
			                trueBlockPrecondition.getExpression());
			Proof conditionalPrecondition = trueBlockPrecondition.clone();
			conditionalPrecondition.setExpression(AstNodeCloneHelper
			                .clone(conditionImpliesBlockPrecondition));
			preconditionList.add(conditionalPrecondition);
		}

		// check if the false block even exists
		if (conditional.getFalseBlock() != null) {
			this.weakestPreconditionStack.push(falseBlockPostconditionList);
			// calculate weakest precondition so that false block implies postcondition
			conditional.getFalseBlock().accept(this);
			List<Proof> falseBlockPreconditionList = this.weakestPreconditionStack.pop();

			for (Proof falseBlockPrecondition : falseBlockPreconditionList) {
				// build second implication: !condition => wp(else-block, wp)
				Negation notCondition = AstNodeCreatorHelper.createNegation(AstNodeCloneHelper
				                .clone(conditional.getCondition()));
				Implication notConditionImpliesBlockPrecondition = AstNodeCreatorHelper
				                .createImplication(notCondition, falseBlockPrecondition.getExpression());
				Proof conditionalPrecondition = falseBlockPrecondition.clone();
				conditionalPrecondition.setExpression(notConditionImpliesBlockPrecondition);
				preconditionList.add(conditionalPrecondition);
			}
		} else {
			for (Proof falseBlockPostcondition : falseBlockPostconditionList) {
				// no else block exists, so not the condition should imply the postcondition directly
				Negation notCondition = AstNodeCreatorHelper.createNegation(AstNodeCloneHelper
				                .clone(conditional.getCondition()));
				Implication notConditionImpliesBlockPostcondition = AstNodeCreatorHelper
				                .createImplication(notCondition, AstNodeCloneHelper
				                                .clone(falseBlockPostcondition.getExpression()));
				Proof conditionalPrecondition = falseBlockPostcondition.clone();
				conditionalPrecondition.setExpression(notConditionImpliesBlockPostcondition);
				preconditionList.add(conditionalPrecondition);
			}
		}
		// put updated weakest preconditions for the conjunctions on top of stack
		this.weakestPreconditionStack.push(preconditionList);
	}

	/**
	 * Visit a {@link FunctionDeclaration}.
	 * 
	 * If no {@link Precondition}s (or {@link Postcondition}s) are present <code>true</code> is implicitly inserted.
	 * 
	 * @param functionDeclaration
	 *                the {@link FunctionDeclaration} to visit
	 */
	@Override
	public void visit(final FunctionDeclaration functionDeclaration) {
		// create a single conjuction containing all the ensures
		Expression ensures = AstNodeCreatorHelper.createConjunction(AstNodeCloneHelper
		                .clone(functionDeclaration.getPreconditions()));

		List<Proof> preconditionList = new ArrayList<Proof>();

		// generate a list of Postcondition Proofs that have to be proven
		final List<Postcondition> postconditions = functionDeclaration.getPostconditions();
		List<Proof> postconditionList = new ArrayList<Proof>();
		if (!postconditions.isEmpty()) {
			for (Postcondition functionPostcondition : postconditions) {
				Proof postconditionProof = new Proof(AstNodeCloneHelper.clone(functionPostcondition
				                .getExpression()), ProofImplication.POSTCONDITION_VALID,
				                functionPostcondition);
				postconditionList.add(postconditionProof);
			}
		} else {
			// just to be sure that there is anything to prove, add true as a required postcondition
			postconditionList.add(new Proof(AstNodeCreatorHelper.createTrueLiteral(),
			                ProofImplication.POSTCONDITION_VALID, null));
		}

		// calculate wp(loop block, postcondition) for each of the postconditions in the list
		this.currentFunctionPostcondition = postconditionList;
		// push an empty postcondition because the correct postcondition will be pushed as soon as the
		// first return statement is seen. The postcondition has to hold directly after the return
		// statement only, so saying that "nothing" has to hold at the end of the function is correct
		this.weakestPreconditionStack.add(new ArrayList<Proof>());
		functionDeclaration.getBody().accept(this);
		preconditionList.addAll(this.weakestPreconditionStack.pop());
		this.currentFunctionPostcondition = null;

		for (Proof precondition : preconditionList) {
			// build the weakest precondition for this function: preconditions => wp(body, postconditions)
			precondition.setExpression(AstNodeCreatorHelper.createImplication(
			                AstNodeCloneHelper.clone(ensures), precondition.getExpression()));

			// wrap all the preconditions in forall quantifiers because they have to be true for all
			// parameters of the function
			for (final VariableDeclaration variableToBind : functionDeclaration.getParameters()) {
				VariableDeclaration newDeclaration = AstNodeCloneHelper.clone(variableToBind);
				VariableDeclarationSubstitutionVisitor variableDeclarationSubstitutionVisitor = new VariableDeclarationSubstitutionVisitor(
				                variableToBind, newDeclaration);
				precondition.getExpression().accept(variableDeclarationSubstitutionVisitor);
				ForAllQuantifier forall = AstNodeCreatorHelper.createForAllQuantifier(newDeclaration,
				                precondition.getExpression());
				precondition.setExpression(forall);
			}
		}
		this.weakestPreconditionStack.push(preconditionList);
	}

	/**
	 * Visit a {@link Loop} to generate the weakest precondition.
	 * 
	 * If no {@link Invariant}s are present the invariant <code>true</code> is implicitly inserted.
	 * 
	 * @param loop
	 *                the {@link Loop} to visit
	 */
	@Override
	public void visit(final Loop loop) {
		List<Proof> loopPreconditionList = new ArrayList<Proof>();

		// add all the invariants to the list of weakest preconditions for the loop
		for (Invariant i : loop.getInvariants()) {
			Proof invariantProof = new Proof(AstNodeCloneHelper.clone(i.getExpression()),
			                ProofImplication.INVARIANT_VALID_AT_ENTRY, i);
			loopPreconditionList.add(invariantProof);
		}

		// build a conjunction of all invariants
		Expression invariant = AstNodeCreatorHelper.createConjunction(AstNodeCloneHelper.clone(loop
		                .getInvariants()));

		// (condition and invariant) implies wp(body, invariant)
		Conjunction conditionAndInvariant = AstNodeCreatorHelper.createConjunction(
		                AstNodeCloneHelper.clone(loop.getCondition()), AstNodeCloneHelper.clone(invariant));

		// generate weakest precondition for the body given the invariant as the postcondition
		// we have to copy the invariant because what happens inside the loop should not be reflected outside of
		// it
		List<Proof> onlyInvariantList;
		onlyInvariantList = new ArrayList<Proof>();
		onlyInvariantList.add(new Proof(AstNodeCloneHelper.clone(invariant),
		                ProofImplication.INVARIANT_AND_CONDITION_IMPLIES_LOOP_BODY_PRECONDITION, loop));
		this.weakestPreconditionStack.push(onlyInvariantList);
		loop.getBody().accept(this);

		// find all the variables that were changed in the body
		AssignedVariableFinderVisitor assignedVariableFinder = new AssignedVariableFinderVisitor();
		loop.getBody().accept(assignedVariableFinder);

		// the (condition and invariant) have to imply all the preconditions
		List<Proof> bodyPreconditionList = this.weakestPreconditionStack.pop();
		for (Proof bodyPrecondition : bodyPreconditionList) {
			Implication conditionAndInvariantImpliesBodyPrecondition = AstNodeCreatorHelper
			                .createImplication(AstNodeCloneHelper.clone(conditionAndInvariant),
			                                AstNodeCloneHelper.clone(bodyPrecondition.getExpression()));

			Expression forAllValuesConditionAndInvariantImpliesBodyPrecondition = conditionAndInvariantImpliesBodyPrecondition;
			// replace all the variables to be bound with new instances of VariableDeclaration and bind them
			// with a forall quantifier
			for (VariableDeclaration variableToBind : assignedVariableFinder.getAssignedVariables()) {
				// replace the declaration with a new one as to not interfere with operations happening
				// on the old one
				VariableDeclaration newDeclaration = AstNodeCreatorHelper.createVariableDeclaration(
				                AstNodeCloneHelper.clone(variableToBind.getType()),
				                variableToBind.getName());
				VariableDeclarationSubstitutionVisitor variableDeclarationSubstitutionVisitor = new VariableDeclarationSubstitutionVisitor(
				                variableToBind, newDeclaration);
				forAllValuesConditionAndInvariantImpliesBodyPrecondition.accept(variableDeclarationSubstitutionVisitor);
				// bind the new variable
				QuantifiedExpression forAllValuesOfNewDeclaration = AstNodeCreatorHelper
				                .createForAllQuantifier(newDeclaration,
				                                forAllValuesConditionAndInvariantImpliesBodyPrecondition);
				forAllValuesConditionAndInvariantImpliesBodyPrecondition = forAllValuesOfNewDeclaration;
			}

			bodyPrecondition.setExpression(forAllValuesConditionAndInvariantImpliesBodyPrecondition);
			loopPreconditionList.add(bodyPrecondition);
		}

		// get the list of postconditions for the whole loop from the stack
		List<Proof> loopPostconditionList = this.weakestPreconditionStack.pop();
		for (Proof loopPostcondition : loopPostconditionList) {
			// ((not condition) and invariant) implies postcondition
			Negation notCondition = AstNodeCreatorHelper.createNegation(AstNodeCloneHelper.clone(loop
			                .getCondition()));

			Conjunction notConditionAndInvariant = AstNodeCreatorHelper.createConjunction(notCondition,
			                AstNodeCloneHelper.clone(invariant));

			Implication notConditionAndInvariantImpliesPostcondition = AstNodeCreatorHelper
			                .createImplication(notConditionAndInvariant, loopPostcondition.getExpression());

			// TODO: Figure out a nice way to eliminiate the copy-pasta in the variable binding code
			Expression forAllValuesNotConditionAndInvariantImpliesPostcondition = notConditionAndInvariantImpliesPostcondition;
			for (VariableDeclaration variableToBind : assignedVariableFinder.getAssignedVariables()) {
				// replace the declaration with a new one as to not interfere with operations happening
				// on the old one
				VariableDeclaration newDeclaration = AstNodeCreatorHelper.createVariableDeclaration(
				                AstNodeCloneHelper.clone(variableToBind.getType()),
				                variableToBind.getName());
				VariableDeclarationSubstitutionVisitor variableDeclarationSubstitutionVisitor = new VariableDeclarationSubstitutionVisitor(
				                variableToBind, newDeclaration);
				forAllValuesNotConditionAndInvariantImpliesPostcondition.accept(variableDeclarationSubstitutionVisitor);
				// bind the new variable
				QuantifiedExpression forAllValuesOfNewDeclaration = AstNodeCreatorHelper
				                .createForAllQuantifier(newDeclaration,
				                                forAllValuesNotConditionAndInvariantImpliesPostcondition);
				forAllValuesNotConditionAndInvariantImpliesPostcondition = forAllValuesOfNewDeclaration;
			}

			Proof newPrecondition = loopPostcondition.clone();
			newPrecondition.setExpression(forAllValuesNotConditionAndInvariantImpliesPostcondition);
			loopPreconditionList.add(newPrecondition);
		}
		// replace the weakest precondition on the stack
		this.weakestPreconditionStack.push(loopPreconditionList);
	}

	/**
	 * Visit a {@link Program} to generate the weakest precondition.
	 * 
	 * @param program
	 *                the {@link Program} to visit
	 */
	@Override
	public void visit(final Program program) {
		List<Proof> preconditionList = new ArrayList<Proof>();

		/*
		 * pass us as visitor from statement to statement in function body or main block:
		 * 
		 * 1. get the weakest precondition, 2. apply the appropriate calculus rule, 3. set the weakest
		 * precondition, 4. forward us to the next statement
		 * 
		 * finally the weakest precondition implies the correctness of the function body or main block
		 */

		for (FunctionDeclaration f : program.getFunctionDeclarations()) {
			// visit function declaration, pushes its weakest precondition on top (does not replace)
			f.accept(this);
			preconditionList.addAll(this.weakestPreconditionStack.pop());
		}

		// push the postcondition true to the track
		List<Proof> postconditionList = new ArrayList<Proof>();
		postconditionList.add(new Proof(AstNodeCreatorHelper.createTrueLiteral(), null));
		this.weakestPreconditionStack.push(postconditionList);
		// visit program's main block
		program.getMainBlock().accept(this);

		// merge function precondition list with main program precondition list
		preconditionList.addAll(this.weakestPreconditionStack.pop());
		this.weakestPreconditionStack.push(preconditionList);

		// assume axioms for the function bodies' and main block's weakest preconditions
		for (Axiom a : program.getAxioms()) {
			a.accept(this);
		}

		// build a giant conjunction of all preconditions that implies the correctness of the whole program
		final Iterator<Proof> i = this.weakestPreconditionStack.peek().iterator();
		// at least the initial precondition true for the main block is on the stack
		Expression programConjunction = AstNodeCloneHelper.clone(i.next().getExpression());
		while (i.hasNext()) {
			programConjunction = AstNodeCreatorHelper.createConjunction(programConjunction,
			                AstNodeCloneHelper.clone(i.next().getExpression()));
		}
		this.weakestPreconditionStack.peek().add(
		                new Proof(programConjunction, ProofImplication.PROGRAM_CONFORM, program));
	}

	/**
	 * Visit a {@link ReturnStatement}.
	 * 
	 * @param returnStatement
	 *                the {@link ReturnStatement} to visit
	 */
	@Override
	public void visit(final ReturnStatement returnStatement) {
		// throw away the weakest precondition so far, return "resets" it
		this.weakestPreconditionStack.pop();

		final Expression returnValue = returnStatement.getReturnValue();
		List<Proof> preconditionList = new ArrayList<Proof>();

		for (Proof postcondition : this.currentFunctionPostcondition) {
			Proof substitutedPostcondition = postcondition.clone();
			substitutedPostcondition.setExpression(AstNodeCloneHelper.clone(postcondition.getExpression()));
			substitutedPostcondition.setExpression(ReturnValueReferenceSubstitution.substitute(
			                returnStatement.getFunction(), substitutedPostcondition.getExpression(),
			                returnValue));
			preconditionList.add(substitutedPostcondition);
		}

		this.weakestPreconditionStack.push(preconditionList);
	}

	/**
	 * Visit a {@link VariableDeclaration} to generate the weakest precondition.
	 * 
	 * @param variableDeclaration
	 *                the {@link VariableDeclaration} to visit
	 */
	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		final Expression initialValue = variableDeclaration.getInitialValue();

		List<Proof> preconditionList = new ArrayList<Proof>();
		for (Proof postcondition : this.weakestPreconditionStack.pop()) {
			Expression precondition;
			if (initialValue == null) {
				final VariableDeclaration parameter = AstNodeCloneHelper.clone(variableDeclaration);
				Expression expression = postcondition.getExpression();
				expression = VariableReferenceSubstitution.substitute(expression, variableDeclaration,
				                AstNodeCreatorHelper.createVariableReference(parameter));
				precondition = AstNodeCreatorHelper.createForAllQuantifier(parameter, expression);
			} else {
				precondition = VariableReferenceSubstitution.substitute(postcondition.getExpression(),
				                variableDeclaration, AstNodeCloneHelper.clone(initialValue));
			}
			postcondition.setExpression(precondition);
			preconditionList.add(postcondition);
		}
		this.weakestPreconditionStack.push(preconditionList);
	}
}