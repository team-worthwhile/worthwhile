package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugTarget;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * This delegate is responsible for launching a Worthwhile program from a given launch configuration.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

    @Inject
    private IResourceSetProvider resourceSetProvider; // TODO: This makes the debugger plugin depend on
						      // xtext.ui, EMF and all sorts of horrible stuff

    @Override
    public final void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
	    final IProgressMonitor monitor) throws CoreException {

	// Get the file to execute from the launch configuration.
	String path = configuration.getAttribute(WorthwhileLaunchConfigurationConstants.ATTR_PATH, "");
	IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));

	if (file == null) {
	    // TODO error
	    return;
	}

	// Load the model from the file
	XtextResourceSet resourceSet = (XtextResourceSet) resourceSetProvider.get(file.getProject());
	resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, true);
	Resource resource = resourceSet.getResource(URI.createURI(path), true);
	Program program = (Program) resource.getContents().get(0);

	// Create and run the interpreter.
	final Interpreter interpreter = new Interpreter(program);

	if (mode.equals(ILaunchManager.DEBUG_MODE)) {
	    IDebugTarget target = new WorthwhileDebugTarget(launch, interpreter);
	    launch.addDebugTarget(target);
	} else {

	    DebugPlugin.getDefault().asyncExec(new Runnable() {
		@Override
		public void run() {
		    interpreter.execute();
		    try {
			Thread.sleep(3000);
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}

	    });
	}
    }

}
