package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Starts the prover with the specified program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileProveLaunchConfigurationDelegate extends WorthwhileLaunchConfigurationDelegate {

	@Override
	public final void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
	                final IProgressMonitor monitor) throws CoreException {

		Program program = this.getProgram(configuration);

		if (program != null) {
			new Job("Prover") {

				@Override
				protected IStatus run(final IProgressMonitor monitor) {
					try {
	                                        Thread.sleep(10000);
                                        } catch (InterruptedException e) {
	                                        // TODO Auto-generated catch block
	                                        e.printStackTrace();
                                        }
					return Status.OK_STATUS;
				}

			}.schedule();
		}

	}

}
