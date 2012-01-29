package edu.kit.iti.formal.pse.worthwhile.ui.autoedit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.ui.preferences.WorthwhilePreferenceConstants;

/**
 * Creates a set of auto edit strategies to use in the Worthwhile editor.
 * 
 * @author Joachim
 */
public class WorthwhileAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	/**
	 * The preference store.
	 */
	@Inject
	private IPreferenceStore preferenceStore;

	@Override
	protected final void configure(final IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);

		if (preferenceStore.getBoolean(WorthwhilePreferenceConstants.ENABLE_AUTOEDIT)) {
			acceptor.accept(new ReplaceKeywordAutoEditStrategy("forall", "∀"),
			                IDocument.DEFAULT_CONTENT_TYPE);
			acceptor.accept(new ReplaceKeywordAutoEditStrategy("exists", "∃"),
			                IDocument.DEFAULT_CONTENT_TYPE);
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

}
