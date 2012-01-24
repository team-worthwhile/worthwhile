package edu.kit.iti.formal.pse.worthwhile.debugger.runtime;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileRuntimeModule;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugScopeProvider;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugTarget;
import edu.kit.iti.formal.pse.worthwhile.validation.WorthwhileNamesAreUniqueValidationHelper;

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

	/**
	 * Provides a scoping provider.
	 * 
	 * @return The class of a scoping provider.
	 */
	public final Class<? extends IScopeProvider> bindIScopeProvider() {
		return WorthwhileDebugScopeProvider.class;
	}
}
