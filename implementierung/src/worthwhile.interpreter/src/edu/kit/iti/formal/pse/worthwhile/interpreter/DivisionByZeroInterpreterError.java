/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * The Class DivisionByZeroInterpreterError.
 */
public class DivisionByZeroInterpreterError extends StatementInterpreterError {

	/**
	 * Sets the name of the error as it appears in the UI.
	 * 
	 * @param statement
	 *            the statement which produced the error
	 */
	public DivisionByZeroInterpreterError(final Statement statement) {
		super(statement, "Division by zero");
	}
}