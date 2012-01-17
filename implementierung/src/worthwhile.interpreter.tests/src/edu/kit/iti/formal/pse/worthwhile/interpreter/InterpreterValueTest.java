package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;

import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ValueType;

/**
 * @author matthias and stefan
 */
public class InterpreterValueTest {

	@Test
	public void test() {
		assertNotNull(new Value(new BigInteger("42")));
		assertNotNull(new Value(true));
		BigInteger[] array1 = new BigInteger[2];
		assertNotNull(new Value(array1));
		Boolean[] array2 = new Boolean[2];
		assertNotNull(new Value(array2));
	}

	@Test
	public void testGetValueType() {
		Value value1 = new Value(new BigInteger("42"));
		assertEquals(value1.getValueType(), ValueType.INTEGER_TYPE);

		Value value2 = new Value(new Boolean(true));
		assertEquals(value2.getValueType(), ValueType.BOOLEAN_TYPE);

		BigInteger[] array1 = new BigInteger[1];
		Value value3 = new Value(array1);
		assertEquals(value3.getValueType(), ValueType.INTEGER_ARRAY_TYPE);

		Boolean[] array2 = new Boolean[2];
		Value value4 = new Value(array2);
		assertEquals(value4.getValueType(), ValueType.BOOLEAN_ARRAY_TYPE);
	}

	@Test
	public void testGetIntegerValue() {
		Value value1 = new Value(new BigInteger("42"));
		assertEquals(value1.getIntegerValue(), new BigInteger("42"));
	}

	@Test
	public void testGetBooleanValue() {
		Value value1 = new Value(true);
		assertEquals(value1.getBooleanValue(), true);
	}

	@Test
	public void testGetIntegerArray() {
		BigInteger[] array1 = new BigInteger[2];
		Value value1 = new Value(array1);
		assertSame(value1.getIntegerArray(), array1);
	}

	@Test
	public void testGetBooleanArray() {
		Boolean[] array1 = new Boolean[2];
		Value value1 = new Value(array1);
		assertSame(value1.getBooleanArray(), array1);
	}

	@Test
	public void testSetIntegerValue() {
		Value value1 = new Value(true);
		value1.setIntegerValue(new BigInteger("42"));
		assertEquals(value1.getValueType(), ValueType.INTEGER_TYPE);
		assertEquals(value1.getIntegerValue(), new BigInteger("42"));
	}

	@Test
	public void testSetBooleanValue() {
		Value value1 = new Value(new BigInteger("42"));
		value1.setBooleanValue(true);
		assertEquals(value1.getValueType(), ValueType.BOOLEAN_TYPE);
		assertEquals(value1.getBooleanValue(), true);
	}

	@Test
	public void testSetIntegerArray() {
		Value value1 = new Value(true);
		BigInteger[] array1 = new BigInteger[2];
		value1.setIntegerArray(array1);
		assertEquals(value1.getValueType(), ValueType.INTEGER_ARRAY_TYPE);
		assertSame(value1.getIntegerArray(), array1);
	}

	@Test
	public void testSetBooleanArray() {
		Value value1 = new Value(new BigInteger("42"));
		Boolean[] array1 = new Boolean[2];
		value1.setBooleanArray(array1);
		assertEquals(value1.getValueType(), ValueType.BOOLEAN_ARRAY_TYPE);
		assertSame(value1.getBooleanArray(), array1);
	}

	@Test
	public void testEquals() {
		Value value1 = new Value(new BigInteger("42"));
		Value value2 = new Value(new BigInteger("42"));
		assertNotSame(value1, value2);
		assertEquals(value1, value2);
		assertTrue(value1.equals(value2));

		Value value3 = new Value(new Boolean(true));
		Value value4 = new Value(new Boolean(true));
		assertNotSame(value3, value4);
		assertEquals(value3, value4);
		assertTrue(value3.equals(value4));

		assertNotSame(value1, value3);
		assertFalse(value1.equals(value3));
		value2.setBooleanValue(new Boolean(true));
		assertNotSame(value2, value3);
		assertTrue(value2.equals(value3));
		value4.setIntegerValue(new BigInteger("42"));
		assertNotSame(value4, value1);
		assertTrue(value4.equals(value1));

		BigInteger[] array1 = new BigInteger[4];
		BigInteger[] array2 = new BigInteger[4];
		array1[0] = new BigInteger("1");
		array2[0] = new BigInteger("1");
		array1[1] = new BigInteger("2");
		array2[1] = new BigInteger("2");
		array1[3] = new BigInteger("3");
		array2[3] = new BigInteger("3");
		Value value5 = new Value(array1);
		Value value6 = new Value(array2);
		assertNotSame(value5, value6);
		assertEquals(value5, value6);
		assertTrue(value5.equals(value6));
		array1[2] = new BigInteger("4");
		array2[2] = new BigInteger("5");
		assertNotSame(value5, value6);
		assertFalse(value5.equals(value6));
		array1[2] = new BigInteger("4");
		array2[2] = new BigInteger("4");
		assertNotSame(value5, value6);
		assertEquals(value5, value6);
		assertTrue(value5.equals(value6));

		Boolean[] array3 = new Boolean[3];
		Boolean[] array4 = new Boolean[3];
		array3[0] = true;
		array4[0] = true;
		array3[1] = false;
		array4[1] = false;
		Value value7 = new Value(array3);
		Value value8 = new Value(array4);
		assertNotSame(value7, value8);
		assertEquals(value7, value8);
		assertTrue(value7.equals(value8));
		array3[2] = true;
		array4[2] = false;
		assertNotSame(value7, value8);
		assertFalse(value7.equals(value8));
		array3[2] = true;
		array4[2] = true;
		assertNotSame(value7, value8);
		assertEquals(value7, value8);
		assertTrue(value7.equals(value8));

		value1.setIntegerArray(array2);
		assertNotSame(value1, value5);
		assertEquals(value1, value5);
		assertTrue(value1.equals(value5));

		value1.setBooleanArray(array3);
		assertNotSame(value1, value7);
		assertEquals(value1, value7);
		assertTrue(value1.equals(value7));

		array1[1] = new BigInteger("42");
		array3[0] = false;
		value5.setIntegerArray(array1);
		value7.setBooleanArray(array3);
		assertFalse(value5.equals(value6));
		assertFalse(value7.equals(value8));
	}
}
