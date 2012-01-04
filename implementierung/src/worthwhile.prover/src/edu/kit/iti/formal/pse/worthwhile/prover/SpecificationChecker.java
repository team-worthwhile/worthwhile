package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Map;

import edu.kit.iti.formal.pse.worthwhile.interpreter.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstFactoryImpl;

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
     * Uses {@link WPStrategy} as {@link SpecificationChecker#transformer}.
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
    // TODO we need error reporting, return UNKNOWN for now in case of ProverCallerException
    public Validity checkFormula(Expression formula, Map<String, Value> environment) {
	// TODO apply Worthwhile specific runtime assertions
	// TODO apply axiom list
	// TODO apply environment

	return getValidity(formula);
    }

    /**
     * Checks a formula's validity and returns the result.
     * 
     * @param formula
     *            the {@link Expression} whose {@link Validity} to determine
     * @return <code>formula</code>'s {@link Validity}
     */
    private Validity getValidity(Expression formula) {
	AstFactory model = new AstFactoryImpl();

	Negation negation = model.createNegation();
	negation.setOperand(formula);

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
    public Validity checkProgram(Program program) {
	// generate formula from program
	Expression formula = this.transformer.transformProgram(program);

	// TODO apply Worthwhile specific runtime assertions

	return this.getValidity(formula);
    }
}