/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

// TODO: Auto-generated Javadoc
/**
 * The Class StatementException.
 *
 * @author Chris
 */
public class StatementException extends RuntimeException {

	/** The error. */
	private InterpreterError error;

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public final InterpreterError getError() {
		return this.error;
	}

	/**
	 * Instantiates a new statement exception.
	 *
	 * @param error the error
	 */
	public StatementException(final InterpreterError error) {
		this.error = error;
	}
}
