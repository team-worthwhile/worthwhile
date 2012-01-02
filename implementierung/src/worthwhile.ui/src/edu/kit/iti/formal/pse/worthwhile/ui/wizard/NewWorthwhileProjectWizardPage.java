package edu.kit.iti.formal.pse.worthwhile.ui.wizard;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * A page for entering a new Worthwhile project’s name and location.
 * 
 * @author Joachim
 * 
 */
public class NewWorthwhileProjectWizardPage extends WizardNewProjectCreationPage {

    /**
     * Creates a new instance of the {@link NewWorthwhileProjectWizardPage} class.
     */
    public NewWorthwhileProjectWizardPage() {
	super("NewWorthwhileProjectWizardPage");
	setTitle("Worthwhile Project");
	setDescription("Creates a new Worthwhile Project");
    }

}
