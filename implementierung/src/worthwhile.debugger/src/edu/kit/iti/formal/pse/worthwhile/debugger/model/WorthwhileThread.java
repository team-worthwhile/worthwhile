package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

/**
 * A representation of a thread in a Worthwhile program. Since we don't support multithreading, this is a pretty useless
 * class, but it is required by the Eclipse debug model.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileThread extends WorthwhileDebugElement implements IThread {

    public WorthwhileThread(WorthwhileDebugTarget debugTarget) {
	super(debugTarget);
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
	// TODO Auto-generated method stub
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
