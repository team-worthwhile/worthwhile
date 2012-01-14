package edu.kit.iti.formal.pse.worthwhile.ui.debugmodel;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class WorthwhileDebugModelPresentation implements IDebugModelPresentation {

	@Override
	public void addListener(final ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public final boolean isLabelProperty(final Object arg0, final String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(final ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public final String getEditorId(final IEditorInput input, final Object element) {
		if (element instanceof IFile || element instanceof ILineBreakpoint) {
			return "edu.kit.iti.formal.pse.worthwhile.Worthwhile";
		}
		return null;
	}

	@Override
	public final IEditorInput getEditorInput(final Object element) {
		if (element instanceof IFile) {
	                return new FileEditorInput((IFile) element);
                }
		if (element instanceof ILineBreakpoint) {
	                return new FileEditorInput((IFile) ((ILineBreakpoint) element).getMarker().getResource());
                }
		return null;
	}

	@Override
	public void computeDetail(final IValue arg0, final IValueDetailListener arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public final Image getImage(final Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final String getText(final Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(final String arg0, final Object arg1) {
		// TODO Auto-generated method stub

	}

}
