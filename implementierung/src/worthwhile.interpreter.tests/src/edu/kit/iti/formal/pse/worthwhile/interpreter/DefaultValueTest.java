package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.caller.Z3Prover;

/**
 * Test that the values of data types default to the expected values.
 * 
 * @author Leon Handreke
 */
public class DefaultValueTest {
	/**
	 * Construct a new {@link Interpreter} instance for testing with the given program.
	 * 
	 * @param programString
	 *                the program to create the Interpreter with
	 * @return the new {@link Interpreter} instance
	 */
	private Interpreter setupInterpreter(final String programString) {
		Program program = TestASTProvider.getRootASTNode(programString);
		return new Interpreter(program, new SpecificationChecker(new Z3Prover(9001)));
	}

	/**
	 * Test that the default value for an Integer is the expected value.
	 */
	@Test
	public final void testIntegerDefaultValue() {
		final Interpreter interpreter = this.setupInterpreter("Integer a\n");
		interpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			@Override
			public void statementExecuted(final Statement statement) {
				Assert.assertNotNull(interpreter.getSymbol("a"));
				Assert.assertTrue(interpreter.getSymbol("a") instanceof IntegerValue);
				Assert.assertEquals(new BigInteger("0"),
				                ((IntegerValue) interpreter.getSymbol("a")).getValue());
			}
		});
		interpreter.execute();
	}

	/**
	 * Test that the default value for a Boolean is the expected value.
	 */
	@Test
	public final void testBooleanDefaultValue() {
		final Interpreter interpreter = this.setupInterpreter("Boolean a\n");
		interpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			@Override
			public void statementExecuted(final Statement statement) {
				Assert.assertNotNull(interpreter.getSymbol("a"));
				Assert.assertTrue(interpreter.getSymbol("a") instanceof BooleanValue);
				Assert.assertEquals(false, ((BooleanValue) interpreter.getSymbol("a")).getValue());
			}
		});
		interpreter.execute();
	}
}