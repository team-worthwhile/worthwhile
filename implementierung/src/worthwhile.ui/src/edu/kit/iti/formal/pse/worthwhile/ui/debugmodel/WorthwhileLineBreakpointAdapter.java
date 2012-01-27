package edu.kit.iti.formal.pse.worthwhile.ui.debugmodel;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;

import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileLineBreakpoint;
import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileEditor;

public class WorthwhileLineBreakpointAdapter implements IToggleBreakpointsTarget {

	@Override
	public final void toggleLineBreakpoints(final IWorkbenchPart part, final ISelection selection)
	                throws CoreException {
		WorthwhileEditor editor = getEditor(part);
		if (editor != null) {
			// get the file that is open in this editor.
			IResource resource = (IResource) editor.getEditorInput().getAdapter(IResource.class);

			// retrieve the currently selected line.
			ITextSelection textSelection = (ITextSelection) selection;
			int lineNumber = textSelection.getStartLine();
			IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
			                .getBreakpoints(ID_WORTHWHILE_DEBUG_MODEL);
			for (int i = 0; i < breakpoints.length; i++) {
				IBreakpoint breakpoint = breakpoints[i];
				if (resource.equals(breakpoint.getMarker().getResource())) {
					if (((ILineBreakpoint) breakpoint).getLineNumber() == (lineNumber + 1)) {
						breakpoint.delete();
						return;
					}
				}
			}
			WorthwhileLineBreakpoint lineBreakpoint = new WorthwhileLineBreakpoint(resource, lineNumber + 1);
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(lineBreakpoint);
		}
	}

	@Override
	public final boolean canToggleLineBreakpoints(final IWorkbenchPart part, final ISelection selection) {
		// We can only toggle breakpoints in a part if the part is a Worthwhile editor.
		return this.getEditor(part) != null;
	}

	@Override
	public void toggleMethodBreakpoints(final IWorkbenchPart part, final ISelection selection) throws CoreException {
		// we don’t support method breakpoints
	}

	@Override
	public final boolean canToggleMethodBreakpoints(final IWorkbenchPart part, final ISelection selection) {
		// we don’t support method breakpoints
		return false;
	}

	@Override
	public void toggleWatchpoints(final IWorkbenchPart part, final ISelection selection) throws CoreException {
		// TODO toggle watchpoints
	}

	@Override
	public final boolean canToggleWatchpoints(final IWorkbenchPart part, final ISelection selection) {
		// TODO we don’t support watchpoints (yet!)
		return false;
	}

	/**
	 * Returns the given workbench part if it is a Worthwhile editor, {@code null} otherwise.
	 * 
	 * @param part
	 *                The workbench part
	 * @return the given workbench part if it is a Worthwhile editor, {@code null} otherwise.
	 */
	private WorthwhileEditor getEditor(final IWorkbenchPart part) {
		if (part instanceof WorthwhileEditor) {
			return (WorthwhileEditor) part;
		} else {
			return null;
		}
	}

}
