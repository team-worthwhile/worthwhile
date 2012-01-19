package edu.kit.iti.formal.pse.worthwhile.debugger.launching;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;
import org.eclipse.debug.core.sourcelookup.containers.FolderSourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.ProjectSourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.WorkspaceSourceContainer;
import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

/**
 * Computes the source file path from a launch configuration.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileSourcePathComputerDelegate implements ISourcePathComputerDelegate {

	@Override
	public final ISourceContainer[] computeSourceContainers(final ILaunchConfiguration configuration,
	                final IProgressMonitor monitor) throws CoreException {

		// see also http://www.eclipse.org/articles/Article-Debugger/how-to.html

		// Get the path to the source file from the launch configuration
		String path = configuration.getAttribute(ATTR_PATH, (String) null);
		ISourceContainer sourceContainer = null;

		// Try to find the specified file in the workspace.
		if (path != null) {
			IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
			if (resource != null) {
				IContainer container = resource.getParent();
				if (container.getType() == IResource.PROJECT) {
					sourceContainer = new ProjectSourceContainer((IProject) container, false);
				} else if (container.getType() == IResource.FOLDER) {
					sourceContainer = new FolderSourceContainer(container, false);
				}
			}
		}

		// If all else fails, return a source container that simply consists of the entire workspace.
		if (sourceContainer == null) {
			sourceContainer = new WorkspaceSourceContainer();
		}
		return new ISourceContainer[] { sourceContainer };
	}

}
