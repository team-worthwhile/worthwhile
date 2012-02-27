package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Z3Prover;

public class DefaultValueTest {

	Interpreter interpreter;

	static Value value;

	private void assertIntegerValueEqualsDefault() {
		interpreter
				.addExecutionEventHandler(new AbstractExecutionEventListener() {
					@Override
					public void statementExecuted(Statement statement) {
						Assert.assertNotNull(interpreter.getSymbol("a"));
						Assert.assertTrue(interpreter.getSymbol("a") instanceof IntegerValue);
						Assert.assertEquals(new BigInteger("0"),
								((IntegerValue) interpreter.getSymbol("a"))
										.getValue());
					}
				});

	}

	private void assertBooleanValueEqualsDefault() {
		interpreter
				.addExecutionEventHandler(new AbstractExecutionEventListener() {
					@Override
					public void statementExecuted(Statement statement) {
						Assert.assertNotNull(interpreter.getSymbol("a"));
						Assert.assertTrue(interpreter.getSymbol("a") instanceof BooleanValue);
						Assert.assertEquals(false, ((BooleanValue) interpreter
								.getSymbol("a")).getValue());
					}
				});
	}

	private void setup(String type) {
		Program program = TestASTProvider.getRootASTNode(type + " a\n");
		this.interpreter = new Interpreter(program, new SpecificationChecker(new Z3Prover(9001)));
	}

	@Test
	public void testIntegerDefaultValue() {
		setup("Integer");
		this.assertIntegerValueEqualsDefault();
	}

	@Test
	public void testBooleanDefaultValue() {
		setup("Boolean");
		this.assertBooleanValueEqualsDefault();
	}
}