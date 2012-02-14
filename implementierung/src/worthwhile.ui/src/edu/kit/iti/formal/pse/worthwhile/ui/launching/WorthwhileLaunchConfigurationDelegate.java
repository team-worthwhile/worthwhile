package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.debugger.DebugHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * This delegate is responsible for launching a Worthwhile program from a given launch configuration.
 * 
 * @author Joachim
 * 
 */
public abstract class WorthwhileLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	/**
	 * A resource set provider for loading the program.
	 */
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	/**
	 * The validator.
	 */
	@Inject
	private IResourceValidator validator;

	/**
	 * Gets a program from the specified launch configuration.
	 * 
	 * @param configuration
	 *                The launch configuration.
	 * @return The root AST node of the program launched by this configuration, or {@code null} if the file contains
	 *         errors.
	 * @throws CoreException
	 *                 if getting the program from the file fails
	 */
	protected final Program getProgram(final ILaunchConfiguration configuration) throws CoreException {
		// Get the file to execute from the launch configuration.
		String path = configuration.getAttribute(ATTR_PATH, "");
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));

		if (file == null) {
			DebugHelper.throwError("The specified source file cannot be found.", null);
		}

		// Load the model from the file
		XtextResourceSet resourceSet = (XtextResourceSet) resourceSetProvider.get(file.getProject());
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, true);
		Resource resource = resourceSet.getResource(URI.createURI(path), true);

		// Check if there are no parser or validator errors
		if (!resource.getErrors().isEmpty()) {
			StringBuilder errorStringBuilder = new StringBuilder("There are syntax errors in the source file:");
			
			for (Diagnostic diag : resource.getErrors()) {
				errorStringBuilder.append("\nLine " + diag.getLine() + ": " + diag.getMessage());
			}
			
			DebugHelper.throwError(errorStringBuilder.toString(), null);
		} else {
			List<Issue> validationErrors = validator.validate(resource, CheckMode.ALL, null);
			if (validationErrors.size() > 0) {
				StringBuilder errorStringBuilder = new StringBuilder("There are validation errors in the source file:");
				
				for (Issue issue : validationErrors) {
					errorStringBuilder.append("\nLine " + issue.getLineNumber() + ": " + issue.getMessage());
				}
				
				DebugHelper.throwError(errorStringBuilder.toString(), null);
			}
		}

		return (Program) resource.getContents().get(0);
	}
}
