package edu.kit.iti.formal.pse.worthwhile.ui.debugmodel;

import org.eclipse.core.runtime.IAdapterFactory;

import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileEditor;

/**
 * A factory class which returns a breakpoint adapter for the Worthwhile Text editor.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileBreakpointAdapterFactory implements IAdapterFactory {

    @SuppressWarnings("rawtypes")
    @Override
    public final Object getAdapter(final Object adaptableObject, final Class adapterType) {
	if (adaptableObject instanceof WorthwhileEditor) {
	    return new WorthwhileLineBreakpointAdapter();
	}
	return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public final Class[] getAdapterList() {
	return new Class[] {WorthwhileLineBreakpointAdapter.class};
    }

}
