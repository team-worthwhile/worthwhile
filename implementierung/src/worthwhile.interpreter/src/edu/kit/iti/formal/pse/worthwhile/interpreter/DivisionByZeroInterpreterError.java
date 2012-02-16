/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

/**
 * The Class DivisionByZeroInterpreterError.
 */
public class DivisionByZeroInterpreterError extends StatementInterpreterError {
	
	/**
	 * Sets the name of the error as it appears in the UI
	 */
	public DivisionByZeroInterpreterError() {
		super("Division-by-zero interpreter error");
	}
}