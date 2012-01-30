package edu.kit.iti.formal.pse.worthwhile.model;

import java.util.HashMap;
import java.util.Map;

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
	private final Map<Integer, T> subValues;

	/**
	 * Returns the sub-values of this composite value.
	 * 
	 * @return The sub-values of this composite value.
	 */
	public final Map<Integer, T> getSubValues() {
		return this.subValues;
	}

	/**
	 * Creates a new instance of the {@link CompositeValue} class.
	 * 
	 * @param subValues
	 *                The sub-values of this value.
	 */
	public CompositeValue(final Map<Integer, T> subValues) {
		this.subValues = subValues;
	}
	
	/**
	 * Creates a new instance of the {@link CompositeValue} class.
	 * 
	 * @param subValues
	 *                The sub-values of this value.
	 */
	public CompositeValue(final T[] subValues) {
		this.subValues = new HashMap<Integer,T>();
		for (int i = 0; i < subValues.length; i++) {
			this.subValues.put(i, subValues[i]);
		}
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
		
		for (Integer index : this.subValues.keySet()) {
			result += this.subValues.get(index).hashCode();
		}
		
		return result;
	}

}
