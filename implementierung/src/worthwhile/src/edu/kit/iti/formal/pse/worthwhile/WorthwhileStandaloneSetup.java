package edu.kit.iti.formal.pse.worthwhile;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry.
 */
public class WorthwhileStandaloneSetup extends
WorthwhileStandaloneSetupGenerated {

	public static void doSetup() {
		new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
        public final Injector createInjectorAndDoEMFRegistration() {
		AstPackage.init();
		return super.createInjectorAndDoEMFRegistration();
	}
}
