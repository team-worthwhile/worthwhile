package edu.kit.iti.formal.pse.worthwhile.ui.proving;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.ui.internal.Workbench;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.debugger.DebugHelper;
import edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileProverMarkerHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;
import edu.kit.iti.formal.pse.worthwhile.prover.Z3Prover;
import edu.kit.iti.formal.pse.worthwhile.ui.launching.WorthwhileLaunchConfigurationDelegate;
import edu.kit.iti.formal.pse.worthwhile.ui.preferences.WorthwhilePreferenceConstants;
import edu.kit.iti.formal.pse.worthwhile.util.WorthwhileMarkerHelper;

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

		IFile file = this.getFile(configuration);
		Program program = this.getProgram(file);

		if (program != null) {
			// Create and run the prover and specification checker.
			Z3Prover prover = new Z3Prover(
			                preferenceStore.getString(WorthwhilePreferenceConstants.PROVER_PATH),
			                preferenceStore.getInt(WorthwhilePreferenceConstants.PROVER_TIMEOUT) * 1000);

			SpecificationChecker specChecker = new SpecificationChecker(prover);

			// Create a new DebugTarget which is necessary for marking the program as terminated.
			final WorthwhileProveJob proveJob = new WorthwhileProveJob("Prove " + file.getName(),
			                specChecker, program, new WorthwhileProverMarkerHelper(
			                                new WorthwhileMarkerHelper(file)));
			final WorthwhileProveDebugTarget finishedListener = new WorthwhileProveDebugTarget(launch);
			proveJob.addJobChangeListener(finishedListener);
			launch.addDebugTarget(finishedListener);
			proveJob.schedule();
		}
	}

	/**
	 * A listener that listens for the end of execution of the prove job.
	 * 
	 * @author Joachim
	 * 
	 */
	private class WorthwhileProveDebugTarget extends JobChangeAdapter implements IDebugTarget {

		/**
		 * The launch object that was used to launch the program.
		 */
		private final ILaunch launch;

		/**
		 * Whether the debug target is terminated.
		 */
		private boolean isTerminated = false;

		/**
		 * Creates a new instance of the {@link WorthwhileProveDebugTarget} class.
		 * 
		 * @param launch
		 *                The launch object that was used to launch the program.
		 */
		public WorthwhileProveDebugTarget(final ILaunch launch) {
			super();
			this.launch = launch;
		}

		@Override
		public void done(final IJobChangeEvent event) {
			final IStatus status = event.getResult();
			Runnable dialogDisplayRunnable = null;

			if (status.isOK()) {
				// Display custom dialog when the proof was successful.
				dialogDisplayRunnable = new Runnable() {
					public void run() {
						Dialog dialog = new WorthwhileSuccessKidDialog(Workbench.getInstance()
						                .getActiveWorkbenchWindow().getShell(),
						                "Prove success",
						                "The program conforms to the specification.");

						dialog.open();
					}
				};
			} else {
				String title;
				String message;

				if (status instanceof ProveResultStatus) {
					if (Validity.INVALID.equals(((ProveResultStatus) status).getValidity())) {
						message = "It cannot be proven that the program conforms to the specification.";
					} else {
						message = "The validity of the program could not be determined.";
					}

					title = "Prove unsuccessful";
				} else {
					// Something went horribly wrong
					title = "Prove error";
					message = "There was an unexpected error invoking the prover:\n\n"
					                + status.getMessage();
				}

				// Copy variable contents into new final variables, since the variables used in the
				// inner Runnable class need to be final.
				final String dialogTitle = title;
				final String dialogMessage = message;

				// Display a boring standard dialog.
				dialogDisplayRunnable = new Runnable() {
					public void run() {
						MessageDialog.open(MessageDialog.ERROR, Workbench.getInstance()
						                .getActiveWorkbenchWindow().getShell(), dialogTitle,
						                dialogMessage, SWT.NONE);
					}
				};
			}

			Workbench.getInstance().getDisplay().asyncExec(dialogDisplayRunnable);

			try {
				this.terminate();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}

		@Override
		public IDebugTarget getDebugTarget() {
			return this;
		}

		@Override
		public ILaunch getLaunch() {
			return this.launch;
		}

		@Override
		public String getModelIdentifier() {
			return WorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;
		}

		@Override
		public Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
			return null;
		}

		@Override
		public boolean canTerminate() {
			return false;
		}

		@Override
		public boolean isTerminated() {
			return this.isTerminated;
		}

		@Override
		public void terminate() throws DebugException {
			this.isTerminated = true;
			DebugPlugin.getDefault().fireDebugEventSet(
			                new DebugEvent[] { new DebugEvent(this, DebugEvent.TERMINATE) });
		}

		@Override
		public boolean canResume() {
			return false;
		}

		@Override
		public boolean canSuspend() {
			return false;
		}

		@Override
		public boolean isSuspended() {
			return false;
		}

		@Override
		public void resume() throws DebugException {
		}

		@Override
		public void suspend() throws DebugException {
		}

		@Override
		public void breakpointAdded(final IBreakpoint breakpoint) {
		}

		@Override
		public void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		}

		@Override
		public void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		}

		@Override
		public boolean canDisconnect() {
			return false;
		}

		@Override
		public void disconnect() throws DebugException {
		}

		@Override
		public boolean isDisconnected() {
			return false;
		}

		@Override
		public IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
			return null;
		}

		@Override
		public boolean supportsStorageRetrieval() {
			return false;
		}

		@Override
		public String getName() throws DebugException {
			return "Prove " + DebugHelper.getSourceName(this.launch);
		}

		@Override
		public IProcess getProcess() {
			return null;
		}

		@Override
		public IThread[] getThreads() throws DebugException {
			return new IThread[0];
		}

		@Override
		public boolean hasThreads() throws DebugException {
			return false;
		}

		@Override
		public boolean supportsBreakpoint(final IBreakpoint arg0) {
			return false;
		}
	}
}
