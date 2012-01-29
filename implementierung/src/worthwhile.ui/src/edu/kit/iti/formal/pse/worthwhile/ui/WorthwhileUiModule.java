package edu.kit.iti.formal.pse.worthwhile.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

import edu.kit.iti.formal.pse.worthwhile.ui.autoedit.WorthwhileAutoEditStrategyProvider;
import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileEditor;
import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileFoldingRegionProvider;
import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileHighlightingConfiguration;
import edu.kit.iti.formal.pse.worthwhile.ui.editor.WorthwhileTokenToAttributeIdMapper;
import edu.kit.iti.formal.pse.worthwhile.ui.preferences.WorthwhileRootPreferencePage;

/**
 * Registers components to be used within the IDE.
 */
public class WorthwhileUiModule extends edu.kit.iti.formal.pse.worthwhile.ui.AbstractWorthwhileUiModule {

	/**
	 * Creates a new instance of the {@link WorthwhileUiModule} class.
	 * 
	 * @param plugin
	 *                The UI plugin.
	 */
	public WorthwhileUiModule(final AbstractUIPlugin plugin) {
		super(plugin);
	}

	/**
	 * Provides an editor part.
	 * 
	 * @return An editor part.
	 */
	public final Class<? extends XtextEditor> bindEditor() {
		return WorthwhileEditor.class;
	}

	/**
	 * Provides an auto edit strategy provider.
	 * 
	 * @return An edit strategy provider instance.
	 */
	@Override
	public final Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return WorthwhileAutoEditStrategyProvider.class;
	}

	/**
	 * Provides a highlighting configuration.
	 * 
	 * @return A highlighting configuration.
	 */
	public final Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return WorthwhileHighlightingConfiguration.class;
	}

	/**
	 * Provides a token to attribute ID mapper.
	 * 
	 * @return A token to attribute ID mapper.
	 */
	public final Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return WorthwhileTokenToAttributeIdMapper.class;
	}

	/**
	 * Provides a folding region provider.
	 * 
	 * @return A folding region provider.
	 */
	public final Class<? extends IFoldingRegionProvider> bindIFoldingRegionprovider() {
		return WorthwhileFoldingRegionProvider.class;
	}

	/**
	 * Provides a root preference page.
	 * 
	 * @return A root preference page.
	 */
	public final Class<? extends LanguageRootPreferencePage> bindLanguageRootPreferencePage() {
		return WorthwhileRootPreferencePage.class;
	}

}
