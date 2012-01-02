package edu.kit.iti.formal.pse.worthwhile.ui.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * A page for entering a new Worthwhile file’s name and location.
 * 
 * @author Joachim
 * 
 */
public class NewWorthwhileFileWizardPage extends WizardNewFileCreationPage {

    /**
     * Creates a new instance of the {@link NewWorthwhileFileWizardPage} class.
     * 
     * @param selection
     *            The current selection in the workbench.
     */
    public NewWorthwhileFileWizardPage(final IStructuredSelection selection) {
	super("NewWorthwhileFileWizardPage", selection);
	setTitle("Worthwhile File");
	setDescription("Creates a new Worthwhile File");
	setFileExtension("ww");
    }

}
