package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Test for {@link DivisionByZeroAssertionInserter} which ensures that Divisions by zero cause the proof to fail.
 * 
 * @author Leon Handreke
 */
public class DivisionByZeroAssertionInserterTest {

	/**
	 * Test if division by a zero literal causes the proof to fail.
	 */
	@Test
	public final void testDivisionByZeroLiteral() {
		Program p = TestASTProvider.getRootASTNode("Integer a := 1/0\n_assert(true)\n");
		SpecificationChecker checker = new SpecificationChecker();
		Validity validity = checker.checkProgram(p);
		Assert.assertEquals(Validity.INVALID, validity);
	}

	/**
	 * Test if division by a variable set to zero causes the proof to fail.
	 */
	@Test
	public final void testDivisionByZeroVariable() {
		Program p = TestASTProvider.getRootASTNode("Integer a := 0\nInteger b := 42 / a\n_assert(true)\n");
		SpecificationChecker checker = new SpecificationChecker();
		Validity validity = checker.checkProgram(p);
		Assert.assertEquals(Validity.INVALID, validity);
	}

	/**
	 * Test if division by a variable that was previously set to zero causes the proof to succeed like it should.
	 */
	@Test
	public final void testDivisionByMultipleZeroVariables() {
		Program p = TestASTProvider
		                .getRootASTNode("Integer a := 2\nInteger b := 42 / a\na := 0\nb := 42 / 1\n_assert(true)\n");
		SpecificationChecker checker = new SpecificationChecker();
		Validity validity = checker.checkProgram(p);
		Assert.assertEquals(Validity.VALID, validity);
	}

	/**
	 * Test if Divisions by zero inside the condition of a Conditional cause the proof to fail.
	 */
	@Test
	public final void testDivisionByZeroInConditional() {
		Program p = TestASTProvider.getRootASTNode("Integer a := 0\nif(10 / a = 2) {\n    a := 0\n"
		                + "    Integer b := 42 / 1\n}\n_assert(true)\n");
		SpecificationChecker checker = new SpecificationChecker();
		Validity validity = checker.checkProgram(p);
		Assert.assertEquals(Validity.INVALID, validity);
	}
}
