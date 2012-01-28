package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;

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
		Assert.assertTrue(actual instanceof BooleanValue);
		Assert.assertEquals(expected, ((BooleanValue) actual).getValue());
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
		Assert.assertTrue(actual instanceof IntegerValue);
		Assert.assertEquals(BigInteger.valueOf(expected), ((IntegerValue) actual).getValue());
	}

	/**
	 * Tests whether a Worthwhile expression is evaluated to an expected {@link Integer} by the {@link Interpreter}.
	 * 
	 * @param expression
	 *                the expression to be evaluated by the <code>Interpreter</code> and whose evaluation result
	 *                must equal <code>expected</code> in order for the test to pass
	 * @param expected
	 *                the <code>Integer</code> value the evaluated <code>expression</code> must equal
	 */
	private static void assertIntegerExpressionValueEquals(final String expression, final Integer expected) {
		final Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := "
		                + expression + "\n"), new SpecificationChecker());
		assertNotNull(interpreter);
		interpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			@Override
			public void statementExecuted(final Statement statement) {
				InterpreterASTNodeVisitorTest.assertIntegerValueEquals(expected,
				                interpreter.getSymbol("a"));
			}
		});
		interpreter.execute();
	}

	/**
	 * Tests whether a Worthwhile expression is evaluated to an expected {@link Boolean} by the {@link Interpreter}.
	 * 
	 * @param expression
	 *                the expression to be evaluated by the <code>Interpreter</code> and whose evaluation result
	 *                must equal <code>expected</code> in order for the test to pass
	 * @param expected
	 *                the <code>Boolean</code> value the evaluated <code>expression</code> must equal
	 */
	private static void assertBooleanExpressionValueEquals(final String expression, final Boolean expected) {
		final Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := "
		                + expression + "\n"), new SpecificationChecker());
		assertNotNull(interpreter);
		interpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			@Override
			public void statementExecuted(final Statement statement) {
				InterpreterASTNodeVisitorTest.assertBooleanValueEquals(expected,
				                interpreter.getSymbol("a"));
			}
		});
		interpreter.execute();
	}

	@Test
	public void test() {
		InterpreterASTNodeVisitor v = new InterpreterASTNodeVisitor(new SpecificationChecker());
		assertNotNull(v);
	}

	@Test
	public void testInterpreterContextAssignment() {
		InterpreterASTNodeVisitorTest.assertIntegerExpressionValueEquals("42", 42);
	}

	@Test
	public void testInterpreterContexAddition() {
		InterpreterASTNodeVisitorTest.assertIntegerExpressionValueEquals("21 + 21", 42);
	}

	@Test
	public void testInterpreterContexMultiplication() {
		InterpreterASTNodeVisitorTest.assertIntegerExpressionValueEquals("2 * 21", 42);
	}

	@Test
	public void testInterpreterContexDivision() {
		InterpreterASTNodeVisitorTest.assertIntegerExpressionValueEquals("84 / 2", 42);
	}

	@Test
	public void testInterpreterContexModulus() {
		InterpreterASTNodeVisitorTest.assertIntegerExpressionValueEquals("85 % 43", 42);
	}

	@Test
	public void testInterpreterContexAnd() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("true && false", false);
	}

	@Test
	public void testInterpreterContexOr() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("true || false", true);
	}

	@Test
	public void testInterpreterContexLess() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("42 < 45", true);
	}

	@Test
	public void testInterpreterContexGreater() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("42 > 41", true);
	}

	@Test
	public void testInterpreterContexLessEqual() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("42 <= 52", true);
	}

	@Test
	public void testInterpreterContexGreaterEqual() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("42 >= 52", false);
	}

	@Test
	public void testInterpreterContexEqual() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("42 = 42", true);
	}

	@Test
	public void testInterpreterContexNotEqual() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("42 != 52", true);
	}

	@Test
	public void testInterpreterContexNot() {
		InterpreterASTNodeVisitorTest.assertBooleanExpressionValueEquals("!false", true);
	}

	@Test
	public void testVisitReturnStatement() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Integer x(Integer p)\n" +
		                				"_ensures _return = 42\n" + 
		                				"{\n" + 
		                					"return 42\n" + 
		                					"return 24\n" +
		                				"}\n" + 
		                				"{\n" + 
		                				"Integer result := x(5)\n" + 
		                				"_assert result = 42 \n" +
		                				"}\n"), new SpecificationChecker());

		interpreter.execute();
		assertTrue(true);
	}
}
