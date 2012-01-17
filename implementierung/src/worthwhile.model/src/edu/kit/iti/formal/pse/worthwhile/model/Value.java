/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.model;

import java.math.BigInteger;

/**
 * This class represents a value with its corresponding name to be used in the interpreter.
 * 
 * @author matthias and stefan
 */
public class Value {
	/**
	 * The type of the value.
	 */
	private ValueType valueType;

	/**
	 * The value of the integer.
	 */
	private BigInteger integerValue;

	/**
	 * The value of the boolean.
	 */
	private Boolean booleanValue;

	/**
	 * The value of the integer array.
	 */
	private BigInteger[] integerArray;

	/**
	 * The value of the boolean array.
	 */
	private Boolean[] booleanArray;

	/**
	 * This method constructs a Value of the type Integer {@link ValueType#INTEGER_TYPE}.
	 * 
	 * @param integerValue
	 *                the value for this Value.
	 */
	public Value(final BigInteger integerValue) {
		this.setValueType(ValueType.INTEGER_TYPE);
		this.setIntegerValue(integerValue);
	}

	/**
	 * This method constructs a Value of the type Boolean {@link ValueType#BOOLEAN_TYPE}.
	 * 
	 * @param booleanValue
	 *                the value for this Value.
	 */
	public Value(final Boolean booleanValue) {
		this.setValueType(ValueType.BOOLEAN_TYPE);
		this.setBooleanValue(booleanValue);
	}

	/**
	 * This method constructs a Value of the type Integer Array {@link ValueType#INTEGER_ARRAY_TYPE}.
	 * 
	 * @param integerArray
	 *                the value for this array.
	 */
	public Value(final BigInteger[] integerArray) {
		this.setValueType(ValueType.INTEGER_ARRAY_TYPE);
		this.setIntegerArray(integerArray);
	}

	/**
	 * This method constructs a Value of the type Boolean Array {@link ValueType#BOOLEAN_ARRAY_TYPE}.
	 * 
	 * @param booleanArray
	 *                the value for this array.
	 */
	public Value(final Boolean[] booleanArray) {
		this.setValueType(ValueType.BOOLEAN_ARRAY_TYPE);
		this.setBooleanArray(booleanArray);
	}

	/**
	 * This returns the type of this Value.
	 * 
	 * @return the valueType of this Value.
	 */
	public final ValueType getValueType() {
		return valueType;
	}

	/**
	 * This sets the type of this Value {@link ValueType}.
	 * 
	 * @param valueType
	 *                the type of this Value.
	 */
	private void setValueType(final ValueType valueType) {
		this.valueType = valueType;
	}

	/**
	 * This method returns the integer value of this Value, if the Type of this Value is
	 * {@link ValueType#INTEGER_TYPE}, otherwise it will return null.
	 * 
	 * @return returns the integer value of this Value or null.
	 */
	public final BigInteger getIntegerValue() {
		if (this.getValueType() == ValueType.INTEGER_TYPE) {
			return this.integerValue;
		} else {
			return null;
		}
	}

	/**
	 * This method returns the boolean value of this Value, if the Type of this Value is
	 * {@link ValueType#BOOLEAN_TYPE}, otherwise it will return null.
	 * 
	 * @return returns the boolean value of this Value or null.
	 */
	public final Boolean getBooleanValue() {
		if (this.getValueType() == ValueType.BOOLEAN_TYPE) {
			return this.booleanValue;
		} else {
			return null;
		}
	}

	/**
	 * This method returns the boolean array of this Value, if the Type of this Value is
	 * {@link ValueType#BOOLEAN_ARRAY_TYPE}, otherwise it will return null.
	 * 
	 * @return returns the boolean array of this Value or null.
	 */
	public final Boolean[] getBooleanArray() {
		if (this.getValueType() == ValueType.BOOLEAN_ARRAY_TYPE) {
			return this.booleanArray;
		} else {
			return null;
		}
	}

	/**
	 * This method returns the integer array of this Value, if the Type of this Value is
	 * {@link ValueType#INTEGER_ARRAY_TYPE}, otherwise it will return null.
	 * 
	 * @return returns the integer array of this Value or null.
	 */
	public final BigInteger[] getIntegerArray() {
		if (this.getValueType() == ValueType.INTEGER_ARRAY_TYPE) {
			return this.integerArray;
		} else {
			return null;
		}
	}

	/**
	 * This sets the integer value of this Value. Note, that by calling this function, the type of this Value will
	 * be set to {@link ValueType.INTEGER_TYPE}.
	 * 
	 * @param integerValue
	 *                the integer value to be set.
	 */
	public final void setIntegerValue(final BigInteger integerValue) {
		this.setValueType(ValueType.INTEGER_TYPE);
		this.integerValue = integerValue;
	}

	/**
	 * This sets the boolean value of this Value. Note, that by calling this function, the type of this Value will
	 * be set to {@link ValueType.BOOLEAN_TYPE}.
	 * 
	 * @param booleanValue
	 *                the boolean value to be set.
	 */
	public final void setBooleanValue(final Boolean booleanValue) {
		this.setValueType(ValueType.BOOLEAN_TYPE);
		this.booleanValue = booleanValue;
	}

	/**
	 * This sets the integer array of this Value. Note, that by calling this function, the type of this Value will
	 * be set to {@link ValueType.INTEGER_ARRAY_TYPE}.
	 * 
	 * @param integerArray
	 *                the integer array to be set.
	 */
	public final void setIntegerArray(final BigInteger[] integerArray) {
		this.setValueType(ValueType.INTEGER_ARRAY_TYPE);
		this.integerArray = integerArray;
	}

	/**
	 * This sets the boolean array of this Value. Note, that by calling this function, the type of this Value will
	 * be set to {@link ValueType.BOOLEAN_ARRAY_TYPE}.
	 * 
	 * @param booleanArray
	 *                the boolean array to be set.
	 */
	public final void setBooleanArray(final Boolean[] booleanArray) {
		this.setValueType(ValueType.BOOLEAN_ARRAY_TYPE);
		this.booleanArray = booleanArray;
	}

	/**
	 * This method checks whether this value and a given object are equal. The method returns true if the given
	 * object is of type Value and its valueType is equal to the valueType of this value, also the corresponding
	 * values of both, the given value and this value have to be the same. If the value is either
	 * {@link ValueType#INTEGER_ARRAY_TYPE} or {@link ValueType#BOOLEAN_ARRAY_TYPE} the size and each element of the
	 * array is compared. Otherwise this method returns false.
	 * 
	 * @param value
	 *                the object to be checked for equality with this value.
	 * @return returns true if the this and the given objects are equal, otherwise false.
	 */
	public final boolean equals(final Object value) {
		if (value instanceof Value) {
			if (((Value) value).getValueType() == (this.getValueType())) {
				switch (((Value) value).getValueType()) {
				case INTEGER_TYPE:
					return this.getIntegerValue().equals(((Value) value).getIntegerValue());
				case BOOLEAN_TYPE:
					return this.getBooleanValue().equals(((Value) value).getBooleanValue());
				case INTEGER_ARRAY_TYPE:
					return this.equalsArray(((Value) value).getIntegerArray());
				case BOOLEAN_ARRAY_TYPE:
					return this.equalsArray(((Value) value).getBooleanArray());
				default:
					return false;
				}
			} else {
				return false;
			}
		} else {
			return super.equals(value);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public final int hashCode() {
		return super.hashCode();
	}

	/**
	 * This method checks whether this and a given array are equal. Equal means in this context that the size of
	 * both arrays and every element in the first array is equal to its corresponding element of the other array.
	 * 
	 * @param array
	 *                the array to check equality with the array of this object.
	 * @return returns true if this and the given array are equal, otherwise false.
	 */
	private boolean equalsArray(final BigInteger[] array) {
		if (this.getIntegerArray().length == array.length) {
			for (int i = 0; i < array.length; i++) {
				if (this.getIntegerArray()[i] != null && array[i] != null
				                && !this.getIntegerArray()[i].equals(array[i])) {
					return false;
				} else if (this.getIntegerArray()[i] != null && array[i] == null) {
					return false;
				} else if (this.getIntegerArray()[i] == null && array[i] != null) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method checks whether this and a given array are equal. Equal means in this context that the size of
	 * both arrays and every element in the first array is equal to its corresponding element of the other array.
	 * 
	 * @param array
	 *                the array to check equality with the array of this object.
	 * @return returns true if this and the given array are equal, otherwise false.
	 */
	private boolean equalsArray(final Boolean[] array) {
		if (this.getBooleanArray().length == array.length) {
			for (int i = 0; i < array.length; i++) {
				if (this.getBooleanArray()[i] != null && array[i] != null
				                && !this.getBooleanArray()[i].equals(array[i])) {
					return false;
				} else if (this.getBooleanArray()[i] != null && array[i] == null) {
					return false;
				} else if (this.getBooleanArray()[i] == null && array[i] != null) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}