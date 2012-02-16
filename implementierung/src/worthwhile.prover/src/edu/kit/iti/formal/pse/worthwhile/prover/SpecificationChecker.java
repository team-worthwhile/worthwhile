package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;

/**
 * Facade class for the {@link edu.kit.iti.formal.pse.worthwhile.prover} package.
 */
public class SpecificationChecker {
	/**
	 * Time delta in seconds after which a prover call times out.
	 * 
	 * Defaults to zero.
	 */
	private Integer timeout = 1;

	/**
	 * @return the timeout
	 */
	public final Integer getTimeout() {
		return this.timeout;
	}

	/**
	 * @param timeout
	 *                the timeout to set, minimum 1
	 */
	public final void setTimeout(final Integer timeout) {
		if (timeout > 0) {
			this.timeout = timeout;
		} else {
			this.timeout = 1;
		}
	}

	/**
	 * The {@link ProverCaller} that is called for checking the satisfiability of formulae.
	 * 
	 * Defaults to {@link Z3Prover} instance.
	 */
	private ProverCaller prover;

	/**
	 * @return the {@link ProverCaller} that is called for checking the satisfiability of formulae
	 */
	public final ProverCaller getProver() {
		return this.prover;
	}

	/**
	 * @param prover
	 *                the {@link ProverCaller} that is called for checking the satisfiability of formulae
	 */
	public final void setProver(final ProverCaller prover) {
		this.prover = prover;
	}

	/**
	 * The {@link FormulaGenerator} that is called for generating a formula from a {@link Program}.
	 */
	private FormulaGenerator transformer;

	/**
	 * @return the transformer
	 */
	public final FormulaGenerator getTransformer() {
		return this.transformer;
	}

	/**
	 * @param transformer
	 *                the transformer to set
	 */
	public final void setTransformer(final FormulaGenerator transformer) {
		this.transformer = transformer;
	}

	/**
	 * The result of the last call to {@link prover}.
	 */
	private ProverResult checkResult;

	/**
	 * @return the checkResult
	 */
	public final ProverResult getCheckResult() {
		return this.checkResult;
	}

	/**
	 * The listener that distributes fired events to other event listeners attached to this instance.
	 */
	private final DistributorProverEventListener listener = new DistributorProverEventListener();

	/**
	 * Add an event listener to this instance.
	 * 
	 * @param listener
	 *                the listener to add
	 * @return true if adding the listener succeeded, else false
	 */
	public final boolean addProverEventListener(final IProverEventListener listener) {
		return this.listener.addProverEventListener(listener);
	}

	/**
	 * Remove an event listener to this instance.
	 * 
	 * @param listener
	 *                the listener to remove
	 * @return true if removing the listener succeeded, else false
	 */
	public final boolean removeProverEventListener(final IProverEventListener listener) {
		return this.listener.removeProverEventListener(listener);
	}

	/**
	 * Uses {@link WPStrategy} as {@link SpecificationChecker#transformer} and {@link Z3Prover} with the default
	 * command line as {@link SpecificationChecker#prover}.
	 */
	public SpecificationChecker() {
		this.transformer = new WPStrategy();
		this.prover = new Z3Prover();
	}

	/**
	 * Uses {@link Z3Prover} with the default command line as {@link SpecificationChecker#prover}.
	 * 
	 * @param transformer
	 *                Is called to transform {@link Program}s into formulae.
	 */
	public SpecificationChecker(final FormulaGenerator transformer) {
		this.transformer = transformer;
		this.prover = new Z3Prover();
	}

	/**
	 * Uses {@link WPStrategy} as {@link SpecificationChecker#transformer}.
	 * 
	 * @param prover
	 *                the {@link ProverCaller} that is called for checking the satisfiability of formulae
	 */
	public SpecificationChecker(final ProverCaller prover) {
		this.transformer = new WPStrategy();
		this.prover = prover;
	}

	/**
	 * @param formula
	 *                the {@link Expression} to check
	 * @param environment
	 *                a list of variable values and axioms
	 * @return the {@link Validity} of <code>formula</code> when <code>environment</code> is applied
	 */
	// TODO we need error reporting, return UNKNOWN for now in case of ProverCallerException
	public final Validity checkFormula(final Expression formula, final Map<VariableDeclaration, Value> environment) {
		// TODO apply Worthwhile specific runtime assertions
		// TODO apply axiom list

		Expression environmentExpression = AstNodeCreatorHelper.createTrueLiteral();
		for (VariableDeclaration environmentVariable : environment.keySet()) {
			// create a reference to the variable
			VariableReference variableReference = AstNodeCreatorHelper
			                .createVariableReference(environmentVariable);

			Value variableValue = environment.get(environmentVariable);
			// create the literal that epxresses the value of the symbol
			Literal variableValueLiteral = null;
			// TODO: array symbols
			if (variableValue instanceof BooleanValue) {
				variableValueLiteral = AstNodeCreatorHelper
				                .createBooleanLiteral(((BooleanValue) variableValue).getValue());
			} else if (variableValue instanceof IntegerValue) {
				variableValueLiteral = AstNodeCreatorHelper
				                .createIntegerLiteral(((IntegerValue) variableValue).getValue());
			}

			// create the ref = literal expression
			Equal equal = AstNodeCreatorHelper.createEqual(variableReference, variableValueLiteral);

			// conjunctively add the equals to the expression expressing the environment
			environmentExpression = AstNodeCreatorHelper.createConjunction(environmentExpression, equal);
		}

		// create the environment => expression implication
		Implication environmentImpliesFormula = AstNodeCreatorHelper.createImplication(environmentExpression,
		                AstNodeCloneHelper.clone(formula));
		return this.checkProgram(AstNodeCreatorHelper.createProgram(AstNodeCreatorHelper
		                .createAssertion(environmentImpliesFormula)));
	}

	/**
	 * Checks a formula's validity and returns the result.
	 * 
	 * @param formula
	 *                the {@link Expression} whose {@link Validity} to determine
	 * @return <code>formula</code>'s {@link Validity}
	 */
	private Validity getValidity(final Expression formula) {
		final Negation negation = AstNodeCreatorHelper.createNegation(formula);

		// let prover check formula and initialize checkResult with the returned result
		/**
		 * Thread that detaches to execute the prover caller.
		 * 
		 * @author Leon Handreke
		 */
		class ProverCallerTask implements Callable<ProverResult> {
			@Override
			public ProverResult call() throws ProverCallerException {
				return SpecificationChecker.this.prover.checkFormula(negation);
			}
		}
		// run the prover caller
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<ProverResult> resultFuture = executor.submit(new ProverCallerTask());
		try {
			this.checkResult = resultFuture.get(this.timeout, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			// timeout - result unknown
			this.checkResult = new ProverResult("timeout") {
				@Override
				public FormulaSatisfiability getSatisfiability() {
					return FormulaSatisfiability.UNKOWN;
				}
			};
		} catch (Exception e) {
			this.checkResult = new ProverResult(e.getMessage()) {
				@Override
				public FormulaSatisfiability getSatisfiability() {
					return FormulaSatisfiability.UNKOWN;
				}
			};
		}
		executor.shutdown();

		// determine formula's validity based on negation's satisfiability, which is VALID only if the latter is
		// UNSATISFIABLE and INVALID only if the latter is SATISFIABLE, UNKNOWN otherwise
		Validity validity = Validity.UNKNOWN;
		if (this.checkResult != null) {
			switch (this.checkResult.getSatisfiability()) {
			case SATISFIABLE:
				validity = Validity.INVALID;
				break;
			case UNSATISFIABLE:
				validity = Validity.VALID;
				break;
			default:
				validity = Validity.UNKNOWN;
			}
		}

		return validity;
	}

	/**
	 * @param program
	 *                the {@link Program} to check
	 * @return the {@link Validity} of <code>program</code>
	 */
	public final Validity checkProgram(final Program program) {
		// TODO apply Worthwhile specific runtime assertions

		// add assertions to check that the divisors are not zero
		program.accept(new DivisionByZeroAssertionInserter());
		program.accept(new ImplicitInitialValueInserter());
		program.accept(new FunctionCallSubstitution());
		// generate formula from program
		List<Proof> provableFormulas = this.transformer.transformProgram(program);
		Validity programValidity = Validity.VALID;
		for (Proof provable : provableFormulas) {
			// get the validity from the prover
			Validity validity = this.getValidity(provable.getExpression());

			// downgrade the "overall validity" if needed
			// if everything up to now was valid, allow downgrade to anything
			if (programValidity == Validity.VALID) {
				programValidity = validity;
			}
			// only allow downgrade from unknown to invalid, no upgrade to valid
			if (programValidity == Validity.UNKNOWN && validity == Validity.INVALID) {
				programValidity = validity;
			}

			// TODO: could this be made more object-oriented by using Proof subclasses?
			// alert the event listeners of the Proof
			if (provable.getImplication() != null) {
				switch (provable.getImplication()) {
				case ASSERTION_VALID:
					this.listener.assertionVerified((Assertion) provable.getRelatedAstNodes()
					                .get(0), validity, provable.getExpression(), this
					                .getCheckResult());
					break;
				case INVARIANT_VALID_AT_ENTRY:
					this.listener.invariantValidAtEntryVerified((Invariant) provable
					                .getRelatedAstNodes().get(0), validity, provable
					                .getExpression(), this.getCheckResult());
					break;
				case INVARIANT_AND_CONDITION_IMPLIES_LOOP_BODY_PRECONDITION:
					this.listener.invariantAndConditionImplyLoopPreconditionVerified(
					                (Loop) provable.getRelatedAstNodes().get(0), validity,
					                provable.getExpression(), this.getCheckResult());
					break;
				case POSTCONDITION_VALID:
					this.listener.postconditionValidVerified((Postcondition) provable
					                .getRelatedAstNodes().get(0), validity, provable
					                .getExpression(), this.getCheckResult());
					break;
				default:
					throw new RuntimeException("Unhandled proof implication type");
				}
			}
		}
		// fire the event listener for the whole verification
		this.listener.programVerified(program, programValidity, null, this.getCheckResult());
		return programValidity;
	}
}
