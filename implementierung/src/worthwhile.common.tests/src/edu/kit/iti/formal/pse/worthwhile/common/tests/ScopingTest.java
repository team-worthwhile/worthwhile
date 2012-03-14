package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the Worthwhile Scoping Provider.
 */
public class ScopingTest {

	/**
	 * Tests that function calls are resolved correctly and no function can be called until after its definition.
	 * 
	 * @throws IOException
	 *                 if the test program fails to load
	 */
	@Test
	public final void testFunctionCallScoping() throws IOException {
		String testProgram = TestUtils.loadTestProgram(ScopingTest.class, "test-scoping-functioncalls.ww");

		Collection<Diagnostic> errors = TestASTProvider.getParseErrors(testProgram);

		Assert.assertEquals(6, errors.size());

		for (Diagnostic diagnostic : errors) {
			Assert.assertTrue(diagnostic instanceof XtextLinkingDiagnostic);
			Assert.assertTrue(diagnostic.getMessage().contains(
			                "Couldn't resolve reference to FunctionDeclaration"));
		}
	}

	/**
	 * Tests that variables defined in conditionals are only visible inside the conditional.
	 * 
	 * @throws IOException
	 *                 if the test program fails to load
	 */
	@Test
	public final void testConditionalScoping() throws IOException {
		String testProgram = TestUtils.loadTestProgram(ScopingTest.class, "test-scoping-conditional.ww");

		Collection<Diagnostic> errors = TestASTProvider.getParseErrors(testProgram);

		Assert.assertEquals(6, errors.size());

		for (Diagnostic diagnostic : errors) {
			Assert.assertTrue(diagnostic instanceof XtextLinkingDiagnostic);
			Assert.assertTrue(diagnostic.getMessage().contains(
			                "Couldn't resolve reference to VariableDeclaration"));
		}
	}

	/**
	 * Tests that variables defined in loops are only visible inside the loop body.
	 * 
	 * @throws IOException
	 *                 if the test program fails to load
	 */
	@Test
	public final void testLoopScoping() throws IOException {
		String testProgram = TestUtils.loadTestProgram(ScopingTest.class, "test-scoping-loop.ww");

		Collection<Diagnostic> errors = TestASTProvider.getParseErrors(testProgram);

		Assert.assertEquals(3, errors.size());

		for (Diagnostic diagnostic : errors) {
			Assert.assertTrue(diagnostic instanceof XtextLinkingDiagnostic);
			Assert.assertTrue(diagnostic.getMessage().contains(
			                "Couldn't resolve reference to VariableDeclaration"));
		}
	}

	/**
	 * Checks that a function's parameters are visible in the function itself, but not outside.
	 * 
	 * @throws IOException
	 *                 if the test program fails to load
	 */
	@Test
	public final void testFunctionParameterVisibility() throws IOException {
		String testProgram = TestUtils.loadTestProgram(ScopingTest.class, "test-scoping-parameters.ww");

		Collection<Diagnostic> errors = TestASTProvider.getParseErrors(testProgram);

		Assert.assertEquals(1, errors.size());

		for (Diagnostic diagnostic : errors) {
			Assert.assertTrue(diagnostic instanceof XtextLinkingDiagnostic);
			Assert.assertTrue(diagnostic.getMessage().contains(
			                "Couldn't resolve reference to VariableDeclaration"));
		}
	}

	/**
	 * Tests that variables are visible in nested constructs (loops and conditions).
	 * 
	 * @throws IOException
	 *                 if the test program fails to load
	 */
	@Test
	public final void testNestedScoping() throws IOException {
		Assert.assertEquals(0, TestASTProvider.getErrorCount(TestUtils.loadTestProgram(ScopingTest.class,
		                "test-scoping-nested.ww")));
	}
	
	/**
	 * Tests that variables are visible in quantified expressions.
	 * 
	 * @throws IOException
	 *                 if the test program fails to load
	 */
	@Test
	public final void testQuantifiedExpressionScoping() throws IOException {
		Assert.assertEquals(0, TestASTProvider.getErrorCount(TestUtils.loadTestProgram(ScopingTest.class,
		                "test-scoping-quantifiedexpressions.ww")));
	}
}
