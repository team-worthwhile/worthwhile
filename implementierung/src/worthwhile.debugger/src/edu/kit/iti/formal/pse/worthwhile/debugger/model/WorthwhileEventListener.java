package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import edu.kit.iti.formal.pse.worthwhile.interpreter.AbstractDebugEventListener;

/**
 * An event listener base class that works with the Eclipse debug model.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileEventListener extends AbstractDebugEventListener {

    /**
     * The debug target to send messages to.
     */
    private final WorthwhileDebugTarget debugTarget;

    /**
     * Gets the debug target.
     * 
     * @return the debug target
     */
    public final WorthwhileDebugTarget getDebugTarget() {
	return debugTarget;
    }

    /**
     * Creates a new instance of the {@link WorthwhileEventListener} class.
     * 
     * @param debugTarget
     *            The debug target to send messages to. May not be null.
     */
    public WorthwhileEventListener(final WorthwhileDebugTarget debugTarget) {
	if (debugTarget == null) {
	    throw new IllegalArgumentException("Debug target may not be null.");
	}

	this.debugTarget = debugTarget;
    }

}
