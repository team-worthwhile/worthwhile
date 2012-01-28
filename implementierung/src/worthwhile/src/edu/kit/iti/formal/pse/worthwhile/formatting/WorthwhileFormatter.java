package edu.kit.iti.formal.pse.worthwhile.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

import edu.kit.iti.formal.pse.worthwhile.services.WorthwhileGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class WorthwhileFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected final void configureFormatting(final FormattingConfig c) {
		WorthwhileGrammarAccess f = (WorthwhileGrammarAccess) getGrammarAccess();
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("{", "}")) {
			c.setIndentation(pair.getFirst(), pair.getSecond());
			c.setLinewrap(1).after(pair.getFirst());
			c.setLinewrap(1).before(pair.getSecond());
			c.setLinewrap(1).after(pair.getSecond());
			c.setNoSpace().before(pair.getFirst());
			c.setNoSpace().between(pair.getFirst(), pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs("(", ")")) {
			c.setNoSpace().before(pair.getFirst());
			c.setNoSpace().between(pair.getFirst(), pair.getSecond());
		}
		for (Keyword comma : f.findKeywords(",")) {
			c.setNoLinewrap().before(comma);
			c.setNoSpace().before(comma);
			c.setLinewrap().after(comma);
		}
		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

		// Forbid line wrap and space in array literals
		c.setNoLinewrap().between(f.getArrayLiteralAccess().getLeftCurlyBracketKeyword_1(),
		                f.getArrayLiteralAccess().getRightCurlyBracketKeyword_3());
		c.setNoSpace().after(f.getArrayLiteralAccess().getLeftCurlyBracketKeyword_1());
		c.setNoSpace().before(f.getArrayLiteralAccess().getRightCurlyBracketKeyword_3());
	}
}
