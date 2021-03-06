package edu.kit.iti.formal.pse.worthwhile.prover.caller;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Represents a result of a proof attempt by a prover for a formula.
 */
public abstract class ProverResult {
	/**
	 * The output of the prover.
	 */
	private final String output;

	/**
	 * The model, if available.
	 */
	private final Program model;

	/**
	 * Construct a new instance using the given output to deduce the satisfiability.
	 * 
	 * @param output
	 *                the output to construct the result with
	 */
	protected ProverResult(final String output) {
		this.output = output;
		this.model = null;
	}

	/**
	 * Construct a new instance using the given output and model to deduce the satisfiability.
	 * 
	 * @param output
	 *                the output to construct the result with
	 * @param model
	 *                The model generated by the prover.
	 */
	protected ProverResult(final String output, final Program model) {
		this.output = output;
		this.model = model;
	}

	/**
	 * @return the raw output of the prover
	 */
	public final String getOutput() {
		return this.output;
	}

	/**
	 * @return the model generated by the prover, if available, {@code null} otherwise.
	 */
	public final Program getModel() {
		return this.model;
	}

	/**
	 * @return the satisfiability of the formula
	 */
	public abstract FormulaSatisfiability getSatisfiability();
}