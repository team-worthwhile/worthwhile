/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeToStringHelper;

/**
 * The Class StatementInterpreterError.
 */
public class StatementInterpreterError extends InterpreterError {
	
	/**
	 * The statement.
	 */
	private Statement statement;
	
	/**
	 * The name of the error as shown in the UI
	 */
	private String name;
	
	/**
	 * Sets the name of the error as it appears in the UI
	 */
	public StatementInterpreterError(Statement statement) {
		this.statement = statement;
		this.name = "Statement interpreter error";
	}
	
	/**
	 * Sets the name of the error as it appears in the UI
	 */
	public StatementInterpreterError(Statement statement, String name) {
		this.statement = statement;
		this.name = name;
	}

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
		return this.name + " at statement: " + AstNodeToStringHelper.toString(statement);
		// end-user-code
	}
}