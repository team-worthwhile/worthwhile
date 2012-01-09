package edu.kit.iti.formal.pse.worthwhile.ui.launching;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.internal.ide.dialogs.ResourceComparator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants;

/**
 * A launch configuration tab in which the user can enter the path to the file to be executed.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	/**
	 * The text box for entering the file’s path.
	 */
	private Text pathText;

	/**
	 * A button to browse for the file.
	 */
	private Button pathBrowseButton;

	/**
	 * Modify listener that simply updates the owning launch configuration dialog.
	 */
	private ModifyListener basicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(final ModifyEvent evt) {
			updateLaunchConfigurationDialog();
		}
	};

	@Override
	public final void createControl(final Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		comp.setLayout(new GridLayout());

		Group pathGroup = SWTFactory.createGroup(comp, "Path", 1, 1, GridData.FILL_BOTH);

		Composite pathComp = SWTFactory.createComposite(pathGroup, 2, 1, GridData.HORIZONTAL_ALIGN_END);

		this.pathText = SWTFactory.createSingleText(pathComp, 1);
		this.pathText.getAccessible().addAccessibleListener(new AccessibleAdapter() {
			@Override
			public void getName(final AccessibleEvent e) {
				e.result = "Path to file";
			}
		});
		this.pathText.addModifyListener(this.basicModifyListener);

		this.pathBrowseButton = createPushButton(pathComp, "Browse …", null);
		this.pathBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(),
				                new WorkbenchLabelProvider(), new WorkbenchContentProvider());
				dialog.setTitle("Select file");
				dialog.setMessage("Select the file to execute");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
				if (dialog.open() == IDialogConstants.OK_ID) {
					IResource resource = (IResource) dialog.getFirstResult();
					pathText.setText(resource.getFullPath().toString());
				}
			}
		});
	}

	@Override
	public final String getName() {
		return "Worthwhile";
	}

	@Override
	public final void initializeFrom(final ILaunchConfiguration configuration) {
		try {
			pathText.setText(configuration.getAttribute(WorthwhileLaunchConfigurationConstants.ATTR_PATH,
			                ""));
		} catch (CoreException e) {
			pathText.setText("");
		}
	}

	@Override
	public final void performApply(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(WorthwhileLaunchConfigurationConstants.ATTR_PATH, pathText.getText());
	}

	@Override
	public final void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(WorthwhileLaunchConfigurationConstants.ATTR_PATH, "");
	}

}
