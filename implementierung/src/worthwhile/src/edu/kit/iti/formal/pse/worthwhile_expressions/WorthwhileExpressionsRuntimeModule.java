/*
 * generated by Xtext
 */
package edu.kit.iti.formal.pse.worthwhile_expressions;

import org.eclipse.xtext.scoping.IScopeProvider;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileRuntimeModule;
import edu.kit.iti.formal.pse.worthwhile_expressions.scoping.IWorthwhileContextProvider;
import edu.kit.iti.formal.pse.worthwhile_expressions.scoping.WorthwhileExpressionsScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class WorthwhileExpressionsRuntimeModule extends WorthwhileRuntimeModule {

	private final IWorthwhileContextProvider contextProvider;

	public WorthwhileExpressionsRuntimeModule(IWorthwhileContextProvider contextProvider) {
		this.contextProvider = contextProvider;
	}

	public WorthwhileExpressionsRuntimeModule() {
	        this.contextProvider = null;
        }

	@Override
	public final Class<? extends IScopeProvider> bindIScopeProvider() {
		return WorthwhileExpressionsScopeProvider.class;
	}

	/**
	 * Returns an instance of a {@link IWorthwhileContextProvider}.
	 * 
	 * @return an instance of a {@link IWorthwhileContextProvider}.
	 */
	public final IWorthwhileContextProvider bindIWorthwhileContextProvider() {
		return this.contextProvider;
	}

}
