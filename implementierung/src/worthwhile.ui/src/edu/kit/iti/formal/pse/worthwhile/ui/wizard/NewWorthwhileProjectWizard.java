package edu.kit.iti.formal.pse.worthwhile.ui.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.internal.progress.ProgressManagerUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;

/**
 * A project wizard for creating a new Worthwhile project.
 * 
 * @author Joachim
 * 
 */
public class NewWorthwhileProjectWizard extends Wizard implements INewWizard {

	/**
	 * The wizard page for entering the project’s name and location.
	 */
	private NewWorthwhileProjectWizardPage newProjectWizardPage;

	@Override
	public final void addPages() {
		addPage(newProjectWizardPage);
	}

	@Override
	public final boolean performFinish() {
		try {
			WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
				@Override
				protected void execute(final IProgressMonitor monitor) {
					createProject(monitor != null ? monitor : new NullProgressMonitor());
				}
			};
			getContainer().run(false, true, op);
		} catch (InvocationTargetException e) {
			MessageDialog.openError(ProgressManagerUtil.getDefaultParent(), "Error", e.getMessage());
			return false;
		} catch (InterruptedException e) {
			MessageDialog.openError(ProgressManagerUtil.getDefaultParent(), "Error", e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public final void init(final IWorkbench workbench, final IStructuredSelection selection) {
		setWindowTitle("New Worthwhile Project");
		this.newProjectWizardPage = new NewWorthwhileProjectWizardPage();
	}

	/**
	 * Creates a new Worthwhile project in the workspace based on the information entered in the
	 * {@code newProjectWizardPage}.
	 * 
	 * @param monitor
	 *                The progress monitor.
	 * 
	 * @see {@linkplain http://www.ibm.com/developerworks/xml/library/x-wxxm15/sidefile1.html}
	 */
	protected final void createProject(final IProgressMonitor monitor) {
		monitor.beginTask("Creating project", 1);
		try {
			// Create a new project.
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(newProjectWizardPage.getProjectName());

			// Set the project’s location.
			IProjectDescription description = ResourcesPlugin.getWorkspace().newProjectDescription(
			                project.getName());
			if (!Platform.getLocation().equals(newProjectWizardPage.getLocationPath())) {
				description.setLocation(newProjectWizardPage.getLocationPath());
			}

			// Add Xtext nature to the project.
			description.setNatureIds(new String[] { XtextProjectHelper.NATURE_ID });

			// Add the Xtext builder to the project.
			ICommand command = description.newCommand();
			command.setBuilderName(XtextProjectHelper.BUILDER_ID);
			description.setBuildSpec(new ICommand[] { command });

			// Perform the actual creation and open the newly generated project.
			project.create(description, monitor);
			monitor.worked(1);
			project.open(monitor);
		} catch (CoreException e) {
			MessageDialog.openError(ProgressManagerUtil.getDefaultParent(), "Error", e.getMessage());
		} finally {
			monitor.done();
		}
	}

}
