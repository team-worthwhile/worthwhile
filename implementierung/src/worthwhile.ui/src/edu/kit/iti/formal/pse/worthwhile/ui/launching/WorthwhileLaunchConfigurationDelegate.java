package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.debugger.DebugHelper;
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

	/**
	 * A resource set provider for loading the program.
	 */
	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Override
	public final void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
	                final IProgressMonitor monitor) throws CoreException {

		// Get the file to execute from the launch configuration.
		String path = configuration.getAttribute(ATTR_PATH, "");
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));

		if (file == null) {
			DebugHelper.showError("The specified source file cannot be found.", null);
		}

		// Load the model from the file
		XtextResourceSet resourceSet = (XtextResourceSet) resourceSetProvider.get(file.getProject());
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, true);
		Resource resource = resourceSet.getResource(URI.createURI(path), true);

		// Check if there are no parser errors
		if (!resource.getErrors().isEmpty()) {
			DebugHelper.showError("There are errors in the source file.", null);
		}

		// Create and run the interpreter.
		Program program = (Program) resource.getContents().get(0);
		final Interpreter interpreter = new Interpreter(program);

		IDebugTarget target = new WorthwhileDebugTarget(launch, interpreter);
		launch.addDebugTarget(target);
	}

}
