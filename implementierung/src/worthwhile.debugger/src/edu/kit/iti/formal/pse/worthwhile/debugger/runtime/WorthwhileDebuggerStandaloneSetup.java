package edu.kit.iti.formal.pse.worthwhile.debugger.runtime;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileStandaloneSetup;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugTarget;

/**
 * Standalone setup for a Worthwhile environment in the Worthwhile debugger.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebuggerStandaloneSetup extends WorthwhileStandaloneSetup {

	/**
	 * The debug target to use.
	 */
	private final WorthwhileDebugTarget debugTarget;

	/**
	 * Creates a new instance of the {@link WorthwhileDebuggerStandaloneSetup} class.
	 * 
	 * @param debugTarget
	 *                The debug target to use.
	 */
	public WorthwhileDebuggerStandaloneSetup(final WorthwhileDebugTarget debugTarget) {
		this.debugTarget = debugTarget;
	}

	@Override
	public final Injector createInjector() {
		return Guice.createInjector(new WorthwhileDebuggerRuntimeModule(this.debugTarget));
	}

}