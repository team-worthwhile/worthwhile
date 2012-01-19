package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.model.IBreakpoint;

import edu.kit.iti.formal.pse.worthwhile.interpreter.InterpreterError;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
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
	 * The mode a debugger can be in.
	 */
	public enum DebugMode {
		/**
		 * The debugger is running. Nothing can stop it, not even breakpoints (only forced termination)
		 */
		RUN,

		/**
		 * The debugger is running the program, but listening for suspend events (such as breakpoints).
		 */
		DEBUG,

		/**
		 * The debugger has been asked to suspend, but has not suspended yet.
		 */
		SUSPEND,

		/**
		 * The debugger is suspended and currently not executing any commands.
		 */
		SUSPENDED,

		/**
		 * The debugger is currently stepping to the next statement.
		 */
		STEP,

		/**
		 * The debugger is currently stepping over a statement.
		 */
		STEP_OVER,

		/**
		 * The execution of the program has terminated.
		 */
		TERMINATED
	}

	/**
	 * The mode the debugger is currently in.
	 */
	private DebugMode mode;

	/**
	 * The active breakpoints, where the map index is the 1-based line number (allows for faster access).
	 */
	private Map<Integer, IBreakpoint> breakpoints;

	/**
	 * The node currently being executed.
	 */
	private ASTNode currentNode;
	
	/**
	 * Returns the node currently being executed.
	 * 
	 * @return the node currently being executed.
	 */
	public final ASTNode getCurrentNode() {
		return this.currentNode;
	}

	/**
	 * Creates a new instance of the {@link WorthwhileDebugEventListener} class.
	 * 
	 * @param debugTarget
	 *                The debug target.
	 * @param debug
	 *                Whether to start in debug mode (otherwise: in run mode).
	 */
	public WorthwhileDebugEventListener(final WorthwhileDebugTarget debugTarget, final boolean debug) {
		super(debugTarget);
		this.breakpoints = new HashMap<Integer, IBreakpoint>();

		if (debug) {
			this.mode = DebugMode.DEBUG;
		} else {
			this.mode = DebugMode.RUN;
		}
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

	/**
	 * Returns the mode the debugger is currently in.
	 * 
	 * @return the mode the debugger is currently in.
	 */
	public final DebugMode getMode() {
		return this.mode;
	}

	@Override
	public final void executionFailed(final Statement statement, final InterpreterError error) {

	}

	@Override
	public final void executionCompleted() {
		System.out.println("Execution completed.");
		this.getDebugTarget().terminated();
	}

	@Override
	public final void statementWillExecute(final Statement statement) {
		synchronized (this) {
			this.currentNode = statement;

			boolean doSuspend = false;
			int suspendReason = 0;

			// Check if there is a breakpoint in this statement's line
			int lineNumber = NodeHelper.getLine(statement);
			if (!this.mode.equals(DebugMode.RUN) && this.breakpoints.containsKey(lineNumber)) {
				// TODO breakpoint condition

				// Notify the debug target that a breakpoint has been hit
				this.getDebugTarget().breakpointHit(this.breakpoints.get(lineNumber));

				doSuspend = true;
				suspendReason = DebugEvent.BREAKPOINT;
			} else {
				// Check if we want to suspend anyway
				if (this.mode.equals(DebugMode.STEP)) {
					doSuspend = true;
					suspendReason = DebugEvent.STEP_END;
				} else if (this.mode.equals(DebugMode.SUSPEND)) {
					doSuspend = true;
					suspendReason = DebugEvent.CLIENT_REQUEST;
				}
			}

			if (doSuspend) {
				this.mode = DebugMode.SUSPENDED;
				this.getDebugTarget().suspended(suspendReason);

				// Wait until someone wakes us up.
				while (this.mode.equals(DebugMode.SUSPENDED)) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				int resumeReason = 0;

				switch (this.mode) {
				case DEBUG:
					resumeReason = DebugEvent.RESUME;
					break;
				case STEP:
					resumeReason = DebugEvent.STEP_INTO;
					break;
				case STEP_OVER:
					resumeReason = DebugEvent.STEP_OVER;
					break;
				default:
					break;
				}

				this.getDebugTarget().resumed(resumeReason);
				this.currentNode = null;
			}
		}
	}

	/**
	 * Suspends the execution.
	 */
	public final void suspend() {
		// We will suspend at the next execution of a statement.
		this.mode = DebugMode.SUSPEND;
	}

	/**
	 * Steps into the following statement.
	 */
	public final void stepInto() {
		synchronized (this) {
			this.mode = DebugMode.STEP;
			notifyAll();
		}
	}

	/**
	 * Resumes the execution.
	 */
	public final void resume() {
		synchronized (this) {
			this.mode = DebugMode.DEBUG;
			notifyAll();
		}
	}

	/**
	 * Terminates the execution.
	 */
	public final void terminate() {
		this.mode = DebugMode.TERMINATED;
	}

	/**
	 * Steps over the current statement.
	 */
	public void stepOver() {
	        // TODO Auto-generated method stub
	        
        }

}
