package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants;
import edu.kit.iti.formal.pse.worthwhile.expressions.ui.activator.WorthwhileExpressionsActivator;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation;

/**
 * A helper class for parsing an expression string.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileExpressionParser extends WorthwhileDebugElement {

	/**
	 * Creates a new instance of the {@link WorthwhileExpressionParser} class.
	 * 
	 * @param debugTarget
	 *                The debug target.
	 */
	public WorthwhileExpressionParser(final WorthwhileDebugTarget debugTarget) {
		super(debugTarget);
	}

	/**
	 * Parses an expression string and returns the corresponding AST node.
	 * 
	 * @param expressionText
	 *                The expression string.
	 * @return An {@link Expression} object that represents this expression
	 * @throws DebugException
	 *                 if the expression contains syntax errors.
	 */
	public final Expression parseExpressionString(final String expressionText) throws DebugException {
		// Load the expressions language plugin and obtain an injector.
		WorthwhileExpressionsActivator activator = WorthwhileExpressionsActivator.getInstance();
		activator.setContextProvider(this.getDebugTarget());
		Injector guiceInjector = activator
		                .getInjector("edu.kit.iti.formal.pse.worthwhile.expressions.WorthwhileExpressions");

		// Create a new program that contains the expression string.
		XtextResourceSet resourceSet = guiceInjector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/debug.wwexpr"));
		InputStream in = new ByteArrayInputStream(expressionText.getBytes());

		try {
			resource.load(in, resourceSet.getLoadOptions());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		// Check whether there are errors in the expression string
		if (resource.getErrors().isEmpty()) {
			return ((ExpressionEvaluation) resource.getContents().get(0)).getExpression();
		} else {
			// Create a new list of the parse errors.
			ExpressionParseError[] parseExceptions = new ExpressionParseError[resource.getErrors().size()];

			for (int i = 0; i < resource.getErrors().size(); i++) {
				Diagnostic diag = resource.getErrors().get(i);
				parseExceptions[i] = new ExpressionParseError(new ParseException(diag.getMessage(),
				                diag.getColumn()));
			}

			throw new DebugException(new ExpressionEvaluationError(parseExceptions));
		}
	}

	/**
	 * Indicates an error that occured while parsing an expression string.
	 * 
	 * @author Joachim
	 * 
	 */
	private class ExpressionParseError implements IStatus {

		/**
		 * The underlying parse exception.
		 */
		private final ParseException parseException;

		/**
		 * Creates a new instance of the {@link ExpressionParseError} class.
		 * 
		 * @param parseException
		 *                The underlying parse exception.
		 */
		public ExpressionParseError(final ParseException parseException) {
			this.parseException = parseException;
		}

		@Override
		public IStatus[] getChildren() {
			return null;
		}

		@Override
		public int getCode() {
			return 42;
		}

		@Override
		public Throwable getException() {
			return this.parseException;
		}

		@Override
		public String getMessage() {
			return this.parseException.getMessage();
		}

		@Override
		public String getPlugin() {
			return WorthwhileDebugConstants.PLUGIN_ID;
		}

		@Override
		public int getSeverity() {
			return IStatus.ERROR;
		}

		@Override
		public boolean isMultiStatus() {
			return false;
		}

		@Override
		public boolean isOK() {
			return false;
		}

		@Override
		public boolean matches(final int severityMask) {
			return (severityMask | IStatus.ERROR) > 0;
		}

	}

	/**
	 * Indicates an error that occured when trying to evaluate an expression.
	 * 
	 * @author Joachim
	 * 
	 */
	private class ExpressionEvaluationError implements IStatus {

		/**
		 * The underlying exceptions causing the evaluation to fail.
		 */
		private final IStatus[] children;

		/**
		 * Creates a new instance of the {@link ExpressionEvaluationError} class.
		 * 
		 * @param children
		 *                The underlying problems causing the evaluation to fail.
		 */
		public ExpressionEvaluationError(final IStatus[] children) {
			this.children = children;
		}

		@Override
		public IStatus[] getChildren() {
			return this.children;
		}

		@Override
		public int getCode() {
			return 42;
		}

		@Override
		public Throwable getException() {
			return null;
		}

		@Override
		public String getMessage() {
			return "Error evaluating the expression.";
		}

		@Override
		public String getPlugin() {
			return WorthwhileDebugConstants.PLUGIN_ID;
		}

		@Override
		public int getSeverity() {
			return IStatus.ERROR;
		}

		@Override
		public boolean isMultiStatus() {
			return true;
		}

		@Override
		public boolean isOK() {
			return false;
		}

		@Override
		public boolean matches(final int severityMask) {
			return (severityMask | IStatus.ERROR) > 0;
		}

	}

}
