/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * The Class StatementInterpreterError.
 */
public class StatementInterpreterError extends InterpreterError {
	
	/** The statement. */
	private Statement statement;

	/**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	public Statement getStatement() {
		// begin-user-code
		return statement;
		// end-user-code
	}

	/**
	 * Sets the statement.
	 *
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		// begin-user-code
		this.statement = statement;
		// end-user-code
	}
	
	/**
	 * Gets the description of the error.
	 *
	 * @return the description
	 */
	@Override
	public String getDescription() {
		// begin-user-code
		return this.getClass().getName() + " at statement: " + statement.toString();
		// end-user-code
	}
}