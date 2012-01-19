package edu.kit.iti.formal.pse.worthwhile.debugger.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileStackFrame;

/**
 * A source lookup participant to look up the source of a Worthwhile stack frame.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileSourceLookupParticipant extends AbstractSourceLookupParticipant {

	@Override
	public final String getSourceName(final Object object) throws CoreException {
		if (object instanceof WorthwhileStackFrame) {
			return ((WorthwhileStackFrame) object).getSourceName();
		}

		return null;
	}

}
