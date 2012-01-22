package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;

public class InterpreterScopingTest {
	private Interpreter interpreter;

	public String getLocalVariablesDeclarationCode() {
		return "Boolean localUsedBool := true"
				+ "\nInteger localUsedInt := 42"
				+ "\nBoolean[] localUsedBoolArray := {true, false, false, true}"
				+ "\nInteger[] localUsedIntArray := {42, 100, 99, 1}";
	}

	public String getGlobalVariablesDeclarationCode() {
		return "Boolean globalUsedBool := true"
				+ "\nInteger globalUsedInt := 42"
				+ "\nBoolean[] globalUsedBoolArray := {true, false, false, true}"
				+ "\nInteger[] globalUsedIntArray := {42, 100, 99, 1}";
	}

	public String getLocalVariablesChangeCode() {
		return "localUsedBool := false" + "\nlocalUsedInt := 24"
				+ "\nlocalUsedBoolArray := {true, true, false, false}"
				+ "\nlocalUsedIntArray := {1, 2, 3, 4}";
	}

	public String getGlobalVariablesChangeCode() {
		return "globalUsedBool := false" + "\nglobalUsedInt := 123"
				+ "\nglobalUsedBoolArray := {false, true, false, false}"
				+ "\nglobalUsedIntArray := {4, 12, 33, 400}";
	}

	public void assertLocalVariablesHaveExpectedValues() {
		assertTrue(this.interpreter.getSymbol("localUsedBool").equals(
				new BooleanValue(true)));
		assertTrue(this.interpreter.getSymbol("localUsedInt").equals(
				new IntegerValue(new BigInteger("42"))));

		BooleanValue[] array1 = new BooleanValue[4];
		array1[0] = new BooleanValue(true);
		array1[1] = new BooleanValue(false);
		array1[2] = new BooleanValue(false);
		array1[3] = new BooleanValue(true);
		assertTrue(this.interpreter.getSymbol("localUsedBoolArray").equals(
				new CompositeValue<BooleanValue>(array1)));

		IntegerValue[] array2 = new IntegerValue[4];
		array2[0] = new IntegerValue(new BigInteger("42"));
		array2[1] = new IntegerValue(new BigInteger("100"));
		array2[2] = new IntegerValue(new BigInteger("99"));
		array2[3] = new IntegerValue(new BigInteger("1"));
		assertTrue(this.interpreter.getSymbol("localUsedIntArray").equals(
				new CompositeValue<IntegerValue>(array2)));
	}

	public void assertGlobalVariablesHaveExpectedValues() {
		assertTrue(this.interpreter.getSymbol("globalUsedBool").equals(
				new BooleanValue(false)));
		assertTrue(this.interpreter.getSymbol("globalUsedInt").equals(
				new IntegerValue(new BigInteger("123"))));

		BooleanValue[] array1 = new BooleanValue[4];
		array1[0] = new BooleanValue(false);
		array1[1] = new BooleanValue(true);
		array1[2] = new BooleanValue(false);
		array1[3] = new BooleanValue(false);
		assertTrue(this.interpreter.getSymbol("globalUsedBoolArray").equals(
				new CompositeValue<BooleanValue>(array1)));

		IntegerValue[] array2 = new IntegerValue[4];
		array2[0] = new IntegerValue(new BigInteger("4"));
		array2[1] = new IntegerValue(new BigInteger("12"));
		array2[2] = new IntegerValue(new BigInteger("33"));
		array2[3] = new IntegerValue(new BigInteger("400"));
		assertTrue(this.interpreter.getSymbol("globalUsedIntArray").equals(
				new CompositeValue<IntegerValue>(array2)));
	}

	public String getCodeBeforeNewScope() {
		return this.getLocalVariablesDeclarationCode() + "\n"
				+ this.getGlobalVariablesDeclarationCode();
	}

	public String getCodeInNewScope() {
		return this.getLocalVariablesDeclarationCode() + "\n"
				+ this.getGlobalVariablesChangeCode() + "\n"
				+ this.getLocalVariablesChangeCode();
	}

	public void setInterpreter(String programCode) {
		this.interpreter = new Interpreter(
				TestASTProvider.getRootASTNode(programCode));
	}

	@Test
	public void testWhileScopingWithInteger() {
		this.setInterpreter(this.getCodeBeforeNewScope() + "\n"
				+ "Integer i := 0" + "\nwhile(i < 10) {" + "\ni := i + 1"
				+ "\n" + this.getCodeInNewScope() + "\n}" + "\n");
		this.interpreter.execute();
		this.assertGlobalVariablesHaveExpectedValues();
		this.assertLocalVariablesHaveExpectedValues();
	}

	@Test
	public void testIfScopingWithInteger() {
		this.setInterpreter(this.getCodeBeforeNewScope() + "\nInteger i := 0"
				+ "\nif(i < 1) {" + "\n" + this.getCodeInNewScope() + "\n}"
				+ "\n");
		this.interpreter.execute();
		this.assertGlobalVariablesHaveExpectedValues();
		this.assertLocalVariablesHaveExpectedValues();
	}

	@Test
	public void testFunctionScopingWithInteger() {
		this.setInterpreter("function Integer test() {" + "\n"
				+ this.getCodeInNewScope() + "\nInteger a := 3" + "\nreturn a"
				+ "\n}" + "\n" + this.getCodeBeforeNewScope()
				+ "\nInteger a := test()" + "\n");
		this.interpreter.execute();
		this.assertGlobalVariablesHaveExpectedValues();
		this.assertLocalVariablesHaveExpectedValues();
	}
}
