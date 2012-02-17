/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * The Class UnknownValidityInterpreterError.
 * 
 * @author Chris
 */
public class UnknownValidityInterpreterError extends StatementInterpreterError {

	/**
	 * Sets the name of the error as it appears in the UI.
	 * 
	 * @param statement
	 *            the statement which produced the error
	 */
	public UnknownValidityInterpreterError(final Statement statement) {
		super(statement, "Unknown validity");
	}
}
