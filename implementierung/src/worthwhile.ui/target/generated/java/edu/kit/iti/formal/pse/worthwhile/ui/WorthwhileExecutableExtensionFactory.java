/*
 * generated by Xtext
 */
package edu.kit.iti.formal.pse.worthwhile.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class WorthwhileExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return edu.kit.iti.formal.pse.worthwhile.ui.internal.WorthwhileActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return edu.kit.iti.formal.pse.worthwhile.ui.internal.WorthwhileActivator.getInstance().getInjector("edu.kit.iti.formal.pse.worthwhile.Worthwhile");
	}
	
}
