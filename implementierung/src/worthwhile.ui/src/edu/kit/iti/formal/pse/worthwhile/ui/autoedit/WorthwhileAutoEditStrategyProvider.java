package edu.kit.iti.formal.pse.worthwhile.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

/**
 * Creates a set of auto edit strategies to use in the Worthwhile editor.
 * 
 * @author Joachim
 */
public class WorthwhileAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected final void configure(final IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("forall", "∀"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("exists", "∃"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("<=", "≤"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy(">=", "≥"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("&&", "∧"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("||", "∨"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("!", "¬"), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("!=", "≠"), IDocument.DEFAULT_CONTENT_TYPE);
		// Replace "¬=" too in case the "!" was replaced by "¬" before.
		acceptor.accept(new ReplaceKeywordAutoEditStrategy("¬=", "≠"), IDocument.DEFAULT_CONTENT_TYPE);
	}

}
