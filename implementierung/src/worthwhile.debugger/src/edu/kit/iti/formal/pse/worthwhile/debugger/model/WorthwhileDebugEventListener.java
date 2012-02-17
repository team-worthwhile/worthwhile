package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;

import edu.kit.iti.formal.pse.worthwhile.debugger.breakpoints.WorthwhileLineBreakpoint;
import edu.kit.iti.formal.pse.worthwhile.debugger.breakpoints.WorthwhileWatchpoint;
import edu.kit.iti.formal.pse.worthwhile.interpreter.InterpreterError;
import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
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
	 * The active line breakpoints, where the map index is the 1-based line number (allows for faster access).
	 */
	private Map<Integer, WorthwhileLineBreakpoint> lineBreakpoints;

	/**
	 * The variables to watch for modification, where the map index is the variable name.
	 */
	private Map<String, WorthwhileWatchpoint> watchpoints;

	/**
	 * The node currently being executed.
	 */
	private ASTNode currentNode;

	/**
	 * The node we are currently stepping over.
	 */
	private ASTNode stepOverNode;

	/**
	 * The variables that were introduced or changed since the last suspend.
	 */
	private Collection<VariableDeclaration> changedVariables;

	/**
	 * The variables that are a candidate to be changed during the current statement.
	 */
	private Map<VariableDeclaration, Value> changedVariableCandidates;

	/**
	 * Returns the node currently being executed.
	 * 
	 * @return the node currently being executed.
	 */
	public final ASTNode getCurrentNode() {
		return this.currentNode;
	}

	/**
	 * Returns the variables changed since the last suspend.
	 * 
	 * @return A list of the variables changed since the last suspend
	 */
	public final Collection<VariableDeclaration> getChangedVariables() {
		return this.changedVariables;
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
		this.lineBreakpoints = new HashMap<Integer, WorthwhileLineBreakpoint>();
		this.watchpoints = new HashMap<String, WorthwhileWatchpoint>();
		this.changedVariables = new HashSet<VariableDeclaration>();
		this.changedVariableCandidates = new HashMap<VariableDeclaration, Value>();

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
	public final void addBreakpoint(final int lineNumber, final WorthwhileLineBreakpoint breakpoint) {
		if (breakpoint == null) {
			throw new IllegalArgumentException("Breakpoint may not be null");
		}

		this.lineBreakpoints.put(lineNumber, breakpoint);
	}

	/**
	 * Removes the breakpoint at the specified line number, if it is present.
	 * 
	 * @param lineNumber
	 *                The line number at which to remove the breakpoint.
	 */
	public final void removeBreakpoint(final int lineNumber) {
		this.lineBreakpoints.remove(lineNumber);
	}

	/**
	 * Adds a watchpoint for a specified variable.
	 * 
	 * @param variableName
	 *                The name of the variable to watch.
	 * @param watchpoint
	 *                The watchpoint to add.
	 */
	public final void addWatchpoint(final String variableName, final WorthwhileWatchpoint watchpoint) {
		if (watchpoint == null) {
			throw new IllegalArgumentException("Watchpoint may not be null");
		}

		this.watchpoints.put(variableName, watchpoint);
	}

	/**
	 * Removes the breakpoint at the specified line number, if it is present.
	 * 
	 * @param variableName
	 *                The variable name for which to remove the watchpoint.
	 */
	public final void removeWatchpoint(final String variableName) {
		this.watchpoints.remove(variableName);
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
	public final void executionCompleted() {
		this.getDebugTarget().terminated();
	}

	@Override
	public final void executionFailed(final Statement statement, final InterpreterError error) {
		this.getDebugTarget().executionFailed(statement, error);
		this.suspendExecution(DebugEvent.SUSPEND);
		this.terminate();
	}

	@Override
	public final void expressionFailed(final Expression expression, final InterpreterError error) {
		this.getDebugTarget().executionFailed(expression, error);
		this.suspendExecution(DebugEvent.SUSPEND);
		this.terminate();
	}

	@Override
	public final void statementWillExecute(final Statement statement) {
		this.currentNode = statement;
		this.stepOverNode = null;

		boolean doSuspend = false;
		int suspendReason = 0;

		// Check if there is a breakpoint in this statement's line
		int lineNumber = NodeHelper.getLine(statement);
		if (!this.mode.equals(DebugMode.RUN)) {
			if (this.checkLineBreakpoint(lineNumber)) {
				doSuspend = true;
				suspendReason = DebugEvent.BREAKPOINT;

				// Notify the debug target that a breakpoint has been hit
				this.getDebugTarget().breakpointHit(this.lineBreakpoints.get(lineNumber));
			} else {
				// Check if we want to suspend anyway, because of stepping mode or client request
				if (this.mode.equals(DebugMode.STEP)) {
					doSuspend = true;
					suspendReason = DebugEvent.STEP_END;
				} else if (this.mode.equals(DebugMode.SUSPEND)) {
					doSuspend = true;
					suspendReason = DebugEvent.CLIENT_REQUEST;
				}
			}
		}

		if (doSuspend) {
			// Suspend the execution and wait for resume.
			suspendExecution(suspendReason);
		}

		// If the statement executed is an assignment or a variable declaration, we have a candidate for a
		// changed variable. Put the old value in the list of candidates for changed variables.
		VariableValueInfo changedVariable = (new VariableValueVisitor().apply(statement));
		if (changedVariable != null) {
			this.changedVariableCandidates.put(changedVariable.getVariable(), changedVariable.getValue());
		}
	}

	@Override
	public final void statementExecuted(final Statement statement) {
		// Check if a variable was changed during this statement.
		if (this.changedVariableCandidates.size() > 0) {
			VariableValueInfo changedVariable = new VariableValueVisitor().apply(statement);

			if (changedVariable != null) {
				// A variable was changed in this statement, get its old value from the list of
				// candidates and compare.
				Value oldValue = changedVariableCandidates.get(changedVariable.getVariable());
				if (!changedVariable.getValue().equals(oldValue)) {
					// Variable was indeed changed!
					this.changedVariables.add(changedVariable.getVariable());

					// Check if there are any watchpoints for this variable. If yes, suspend.
					String variableName = changedVariable.getVariable().getName();
					if (this.watchpoints.containsKey(variableName)) {
						this.getDebugTarget().breakpointHit(this.watchpoints.get(variableName));
						suspendExecution(DebugEvent.BREAKPOINT);
					}
				}
			}

		}

		// Check if this is the statement we have stepped over. If yes, return to normal step mode.
		// FIXME: Statement is visited twice when stepping over?!
		if (DebugMode.STEP_OVER.equals(this.mode)) {
			if (statement.equals(this.stepOverNode)) {
				this.mode = DebugMode.STEP;
			}
		}
		
		this.currentNode = null;
	}

	@Override
	public final void annotationFailed(final Annotation annotation) {
		this.getDebugTarget().annotationFailed(annotation);
		this.suspendExecution(DebugEvent.BREAKPOINT);
	}

	@Override
	public final void annotationSucceeded(final Annotation annotation) {
		this.getDebugTarget().annotationSucceeded(annotation);
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
		synchronized (this) {
			this.mode = DebugMode.TERMINATED;
			notifyAll();
		}

		this.getDebugTarget().terminated();
	}

	/**
	 * Steps over the current statement.
	 */
	public final void stepOver() {
		synchronized (this) {
			this.mode = DebugMode.STEP_OVER;
			notifyAll();
		}
	}

	/**
	 * Sets the debug mode to "run", i.e. breakpoints are not handled any more.
	 */
	public final void disconnect() {
		synchronized (this) {
			this.mode = DebugMode.RUN;
			notifyAll();
		}
	}

	/**
	 * Checks if there is a breakpoint on the specified line (and if yes, whether the breakpoint's condition is
	 * met).
	 * 
	 * @param lineNumber
	 *                The line number to check for a breakpoint.
	 * @return Whether there is a breakpoint on the specified line and if yes, whether the breakpoint's condition is
	 *         met.
	 */
	private boolean checkLineBreakpoint(final int lineNumber) {
		WorthwhileLineBreakpoint breakpoint = this.lineBreakpoints.get(lineNumber);

		if (breakpoint == null) {
			return false;
		}

		// check breakpoint condition
		String condition = breakpoint.getCondition();

		if (!("".equals(condition))) {
			// Evaluate condition expression and check if the result is true.
			try {
				Value result = this.getDebugTarget().evaluateExpression(condition);

				if (!result.equals(new BooleanValue(true))) {
					return false;
				}
			} catch (DebugException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;

	}

	/**
	 * Suspends the execution for the given reason, sends the appropriate event to the debug target, and waits for
	 * the resume.
	 * 
	 * @param suspendReason
	 *                The reason for the suspend.
	 */
	private void suspendExecution(final int suspendReason) {
		this.mode = DebugMode.SUSPENDED;
		this.getDebugTarget().suspended(suspendReason);

		// Wait until someone wakes us up, i.e. sets the debug mode
		// to something other than "suspend".
		synchronized (this) {
			while (this.mode.equals(DebugMode.SUSPENDED)) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		// If we arrive here we have received the resume event.
		resumeExecution();

		this.changedVariables = new HashSet<VariableDeclaration>();
	}

	/**
	 * Resumes the execution after a suspend and sends the appropriate event to the debug target.
	 */
	private void resumeExecution() {
		int resumeReason = 0;

		switch (this.mode) {
			case RUN:
			case DEBUG:
				resumeReason = DebugEvent.RESUME;
				break;
			case STEP:
				resumeReason = DebugEvent.STEP_INTO;
				break;
			case STEP_OVER:
				resumeReason = DebugEvent.STEP_OVER;
				this.stepOverNode = this.currentNode;
				break;
			default:
				break;
		}

		if (resumeReason != 0) {
			this.getDebugTarget().resumed(resumeReason);
		}
	}

	/**
	 * Stores information about a variable and its value.
	 * 
	 * @author Joachim
	 * 
	 */
	private class VariableValueInfo {

		/**
		 * The variable declaration.
		 */
		private final VariableDeclaration variable;

		/**
		 * The value of the variable.
		 */
		private final Value value;

		/**
		 * Creates a new instance of the {@link VariableValueInfo} class.
		 * 
		 * @param variable
		 *                The variable declaration.
		 * @param value
		 *                The value of the variable.
		 */
		public VariableValueInfo(final VariableDeclaration variable, final Value value) {
			this.variable = variable;
			this.value = value;
		}

		/**
		 * Returns the variable.
		 * 
		 * @return The variable.
		 */
		public VariableDeclaration getVariable() {
			return this.variable;
		}

		/**
		 * Returns the value of the variable.
		 * 
		 * @return The value of the variable.
		 */
		public Value getValue() {
			return this.value;
		}

	}

	/**
	 * A visitor that extracts information about variable assignment and declaration and their old value from a
	 * statement.
	 * 
	 * @author Joachim
	 * 
	 */
	private class VariableValueVisitor extends ASTNodeReturnVisitor<VariableValueInfo> {

		@Override
		public void defaultOperation(final ASTNode node) {
		}

		@Override
		public void visit(final Assignment node) {
			VariableDeclaration variable = node.getVariable().getVariable();
			// FIXME: Ugly code
			Value value = ((WorthwhileValue) getDebugTarget().getVariableValue(variable.getName()))
			                .getValue();
			this.setReturnValue(new VariableValueInfo(variable, value));
		}

		@Override
		public void visit(final VariableDeclaration node) {
			WorthwhileValue value = ((WorthwhileValue) getDebugTarget().getVariableValue(node.getName()));
			if (value == null) {
				this.setReturnValue(new VariableValueInfo(node, null));
			} else {
				this.setReturnValue(new VariableValueInfo(node, value.getValue()));
			}
		}

	}

}
