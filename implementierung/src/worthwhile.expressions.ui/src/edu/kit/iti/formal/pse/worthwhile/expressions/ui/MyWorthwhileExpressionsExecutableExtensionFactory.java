package edu.kit.iti.formal.pse.worthwhile.expressions.ui;

import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class MyWorthwhileExpressionsExecutableExtensionFactory extends WorthwhileExpressionsExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return edu.kit.iti.formal.pse.worthwhile.expressions.ui.activator.WorthwhileExpressionsActivator
		                .getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return edu.kit.iti.formal.pse.worthwhile.expressions.ui.activator.WorthwhileExpressionsActivator
		                .getInstance().getInjector(
		                                "edu.kit.iti.formal.pse.worthwhile.expressions.WorthwhileExpressions");
	}

}
