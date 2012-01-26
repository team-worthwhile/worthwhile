package edu.kit.iti.formal.pse.worthwhile_expressions;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile_expressions.scoping.IWorthwhileContextProvider;

/**
 * Initialization support for running Xtext languages without equinox extension registry
 */
public class WorthwhileExpressionsStandaloneSetup extends WorthwhileExpressionsStandaloneSetupGenerated {

	private final IWorthwhileContextProvider contextProvider;

	public WorthwhileExpressionsStandaloneSetup(IWorthwhileContextProvider contextProvider) {
		this.contextProvider = contextProvider;
	}

	public static void doSetup(IWorthwhileContextProvider contextProvider) {
		new WorthwhileExpressionsStandaloneSetup(contextProvider).createInjectorAndDoEMFRegistration();
	}

	@Override
	public final Injector createInjector() {
		return Guice.createInjector(new WorthwhileExpressionsRuntimeModule(this.contextProvider));
	}
}
