package edu.kit.iti.formal.pse.worthwhile.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import edu.kit.iti.formal.pse.worthwhile.ui.internal.WorthwhileActivator;

/**
 * Initializes the Worthwhile preferences to their default values.
 * 
 * @author Joachim
 * 
 */
public class WorthwhilePreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public final void initializeDefaultPreferences() {
		IPreferenceStore store = WorthwhileActivator.getInstance().getPreferenceStore();
		store.setDefault(WorthwhilePreferenceConstants.PROVER_PATH,
		                WorthwhilePreferenceConstants.DEFAULT_PROVER_PATH);
		store.setDefault(WorthwhilePreferenceConstants.PROVER_TIMEOUT,
		                WorthwhilePreferenceConstants.DEFAULT_PROVER_TIMEOUT);
		store.setDefault(WorthwhilePreferenceConstants.ENABLE_AUTOEDIT,
		                WorthwhilePreferenceConstants.DEFAULT_ENABLE_AUTOEDIT);

	}

}
