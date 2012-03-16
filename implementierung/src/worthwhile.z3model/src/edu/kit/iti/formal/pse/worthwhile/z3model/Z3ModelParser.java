package edu.kit.iti.formal.pse.worthwhile.z3model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * A helper class for parsing a Z3 model string
 * 
 * @author Joachim
 * 
 */
public class Z3ModelParser {

	/**
	 * Parses a model string and returns the corresponding AST node.
	 * 
	 * @param modelText
	 *                The model string.
	 * @return An {@link Expression} object that represents this expression
	 * @throws DebugException
	 *                 if the expression contains syntax errors.
	 */
	public static final Program parseExpressionString(final String modelText) throws ParseException {
		// Load the expressions language plugin and obtain an injector.
		Injector guiceInjector = new Z3ModelStandaloneSetup().createInjectorAndDoEMFRegistration();

		// Create a new program that contains the model string.
		XtextResourceSet resourceSet = guiceInjector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/model.z3model"));
		InputStream in = new ByteArrayInputStream(modelText.getBytes());

		try {
			resource.load(in, resourceSet.getLoadOptions());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		// Validate the model syntactically
		IResourceValidator validator = guiceInjector.getInstance(IResourceValidator.class);
		List<Issue> errors = validator.validate(resource, CheckMode.ALL, null);
		int errorCount = 0;

		for (Issue issue : errors) {
			if (issue.getSeverity().equals(Severity.ERROR)) {
				errorCount++;
			}
		}

		// Check whether there are errors in the expression string
		if (errorCount == 0) {
			return (Program) resource.getContents().get(0);
		} else {
			// Create a new list of the parse errors.
			StringBuilder errorStringBuilder = new StringBuilder("Error parsing the model");

			for (Issue issue : errors) {
				if (issue.getSeverity().equals(Severity.ERROR)) {
					errorStringBuilder.append("\n" + issue.getMessage() + " at " + issue.getOffset());
				}
			}

			throw new ParseException(errorStringBuilder.toString(), 0);
		}
	}

}
