package edu.kit.iti.formal.pse.worthwhile.model;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IValueVisitor;

/**
 * Represents a boolean value (true or false).
 * 
 * @author Joachim
 * 
 */
public class BooleanValue extends Value {

	/**
	 * The value represented by this object.
	 */
	private final boolean value;

	/**
	 * Returns the value represented by this object.
	 * 
	 * @return the value represented by this object.
	 */
	public final boolean getValue() {
		return value;
	}

	/**
	 * Creates a new instance of the {@link BooleanValue} class.
	 * 
	 * @param value
	 *                The value represented by this object.
	 */
	public BooleanValue(final boolean value) {
		this.value = value;
	}

	@Override
	public final void accept(final IValueVisitor visitor) {
		visitor.visitBooleanValue(this);
	}

	@Override
	public final boolean equals(final Object other) {
		if (other instanceof BooleanValue) {
			return this.value == ((BooleanValue) other).getValue();
		} else {
			return false;
		}
	}

	@Override
	public final int hashCode() {
		return this.value ? 1 : 0;
	}

}
