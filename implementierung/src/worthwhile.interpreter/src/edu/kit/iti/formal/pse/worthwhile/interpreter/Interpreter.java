/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

/** 
 * 
 */
public class Interpreter {
	/**
	 */
	private Set<AbstractExecutionEventListener> executionEventHandlers = new HashSet<AbstractExecutionEventListener>();

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
	public void setExecutionEventHandlers(
			Set<AbstractExecutionEventListener> executionEventHandlers) {
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
		this.currentNodeVisitor = new InterpreterASTNodeVisitor();
		this.currentNodeVisitor
				.setExecutionEventHandlers(this.executionEventHandlers);
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
	public void removeExecutionEventHandler(
			AbstractExecutionEventListener handler) {
		this.executionEventHandlers.remove(handler);
	}

	/**
	 * @param expression
	 * @return
	 */
	public Value evaluateExpression(Expression expression) {
		InterpreterASTNodeVisitor visitor = new InterpreterASTNodeVisitor();
		visitor.visit(expression);
		return visitor.getReturnValue();
	}

	/**
	 * @param key
	 * @return
	 */
	public Value getSymbol(VariableDeclaration key) {
		return this.currentNodeVisitor.getSymbol(key);
	}

	/**
	 * Get the value of a symbol by its name
	 * 
	 * @param key
	 *            the name of the Symbol to look up the value for
	 * @return the current value of the Symbol or null if no such symbol exists
	 */
	public Value getSymbol(String key) {
		return this.currentNodeVisitor.getSymbol(key);
	}

	/**
	 * @param key
	 * @param value
	 */
	public void setSymbol(VariableDeclaration key, Value value) {
		this.currentNodeVisitor.setSymbol(key, value);
	}

	/**
	 * @return
	 */
	public Map<VariableDeclaration, Value> getAllSymbols() {
		return this.currentNodeVisitor.getAllSymbols();
	}
}