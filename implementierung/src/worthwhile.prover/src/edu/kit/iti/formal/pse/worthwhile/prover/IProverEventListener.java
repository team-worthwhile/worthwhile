package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Event listener for events that may occur while the prover is running.
 * 
 * @author Leon Handreke
 * 
 */
public interface IProverEventListener {
	/**
	 * Signals that all verifiable elements in a program were verified.
	 * 
	 * @param program
	 *                the program that has been verified
	 * @param validity
	 *                the validity of the program
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void programVerified(final Program program, final Validity validity, final ProverResult proverResult);
}
