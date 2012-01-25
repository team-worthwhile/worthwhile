package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Map;

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
	private Integer timeout = 0;

	/**
	 * @return the timeout
	 */
	public final Integer getTimeout() {
		return this.timeout;
	}

	/**
	 * @param timeout
	 *            the timeout to set, zero when negative
	 */
	public final void setTimeout(final Integer timeout) {
		if (timeout < 0) {
			this.timeout = 0;
		} else {
			this.timeout = timeout;
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
	 *            the transformer to set
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
	 * Uses {@link WPStrategy} as {@link SpecificationChecker#transformer}.
	 */
	public SpecificationChecker() {
		this.transformer = new WPStrategy();
	}

	/**
	 * @param transformer
	 *            Is called to transform {@link Program}s into formulae.
	 */
	public SpecificationChecker(final FormulaGenerator transformer) {
		this.transformer = transformer;
	}

	/**
	 * @param formula
	 *            the {@link Expression} to check
	 * @param environment
	 *            a list of variable values and axioms
	 * @return the {@link Validity} of <code>formula</code> when <code>environment</code> is applied
	 */
	// TODO we need error reporting, return UNKNOWN for now in case of ProverCallerException
	public final Validity checkFormula(final Expression formula, final Map<VariableDeclaration, Value> environment) {
		// TODO apply Worthwhile specific runtime assertions
		// TODO apply axiom list

		Expression environmentExpression = AstNodeCreatorHelper.createTrueLiteral();
		for (VariableDeclaration environmentVariable : environment.keySet()) {
			// create a reference to the variable
			VariableReference variableReference = AstNodeCreatorHelper.createVariableReference(environmentVariable);

			Value variableValue = environment.get(environmentVariable);
			// create the literal that epxresses the value of the symbol
			Literal variableValueLiteral = null;
			// TODO: array symbols
			if (variableValue instanceof BooleanValue) {
				variableValueLiteral = AstNodeCreatorHelper.createBooleanLiteral(((BooleanValue) variableValue).getValue());
			} else if (variableValue instanceof IntegerValue) {
				variableValueLiteral = AstNodeCreatorHelper.createIntegerLiteral(((IntegerValue) variableValue).getValue());
			}

			// create the ref = literal expression
			Equal equal = AstNodeCreatorHelper.createEqual(variableReference, variableValueLiteral);

			// conjunctively add the equals to the expression expressing the environment
			environmentExpression = AstNodeCreatorHelper.createConjunction(environmentExpression, equal);
		}

		// create the environment => expression implication
		Implication environmentImpliesFormula = AstNodeCreatorHelper.createImplication(environmentExpression, formula);
		return getValidity(environmentImpliesFormula);
	}

	/**
	 * Checks a formula's validity and returns the result.
	 * 
	 * @param formula
	 *            the {@link Expression} whose {@link Validity} to determine
	 * @return <code>formula</code>'s {@link Validity}
	 */
	private Validity getValidity(final Expression formula) {
		Negation negation = AstNodeCreatorHelper.createNegation(formula);

		// let prover check formula and initialize checkResult with the returned result
		try {
			this.checkResult = this.prover.checkFormula(negation);
		} catch (ProverCallerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Validity.UNKNOWN;
		}

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
	 *            the {@link Program} to check
	 * @return the {@link Validity} of <code>program</code>
	 */
	public final Validity checkProgram(final Program program) {
		// TODO apply Worthwhile specific runtime assertions

		// generate formula from program
		Expression formula = this.transformer.transformProgram(program);

		return this.getValidity(formula);
	}
}