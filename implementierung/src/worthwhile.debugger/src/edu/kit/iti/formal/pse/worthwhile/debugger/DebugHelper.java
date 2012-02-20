package edu.kit.iti.formal.pse.worthwhile.debugger;

import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

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

	/**
	 * Returns the file name of the source file of the program that is executed.
	 * 
	 * @param launch
	 *                The launch object used to launch the program.
	 * 
	 * @return The file name of the source file of the program that is executed.
	 */
	public static String getSourceName(final ILaunch launch) {
		try {
			// Get the path from the launch configuration and return only the file name.
			ILaunchConfiguration configuration = launch.getLaunchConfiguration();
			if (configuration != null) {
				Path path = new Path(configuration.getAttribute(ATTR_PATH, ""));
				return path.lastSegment();
			} else {
				return "";
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return "";
		}
	}

}
