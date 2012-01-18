package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;

import edu.kit.iti.formal.pse.worthwhile.debugger.IWorthwhileDebugConstants;

/**
 * A base class for all elements of the Worthwhile debug model.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugElement extends PlatformObject implements IDebugElement {

	/**
	 * The debug target this element belongs to.
	 */
	private WorthwhileDebugTarget debugTarget;

	/**
	 * Creates a new instance of the {@link WorthwhileDebugElement} class.
	 * 
	 * @param debugTarget
	 *                The debug target this element belongs to.
	 */
	public WorthwhileDebugElement(final WorthwhileDebugTarget debugTarget) {
		this.debugTarget = debugTarget;
	}

	@Override
	public final WorthwhileDebugTarget getDebugTarget() {
		return this.debugTarget;
	}

	/**
	 * Sets the debug target.
	 * 
	 * @param debugTarget
	 *                The debug target
	 */
	public final void setDebugTarget(final WorthwhileDebugTarget debugTarget) {
		this.debugTarget = debugTarget;
	}

	@Override
	public final ILaunch getLaunch() {
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
	 *                the event to be fired
	 */
	protected final void fireEvent(final DebugEvent event) {
		System.out.println(event.toString());
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { event });
		// TODO: fire model changed event
		// ModelDelta delta = new ModelDelta(DebugPlugin.getDefault().getLaunchManager(), IModelDelta.CONTENT);
		// DebugPlugin.getDefault().
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
	 *                event detail code
	 */
	protected final void fireResumeEvent(final int detail) {
		fireEvent(new DebugEvent(this, DebugEvent.RESUME, detail));
	}

	/**
	 * Fires a <code>SUSPEND</code> event for this element with the given detail.
	 * 
	 * @param detail
	 *                event detail code
	 */
	protected final void fireSuspendEvent(final int detail) {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND, detail));
	}

	/**
	 * Fires a <code>TERMINATE</code> event for this element.
	 */
	protected final void fireTerminateEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

}
