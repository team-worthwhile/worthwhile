
package edu.kit.iti.formal.pse.worthwhile_expressions;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class WorthwhileExpressionsStandaloneSetup extends WorthwhileExpressionsStandaloneSetupGenerated{

	public static void doSetup() {
		new WorthwhileExpressionsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

