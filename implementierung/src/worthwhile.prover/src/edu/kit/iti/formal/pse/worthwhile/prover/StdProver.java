package edu.kit.iti.formal.pse.worthwhile.prover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * Implements a prover interface that uses stdin/stdout/stderr.
 */
abstract class StdProver implements ProverCaller {
	/**
	 * The compiler used to construct an input string from the Expression object to be checked for satisfiability.
	 */
	private FormulaCompiler compiler;

	/**
	 * The path to the binary of the prover that should be called.
	 */
	private String proverPath;

	/**
	 * Constructs a new caller with the given binary path and compiler object.
	 * 
	 * @param path
	 *            the path to the binary to call
	 * @param compiler
	 *            the compiler to use to compile valid input for the prover
	 */
	protected StdProver(final String path, final FormulaCompiler compiler) {
		this.compiler = compiler;
		this.proverPath = path;
	}

	/**
	 * Check an the given <code>Expression</code> for its validity.
	 * 
	 * @param formula
	 *            the expression to check
	 * @return the result returned by the prover
	 * @throws ProverCallerException
	 */
	@Override
	public ProverResult checkFormula(final Expression formula) throws ProverCallerException {
		String inputString = this.getCompiler().compileFormula(formula);
		String outputString = "";
		try {
			// instantiate the prover
			ProcessBuilder builder = new ProcessBuilder(this.proverPath);
			builder.redirectErrorStream(true);
			Process proverProcess = builder.start();

			// get the streams that are used to communicate with the prover
			BufferedReader stdout = new BufferedReader(new InputStreamReader(proverProcess.getInputStream()));
			BufferedWriter stdin = new BufferedWriter(new OutputStreamWriter(proverProcess.getOutputStream()));
			// ask the prover what we want to know
			stdin.write(inputString);
			stdin.close();

			// read all the output from the prover process
			String line;
			while ((line = stdout.readLine()) != null) {
				outputString += line;
			}
		} catch (IOException e) {
			// normally the binary was simply not found
			e.printStackTrace();
			throw new ProverCallerException("Error calling prover binary: " + this.proverPath);
		}
		return this.getResult(outputString);
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
	 * Convert output supplied by the prover to machine-readable <code>ProverResult</code>.
	 * 
	 * @param output
	 *            the String output returned from the called prover
	 * @return a result extracted from the prover output
	 */
	abstract ProverResult getResult(String output);

	/**
	 * @param compiler
	 *            the compiler to set to compile input for this prover
	 */
	public void setCompiler(final FormulaCompiler compiler) {
		this.compiler = compiler;
	}

	/**
	 * @param proverPath
	 *            the path to the binary to call for this prover
	 */
	public void setProverPath(final String proverPath) {
		this.proverPath = proverPath;
	}
}