/**
 * Default listener for interpreter events.
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

public abstract class AbstractDebugEventListener {
	/**
	 * Called every time a Statement has been executed by the Interpreter
	 * 
	 * @param statement
	 *            the Statement that was executed
	 */

	public void statementExecuted(Statement statement) {
		return;
	}

	/**
	 * Called every time a Statement will be executed
	 * 
	 * @param statement
	 *            the Statement that will be executed
	 */
	public void statementWillExecute(Statement statement) {
		return;
	}

	/**
	 * Called after the execution of a Statement failed
	 * 
	 * @param statement
	 *            the Statement that failed to execute
	 * @param error
	 *            an InterpreterError object that describes the error
	 */
	public void executionFailed(Statement statement, InterpreterError error) {
		throw new RuntimeException("Failed to execute " + statement.toString() + "; Got error " + error.toString());
	}

	/**
	 * Called after a breakpoint has interrupted execution
	 * 
	 * @param statement
	 *            the statement that would be executed next
	 * @param breakpoint
	 *            the breakpoint that was hit
	 */
	public void breakpointReached(Statement statement, LineBreakpoint breakpoint) {
		// Just ignore the breakpoint
		return;
	}

	/**
	 * Called after the start of the execution of a <code>Program</code>
	 */
	public void executionStarted() {
		return;
	}

	/**
	 * Called after the successful completion of execution of a <code>Program</code>
	 */
	public void executionCompleted() {
		return;
	}

	/**
	 * Called after the execution of an assertion that was not valid
	 * 
	 * @param assertion
	 *            the invalid assertion
	 */
	public void assertionFailed(Assertion assertion) {
		throw new RuntimeException(assertion.toString() + " is invalid.");
	}

	/**
	 * Called after the execution of an assertion that was valid
	 * 
	 * @param assertion
	 *            the valid assertion
	 */
	public void assertionSucceeded(Assertion assertion) {
		return;
	}

	/**
	 * Called after the evaluation of a <code>Expression</code>
	 * 
	 * @param expression
	 *            the expression that was evaluated
	 */
	public void expressionEvaluated(Expression expression) {
		return;
	}
}