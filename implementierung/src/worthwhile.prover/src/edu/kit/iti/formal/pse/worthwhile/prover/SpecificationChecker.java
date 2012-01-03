package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Map;

import edu.kit.iti.formal.pse.worthwhile.interpreter.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Facade class for the {@link prover} package.
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
    public Integer getTimeout() {
	return this.timeout;
    }

    /**
     * @param timeout
     *            the timeout to set, zero when negative
     */
    public void setTimeout(Integer timeout) {
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
    public FormulaGenerator getTransformer() {
	return this.transformer;
    }

    /**
     * @param transformer
     *            the transformer to set
     */
    public void setTransformer(FormulaGenerator transformer) {
	this.transformer = transformer;
    }

    /**
     * The result of the last call to {@link prover}.
     */
    private ProverResult checkResult;

    /**
     * @return the checkResult
     */
    public ProverResult getCheckResult() {
	return this.checkResult;
    }

    /**
     * Uses {@link WPStrategy} as {@link transformer}.
     */
    public SpecificationChecker() {
	this.transformer = new WPStrategy();
    }

    /**
     * @param transformer
     *            Is called to transform {@link Program}s into formulae.
     */
    public SpecificationChecker(FormulaGenerator transformer) {
	this.transformer = transformer;
    }

    /**
     * @param formula
     *            the {@link Expression} to check
     * @param environment
     *            a list of variable values and axioms
     * @return the {@link Validity} of <code>formula</code> when <code>environment</code> is applied
     */
    public Validity checkFormula(Expression formula, Map<String, Value> environment) {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * @param program
     *            the {@link Program} to check
     * @return the {@link Validity} of <code>program</code>
     */
    public Validity checkProgram(Program program) {
	// TODO Auto-generated method stub
	return null;
    }
}