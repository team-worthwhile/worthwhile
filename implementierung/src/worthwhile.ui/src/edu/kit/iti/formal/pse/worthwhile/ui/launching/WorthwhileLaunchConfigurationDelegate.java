package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

import java.util.Iterator;
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
import org.eclipse.xtext.diagnostics.Severity;
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
	 * Gets a program from the specified file.
	 * 
	 * @param file
	 *                The source file.
	 * @return The root AST node of the program launched by this configuration, or {@code null} if the file contains
	 *         errors.
	 * @throws CoreException
	 *                 if getting the program from the file fails
	 */
	protected final Program getProgram(final IFile file) throws CoreException {
		// Load the model from the file
		XtextResourceSet resourceSet = (XtextResourceSet) resourceSetProvider.get(file.getProject());
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, true);
		Resource resource = resourceSet.getResource(URI.createURI(file.getFullPath().toString()), true);

		// Validate the model (includes both syntax and validator errors)
		List<Issue> errors = validator.validate(resource, CheckMode.ALL, null);
		StringBuilder errorStringBuilder = new StringBuilder("There are errors in the source file:");
		int errorCount = 0;

		for (Issue issue : errors) {
			if (issue.getSeverity().equals(Severity.ERROR)) {
				errorCount++;
				errorStringBuilder
				                .append("\nLine " + issue.getLineNumber() + ": " + issue.getMessage());
			}
		}

		if (errorCount > 0) {
			DebugHelper.throwError(errorStringBuilder.toString(), null);
		}

		return (Program) resource.getContents().get(0);
	}

	/**
	 * Gets the file being launched from the launch configuration.
	 * 
	 * @param configuration
	 *                The launch configuration.
	 * @return The file being launched
	 * @throws CoreException
	 *                 if getting the file from the configuration fails.
	 */
	protected final IFile getFile(final ILaunchConfiguration configuration) throws CoreException {
		String path = configuration.getAttribute(ATTR_PATH, "");
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));

		if (file == null) {
			DebugHelper.throwError("The specified source file cannot be found.", null);
		}

		return file;
	}
}
