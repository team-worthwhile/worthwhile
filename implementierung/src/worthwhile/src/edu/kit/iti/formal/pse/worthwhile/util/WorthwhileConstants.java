package edu.kit.iti.formal.pse.worthwhile.util;

/**
 * Contains some global constants for Worthwhile.
 * 
 * @author Joachim
 *
 */
public final class WorthwhileConstants {

	/**
	 * The prefix for the marker specifications.
	 */
	public static final String MARKER_PREFIX = "edu.kit.iti.formal.pse.worthwhile.debugger.markers";

	/**
	 * The marker identifier for the "failed annotation" marker.
	 */
	public static final String MARKER_FAILED_STATEMENT = MARKER_PREFIX + ".failedStatement";

	/**
	 * The marker identifier for the "succeeded annotation" marker.
	 */
	public static final String MARKER_SUCCEEDED_STATEMENT = MARKER_PREFIX + ".succeededStatement";

	/**
	 * Private constructor to prevent instantiation.
	 */
	private WorthwhileConstants() {
	}

}
