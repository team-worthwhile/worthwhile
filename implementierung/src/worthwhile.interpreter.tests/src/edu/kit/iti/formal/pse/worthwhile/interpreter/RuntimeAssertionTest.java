package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Z3Prover;

/**
 * Tests the {@link Interpreter}'s ability to evaluate {@link Assertion}s at runtime.
 * 
 * @author fabian
 */
@RunWith(Parameterized.class)
public final class RuntimeAssertionTest {
	/**
	 * Magic timeout number for the {@link Z3Prover} used along with {@link RuntimeAssertionTest#CHECKER}.
	 */
	private static final int TIMEOUT = 5000;

	/**
	 * The {@link SpecificationChecker} and {@link Z3Prover} used along with
	 * {@link RuntimeAssertionTest#testInterpreter}.
	 */
	private static final SpecificationChecker CHECKER = new SpecificationChecker(new Z3Prover(
	                RuntimeAssertionTest.TIMEOUT));

	/**
	 * The expected evaluation of the {@link Assertion} in the test program.
	 */
	private Boolean succeedExpected;

	/**
	 * The actual evaluation of the {@link Assertion} in the test program.
	 */
	private Boolean assertionSucceeded = null;

	/**
	 * The {@link Interpreter} executing the test program.
	 */
	private Interpreter testInterpreter;

	/**
	 * Sets up the test environment.
	 * 
	 * @param program
	 *                a {@link String} encoding the test program (to be parsed with {@link TestASTProvider}
	 * @param expected
	 *                the expected truth for the to be evaluated {@link Assertion} from the test program
	 */
	public RuntimeAssertionTest(final String program, final boolean expected) {
		this.succeedExpected = expected;

		final Program testProgram = TestASTProvider.getRootASTNode(program);
		this.testInterpreter = new Interpreter(testProgram, RuntimeAssertionTest.CHECKER);
		this.testInterpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			@Override
			public void annotationSucceeded(final Annotation annotation) {
				if (annotation instanceof Assertion) {
					RuntimeAssertionTest.this.assertionSucceeded = true;
				}
			}

			@Override
			public void annotationFailed(final Annotation annotation) {
				if (annotation instanceof Assertion) {
					RuntimeAssertionTest.this.assertionSucceeded = false;
				}
			}
		});
	}

	/**
	 * @return a list of pairs of test program {@link String}s and the respective expected {@link Assertion}
	 *         evaluation truth values
	 */
	@Parameters
	public static Collection<Object[]> testParameters() {
		return Arrays.asList(
		                new Object[] { "_assume false\n_assert 0 = 1\n", true },
		                new Object[] { "_assume false\n_assume true\n_assert 0 = 1\n", true },
		                new Object[] { "if (true)  {\n_assume false\n}\n_assert 0 = 1\n", true },
		                new Object[] { "if (true)  {\n_assume true \n}\n_assert 0 = 1\n", false },
		                new Object[] { "if (false) {\n_assume false\n}\n_assert 0 = 1\n", false },
		                new Object[] { "if (false) {\n_assume true \n}\n_assert 0 = 1\n", false },
		                new Object[] { "if (true)  {\nBoolean c := false\n_assume c\n}\n_assert 0 = 1\n", true },
		                new Object[] { "Boolean c := false\n_assume c\nc := true\n_assert 0 = 1\n", true },
		                new Object[] {
		                                "Boolean c := true\nwhile (c) {\nc := false\n_assume c\n}\n_assert 0 = 1\n",
		                                true },
		                new Object[] {
		                                "function Boolean fun() {\n_assert 0 = 1\nreturn true\n}\n_assume false\nBoolean v := fun()\n",
		                                false },
		                new Object[] { "_assume false\n_assert ∀ Integer i : 1 = 0\n", true },
		                new Object[] {
		                                "if (true) {\nBoolean c := false\n_assume c\n}\n_assert ∀ Integer i : 1 = 0\n",
		                                true },
		                new Object[] {
		                                "Boolean c := false\n_assume c\nc := true\n_assert ∀ Integer i : 1 = 0\n",
		                                true });
	}

	/**
	 * Executes the {@link RuntimeAssertionTest#testInterpreter} and asserts that
	 * {@link RuntimeAssertionTest#succeedExpected} and {@link RuntimeAssertionTest#assertionSucceeded} equal.
	 */
	@Test
	public void runTest() {
		this.testInterpreter.execute();
		Assert.assertEquals(this.succeedExpected, this.assertionSucceeded);
	}
}
