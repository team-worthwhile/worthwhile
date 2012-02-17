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
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;

/**
 * The facade for the interpreter module.
 * 
 * @author Chris
 * 
 */
public class Interpreter {
	/**
	 * The {@link Set} of {@link AbstractExecutionEventListener}s that are
	 * notified during execution.
	 */
	private Set<AbstractExecutionEventListener> executionEventHandlers = new HashSet<AbstractExecutionEventListener>();

	/**
	 * The {@link InterpreterASTNodeVisitor} that is executing the
	 * {@link program}, if any.
	 */
	private InterpreterASTNodeVisitor executingVisitor;

	/**
	 * Gets the current node visitor.
	 * 
	 * @return the currently executing {@link InterpreterASTNodeVisitor} and
	 *         <code>null</code> if {@link Interpreter#execute()} has not been
	 *         called yet
	 */
	public final InterpreterASTNodeVisitor getCurrentNodeVisitor() {
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
	 * @return the {@link Program} ran by this {@link Interpreter} instance.
	 */
	public final Program getProgram() {
		return program;
	}

	/**
	 * the prover used to check formulas.
	 */
	private SpecificationChecker specificationChecker;

	/**
	 * Constructs a new {@link Interpreter} with the given program and
	 * specification checker.
	 * 
	 * @param program
	 *            the program to execute
	 * @param specificationChecker
	 *            the specification checker to use to prove some expressions
	 */
	public Interpreter(final Program program,
			final SpecificationChecker specificationChecker) {
		this.program = program;
		this.specificationChecker = specificationChecker;
	}

	/**
	 * Executes the {@link program}.
	 * 
	 * @see Interpreter#Interpreter(Program)
	 * @see Interpreter#setProgram(Program)
	 */
	public final void execute() {
		this.executingVisitor = new InterpreterASTNodeVisitor(
				this.specificationChecker);
		this.executingVisitor
				.setExecutionEventHandlers(this.executionEventHandlers);
		this.program.accept(executingVisitor);
	}

	/**
	 * Adds the execution event handler.
	 * 
	 * @param handler
	 *            the handler
	 */
	public final void addExecutionEventHandler(
			final AbstractExecutionEventListener handler) {
		this.executionEventHandlers.add(handler);
	}

	/**
	 * Removes the execution event handler.
	 * 
	 * @param handler
	 *            the handler
	 */
	public final void removeExecutionEventHandler(
			final AbstractExecutionEventListener handler) {
		this.executionEventHandlers.remove(handler);
	}

	/**
	 * Evaluate expression.
	 * 
	 * @param expression
	 *            the expression
	 * @return the "return"-value of the expression
	 */
	public final Value evaluateExpression(final Expression expression) {
		InterpreterASTNodeVisitor visitor = this.getCurrentNodeVisitor();

		if (visitor != null) {
			visitor = visitor.clone();
		} else {
			visitor = new InterpreterASTNodeVisitor(this.specificationChecker);
		}

		expression.accept(visitor);
		return visitor.getReturnValue();
	}

	/**
	 * Gets a symbol.
	 * 
	 * @param key
	 *            the key
	 * @return the symbol
	 */
	public final Value getSymbol(final VariableDeclaration key) {
		return this.getCurrentNodeVisitor().getSymbol(key);
	}

	/**
	 * Get the value of a symbol by its name.
	 * 
	 * @param key
	 *            the name of the Symbol to look up the value for
	 * @return the current value of the Symbol or null if no such symbol exists
	 */
	public final Value getSymbol(final String key) {
		return this.getCurrentNodeVisitor().getSymbol(key);
	}

	/**
	 * Sets a symbol.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public final void setSymbol(final VariableDeclaration key, final Value value) {
		this.getCurrentNodeVisitor().setSymbol(key, value);
	}

	/**
	 * Gets all symbols.
	 * 
	 * @return all symbols as Map
	 */
	public final Map<VariableDeclaration, Value> getAllSymbols() {
		return this.getCurrentNodeVisitor().getAllSymbols();
	}
}