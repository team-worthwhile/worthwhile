/*
 * generated by Xtext
 */
package edu.kit.iti.formal.pse.worthwhile.expressions;

import org.eclipse.xtext.scoping.IScopeProvider;

import de.itemis.xtext.typesystem.ITypesystem;
import edu.kit.iti.formal.pse.worthwhile.expressions.scoping.WorthwhileExpressionsScopeProvider;
import edu.kit.iti.formal.pse.worthwhile.typesystem.WorthwhileTypesystem;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class WorthwhileExpressionsRuntimeModule extends edu.kit.iti.formal.pse.worthwhile.expressions.AbstractWorthwhileExpressionsRuntimeModule {

	@Override
	public final Class<? extends IScopeProvider> bindIScopeProvider() {
		return WorthwhileExpressionsScopeProvider.class;
	}
	
	public final Class<? extends ITypesystem> bindITypesystem() {
		return WorthwhileTypesystem.class;
	}

}
