package edu.kit.iti.formal.pse.worthwhile.debugger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * A set of utility functions for debugging.
 * 
 * @author Joachim
 * 
 */
public final class DebugHelper {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private DebugHelper() {
	}

	/**
	 * Throws an exception with a new status containing the given message and optional exception.
	 * 
	 * See http://www.eclipse.org/articles/Article-Debugger/how-to.html
	 * 
	 * @param message
	 *                The error message.
	 * @param e
	 *                The underlying exception.
	 * @throws CoreException
	 *                 This is the purpose of the method.
	 */
	public static void throwError(final String message, final Throwable e) throws CoreException {
		throw new CoreException(new Status(IStatus.ERROR, "edu.kit.iti.formal.pse.worthwhile.debugger", 0,
		                message, e));
	}

}
