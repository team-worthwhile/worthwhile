package edu.kit.iti.formal.pse.worthwhile.ui.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.ui.actions.RulerBreakpointAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IUpdate;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileLineBreakpoint;

/**
 * A ruler action to open the properties page of a breakpoint.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileRulerBreakpointPropertiesAction extends RulerBreakpointAction implements IUpdate {

	/**
	 * Creates a new instance of the {@link WorthwhileRulerBreakpointPropertiesAction}.
	 * 
	 * @param editor
	 *                {@inheritDoc}
	 * @param info
	 *                {@inheritDoc}
	 */
	public WorthwhileRulerBreakpointPropertiesAction(final ITextEditor editor, final IVerticalRulerInfo info) {
		super(editor, info);
		this.setText("Breakpoint properties …");
	}
	
	@Override
        public final void update() {
		this.setEnabled(this.getBreakpoint() != null);
	}

	@Override
	public final void run() {
		if (this.getBreakpoint() != null) {
			String currentCondition = this.getBreakpoint().getMarker()
			                .getAttribute(WorthwhileLineBreakpoint.CONDITION, "");

			InputDialog dialog = new InputDialog(this.getEditor().getSite().getShell(),
			                "Breakpoint properties", "Breakpoint condition", currentCondition, null);

			if (dialog.open() == IStatus.OK) {
				try {
					this.getBreakpoint()
					                .getMarker()
					                .setAttribute(WorthwhileLineBreakpoint.CONDITION,
					                                dialog.getValue());
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
