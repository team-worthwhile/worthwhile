package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;

/**
 * @author matthias and stefan
 */
public class InterpreterASTNodeVisitorTest {
	/**
	 * Tests whether a {@link Value} is of boolean type and equals a given boolean value.
	 * 
	 * Also asserts that <code>actual</code> is not <code>null</code>.
	 * 
	 * @param expected
	 *                the expected boolean value for <code>actual</code> to equal
	 * @param actual
	 *                the Value to be checked to be of boolean type and equal <code>expected</code>
	 */
	private static void assertBooleanValueEquals(final Boolean expected, final Value actual) {
		Assert.assertNotNull(actual);
		Assert.assertEquals(actual.getValueType(), ValueType.BOOLEAN_TYPE);
		Assert.assertEquals(expected, actual.getBooleanValue());
	}

	/**
	 * Tests whether a {@link Value} is of integer type and equals a given integer value.
	 * 
	 * Also asserts that <code>actual</code> is not <code>null</code>.
	 * 
	 * @param expected
	 *                the expected integer value for <code>actual</code> to equal
	 * @param actual
	 *                the Value to be checked to be of integer type and equal <code>expected</code>
	 */
	private static void assertIntegerValueEquals(final Integer expected, final Value actual) {
		Assert.assertNotNull(actual);
		Assert.assertEquals(actual.getValueType(), ValueType.INTEGER_TYPE);
		Assert.assertEquals(BigInteger.valueOf(expected), actual.getIntegerValue());
	}

	@Test
	public void test() {
		InterpreterASTNodeVisitor v = new InterpreterASTNodeVisitor();
		assertNotNull(v);
	}

	@Test
	public void testInterpreterContextAssignment() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 42\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertIntegerValueEquals(42, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexAddition() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 21 + 21\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertIntegerValueEquals(42, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexMultiplication() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 * 21\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertIntegerValueEquals(42, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexDivision() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 84 / 2\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertIntegerValueEquals(42, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexModulus() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 85 % 43\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertIntegerValueEquals(42, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexAnd() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Boolean a := true && false\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(false, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexOr() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Boolean a := true || false\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(true, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexLess() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 < 45\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(true, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexGreater() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 > 41\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(false, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexLessEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 <= 52\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(true, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexGreaterEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 >= 52\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(false, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 = 42\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(true, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexNotEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 != 52\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(true, interpreter.getSymbol("a"));
	}

	@Test
	public void testInterpreterContexNot() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := !false\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		InterpreterASTNodeVisitorTest.assertBooleanValueEquals(true, interpreter.getSymbol("a"));
	}
}
