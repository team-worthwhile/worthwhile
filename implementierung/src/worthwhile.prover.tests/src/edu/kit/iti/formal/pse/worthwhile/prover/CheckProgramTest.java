package edu.kit.iti.formal.pse.worthwhile.prover;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.text.ParseException;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestUtils;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Tests {@link SpecificationChecker#checkProgram(Program)}.
 * 
 * @author fabian
 * @author Leon Handreke
 * @author Joachim
 * 
 */
@RunWith(Parameterized.class)
public class CheckProgramTest {

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
	 * @throws IOException
	 *                 if a file failed to load.
	 * @throws ParseException
	 *                 if a program did not contain any specification of expected validity
	 */
	@Parameters
	public static Collection<Object[]> testData() throws IOException, ParseException {
		Collection<Object[]> result = new ArrayList<Object[]>();
		Pattern expectedValidityPattern = Pattern.compile("EXPECTED:(VALID|INVALID|UNKNOWN)");
		String[] testPrograms = { "test-division", "test-faculty", "test-even", "test-max", "test-clone",
		                "test-arrayindexassignment", "test-incrementfunction", "test-debuggerdemo",
		                "smtlib-keywords", "test-qexpr-condition", "test-github-issue-93", "test-fibonacci" };

		for (String fileName : testPrograms) {
			// Load test program and look for EXPECTED:???
			String testCode = TestUtils.loadTestProgram(CheckProgramTest.class, fileName + ".ww");
			Matcher matcher = expectedValidityPattern.matcher(testCode);

			if (matcher.find()) {
				Validity validity = Validity.valueOf(matcher.group().substring(9));
				Program program = TestASTProvider.getRootASTNode(testCode);

				result.add(new Object[] { program, validity });
			} else {
				throw new ParseException("Could not determine expected validity from test program "
				                + fileName, 0);
			}
		}

		return result;
	}

	/**
	 * 
	 * @param testProgram
	 *                the {@link Program} to be verified
	 * @param expectedValidity
	 *                the expected verification result for the <code>testProgram</code>
	 * @throws IOException
	 *                 if test program cannot be loaded
	 */
	public CheckProgramTest(final Program testProgram, final Validity expectedValidity) throws IOException {
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