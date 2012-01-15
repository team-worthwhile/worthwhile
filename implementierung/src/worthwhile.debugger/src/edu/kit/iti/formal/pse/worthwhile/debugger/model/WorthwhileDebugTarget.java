package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
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
import edu.kit.iti.formal.pse.worthwhile.debugger.launching.IWorthwhileLaunchConfigurationConstants;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugEventListener.DebugMode;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;

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
	 * The launch object that belongs to the execution of this program.
	 */
	private ILaunch launch;

	/**
	 * The event listener that manages the debug events from the interpreter.
	 */
	private WorthwhileDebugEventListener eventListener;

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
			                .getBreakpoints(IWorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL);
			for (int i = 0; i < breakpoints.length; i++) {
				breakpointAdded(breakpoints[i]);
			}
		} else {
			this.eventListener = new WorthwhileDebugEventListener(this, false);
		}

		// Register our event listener with the interpreter.
		interpreter.addExecutionEventHandler(this.eventListener);

		// Execute the program.
		DebugPlugin.getDefault().asyncExec(new Runnable() {

			// TODO: auslagern in eigene Klasse

			@Override
			public void run() {
				interpreter.execute();
			}

		});
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
		return this.thread.canTerminate();
	}

	@Override
	public final boolean isTerminated() {
		return this.thread.isTerminated();
	}

	@Override
	public final void terminate() throws DebugException {
		this.thread.terminate();
	}

	@Override
	public final boolean canResume() {
		return this.thread.canResume();
	}

	@Override
	public final boolean canSuspend() {
		return this.thread.canSuspend();
	}

	@Override
	public final boolean isSuspended() {
		return this.thread.isSuspended();
	}

	@Override
	public final void resume() throws DebugException {
		this.thread.resume();
	}

	@Override
	public final void suspend() throws DebugException {
		this.thread.suspend();
	}

	@Override
	public final void breakpointAdded(final IBreakpoint breakpoint) {
		if (breakpoint instanceof org.eclipse.debug.core.model.LineBreakpoint) {
			try {
				((WorthwhileDebugEventListener) this.eventListener).addBreakpoint(
				                ((org.eclipse.debug.core.model.LineBreakpoint) breakpoint)
				                                .getLineNumber(), breakpoint);
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
		if (breakpoint instanceof org.eclipse.debug.core.model.LineBreakpoint) {
			try {
				((WorthwhileDebugEventListener) this.eventListener)
				                .removeBreakpoint(((org.eclipse.debug.core.model.LineBreakpoint) breakpoint)
				                                .getLineNumber());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
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
		if (IWorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL.equals(breakpoint.getModelIdentifier())) {
			IMarker marker = breakpoint.getMarker();
			// TODO
		}

		return false;
	}

	/**
	 * Called when a breakpoint is hit.
	 */
	protected final void breakpointHit(final IBreakpoint breakpoint) {
		suspended(DebugEvent.BREAKPOINT);
	}

	/**
	 * Notifies the UI that the target has suspended for the given detail reason.
	 * 
	 * @param detail
	 *                The detail reason for the suspend
	 */
	public final void suspended(final int detail) {
		this.fireSuspendEvent(detail);
	}

	/**
	 * Called when the interpreter terminates the execution.
	 */
	protected final void executionTerminated() {
		try {
			this.thread.terminate();
		} catch (DebugException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
		fireTerminateEvent();
	}

	/**
	 * Returns the path to the source file of the program that is executed.
	 * 
	 * @return The path to the source file of the program that is executed.
	 */
	public final String getSourceName() {
		try {
			Path path = new Path(this.launch.getLaunchConfiguration().getAttribute(
			                IWorthwhileLaunchConfigurationConstants.ATTR_PATH, ""));
			return path.lastSegment();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
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
