package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;

/**
 * A runnable class which can execute an interpreter.
 * 
 * @author Joachim
 * 
 */
public class InterpreterRunner extends Thread {

	/**
	 * The interpreter to be run.
	 */
	private final Interpreter interpreter;

	/**
	 * Returns the interpreter being run.
	 * 
	 * @return The interpreter being run.
	 */
	public final Interpreter getInterpreter() {
		return this.interpreter;
	}

	/**
	 * Creates a new instance of the {@link InterpreterRunner} class.
	 * 
	 * @param interpreter
	 *                The interpreter to be run.
	 */
	public InterpreterRunner(final Interpreter interpreter) {
		super("Worthwhile Interpreter runner");
		this.interpreter = interpreter;
	}

	@Override
	public final void run() {
		this.interpreter.execute();
	}
}
