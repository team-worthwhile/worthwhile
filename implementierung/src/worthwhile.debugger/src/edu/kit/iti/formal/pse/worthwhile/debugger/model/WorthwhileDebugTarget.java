package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.LineBreakpoint;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugEventListener.DebugMode;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;
import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;
import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

/**
 * This debug target communicates between the Eclipse platform debugging functions and the Worthwhile interpreter.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugTarget extends WorthwhileDebugElement implements IDebugTarget {

	/**
	 * The (only) thread a program execution consists of.
	 */
	private WorthwhileThread thread;

	/**
	 * The launch object that belongs to the execution of this program.
	 */
	private ILaunch launch;

	/**
	 * The event listener that manages the debug events from the interpreter.
	 */
	private WorthwhileDebugEventListener eventListener;

	/**
	 * The runner which runs the interpreter.
	 */
	private InterpreterRunner interpreterRunner;

	/**
	 * Creates a new instance of the {@link WorthwhileDebugTarget} class.
	 * 
	 * @param launch
	 *                The launch object from which the program was launched.
	 * @param interpreter
	 *                The interpreter that runs the program.
	 */
	public WorthwhileDebugTarget(final ILaunch launch, final Interpreter interpreter) {
		super(null);
		this.setDebugTarget(this);

		if (interpreter == null) {
			throw new IllegalArgumentException("Interpreter may not be null.");
		}

		this.launch = launch;
		this.thread = new WorthwhileThread(this);

		// Create a new event listener.
		if (launch.getLaunchMode().equals("debug")) {
			this.eventListener = new WorthwhileDebugEventListener(this, true);

			// Register ourselves as a breakpoint listener.
			DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);

			// Get the breakpoints that are already defined and add them to the debug target.
			IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
			                .getBreakpoints(ID_WORTHWHILE_DEBUG_MODEL);
			for (int i = 0; i < breakpoints.length; i++) {
				breakpointAdded(breakpoints[i]);
			}
		} else {
			this.eventListener = new WorthwhileDebugEventListener(this, false);
		}

		// Register our event listener with the interpreter.
		interpreter.addExecutionEventHandler(this.eventListener);

		// Execute the program.
		this.interpreterRunner = new InterpreterRunner(interpreter);
		this.interpreterRunner.schedule();
	}

	/**
	 * Returns the launch this debug target belongs to.
	 * 
	 * @return The launch this debug target belongs to.
	 */
	public final ILaunch doGetLaunch() {
		return this.launch;
	}

	@Override
	public final boolean canTerminate() {
		return !this.getEventListener().getMode().equals(DebugMode.TERMINATED);
	}

	@Override
	public final boolean isTerminated() {
		return this.getEventListener().getMode().equals(DebugMode.TERMINATED);
	}

	@Override
	public final void terminate() throws DebugException {
		this.getEventListener().terminate();
	}

	@Override
	public final boolean canResume() {
		return !this.getEventListener().getMode().equals(DebugMode.TERMINATED)
		                && this.getEventListener().getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final boolean canSuspend() {
		return !this.getEventListener().getMode().equals(DebugMode.TERMINATED)
		                && !this.getEventListener().getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final boolean isSuspended() {
		return this.getEventListener().getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final void resume() throws DebugException {
		this.getEventListener().resume();
	}

	@Override
	public final void suspend() throws DebugException {
		this.getEventListener().suspend();
	}

	/**
	 * Returns whether the debug target can step into a statement.
	 * 
	 * @return whether the debug target can step into a statement.
	 */
	public final boolean canStepInto() {
		return this.isSuspended();
	}

	/**
	 * Returns whether the debug target can step over a statement.
	 * 
	 * @return whether the debug target can step over a statement.
	 */
	public final boolean canStepOver() {
		return this.isSuspended();
	}

	/**
	 * Returns whether the debug target can step to the next return statement.
	 * 
	 * @return whether the debug target can step to the next return statement.
	 */
	public final boolean canStepReturn() {
		return this.isSuspended();
	}

	/**
	 * Returns whether we are currently in stepping mode.
	 * 
	 * @return whether we are currently in stepping mode.
	 */
	public final boolean isStepping() {
		return this.getEventListener().getMode().equals(DebugMode.STEP)
		                || this.getEventListener().getMode().equals(DebugMode.STEP_OVER);
	}

	/**
	 * Steps into the current statement.
	 * 
	 * @throws DebugException
	 *                 when the desired operation cannot be performed.
	 */
	public void stepInto() throws DebugException {
		// TODO Auto-generated method stub
	}

	/**
	 * Steps over the current statement.
	 * 
	 * @throws DebugException
	 *                 when the desired operation cannot be performed.
	 */
	public void stepOver() throws DebugException {
		// TODO Auto-generated method stub
	}

	/**
	 * Steps until the next return statement.
	 * 
	 * @throws DebugException
	 *                 when the desired operation cannot be performed.
	 */
	public void stepReturn() throws DebugException {
		// TODO Auto-generated method stub
	}

	@Override
	public final void breakpointAdded(final IBreakpoint breakpoint) {
		if (breakpoint instanceof LineBreakpoint) {
			try {
				this.eventListener.addBreakpoint(((LineBreakpoint) breakpoint).getLineNumber(),
				                breakpoint);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else if (breakpoint instanceof org.eclipse.debug.core.model.IWatchpoint) {
			// TODO
		}
	}

	@Override
	public final void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					breakpointAdded(breakpoint);
				} else {
					breakpointRemoved(breakpoint, null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public final void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		if (breakpoint instanceof org.eclipse.debug.core.model.LineBreakpoint) {
			try {
				this.eventListener.removeBreakpoint(((LineBreakpoint) breakpoint).getLineNumber());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public final boolean canDisconnect() {
		return this.eventListener.getMode().equals(DebugMode.DEBUG);
	}

	@Override
	public final void disconnect() throws DebugException {
		// TODO
	}

	@Override
	public final boolean isDisconnected() {
		return this.eventListener.getMode().equals(DebugMode.RUN);
	}

	@Override
	public final IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
		return null;
	}

	@Override
	public final boolean supportsStorageRetrieval() {
		return false;
	}

	@Override
	public final String getName() throws DebugException {
		return this.getSourceName();
	}

	@Override
	public final IProcess getProcess() {
		return null;
	}

	@Override
	public final IThread[] getThreads() throws DebugException {
		return new IThread[] { this.thread };
	}

	@Override
	public final boolean hasThreads() throws DebugException {
		return true;
	}

	@Override
	public final boolean supportsBreakpoint(final IBreakpoint breakpoint) {
		// Support a breakpoint if its debug model equals the Worthwhile debug model
		// and it is set in the program we are currently executing.
		if (ID_WORTHWHILE_DEBUG_MODEL.equals(breakpoint.getModelIdentifier())) {
			IMarker marker = breakpoint.getMarker();
			// TODO
		}

		return false;
	}

	/**
	 * Called when a breakpoint is hit.
	 * 
	 * @param breakpoint
	 *                The breakpoint that has been hit.
	 */
	public final void breakpointHit(final IBreakpoint breakpoint) {
		this.thread.setBreakpoint(breakpoint);
	}

	/**
	 * Called when the execution has suspended for the given detail reason.
	 * 
	 * @param detail
	 *                The detail reason for the suspend
	 */
	public final void suspended(final int detail) {
		this.thread.fireSuspendEvent(detail);
	}

	/**
	 * Called when the execution has resumed for the given detail reason.
	 * 
	 * @param detail
	 *                The detail reason for the resume.
	 */
	public final void resumed(final int detail) {
		this.thread.setBreakpoint(null);
		this.thread.fireResumeEvent(detail);
	}

	/**
	 * Called when the interpreter terminates the execution.
	 */
	protected final void terminated() {
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
		this.fireTerminateEvent();
	}

	/**
	 * Returns the path to the source file of the program that is executed.
	 * 
	 * @return The path to the source file of the program that is executed.
	 */
	public final String getSourceName() {
		try {
			Path path = new Path(this.launch.getLaunchConfiguration().getAttribute(ATTR_PATH, ""));
			return path.lastSegment();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Returns the current stack frames in this target.
	 * 
	 * @return The current stack frames in this target
	 * @throws DebugException
	 *                 if unable to perform the request
	 */
	protected final IStackFrame[] getStackFrames() throws DebugException {
		return new IStackFrame[] { new WorthwhileStackFrame(this, this.thread,
		                this.eventListener.getCurrentNode()) };
	}

	/**
	 * Returns the event listener.
	 * 
	 * @return The event listener.
	 */
	public final WorthwhileDebugEventListener getEventListener() {
		return this.eventListener;
	}

}
