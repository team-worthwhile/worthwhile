package org.xtext.example.mydsl.typesystem;

import org.eclipse.emf.ecore.EObject;
import org.xtext.example.mydsl.myDsl.ArrayAccess;
import org.xtext.example.mydsl.myDsl.Function;
import org.xtext.example.mydsl.myDsl.ReturnStatement;
import org.xtext.example.mydsl.typesys.MyDslTypesystemGenerated;

import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;


public class MyDslTypesystem extends MyDslTypesystemGenerated  {

	@Override
	protected EObject type(ArrayAccess element, TypeCalculationTrace trace) {
		// TODO Auto-generated method stub
		return null;
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

//	@Override
//	protected void initialize() {
//		MyDslPackage lang = MyDslPackage.eINSTANCE;
//		
//		try {
//			// Integer and Boolean literals return -- surprise -- the integer and boolean types, respectively. 
//			useCloneAsType(lang.getIntType());
//			useCloneAsType(lang.getBoolType());
//			
//			// Variable declarations return the type of the specified variable
//			useTypeOfFeature(lang.getVariableDeclaration(), lang.getVariable_Type());
//			
//			// A variable reference return the type of the variable it references. 
//			useTypeOfFeature(lang.getVariableRef(), lang.getVariableRef_Symbol());
//			
//			// The arithmetic operations need an integer type as parameters.
//			useFixedType(lang.getPlus(), lang.getIntType());
//			useFixedType(lang.getMinus(), lang.getIntType());
//			useFixedType(lang.getMulti(), lang.getIntType());
//			useFixedType(lang.getDiv(), lang.getIntType());
//			useFixedType(lang.getModulo(), lang.getIntType());
//			useFixedType(lang.getUnaryMinusOperator(), lang.getIntType());
//			useFixedType(lang.getUnaryPlusOperator(), lang.getIntType());
//			
//			// The Boolean operators need a boolean type as parameters
//			useFixedType(lang.getAnd(), lang.getBoolType());
//			useFixedType(lang.getOr(), lang.getBoolType());
//			useFixedType(lang.getUnaryNotOperator(), lang.getBoolType());
//			
//			// The initial value of a variable has to match the declared type.
//			ensureOrderedCompatibility(lang.getVariableDeclaration(), lang.getVariableDeclaration_InitialValue(), lang.getVariable_Type());
//		} catch (TypesystemConfigurationException e) {
//			e.printStackTrace();
//		}
//	} 
	
}
