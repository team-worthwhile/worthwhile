package edu.kit.iti.formal.pse.worthwhile.debugger.runtime;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileRuntimeModule;
import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugScopeProvider;

/**
 * Runtime module for a Worthwhile environment in the debugger.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebuggerRuntimeModule extends WorthwhileRuntimeModule {

	@Override
	public final Class<? extends org.eclipse.xtext.scoping.IScopeProvider> bindIScopeProvider() {
		return WorthwhileDebugScopeProvider.class;
	}
}
