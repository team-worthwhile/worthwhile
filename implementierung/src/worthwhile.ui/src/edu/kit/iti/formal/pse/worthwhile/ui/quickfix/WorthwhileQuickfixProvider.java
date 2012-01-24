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
		// FIXME: Where does the image come from?
		acceptor.accept(issue, "Add newline", "Add a newline character.", "addnewline.png",
		                new IModification() {
			                public void apply(final IModificationContext context)
			                                throws BadLocationException {
				                IXtextDocument document = context.getXtextDocument();
				                document.replace(document.getLength(), 0, "\n"); // FIXME Use
				                                                                 // platform-specific NL
				                                                                 // character
			                }
		                });
	}

	@Fix(WorthwhileSyntaxErrorMessageProvider.NO_FUNCTION_RETURN_TYPE)
        public final void addFunctionReturnType(final Issue issue, final IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add return type 'int'", "Add a return type of 'int' to the function.",
		                "upcase.png", new AddFunctionReturnTypeModification(issue, "int"));
		acceptor.accept(issue, "Add return type 'bool'", "Add a return type of 'bool' to the function.",
		                "upcase.png", new AddFunctionReturnTypeModification(issue, "bool"));
		acceptor.accept(issue, "Add return type 'int[]'", "Add a return type of 'int[]' to the function.",
		                "upcase.png", new AddFunctionReturnTypeModification(issue, "int[]"));
		acceptor.accept(issue, "Add return type 'bool[]'", "Add a return type of 'bool[]' to the function.",
		                "upcase.png", new AddFunctionReturnTypeModification(issue, "bool[]"));
	}

	private class AddFunctionReturnTypeModification implements IModification {

		private final String returnType;

		private final Issue issue;

		public AddFunctionReturnTypeModification(final Issue issue, final String returnType) {
			this.issue = issue;
			this.returnType = returnType;
		}

		@Override
		public void apply(final IModificationContext context) throws BadLocationException {
			IXtextDocument xtextDocument = context.getXtextDocument();
			xtextDocument.replace(issue.getOffset(), 0, returnType + " ");
		}

	}
}
