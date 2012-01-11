package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;

/**
 * @author matthias and stefan
 */
public class InterpreterASTNodeVisitorTest {

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
		Value value = new Value(new BigInteger("42"));
		assertEquals(interpreter.getSymbol("a"), value);
	}

	@Test
	public void testInterpreterContexAddition() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 21 + 21\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		Value value = new Value(new BigInteger("42"));
		assertEquals(interpreter.getSymbol("a"), value);
	}

	@Test
	public void testInterpreterContexMultiplication() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 * 21\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		Value value = new Value(new BigInteger("42"));
		assertEquals(interpreter.getSymbol("a"), value);
	}

	@Test
	public void testInterpreterContexDivision() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 84 / 2\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		Value value = new Value(new BigInteger("42"));
		assertEquals(interpreter.getSymbol("a"), value);
	}

	@Test
	public void testInterpreterContexModulus() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 85 % 43\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		Value value = new Value(new BigInteger("42"));
		assertEquals(interpreter.getSymbol("a"), value);
	}

	@Test
	public void testInterpreterContexAnd() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Boolean a := true && false\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertFalse(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexOr() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Boolean a := true || false\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertTrue(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexLess() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 < 45\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertTrue(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexGreater() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 > 41\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertFalse(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexLessEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 <= 52\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertTrue(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexGreaterEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 >= 52\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertFalse(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 == 42\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertTrue(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexNotEqual() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := 42 != 52\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertTrue(interpreter.getSymbol("a").getBooleanValue());
	}

	@Test
	public void testInterpreterContexNot() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := !false\n"));
		assertNotNull(interpreter);
		interpreter.execute();
		assertTrue(interpreter.getSymbol("a").getBooleanValue());
	}
}
