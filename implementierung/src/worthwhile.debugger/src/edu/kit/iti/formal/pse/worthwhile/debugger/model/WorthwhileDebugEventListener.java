package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import edu.kit.iti.formal.pse.worthwhile.interpreter.InterpreterError;
import edu.kit.iti.formal.pse.worthwhile.interpreter.LineBreakpoint;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * An event listener that passes on debug events to the debug target.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugEventListener extends WorthwhileEventListener {

    public WorthwhileDebugEventListener(final WorthwhileDebugTarget debugTarget) {
	super(debugTarget);
    }

    @Override
    public final void executionFailed(final Statement statement, final InterpreterError error) {
	
    }

    @Override
    public final void executionCompleted() {
	getDebugTarget().executionTerminated();
    }

    @Override
    public final void executionStarted() {
	getDebugTarget().executionStarted();
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
