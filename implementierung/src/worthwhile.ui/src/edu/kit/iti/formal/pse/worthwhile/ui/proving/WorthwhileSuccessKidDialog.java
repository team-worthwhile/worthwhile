package edu.kit.iti.formal.pse.worthwhile.ui.proving;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.Workbench;

/**
 * A dialog for when you really need to show off your success.
 * 
 * @author Joachim
 * 
 */
public final class WorthwhileSuccessKidDialog extends Dialog {

	/**
	 * The initial width of the dialog.
	 */
	private static final int INITIAL_WIDTH = 300;

	/**
	 * The initial height of the dialog.
	 */
	private static final int INITIAL_HEIGHT = 280;

	/**
	 * The title of the dialog.
	 */
	private final String dialogTitle;

	/**
	 * The message to display.
	 */
	private final String dialogMessage;

	/**
	 * Creates a new instance of the {@code WorthwhileSuccessKidDialog} class.
	 * 
	 * @param parentShell
	 *                The parent shell
	 * @param dialogTitle
	 *                The title of the dialog.
	 * @param dialogMessage
	 *                The message to display.
	 */
	public WorthwhileSuccessKidDialog(final Shell parentShell, final String dialogTitle, final String dialogMessage) {
		super(parentShell);
		this.dialogTitle = dialogTitle;
		this.dialogMessage = dialogMessage;
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		// Load success kid image
		ImageData successKidImageData = new ImageData(this.getClass().getResourceAsStream(
		                "/images/successkid.png"));
		final Image image = new Image(Workbench.getInstance().getActiveWorkbenchWindow().getShell()
		                .getDisplay(), successKidImageData);

		// Place image and label text.
		Label picture = new Label(composite, SWT.NONE);
		picture.setImage(image);
		picture.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, true, 1, 1));

		Label message = new Label(composite, SWT.NONE);
		message.setText(this.dialogMessage);
		message.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, true, 1, 1));

		return composite;
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(this.dialogTitle);
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, 0, "OK", true);
	}
}