package edu.kit.iti.formal.pse.worthwhile.debugger.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileStackFrame;

public class WorthwhileSourceLookupParticipant extends AbstractSourceLookupParticipant {

	@Override
	public String getSourceName(Object object) throws CoreException {
		if (object instanceof WorthwhileStackFrame) {
			return ((WorthwhileStackFrame) object).getSourceName();
		}

		return null;
	}

}
