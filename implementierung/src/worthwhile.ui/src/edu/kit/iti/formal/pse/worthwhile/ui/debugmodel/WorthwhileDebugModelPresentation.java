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

/**
 * The UI presentation (providing labels, descriptions, editors etc.) for the Worthwhile debug model.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugModelPresentation implements IDebugModelPresentation {

	@Override
	public void addListener(final ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public final boolean isLabelProperty(final Object element, final String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(final ILabelProviderListener listener) {
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
	public void computeDetail(final IValue value, final IValueDetailListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public final Image getImage(final Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final String getText(final Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(final String attribute, final Object value) {
		// TODO Auto-generated method stub

	}

}
