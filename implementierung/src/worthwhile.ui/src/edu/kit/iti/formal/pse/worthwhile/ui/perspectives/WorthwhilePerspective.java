package edu.kit.iti.formal.pse.worthwhile.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * The perspective factory for the Worthwhile perspective.
 * 
 * @author Joachim
 * 
 */
public class WorthwhilePerspective implements IPerspectiveFactory {

	/**
	 * The width of the area left of the editor.
	 */
	private static final float LEFT_AREA_WIDTH = 0.25f;

	/**
	 * The height of the editor area.
	 */
	private static final float EDITOR_AREA_HEIGHT = 0.7f;

	@Override
	public final void createInitialLayout(final IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	/**
	 * Defines the actions visible in the perspective.
	 * 
	 * @param layout
	 *                The layout to customize.
	 */
	private void defineActions(final IPageLayout layout) {
		// Add wizard shortcuts to File → New
		layout.addNewWizardShortcut("edu.kit.iti.formal.pse.worthwhile.ui.wizard.NewWorthwhileProjectWizard");
		layout.addNewWizardShortcut("edu.kit.iti.formal.pse.worthwhile.ui.wizard.NewWorthwhileFileWizard");

		// Add shortcuts to "show view" menu
		layout.addShowViewShortcut(IPageLayout.ID_BOOKMARKS);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);

		// Add shortcut to debug perspective (shown in the "open perspective" menu)
		layout.addPerspectiveShortcut("org.eclipse.debug.ui.DebugPerspective");
	}

	/**
	 * Defines the layout of the perspective.
	 * 
	 * @param layout
	 *                The layout to customize.
	 */
	private void defineLayout(final IPageLayout layout) {
		// The editor area is already defined, all other components are placed relative to it.
		String editorArea = layout.getEditorArea();

		// Place the project explorer and the outline to the left of the editor area.
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, LEFT_AREA_WIDTH, editorArea);
		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		left.addView(IPageLayout.ID_OUTLINE);

		// Place task, problems, console views to the bottom of the editor area.
		IFolderLayout bottom = layout
		                .createFolder("bottom", IPageLayout.BOTTOM, EDITOR_AREA_HEIGHT, editorArea);
		bottom.addView(IPageLayout.ID_TASK_LIST);
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		// TODO: Add console
	}

}
