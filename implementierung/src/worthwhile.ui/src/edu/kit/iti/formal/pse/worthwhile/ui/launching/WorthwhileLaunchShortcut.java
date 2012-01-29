package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;
import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.LAUNCH_CONFIG_TYPE;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;

/**
 * Provides a shortcut to launch a Worthwhile program from a selection or from the editor.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileLaunchShortcut implements ILaunchShortcut {

	@Override
	public final void launch(final ISelection selection, final String mode) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				if (structuredSelection.getFirstElement() instanceof IFile) {
					launchFile((IFile) structuredSelection.getFirstElement(), mode);
				}
			}
		}
	}

	@Override
	public final void launch(final IEditorPart editor, final String mode) {
		IFile file = (IFile) editor.getEditorInput().getAdapter(IFile.class);
		launchFile(file, mode);
	}

	/**
	 * Launches a program from a file.
	 * 
	 * @param file
	 *                The file to launch.
	 * @param mode
	 *                The mode (run, debug) in which to launch the program.
	 */
	private void launchFile(final IFile file, final String mode) {
		// Create a new launchable configuration and launch it.
		ILaunchConfiguration launchConfiguration = getLaunchConfiguration(file);
		if (launchConfiguration != null) {
			DebugUITools.launch(launchConfiguration, mode);
		}
	}

	/**
	 * Gets a launch configuration for a file.
	 * 
	 * If a configuration with the name of the file (slashes replaced by underscores) already exists, it is taken.
	 * Otherwise a new one with default values is created.
	 * 
	 * @param file
	 *                The file for which to get the launch configuration.
	 * @return A launch configuration for the file, or {@code null} if an error occured.
	 */
	private ILaunchConfiguration getLaunchConfiguration(final IFile file) {
		// Get the launch configuration type from the launch manager
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager
		                .getLaunchConfigurationType(LAUNCH_CONFIG_TYPE);
		final String launchConfigurationName = file.getFullPath().toString().replace("/", "_");

		try {
			// Search for pre-existing configurations.
			ILaunchConfiguration[] configurations = launchManager
			                .getLaunchConfigurations(launchConfigurationType);
			for (int i = 0; i < configurations.length; i++) {
				ILaunchConfiguration configuration = configurations[i];
				if (configuration.getName().equals(launchConfigurationName)) {
					return configuration;
				}
			}

			// Create a new instance of the launch configuration type and set the path to the file.
			ILaunchConfigurationWorkingCopy workingCopy = launchConfigurationType.newInstance(null,
			                launchConfigurationName);
			workingCopy.setAttribute(ATTR_PATH, file.getFullPath().toString());
			return workingCopy.doSave();

		} catch (CoreException e) {
			// TODO Show error message
			e.printStackTrace();
			return null;
		}
	}

}
