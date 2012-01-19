/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * 
 */
public interface ProverCaller {
	/**
	 * @param formula
	 *            the {@link Expression} to be checked
	 * @return some prover's satisfiability checking result for <code>formula</code>
	 * @throws ProverCallerException when there is an error executing the prover
	 */
	ProverResult checkFormula(Expression formula) throws ProverCallerException;
}