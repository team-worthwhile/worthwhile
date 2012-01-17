package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

/**
 * A representation of a thread (i.e., the only thread) in a Worthwhile program. It delegates all operations to the
 * debug target.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileThread extends WorthwhileDebugElement implements IThread {

	/**
	 * Creates a new instance of the {@link WorthwhileThread} class.
	 * 
	 * @param debugTarget
	 *                The debug target this thread belongs to.
	 */
	public WorthwhileThread(final WorthwhileDebugTarget debugTarget) {
		super(debugTarget);
	}

	/**
	 * The breakpoint this thread is currently suspended at, if applicable.
	 */
	private IBreakpoint breakpoint;

	/**
	 * Sets the breakpoint this thread is currently suspended at.
	 * 
	 * @param breakpoint
	 *                The breakpoint this thread is currently suspended at.
	 */
	public final void setBreakpoint(final IBreakpoint breakpoint) {
		this.breakpoint = breakpoint;
	}

	@Override
	public final boolean canResume() {
		return this.getDebugTarget().canResume();
	}

	@Override
	public final boolean canSuspend() {
		return this.getDebugTarget().canSuspend();
	}

	@Override
	public final boolean isSuspended() {
		return this.getDebugTarget().isSuspended();
	}

	@Override
	public final void resume() throws DebugException {
		this.getDebugTarget().resume();
	}

	@Override
	public final void suspend() throws DebugException {
		this.getDebugTarget().suspend();
	}

	@Override
	public final boolean canStepInto() {
		return this.getDebugTarget().canStepInto();
	}

	@Override
	public final boolean canStepOver() {
		return this.getDebugTarget().canStepOver();
	}

	@Override
	public final boolean canStepReturn() {
		return this.getDebugTarget().canStepReturn();
	}

	@Override
	public final boolean isStepping() {
		return this.getDebugTarget().isStepping();
	}

	@Override
	public final void stepInto() throws DebugException {
		this.getDebugTarget().stepInto();
	}

	@Override
	public final void stepOver() throws DebugException {
		this.getDebugTarget().stepOver();
	}

	@Override
	public final void stepReturn() throws DebugException {
		this.getDebugTarget().stepReturn();
	}

	@Override
	public final boolean canTerminate() {
		return this.getDebugTarget().canTerminate();
	}

	@Override
	public final boolean isTerminated() {
		return this.getDebugTarget().isTerminated();
	}

	@Override
	public final void terminate() throws DebugException {
		this.getDebugTarget().terminate();
	}

	@Override
	public final IBreakpoint[] getBreakpoints() {
		return new IBreakpoint[] { this.breakpoint };
	}

	@Override
	public final String getName() throws DebugException {
		return "Default Thread";
	}

	@Override
	public final int getPriority() throws DebugException {
		return 0;
	}

	// FIXME
	private WorthwhileStackFrame buildStackFrame() {
		WorthwhileStackFrame result = new WorthwhileStackFrame(this.getDebugTarget(), this.getDebugTarget()
		                .getEventListener().getCurrentNode());
		return result;
	}

	@Override
	public final IStackFrame[] getStackFrames() throws DebugException {
		return new IStackFrame[] { this.buildStackFrame() };
	}

	@Override
	public final IStackFrame getTopStackFrame() throws DebugException {
		return this.buildStackFrame();
	}

	@Override
	public final boolean hasStackFrames() throws DebugException {
		return this.isSuspended();
	}

}
