package org.xtext.example.mydsl.ui.autoedit;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;


public class MyDslAutoEditStrategyProvider extends
		DefaultAutoEditStrategyProvider {
	
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
	    super.configure(acceptor);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy("forall", "∀"), IDocument.DEFAULT_CONTENT_TYPE);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy("exists", "∃"), IDocument.DEFAULT_CONTENT_TYPE);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy("<=", "≤"), IDocument.DEFAULT_CONTENT_TYPE);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy(">=", "≥"), IDocument.DEFAULT_CONTENT_TYPE);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy("and", "∧"), IDocument.DEFAULT_CONTENT_TYPE);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy("or", "∨"), IDocument.DEFAULT_CONTENT_TYPE);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy("not", "¬"), IDocument.DEFAULT_CONTENT_TYPE);
	    acceptor.accept(new ReplaceKeywordAutoEditStrategy("!", "¬"), IDocument.DEFAULT_CONTENT_TYPE);
	} 
	
	private class ReplaceKeywordAutoEditStrategy implements IAutoEditStrategy {

		private final String keyword;
		
		private final String replacement;
		
		public ReplaceKeywordAutoEditStrategy(String keyword, String replacement) {
			if (keyword == null || keyword.length() < 1) {
				throw new IllegalArgumentException("Keyword must be longer than one character.");
			}
			
			this.keyword = keyword;
			this.replacement = replacement;
		}
		
		@Override
		public void customizeDocumentCommand(IDocument document,
				DocumentCommand command) {
			
			// If the last character of the keyword is typed and the text before the cursor matches the rest of the keyword,
			// replace the keyword with the replacement.
			
			// FIXME: Do not replace in a word (e.g. for => f∧)
			
			// Do not use "chatAt" because a char cannot equal a string.
			if (command.text.equals(keyword.substring(keyword.length() - 1))) {
				try {
					if (command.offset >= keyword.length() - 1 && document.get(command.offset - (keyword.length() - 1), keyword.length() - 1).equals(keyword.substring(0, keyword.length() - 1))) {
						document.replace(command.offset - (keyword.length() - 1), (keyword.length() - 1), "");
						command.offset -= (keyword.length() - 1);
						command.shiftsCaret = true;
						command.text = replacement;
					}
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
