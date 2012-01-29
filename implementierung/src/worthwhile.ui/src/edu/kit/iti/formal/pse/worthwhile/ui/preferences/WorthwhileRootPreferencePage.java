package edu.kit.iti.formal.pse.worthwhile.ui.preferences;

import java.io.File;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
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
		addField(new WorthwhileFileFieldEditor(WorthwhilePreferenceConstants.PROVER_PATH, "&Path to Z3 binary",
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

	/**
	 * A custom file field editor which allows "non-existing" files (since the file specified could be one that is
	 * just in the PATH).
	 * 
	 * @author Joachim
	 * 
	 */
	private class WorthwhileFileFieldEditor extends FileFieldEditor {

		/**
		 * Creates a file field editor.
		 * 
		 * @param name
		 *                the name of the preference this field editor works on
		 * @param labelText
		 *                the label text of the field editor
		 * @param parent
		 *                the parent of the field editor's control
		 */
		public WorthwhileFileFieldEditor(final String name, final String labelText, final Composite parent) {
			super(name, labelText, parent);
		}

		@Override
		protected String changePressed() {
			File f = new File(getTextControl().getText());
			if (!f.exists()) {
				f = null;
			}

			File d = getFile(f);
			if (d == null) {
				return getTextControl().getText();
			} else {
				return d.getAbsolutePath();
			}

		}

		/**
		 * Helper to open the file chooser dialog.
		 * 
		 * Shamelessly copied from FileFieldEditor (why didn't they make it protected?!)
		 * 
		 * @param startingDirectory
		 *                the directory to open the dialog on.
		 * @return File The File the user selected or <code>null</code> if they do not.
		 */
		private File getFile(final File startingDirectory) {

			FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
			if (startingDirectory != null) {
				dialog.setFileName(startingDirectory.getPath());
			}
			String file = dialog.open();
			if (file != null) {
				file = file.trim();
				if (file.length() > 0) {
					return new File(file);
				}
			}

			return null;
		}

		@Override
		protected boolean checkState() {
			// We only check if the text is empty.
			if (getTextControl().getText().isEmpty()) {
				showErrorMessage("Please enter the prover path.");
				return false;
			} else {
				clearErrorMessage();
				return true;
			}
		}

	}

}
