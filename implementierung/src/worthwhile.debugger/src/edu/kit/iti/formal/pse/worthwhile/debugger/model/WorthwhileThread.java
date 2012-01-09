package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

/**
 * A representation of a thread (i.e., the only thread) in a Worthwhile program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileThread extends WorthwhileDebugElement implements IThread {

	/**
	 * Indicates whether the execution is suspended.
	 */
	private boolean suspended = false;

	/**
	 * Indicates whether the execution is terminated.
	 */
	private boolean terminated = false;

	/**
	 * Creates a new instance of the {@link WorthwhileThread} class.
	 * 
	 * @param debugTarget
	 *                The debug target this thread belongs to.
	 */
	public WorthwhileThread(final WorthwhileDebugTarget debugTarget) {
		super(debugTarget);
	}

	@Override
	public final boolean canResume() {
		return !this.terminated && this.suspended;
	}

	@Override
	public final boolean canSuspend() {
		return !this.terminated && !this.suspended;
	}

	@Override
	public final boolean isSuspended() {
		return this.suspended;
	}

	@Override
	public void resume() throws DebugException {
		// TODO: Send resume request to debug event listener, wait for response
	}

	/**
	 * Called when the execution of the program was resumed.
	 * 
	 * @param detail
	 *                The reason for resuming the program execution.
	 */
	public final void resumed(final int detail) {
		this.suspended = false;
		this.fireResumeEvent(detail);
	}

	@Override
	public final void suspend() throws DebugException {
		this.suspended = true;
		// TODO
	}

	@Override
	public final boolean canStepInto() {
		return this.isSuspended();
	}

	@Override
	public final boolean canStepOver() {
		return this.isSuspended();
	}

	@Override
	public final boolean canStepReturn() {
		return this.isSuspended();
	}

	@Override
	public final boolean isStepping() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stepInto() throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public void stepOver() throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public void stepReturn() throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public final boolean canTerminate() {
		return !this.terminated;
	}

	@Override
	public final boolean isTerminated() {
		return this.terminated;
	}

	@Override
	public final void terminate() throws DebugException {
		this.terminated = true;
		this.suspended = false;
		// TODo
	}

	@Override
	public final IBreakpoint[] getBreakpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final String getName() throws DebugException {
		return "Default Thread";
	}

	@Override
	public final int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public final IStackFrame[] getStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final IStackFrame getTopStackFrame() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final boolean hasStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

}
