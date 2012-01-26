package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * Default listener for {@link Interpreter} events.
 */
public abstract class AbstractExecutionEventListener {
	/**
	 * Signals that a {@link Statement} has been executed by the {@link Interpreter}.
	 * 
	 * @param statement
	 *                the <code>Statement</code> that was executed
	 */

	public void statementExecuted(final Statement statement) {
	}

	/**
	 * Signals that a {@link Statement} will be executed.
	 * 
	 * @param statement
	 *                the <code>Statement</code> that will be executed
	 */
	public void statementWillExecute(final Statement statement) {
	}

	/**
	 * Signals that the execution of a {@link Statement} failed.
	 * 
	 * @param statement
	 *                the <code>Statement</code> that failed to execute
	 * @param error
	 *                an {@link InterpreterError} object that describes the error
	 */
	public void executionFailed(final Statement statement, final InterpreterError error) {
		throw new RuntimeException("Failed to execute " + statement.toString() + "; Got error "
		                + error.toString());
	}

	/**
	 * Signals the start of the execution of a {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program}.
	 */
	public void executionStarted() {
	}

	/**
	 * Signals the successful completion of execution of a
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program}.
	 */
	public void executionCompleted() {
	}

	/**
	 * Signals the execution of an {@link Annotation} that was not valid.
	 * 
	 * @param annotation
	 *                the invalid <code>Annotation</code>
	 */
	public void annotationFailed(final Annotation annotation) {
		throw new RuntimeException(annotation.toString() + " is invalid.");
	}

	/**
	 * Signals the execution of an {@link Annotation} that was valid.
	 * 
	 * @param annotation
	 *                the valid <code>Annotation</code>
	 */
	public void annotationSucceeded(final Annotation annotation) {
	}

	/**
	 * Signals the evaluation of a {@link Expression}.
	 * 
	 * @param expression
	 *                the <code>Expression</code> that was evaluated
	 */
	public void expressionEvaluated(final Expression expression) {
	}

	/**
	 * Signals that the execution of a {@link Expression} failed.
	 * 
	 * @param expression
	 *                the <code>Expression</code> that failed to execute
	 * @param error
	 *                an {@link InterpreterError} object that describes the error
	 */
	public void expressionFailed(final Expression expression, final InterpreterError error) {
		throw new RuntimeException("Failed to execute " + expression.toString() + "; Got error "
		                + error.toString());
	}
}