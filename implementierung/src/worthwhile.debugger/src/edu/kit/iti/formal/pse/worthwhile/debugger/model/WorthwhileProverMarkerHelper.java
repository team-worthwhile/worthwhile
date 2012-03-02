package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;
import edu.kit.iti.formal.pse.worthwhile.util.WorthwhileConstants;
import edu.kit.iti.formal.pse.worthwhile.util.WorthwhileMarkerHelper;

/**
 * A helper class that assists in marking statements in a proof.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileProverMarkerHelper {

	/**
	 * The marker helper used to set the markers.
	 */
	private final WorthwhileMarkerHelper markerHelper;
	
	/**
	 * Returns the marker helper used to set the markers.
	 * @return The marker helper used to set the markers.
	 */
	public WorthwhileMarkerHelper getMarkerHelper() {
		return this.markerHelper;
	}

	/**
	 * Creates a new instance of the {@link WorthwhileProverMarkerHelper} class.
	 * 
	 * @param markerHelper
	 *                The marker helper used to set the markers.
	 */
	public WorthwhileProverMarkerHelper(final WorthwhileMarkerHelper markerHelper) {
		this.markerHelper = markerHelper;
	}

	/**
	 * Marks a statement as failed or succeeded. If the statement is already marked, it will only be re-marked if
	 * the validity gets "worse", i.e. from VALID to INVALID/UNKNOWN.
	 * 
	 * @param statement
	 *                The statement to mark
	 * @param validity
	 *                The validity of the statement
	 * @param message
	 *                An additional message.
	 */
	public void markStatement(final ASTNode statement, final Validity validity, final String message) {
		try {
			IMarker marker = this.markerHelper.getMarkerAt(statement);

			// Mark the statement only if there is no marker or the validity gets worse.
			if (marker != null) {
				if (marker.getType().equals(WorthwhileConstants.MARKER_FAILED_STATEMENT)
				                || validity.equals(Validity.VALID)) {
					return;
				} else {
					marker.delete();
				}
			}

			switch (validity) {
				case VALID:
					this.markerHelper.markSucceededStatement(statement, message);
					break;
				case INVALID:
				case UNKNOWN:
					this.markerHelper.markFailedStatement(statement, message);
					break;
				default:
					break;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
