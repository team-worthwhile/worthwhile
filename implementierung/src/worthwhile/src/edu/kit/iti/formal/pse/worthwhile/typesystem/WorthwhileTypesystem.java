package edu.kit.iti.formal.pse.worthwhile.typesystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import de.itemis.xtext.typesystem.ITypesystem;
import de.itemis.xtext.typesystem.characteristics.TypeCharacteristic;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

public class WorthwhileTypesystem implements ITypesystem{

	@Override
        public void checkTypesystemConstraints(EObject arg0, ValidationMessageAcceptor arg1) {
	        // TODO Auto-generated method stub
	        
        }

	@Override
        public EObject computeCommonType(EObject arg0, EObject arg1, EObject arg2, EObject arg3,
                        TypeCalculationTrace arg4) {
	        // TODO Auto-generated method stub
	        return null;
        }

	@Override
        public boolean hasCharacteristic(EObject arg0, TypeCharacteristic arg1) {
	        // TODO Auto-generated method stub
	        return false;
        }

	@Override
        public boolean isCompatibleTypeOrdered(EObject arg0, EObject arg1, EObject arg2, EObject arg3,
                        TypeCalculationTrace arg4) {
	        // TODO Auto-generated method stub
	        return false;
        }

	@Override
        public boolean isCompatibleTypeUnordered(EObject arg0, EObject arg1, EObject arg2, EObject arg3,
                        TypeCalculationTrace arg4) {
	        // TODO Auto-generated method stub
	        return false;
        }

	@Override
        public boolean isInstanceOf(EObject arg0, EClass arg1, TypeCalculationTrace arg2) {
	        // TODO Auto-generated method stub
	        return false;
        }

	@Override
        public boolean isNameLocallyUnique(EObject arg0, EList<? extends EObject> arg1) {
	        // TODO Auto-generated method stub
	        return false;
        }

	@Override
        public boolean isSameType(EObject arg0, EObject arg1, EObject arg2, EObject arg3, TypeCalculationTrace arg4) {
	        // TODO Auto-generated method stub
	        return false;
        }

	@Override
        public EObject tryToCoerceType(EObject arg0, EObject arg1, EObject arg2, TypeCalculationTrace arg3) {
	        // TODO Auto-generated method stub
	        return null;
        }

	@Override
        public String typeString(Object arg0) {
	        // TODO Auto-generated method stub
	        return null;
        }

	@Override
        public String typeStrings(Object[] arg0) {
	        // TODO Auto-generated method stub
	        return null;
        }

	@Override
        public EObject typeof(EObject arg0, TypeCalculationTrace arg1) {
	        // TODO Auto-generated method stub
	        return null;
        }

}
