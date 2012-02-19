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
		List<Issue> errors = validator.validate(resource, CheckMode.ALL, null);
		StringBuilder errorStringBuilder = new StringBuilder("There are errors in the source file:");
		int errorCount = 0;

		for (Issue issue : errors) {
			if (issue.getSeverity().equals(Severity.ERROR)) {
				errorCount++;
				errorStringBuilder
				                .append("\nLine " + issue.getLineNumber() + ": " + issue.getMessage());
			}
		}
		
		if (errorCount != expected) {
			throw new AssertionError(errorStringBuilder.toString());
		}
	}

	/**
	 * Private constructor to prevent instantiation.
	 */
	private TestUtils() {
	}

}
