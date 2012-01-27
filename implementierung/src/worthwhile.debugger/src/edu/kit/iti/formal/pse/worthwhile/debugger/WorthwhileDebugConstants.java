package edu.kit.iti.formal.pse.worthwhile.debugger;

/**
 * This class provides some global constants for the debugger.
 * 
 * @author Joachim
 * 
 */
public final class WorthwhileDebugConstants {

	/**
	 * A unique identifier for the debug model provided by thie plug-in.
	 */
	public static final String ID_WORTHWHILE_DEBUG_MODEL = "edu.kit.iti.formal.pse.worthwhile";
	
	/**
	 * The prefix for the marker specifications.
	 */
	public static final String MARKER_PREFIX = "edu.kit.iti.formal.pse.worthwhile.debugger.markers";

	/**
	 * The marker identifier for the "failed annotation" marker.
	 */
	public static final String MARKER_FAILED_ANNOTATION = MARKER_PREFIX + ".failedAnnotation";

	/**
	 * The marker identifier for the "succeeded annotation" marker.
	 */
	public static final String MARKER_SUCCEEDED_ANNOTATION = MARKER_PREFIX + ".succeededAnnotation";

	/**
	 * Private constructor to prevent instantiation.
	 */
	private WorthwhileDebugConstants() {
	}

}
