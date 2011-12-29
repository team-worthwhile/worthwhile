package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;

import edu.kit.iti.formal.pse.worthwhile.debugger.IWorthwhileDebugConstants;

/**
 * The implementation of a line breakpoint that the Worthwhile debugger uses.
 * 
 * @author Joachim
 * @see http://www.eclipse.org/articles/Article-Debugger/how-to.html
 * 
 */
public class WorthwhileLineBreakpoint extends LineBreakpoint {

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
     * Constructs a line breakpoint on the given resource at the given line number. The line number is 1-based (i.e. the
     * first line of a file is line number 1).
     * 
     * @param resource
     *            file on which to set the breakpoint
     * @param lineNumber
     *            1-based line number of the breakpoint
     * @throws CoreException
     *             if unable to create the breakpoint
     * 
     * @see http://www.eclipse.org/articles/Article-Debugger/how-to.html
     */
    public WorthwhileLineBreakpoint(final IResource resource, final int lineNumber) throws CoreException {
	// Create a new job to be executed in the workspace (to make things thread-safe!)
	IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
	    public void run(final IProgressMonitor monitor) throws CoreException {
		// create a new marker for this breakpoint
		IMarker marker = resource
			.createMarker("edu.kit.iti.formal.pse.worthwhile.debugger.lineBreakpoint.marker");
		setMarker(marker);
		marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
		marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
		marker.setAttribute(IMarker.MESSAGE, "Breakpoint: " + resource.getName() + " [line: " + lineNumber
			+ "]");
	    }
	};
	run(getMarkerRule(resource), runnable);
    }

    @Override
    public final String getModelIdentifier() {
	return IWorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;
    }

}
