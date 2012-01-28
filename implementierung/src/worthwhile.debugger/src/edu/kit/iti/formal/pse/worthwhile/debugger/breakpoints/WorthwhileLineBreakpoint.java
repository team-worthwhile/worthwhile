package edu.kit.iti.formal.pse.worthwhile.debugger.breakpoints;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;

import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;

/**
 * The implementation of a line breakpoint that the Worthwhile debugger uses.
 * 
 * @author Joachim
 * @see http://www.eclipse.org/articles/Article-Debugger/how-to.html
 * 
 */
public class WorthwhileLineBreakpoint extends LineBreakpoint {

	/**
	 * The ID of the associated marker.
	 */
	public static final String MARKER_ID = "edu.kit.iti.formal.pse.worthwhile.debugger.lineBreakpoint.marker";

	/**
	 * The attribute identifier for the condition on which this breakpoint stops.
	 */
	public static final String CONDITION = "edu.kit.iti.formal.pse.worthwhile.debugger.model.lineBreakpoint.condition";

	/**
	 * Default constructor is required for the breakpoint manager to re-create persisted breakpoints. After
	 * instantiating a breakpoint, the <code>setMarker(...)</code> method is called to restore this breakpoint's
	 * attributes.
	 * 
	 * @see http://www.eclipse.org/articles/Article-Debugger/how-to.html
	 */
	public WorthwhileLineBreakpoint() {
	}

	/**
	 * Constructs a line breakpoint on the given resource at the given line number. The line number is 1-based (i.e.
	 * the first line of a file is line number 1).
	 * 
	 * @param resource
	 *                file on which to set the breakpoint
	 * @param lineNumber
	 *                1-based line number of the breakpoint
	 * @throws CoreException
	 *                 if unable to create the breakpoint
	 * 
	 * @see http://www.eclipse.org/articles/Article-Debugger/how-to.html
	 */
	public WorthwhileLineBreakpoint(final IResource resource, final int lineNumber) throws CoreException {
		// Create a new job to be executed in the workspace (to make things thread-safe!)
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			@Override
			public void run(final IProgressMonitor monitor) throws CoreException {
				// Create a new marker for this breakpoint
				IMarker marker = resource.createMarker(MARKER_ID);
				setMarker(marker);
				marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(IMarker.MESSAGE, "Breakpoint: " + resource.getName() + " [line: "
				                + lineNumber + "]");
			}
		};
		run(getMarkerRule(resource), runnable);
	}

	/**
	 * Sets the condition of this breakpoint.
	 * 
	 * @param condition
	 *                The condition of this breakpoint
	 * @throws DebugException
	 *                 if the condition cannot be retrieved.
	 */
	public final void setCondition(final String condition) throws DebugException {
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			@Override
			public void run(final IProgressMonitor monitor) throws CoreException {
				IMarker marker = getMarker();
				marker.setAttribute(WorthwhileLineBreakpoint.CONDITION, condition);
			}
		};
		run(getMarkerRule(), runnable);
	}

	/**
	 * Returns the condition of this breakpoint.
	 * 
	 * @return the condition of this breakpoint.
	 */
	public final String getCondition() {
		return this.getMarker().getAttribute(CONDITION, "");
	}

	@Override
	public final String getModelIdentifier() {
		return ID_WORTHWHILE_DEBUG_MODEL;
	}

}
