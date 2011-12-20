
package edu.kit.iti.formal.pse.worthwhile;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class WorthwhileStandaloneSetup extends WorthwhileStandaloneSetupGenerated{

	public static void doSetup() {
		new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

