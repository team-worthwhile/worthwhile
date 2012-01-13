package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.model.IBreakpoint;

import edu.kit.iti.formal.pse.worthwhile.interpreter.InterpreterError;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * An event listener that passes on debug events to the debug target and manages breakpoints.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugEventListener extends WorthwhileEventListener {

	/**
	 * The active breakpoints, where the map index is the 1-based line number (allows for faster access).
	 */
	private Map<Integer, IBreakpoint> breakpoints;

	/**
	 * Creates a new instance of the {@link WorthwhileDebugEventListener} class.
	 * 
	 * @param debugTarget
	 *                The debug target.
	 */
	public WorthwhileDebugEventListener(final WorthwhileDebugTarget debugTarget) {
		super(debugTarget);
		this.breakpoints = new HashMap<Integer, IBreakpoint>();
	}

	/**
	 * Adds a breakpoint at a specified line.
	 * 
	 * @param lineNumber
	 *                The 1-based line number of the breakpoint.
	 * @param breakpoint
	 *                The breakpoint to add.
	 */
	public final void addBreakpoint(final int lineNumber, final IBreakpoint breakpoint) {
		if (breakpoint == null) {
			throw new IllegalArgumentException("Breakpoint may not be null");
		}

		System.out.println("Breakpoint added at line " + lineNumber);
		
		this.breakpoints.put(lineNumber, breakpoint);
	}

	/**
	 * Removes the breakpoint at the specified line number, if it is present.
	 * 
	 * @param lineNumber
	 *                The line number at which to remove the breakpoint.
	 */
	public final void removeBreakpoint(final int lineNumber) {
		this.breakpoints.remove(lineNumber);
	}

	@Override
	public final void executionFailed(final Statement statement, final InterpreterError error) {

	}

	@Override
	public final void executionCompleted() {
		System.out.println("Execution completed.");
		getDebugTarget().executionTerminated();
	}

	@Override
	public final void executionStarted() {
		System.out.println("Execution started.");
		getDebugTarget().executionStarted();
	}

	@Override
        public final void statementWillExecute(final Statement statement) {
		System.out.println("statement will execute: " + statement.toString());
		
		// Check if there is a breakpoint in this statement's line
		int lineNumber = NodeHelper.getLine(statement);
		if (this.breakpoints.containsKey(lineNumber)) {
			// TODO breakpoint condition
			System.out.println("Breakpoint hit at line " + lineNumber);
			// Suspend execution
			this.getDebugTarget().breakpointHit();
			// this.suspendExecution();
		}
	}

}
