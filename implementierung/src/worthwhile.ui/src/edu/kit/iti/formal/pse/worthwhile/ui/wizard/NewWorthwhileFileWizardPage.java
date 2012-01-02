package edu.kit.iti.formal.pse.worthwhile.ui.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewWorthwhileFileWizardPage extends WizardNewFileCreationPage {

    public NewWorthwhileFileWizardPage(IStructuredSelection selection) {
	super("NewWorthwhileFileWizardPage", selection);
	setTitle("Worthwhile File");
	setDescription("Creates a new Worthwhile File");
	setFileExtension("ww");
    }

}
