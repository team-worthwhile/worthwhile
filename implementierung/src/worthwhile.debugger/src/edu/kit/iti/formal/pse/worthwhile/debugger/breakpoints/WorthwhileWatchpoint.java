package edu.kit.iti.formal.pse.worthwhile.debugger.breakpoints;

import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IWatchpoint;
import org.eclipse.debug.core.model.LineBreakpoint;

/**
 * Represents a watchpoint in a Worthwhile program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileWatchpoint extends LineBreakpoint implements IWatchpoint {

	/**
	 * The ID of the associated marker.
	 */
	public static final String MARKER_ID = "edu.kit.iti.formal.pse.worthwhile.debugger.watchpoint.marker";

	/**
	 * The attribute identifier for the name of the variable to match.
	 */
	public static final String VARIABLE_NAME = "edu.kit.iti.formal.pse.worthwhile.debugger.model.watchpoint.varName";
	
	/**
	 * Default constructor is required for the breakpoint manager to re-create persisted breakpoints. After
	 * instantiating a breakpoint, the <code>setMarker(...)</code> method is called to restore this breakpoint's
	 * attributes.
	 * 
	 * @see http://www.eclipse.org/articles/Article-Debugger/how-to.html
	 */
	public WorthwhileWatchpoint() {
	}

	/**
	 * Constructs a watchpoint on the given resource at the given line number. The line number is 1-based (i.e. the
	 * first line of a file is line number 1).
	 * 
	 * @param resource
	 *                file on which to set the watchpoint
	 * @param lineNumber
	 *                1-based line number of the watchpoint
	 * @param variableName
	 *                The name of the variable to watch.
	 * @throws DebugException
	 *                 if unable to create the breakpoint
	 * 
	 * @see http://www.eclipse.org/articles/Article-Debugger/how-to.html
	 */
	public WorthwhileWatchpoint(final IResource resource, final int lineNumber, final String variableName)
	                throws DebugException {
		// Create a new job to be executed in the workspace (to make things thread-safe!)
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			@Override
			public void run(final IProgressMonitor monitor) throws CoreException {
				// Create a new marker for this breakpoint
				IMarker marker = resource.createMarker(MARKER_ID);
				setMarker(marker);
				marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(VARIABLE_NAME, variableName);
				marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(IMarker.MESSAGE, "Watchpoint: " + resource.getName()
				                + " [variable: " + variableName + "]");
			}
		};
		run(getMarkerRule(resource), runnable);
	}

	/**
	 * Returns the name of the variable to watch.
	 * 
	 * @return The name of the variable to watch.
	 */
	public final String getVariableName() {
		return this.getMarker().getAttribute(VARIABLE_NAME, "");
	}

	@Override
	public final boolean isAccess() throws CoreException {
		return false;
	}

	@Override
	public void setAccess(final boolean access) throws CoreException {
	}

	@Override
	public final boolean isModification() throws CoreException {
		return true;
	}

	@Override
	public void setModification(final boolean modification) throws CoreException {
	}

	@Override
	public final boolean supportsAccess() {
		return false;
	}

	@Override
	public final boolean supportsModification() {
		return true;
	}

	@Override
	public final String getModelIdentifier() {
		return ID_WORTHWHILE_DEBUG_MODEL;
	}

}
