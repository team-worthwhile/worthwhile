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
	
	/**
	 * The red part of the RGB value for Boolean literals.
	 */
	private static final int BOOL_R = 0;
	
	/**
	 * The green part of the RGB value for Boolean literals.
	 */
	private static final int BOOL_G = 85;
	
	/**
	 * The blue part of the RGB value for Boolean literals.
	 */
	private static final int BOOL_B = 127;

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
		textStyle.setColor(new RGB(BOOL_R, BOOL_G, BOOL_B));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

}
