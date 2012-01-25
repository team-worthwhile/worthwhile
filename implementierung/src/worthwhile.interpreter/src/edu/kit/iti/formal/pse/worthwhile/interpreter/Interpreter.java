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
	 * The {@link Set} of {@link AbstractExecutionEventListener}s that are notified during execution.
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
	 *                the executionEventHandlers to set
	 */
	public void setExecutionEventHandlers(Set<AbstractExecutionEventListener> executionEventHandlers) {
		// begin-user-code
		this.executionEventHandlers = executionEventHandlers;
		// end-user-code
	}

	/**
	 * The {@link InterpreterASTNodeVisitor} that is executing the {@link program}, if any.
	 */
	private InterpreterASTNodeVisitor executingVisitor;

	/**
	 * @return the currently executing {@link InterpreterASTNodeVisitor} and <code>null</code> if
	 *         {@link Interpreter#execute()} has not been called yet
	 */
	public InterpreterASTNodeVisitor getCurrentNodeVisitor() {
		if (this.executingVisitor != null) {
			return this.executingVisitor.getExecutingVisitor();
		} else {
			return null;
		}
	}

	/**
	 * The {@link Program} that is executed with {@link Interpreter#execute()}.
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
	 *                the program to set
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
	 * Executes the {@link program}.
	 * 
	 * @see Interpreter#Interpreter(Program)
	 * @see Interpreter#setProgram(Program)
	 */
	public void execute() {
		this.executingVisitor = new InterpreterASTNodeVisitor();
		this.executingVisitor.setExecutionEventHandlers(this.executionEventHandlers);
		this.program.accept(executingVisitor);
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
		InterpreterASTNodeVisitor visitor = this.getCurrentNodeVisitor();

		if (visitor != null) {
			visitor = visitor.clone();
		} else {
			visitor = new InterpreterASTNodeVisitor();
		}

		expression.accept(visitor);
		return visitor.getReturnValue();
	}

	/**
	 * @param key
	 * @return
	 */
	public Value getSymbol(VariableDeclaration key) {
		return this.getCurrentNodeVisitor().getSymbol(key);
	}

	/**
	 * Get the value of a symbol by its name
	 * 
	 * @param key
	 *                the name of the Symbol to look up the value for
	 * @return the current value of the Symbol or null if no such symbol exists
	 */
	public Value getSymbol(String key) {
		return this.getCurrentNodeVisitor().getSymbol(key);
	}

	/**
	 * @param key
	 * @param value
	 */
	public void setSymbol(VariableDeclaration key, Value value) {
		this.getCurrentNodeVisitor().setSymbol(key, value);
	}

	/**
	 * @return
	 */
	public Map<VariableDeclaration, Value> getAllSymbols() {
		return this.getCurrentNodeVisitor().getAllSymbols();
	}
}