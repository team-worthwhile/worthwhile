package edu.kit.iti.formal.pse.worthwhile.debugger.runtime;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileRuntimeModule;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugTarget;

/**
 * Runtime module for a Worthwhile environment in the debugger.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebuggerRuntimeModule extends WorthwhileRuntimeModule {

	/**
	 * The debug target to use.
	 */
	private final WorthwhileDebugTarget debugTarget;

	/**
	 * Creates a new instance of the {@link WorthwhileDebuggerRuntimeModule} class.
	 * 
	 * @param debugTarget
	 *                The debug target to use.
	 */
	public WorthwhileDebuggerRuntimeModule(final WorthwhileDebugTarget debugTarget) {
		this.debugTarget = debugTarget;
	}

	/**
	 * Returns an instance of a {@link WorthwhileDebugTarget}.
	 * 
	 * @return an instance of a {@link WorthwhileDebugTarget}.
	 */
	public final WorthwhileDebugTarget bindWorthwhileDebugTarget() {
		return this.debugTarget;
	}
}
