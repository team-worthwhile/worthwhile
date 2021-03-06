package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileStandaloneSetup;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

/**
 * A utility class for generating a test AST from a string.
 */
public class TestASTProvider {
	/**
	 * Indicates whether {@link TestASTProvider#getRootASTNode(String, boolean) should fail with an exception when
	 * validation errors occur while parsing.
	 */
	private static boolean failOnValidationError = true;

	/**
	 * Creates a {@link Program} from a Worthwhile {@link String}.
	 * 
	 * Does fail when validation errors occur while parsing the <code>parseText</code>.
	 * 
	 * @param parseText
	 *                a <code>String</code> that encodes a <code>Program</code>
	 * @return a <code>Program</code> that represents the <code>parseText</code>
	 */
	public static Program getRootASTNode(final String parseText) {
		Resource resource = loadProgram(parseText);

		Program root = null;

		if (resource.getErrors().isEmpty()) {
			root = (Program) resource.getContents().get(0);

			Injector guiceInjector = new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
			IResourceValidator validator = guiceInjector.getInstance(IResourceValidator.class);
			List<Issue> validationErrors = validator.validate(resource, CheckMode.ALL, null);

			if (validationErrors.size() > 0 && TestASTProvider.failOnValidationError) {
				root = null;

				StringBuilder errorStringBuilder = new StringBuilder();

				for (Issue issue : validationErrors) {
					errorStringBuilder.append("\n Line " + issue.getLineNumber() + ": "
					                + issue.getMessage());
				}

				throw new IllegalArgumentException("Program contains validation errors:"
				                + errorStringBuilder.toString());
			}
		} else {
			StringBuilder errorStringBuilder = new StringBuilder();

			for (Diagnostic diag : resource.getErrors()) {
				errorStringBuilder.append("\n Line " + diag.getLine() + ": " + diag.getMessage());
			}

			throw new IllegalArgumentException("Program contains syntax errors:"
			                + errorStringBuilder.toString());
		}
		return root;
	}

	/**
	 * Returns a list of the parse errors (not the validation errors) in the given program text.
	 * 
	 * @param parseText
	 *                The program to parse.
	 * @return A list of the parse errors in the program.
	 */
	public static Collection<Diagnostic> getParseErrors(final String parseText) {
		return loadProgram(parseText).getErrors();
	}

	/**
	 * Returns the number of parser/validator errors in the specified code.
	 * 
	 * @param parseText
	 *                The program code to parse.
	 * @return The number of parser/validator errors in the specified code.
	 */
	public static int getErrorCount(final String parseText) {
		Resource resource = loadProgram(parseText);
		if (resource.getErrors().size() == 0) {
			Injector guiceInjector = new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
			IResourceValidator validator = guiceInjector.getInstance(IResourceValidator.class);
			List<Issue> validationErrors = validator.validate(resource, CheckMode.ALL, null);

			return validationErrors.size();
		} else {
			return resource.getErrors().size();
		}
	}

	/**
	 * Creates an {@link Expression} from a Worthwhile {@link String}.
	 * 
	 * Does not fail when validation errors occur while parsing the <code>formulaString</code>.
	 * 
	 * @param formulaString
	 *                a <code>String</code> that encodes an <code>Expression</code>
	 * @return an <code>Expression</code> that represents the <code>formulaString</code>
	 */
	public static Expression parseFormulaString(final String formulaString) {
		TestASTProvider.failOnValidationError = false;

		ASTNode n = TestASTProvider.getRootASTNode("{\n_assert (" + formulaString + ")\n" + "}\n");

		TestASTProvider.failOnValidationError = true;

		if (n == null) {
			return null;
		}

		List<Statement> statements = ((Block) ((Program) n).getMainBlock().getStatements().get(0))
		                .getStatements();

		return ((Annotation) (statements.get(0))).getExpression();
	}

	/**
	 * Creates an Xtext resource from a program text.
	 * 
	 * @param parseText
	 *                The program code.
	 * @return An Xtext resource that represents the program text.
	 */

	protected static Resource loadProgram(final String parseText) {
		// http://wiki.eclipse.org/Xtext/FAQ#How_do_I_load_my_model_in_a_standalone_Java_application.C2.A0.3F
		Injector guiceInjector = new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = guiceInjector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.ww"));
		InputStream in = new ByteArrayInputStream(parseText.getBytes());
		try {
			resource.load(in, resourceSet.getLoadOptions());
		} catch (IOException e) {
			return null;
		}
		return resource;
	}
}
