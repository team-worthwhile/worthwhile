package edu.kit.iti.formal.pse.worthwhile.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
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
	 * Returns the label for an annotation.
	 * 
	 * @param node
	 *                The annotation to get the label for
	 * @return The label for the annotation.
	 */
	final String text(final Annotation node) {
		return NodeHelper.getText(node).trim();
	}

	/**
	 * Returns the image for an annotation.
	 * 
	 * @param node
	 *                The annotation to get the image for
	 * @return The image for the annotation.
	 */
	final String image(final Annotation node) {
		return "annotation.gif";
	}

	/**
	 * Returns the image for a function declaration.
	 * 
	 * @param node
	 *                The function declaration to get the image for
	 * @return The image for the function declaration.
	 */
	final String image(final FunctionDeclaration node) {
		return "function.gif";
	}
}
