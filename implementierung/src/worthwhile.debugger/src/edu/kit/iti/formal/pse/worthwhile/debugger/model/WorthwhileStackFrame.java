package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeToStringHelper;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * Represents a stack frame in a suspended Worthwhile program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileStackFrame extends WorthwhileDebugElement implements IStackFrame {

	/**
	 * The thread this stack frame belongs to.
	 */
	private final IThread thread;

	/**
	 * Creates a new instance of the {@link WorthwhileStackFrame} class.
	 * 
	 * @param debugTarget
	 *                The debug target.
	 * @param thread
	 *                The thread this stack frame belongs to.
	 * @param node
	 *                The AST node this stack frame represents.
	 */
	public WorthwhileStackFrame(final WorthwhileDebugTarget debugTarget, final IThread thread, final ASTNode node) {
		super(debugTarget);

		if (node == null) {
			throw new IllegalArgumentException("Stack frame must have a non-null node.");
		}

		this.thread = thread;
		this.node = node;
	}

	/**
	 * The AST node this stack frame represents. (FIXME?)
	 */
	private final ASTNode node;

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
		return this.getThread().canStepInto();
	}

	@Override
	public final boolean canStepOver() {
		return this.getThread().canStepOver();
	}

	@Override
	public final boolean canStepReturn() {
		return this.getThread().canStepReturn();
	}

	@Override
	public final boolean isStepping() {
		return this.getThread().isStepping();
	}

	@Override
	public final void stepInto() throws DebugException {
		this.getThread().stepInto();
	}

	@Override
	public final void stepOver() throws DebugException {
		this.getThread().stepOver();
	}

	@Override
	public final void stepReturn() throws DebugException {
		this.getThread().stepReturn();
	}

	@Override
	public final boolean canResume() {
		return this.getThread().canResume();
	}

	@Override
	public final boolean canSuspend() {
		return this.getThread().canSuspend();
	}

	@Override
	public final boolean isSuspended() {
		return this.getThread().isSuspended();
	}

	@Override
	public final void resume() throws DebugException {
		this.getThread().resume();
	}

	@Override
	public final void suspend() throws DebugException {
		this.getThread().suspend();
	}

	@Override
	public final boolean canTerminate() {
		return this.getThread().canTerminate();
	}

	@Override
	public final boolean isTerminated() {
		return this.getThread().isTerminated();
	}

	@Override
	public final void terminate() throws DebugException {
		this.getThread().terminate();
	}

	@Override
	public final int getCharEnd() throws DebugException {
		return -1;
	}

	@Override
	public final int getCharStart() throws DebugException {
		return -1;
	}

	@Override
	public final int getLineNumber() throws DebugException {
		return NodeHelper.getLine(this.node);
	}

	@Override
	public final String getName() throws DebugException {
		return "Statement at line " + NodeHelper.getLine(this.node);
	}

	@Override
	public final IRegisterGroup[] getRegisterGroups() throws DebugException {
		return new IRegisterGroup[0];
	}

	@Override
	public final IThread getThread() {
		return this.thread;
	}

	@Override
	public final IVariable[] getVariables() throws DebugException {
		return this.getDebugTarget().getVariables();
	}

	@Override
	public final boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	@Override
	public final boolean hasVariables() throws DebugException {
		return true;
	}

	@Override
	public final boolean equals(final Object other) {
		if (other instanceof WorthwhileStackFrame) {
			try {
				return this.getLineNumber() == ((WorthwhileStackFrame) other).getLineNumber();
			} catch (DebugException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public final int hashCode() {
		try {
			return this.getLineNumber();
		} catch (DebugException e) {
			return -1;
		}
	}

	@Override
	public final String toString() {
		return "Stack Frame for " + (node == null ? "NULL" : AstNodeToStringHelper.toString(node))
		                + " at line " + NodeHelper.getLine(node);
	}

}
