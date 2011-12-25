package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import org.eclipse.help.HelpSystem;
import org.eclipse.help.IContext;
import org.eclipse.help.IContextProvider;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstSwitch;

/**
 * Provides help context IDs for a {@link WorthwhileEditor} depending on the current selection.
 * 
 * @see {@linkplain http://www.eclipse.org/articles/article.php?file=Article-DynamicCSH/index.html}
 * @author jojo
 * 
 */
public class WorthwhileEditorContextProvider implements IContextProvider {

    /**
     * Creates a new instance of the {@link WorthwhileEditorContextProvider} class.
     * 
     * @param editor
     *            The editor for which to provide help context IDs. May not be null.
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
	// Get the context for the keyword the cursor is currently on. If there is no such keyword, return null which
	// displays the generic help for the editor.
	ASTNode currentNode = editor.getCurrentNode();

	if (currentNode != null) {
	    return HelpSystem.getContext("edu.kit.iti.formal.pse.worthwhile.help.keyword_"
		    + (new ASTNodeKeywordSwitch()).doSwitch(currentNode));
	}

	return null;
    }

    @Override
    public final String getSearchExpression(final Object target) {
	return null;
    }
    
    /**
     * Returns a help keyword for the given AST node.
     */
    private class ASTNodeKeywordSwitch extends AstSwitch<String> {
	
	@Override
	public String caseIntegerType(final IntegerType obj) {
	    return "Integer";
	}
	
	@Override
	public String caseBooleanType(final BooleanType obj) {
	    return "Boolean";
	}
	
    }

}
