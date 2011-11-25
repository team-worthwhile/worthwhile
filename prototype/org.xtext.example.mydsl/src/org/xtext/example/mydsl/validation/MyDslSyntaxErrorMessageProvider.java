package org.xtext.example.mydsl.validation;

import org.eclipse.xtext.impl.KeywordImpl;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;

public class MyDslSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		if ("function".equals(getPreviousKeyword(context))) {
			return new SyntaxErrorMessage("You must specify a function return type.", "NoFunctionReturnType");
		} else {
			return super.getSyntaxErrorMessage(context);
		}
	}
	
	private String getPreviousKeyword(IParserErrorContext context) {
		if (context.getCurrentNode().hasPreviousSibling() && (context.getCurrentNode().getPreviousSibling().getGrammarElement() instanceof KeywordImpl)) {
			return ((KeywordImpl) context.getCurrentNode().getPreviousSibling().getGrammarElement()).getValue();
		} else {
			return null;
		}
	}

}
