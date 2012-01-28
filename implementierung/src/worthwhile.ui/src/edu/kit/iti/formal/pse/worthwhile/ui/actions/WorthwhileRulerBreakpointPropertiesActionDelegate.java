package edu.kit.iti.formal.pse.worthwhile.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * A delegate for providing the "Breakpoint properties …" action in the ruler.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileRulerBreakpointPropertiesActionDelegate extends AbstractRulerActionDelegate {

	@Override
	protected final IAction createAction(final ITextEditor editor, final IVerticalRulerInfo rulerInfo) {
		return new WorthwhileRulerBreakpointPropertiesAction(editor, rulerInfo);
	}

}
