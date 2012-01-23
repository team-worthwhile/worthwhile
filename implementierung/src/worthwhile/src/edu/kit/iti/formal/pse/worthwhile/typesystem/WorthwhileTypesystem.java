package edu.kit.iti.formal.pse.worthwhile.typesystem;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.typesys.WorthwhileTypesystemGenerated;

/**
 * The type system for validation.
 * 
 */
public class WorthwhileTypesystem extends WorthwhileTypesystemGenerated {

	@Override
	protected final void initialize() {

		super.initialize();

	}

	/**
	 * Returns the type of the variable reference. If the variable reference is an array access return the base type
	 * of the array.
	 * 
	 * @param element
	 *                the variable reference from which you want to get the type.
	 * @param trace
	 *                a type calculation trace.
	 * 
	 * @return the type of the variable reference.
	 */
	@Override
	protected final EObject type(final VariableReference element, final TypeCalculationTrace trace) {

		if (element.getIndex() != null
		                && isInstanceOf(element.getVariable().getType(), p.getArrayType(), trace)) {
			trace.add(element, "variableRefernce_arrayAccess");

			return ((ArrayType) element.getVariable().getType()).getBaseType();
		} else {
			trace.add(element, "variableRefernce");
			return typeof(element.getVariable().getType(), trace);
		}
	}

	/**
	 * Returns the type of the array literal. Sets the base type of the array literal to the type of the first
	 * element of the array. If the array has no elements the base type is null.
	 * 
	 * @param element
	 *                The array literal from which you want to get the type.
	 * @param trace
	 *                a type calculation trace.
	 * 
	 * @return The type of the array literal.
	 */
	@Override
	protected final EObject type(final ArrayLiteral element, final TypeCalculationTrace trace) {

		ArrayType at = AstFactory.eINSTANCE.createArrayType();
		if (element.getValues().size() == 0) {
			at.setBaseType(null);
		} else if (isInstanceOf(typeof(element.getValues().get(0), trace), p.getIntegerType(), trace)) {
			at.setBaseType(AstFactory.eINSTANCE.createIntegerType());
		} else if (isInstanceOf(typeof(element.getValues().get(0), trace), p.getBooleanType(), trace)) {
			at.setBaseType(AstFactory.eINSTANCE.createBooleanType());
		}
		IntegerLiteral it = AstFactory.eINSTANCE.createIntegerLiteral();
		it.setValue(BigInteger.valueOf(element.getValues().size()));
		at.setSize(it);
		trace.add(element, "arrayType");
		return at;
	}

	/**
	 * Checks whether the two elements have the same type.
	 * 
	 * If both elements have the type {@link ArrayType} there base types will be compared and the result will be
	 * returned.
	 * 
	 * @param element1
	 *                The first element which shell be compared.
	 * @param type1
	 *                The type of the first element.
	 * @param element2
	 *                The second element which shell be compared.
	 * @param type2
	 *                The type of the second element.
	 * @param trace
	 *                a type calculation trace
	 * 
	 * @return true if both have the same type, otherwise false.
	 */
	@Override
	public final boolean isSameType(final EObject element1, final EObject type1, final EObject element2,
	                final EObject type2, final TypeCalculationTrace trace) {

		if (isInstanceOf(type1, p.getArrayType(), trace) && isInstanceOf(type2, p.getArrayType(), trace)) {
			ArrayType at1 = (ArrayType) type1;
			ArrayType at2 = (ArrayType) type2;
			return super.isSameType(at1, at1.getBaseType(), at2, at2.getBaseType(), trace);
		}
		return super.isSameType(element1, type1, element2, type2, trace);
	}

}
