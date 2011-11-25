
package org.xtext.example.mydsl.ui.quickfix;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public class MyDslQuickfixProvider extends DefaultQuickfixProvider {

//	@Fix(MyJavaValidator.INVALID_NAME)
//	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
//			public void apply(IModificationContext context) throws BadLocationException {
//				IXtextDocument xtextDocument = context.getXtextDocument();
//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
//				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
//			}
//		});
//	}
	
	@Fix("NoFunctionReturnType")
	public void addFunctionReturnType(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add return type 'int'", "Add a return type of 'int' to the function.", "upcase.png", new AddFunctionReturnTypeModification(issue, "int"));
		acceptor.accept(issue, "Add return type 'bool'", "Add a return type of 'bool' to the function.", "upcase.png", new AddFunctionReturnTypeModification(issue, "bool"));
		acceptor.accept(issue, "Add return type 'int[]'", "Add a return type of 'int[]' to the function.", "upcase.png", new AddFunctionReturnTypeModification(issue, "int[]"));
		acceptor.accept(issue, "Add return type 'bool[]'", "Add a return type of 'bool[]' to the function.", "upcase.png", new AddFunctionReturnTypeModification(issue, "bool[]"));
	}
	
	private class AddFunctionReturnTypeModification implements IModification {
		
		private final String returnType;
		
		private final Issue issue;
		
		public AddFunctionReturnTypeModification(Issue issue, String returnType) {
			this.issue = issue;
			this.returnType = returnType;
		}

		@Override
		public void apply(IModificationContext context) throws BadLocationException {
			IXtextDocument xtextDocument = context.getXtextDocument();
			xtextDocument.replace(issue.getOffset(), 0, returnType + " ");
		}
		
	}

}
