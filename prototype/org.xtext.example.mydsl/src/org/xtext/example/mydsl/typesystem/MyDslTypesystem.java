package org.xtext.example.mydsl.typesystem;

import org.eclipse.emf.ecore.EObject;
import org.xtext.example.mydsl.myDsl.ArrayAccess;
import org.xtext.example.mydsl.myDsl.ArrayType;
import org.xtext.example.mydsl.myDsl.Function;
import org.xtext.example.mydsl.myDsl.ReturnStatement;
import org.xtext.example.mydsl.myDsl.Type;
import org.xtext.example.mydsl.typesys.MyDslTypesystemGenerated;

import de.itemis.xtext.typesystem.ITypesystem;
import de.itemis.xtext.typesystem.checks.CustomTypeChecker;
import de.itemis.xtext.typesystem.checks.custom.StaticCustomTypeChecker;
import de.itemis.xtext.typesystem.exceptions.EClassDoesntHaveFeatureException;
import de.itemis.xtext.typesystem.exceptions.FeatureMustBeSingleValuedException;
import de.itemis.xtext.typesystem.exceptions.InvalidTypeSpecification;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;


public class MyDslTypesystem extends MyDslTypesystemGenerated  {

	@Override
	protected void initialize() {
		super.initialize();
		
		try {
			ensureFeatureType(p.getFunctionCallActualParameter(), p.getFunctionCallActualParameter_Value(), new FunctionCallActualParameterTypeChecker(null));
		} catch (FeatureMustBeSingleValuedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EClassDoesntHaveFeatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidTypeSpecification e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected EObject type(ArrayAccess element, TypeCalculationTrace trace) {
		ArrayType arrayType = (ArrayType) typeof(element.getExpr(), trace);
		trace.add(element, "array type is " + typeString(arrayType));
		Type bt = arrayType.getBaseType();
		trace.add(element, "base type is is " + typeString(bt));
		return bt;
	}

	@Override
	protected EObject type(ReturnStatement element, TypeCalculationTrace trace) {
		EObject obj = element;
		
		// Go up the parse tree until we find a function declaration or arrive at the top.
		do {
			obj = obj.eContainer();
		} while (obj != null && !(obj instanceof Function));
		
		if (obj != null) {
			return ((Function) obj).getReturnType();
		} else {
			return null;
		}
	}
	
	public String typeToString( EObject o ) {
		String cn = o.eClass().getName();
		if ( cn.toLowerCase().endsWith("type")) return cn.substring(0,cn.length()-4);
		return null;
	}
	
}
