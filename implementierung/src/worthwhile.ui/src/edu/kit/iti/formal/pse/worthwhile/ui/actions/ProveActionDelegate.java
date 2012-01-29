package edu.kit.iti.formal.pse.worthwhile.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileEditor;
import edu.kit.iti.formal.pse.worthwhile.ui.launching.LaunchHelper;

/**
 * An action delegate for the "prove program" action.
 * 
 * @author Joachim
 * 
 */
public class ProveActionDelegate implements IEditorActionDelegate {

	/**
	 * The currently active editor.
	 */
	private IEditorPart currentEditor;

	@Override
	public final void setActiveEditor(final IAction action, final IEditorPart targetEditor) {
		this.currentEditor = targetEditor;

		action.setEnabled(targetEditor != null && targetEditor instanceof WorthwhileEditor);
	}

	@Override
	public final void run(final IAction action) {
		if (this.currentEditor != null) {
			IFile file = (IFile) this.currentEditor.getEditorInput().getAdapter(IFile.class);
			ILaunchConfiguration launchConfiguration = LaunchHelper.getLaunchConfiguration(file);
			if (launchConfiguration != null) {
				DebugUITools.launch(launchConfiguration, "prove");
			}
		}
	}

	@Override
	public void selectionChanged(final IAction action, final ISelection selection) {
	}

}
