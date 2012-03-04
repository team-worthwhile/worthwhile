package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import edu.kit.iti.formal.pse.worthwhile.interpreter.InterpreterError;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * An event listener that listens while an expression is being evaluated.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileEvaluationEventListener extends WorthwhileEventListener {

	/**
	 * Creates a new instance of the {@link WorthwhileEvaluationEventListener} class.
	 * 
	 * @param debugTarget
	 *                The debug target.
	 */
	public WorthwhileEvaluationEventListener(final WorthwhileDebugTarget debugTarget) {
		super(debugTarget);
	}

	/**
	 * If an interpreter error occured: the interpreter error.
	 */
	private InterpreterError error;

	/**
	 * Returns the interpreter error if an interpreter error occured.
	 * 
	 * @return the interpreter error if an interpreter error occured, {@code null} otherwise.
	 */
	public final InterpreterError getError() {
		return this.error;
	}

	@Override
	public final void expressionFailed(final Expression expression, final InterpreterError error) {
		this.error = error;
	}

}
