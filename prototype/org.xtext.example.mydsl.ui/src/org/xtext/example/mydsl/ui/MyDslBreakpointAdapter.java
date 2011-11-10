package org.xtext.example.mydsl.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.xtext.example.mydsl.plugin.breakpoints.*;

public class MyDslBreakpointAdapter implements IToggleBreakpointsTarget {

	public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection) 
            throws CoreException {
      ITextEditor textEditor = getEditor(part);
      if (textEditor != null) {
         IResource resource = (IResource) textEditor.getEditorInput()
                                             .getAdapter(IResource.class);
         ITextSelection textSelection = (ITextSelection) selection;
         int lineNumber = textSelection.getStartLine();
         IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
                        .getBreakpoints("42");
         for (int i = 0; i < breakpoints.length; i++) {
            IBreakpoint breakpoint = breakpoints[i];
            if (resource.equals(breakpoint.getMarker().getResource())) {
               if (((ILineBreakpoint)breakpoint).getLineNumber() == (lineNumber + 1)) {
               breakpoint.delete();
                  return;
               }
            }
         }
   MyDslLineBreakpoint lineBreakpoint = new MyDslLineBreakpoint(resource, lineNumber + 1);
         DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(lineBreakpoint);
      }
   }
	
	private ITextEditor getEditor(IWorkbenchPart part) {
		if (part instanceof ITextEditor) {
			ITextEditor editorPart = (ITextEditor) part;
			IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null) {
				String extension = resource.getFileExtension();
				if (extension != null && extension.equals("mydsl")) {
					return editorPart;
				}
			}
		}
		return null;		
	}

	@Override
	public boolean canToggleLineBreakpoints(IWorkbenchPart part,
			ISelection selection) {
		// TODO Auto-generated method stub
		return getEditor(part) != null;
	}

	@Override
	public void toggleMethodBreakpoints(IWorkbenchPart part,
			ISelection selection) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canToggleMethodBreakpoints(IWorkbenchPart part,
			ISelection selection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canToggleWatchpoints(IWorkbenchPart part,
			ISelection selection) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
