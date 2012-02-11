package edu.kit.iti.formal.pse.worthwhile.common.tests;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the Worthwhile Scoping Provider.
 */
public class ScopingTest {

	/**
	 * Test program for scoping test.
	 */
	// @formatter:off
	private static final String TEST_PROGRAM_SCOPING =
			"_axiom forall Integer a forall Integer b : a * b = b * a\n"
	                + "function Integer z() {\n"
				+ "Integer bla := x() + y() + z()\n"
				+ "return 0\n"
	                + "}\n"
					
	                + "function Integer x() {\n"
	                	+ "Integer c := 42\n"
	                	+ "_assert forall Integer a : b = 0 ∧ (forall Integer b : a * b = b * a - c)\n"
	                	+ "Integer b := 9 + a + x() + b + z() + c + y()\n"
	                	+ "b := 4\n" + "c := z\n"
	                	+ "b := u\n"
	                	+ "while (false) {\n"
	                		+ "Integer h := 9\n"
	                		+ "h := 7\n" + "}\n"
	                		+ "h := 8\n"
	                		+ "return 0\n"
	                	+ "}\n"
	                		
	                + "function Integer y() {\n"
	                	+ "Integer bla := x() + y() + z()\n"
	                	+ "return 0\n"
	                + "}\n"
	                	
	                + "Integer trololo := x() + y() + z()\n" 
	                + "while (false) {\n"
	                	+ "Integer h := 9\n"
	                	+ "h := 7\n"
	                + "}\n"
	                + "trololo := 8\n" + "h := 8\n";
	// @formatter:on

	/**
	 * Number of errors in {@code TEST_PROGRAM_SCOPING}.
	 */
	private static final int TEST_PROGRAM_SCOPING_ERROR_COUNT = 13;

	/**
	 * Tests the scoping provider as a whole.
	 */
	@Test
	public final void testScoping() {
		Assert.assertEquals(TEST_PROGRAM_SCOPING_ERROR_COUNT,
		                TestASTProvider.getErrorCount(TEST_PROGRAM_SCOPING));
	}

	/**
	 * Checks that a function's parameters are visible in the function itself, but not outside.
	 */
	@Test
	public final void testFunctionParameterVisibility() {
		String testProgram = "function Integer test (Integer n) {\n" + "return n\n" + "}\n"
		                + "Integer m := n\n";

		Assert.assertEquals(1, TestASTProvider.getErrorCount(testProgram));
	}
}
