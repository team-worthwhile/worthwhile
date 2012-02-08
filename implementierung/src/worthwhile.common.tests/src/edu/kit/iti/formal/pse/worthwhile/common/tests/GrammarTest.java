package edu.kit.iti.formal.pse.worthwhile.common.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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

}
