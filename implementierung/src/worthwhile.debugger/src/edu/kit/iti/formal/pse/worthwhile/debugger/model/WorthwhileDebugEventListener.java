package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import edu.kit.iti.formal.pse.worthwhile.interpreter.AbstractWorthwhileDebugEventListener;

/**
 * An event listener that passes on debug events to the debug target.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugEventListener extends AbstractWorthwhileDebugEventListener {

    /**
     * The debug target to send messages to.
     */
    private WorthwhileDebugTarget debugTarget;

    /**
     * Creates a new instance of the {@link WorthwhileDebugEventListener} class.
     * 
     * @param debugTarget
     *            The debug target to send messages to. May not be null.
     */
    public WorthwhileDebugEventListener(final WorthwhileDebugTarget debugTarget) {
	if (debugTarget == null) {
	    throw new IllegalArgumentException("Debug target may not be null.");
	}

	this.debugTarget = debugTarget;
    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub
    }

    @Override
    public void statementWillExecute() {
	// TODO Auto-generated method stub
    }

    @Override
    public void executionStarted() {
	// TODO Auto-generated method stub
    }

}
