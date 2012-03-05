package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import org.eclipse.core.resources.IFile;
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
import edu.kit.iti.formal.pse.worthwhile.prover.caller.Z3Prover;
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

		IFile file = this.getFile(configuration);
		Program program = this.getProgram(file);

		if (program != null) {
			// Create and run the prover, specification checker, and interpreter.
			Z3Prover prover = new Z3Prover(
			                preferenceStore.getString(WorthwhilePreferenceConstants.PROVER_PATH),
			                preferenceStore.getInt(WorthwhilePreferenceConstants.PROVER_TIMEOUT) * 1000);

			SpecificationChecker specChecker = new SpecificationChecker(prover);

			Interpreter interpreter = new Interpreter(program, specChecker);

			IDebugTarget target = new WorthwhileDebugTarget(launch, interpreter);
			launch.addDebugTarget(target);
		}
	}

}
