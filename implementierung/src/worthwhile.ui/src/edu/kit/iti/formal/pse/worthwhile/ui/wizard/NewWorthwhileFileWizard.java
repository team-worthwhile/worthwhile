package edu.kit.iti.formal.pse.worthwhile.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.progress.ProgressManagerUtil;

/**
 * A wizard for creating a new Worthwhile (.ww) file.
 * 
 * @author Joachim
 * 
 */
public class NewWorthwhileFileWizard extends Wizard implements INewWizard {

	/**
	 * The wizard page for entering the file’s name and location.
	 */
	private NewWorthwhileFileWizardPage newFileWizardPage;

	@Override
	public final void addPages() {
		addPage(newFileWizardPage);
	}

	@Override
	public final boolean performFinish() {
		// Create the file.
		IFile file = newFileWizardPage.createNewFile();

		if (file != null) {
			// Open the newly created file.
			try {
				IDE.openEditor(Workbench.getInstance().getActiveWorkbenchWindow().getActivePage(), file);
			} catch (PartInitException e) {
				MessageDialog.openError(ProgressManagerUtil.getDefaultParent(), "Error", e.getMessage());
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public final void init(final IWorkbench workbench, final IStructuredSelection selection) {
		setWindowTitle("New Worthwhile File");
		this.newFileWizardPage = new NewWorthwhileFileWizardPage(selection);
	}

}
