package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

import edu.kit.iti.formal.pse.worthwhile.debugger.IWorthwhileDebugConstants;

public class WorthwhileDebugElement extends PlatformObject implements IDebugElement {

    /**
     * The debug target this element belongs to.
     */
    protected WorthwhileDebugTarget debugTarget;
    
    public WorthwhileDebugElement(WorthwhileDebugTarget debugTarget) {
	this.debugTarget = debugTarget;
    }

    @Override
    public final IDebugTarget getDebugTarget() {
	return this.debugTarget;
    }

    @Override
    public ILaunch getLaunch() {
	return this.debugTarget.doGetLaunch();
    }

    @Override
    public final String getModelIdentifier() {
	return IWorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;
    }

    @Override
    public final Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
	if (adapter == IDebugElement.class) {
	    return this;
	}
	return super.getAdapter(adapter);
    }

    /**
     * Fires a debug event.
     * 
     * @param event
     *            the event to be fired
     */
    protected final void fireEvent(final DebugEvent event) {
	DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { event });
    }

    /**
     * Fires a <code>CREATE</code> event for this element.
     */
    protected final void fireCreationEvent() {
	fireEvent(new DebugEvent(this, DebugEvent.CREATE));
    }

    /**
     * Fires a <code>RESUME</code> event for this element with the given detail.
     * 
     * @param detail
     *            event detail code
     */
    public final void fireResumeEvent(final int detail) {
	fireEvent(new DebugEvent(this, DebugEvent.RESUME, detail));
    }

    /**
     * Fires a <code>SUSPEND</code> event for this element with the given detail.
     * 
     * @param detail
     *            event detail code
     */
    public final void fireSuspendEvent(final int detail) {
	fireEvent(new DebugEvent(this, DebugEvent.SUSPEND, detail));
    }

    /**
     * Fires a <code>TERMINATE</code> event for this element.
     */
    protected final void fireTerminateEvent() {
	fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
    }

}
