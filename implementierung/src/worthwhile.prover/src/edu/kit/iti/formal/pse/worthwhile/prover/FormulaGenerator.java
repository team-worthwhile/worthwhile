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
     * @return
     */
    public Expression transformProgram(Program program);
}