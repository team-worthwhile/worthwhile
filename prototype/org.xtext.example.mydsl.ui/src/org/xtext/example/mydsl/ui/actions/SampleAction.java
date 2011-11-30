package org.xtext.example.mydsl.ui.actions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.xtext.example.mydsl.interpreter.ExprModelInterpreter;
import org.xtext.example.mydsl.myDsl.Program;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public SampleAction() {
	}

	@Inject
	private ITypesystem ts;

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		// ExprModelInterpreter int = new ExprModelInterpreter();
		
		IWorkbenchPart part = window.getPartService().getActivePart();
		
		if (part instanceof XtextEditor) {
			XtextEditor editor = (XtextEditor)part;
			//ExprModelInterpreter int = new ExprModelInterpreter();
			editor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {

				@Override
				public IStatus exec(XtextResource state) throws Exception {
					ExprModelInterpreter interpreter = new ExprModelInterpreter();
					interpreter.runProgram((Program)(state.getParseResult().getRootASTElement()), ts);

					return null;
				}
				
				}
			);};
		}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}