package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextHover;
import org.eclipse.xtext.ui.editor.hover.DefaultCompositeHover;

/**
 * A composite hover that adds the {@link WorthwhileMarkerHover} to the list of hovers.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileCompositeHover extends DefaultCompositeHover {

	@Override
	protected final List<ITextHover> createHovers() {
		List<ITextHover> hovers = new ArrayList<ITextHover>();
		hovers.add(new WorthwhileMarkerHover());
		hovers.addAll(super.createHovers());
		return hovers;
	}

}
