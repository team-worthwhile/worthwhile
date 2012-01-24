package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;

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
	 * Error code for "No return type specified for function"
	 */
	public static final String NO_FUNCTION_RETURN_TYPE = "NoFunctionReturnType";

	/**
	 * Returns improved syntax error messages. TODO find a better way to get improved messages
	 * 
	 * @param context
	 *                the context from which you want the error message
	 * 
	 * @return the syntax error message
	 */
	@Override
	public final SyntaxErrorMessage getSyntaxErrorMessage(final IParserErrorContext context) {
		System.out.println(context.getDefaultMessage());
		if (context.getDefaultMessage().contains("loop did not match anything at input '<EOF>'")) {

			return new SyntaxErrorMessage("Newline is missing", NO_NEWLINE_AT_EOF);

		} else if (context.getDefaultMessage().contains("loop did not match anything")
		                || context.getDefaultMessage().contains("missing EOF")) {

			return new SyntaxErrorMessage("Delete this token.", "deleteToken");
		}
		return super.getSyntaxErrorMessage(context);

	}

}
