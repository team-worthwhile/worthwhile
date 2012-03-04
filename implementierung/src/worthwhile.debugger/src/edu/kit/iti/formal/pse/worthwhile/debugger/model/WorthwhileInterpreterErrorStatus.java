package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.runtime.IStatus;

import edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants;
import edu.kit.iti.formal.pse.worthwhile.interpreter.InterpreterError;

/**
 * Status that represents an interpreter error.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileInterpreterErrorStatus implements IStatus {

	/**
	 * The interpreter error represented by this status.
	 */
	private final InterpreterError interpreterError;

	/**
	 * Creates a new instance of the {@link WorthwhileInterpreterErrorStatus} class.
	 * 
	 * @param interpreterError
	 *                The interpreter error represented by this status.
	 */
	public WorthwhileInterpreterErrorStatus(final InterpreterError interpreterError) {
		this.interpreterError = interpreterError;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getChildren()
	 */
	@Override
	public final IStatus[] getChildren() {
		return new IStatus[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getCode()
	 */
	@Override
	public final int getCode() {
		return 42;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getException()
	 */
	@Override
	public final Throwable getException() {
		return new RuntimeException(this.interpreterError.getDescription());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getMessage()
	 */
	@Override
	public final String getMessage() {
		return this.interpreterError.getDescription();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getPlugin()
	 */
	@Override
	public final String getPlugin() {
		return WorthwhileDebugConstants.PLUGIN_ID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#getSeverity()
	 */
	@Override
	public final int getSeverity() {
		return IStatus.ERROR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#isMultiStatus()
	 */
	@Override
	public final boolean isMultiStatus() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#isOK()
	 */
	@Override
	public final boolean isOK() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IStatus#matches(int)
	 */
	@Override
	public final boolean matches(final int severity) {
		return (severity | IStatus.ERROR) != 0;
	}

}
