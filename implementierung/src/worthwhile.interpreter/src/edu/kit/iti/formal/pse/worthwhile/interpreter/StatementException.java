/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

/**
 * @author Chris
 * 
 */
public class StatementException extends RuntimeException {

	/**
	 * 
	 */
	private InterpreterError error;

	public InterpreterError getError() {
		return this.error;
	}

	/**
	 * 
	 */
	public StatementException(InterpreterError error) {
		this.error = error;
	}
}
