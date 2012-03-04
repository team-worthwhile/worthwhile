package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.runtime.IStatus;

import edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants;

/**
 * Indicates an error that occured when trying to evaluate an expression.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileExpressionEvaluationError implements IStatus {

	/**
	 * The underlying exceptions causing the evaluation to fail.
	 */
	private final IStatus[] children;

	/**
	 * Creates a new instance of the {@link ExpressionEvaluationError} class.
	 * 
	 * @param children
	 *                The underlying problems causing the evaluation to fail.
	 */
	public WorthwhileExpressionEvaluationError(final IStatus[] children) {
		this.children = children;
	}

	@Override
	public final IStatus[] getChildren() {
		return this.children;
	}

	@Override
	public final int getCode() {
		return 42;
	}

	@Override
	public final Throwable getException() {
		return null;
	}

	@Override
	public final String getMessage() {
		return this.children[0].getMessage();
	}

	@Override
	public final String getPlugin() {
		return WorthwhileDebugConstants.PLUGIN_ID;
	}

	@Override
	public final int getSeverity() {
		return IStatus.ERROR;
	}

	@Override
	public final boolean isMultiStatus() {
		return true;
	}

	@Override
	public final boolean isOK() {
		return false;
	}

	@Override
	public final boolean matches(final int severityMask) {
		return (severityMask & IStatus.ERROR) > 0;
	}

}