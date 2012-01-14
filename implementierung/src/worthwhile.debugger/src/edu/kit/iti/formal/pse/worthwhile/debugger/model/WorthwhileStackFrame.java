package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

/**
 * Represents a stack frame in a suspended Worthwhile program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileStackFrame extends WorthwhileDebugElement implements IStackFrame {

	/**
	 * Creates a new instance of the {@link WorthwhileStackFrame} class.
	 * 
	 * @param debugTarget
	 *                The debug target.
	 */
	public WorthwhileStackFrame(final WorthwhileDebugTarget debugTarget) {
		super(debugTarget);
	}

	/**
	 * Returns the name of the source file that is associated with this stack frame.
	 * 
	 * @return the name of the source file that is associated with this stack frame.
	 */
	public final String getSourceName() {
		return this.getDebugTarget().getSourceName();
	}

	@Override
	public final boolean canStepInto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean canStepOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean canStepReturn() {
		// TODO Auto-generated method stub
		return false;
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
	public final boolean canResume() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean canSuspend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean isSuspended() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resume() throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public void suspend() throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public final boolean canTerminate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void terminate() throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public final int getCharEnd() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final int getCharStart() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final int getLineNumber() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final String getName() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final IRegisterGroup[] getRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final IThread getThread() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final IVariable[] getVariables() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final boolean hasRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final boolean hasVariables() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

}
