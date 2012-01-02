package edu.kit.iti.formal.pse.worthwhile.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.Workbench;

public class NewWorthwhileFileWizard extends Wizard implements INewWizard {

    private NewWorthwhileFileWizardPage newFileWizardPage;

    public NewWorthwhileFileWizard() {
	setWindowTitle("New Worthwhile File");
    }

    @Override
    public void addPages() {

	addPage(newFileWizardPage);
    }

    @Override
    public boolean performFinish() {
	IFile file = newFileWizardPage.createNewFile();
	if (file != null) {
	    // Open the newly created file.
	    try {
		IDE.openEditor(Workbench.getInstance().getActiveWorkbenchWindow().getActivePage(), file);
	    } catch (PartInitException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
	this.newFileWizardPage = new NewWorthwhileFileWizardPage(selection);
    }

}
