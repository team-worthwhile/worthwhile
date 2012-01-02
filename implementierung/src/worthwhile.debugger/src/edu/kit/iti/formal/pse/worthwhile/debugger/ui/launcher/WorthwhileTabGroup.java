package edu.kit.iti.formal.pse.worthwhile.debugger.ui.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class WorthwhileTabGroup extends AbstractLaunchConfigurationTabGroup {

    @Override
    public final void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {
	setTabs(new ILaunchConfigurationTab[] { new CommonTab() });
    }
}
