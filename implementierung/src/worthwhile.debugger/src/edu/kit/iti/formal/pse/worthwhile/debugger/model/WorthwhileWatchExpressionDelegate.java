package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IWatchExpressionDelegate;
import org.eclipse.debug.core.model.IWatchExpressionListener;
import org.eclipse.debug.core.model.IWatchExpressionResult;

import edu.kit.iti.formal.pse.worthwhile.model.Value;

/**
 * A delegate for evaluating watch expressions.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileWatchExpressionDelegate implements IWatchExpressionDelegate {

	/**
	 * Represents a result of a watch expression in a Worthwhile program.
	 * 
	 * @author Joachim
	 * 
	 */
	private final class WorthwhileWatchExpressionResult extends WorthwhileDebugElement implements
	                IWatchExpressionResult {

		/**
		 * Creates a new instance of the {@link WorthwhileWatchExpressionResult} class.
		 * 
		 * @param debugTarget
		 *                The debug target to use.
		 * @param value
		 *                The value that this result represents.
		 * @param exception
		 *                The exception that was raised if an error occurred during evaluation.
		 * @param expressionText
		 *                The expression text as a String.
		 */
		public WorthwhileWatchExpressionResult(final WorthwhileDebugTarget debugTarget, final Value value,
		                final DebugException exception, final String expressionText) {
			super(debugTarget);
			this.value = value;
			this.exception = exception;
			this.expressionText = expressionText;
		}

		/**
		 * The value that this result represents.
		 */
		private final Value value;

		/**
		 * The exception that was raised if an error occurred during evaluation.
		 */
		private final DebugException exception;

		/**
		 * The expression text as a String.
		 */
		private final String expressionText;

		@Override
		public IValue getValue() {
			return new WorthwhileValue(this.getDebugTarget(), this.value);
		}

		@Override
		public boolean hasErrors() {
			return this.exception != null;
		}

		@Override
		public String[] getErrorMessages() {
			if (this.exception != null) {
				return new String[] { this.exception.getMessage() };
			} else {
				return new String[0];
			}
		}

		@Override
		public String getExpressionText() {
			return this.expressionText;
		}

		@Override
		public DebugException getException() {
			return this.exception;
		}
	}

	@Override
	public final void evaluateExpression(final String expression, final IDebugElement context,
	                final IWatchExpressionListener listener) {

		if (context instanceof WorthwhileDebugElement) {
			WorthwhileDebugTarget debugTarget = (WorthwhileDebugTarget) (context.getDebugTarget());

			DebugException exception = null;
			Value result = null;

			try {
				result = debugTarget.evaluateExpression(expression);
			} catch (DebugException e) {
				exception = e;
			}

			listener.watchEvaluationFinished(new WorthwhileWatchExpressionResult(debugTarget, result,
			                exception, expression));
		} else {
			listener.watchEvaluationFinished(null);
		}
	}

}
