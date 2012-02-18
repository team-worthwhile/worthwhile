package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.ui.editor.hover.AnnotationWithQuickFixesHover;
import org.eclipse.xtext.ui.editor.hover.DefaultCompositeHover;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;

import com.google.inject.Inject;

/**
 * A text hover which displays information for failed/succeeded statement markers.
 * 
 * Adapted from {@link http://www.eclipse.org/forums/index.php/mv/msg/198314/632711/}
 * 
 * @author Joachim
 * 
 */
public class WorthwhileBestMatchHover extends DefaultCompositeHover {
	
	@Inject
        protected AnnotationWithQuickFixesHover annotationHover;

        @Inject
        protected DispatchingEObjectTextHover htmlHover;


	private List<ITextHoverExtension2> instantiatedTextHovers;

	public WorthwhileBestMatchHover(final ISourceViewer sourceViewer) {
		addTextHovers(sourceViewer);
	}

	private void addTextHovers(final ISourceViewer sourceViewer) {
		// Add in order of precedence. Higher precedence first.
		instantiatedTextHovers = new ArrayList<ITextHoverExtension2>(2);
		// Xtext's problem hover (for syntax errors).
		instantiatedTextHovers.add(new AnnotationWithQuickFixesHover());
		// Our Worthwhile information hover.
		instantiatedTextHovers.add(new WorthwhileTextHover());
		// Xtext's information hover
		instantiatedTextHovers.add(new DispatchingEObjectTextHover());
	}

	@Override
	public final String getHoverInfo2(final ITextViewer textViewer, final IRegion hoverRegion) {
		if (instantiatedTextHovers == null) {
			return null;
		}
		for (Iterator<ITextHoverExtension2> it = instantiatedTextHovers.iterator(); it.hasNext();) {
			ITextHoverExtension2 hover = it.next();
			String s = (String) hover.getHoverInfo2(textViewer, hoverRegion);
			if (s != null && !s.trim().isEmpty()) {
				return s;
			}
		}
		return null;
	}

	@Override
	public final String getHoverInfo(final ITextViewer textViewer, final IRegion hoverRegion) {
		return getHoverInfo2(textViewer, hoverRegion);
	}

	@Override
	public final IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
		Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y) {
			return new Region(selection.x, selection.y);
		}
		return new Region(offset, 0);
	}

}
