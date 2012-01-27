package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.MARKER_FAILED_STATEMENT;
import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.MARKER_SUCCEEDED_STATEMENT;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * Helper class for setting markers in a debugged file.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugMarkerHelper {

	/**
	 * The file to set the markers in.
	 */
	private final IFile file;

	/**
	 * Creates a new instance of the {@link WorthwhileDebugMarkerHelper} class.
	 * 
	 * @param file
	 *                The file to set the markers in.
	 */
	public WorthwhileDebugMarkerHelper(final IFile file) {
		if (file == null) {
			throw new IllegalArgumentException("File may not be null");
		}

		this.file = file;
	}

	/**
	 * Clears all debug markers in the file.
	 */
	public final void clearMarkers() {
		try {
			IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
				@Override
				public void run(final IProgressMonitor monitor) throws CoreException {
					file.deleteMarkers(MARKER_FAILED_STATEMENT, true, IResource.DEPTH_INFINITE);
					file.deleteMarkers(MARKER_SUCCEEDED_STATEMENT, true, IResource.DEPTH_INFINITE);
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
	 * Creates a marker in the specified file.
	 * 
	 * @param statement
	 *                The statement to mark in the file.
	 * @param markerType
	 *                The type of the marker
	 * @return The created marker.
	 * @throws CoreException
	 *                 if the marker cannot be created.
	 */
	private IMarker createMarker(final ASTNode statement, final String markerType) throws CoreException {
		// Get the position of the node in the source file.
		int line = NodeHelper.getLine(statement);
		int offset = NodeHelper.getOffset(statement);
		int length = NodeHelper.getLength(statement);

		// Create a new marker
		IMarker marker = this.file.createMarker(markerType);
		marker.setAttribute(IMarker.LINE_NUMBER, line);
		marker.setAttribute(IMarker.CHAR_START, offset);
		marker.setAttribute(IMarker.CHAR_END, offset + length);

		return marker;
	}

}
