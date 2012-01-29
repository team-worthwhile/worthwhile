package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.ILaunchConfiguration;
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
		ILaunchConfiguration launchConfiguration = LaunchHelper.getLaunchConfiguration(file);
		if (launchConfiguration != null) {
			DebugUITools.launch(launchConfiguration, mode);
		}
	}

}
