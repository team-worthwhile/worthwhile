/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;;

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