package edu.kit.iti.formal.pse.worthwhile.ui.proving;

import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.ui.internal.Workbench;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;
import edu.kit.iti.formal.pse.worthwhile.prover.Z3Prover;
import edu.kit.iti.formal.pse.worthwhile.ui.launching.WorthwhileLaunchConfigurationDelegate;
import edu.kit.iti.formal.pse.worthwhile.ui.preferences.WorthwhilePreferenceConstants;

/**
 * Starts the prover with the specified program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileProveLaunchConfigurationDelegate extends WorthwhileLaunchConfigurationDelegate {

	/**
	 * The preference store.
	 */
	@Inject
	private IPreferenceStore preferenceStore;

	@Override
	public final void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
	                final IProgressMonitor monitor) throws CoreException {

		Program program = this.getProgram(configuration);

		String filePath = configuration.getAttribute(ATTR_PATH, "");
		String fileName = new Path(filePath).lastSegment();

		if (program != null) {
			// Create and run the prover, specification checker, and interpreter.
			Z3Prover prover = new Z3Prover(
			                preferenceStore.getString(WorthwhilePreferenceConstants.PROVER_PATH));

			SpecificationChecker specChecker = new SpecificationChecker(prover);
			specChecker.setTimeout(preferenceStore.getInt(WorthwhilePreferenceConstants.PROVER_TIMEOUT));
			final WorthwhileProveJob proveJob = new WorthwhileProveJob("Prove " + fileName, specChecker,
			                program);
			proveJob.addJobChangeListener(new ProveJobFinishedListener());
			proveJob.schedule();
		}

	}

	/**
	 * A listener that listens for the end of execution of the prove job.
	 * 
	 * @author Joachim
	 * 
	 */
	private class ProveJobFinishedListener extends JobChangeAdapter {

		@Override
		public void done(final IJobChangeEvent event) {
			final IStatus status = event.getResult();

			// Type of the dialog to show
			int type;
			// Title of the dialog
			String title = "";
			// Dialog message
			String message = "";

			if (status.isOK()) {
				type = MessageDialog.INFORMATION;
				title = "Prove success";
				message = "The program conforms to the specification.";
			} else {
				type = MessageDialog.ERROR;
				if (status instanceof ProveResultStatus) {
					if (Validity.INVALID.equals(((ProveResultStatus) status).getValidity())) {
						message = "It cannot be proven that the program conforms to the specification.";
					} else {
						message = "The validity of the program could not be determined.";
					}

					title = "Prove unsuccessful";
					message += "\n\nAdditional prover output: " + status.getMessage();
				} else {
					// Something went horribly wrong
					title = "Prove error";
					message += "There was an unexpected error invoking the prover:\n\n"
					                + status.getMessage();
				}
			}

			// Copy variable contents into new final variables, since the variables used in the inner
			// Runnable class need to be final.
			final int dialogType = type;
			final String dialogTitle = title;
			final String dialogMessage = message;

			Workbench.getInstance().getDisplay().asyncExec(new Runnable() {
				public void run() {
					MessageDialog.open(dialogType, Workbench.getInstance()
					                .getActiveWorkbenchWindow().getShell(), dialogTitle,
					                dialogMessage, SWT.NONE);
				}
			});
		}
	}
}
