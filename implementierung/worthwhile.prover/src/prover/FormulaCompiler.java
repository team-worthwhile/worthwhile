/**
 * 
 */
package prover;

import AST.Expression;

/** 
 * 
 */
public interface FormulaCompiler {
	/** 
	 * @param formula
	 * @return
	 */
	public String compileFormula(Expression formula);
}