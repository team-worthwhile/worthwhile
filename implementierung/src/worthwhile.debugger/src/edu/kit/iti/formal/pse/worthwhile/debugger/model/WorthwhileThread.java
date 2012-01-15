package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugEventListener.DebugMode;

/**
 * A representation of a thread (i.e., the only thread) in a Worthwhile program.
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

	@Override
	public final boolean canResume() {
		return !this.getDebugTarget().getEventListener().getMode().equals(DebugMode.TERMINATED)
		                && this.getDebugTarget().getEventListener().getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final boolean canSuspend() {
		return !this.getDebugTarget().getEventListener().getMode().equals(DebugMode.TERMINATED)
		                && !this.getDebugTarget().getEventListener().getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final boolean isSuspended() {
		return this.getDebugTarget().getEventListener().getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final void resume() throws DebugException {
		this.getDebugTarget().getEventListener().resume();
	}

	@Override
	public final void suspend() throws DebugException {
		this.getDebugTarget().suspend();
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
		return this.getDebugTarget().getEventListener().getMode().equals(DebugMode.STEP)
		                || this.getDebugTarget().getEventListener().getMode().equals(DebugMode.STEP_OVER);
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
		return !this.getDebugTarget().getEventListener().getMode().equals(DebugMode.TERMINATED);
	}

	@Override
	public final boolean isTerminated() {
		return this.getDebugTarget().getEventListener().getMode().equals(DebugMode.TERMINATED);
	}

	@Override
	public final void terminate() throws DebugException {
		this.getDebugTarget().getEventListener().terminate();
	}

	@Override
	public final IBreakpoint[] getBreakpoints() {
		// Return the breakpoints the thread is currently suspended at (!)
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
