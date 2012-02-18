package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;

/**
 * Source viewer configuration for the Worthwhile language.
 * 
 */
public class WorthwhileSourceViewerConfiguration extends XtextSourceViewerConfiguration {

	@Override
        public final ITextHover getTextHover(final ISourceViewer sourceViewer, final String contentType) {
		return new WorthwhileBestMatchHover(sourceViewer);
	}

}
