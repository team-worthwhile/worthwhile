package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import edu.kit.iti.formal.pse.worthwhile.interpreter.AbstractDebugEventListener;
import edu.kit.iti.formal.pse.worthwhile.interpreter.InterpreterError;
import edu.kit.iti.formal.pse.worthwhile.interpreter.LineBreakpoint;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * An event listener that passes on debug events to the debug target.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugEventListener extends AbstractDebugEventListener {

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
    public final void executionFailed(final Statement statement, final InterpreterError error) {
	
    }

    @Override
    public final void executionCompleted() {
	debugTarget.executionTerminated();
    }

    @Override
    public final void executionStarted() {
	debugTarget.executionStarted();
    }

    @Override
    public void statementWillExecute(final Statement statement) {
	// TODO Auto-generated method stub
    }

    @Override
    public final void breakpointReached(final Statement statement, final LineBreakpoint breakpoint) {
	// Just ignore the breakpoint
	return;
    }

}
