package edu.kit.iti.formal.pse.worthwhile.ui.quickfix;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import edu.kit.iti.formal.pse.worthwhile.validation.WorthwhileSyntaxErrorMessageProvider;

/**
 * A provider for quick fixes.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileQuickfixProvider extends DefaultQuickfixProvider {

	/**
	 * Offers to add a newline at the end of the file.
	 * 
	 * @param issue
	 *                Details about the error.
	 * @param acceptor
	 *                The issue resolution acceptor.
	 */
	@Fix(WorthwhileSyntaxErrorMessageProvider.NO_NEWLINE_AT_EOF)
	public final void addNewlineAtEOF(final Issue issue, final IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add newline", "Add a newline character.", "addnewline.png",
		                new IModification() {
			                public void apply(final IModificationContext context)
			                                throws BadLocationException {
				                IXtextDocument document = context.getXtextDocument();
				                String newline = String.format("%n");
				                document.replace(document.getLength(), 0, newline);
			                }
		                });
	}

	/**
	 * Offers to add a return type to a function.
	 * 
	 * @param issue
	 *                Details about the error.
	 * @param acceptor
	 *                The issue resolution acceptor.
	 */
	@Fix(WorthwhileSyntaxErrorMessageProvider.NO_FUNCTION_RETURN_TYPE)
	public final void addFunctionReturnType(final Issue issue, final IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add return type 'Integer'", "Add a return type of 'Integer' to the function.",
		                "add.png", new InsertStringModification(issue.getOffset(), "Integer"));
		acceptor.accept(issue, "Add return type 'Boolean'", "Add a return type of 'Boolean' to the function.",
		                "add.png", new InsertStringModification(issue.getOffset(), "Boolean"));
		acceptor.accept(issue, "Add return type 'Integer[]'",
		                "Add a return type of 'Integer[]' to the function.", "add.png",
		                new InsertStringModification(issue.getOffset(), "Integer[]"));
		acceptor.accept(issue, "Add return type 'Boolean[]'",
		                "Add a return type of 'Boolean[]' to the function.", "add.png",
		                new InsertStringModification(issue.getOffset(), "Boolean[]"));
	}

	/**
	 * Modification that inserts a string at a given position.
	 * 
	 * @author Joachim
	 * 
	 */
	private class InsertStringModification implements IModification {

		/**
		 * The string to insert.
		 */
		private final String stringToInsert;

		/**
		 * The position in the document at which to insert the string.
		 */
		private final int position;

		/**
		 * Creates a new instance of the {@link InsertStringModification} class.
		 * 
		 * @param stringToInsert
		 *                The string to insert.
		 * @param position
		 *                The position in the document at which to insert the string.
		 */
		public InsertStringModification(final int position, final String stringToInsert) {
			this.stringToInsert = stringToInsert;
			this.position = position;
		}

		@Override
		public void apply(final IModificationContext context) throws BadLocationException {
			IXtextDocument xtextDocument = context.getXtextDocument();
			xtextDocument.replace(position, 0, stringToInsert + " ");
		}

	}
}
