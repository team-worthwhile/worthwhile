package edu.kit.iti.formal.pse.worthwhile.prover;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * Implements a prover interface that uses stdin/stdout/stderr.
 */
abstract class StdProver extends TimeoutProverCaller {
	/**
	 * The compiler used to construct an input string from the Expression object to be checked for satisfiability.
	 */
	private FormulaCompiler compiler;

	/**
	 * The command line that is executed to call this prover.
	 */
	private List<String> proverCommand;

	/**
	 * Constructs a new caller with the given prover command and compiler object.
	 * 
	 * @param command
	 *                the command line that is executed to call this prover
	 * @param compiler
	 *                the compiler to use to compile valid input for the prover
	 * @param timeout
	 *                the timeout after which to kill the prover
	 */
	protected StdProver(final String command, final FormulaCompiler compiler, final int timeout) {
		this(Arrays.asList(command), compiler, timeout);
	}

	/**
	 * Constructs a new caller with the given prover command and compiler object.
	 * 
	 * @param command
	 *                the command line that is executed to call this prover
	 * @param compiler
	 *                the compiler to use to compile valid input for the prover
	 * @param timeout
	 *                the timeout after which to kill the prover
	 */
	protected StdProver(final List<String> command, final FormulaCompiler compiler, final int timeout) {
		super(timeout);
		this.compiler = compiler;
		this.proverCommand = command;
	}

	@Override
	public ProverResult checkFormula(final Expression formula) throws ProverCallerException {
		String inputString = this.getCompiler().compileFormula(formula);
		String outputString = "";
		try {
			// instantiate the prover
			ProcessBuilder builder = new ProcessBuilder(this.proverCommand);
			builder.redirectErrorStream(true);
			final Process proverProcess = builder.start();
			// schedule cleanup after timeout
			this.addCleanupTask(new Runnable() {
				@Override
				public void run() {
					proverProcess.destroy();
				}
			});
			this.scheduleProverCallerTimeout();

			// get the streams that are used to communicate with the prover
			BufferedReader stdout = new BufferedReader(
			                new InputStreamReader(proverProcess.getInputStream()));
			BufferedWriter stdin = new BufferedWriter(new OutputStreamWriter(
			                proverProcess.getOutputStream()));
			// ask the prover what we want to know
			stdin.write(inputString);
			stdin.close();

			// read all the output from the prover process
			String line;
			// this is where the function blocks until the prover quits or the timeout is reached
			while ((line = stdout.readLine()) != null) {
				outputString += line + "\n";
			}

			// TODO: Maybe make this heuristic better...
			// if the prover returned nothing, assume timeout
			if (outputString.equals("")) {
				return new ProverResult("timeout") {
					@Override
					public FormulaSatisfiability getSatisfiability() {
						return FormulaSatisfiability.UNKOWN;
					}
				};
			}
		} catch (IOException e) {
			// normally the binary was simply not found
			e.printStackTrace();
			throw new ProverCallerException("Error executing the prover command line: "
			                + this.proverCommand);
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
	 * @return the command line that is executed to call this prover
	 */
	public List<String> getProverCommand() {
		return this.proverCommand;
	}

	/**
	 * Convert output supplied by the prover to machine-readable <code>ProverResult</code>.
	 * 
	 * @param output
	 *                the String output returned from the called prover
	 * @return a result extracted from the prover output
	 */
	abstract ProverResult getResult(String output);

	/**
	 * @param compiler
	 *                the compiler to set to compile input for this prover
	 */
	public void setCompiler(final FormulaCompiler compiler) {
		this.compiler = compiler;
	}

	/**
	 * Convenience method for when the prover command line consists of only the program name.
	 * 
	 * @param command
	 *                the command line that is executed to call this prover
	 */
	public void setProverCommand(final String command) {
		this.setProverCommand(Arrays.asList(command));
	}

	/**
	 * @param command
	 *                the command line that is executed to call this prover
	 */
	public void setProverCommand(final List<String> command) {
		this.proverCommand = command;
	}
}