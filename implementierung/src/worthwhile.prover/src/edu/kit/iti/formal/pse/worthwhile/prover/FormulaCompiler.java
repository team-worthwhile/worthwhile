/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/** 
 * 
 */
public interface FormulaCompiler {
	/**
	 * @param formula
	 *            the {@link Expression} to be compiled into some prover's input language
	 * @return the character string compilation of <code>formula</code> into some prover language
	 */
	public String compileFormula(Expression formula);
}