package edu.kit.iti.formal.pse.worthwhile.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class WorthwhileLabelProvider extends DefaultEObjectLabelProvider {

	/**
	 * Creates a new instance of the {@link WorthwhileLabelProvider} class.
	 * 
	 * @param delegate
	 *                This is not even documented in the Xtext documentation, so who knows what this does?
	 */
	@Inject
	public WorthwhileLabelProvider(final AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	/**
	 * Returns the lael for an annotation.
	 * 
	 * @param node
	 *                The annotation to get the label for
	 * @return The label for the annotation.
	 */
	final String text(final Annotation node) {
		return NodeHelper.getText(node);
	}
}
