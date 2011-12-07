package org.xtext.example.mydsl.typesystem;

import org.eclipse.emf.ecore.EObject;

import de.itemis.xtext.typesystem.ITypesystem;
import de.itemis.xtext.typesystem.checks.custom.StaticCustomTypeChecker;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

public class FunctionCallActualParameterTypeChecker extends StaticCustomTypeChecker {

	public FunctionCallActualParameterTypeChecker(String info) {
		super(info);
	}

	@Override
	public boolean isValid(ITypesystem ts, EObject type,
			TypeCalculationTrace trace) {

		// FIXME Implement parameter type checking here
		return false;
	}

}
