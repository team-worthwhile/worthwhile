package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Injector;

import de.itemis.xtext.typesystem.testing.IssueCollection;
import de.itemis.xtext.typesystem.testing.XTextTestCase;
import edu.kit.iti.formal.pse.worthwhile.WorthwhileStandaloneSetup;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

/**
 * Test class for the validator.
 * 
 */
public final class ValidatorTest extends XTextTestCase {

	@Test
	public void testEmptyArrayLiteral() {
		String testProgram = "Integer[]  k := {}\n";
		Assert.assertEquals(0, TestASTProvider.getErrorCount(testProgram));
	}

	@Test
	public void testTypesOfParams() {
		String testProgram = "Integer a := true\n" + "a := false \n";

		initialize(testProgram);
		assertConstraints(allIssues.forType(VariableDeclaration.class).sizeIs(1));

	}

	@Test
	public void testReturnValueReferenceOnlyPostcondition() {
		String testProgram = "function Integer fun()\n" + "_requires _return > 4\n" + "_ensures _return > 4\n"
		                + "{\n" + "return 0\n" + "}\n";

		initialize(testProgram);
		assertConstraints(allIssues.forType(ReturnValueReference.class).sizeIs(1));
	}

	@Test
	public void testFunctionDeclarationValidReturnStatement() {
		String testProgram = "function Integer fun() {\n" + "if (true) { \n" + "return 4\n" + "}\n" + "}\n";
		initialize(testProgram);
		assertConstraints(allIssues.forType(FunctionDeclaration.class).sizeIs(1));
	}

	@Test
	public void testReturnValueRefwithIndex() {
		String testProgram = "function Integer fun()\n" + "_ensures _return[0] = 5\n" + "{\n" + "return 0\n"
		                + "}\n" + "function Boolean[] fun2()\n" + "_ensures _return[0] = false\n" + "{\n"
		                + "return {false}\n" + "}\n";
		Assert.assertEquals(1, TestASTProvider.getErrorCount(testProgram));
	}

	@Test
	public void testFunctionParametersNotModified() {
		String testProgram = "function Integer fun(Integer a, Boolean b) {\n" + "a := 8\n" + "Boolean c := b\n"
		                + "return 0\n" + "}\n";
		initialize(testProgram);
		assertConstraints(allIssues.forType(Assignment.class).sizeIs(1));
	}

	/**
	 * Tests that undeclared functions are not checked for their parameter count.
	 */
	@Test
	public final void testUndeclaredFunctionParameterCountCheck() {
		String testProgram = "Integer i := g(1)\nInteger j := g()\n";
		TestUtils.assertErrorCountEquals(2, TestASTProvider.loadProgram(testProgram));
	}

	@Test
	public void testFunctionCallParameter() {
		String testProgram = "function Integer fun(Integer a, Boolean b) {\n" + "return 4\n" + "}\n"
		                + "Integer k := fun(5,true)\n" + "k := fun(true)\n" + "k := fun(true,true)\n";
		initialize(testProgram);
		assertConstraints(allIssues.sizeIs(2));
	}

	@Test
	public void testQuantifiedExpressionOnlyAnnotation() {
		String testProgram = "_assume forall Boolean a : a = true\n"
		                + "Boolean d := forall Integer k : k > 0\n";
		initialize(testProgram);
		assertConstraints(allIssues.sizeIs(1));
	}

	@Test
	public void testArrayLiteralnotInArrayLiteral() {
		String testProgram = "Integer[] a := {{},5}\n" + "Boolean[] b := {true, {}}\n";
		initialize(testProgram);
		assertConstraints(allIssues.sizeIs(4));
	}

	private void initialize(String parseText) {
		XtextResource resource = (XtextResource) TestASTProvider.loadProgram(parseText);

		Assert.assertTrue(resource.getErrors().isEmpty());

		Injector guiceInjector = new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
		IResourceValidator validator = guiceInjector.getInstance(IResourceValidator.class);
		List<Issue> validationErrors = validator.validate(resource, CheckMode.ALL, null);
		List<String> messages = new ArrayList<String>();
		for (Issue issue : validationErrors) {
			messages.add(issue.getMessage());
		}
		allIssues = new IssueCollection(resource, validationErrors, messages);
	}
}
