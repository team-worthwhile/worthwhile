package edu.kit.iti.formal.pse.worthwhile.debugger.launching;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public class WorthwhileLaunchShortcut implements ILaunchShortcut {

    @Override
    public void launch(final ISelection selection, final String mode) {
	// TODO Auto-generated method stub
	System.out.println("launching selection");
    }

    @Override
    public void launch(final IEditorPart editor, final String mode) {
	// TODO Auto-generated method stub
	System.out.println("launching editor");
    }

}
