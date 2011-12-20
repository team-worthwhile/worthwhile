/**
 * 
 */
package interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/** 
 * 
 */
public class StatementInterpreterError extends InterpreterError {
	/** 
	 * 
	 */
	private Statement statement;

	/** 
	 * @return the statement
	 */
	public Statement getStatement() {
		// begin-user-code
		return statement;
		// end-user-code
	}

	/** 
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		// begin-user-code
		this.statement = statement;
		// end-user-code
	}
}