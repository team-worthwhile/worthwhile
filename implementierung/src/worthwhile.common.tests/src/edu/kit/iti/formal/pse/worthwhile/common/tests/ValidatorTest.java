package edu.kit.iti.formal.pse.worthwhile.common.tests;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
	
	@Test
	public void testEmptyArrayLiteral() {
		String testProgram = "Integer[] k := {}\n";

		Assert.assertEquals(0, TestASTProvider.getErrorCount(testProgram));
	}

}
