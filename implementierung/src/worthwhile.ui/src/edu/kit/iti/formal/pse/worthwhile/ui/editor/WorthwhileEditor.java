package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.help.IContextProvider;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * The source code editor used for Worthwhile documents.
 * 
 * @author Joachim
 */
public class WorthwhileEditor extends XtextEditor {

	/**
	 * A helper class to determine the AST object at a given position in the editor.
	 */
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	/**
	 * The class that provides help context IDs for this editor.
	 */
	private WorthwhileEditorContextProvider contextProvider;

	@Override
	public final Object getAdapter(@SuppressWarnings("rawtypes") final Class key) {
		// When asked for a context provider, return our own context provider.
		if (key.equals(IContextProvider.class)) {
			if (this.contextProvider == null) {
				this.contextProvider = new WorthwhileEditorContextProvider(this);
			}
			return contextProvider;
		} else {
			return super.getAdapter(key);
		}
	}

	/**
	 * Gets the AST node the cursor is currently on.
	 * 
	 * @return The node the cursor is currently on.
	 */
	public final ASTNode getCurrentNode() {
		ISelection selection = this.getSelectionProvider().getSelection();
		if (selection instanceof TextSelection) {
			return (ASTNode) this.getContext(((TextSelection) selection).getOffset());
		}

		return null;
	}

	/**
	 * Gets the AST object at the given position in the document.
	 * 
	 * @param offset
	 *                The position in the document at which to look for an AST object.
	 * @return the AST object at the position {@code offset} in the document, if one exists.
	 */
	private EObject getContext(final int offset) {
		return this.getDocument().readOnly(new IUnitOfWork<EObject, XtextResource>() {
			@Override
			public EObject exec(final XtextResource localResource) throws Exception {
				return eObjectAtOffsetHelper.resolveElementAt(localResource, offset);
			}
		});
	}

}
