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
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

/**
 * Test class for the validator.
 *
 */
public class ValidatorTest extends XTextTestCase {

	@Test
	public void testEmptyArrayLiteral() {
		String testProgram = "Integer[]  k := {}\n";
		Assert.assertEquals(0, TestASTProvider.getErrorCount(testProgram));
	}

	@Test
	public void testTypesOfParams() {
		String testProgram = "Integer a := true\n" +
				"a := false \n";

		initialize(testProgram);
		assertConstraints(allIssues.forType(VariableDeclaration.class).sizeIs(1));

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
