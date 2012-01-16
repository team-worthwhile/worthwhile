package edu.kit.iti.formal.pse.worthwhile.typesystem;

import org.eclipse.emf.ecore.EObject;

import de.itemis.xtext.typesystem.ITypesystem;
import de.itemis.xtext.typesystem.checks.custom.StaticCustomTypeChecker;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

public class FunctionCallActualParameterTypeChecker extends StaticCustomTypeChecker {

	public FunctionCallActualParameterTypeChecker(final String info) {
		super(info);
	}

	@Override
        public final boolean isValid(final ITypesystem ts, final EObject type,
			final TypeCalculationTrace trace) {

		// FIXME Implement parameter type checking here
		return false;
	}

}
