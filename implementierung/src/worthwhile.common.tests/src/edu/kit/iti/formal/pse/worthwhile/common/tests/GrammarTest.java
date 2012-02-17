package edu.kit.iti.formal.pse.worthwhile.common.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Some tests for the Worthwhile grammar.
 *
 */
public class GrammarTest {

	/**
	 * Tests that the spacing around the minus sign is irrelevant for the grammar.
	 */
	@Test
	public void testMinusSign() {
		String testAST = "function Integer y() {\nreturn 42\n}\n" + "Integer i\n"
		                + "_assert (i-1) = 0\n_assert (i--1) = 0\n_assert (i-i) = 0\n_assert (i--i) = 0\n"
		                + "_assert (i-y()) = 0\n_assert (i--y()) = 0\n"
		                + "_assert (i - 1) = 0\n_assert (i - - 1) = 0\n_assert (i - i) = 0\n_assert (i - - i) = 0\n"
		                + "_assert (i - y()) = 0\n_assert (i - - y()) = 0\n";
		
		assertEquals(0, TestASTProvider.getErrorCount(testAST));
	}
	
	/**
	 * Tests that the return value reference in a function’s postcondition accepts an array index
	 * if the function returns an array.
	 */
	@Test
	public void testReturnValueReferenceIndex() {
		String testAST = "function Integer[] x()\n _ensures _return[0] = 1\n{\nreturn {1}\n}\n";
		
		TestASTProvider.getRootASTNode(testAST);
		assertEquals(0, TestASTProvider.getErrorCount(testAST));
	}
	
	/**
	 * Tests that the spacing in conditional expressions is irrelevant.
	 */
	@Test
	public final void testConditionalExpressionSpacing() {
		String testAST = "if (false) { }\nelse { }\n"
				+ "if (false) \n { \n } \n else \n { \n } \n"
				+ "if (false) { \n } \n else { \n }\n";
		
		TestUtils.assertErrorCountEquals(0,  TestASTProvider.loadProgram(testAST));
	}

}
