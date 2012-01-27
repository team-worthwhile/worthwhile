package edu.kit.iti.formal.pse.worthwhile.validation;

import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * This class provides the correct syntax error messages.
 * 
 * @author matthias
 * 
 */
public class WorthwhileSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {

	/**
	 * Error code for "No newline at end of file".
	 */
	public static final String NO_NEWLINE_AT_EOF = "NoNewlineAtEOF";

	/**
	 * Error code for "No return type specified for function".
	 */
	public static final String NO_FUNCTION_RETURN_TYPE = "NoFunctionReturnType";

	/**
	 * Returns a syntax error messages for the context.
	 * 
	 * @param context
	 *                the context from which you want the error message
	 * 
	 * @return the syntax error message
	 */
	@Override
	public final SyntaxErrorMessage getSyntaxErrorMessage(final IParserErrorContext context) {
		if (context.getRecognitionException() instanceof EarlyExitException) {

			if (context.getCurrentNode().getRootNode().getTotalEndLine() == context.getCurrentNode()
			                .getEndLine()) {
				return new SyntaxErrorMessage("Newline is missing", NO_NEWLINE_AT_EOF);
			} else {
				return new SyntaxErrorMessage("Delete this token.", "deleteToken");
			}
		} else if (context.getRecognitionException() instanceof NoViableAltException
		                && context.getCurrentContext() instanceof Program) {
			return new SyntaxErrorMessage("Return type of function is missing", NO_FUNCTION_RETURN_TYPE);

		}

		return super.getSyntaxErrorMessage(context);

	}

}
