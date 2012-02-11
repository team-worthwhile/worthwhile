package edu.kit.iti.formal.pse.worthwhile.common.tests;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the Worthwhile Scoping Provider.
 */
public class ScopingTest {

	@Test
	public void testScoping() {
		String testProgram = "_axiom forall Integer a forall Integer b : a * b = b * a\n"
		                + "function Integer z() {\n" + "Integer bla := x() + y() + z()\n" + "return 0\n"
		                + "}\n" + "function Integer x() {\n" + "Integer c := 42\n"
		                + "_assert forall Integer a : b = 0 ∧ (forall Integer b : a * b = b * a - c)\n"
		                + "Integer b := 9 + a + x() + b + z() + c + y()\n" + "b := 4\n" + "c := z\n"
		                + "b := u\n" + "while (false) {\n" + "Integer h := 9\n" + "h := 7\n" + "}\n"
		                + "h := 8\n" + "return 0\n" + "}\n" + "function Integer y() {\n"
		                + "Integer bla := x() + y() + z()\n" + "return 0\n" + "}\n"
		                + "Integer trololo := x() + y() + z()\n" + "while (false) {\n" + "Integer h := 9\n"
		                + "h := 7\n" + "}\n" + "trololo := 8\n" + "h := 8\n";

		Assert.assertEquals(13, TestASTProvider.getErrorCount(testProgram));
	}

	/**
	 * Checks that a function's parameters are visible in the function itself, but not outside.
	 */
	@Test
	public void testFunctionParameterVisibility() {
		String testProgram = "function Integer test (Integer n) {\n" + "return n\n" + "}\n"
		+ "Integer m := n\n";
		
		Assert.assertEquals(1, TestASTProvider.getErrorCount(testProgram));
	}
}
