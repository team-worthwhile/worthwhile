package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;

public class InterpreterScopingTest {
	private Interpreter interpreter;
	
	@Before
	public void initializeTest() {
		//this.setInterpreter("");
	}
	
	public void setInterpreter(String programCode) {
		this.interpreter = new Interpreter(TestASTProvider.getRootASTNode(programCode));
	}
	
	public void assertVariableEqualsValue(String variableName, Value value) {
		assertTrue(this.interpreter.getSymbol(variableName).equals(value));
	}
	
	@Test
	public void testWhileScopingWithInteger() {
		this.setInterpreter(
				"Integer a := 42" +
				"\nInteger i := 0" +
				"\nwhile(i < 10) {" +
				"\ni := i + 1" +
				"\nInteger a := 12" +
				"\na := a - 1" +
				"\n}" +
				"\n");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(new BigInteger("42")));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testWhileScopingWithBoolean() {
		this.setInterpreter(
				"Boolean a := true" +
				"\nInteger i := 0" +
				"\nwhile(i < 10) {" +
				"\ni := i + 1" +
				"\nInteger a := 12" +
				"\na := a - 1" +
				"\n}" +
				"\n");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(true));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testWhileScopingWithIntegerArray() {
		this.setInterpreter(
				"Integer[] a := {42, 12, 100, 1}" +
				"\nInteger i := 0" +
				"\nwhile(i < 10) {" +
				"\ni := i + 1" +
				"\na[1] := 4" +
				"\n}" +
				"\n");
		BigInteger[] array = new BigInteger[4];
		array[0] = new BigInteger("42");
		array[1] = new BigInteger("12");
		array[2] = new BigInteger("100");
		array[3] = new BigInteger("1");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(array));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testWhileScopingWithBooleanArray() {
		this.setInterpreter(
				"Boolean[] a := {true, false, false, true}" +
				"\nInteger i := 0" +
				"\nwhile(i < 10) {" +
				"\ni := i + 1" +
				"\na[1] := true" +
				"\n}" +
				"\n");
		Boolean[] array = new Boolean[4];
		array[0] = new Boolean(true);
		array[1] = new Boolean(false);
		array[2] = new Boolean(false);
		array[3] = new Boolean(true);
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(array));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testIfScopingWithInteger() {
		this.setInterpreter(
				"Integer a := 42" +
				"\nInteger i := 0" +
				"\nif(i < 10) {" +
				"\ni := 10" +
				"\nInteger a := 12" +
				"\na := a - 1" +
				"\n}" +
				"\n");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(new BigInteger("42")));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testIfScopingWithBoolean() {
		this.setInterpreter(
				"Boolean a := true" +
				"\nInteger i := 0" +
				"\nwhile(i < 10) {" +
				"\ni := i + 1" +
				"\nInteger a := 12" +
				"\na := a - 1" +
				"\n}" +
				"\n");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(true));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testIfScopingWithIntegerArray() {
		this.setInterpreter(
				"Boolean[] a := {42, 12, 100, 1}" +
				"\nInteger i := 0" +
				"\nif(i < 10) {" +
				"\ni := 10" +
				"\na[1] := true" +
				"\n}" +
				"\n");
		BigInteger[] array = new BigInteger[4];
		array[0] = new BigInteger("42");
		array[1] = new BigInteger("12");
		array[2] = new BigInteger("100");
		array[3] = new BigInteger("1");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(array));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testIfScopingWithBooleanArray() {
		this.setInterpreter(
				"Boolean[] a := {true, false, false, true}" +
				"\nInteger i := 0" +
				"\nif(i < 10) {" +
				"\ni := 10" +
				"\na[1] := true" +
				"\n}" +
				"\n");
		Boolean[] array = new Boolean[4];
		array[0] = new Boolean(true);
		array[1] = new Boolean(false);
		array[2] = new Boolean(false);
		array[3] = new Boolean(true);
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(array));
		this.assertVariableEqualsValue("i", new Value(new BigInteger("10")));
	}
	
	@Test
	public void testFunctionScopingWithInteger() {
		this.setInterpreter(
				"function Integer test() {" +
				"\nInteger a := 23" +
				"\nreturn a" +
				"\n}" +
				"\nInteger a := 42" +
				"\nInteger b := test()" +
				"\n");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(new BigInteger("42")));
	}
	
	@Test
	public void testFunctionScopingWithBoolean() {
		this.setInterpreter(
				"function Boolean test() {" +
				"\nBoolean a := 23" +
				"\nreturn a" +
				"\n}" +
				"\nBoolean a := 42" +
				"\nBoolean b := test()" +
				"\n");
		this.interpreter.execute();
		this.assertVariableEqualsValue("a", new Value(true));
	}
	
	@Test
	public void testFunctionScopingWithIntegerArray() {
		this.setInterpreter(
				"function Integer[] test() {" +
				"\nInteger[] a := {21, 100, 13, 0}" +
				"\nb := {1, 3, 101, 99}" +
				"\nreturn a" +
				"\n}" +
				"\nInteger[] a := {42, 12, 100, 1}" +
				"\nInteger[] b := {1, 2, 3, 4}" +
				"\nInteger[] c := test()" +
				"\n");
		BigInteger[] array1 = new BigInteger[4];
		array1[0] = new BigInteger("42");
		array1[1] = new BigInteger("12");
		array1[2] = new BigInteger("100");
		array1[3] = new BigInteger("1");
		BigInteger[] array2 = new BigInteger[4];
		array2[0] = new BigInteger("1");
		array2[1] = new BigInteger("3");
		array2[2] = new BigInteger("101");
		array2[3] = new BigInteger("99");
		this.assertVariableEqualsValue("a", new Value(array1));
		this.assertVariableEqualsValue("b", new Value(array2));
	}
	
	@Test
	public void testFunctionScopingWithBooleanArray() {
		this.setInterpreter(
				"function Boolean[] test() {" +
				"\nBoolean[] a := {true, true, true, false}" +
				"\nb[0] := true" +
				"\nreturn a" +
				"\n}" +
				"\nBoolean[] a := {true, false, false, true}" +
				"\nBoolean[] b := {false, true, true, true}" +
				"\nBoolean[] c := test()" +
				"\n");
		Boolean[] array1 = new Boolean[4];
		array1[0] = new Boolean(true);
		array1[1] = new Boolean(false);
		array1[2] = new Boolean(false);
		array1[3] = new Boolean(true);
		Boolean[] array2 = new Boolean[4];
		array2[0] = new Boolean(true);
		array2[1] = new Boolean(true);
		array2[2] = new Boolean(true);
		array2[3] = new Boolean(true);
		this.assertVariableEqualsValue("a", new Value(array1));
		this.assertVariableEqualsValue("b", new Value(array2));
	}
}
