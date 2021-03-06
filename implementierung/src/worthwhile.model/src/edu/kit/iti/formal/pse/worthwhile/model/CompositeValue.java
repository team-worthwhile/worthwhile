package edu.kit.iti.formal.pse.worthwhile.model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IValueVisitor;

/**
 * Represents a value consisting of ordered sub-values (e.g. an array).
 * 
 * @param <T>
 *                The type of the sub-values.
 * 
 * @author Joachim
 * 
 */
public class CompositeValue<T extends Value> extends Value {

	/**
	 * The sub-values of this composite value.
	 */
	private final Map<BigInteger, T> subValues;

	/**
	 * The {@link CompositeValue}s' {@link Type} is a {@link ArrayType}.
	 */
	private final ArrayType type;

	/**
	 * Returns the sub-values of this composite value.
	 * 
	 * @return The sub-values of this composite value.
	 */
	public final Map<BigInteger, T> getSubValues() {
		return this.subValues;
	}

	/**
	 * Creates a new instance of the {@link CompositeValue} class.
	 * 
	 * @param subValues
	 *                The sub-values of this value.
	 * @param baseType
	 *                the sub-values' {@link PrimitiveType}
	 */
	public CompositeValue(final Map<BigInteger, T> subValues, final PrimitiveType baseType) {
		this.subValues = subValues;
		this.type = AstNodeCreatorHelper.createArrayType(baseType);
	}

	/**
	 * Creates a new instance of the {@link CompositeValue} class.
	 * 
	 * @param subValues
	 *                The sub-values of this value.
	 * @param baseType
	 *                the sub-values' {@link PrimitiveType}
	 */
	public CompositeValue(final T[] subValues, final PrimitiveType baseType) {
		this.subValues = new HashMap<BigInteger, T>();
		for (int i = 0; i < subValues.length; i++) {
			this.subValues.put(BigInteger.valueOf(i), subValues[i]);
		}
		this.type = AstNodeCreatorHelper.createArrayType(baseType);
	}

	/**
	 * Returns a new instance of the {@link CompositeValue} class with the value at index i replaced by (or newly
	 * set to) the specified value.
	 * 
	 * The new <code>CompositeValue</code>'s sub-values' {@link Type} is a clone of this one's.
	 * 
	 * @param index
	 *                The index at which to set the new value.
	 * @param newValue
	 *                The new value to set.
	 * @return a new instance of the {@link CompositeValue} class with the value at index i replaced by (or newly
	 *         set to) the specified value.
	 */
	public final CompositeValue<T> replaceValue(final BigInteger index, final T newValue) {
		// Copy the current values to a new composite value
		Map<BigInteger, T> newValues = new HashMap<BigInteger, T>();

		for (BigInteger idx : this.subValues.keySet()) {
			newValues.put(idx, this.getSubValues().get(idx));
		}

		// Put the new value at the specified index.
		newValues.put(index, newValue);

		// Return a new composite value.
		return new CompositeValue<T>(newValues, AstNodeCloneHelper.clone(this.type.getBaseType()));
	}

	/**
	 * Returns a new instance of the {@link CompositeValue} class with the value at index i replaced by (or newly
	 * set to) the specified value.
	 * 
	 * @param index
	 *                The index at which to set the new value.
	 * @param newValue
	 *                The new value to set.
	 * @return a new instance of the {@link CompositeValue} class with the value at index i replaced by (or newly
	 *         set to) the specified value.
	 */
	@SuppressWarnings("unchecked")
	public final CompositeValue<T> replaceUntypedValue(final BigInteger index, final Value newValue) {
		return this.replaceValue(index, (T) newValue);
	}

	@Override
	public final void accept(final IValueVisitor visitor) {
		visitor.visitCompositeValue(this);
	}

	@Override
	public final boolean equals(final Object other) {
		if (other instanceof CompositeValue<?>) {
			return this.subValues.equals(((CompositeValue<?>) other).getSubValues());
		} else {
			return false;
		}
	}

	@Override
	public final int hashCode() {
		int result = 0;

		for (BigInteger index : this.subValues.keySet()) {
			result += this.subValues.get(index).hashCode();
		}

		return result;
	}

	@Override
	public final Type getType() {
		return this.type;
	}
}
