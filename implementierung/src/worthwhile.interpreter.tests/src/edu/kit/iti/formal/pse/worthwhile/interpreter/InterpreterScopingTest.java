package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;

public class InterpreterScopingTest {
	private static String getLocalVariablesDeclarationCode() {
		return "Boolean localUsedBool := true" + "\nInteger localUsedInt := 42"
		                + "\nBoolean[] localUsedBoolArray := {true, false, false, true}"
		                + "\nInteger[] localUsedIntArray := {42, 100, 99, 1}";
	}

	private static String getGlobalVariablesDeclarationCode() {
		return "Boolean globalUsedBool := true" + "\nInteger globalUsedInt := 42"
		                + "\nBoolean[] globalUsedBoolArray := {true, false, false, true}"
		                + "\nInteger[] globalUsedIntArray := {42, 100, 99, 1}";
	}

	private static String getLocalVariablesChangeCode() {
		return "localUsedBool := false" + "\nlocalUsedInt := 24"
		                + "\nlocalUsedBoolArray := {true, true, false, false}"
		                + "\nlocalUsedIntArray := {1, 2, 3, 4}";
	}

	private static String getGlobalVariablesChangeCode() {
		return "globalUsedBool := false" + "\nglobalUsedInt := 123"
		                + "\nglobalUsedBoolArray := {false, true, false, false}"
		                + "\nglobalUsedIntArray := {4, 12, 33, 400}";
	}

	static void assertLocalVariablesHaveExpectedValues(final Interpreter interpreter) {
		assertTrue(interpreter.getSymbol("localUsedBool").equals(new BooleanValue(true)));
		assertTrue(interpreter.getSymbol("localUsedInt").equals(new IntegerValue(new BigInteger("42"))));

		BooleanValue[] array1 = new BooleanValue[4];
		array1[0] = new BooleanValue(true);
		array1[1] = new BooleanValue(false);
		array1[2] = new BooleanValue(false);
		array1[3] = new BooleanValue(true);
		assertTrue(interpreter.getSymbol("localUsedBoolArray").equals(new CompositeValue<BooleanValue>(array1)));

		IntegerValue[] array2 = new IntegerValue[4];
		array2[0] = new IntegerValue(new BigInteger("42"));
		array2[1] = new IntegerValue(new BigInteger("100"));
		array2[2] = new IntegerValue(new BigInteger("99"));
		array2[3] = new IntegerValue(new BigInteger("1"));
		assertTrue(interpreter.getSymbol("localUsedIntArray").equals(new CompositeValue<IntegerValue>(array2)));
	}

	static void assertGlobalVariablesHaveExpectedValues(final Interpreter interpreter) {
		assertTrue(interpreter.getSymbol("globalUsedBool").equals(new BooleanValue(false)));
		assertTrue(interpreter.getSymbol("globalUsedInt").equals(new IntegerValue(new BigInteger("123"))));

		BooleanValue[] array1 = new BooleanValue[4];
		array1[0] = new BooleanValue(false);
		array1[1] = new BooleanValue(true);
		array1[2] = new BooleanValue(false);
		array1[3] = new BooleanValue(false);
		assertTrue(interpreter.getSymbol("globalUsedBoolArray")
		                .equals(new CompositeValue<BooleanValue>(array1)));

		IntegerValue[] array2 = new IntegerValue[4];
		array2[0] = new IntegerValue(new BigInteger("4"));
		array2[1] = new IntegerValue(new BigInteger("12"));
		array2[2] = new IntegerValue(new BigInteger("33"));
		array2[3] = new IntegerValue(new BigInteger("400"));
		assertTrue(interpreter.getSymbol("globalUsedIntArray").equals(new CompositeValue<IntegerValue>(array2)));
	}

	private static String getCodeBeforeNewScope() {
		return InterpreterScopingTest.getLocalVariablesDeclarationCode() + "\n"
		                + InterpreterScopingTest.getGlobalVariablesDeclarationCode();
	}

	private static String getCodeInNewScope() {
		return InterpreterScopingTest.getLocalVariablesDeclarationCode() + "\n"
		                + InterpreterScopingTest.getLocalVariablesChangeCode();
	}

	private static String getCodeInNewScopeWithGlobal() {
		return InterpreterScopingTest.getLocalVariablesDeclarationCode() + "\n"
		                + InterpreterScopingTest.getGlobalVariablesChangeCode() + "\n"
		                + InterpreterScopingTest.getLocalVariablesChangeCode();
	}

	private static void runInterpreter(final String programCode, final int localLevel, final int globalLevel) {
		final Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode(programCode));

		interpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			private int level = 0;

			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Block) {
					// the visitor has gone one level deeper
					level++;
				}
			}

			@Override
			public void statementExecuted(Statement statement) {
				if (!(statement instanceof Block)) {
					return;
				}

				// which block level did we just exit from, which symbol map is to be examined
				if (level == globalLevel) {
					InterpreterScopingTest.assertGlobalVariablesHaveExpectedValues(interpreter);
				} else if (level == localLevel) {
					InterpreterScopingTest.assertLocalVariablesHaveExpectedValues(interpreter);
				}

				level--;
			}
		});

		interpreter.execute();
	}

	@Test
	public void testWhileScopingWithInteger() {
		InterpreterScopingTest.runInterpreter(InterpreterScopingTest.getCodeBeforeNewScope() + "\n"
		                + "Integer i := 0" + "\nwhile(i < 10) {" + "\ni := i + 1" + "\n"
		                + InterpreterScopingTest.getCodeInNewScopeWithGlobal() + "\n}" + "\n", 1, 2);
	}

	@Test
	public void testIfScopingWithInteger() {
		InterpreterScopingTest.runInterpreter(
		                InterpreterScopingTest.getCodeBeforeNewScope() + "\nInteger i := 0" + "\nif(i < 1) {"
		                                + "\n" + InterpreterScopingTest.getCodeInNewScopeWithGlobal() + "\n}"
		                                + "\n", 1, 2);
	}

	@Test
	public void testFunctionScopingWithInteger() {
		InterpreterScopingTest.runInterpreter(
		                "function Integer test() {" + "\n" + InterpreterScopingTest.getCodeInNewScope()
		                                + "\nInteger a := 3" + "\nreturn a" + "\n}" + "\n"
		                                + InterpreterScopingTest.getCodeBeforeNewScope()
		                                + "\nInteger a := test()" + "\n", 1, 3);
	}
}
