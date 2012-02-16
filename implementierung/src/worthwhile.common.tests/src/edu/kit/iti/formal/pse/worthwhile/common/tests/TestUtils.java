package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileStandaloneSetup;

/**
 * Some utilities for unit testing.
 * 
 * @author Joachim
 * 
 */
public final class TestUtils {

	/**
	 * Loads a test program from a resource.
	 * 
	 * @param resourceClass
	 *                The class from which to get the resource
	 * @param fileName
	 *                The file name
	 * @return The test program as a String
	 * @throws IOException
	 *                 if the file failed to load.
	 */
	public static String loadTestProgram(final Class<?> resourceClass, final String fileName) throws IOException {
		InputStream stream = resourceClass.getResourceAsStream("/" + fileName);

		if (stream == null) {
			throw new IOException("Cannot find file: " + fileName);
		}

		return new Scanner(stream).useDelimiter("\\A").next();
	}

	/**
	 * Asserts that the error count of a resource matches the expected error count, and if not, prints the list of
	 * the errors.
	 * 
	 * @param expected
	 *                Expected error count
	 * @param resource
	 *                Resource that contains the errors
	 */
	public static void assertErrorCountEquals(final int expected, final Resource resource) {
		Injector guiceInjector = new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
		IResourceValidator validator = guiceInjector.getInstance(IResourceValidator.class);
		List<Issue> validationErrors = validator.validate(resource, CheckMode.ALL, null);

		int errorCount = resource.getErrors().size();

		for (Issue issue : validationErrors) {
			if (issue.getSeverity().equals(Severity.ERROR)) {
				errorCount++;
			}
		}

		if (errorCount != expected) {
			StringBuilder errorStringBuilder = new StringBuilder("expected <" + expected + ">, but found <"
			                + resource.getErrors().size() + ">:");

			for (Diagnostic diag : resource.getErrors()) {
				errorStringBuilder.append("\nLine " + diag.getLine() + ": " + diag.getMessage());
			}

			for (Issue issue : validationErrors) {
				if (issue.getSeverity().equals(Severity.ERROR)) {
					errorStringBuilder.append("\nLine " + issue.getLineNumber() + ": "
					                + issue.getMessage());
				}
			}

			throw new AssertionError(errorStringBuilder.toString());
		}
	}

	/**
	 * Private constructor to prevent instantiation.
	 */
	private TestUtils() {
	}

}
