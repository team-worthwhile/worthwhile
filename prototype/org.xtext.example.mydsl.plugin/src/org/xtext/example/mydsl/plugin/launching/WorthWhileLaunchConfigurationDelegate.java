package org.xtext.example.mydsl.plugin.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.xtext.example.mydsl.interpreter.ExprModelInterpreter;
import org.xtext.example.mydsl.myDsl.Program;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;

public class WorthWhileLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {
	
	@Inject
	private ITypesystem ts;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		/*// mode is "run" or "debug"
		
		DebugPlugin dp = DebugPlugin.getDefault();
		IDebugTarget debugTarget = launch.getDebugTarget();*/
		
		Display.getDefault().asyncExec(new Runnable() {
		    @Override
		    public void run() {
		        IWorkbenchWindow iw = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		    	IWorkbenchPart part = iw.getPartService().getActivePart();
				
				if (part instanceof XtextEditor) {
					XtextEditor editor = (XtextEditor)part;
					//ExprModelInterpreter int = new ExprModelInterpreter();
					editor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {

						@Override
						public IStatus exec(XtextResource state) throws Exception {
							// TODO Auto-generated method stub
							ExprModelInterpreter interpreter = new ExprModelInterpreter();
							interpreter.runProgram((Program)(state.getParseResult().getRootASTElement()), ts);

							return null;
						}
						
						}
					);};
		    }
		});
	}

}
