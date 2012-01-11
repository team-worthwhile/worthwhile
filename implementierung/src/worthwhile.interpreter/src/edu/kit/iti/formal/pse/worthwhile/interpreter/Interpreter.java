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
	private Set<AbstractExecutionEventListener> executionEventHandlers;

	/**
	 * @return the executionEventHandlers
	 */
	public Set<AbstractExecutionEventListener> getExecutionEventHandlers() {
		// begin-user-code
		return this.executionEventHandlers;
		// end-user-code
	}

	/**
	 * @param executionEventHandlers
	 *            the executionEventHandlers to set
	 */
	public void setExecutionEventHandlers(Set<AbstractExecutionEventListener> executionEventHandlers) {
		// begin-user-code
		this.executionEventHandlers = executionEventHandlers;
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
		return this.currentNodeVisitor;
		// end-user-code
	}

	/**
	 * @param currentNodeVisitor
	 *            the currentNodeVisitor to set
	 */
	public void setCurrentNodeVisitor(InterpreterASTNodeVisitor currentNodeVisitor) {
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
		return this.nodeVisitors;
		// end-user-code
	}

	/**
	 * @param nodeVisitors
	 *            the nodeVisitors to set
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
		return this.program;
		// end-user-code
	}

	/**
	 * @param program
	 *            the program to set
	 */
	public void setProgram(Program program) {
		// begin-user-code
		this.program = program;
		// end-user-code
	}

	/**
	 * @param program
	 */
	public Interpreter(Program program) {
		this.program = program;
	}

	/** 
	 * 
	 */
	public void execute() {
		this.program.accept(currentNodeVisitor);
	}

	/**
	 * @param handler
	 */
	public void addExecutionEventHandler(AbstractExecutionEventListener handler) {
		this.executionEventHandlers.add(handler);
	}

	/**
	 * @param handler
	 */
	public void removeExecutionEventHandler(AbstractExecutionEventListener handler) {
		this.executionEventHandlers.remove(handler);
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
		return this.currentNodeVisitor.getSymbol(key);
	}

	/**
	 * @param key
	 * @param value
	 */
	public void setSymbol(String key, Value value) {
		this.currentNodeVisitor.setSymbol(key, value);
	}

	/**
	 * @return
	 */
	public Map<String, Value> getAllSymbols() {
		return this.currentNodeVisitor.getAllSymbols();
	}
}