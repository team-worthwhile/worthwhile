package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;

import com.google.common.collect.Lists;

/**
 * A hover provider that displays hover information on Worthwhile markers.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileMarkerHover extends ProblemAnnotationHover implements IAnnotationHover {

	// These two methods are shamelessly copied from AbstractProblemHover because isHandled() is only protected
	// since Xtext 2.1
	@Override
	public final List<Annotation> getAnnotations(final int lineNumber, final int offset) {
		if (getAnnotationModel() == null) {
			return null;
		}
		final Iterator<?> iterator = getAnnotationModel().getAnnotationIterator();
		List<Annotation> result = Lists.newArrayList();
		while (iterator.hasNext()) {
			final Annotation annotation = (Annotation) iterator.next();
			if (isHandled(annotation)) {
				Position position = getAnnotationModel().getPosition(annotation);
				if (position != null) {
					final int start = position.getOffset();
					final int end = start + position.getLength();

					if (offset > 0 && !(start <= offset && offset <= end)) {
						continue;
					}
					try {
						if (lineNumber != getDocument().getLineOfOffset(start)) {
							continue;
						}
					} catch (final Exception x) {
						continue;
					}
					if (!isLineDiffInfo(annotation)) {
						result.add(annotation);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Partly copied from {@code AbstractProblemHover}.
	 * 
	 * @param annotation
	 *                The annotation
	 * @return Whether we want to deal with this annotation
	 */
	private boolean isHandled(final Annotation annotation) {
		// TODO: move these into WorthwhileUiConstants
		String[] handledAnnotations = { "edu.kit.iti.formal.pse.worthwhile.ui.annotations.failedStatement",
		                "edu.kit.iti.formal.pse.worthwhile.ui.annotations.succeededStatement",
		                XtextEditor.ERROR_ANNOTATION_TYPE, XtextEditor.WARNING_ANNOTATION_TYPE };

		return null != annotation && !annotation.isMarkedDeleted()
		                && (Arrays.asList(handledAnnotations).contains(annotation.getType()));
	}
}
