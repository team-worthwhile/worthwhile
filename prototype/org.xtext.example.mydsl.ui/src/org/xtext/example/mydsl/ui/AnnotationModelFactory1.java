package org.xtext.example.mydsl.ui;

import org.eclipse.core.filebuffers.IAnnotationModelFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;

public class AnnotationModelFactory1 implements IAnnotationModelFactory {

	@Override
	public IAnnotationModel createAnnotationModel(IPath location) {
		// TODO Auto-generated method stub
		return new AnnotationModel() {
			
		};
	}

}
