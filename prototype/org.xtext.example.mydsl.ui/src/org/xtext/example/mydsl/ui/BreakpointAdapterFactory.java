package org.xtext.example.mydsl.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class BreakpointAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof XtextEditor) {
			XtextEditor editorPart = (XtextEditor) adaptableObject;
	          IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
	          if (resource != null) {
	             String extension = resource.getFileExtension();
	             if (extension != null && extension.equals("mydsl")) {
	            	 return new MyDslBreakpointAdapter();
	             }
	          } 
	       }
	       return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class[]{IToggleBreakpointsTarget.class};
	}

}
