package edu.kit.iti.formal.pse.worthwhile.debugger.launching;

import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant;

/**
 * This class makes the {@link WorthwhileSourceLookupParticipant} known to the debug model.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileSourceLookupDirector extends AbstractSourceLookupDirector {

	@Override
        public final void initializeParticipants() {
		addParticipants(new ISourceLookupParticipant[] { new WorthwhileSourceLookupParticipant() });
	}

}
