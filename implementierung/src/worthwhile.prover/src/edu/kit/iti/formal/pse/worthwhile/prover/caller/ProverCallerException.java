package edu.kit.iti.formal.pse.worthwhile.prover.caller;

/**
 * {@link ProverCallerException} is thrown when
 * {@link ProverCaller#checkFormula(edu.kit.iti.formal.pse.worthwhile.model.ast.Expression)} could not successfully call
 * the respective prover and thus cannot return a reliable {@link ProverResult}.
 * 
 * @author Leon Handreke
 * 
 */
public class ProverCallerException extends Exception {

	/**
	 * Default constructor.
	 * 
	 * @param reason
	 *                the detail message
	 * 
	 * @see Exception
	 */
	public ProverCallerException(final String reason) {
		super(reason);
	}

}
