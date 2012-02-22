package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;

import com.google.common.collect.Lists;

/**
 * A hover provider that displays hover information on Worthwhile markers.
 * 
 * More or less shamelessly copied from Xtext, because we need to override the private methods {@code splitInfo} and
 * {@code isHandled}.
 * 
 * Changes:
 * <ul>
 * <li>Handling Worthwhile annotations in addition to the Xtext ones</li>
 * <li>Replacing newlines by &lt;br&gt; in text hover, thus enabling line breaks there</li>
 * </ul>
 * 
 * http://git.eclipse.org/c/tmf/org.eclipse.xtext.git/tree/plugins/org.eclipse.xtext.ui/src/org/eclipse/xtext
 * /ui/editor/hover/ProblemAnnotationHover.java?id=v2.0.1}
 * 
 * @author Joachim
 * 
 */
public class WorthwhileMarkerHover extends ProblemAnnotationHover implements IAnnotationHover {

	/**
	 * The maximum width of a message, messages are line-wrapped when exceeding this number of characters per line.
	 */
	private static final int MSG_WIDTH = 100;

	// IAnnotationHover
	@Override
	public final String getHoverInfo(final ISourceViewer sourceViewer, final int lineNumber) {
		Object o = getHoverInfoInternal(sourceViewer, lineNumber, -1);
		if (o != null) {
			return o.toString().replace("<br>", "\n");
		}
		return null;
	}

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

	@Override
	protected final String formatInfo(final Collection<String> messages) {
		final StringBuffer buffer = new StringBuffer();
		if (messages.size() > 1) {
			buffer.append(XtextUIMessages.AbstractHover_MultipleMarkers);
			final Iterator<String> e = messages.iterator();
			while (e.hasNext()) {
				splitInfo("- " + e.next() + "<br>", buffer);
			}
			buffer.deleteCharAt(buffer.length() - 1);
		} else if (messages.size() == 1) {
			splitInfo(messages.iterator().next(), buffer);
		}
		return buffer.toString();
	}

	/**
	 * Splits a message at MAX_MSG_WIDTH chars.
	 * 
	 * @param message
	 *                The message to split
	 * @param buffer
	 *                The buffer to write the message
	 * @return The message, again (I don't know why).
	 */
	private String splitInfo(final String message, final StringBuffer buffer) {
		// Replace newlines by <br>. Don't use <br /> here, Eclipse does not understand that.
		// Split message at <br> so that the splitting point is always seeked from the beginning of a line
		String[] messages = message.replace("\n", "<br>").split("<br>");
		List<String> splitMessages = new ArrayList<String>();

		for (String msg : messages) {
			String prefix = "";
			String splitMessage = "";
			int pos;
			do {
				pos = msg.indexOf(" ", MSG_WIDTH);
				if (pos > -1) {
					splitMessage += prefix + msg.substring(0, pos) + "<br>";
					msg = msg.substring(pos);
					prefix = "  ";
				} else {
					splitMessage += prefix + msg;
				}
			} while (pos > -1);

			splitMessages.add(splitMessage);
		}

		// Join previously split strings and return them
		buffer.append(join(splitMessages, "<br>"));
		return buffer.toString();
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

	/**
	 * Joins a collection of strings to a string.
	 * 
	 * from http://stackoverflow.com/questions/187676/java-equivalents-of-c-sharp-string-format-and-string-join
	 * 
	 * @param <T>
	 *                The type of the collection.
	 * @param s
	 *                The collection of strings
	 * @param delimiter
	 *                The delimiter
	 * @return The joined string.
	 */
	private static <T> String join(final Collection<T> s, final String delimiter) {
		StringBuilder builder = new StringBuilder();
		Iterator<T> iter = s.iterator();
		while (iter.hasNext()) {
			builder.append(iter.next());
			if (!iter.hasNext()) {
				break;
			}
			builder.append(delimiter);
		}
		return builder.toString();
	}

}
