package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugTarget;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.ui.preferences.WorthwhilePreferenceConstants;

/**
 * Starts the execution of a Worthwhile program via the interpreter/debugger.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileExecuteLaunchConfigurationDelegate extends WorthwhileLaunchConfigurationDelegate {

	/**
	 * The preference store.
	 */
	@Inject
	private IPreferenceStore preferenceStore;

	@Override
	public final void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
	                final IProgressMonitor monitor) throws CoreException {

		Program program = this.getProgram(configuration);

		if (program != null) {
			// Create and run the interpreter.
			SpecificationChecker specChecker = new SpecificationChecker();
			specChecker.setTimeout(preferenceStore.getInt(WorthwhilePreferenceConstants.PROVER_TIMEOUT));
			final Interpreter interpreter = new Interpreter(program, specChecker);

			IDebugTarget target = new WorthwhileDebugTarget(launch, interpreter);
			launch.addDebugTarget(target);
		}
	}

}
