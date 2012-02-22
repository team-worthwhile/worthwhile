package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import java.util.List;

import org.eclipse.jface.text.ITextHover;
import org.eclipse.xtext.ui.editor.hover.DefaultCompositeHover;

public class WorthwhileCompositeHover extends DefaultCompositeHover {

	@Override
        protected final List<ITextHover> createHovers() {
	        List<ITextHover> hovers = super.createHovers();
	        hovers.add(new WorthwhileMarkerHover());
	        return hovers;
        }

}
