package org.xtext.example.mydsl.plugin.launching;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public class LaunchShortcut implements ILaunchShortcut {

	@Override
	public void launch(ISelection selection, String mode) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		// TODO Auto-generated method stub
			@SuppressWarnings("unused")
			IEditorPart _editor = editor;
	}

}
