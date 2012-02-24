package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * Classes implementing the {@link ProverCaller} interface provide {@link ProverCaller#checkFormula(Expression)}
 * implementations that generate an {@link ProverResult} for an {@link Expression}. The given <code>Expression</code>s
 * are first-order logic formulae and primarily the implementations try to determine these formulas' satisfiability.
 * Therefore usually an external prover binary or library is called, which is the reason for the interface's name.
 */
public interface ProverCaller {
	/**
	 * @param formula
	 *                the {@link Expression} to be checked
	 * @param timeout
	 *                the timeout after which the prover caller should give up
	 * @return some prover's satisfiability checking result for <code>formula</code>
	 * @throws ProverCallerException
	 *                 when there is an error executing the prover
	 */
	ProverResult checkFormula(Expression formula, int timeout) throws ProverCallerException;
}