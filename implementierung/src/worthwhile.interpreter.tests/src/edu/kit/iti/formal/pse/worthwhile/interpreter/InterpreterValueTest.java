package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;

/**
 * @author matthias and stefan
 */
public class InterpreterValueTest {

	@Test
	public void test() {
		assertNotNull(new IntegerValue(new BigInteger("42")));
		assertNotNull(new BooleanValue(true));
		IntegerValue[] array1 = new IntegerValue[2];
		assertNotNull(new CompositeValue<IntegerValue>(array1));
		BooleanValue[] array2 = new BooleanValue[2];
		assertNotNull(new CompositeValue<BooleanValue>(array2));
	}

	@Test
	public void testGetIntegerValue() {
		IntegerValue value1 = new IntegerValue(new BigInteger("42"));
		assertEquals(value1.getValue(), new BigInteger("42"));
	}

	@Test
	public void testGetBooleanValue() {
		BooleanValue value1 = new BooleanValue(true);
		assertEquals(value1.getValue(), true);
	}

	@Test
	public void testGetIntegerArray() {
		BigInteger[] array1 = new BigInteger[2];
		IntegerValue[] val_array1 = new IntegerValue[] { new IntegerValue(array1[0]),
		                new IntegerValue(array1[1]) };
		CompositeValue<IntegerValue> value1 = new CompositeValue<IntegerValue>(val_array1);
		assertSame(value1.getSubValues(), val_array1);
	}

	@Test
	public void testGetBooleanArray() {
		Boolean[] array1 = new Boolean[2];
		BooleanValue[] val_array1 = new BooleanValue[] { new BooleanValue(array1[0]),
		                new BooleanValue(array1[1]) };
		CompositeValue<BooleanValue> value1 = new CompositeValue<BooleanValue>(val_array1);
		assertSame(value1.getSubValues(), val_array1);
	}

	@Test
	public void testEquals() {
		IntegerValue value1 = new IntegerValue(new BigInteger("42"));
		IntegerValue value2 = new IntegerValue(new BigInteger("42"));
		assertNotSame(value1, value2);
		assertEquals(value1, value2);
		assertTrue(value1.equals(value2));

		BooleanValue value3 = new BooleanValue(new Boolean(true));
		BooleanValue value4 = new BooleanValue(new Boolean(true));
		assertNotSame(value3, value4);
		assertEquals(value3, value4);
		assertTrue(value3.equals(value4));

		assertNotSame(value1, value3);
		assertFalse(value1.equals(value3));

		BigInteger[] array1 = new BigInteger[4];
		BigInteger[] array2 = new BigInteger[4];
		array1[0] = new BigInteger("1");
		array2[0] = new BigInteger("1");
		array1[1] = new BigInteger("2");
		array2[1] = new BigInteger("2");
		array1[3] = new BigInteger("3");
		array2[3] = new BigInteger("3");

		IntegerValue[] val_array1 = new IntegerValue[] { new IntegerValue(array1[0]),
		                new IntegerValue(array1[1]), new IntegerValue(array1[2]), new IntegerValue(array1[3]) };
		IntegerValue[] val_array2 = new IntegerValue[] { new IntegerValue(array2[0]),
		                new IntegerValue(array2[1]), new IntegerValue(array2[2]), new IntegerValue(array2[3]) };

		CompositeValue<IntegerValue> value5 = new CompositeValue<IntegerValue>(val_array1);
		CompositeValue<IntegerValue> value6 = new CompositeValue<IntegerValue>(val_array2);
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

		BooleanValue[] val_array3 = new BooleanValue[] { new BooleanValue(array3[0]),
		                new BooleanValue(array3[1]), new BooleanValue(array3[2]), new BooleanValue(array3[3]) };
		BooleanValue[] val_array4 = new BooleanValue[] { new BooleanValue(array4[0]),
		                new BooleanValue(array4[1]), new BooleanValue(array4[2]), new BooleanValue(array4[3]) };

		CompositeValue<BooleanValue> value7 = new CompositeValue<BooleanValue>(val_array3);
		CompositeValue<BooleanValue> value8 = new CompositeValue<BooleanValue>(val_array4);
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
	}
}
