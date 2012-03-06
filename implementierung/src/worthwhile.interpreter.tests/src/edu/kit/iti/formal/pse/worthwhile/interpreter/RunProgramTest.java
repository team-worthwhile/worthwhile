package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestUtils;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;
import edu.kit.iti.formal.pse.worthwhile.prover.caller.Z3Prover;

/**
 * Tests {@link Interpreter#execute()}.
 * 
 * @author fabian
 * @author Leon Handreke
 * @author Joachim
 * 
 */
@RunWith(Parameterized.class)
public final class RunProgramTest {
	/**
	 * The timeout given the prover for evaluating expressions that are too difficult for the
	 * {@link RunProgramTest#interpreter}.
	 */
	private static final int PROVER_TIMEOUT = 50000;

	/**
	 * The {@link Interpreter} to be tested.
	 */
	private Interpreter interpreter;

	/**
	 * The expected test result for the {@link RunProgramTest#interpreter} execution.
	 */
	private Boolean expectedValidity;

	/**
	 * The actual test result for the {@link RunProgramTest#interpreter} execution.
	 */
	private Boolean actualValidity;

	/**
	 * Returns an array of {@link Program}s.
	 * 
	 * @return the parameters to test with
	 * 
	 * @throws IOException
	 *                 if a file failed to load.
	 * @throws ParseException
	 *                 if a program did not contain any specification of expected validity
	 */
	@Parameters
	public static Collection<Object[]> testData() throws IOException, ParseException {
		final Collection<Object[]> result = new ArrayList<Object[]>();
		final Pattern expectedValidityPattern = Pattern.compile("EXPECTED:(VALID|INVALID|UNKNOWN)");
		final String[] testPrograms = { "test-division", "test-faculty", "test-even", "test-max", "test-clone",
		                "test-arrayindexassignment", "test-incrementfunction", "DebuggerDemo",
		                "smtlib-keywords", "test-qexpr-condition", "test-github-issue-93", "test-fibonacci",
		                "bubblesort2", "multiplication", "test-github-issue-108", "array_max",
		                "invalid_array_max", "test-valid-functioncall" };

		for (final String fileName : testPrograms) {
			// Load test program and look for EXPECTED:???
			final String testCode = TestUtils.loadTestProgram(RunProgramTest.class, fileName + ".ww");
			final Matcher matcher = expectedValidityPattern.matcher(testCode);

			if (matcher.find()) {
				Boolean validity;

				switch (Validity.valueOf(matcher.group().substring("EXPECTED:".length()))) {
				case VALID:
					validity = true;
					break;
				case INVALID:
					validity = false;
					break;
				default:
					validity = null;
				}

				final Program program = TestASTProvider.getRootASTNode(testCode);

				result.add(new Object[] { program, validity });
			} else {
				throw new ParseException("Could not determine expected validity from test program "
				                + fileName, 0);
			}
		}

		return result;
	}

	/**
	 * @param testProgram
	 *                the {@link Program} to be executed
	 * @param expectedValidity
	 *                the expected assertion result for the <code>testProgram</code>
	 * @throws IOException
	 *                 if test program cannot be loaded
	 */
	public RunProgramTest(final Program testProgram, final Boolean expectedValidity) throws IOException {
		this.interpreter = new Interpreter(testProgram, new SpecificationChecker(new Z3Prover(
		                RunProgramTest.PROVER_TIMEOUT)));
		this.interpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			@Override
			public void annotationFailed(final Annotation annotation) {
				RunProgramTest.this.actualValidity = false;
			}
		});

		// falsify the validity
		this.actualValidity = true;
		this.expectedValidity = expectedValidity;
	}

	/**
	 * Tests whether {@link RunProgramTest#interpreter} executes without error and without failed annotations.
	 */
	@Test
	public void testTestProgramValidity() {
		this.interpreter.execute();

		Assert.assertEquals(this.expectedValidity, this.actualValidity);
	}
}