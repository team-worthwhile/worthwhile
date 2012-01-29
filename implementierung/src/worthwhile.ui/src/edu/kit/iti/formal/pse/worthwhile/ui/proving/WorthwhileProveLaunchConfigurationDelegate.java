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
import org.eclipse.ui.internal.Workbench;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
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
			SpecificationChecker specChecker = new SpecificationChecker();
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

			if (status.isOK()) {
				Workbench.getInstance().getDisplay().asyncExec(new Runnable() {
					public void run() {
						MessageDialog.openInformation(Workbench.getInstance()
						                .getActiveWorkbenchWindow().getShell(),
						                "Prove success", status.getMessage());
					}
				});
			} else {
				// Something went horribly wrong
				Workbench.getInstance().getDisplay().asyncExec(new Runnable() {
					public void run() {
						MessageDialog.openError(Workbench.getInstance()
						                .getActiveWorkbenchWindow().getShell(), "Prove error",
						                status.getMessage());
					}
				});
			}
		}
	}
}
