package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import java.util.Arrays;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

/**
 * Maps tokens to attribute IDs, thus providing services such as highlighting.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected final String calculateId(final String tokenName, final int tokenType) {
		// Tokens that should be deemed punctuation characters and not be highlighted
		String[] additionalPunctuationTokens = { "¬", "∙", "÷", "⋅", "≤", "≥", "≠", "∧", "⇒", "∨", "⇔" };

		if ("RULE_BOOL".equals(tokenName)) {
			// Provide our own ID for Boolean literals
			return WorthwhileHighlightingConfiguration.BOOL_ID;
		} else if ("RULE_NUMBER".equals(tokenName)) {
			// Map our own Integer type to the default Number ID.
			return WorthwhileHighlightingConfiguration.NUMBER_ID;
		} else if ("RULE_RETURN_VALUE_REFERENCE".equals(tokenName)) {
			// "_return" is a keyword although it is not recognized as such. 
			return WorthwhileHighlightingConfiguration.KEYWORD_ID;
		} else if ("RULE_RETURN_STATEMENT".equals(tokenName)) {
			// "return" is a keyword although it is not recognized as such
			return WorthwhileHighlightingConfiguration.KEYWORD_ID;
		} else if (tokenName.length() >= 3 // filter out the quotes arount the token name
		                && Arrays.asList(additionalPunctuationTokens).contains(
		                                tokenName.substring(1, tokenName.length() - 1))) {
			// Map punctuation characters to the default punctuation ID.
			return WorthwhileHighlightingConfiguration.PUNCTUATION_ID;
		}

		return super.calculateId(tokenName, tokenType);
	}

}
