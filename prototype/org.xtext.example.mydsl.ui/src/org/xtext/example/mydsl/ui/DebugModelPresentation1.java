package org.xtext.example.mydsl.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class DebugModelPresentation1 extends LabelProvider implements IDebugModelPresentation {

	/* (non-Javadoc)
		 * @see org.eclipse.debug.ui.IDebugModelPresentation#setAttribute(java.lang.String, java.lang.Object)
		 */
		public void setAttribute(String attribute, Object value) {
		}
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(Object element) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object element) {
			return null;
		}
		/* (non-Javadoc)
		 * @see org.eclipse.debug.ui.IDebugModelPresentation#computeDetail(org.eclipse.debug.core.model.IValue, org.eclipse.debug.ui.IValueDetailListener)
		 */
		public void computeDetail(IValue value, IValueDetailListener listener) {
			String detail = "";
			try {
				detail = value.getValueString();
			} catch (DebugException e) {
			}
			listener.detailComputed(value, detail);
		}
		/* (non-Javadoc)
		 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
		 */
		public IEditorInput getEditorInput(Object element) {
			if (element instanceof IFile) {
				return new FileEditorInput((IFile)element);
			}
			if (element instanceof ILineBreakpoint) {
				return new FileEditorInput((IFile)((ILineBreakpoint)element).getMarker().getResource());
			}
			return null;
		}
		/* (non-Javadoc)
		 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput, java.lang.Object)
		 */
		public String getEditorId(IEditorInput input, Object element) {
			if (element instanceof IFile || element instanceof ILineBreakpoint) {
				return "org.eclipse.ui.DefaultTextEditor";
			}
			return null;
		}

}
