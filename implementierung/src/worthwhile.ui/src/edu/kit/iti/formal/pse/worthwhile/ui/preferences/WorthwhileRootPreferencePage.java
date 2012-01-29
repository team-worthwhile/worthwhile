package edu.kit.iti.formal.pse.worthwhile.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;

import edu.kit.iti.formal.pse.worthwhile.ui.internal.WorthwhileActivator;

/**
 * The root preference page for the Worthwhile language.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileRootPreferencePage extends LanguageRootPreferencePage {

	@Override
	protected final void createFieldEditors() {
		addField(new StringFieldEditor(WorthwhilePreferenceConstants.PROVER_PATH, "&Path to Z3 binary",
		                getFieldEditorParent()));
		addField(new IntegerFieldEditor(WorthwhilePreferenceConstants.PROVER_TIMEOUT,
		                "Prover &timeout (in seconds)", getFieldEditorParent()));
		addField(new BooleanFieldEditor(WorthwhilePreferenceConstants.ENABLE_AUTOEDIT,
		                "Enable automatic keyword replacing in editor (change requires restart)",
		                getFieldEditorParent()));
	}

	@Override
	public final void init(final IWorkbench workbench) {
		setPreferenceStore(WorthwhileActivator.getInstance().getPreferenceStore());
	}

}
