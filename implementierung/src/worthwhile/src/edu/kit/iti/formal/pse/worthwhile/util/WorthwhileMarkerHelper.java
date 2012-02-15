package edu.kit.iti.formal.pse.worthwhile.util;

import static edu.kit.iti.formal.pse.worthwhile.util.WorthwhileConstants.MARKER_FAILED_STATEMENT;
import static edu.kit.iti.formal.pse.worthwhile.util.WorthwhileConstants.MARKER_SUCCEEDED_STATEMENT;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * Helper class for setting markers in a Worthwhile file.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileMarkerHelper {

	/**
	 * The resource to set the markers in.
	 */
	private final IResource resource;

	/**
	 * Creates a new instance of the {@link WorthwhileMarkerHelper} class.
	 * 
	 * @param resource
	 *                The resource to set the markers in.
	 */
	public WorthwhileMarkerHelper(final IResource resource) {
		if (resource == null) {
			throw new IllegalArgumentException("Resource may not be null");
		}

		this.resource = resource;
	}

	/**
	 * Clears all Worthwhile markers in the resource.
	 */
	public final void clearMarkers() {
		try {
			IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
				@Override
				public void run(final IProgressMonitor monitor) throws CoreException {
					resource.deleteMarkers(MARKER_FAILED_STATEMENT, true, IResource.DEPTH_INFINITE);
					resource.deleteMarkers(MARKER_SUCCEEDED_STATEMENT, true,
					                IResource.DEPTH_INFINITE);
				}
			};
			runnable.run(null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Marks a statement as failed (e.g. an assertion).
	 * 
	 * @param statement
	 *                The statement to mark as failed.
	 * @param message
	 *                The message to mark the statement with.
	 */
	public final void markFailedStatement(final ASTNode statement, final String message) {
		try {
			IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
				@Override
				public void run(final IProgressMonitor monitor) throws CoreException {
					// Create a new marker
					IMarker marker = createMarker(statement, MARKER_FAILED_STATEMENT);
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
					marker.setAttribute(IMarker.MESSAGE, message);
				}
			};
			runnable.run(null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Marks a statement as succeeded (e.g. an assertion).
	 * 
	 * @param statement
	 *                The statement to mark as succeeded.
	 * @param message
	 *                The message to mark the statement with.
	 */
	public final void markSucceededStatement(final ASTNode statement, final String message) {
		try {
			IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
				@Override
				public void run(final IProgressMonitor monitor) throws CoreException {
					// Create a new marker
					IMarker marker = createMarker(statement, MARKER_SUCCEEDED_STATEMENT);
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
					marker.setAttribute(IMarker.MESSAGE, message);
				}
			};
			runnable.run(null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Creates a marker in the specified resource.
	 * 
	 * @param statement
	 *                The statement to mark in the resource.
	 * @param markerType
	 *                The type of the marker
	 * @return The created marker.
	 * @throws CoreException
	 *                 if the marker cannot be created.
	 */
	private IMarker createMarker(final ASTNode statement, final String markerType) throws CoreException {
		// Get the position and length of the node in the source file.
		// Do not include trailing whitespace to prevent the marker from running into the next line.
		int line = NodeHelper.getLine(statement);
		int offset = NodeHelper.getOffset(statement);
		int length = trimRight(NodeHelper.getText(statement)).length();

		// Create a new marker
		IMarker marker = this.resource.createMarker(markerType);
		marker.setAttribute(IMarker.LINE_NUMBER, line);
		marker.setAttribute(IMarker.CHAR_START, offset);
		marker.setAttribute(IMarker.CHAR_END, offset + length);

		return marker;
	}

	/**
	 * Removes trailing whitespace from a string.
	 * 
	 * http://forums.devshed.com/java-help-9/how-to-remove-leading-white-spaces-from-a-string-579116.html
	 * 
	 * @param s
	 *                The string
	 * @return The right-trimmed string.
	 */
	private static String trimRight(final String s) {
		return s.replaceAll("\\s+$", "");
	}

}
