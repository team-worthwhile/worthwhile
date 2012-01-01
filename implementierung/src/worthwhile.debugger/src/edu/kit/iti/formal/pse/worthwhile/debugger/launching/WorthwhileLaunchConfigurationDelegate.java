package edu.kit.iti.formal.pse.worthwhile.debugger.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugTarget;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;

public class WorthwhileLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

    @Override
    public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch, final IProgressMonitor monitor)
	    throws CoreException {
	// TODO Auto-generated method stub

	// IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(program));
	
	Interpreter interpreter = null;
	
	if (mode.equals(ILaunchManager.DEBUG_MODE)) {
		IDebugTarget target = new WorthwhileDebugTarget(launch, interpreter);
		launch.addDebugTarget(target);
	}
    }

}
