package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Test for {@link DivisionByZeroAssertionInserter} which ensures that Divisions by zero cause the proof to fail.
 * 
 * @author Leon Handreke
 */
@RunWith(Parameterized.class)
public class DivisionByZeroAssertionInserterTest {
	/**
	 * Test if division by a zero literal causes the proof to fail.
	 */
	private static final String DIVISIONBYZEROLITERAL = "Integer a := 1/0\n_assert(true)\n";

	/**
	 * Test if division by a variable set to zero causes the proof to fail.
	 */
	private static final String DIVISIONBYZEROVARIABLE = "Integer a := 0\nInteger b := 42 / a\n_assert(true)\n";

	/**
	 * Test if division by a variable that was previously set to zero causes the proof to succeed like it should.
	 */
	private static final String DIVISIONBYMULTIPLEZEROVARIABLES = "Integer a := 2\nInteger b := 42 / a\na := 0\nb := 42 / 1\n_assert(true)\n";

	/**
	 * Test if Divisions by zero inside the condition of a Conditional cause the proof to fail.
	 */
	private static final String DIVISIONBYZEROCONDITIONAL = "Integer a := 0\nif(10 / a = 2) {\n    a := 0\n    Integer b := 42 / 1\n}\n_assert(true)\n";

	/**
	 * Test if modulus by a zero literal causes the proof to fail.
	 */
	private static final String MODULUSBYZEROLITERAL = "Integer a := 1 % 0\n_assert(true)\n";

	/**
	 * Test if modulus by a variable set to zero causes the proof to fail.
	 */
	private static final String MODULUSBYZEROVARIABLE = "Integer a := 0\nInteger b := 42 % a\n_assert(true)\n";

	/**
	 * Test if modulus by a variable that was previously set to zero causes the proof to succeed like it should.
	 */
	private static final String MODULUSBYMULTIPLEZEROVARIABLES = "Integer a := 2\nInteger b := 42 % a\na := 0\nb := 42 % 1\n_assert(true)\n";

	/**
	 * Test if modulus by zero inside the condition of a conditional causes the proof to fail.
	 */
	private static final String MODULUSBYZEROCONDITIONAL = "Integer a := 0\nif(10 % a = 2) {\na := 0\nInteger b := 42 % 1\n}\n_assert(true)\n";

	/**
	 * The {@link SpecificationChecker} whose {@link Program} validity checking is tested.
	 */
	private SpecificationChecker checker;

	/**
	 * The {@link Program} for which the {@link DivisionByZeroAssertionInserterTest#checker}'s validity checking is
	 * tested.
	 */
	private Program testProgram;

	/**
	 * The expected value for the {@link DivisionByZeroAssertionInserterTest#testProgram}'s validity.
	 */
	private Validity expectedValidity;

	/**
	 * 
	 * @return a {@link Collection} of test parameters, in which several
	 *         {@link DivisionByZeroAssertionInserterTest#testProgram}s are assigned an
	 *         {@link DivisionByZeroAssertionInserterTest#expectedValidity}
	 */
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
		                { TestASTProvider.getRootASTNode(DIVISIONBYZEROLITERAL), Validity.INVALID },
		                { TestASTProvider.getRootASTNode(DIVISIONBYZEROVARIABLE), Validity.INVALID },
		                { TestASTProvider.getRootASTNode(DIVISIONBYMULTIPLEZEROVARIABLES), Validity.VALID },
		                { TestASTProvider.getRootASTNode(DIVISIONBYZEROCONDITIONAL), Validity.INVALID },
		                { TestASTProvider.getRootASTNode(MODULUSBYZEROLITERAL), Validity.INVALID },
		                { TestASTProvider.getRootASTNode(MODULUSBYZEROVARIABLE), Validity.INVALID },
		                { TestASTProvider.getRootASTNode(MODULUSBYMULTIPLEZEROVARIABLES), Validity.VALID },
		                { TestASTProvider.getRootASTNode(MODULUSBYZEROCONDITIONAL), Validity.INVALID } });
	}

	/**
	 * Initializes the test parameters and the to be used {@link SpecificationChecker}.
	 * 
	 * @param testProgram
	 *                the {@link Program} whose {@link Validity} is to be checked
	 * @param expectedValidity
	 *                the <code>Validity</code> expected for the given <code>testProgram</code>
	 * 
	 * @see DivisionByZeroAssertionInserterTest#testTestProgramValidity()
	 */
	public DivisionByZeroAssertionInserterTest(final Program testProgram, final Validity expectedValidity) {
		this.checker = new SpecificationChecker();

		this.testProgram = testProgram;
		this.expectedValidity = expectedValidity;
	}

	/**
	 * Asserts that the {@link DivisionByZeroAssertionInserterTest#checker} returns the expected
	 * {@link DivisionByZeroAssertionInserterTest#expectedValidity} for the
	 * {@link DivisionByZeroAssertionInserterTest#testProgram}.
	 */
	@Test
	public final void testTestProgramValidity() {
		Assert.assertEquals(this.expectedValidity, this.checker.checkProgram(this.testProgram));
	}
}
