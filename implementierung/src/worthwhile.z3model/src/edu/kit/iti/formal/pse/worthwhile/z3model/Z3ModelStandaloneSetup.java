
package edu.kit.iti.formal.pse.worthwhile.z3model;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Z3ModelStandaloneSetup extends Z3ModelStandaloneSetupGenerated{

	public static void doSetup() {
		new Z3ModelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

