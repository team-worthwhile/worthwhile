package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * Implements a prover interface that uses stdin/stdout/stderr
 */
abstract class StdProver implements ProverCaller {
	/**
	 *
	 */
	private FormulaCompiler compiler;

	/**
	 * The path to the binary of the prover that should be called
	 */
	private String proverPath;

	/**
	 * Constructs a new caller with the given binary path and compiler object
	 *
	 * @param path the path to the binary to call
	 * @param compiler the compiler to use to compile valid input for the prover
	 */
	protected StdProver(String path, FormulaCompiler compiler) {
		this.compiler = compiler;
	}

	/**
	 * Check an the given <code>Expression</code> for its validity
	 *
	 * @param formula the expression to check
	 * @return the result returned by the prover
	 */
	public ProverResult checkFormula(Expression formula) {
		String in = this.getCompiler().compileFormula(formula);
		String out = this.executeProverBinary(in);
		return this.getResult(out);
	}

	/**
	 * Call the prover with the given input string
	 *
	 * @param input the input string to pass to the prover
	 * @return the output received on stdout from the prover
	 */
	// TODO: Throw some kind of "can't find the binary exception"
	private String executeProverBinary(String input) {
		return null;
	}

	/**
	 * @return the compiler used to compile input for this prover
	 */
	public FormulaCompiler getCompiler() {
		return this.compiler;
	}

	/**
	 * @return the path to the prover binary called by this caller
	 */
	public String getProverPath() {
		return this.proverPath;
	}

	/**
	 * Convert output supplied by the prover to machine-readable
	 * <code>ProverResult</code>
	 *
	 * @param output the String output returned from the called prover
	 * @return a result extracted from the prover output
	 */
	protected abstract ProverResult getResult(String output);

	/**
	 * @param compiler the compiler to set to compile input for this prover
	 */
	public void setCompiler(FormulaCompiler compiler) {
		this.compiler = compiler;
	}

	/**
	 * @param proverPath the path to the binary to call for this prover
	 */
	public void setProverPath(String proverPath) {
		this.proverPath = proverPath;
	}
}