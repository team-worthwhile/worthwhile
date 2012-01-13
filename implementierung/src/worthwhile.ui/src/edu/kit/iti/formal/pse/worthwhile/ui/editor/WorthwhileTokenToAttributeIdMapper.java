package edu.kit.iti.formal.pse.worthwhile.ui.editor;

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
		if ("RULE_BOOL".equals(tokenName)) {
			// Provide our own ID for Boolean literals
			return WorthwhileHighlightingConfiguration.BOOL_ID;
		} else if ("RULE_NUMBER".equals(tokenName)) {
			// Map our own Integer type to the default Number ID.
			return WorthwhileHighlightingConfiguration.NUMBER_ID;
		}

		return super.calculateId(tokenName, tokenType);
	}

}
