/**
 * 
 */
package prover;

import AST.Expression;

/** 
 * 
 */
public interface ProverCaller {
	/** 
	 * @param formula
	 * @return
	 */
	public ProverResult checkFormula(Expression formula);
}