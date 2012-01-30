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
 * Tests {@link SpecificationChecker#checkProgram(Program)}.
 * 
 * @author fabian
 * @author Leon Handreke
 * 
 */
@RunWith(Parameterized.class)
public class CheckProgramTest {
	/**
	 * <code>division</code> divides <code>a</code> by <code>b</code>.
	 */
	private static final String TEST_DIVISION = "function Integer division(Integer a, Integer b)\n"
			+ "_ensures _return = a / b\n"
			+ "{\n"
			+ "    Integer c := b\n"
			+ "    Integer d := 0\n"
			+ "    if b >= 0 {\n"
			+ "        while c <= a {\n"
			+ "            c := c + b\n"
			+ "            d := d + 1\n"
			+ "        }\n"
			+ "    }\n"
			+ "    return d\n"
			+ "}\n";

	/**
	 * <code>faculty</code> calculates the faculty of <code>fac</code>.
	 */
	private static final String TEST_FACULTY = "function Integer faculty(Integer fac)\n"
			+ "{\n"
			+ "    if fac < 0 {\n"
			+ "        return -1\n"
			+ "    }\n"
			+ "    if fac = 0 {\n"
			+ "        return 1\n"
			+ "    }\n"
			+ "    Integer res := 1\n"
			+ "    Integer factor := fac\n"
			+ "    while factor > 0 {\n"
			+ "        res := res * fac\n"
			+ "        factor := factor - 1\n"
			+ "    }\n"
			+ "    return res\n"
			+ "}\n";

	/**
	 * <code>even</code> checks whether <code>x</code> is even.
	 */
	private static final String TEST_EVEN = "function Boolean even(Integer x)\n"
			+ "_ensures (exists Integer k1 : 2 * k1 = x && _return = true) || (exists Integer k2 : 2 * k2 - 1 = x && _return = false)\n"
			+ "{\n"
			+ "    Integer temp := x % 2\n"
			+ "    if temp = 0 {\n"
			+ "        return true\n"
			+ "    }\n"
			+ "    if temp = 1 {\n"
			+ "        return false\n"
			+ "    }\n"
			+ "    return false\n"
			+ "}\n";

	/**
	 * <code>max</code> calculates the maximum of <code>a</code> and <code>b</code>.
	 */
	private static final String TEST_MAX = "function Integer max(Integer a, Integer b)\n"
			+ "_ensures _return >= a && _return >= b && (_return = a || _return = b)\n"
			+ "{\n"
			+ "    if a > b {\n"
			+ "        return a\n"
			+ "    }\n"
			+ "    if b >= a {\n"
			+ "        return b\n"
			+ "    }\n"
			+ "    return b\n"
			+ "}\n";

	/**
	 * <code>clone</code> calculates <code>n</code>.
	 */
	private static final String TEST_CLONE = "function Integer clone(Integer n)\n"
			+ "_requires n >= 0\n"
			+ "_ensures _return = n\n"
			+ "{\n"
			+ "    Integer t := 0\n"
			+ "    while t < n\n"
			+ "    _invariant t <= n\n"
			+ "    {\n"
			+ "        t := t + 1\n"
			+ "    }\n"
			+ "    return t\n"
			+ "}\n";

	/**
	 * <code>increment</code> calculates <code>i + 1</code>.
	 */
	private static final String TEST_INCREMENTFUNCTION = "function Integer increment(Integer i)\n"
			+ "_ensures _return = i + 1\n"
			+ "{\n"
			+ "    return i + 1\n"
			+ "}\n"
			+ "Integer var := 0\n"
			+ "while var < 10\n"
			+ "_invariant var <= 10\n"
			+ "{\n"
			+ "    var := increment(var)\n"
			+ "}\n"
			+ "_assert var = 10\n";
	
	/**
	 * 
	 */
	private static final String TEST_DEBUGGERDEMO = "function Integer[] buildArray(Integer length) {\n"
			+ "Integer[] result\n"
			+ "Integer i := 1\n"
			+ "while (i <= length) {\n"
			+ "    result[i - 1] := i\n"
			+ "i := i + 1\n"
			+ "}\n"
			+ "return result\n"
			+ "}\n"
			+ "Integer len := 100\n"
			+ "Integer[] array := buildArray(len)\n"
			+ "Integer sum := 0\n"
			+ "Integer j := 0\n"
			+ "while (j < len)\n"
			+ "_invariant sum = (j * (j + 1)) / 2\n"
			+ "{\n"
			+ "    sum := sum + array[j]\n"
			+ "    j := j + 1\n"
			+ "}\n";

	/**
	 * Test assignment of an Integer to an array at an index.
	 */
	private static final String TEST_ARRAYINDEXASSIGNMENT = "Integer[] a := {1, 2, 3}\n"
			+ "a[0] := 42\n"
			+ "_assert a[0] = 42 && a[1] = 2 && a[2] = 3\n";
	/**
	 * The {@link SpecificationChecker} to be tested.
	 */
	private SpecificationChecker checker;

	/**
	 * The {@link Program} the {@link CheckProgramTest#checker} is tested with.
	 */
	private Program testProgram;

	/**
	 * The expected test result for the {@link CheckProgramTest#testProgram}.
	 */
	private Validity expectedValidity;

	/**
	 * Returns an array of pairs of {@link Program}s and expected {@link Validity} results.
	 * 
	 * @return the parameters to test with
	 */
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
		                { TestASTProvider.getRootASTNode(TEST_DIVISION), Validity.VALID },
		                { TestASTProvider.getRootASTNode(TEST_FACULTY), Validity.VALID },
		                { TestASTProvider.getRootASTNode(TEST_EVEN), Validity.VALID },
		                { TestASTProvider.getRootASTNode(TEST_MAX), Validity.VALID },
		                { TestASTProvider.getRootASTNode(TEST_CLONE), Validity.VALID },
		                { TestASTProvider.getRootASTNode(TEST_ARRAYINDEXASSIGNMENT), Validity.VALID },
		                { TestASTProvider.getRootASTNode(TEST_INCREMENTFUNCTION), Validity.VALID },
		                { TestASTProvider.getRootASTNode(TEST_DEBUGGERDEMO), Validity.VALID } });
	}

	/**
	 * 
	 * @param testProgram
	 *                the {@link Program} to be verified
	 * @param expectedValidity
	 *                the expected verification result for the <code>testProgram</code>
	 */
	public CheckProgramTest(final Program testProgram, final Validity expectedValidity) {
		this.checker = new SpecificationChecker();

		this.testProgram = testProgram;
		this.expectedValidity = expectedValidity;
	}

	/**
	 * Tests whether {@link CheckProgramTest#checker} verifies {@link CheckProgramTest#testProgram} with the result
	 * {@link CheckProgramTest#expectedValidity}.
	 */
	@Test
	public void testTestProgramValidity() {
		Assert.assertEquals(this.expectedValidity, this.checker.checkProgram(this.testProgram));
	}
}