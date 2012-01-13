package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Configures the default highlighting for the Worthwhile language.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileHighlightingConfiguration extends DefaultHighlightingConfiguration implements
                IHighlightingConfiguration {

	/**
	 * The hightlighting ID for Boolean literals.
	 */
	public static final String BOOL_ID = "edu.kit.iti.formal.pse.worthwhile.ui.highlighting.bool";

	@Override
	public final void configure(final IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(BOOL_ID, "Boolean literal", booleanTextStyle());
		super.configure(acceptor);
	}

	/**
	 * Provides a default text style for Boolean values.
	 * 
	 * @return a default text style for Boolean values.
	 */
	public final TextStyle booleanTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 85, 127));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

}
