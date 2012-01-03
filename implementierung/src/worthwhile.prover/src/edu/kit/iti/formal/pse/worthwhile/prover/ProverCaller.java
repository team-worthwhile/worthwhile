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
     * @return
     * @throws ProverCallerException
     */
    public ProverResult checkFormula(Expression formula) throws ProverCallerException;
}