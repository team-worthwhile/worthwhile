package edu.kit.iti.formal.pse.worthwhile.model;

import java.util.List;

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
	private final T[] subValues;

	/**
	 * Returns the sub-values of this composite value.
	 * 
	 * @return The sub-values of this composite value.
	 */
	public final T[] getSubValues() {
		return this.subValues;
	}

	/**
	 * Creates a new instance of the {@link CompositeValue} class.
	 * 
	 * @param subValues
	 *                The sub-values of this value.
	 */
	public CompositeValue(final T[] subValues) {
		this.subValues = subValues;
	}

	@Override
	public final void accept(final IValueVisitor visitor) {
		visitor.visitCompositeValue(this);
	}

	@Override
        public final boolean equals(final Object other) {
		if (other instanceof CompositeValue<?>) {
			// FIXME: Does this work?
			return this.subValues.equals(((CompositeValue<?>) other).getSubValues());
		} else {
			return false;
		}
	}
	
	@Override
        public final int hashCode() {
		int result = 0;
		
		for (T subValue : this.subValues) {
			result += subValue.hashCode();
		}
		
		return result;
	}

}
