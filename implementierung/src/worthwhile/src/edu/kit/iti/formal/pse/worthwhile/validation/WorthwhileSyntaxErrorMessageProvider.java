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
	 * Returns improved syntax error messages. TODO find a better way to get improved messages
	 * 
	 * @param context
	 *                the context from which you want the error message
	 * 
	 * @return the syntax error message
	 */
	@Override
	public final SyntaxErrorMessage getSyntaxErrorMessage(final IParserErrorContext context) {

		if (context.getDefaultMessage().contains("EOF")) {
			return new SyntaxErrorMessage("Newline is missing", "NoFunctionReturnType");
		} else if (context.getDefaultMessage().contains("loop did not match anything")) {
			return new SyntaxErrorMessage("Delete this token.", "NoFunctionReturnType");
		}
		return super.getSyntaxErrorMessage(context);

	}

}
