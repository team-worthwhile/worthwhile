/**
 * 
 */
package interpreter;

import AST.Statement;
import AST.Assertion;
import AST.Expression;

/** 
 *
 */
public abstract class AbstractDebugEventListener {
	/** 
	 * @param statement
	 */
	
	public void statementExecuted(Statement statement) {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
	}

	/** 
	 * @param statement
	 */
	public void statementWillExecute(Statement statement) {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
	}

	/** 
	 * @param statement
	 * @param error
	 */
	public void executionFailed(Statement statement, InterpreterError error) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @param statement
	 * @param breakpoint
	 */
	public void breakpointReached(Statement statement, LineBreakpoint breakpoint) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * 
	 */
	public void executionStarted() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * 
	 */
	public void executionCompleted() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @param assertion
	 */
	public void assertionFailed(Assertion assertion) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @param assertion
	 */
	public void assertionSucceeded(Assertion assertion) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @param expression
	 */
	public void expressionEvaluated(Expression expression) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}