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
     */
    private Integer timeout = 0;

    /**
     * @return the timeout
     */
    public Integer getTimeout() {
	// begin-user-code
	return this.timeout;
	// end-user-code
    }

    /**
     * @param timeout
     *            the timeout to set
     */
    public void setTimeout(Integer timeout) {
	// begin-user-code
	this.timeout = timeout;
	// end-user-code
    }

    /**
     * The {@link ProverCaller} that is called for checking the satisfiability of formulae.
     */
    private ProverCaller prover;

    /**
     * @return the prover
     */
    public ProverCaller getProver() {
	// begin-user-code
	return this.prover;
	// end-user-code
    }

    /**
     * @param prover
     *            the prover to set
     */
    public void setProver(ProverCaller prover) {
	// begin-user-code
	this.prover = prover;
	// end-user-code
    }

    /**
     * The {@link FormulaGenerator} that is called for generating a formula from a {@link Program}.
     */
    private FormulaGenerator transformer;

    /**
     * @return the transformer
     */
    public FormulaGenerator getTransformer() {
	// begin-user-code
	return this.transformer;
	// end-user-code
    }

    /**
     * @param transformer
     *            the transformer to set
     */
    public void setTransformer(FormulaGenerator transformer) {
	// begin-user-code
	this.transformer = transformer;
	// end-user-code
    }

    /**
     * The result of the last call to {@link prover}.
     */
    private ProverResult checkResult;

    /**
     * @return the checkResult
     */
    public ProverResult getCheckResult() {
	// begin-user-code
	return this.checkResult;
	// end-user-code
    }

    /**
     * @param checkResult
     *            the checkResult to set
     */
    public void setCheckResult(ProverResult checkResult) {
	// begin-user-code
	this.checkResult = checkResult;
	// end-user-code
    }

    /**
     * Uses {@link WPStrategy} as {@link transformer}.
     */
    public SpecificationChecker() {
	// begin-user-code
	// TODO Auto-generated constructor stub
	// end-user-code
    }

    /**
     * @param transformer
     *            Is called to transform {@link Program}s into formulae.
     */
    public SpecificationChecker(FormulaGenerator transformer) {
	// begin-user-code
	// TODO Auto-generated constructor stub
	// end-user-code
    }

    /**
     * @param formula
     *            the {@link Expression} to check
     * @param environment
     *            a list of variable values and axioms
     * @return the {@link Validity} of <code>formula</code> when <code>environment</code> is applied
     */
    public Validity checkFormula(Expression formula, Map<String, Value> environment) {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * @param program
     *            the {@link Program} to check
     * @return the {@link Validity} of <code>program</code>
     */
    public Validity checkProgram(Program program) {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }
}