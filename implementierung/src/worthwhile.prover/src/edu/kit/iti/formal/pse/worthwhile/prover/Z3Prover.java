package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Arrays;
import java.util.List;

/**
 * Caller for the Z3 Prover by Microsoft Research.
 */
public class Z3Prover extends StdProver {
	/**
	 * Construct a new prover caller with the default Z3 command line.
	 * 
	 * The default Z3 command line is <code>z3 -in -smt2 -nw</code>.
	 */
	public Z3Prover() {
		/* we will assume that z3 is in the PATH */
		this("z3");
	}

	/**
	 * Construct a new {@link Z3Prover} with the given Z3 binary path.
	 * 
	 * @param binary
	 *                the path that is executed to run the Z3 prover with the default parameters
	 *                <code>-in -smt2 -nw</code>
	 */
	public Z3Prover(final String binary) {
		this(Arrays.asList(binary, "-in", "-smt2", "-nw", "-m"));
	}

	/**
	 * Construct a new {@link Z3Prover} with the given command line.
	 * 
	 * @param command
	 *                the command line that is executed to run the Z3 prover binary
	 */
	public Z3Prover(final List<String> command) {
		/* we will use SMTLib as the input format */
		super(command, new SMTLIBStrategy());
	}

	@Override
	public final ProverResult getResult(final String output) {
		return new Z3ProverResult(output);
	}
}