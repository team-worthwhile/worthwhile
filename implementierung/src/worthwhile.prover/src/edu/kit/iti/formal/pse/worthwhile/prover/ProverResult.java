package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Represents a result of a proof attempt by a prover for a formula
 */
abstract class ProverResult {
	/**
	 * The output of the prover
	 */
	private final String output;

	/**
	 * Construct a new instance using the given output to deduce the
	 * satisfiability
	 *
	 * @param output the output to construct the result with
	 */
	protected ProverResult(String output) {
		this.output = output;
	}

	/**
	 * @return the raw output of the prover
	 */
	public String getOutput() {
		return this.output;
	}

	/**
	 * @return the satisfiability of the formula
	 */
	public abstract FormulaSatisfiability getSatisfiability();
}