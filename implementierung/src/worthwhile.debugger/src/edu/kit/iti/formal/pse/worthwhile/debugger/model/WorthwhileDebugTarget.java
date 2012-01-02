package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.resources.IMarker;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;

import edu.kit.iti.formal.pse.worthwhile.debugger.IWorthwhileDebugConstants;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;
import edu.kit.iti.formal.pse.worthwhile.interpreter.LineBreakpoint;

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
    private IThread thread;

    /**
     * The event listener that manages the debug events from the interpreter.
     */
    private WorthwhileDebugEventListener eventListener;

    /**
     * The interpreter executing the program.
     */
    private Interpreter interpreter;

    /**
     * Indicates whether the execution is terminated.
     */
    private boolean terminated = false;

    /**
     * Indicates whether the execution is suspended.
     */
    private boolean suspended = false;

    /**
     * Creates a new instance of the {@link WorthwhileDebugTarget} class.
     * 
     * @param launch
     *            The launch object from which the program was launched.
     * @param interpreter
     *            The interpreter that runs the program.
     */
    public WorthwhileDebugTarget(final ILaunch launch, final Interpreter interpreter) {
	super();

	if (interpreter == null) {
	    throw new IllegalArgumentException("Interpreter may not be null.");
	}

	this.interpreter = interpreter;

	// Register our debug event handler with the interpreter.
	this.eventListener = new WorthwhileDebugEventListener(this);
	interpreter.addDebugEventHandler(this.eventListener);

	// Register ourselves as a breakpoint listener.
	DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
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
	// TODO Auto-generated method stub

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
    public final void resume() throws DebugException {
	// TODO Auto-generated method stub

    }

    @Override
    public final void suspend() throws DebugException {
	// TODO Auto-generated method stub

    }

    @Override
    public final void breakpointAdded(final IBreakpoint breakpoint) {
	if (breakpoint instanceof org.eclipse.debug.core.model.LineBreakpoint) {
	    try {
		this.interpreter.addBreakpoint(new LineBreakpoint(
			((org.eclipse.debug.core.model.LineBreakpoint) breakpoint).getLineNumber()));
	    } catch (CoreException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	} else if (breakpoint instanceof org.eclipse.debug.core.model.IWatchpoint) {
	    // TODO
	}
    }

    @Override
    public final void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
	// TODO Auto-generated method stub

    }

    @Override
    public final void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
	// TODO Auto-generated method stub

    }

    @Override
    public final boolean canDisconnect() {
	return true;
    }

    @Override
    public final void disconnect() throws DebugException {
	this.interpreter.removeDebugEventHandler(this.eventListener);
	// TODO isDisconnected
    }

    @Override
    public final boolean isDisconnected() {
	// TODO
	return false;
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
	// TODO Auto-generated method stub
	return null;
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
	if (IWorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL.equals(breakpoint.getModelIdentifier())) {
	    IMarker marker = breakpoint.getMarker();
	    // TODO
	}

	return false;
    }

    /**
     * Installs the breakpoints that have already registered before the execution of the program (as opposed to
     * breakpoints added when the program is running).
     */
    private void installDeferredBreakpoints() {
	IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
		.getBreakpoints(IWorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL);

	for (IBreakpoint breakpoint : breakpoints) {
	    breakpointAdded(breakpoint);
	}
    }

    /**
     * Called when the interpreter has been started, before executing the first statement.
     */
    protected final void executionStarted() {
	this.installDeferredBreakpoints();
    }
    
    /**
     * Called when a breakpoint is hit.
     */
    protected final void breakpointHit() {
	fireSuspendEvent(DebugEvent.BREAKPOINT);
    }

    /**
     * Called when the interpreter terminates the execution.
     */
    protected final void executionTerminated() {
	this.terminated = true;
	this.suspended = false;
	DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
	fireTerminateEvent();
    }

}
