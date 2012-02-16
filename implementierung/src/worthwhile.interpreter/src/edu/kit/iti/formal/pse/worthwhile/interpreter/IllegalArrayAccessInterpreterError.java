/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * The Class IllegalArrayAccessInterpreterError.
 */
public class IllegalArrayAccessInterpreterError extends StatementInterpreterError {
	
	/**
	 * Sets the name of the error as it appears in the UI
	 */
	public IllegalArrayAccessInterpreterError(Statement statement) {
		super(statement, "Illegal-array-access interpreter error");
	}
}