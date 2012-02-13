package edu.kit.iti.formal.pse.worthwhile.model;

import java.math.BigInteger;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IValueVisitor;

/**
 * Represents an Integer value.
 * 
 * @author Joachim
 * 
 */
public class IntegerValue extends Value {

	/**
	 * The value represented by this object.
	 */
	private final BigInteger value;

	/**
	 * Returns the value represented by this object.
	 * 
	 * @return the value represented by this object.
	 */
	public final BigInteger getValue() {
		return value;
	}

	/**
	 * Creates a new instance of the {@link IntegerValue} class.
	 * 
	 * @param value
	 *                The value represented by this object.
	 */
	public IntegerValue(final BigInteger value) {
		if (value == null) {
			throw new IllegalArgumentException("IntegerValue cannot hold null as a value");
		}

		this.value = value;
	}

	@Override
	public final void accept(final IValueVisitor visitor) {
		visitor.visitIntegerValue(this);
	}

	@Override
	public final boolean equals(final Object other) {
		if (other instanceof IntegerValue) {
			return this.value.equals(((IntegerValue) other).getValue());
		} else {
			return false;
		}
	}

	@Override
	public final int hashCode() {
		return this.value.hashCode();
	}

}
