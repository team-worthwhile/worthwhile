package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import org.eclipse.help.HelpSystem;
import org.eclipse.help.IContext;
import org.eclipse.help.IContextProvider;

/**
 * Provides help context IDs for a {@link WorthwhileEditor} depending on the
 * current selection.
 * 
 * @see {@linkplain http
 *      ://www.eclipse.org/articles/article.php?file=Article-DynamicCSH
 *      /index.html}
 * @author jojo
 * 
 */
public class WorthwhileEditorContextProvider implements IContextProvider {

    /**
     * Creates a new instance of the {@link WorthwhileEditorContextProvider}
     * class.
     * 
     * @param editor
     *            The editor for which to provide help context IDs. May not be
     *            null.
     */
    public WorthwhileEditorContextProvider(final WorthwhileEditor editor) {
	super();

	if (editor == null) {
	    throw new IllegalArgumentException("Editor may not be null.");
	}

	this.editor = editor;
    }

    /**
     * The editor for which to provide help context IDs.
     */
    private WorthwhileEditor editor;

    @Override
    public final int getContextChangeMask() {
	return IContextProvider.SELECTION;
    }

    @Override
    public final IContext getContext(final Object target) {
	String currentKeyword = editor.getCurrentKeyword(); 
	
	if (currentKeyword != "") {
		return HelpSystem.getContext("keyword." + currentKeyword);
	}
       return HelpSystem.getContext("editor");
    }

    @Override
    public final String getSearchExpression(final Object target) {
	return null;
    }

}
