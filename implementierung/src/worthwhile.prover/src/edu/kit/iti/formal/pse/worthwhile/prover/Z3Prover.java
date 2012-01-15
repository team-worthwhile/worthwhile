package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Caller for the Z3 Prover by Microsoft Research.
 */
public class Z3Prover extends StdProver {
	/**
	 * Construct a new prover caller with the default path.
	 */
	public Z3Prover() {
		/* we will assume that z3 is in the PATH */
		this("z3");
	}

	public Z3Prover(final String path) {
		/* we will use SMTLib as the input format */
		super(path, new SMTLIBStrategy());
	}

	@Override
	public ProverResult getResult(final String output) {
		return new Z3ProverResult(output);
	}
}