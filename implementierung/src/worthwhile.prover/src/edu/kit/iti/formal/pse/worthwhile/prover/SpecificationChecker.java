package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
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
	private ProverCaller prover = new Z3Prover();

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
	 * Uses {@link WPStrategy} as {@link SpecificationChecker#transformer}.
	 */
	public SpecificationChecker() {
		this.transformer = new WPStrategy();
	}

	/**
	 * @param transformer
	 *                Is called to transform {@link Program}s into formulae.
	 */
	public SpecificationChecker(final FormulaGenerator transformer) {
		this.transformer = transformer;
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
		} catch (InterruptedException e) {
			// don't care
			e.printStackTrace();
		} catch (ExecutionException e) {
			// what could possibly go wrong?
			e.printStackTrace();
		} catch (TimeoutException e) {
			// timeout - result unknown
			this.checkResult = new ProverResult("timeout") {
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

		return validity;
	}

	/**
	 * @param program
	 *                the {@link Program} to check
	 * @return the {@link Validity} of <code>program</code>
	 */
	public final Validity checkProgram(final Program program) {
		// TODO apply Worthwhile specific runtime assertions

		// we don't want to pollute the o
		Program modifiedProgram = AstNodeCloneHelper.clone(program);
		// add assertions to check that the divisors are not zero
		DivisionByZeroAssertionInserter divisionByZeroAssertionInserter = new DivisionByZeroAssertionInserter();
		modifiedProgram.accept(divisionByZeroAssertionInserter);
		modifiedProgram.accept(new ImplicitInitialValueInserter());
		modifiedProgram.accept(new FunctionCallSubstitution());
		// generate formula from program
		Expression formula = this.transformer.transformProgram(modifiedProgram);
		// get the validity from the prover
		Validity validity = this.getValidity(formula);
		// fire the event listener
		this.listener.programVerified(program, validity, this.getCheckResult());
		return validity;
	}
}