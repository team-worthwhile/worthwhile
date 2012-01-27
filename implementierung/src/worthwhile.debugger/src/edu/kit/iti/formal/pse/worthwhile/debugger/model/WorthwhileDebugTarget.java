package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.ID_WORTHWHILE_DEBUG_MODEL;
import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.MARKER_FAILED_ANNOTATION;
import static edu.kit.iti.formal.pse.worthwhile.debugger.WorthwhileDebugConstants.MARKER_SUCCEEDED_ANNOTATION;
import static edu.kit.iti.formal.pse.worthwhile.debugger.launching.WorthwhileLaunchConfigurationConstants.ATTR_PATH;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.core.model.LineBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileDebugEventListener.DebugMode;
import edu.kit.iti.formal.pse.worthwhile.expressions.scoping.IWorthwhileContextProvider;
import edu.kit.iti.formal.pse.worthwhile.expressions.ui.activator.WorthwhileExpressionsActivator;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * This debug target communicates between the Eclipse platform debugging functions and the Worthwhile interpreter.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileDebugTarget extends WorthwhileDebugElement implements IDebugTarget, IWorthwhileContextProvider {

	/**
	 * The (only) thread a program execution consists of.
	 */
	private WorthwhileThread thread;

	/**
	 * The launch object that belongs to the execution of this program.
	 */
	private ILaunch launch;

	/**
	 * The event listener that manages the debug events from the interpreter.
	 */
	private WorthwhileDebugEventListener eventListener;

	/**
	 * The runner which runs the interpreter.
	 */
	private InterpreterRunner interpreterRunner;

	/**
	 * Creates a new instance of the {@link WorthwhileDebugTarget} class.
	 * 
	 * @param launch
	 *                The launch object from which the program was launched.
	 * @param interpreter
	 *                The interpreter that runs the program.
	 */
	public WorthwhileDebugTarget(final ILaunch launch, final Interpreter interpreter) {
		super(null);
		this.setDebugTarget(this);

		if (interpreter == null) {
			throw new IllegalArgumentException("Interpreter may not be null.");
		}

		this.launch = launch;
		this.thread = new WorthwhileThread(this);

		// Create a new event listener.
		if (launch.getLaunchMode().equals("debug")) {
			this.eventListener = new WorthwhileDebugEventListener(this, true);

			// Register ourselves as a breakpoint listener.
			DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);

			// Get the breakpoints that are already defined and add them to the debug target.
			IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
			                .getBreakpoints(ID_WORTHWHILE_DEBUG_MODEL);
			for (IBreakpoint breakpoint : breakpoints) {
				breakpointAdded(breakpoint);
			}
		} else {
			this.eventListener = new WorthwhileDebugEventListener(this, false);
		}

		// Clear all problem markers
		this.clearMarkers();

		// Register our event listener with the interpreter.
		interpreter.addExecutionEventHandler(this.eventListener);

		// Execute the program.
		this.interpreterRunner = new InterpreterRunner(interpreter);
		this.interpreterRunner.start();
	}

	/**
	 * Returns the launch this debug target belongs to.
	 * 
	 * @return The launch this debug target belongs to.
	 */
	public final ILaunch doGetLaunch() {
		return this.launch;
	}

	@Override
	public final boolean canTerminate() {
		return !this.eventListener.getMode().equals(DebugMode.TERMINATED);
	}

	@Override
	public final boolean isTerminated() {
		return this.eventListener.getMode().equals(DebugMode.TERMINATED);
	}

	@SuppressWarnings("deprecation")
	@Override
	public final void terminate() throws DebugException {
		this.interpreterRunner.getInterpreter().removeExecutionEventHandler(this.eventListener);
		this.eventListener.terminate();
		this.interpreterRunner.stop();
	}

	@Override
	public final boolean canResume() {
		return !this.eventListener.getMode().equals(DebugMode.TERMINATED)
		                && this.eventListener.getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final boolean canSuspend() {
		return !this.eventListener.getMode().equals(DebugMode.TERMINATED)
		                && !this.eventListener.getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final boolean isSuspended() {
		return this.eventListener.getMode().equals(DebugMode.SUSPENDED);
	}

	@Override
	public final void resume() throws DebugException {
		this.eventListener.resume();
	}

	@Override
	public final void suspend() throws DebugException {
		this.eventListener.suspend();
	}

	/**
	 * Returns whether the debug target can step into a statement.
	 * 
	 * @return whether the debug target can step into a statement.
	 */
	public final boolean canStepInto() {
		return this.isSuspended();
	}

	/**
	 * Returns whether the debug target can step over a statement.
	 * 
	 * @return whether the debug target can step over a statement.
	 */
	public final boolean canStepOver() {
		return this.isSuspended();
	}

	/**
	 * Returns whether the debug target can step to the next return statement.
	 * 
	 * @return whether the debug target can step to the next return statement.
	 */
	public final boolean canStepReturn() {
		return this.isSuspended();
	}

	/**
	 * Returns whether we are currently in stepping mode.
	 * 
	 * @return whether we are currently in stepping mode.
	 */
	public final boolean isStepping() {
		return this.eventListener.getMode().equals(DebugMode.STEP)
		                || this.eventListener.getMode().equals(DebugMode.STEP_OVER);
	}

	/**
	 * Steps into the current statement.
	 * 
	 * @throws DebugException
	 *                 when the desired operation cannot be performed.
	 */
	public final void stepInto() throws DebugException {
		this.eventListener.stepInto();
	}

	/**
	 * Steps over the current statement.
	 * 
	 * @throws DebugException
	 *                 when the desired operation cannot be performed.
	 */
	public final void stepOver() throws DebugException {
		this.eventListener.stepOver();
	}

	/**
	 * Steps until the next return statement.
	 * 
	 * @throws DebugException
	 *                 when the desired operation cannot be performed.
	 */
	public void stepReturn() throws DebugException {
		// TODO Auto-generated method stub
	}

	@Override
	public final void breakpointAdded(final IBreakpoint breakpoint) {
		if (breakpoint instanceof LineBreakpoint) {
			try {
				this.eventListener.addBreakpoint(((LineBreakpoint) breakpoint).getLineNumber(),
				                breakpoint);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else if (breakpoint instanceof org.eclipse.debug.core.model.IWatchpoint) {
			// TODO
		}
	}

	@Override
	public final void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		if (supportsBreakpoint(breakpoint)) {
			try {
				if (breakpoint.isEnabled()) {
					breakpointAdded(breakpoint);
				} else {
					breakpointRemoved(breakpoint, null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public final void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
		if (breakpoint instanceof org.eclipse.debug.core.model.LineBreakpoint) {
			try {
				this.eventListener.removeBreakpoint(((LineBreakpoint) breakpoint).getLineNumber());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public final boolean canDisconnect() {
		return !this.eventListener.getMode().equals(DebugMode.RUN);
	}

	@Override
	public final void disconnect() throws DebugException {
		this.eventListener.disconnect();
	}

	@Override
	public final boolean isDisconnected() {
		return this.eventListener.getMode().equals(DebugMode.RUN);
	}

	@Override
	public final IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
		return null;
	}

	@Override
	public final boolean supportsStorageRetrieval() {
		return false;
	}

	@Override
	public final String getName() throws DebugException {
		return this.getSourceName();
	}

	@Override
	public final IProcess getProcess() {
		return null;
	}

	@Override
	public final IThread[] getThreads() throws DebugException {
		return new IThread[] { this.thread };
	}

	@Override
	public final boolean hasThreads() throws DebugException {
		return true;
	}

	@Override
	public final boolean supportsBreakpoint(final IBreakpoint breakpoint) {
		// Support a breakpoint if its debug model equals the Worthwhile debug model
		if (ID_WORTHWHILE_DEBUG_MODEL.equals(breakpoint.getModelIdentifier())) {

			// Check if the breakpoint is set in the program we are currently executing.
			String program;
			try {
				program = this.getLaunch().getLaunchConfiguration().getAttribute(ATTR_PATH, "");
				if (program != null) {
					IMarker marker = breakpoint.getMarker();
					if (marker != null) {
						IPath p = new Path(program);
						return marker.getResource().getFullPath().equals(p);
					}
				}
			} catch (CoreException e) {
				return false;
			}
		}

		return false;
	}

	/**
	 * Called when a breakpoint is hit.
	 * 
	 * @param breakpoint
	 *                The breakpoint that has been hit.
	 */
	public final void breakpointHit(final IBreakpoint breakpoint) {
		this.thread.setBreakpoint(breakpoint);
	}

	/**
	 * Called when the execution has suspended for the given detail reason.
	 * 
	 * @param detail
	 *                The detail reason for the suspend
	 */
	public final void suspended(final int detail) {
		this.thread.fireSuspendEvent(detail);
	}

	/**
	 * Called when the execution has resumed for the given detail reason.
	 * 
	 * @param detail
	 *                The detail reason for the resume.
	 */
	public final void resumed(final int detail) {
		this.thread.setBreakpoint(null);
		this.thread.fireResumeEvent(detail);
	}

	/**
	 * Called when the interpreter terminates the execution.
	 */
	protected final void terminated() {
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
		this.fireTerminateEvent();
	}

	/**
	 * Returns the file name of the source file of the program that is executed.
	 * 
	 * @return The file name of the source file of the program that is executed.
	 */
	public final String getSourceName() {
		try {
			// Get the path from the launch configuration and return only the file name.
			Path path = new Path(this.launch.getLaunchConfiguration().getAttribute(ATTR_PATH, ""));
			return path.lastSegment();
		} catch (CoreException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Returns the current stack frames in this target.
	 * 
	 * @return The current stack frames in this target
	 * @throws DebugException
	 *                 if unable to perform the request
	 */
	protected final IStackFrame[] getStackFrames() throws DebugException {
		return new IStackFrame[] { new WorthwhileStackFrame(this, this.thread,
		                this.eventListener.getCurrentNode()) };
	}

	/**
	 * Returns the event listener.
	 * 
	 * @return The event listener.
	 */
	public final WorthwhileDebugEventListener getEventListener() {
		return this.eventListener;
	}

	/**
	 * Returns a list of all variables in the current execution context.
	 * 
	 * @return A list of all variables in the current execution context.
	 */
	public final IVariable[] getVariables() {
		Set<VariableDeclaration> variables = this.interpreterRunner.getInterpreter().getAllSymbols().keySet();
		IVariable[] result = new IVariable[variables.size()];

		int i = 0;
		for (VariableDeclaration vardecl : variables) {
			result[i++] = new WorthwhileVariable(this, vardecl.getName());
		}

		return result;
	}

	/**
	 * Returns the value of a variable referenced by its name.
	 * 
	 * @param name
	 *                The name of the variable.
	 * @return The value of the variable.
	 */
	public final IValue getVariableValue(final String name) {
		return new WorthwhileValue(this, this.interpreterRunner.getInterpreter().getSymbol(name));
	}

	/**
	 * Sets the value of the given variable.
	 * 
	 * @param variable
	 *                The variable whose value to set.
	 * @param value
	 *                The value to set.
	 */
	public final void setVariableValue(final VariableDeclaration variable, final Value value) {
		this.interpreterRunner.getInterpreter().setSymbol(variable, value);
	}

	/**
	 * Evaluates an expression string and returns the result.
	 * 
	 * @param expressionText
	 *                The expression to evaluate
	 * @return The result of the expression evaluation
	 * @throws DebugException
	 *                 when there is an error in the expression
	 */
	public final Value evaluateExpression(final String expressionText) throws DebugException {
		return this.interpreterRunner.getInterpreter().evaluateExpression(
		                this.parseExpressionString(expressionText));
	}

	/**
	 * Clears all markers in the launched file.
	 */
	private void clearMarkers() {
		final IFile file = this.getLaunchedFile();

		if (file != null) {
			try {
				IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
					@Override
					public void run(final IProgressMonitor monitor) throws CoreException {
						file.deleteMarkers(MARKER_FAILED_ANNOTATION, true,
						                IResource.DEPTH_INFINITE);
						file.deleteMarkers(MARKER_SUCCEEDED_ANNOTATION, true,
						                IResource.DEPTH_INFINITE);
					}
				};
				runnable.run(null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Marks a statement as failed (e.g. an assertion).
	 * 
	 * @param statement
	 *                The statement to mark as failed.
	 */
	public final void markFailedStatement(final ASTNode statement) {
		final IFile file = this.getLaunchedFile();

		if (file != null) {
			try {
				IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
					@Override
					public void run(final IProgressMonitor monitor) throws CoreException {
						// Get the position of the node in the source file.
						int line = NodeHelper.getLine(statement);
						int offset = NodeHelper.getOffset(statement);
						int length = NodeHelper.getLength(statement);

						// Create a new marker
						IMarker marker = file.createMarker(MARKER_FAILED_ANNOTATION);
						marker.setAttribute(IMarker.LINE_NUMBER, line);
						marker.setAttribute(IMarker.CHAR_START, offset);
						marker.setAttribute(IMarker.CHAR_END, offset + length);
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
						marker.setAttribute(IMarker.MESSAGE, "Assertion failed");
					}
				};
				runnable.run(null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Marks a statement as succeeded (e.g. an assertion).
	 * 
	 * @param statement
	 *                The statement to mark as succeeded.
	 */
	public final void markSucceededStatement(final ASTNode statement) {
		final IFile file = this.getLaunchedFile();

		if (file != null) {
			try {
				IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
					@Override
					public void run(final IProgressMonitor monitor) throws CoreException {
						// Get the position of the node in the source file.
						int line = NodeHelper.getLine(statement);
						int offset = NodeHelper.getOffset(statement);
						int length = NodeHelper.getLength(statement);

						// Create a new marker
						IMarker marker = file.createMarker(MARKER_SUCCEEDED_ANNOTATION);
						marker.setAttribute(IMarker.LINE_NUMBER, line);
						marker.setAttribute(IMarker.CHAR_START, offset);
						marker.setAttribute(IMarker.CHAR_END, offset + length);
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
						marker.setAttribute(IMarker.MESSAGE, "Assertion succeeded");
					}
				};
				runnable.run(null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Returns the file that is currently being launched.
	 * 
	 * @return the currently launched file.
	 */
	private IFile getLaunchedFile() {
		// Obtain the path to the file from the launch configuration.
		IPath path;

		try {
			path = new Path(this.launch.getLaunchConfiguration().getAttribute(ATTR_PATH, ""));
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}

		// Locate the path in the workspace and get the file with this path from the workspace.
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		return workspaceRoot.getFile(path);
	}

	/**
	 * Parses an expression string and returns the corresponding AST node.
	 * 
	 * @param expressionText
	 *                The expression string.
	 * @return An {@link Expression} object that represents this expression
	 * @throws DebugException
	 *                 if the expression contains syntax errors.
	 */
	private Expression parseExpressionString(final String expressionText) throws DebugException {
		// Load the expressions language plugin and obtain an injector.
		WorthwhileExpressionsActivator activator = WorthwhileExpressionsActivator.getInstance();
		activator.setContextProvider(this);
		Injector guiceInjector = activator
		                .getInjector("edu.kit.iti.formal.pse.worthwhile.expressions.WorthwhileExpressions");

		// Create a new program that contains the expression string.
		XtextResourceSet resourceSet = guiceInjector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/debug.wwexpr"));
		InputStream in = new ByteArrayInputStream(expressionText.getBytes());

		try {
			resource.load(in, resourceSet.getLoadOptions());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		// Check whether there are errors in the expression string
		if (resource.getErrors().isEmpty()) {
			return ((ExpressionEvaluation) resource.getContents().get(0)).getExpression();
		} else {
			StringBuilder errorStringBuilder = new StringBuilder();

			// Create a newline-separated list of the parse error messages
			Iterator<Diagnostic> iter = resource.getErrors().iterator();
			while (iter.hasNext()) {
				errorStringBuilder.append(iter.next().getMessage());
				if (!iter.hasNext()) {
					break;
				}
				errorStringBuilder.append("\n");
			}

			System.out.println(errorStringBuilder.toString());

			throw new DebugException(new ExpressionEvaluationError(new ParseException(
			                errorStringBuilder.toString(), resource.getErrors().get(0).getColumn())));
		}
	}

	@Override
	public final Set<VariableDeclaration> getVariableDeclarations() {
		return this.interpreterRunner.getInterpreter().getAllSymbols().keySet();
	}

	@Override
	public final Set<FunctionDeclaration> getFunctionDeclarations() {
		return new HashSet<FunctionDeclaration>(this.interpreterRunner.getInterpreter().getProgram()
		                .getFunctionDeclarations());
	}

	private class ExpressionEvaluationError implements IStatus {

		private final Exception exception;

		public ExpressionEvaluationError(final Exception exception) {
			this.exception = exception;
		}

		@Override
		public IStatus[] getChildren() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getCode() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Throwable getException() {
			return this.exception;
		}

		@Override
		public String getMessage() {
			return this.exception.getMessage();
		}

		@Override
		public String getPlugin() {
			return "";
		}

		@Override
		public int getSeverity() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isMultiStatus() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isOK() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean matches(final int arg0) {
			// TODO Auto-generated method stub
			return false;
		}

	}
}
