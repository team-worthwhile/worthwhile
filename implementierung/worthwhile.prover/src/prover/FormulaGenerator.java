/**
 * 
 */
package prover;

import AST.Expression;
import AST.Program;

/** 
 * 
 */
public interface FormulaGenerator {
	/** 
	 * @param program
	 * @return
	 */
	public Expression transformProgram(Program program);
}