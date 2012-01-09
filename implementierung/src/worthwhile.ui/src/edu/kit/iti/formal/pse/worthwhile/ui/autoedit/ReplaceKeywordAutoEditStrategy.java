package edu.kit.iti.formal.pse.worthwhile.ui.autoedit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

/**
 * The "Replace Keyword" auto edit strategy is meant to replace a keyword typed in the editor with another string.
 * 
 * @author Joachim
 */
class ReplaceKeywordAutoEditStrategy implements IAutoEditStrategy {

	/**
	 * The keyword that shall be replaced upon entry.
	 */
	private final String keyword;

	/**
	 * The string with which to replace the keyword.
	 */
	private final String replacement;

	/**
	 * Creates a new instance of the {@link ReplaceKeywordAutoEditStrategy} class.
	 * 
	 * @param keyword
	 *                The keyword that shall be replaced upon entry.
	 * @param replacement
	 *                The string with which to replace the keyword.
	 */
	public ReplaceKeywordAutoEditStrategy(String keyword, String replacement) {
		if (keyword == null || keyword.length() < 1) {
			throw new IllegalArgumentException("Keyword must be longer than one character.");
		}

		this.keyword = keyword;
		this.replacement = replacement;
	}

	@Override
	public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {

		// If the last character of the keyword is typed and the text before
		// the cursor matches the rest of the keyword,
		// replace the keyword with the replacement.

		// Check if the last character of the keyword matches the currently
		// typed character.
		// Do not use "chatAt" because a char cannot equal a string.
		if (command.text.equals(keyword.substring(keyword.length() - 1))) {
			try {
				// Calculate the starting position of the keyword under the
				// assumption that the character just typed was the last
				// character of the keyword.
				int beginOfKeyword = command.offset - (keyword.length() - 1);

				// Check if the text before the cursor matches the rest of
				// the keyword.
				if (command.offset >= keyword.length() - 1
				                && document.get(beginOfKeyword, keyword.length() - 1).equals(
				                                keyword.substring(0, keyword.length() - 1))) {

					// Check if the typed word is at the beginning of the
					// document or there is whitespace before the typed
					// word.
					if (beginOfKeyword <= 0
					                || document.get(beginOfKeyword - 1, 1).matches("[ \t\n]")) {

						// Replace the typed keyword with its replacement.
						document.replace(command.offset - (keyword.length() - 1),
						                (keyword.length() - 1), "");
						command.offset -= (keyword.length() - 1);
						command.shiftsCaret = true;
						command.text = replacement;
					}
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}

}