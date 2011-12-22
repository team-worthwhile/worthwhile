/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.util.Map;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/** 
 * 
 */
public class Interpreter {
	/**
	 */
	private Set<AbstractDebugEventListener> debugEventHandlers;

	/** 
	 * @return the debugEventHandlers
	 */
	public Set<AbstractDebugEventListener> getDebugEventHandlers() {
		// begin-user-code
		return debugEventHandlers;
		// end-user-code
	}

	/** 
	 * @param debugEventHandlers the debugEventHandlers to set
	 */
	public void setDebugEventHandlers(
			Set<AbstractDebugEventListener> debugEventHandlers) {
		// begin-user-code
		this.debugEventHandlers = debugEventHandlers;
		// end-user-code
	}

	/** 
	 * 
	 */
	private InterpreterASTNodeVisitor currentNodeVisitor;

	/** 
	 * @return the currentNodeVisitor
	 */
	public InterpreterASTNodeVisitor getCurrentNodeVisitor() {
		// begin-user-code
		return currentNodeVisitor;
		// end-user-code
	}

	/** 
	 * @param currentNodeVisitor the currentNodeVisitor to set
	 */
	public void setCurrentNodeVisitor(
			InterpreterASTNodeVisitor currentNodeVisitor) {
		// begin-user-code
		this.currentNodeVisitor = currentNodeVisitor;
		// end-user-code
	}

	/** 
	 * 
	 */
	private Set<InterpreterASTNodeVisitor> nodeVisitors;

	/** 
	 * @return the nodeVisitors
	 */
	public Set<InterpreterASTNodeVisitor> getNodeVisitors() {
		// begin-user-code
		return nodeVisitors;
		// end-user-code
	}

	/** 
	 * @param nodeVisitors the nodeVisitors to set
	 */
	public void setNodeVisitors(Set<InterpreterASTNodeVisitor> nodeVisitors) {
		// begin-user-code
		this.nodeVisitors = nodeVisitors;
		// end-user-code
	}

	/** 
	 * 
	 */
	private Program program;

	/** 
	 * @return the program
	 */
	public Program getProgram() {
		// begin-user-code
		return program;
		// end-user-code
	}

	/** 
	 * @param program the program to set
	 */
	public void setProgram(Program program) {
		// begin-user-code
		this.program = program;
		// end-user-code
	}

	/** 
	 * 
	 */
	private Set<LineBreakpoint> breakpoints;

	/** 
	 * @return the breakpoints
	 */
	public Set<LineBreakpoint> getBreakpoints() {
		// begin-user-code
		return breakpoints;
		// end-user-code
	}

	/** 
	 * @param breakpoints the breakpoints to set
	 */
	public void setBreakpoints(Set<LineBreakpoint> breakpoints) {
		// begin-user-code
		this.breakpoints = breakpoints;
		// end-user-code
	}

	/** 
	 * @param program
	 */
	public Interpreter(Program program) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	 * 
	 */
	public void execute() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @param breakpoint
	 */
	public void addBreakpoint(LineBreakpoint breakpoint) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @param breakpoint
	 */
	public void removeBreakpoint(LineBreakpoint breakpoint) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @param handler
	 */
	public void addDebugEventHandler(AbstractDebugEventListener handler) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @param handler
	 */
	public void removeDebugEventHandler(AbstractDebugEventListener handler) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @param expression
	 * @return
	 */
	public Value evaluateExpression(Expression expression) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * @param key
	 * @return
	 */
	public Value getSymbol(String key) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * @param key
	 * @param value
	 */
	public void setSymbol(String key, Value value) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/** 
	 * @return
	 */
	public StringToValueMap getAllSymbols() {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}