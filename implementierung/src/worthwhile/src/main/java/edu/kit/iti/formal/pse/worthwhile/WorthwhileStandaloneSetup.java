package edu.kit.iti.formal.pse.worthwhile;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl;

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
	public Injector createInjectorAndDoEMFRegistration() {
		AstPackageImpl.init();
		return super.createInjectorAndDoEMFRegistration();
	}
}
