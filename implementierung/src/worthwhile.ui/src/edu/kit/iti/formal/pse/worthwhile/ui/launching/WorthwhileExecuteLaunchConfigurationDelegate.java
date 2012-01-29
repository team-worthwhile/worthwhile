package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugTarget;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;

/**
 * Starts the execution of a Worthwhile program via the interpreter/debugger.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileExecuteLaunchConfigurationDelegate extends WorthwhileLaunchConfigurationDelegate {

	@Override
	public final void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
	                final IProgressMonitor monitor) throws CoreException {

		Program program = this.getProgram(configuration);

		if (program != null) {
			// Create and run the interpreter.
			final Interpreter interpreter = new Interpreter(program, new SpecificationChecker());

			IDebugTarget target = new WorthwhileDebugTarget(launch, interpreter);
			launch.addDebugTarget(target);
		}
	}

}
