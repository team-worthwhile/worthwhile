package edu.kit.iti.formal.pse.worthwhile.ui.debugmodel;

import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;
import org.eclipse.debug.core.model.IWatchpoint;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import edu.kit.iti.formal.pse.worthwhile.debugger.breakpoints.WorthwhileLineBreakpoint;
import edu.kit.iti.formal.pse.worthwhile.debugger.breakpoints.WorthwhileWatchpoint;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileEditor;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * An adapter for toggling line breakpoints and watch points.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileBreakpointAdapter implements IToggleBreakpointsTarget {

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
					if (breakpoint instanceof WorthwhileLineBreakpoint
					                && ((ILineBreakpoint) breakpoint).getLineNumber() == (lineNumber + 1)) {
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
	public final void toggleWatchpoints(final IWorkbenchPart part, final ISelection selection) throws CoreException {
		WorthwhileEditor editor = getEditor(part);
		if (editor != null) {
			// get the file that is open in this editor.
			IResource resource = (IResource) editor.getEditorInput().getAdapter(IResource.class);

			// retrieve the current selection.
			ITextSelection textSelection = (ITextSelection) selection;
			ASTNode node = (ASTNode) getNodeAt(editor.getDocument(), textSelection.getOffset());

			// Retrieve the variable declaration on this line.
			if (node != null) {
				VariableDeclaration vardec = (new VariableFinder()).apply(node);
				if (vardec != null) {
					int lineNumber = NodeHelper.getLine(vardec);
					IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
					                .getBreakpoints(ID_WORTHWHILE_DEBUG_MODEL);
					for (int i = 0; i < breakpoints.length; i++) {
						IBreakpoint breakpoint = breakpoints[i];
						if (breakpoint instanceof IWatchpoint
						                && resource.equals(breakpoint.getMarker().getResource())) {
							if (((ILineBreakpoint) breakpoint).getLineNumber() == lineNumber) {
								breakpoint.delete();
								return;
							}
						}
					}

					WorthwhileWatchpoint watchpoint = new WorthwhileWatchpoint(resource,
					                lineNumber, vardec.getName());
					DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(watchpoint);
				}
			}
		}
	}

	@Override
	public final boolean canToggleWatchpoints(final IWorkbenchPart part, final ISelection selection) {
		WorthwhileEditor editor = this.getEditor(part);

		if (editor == null) {
			return false;
		}

		if (selection instanceof TextSelection) {
			TextSelection textSelection = (TextSelection) selection;

			IXtextDocument document = editor.getDocument();
			ASTNode node = (ASTNode) getNodeAt(document, textSelection.getOffset());

			if (node != null) {
				if ((new VariableFinder()).apply(node) != null) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Gets the AST object at the given position in the document.
	 * 
	 * @param document
	 *                The document in which to look for an AST object.
	 * @param offset
	 *                The position in the document at which to look for an AST object.
	 * @return the AST object at the position {@code offset} in the document, if one exists.
	 */
	private EObject getNodeAt(final IXtextDocument document, final int offset) {
		return document.readOnly(new IUnitOfWork<EObject, XtextResource>() {
			@Override
			public EObject exec(final XtextResource localResource) throws Exception {
				return new EObjectAtOffsetHelper().resolveElementAt(localResource, offset);
			}
		});
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

	/**
	 * Returns the variable declaration specified or referenced by the current node, if one exists.
	 * 
	 * @author Joachim
	 * 
	 */
	private class VariableFinder extends ASTNodeReturnVisitor<VariableDeclaration> {

		@Override
		public void defaultOperation(final ASTNode node) {
		}

		@Override
		public void visit(final VariableReference node) {
			this.setReturnValue(node.getVariable());
		}

		@Override
		public void visit(final VariableDeclaration node) {
			this.setReturnValue(node);
		}

	}

}
