package edu.kit.iti.formal.pse.worthwhile.ui.preferences;

/**
 * Some constants for preference keys.
 * 
 * @author Joachim
 * 
 */
public final class WorthwhilePreferenceConstants {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private WorthwhilePreferenceConstants() {
	}

	/**
	 * Preference key for the prover path preference.
	 */
	public static final String PROVER_PATH = "ProverPath";

	/**
	 * Default value for the prover path preference.
	 */
	public static final String DEFAULT_PROVER_PATH = "z3";

	/**
	 * Preference key for the prover timeout preference.
	 */
	public static final String PROVER_TIMEOUT = "ProverTimeout";

	/**
	 * Default value for the prover timeout preference.
	 */
	public static final int DEFAULT_PROVER_TIMEOUT = 1;

	/**
	 * Preference key for the "enable auto edit" preference.
	 */
	public static final String ENABLE_AUTOEDIT = "EnableAutoEdit";

	/**
	 * Default value for the "enable auto edit" preference.
	 */
	public static final boolean DEFAULT_ENABLE_AUTOEDIT = true;

}
