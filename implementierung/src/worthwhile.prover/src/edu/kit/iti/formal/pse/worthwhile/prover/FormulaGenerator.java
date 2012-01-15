/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/** 
 * 
 */
public interface FormulaGenerator {
	/**
	 * @param program
	 *            the {@link Program} to be transformed into a formula
	 * @return the transformation formula of <code>program</code> according to some calculus rules
	 */
	Expression transformProgram(Program program);
}