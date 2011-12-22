package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Caller for the Z3 Prover by Microsoft Research
 */
public class Z3Prover extends StdProver {
	/**
	 * Construct a new prover caller with the default path
	 */
	public Z3Prover() {
		// we will use SMTLib as the input format
		super("/bin/false", new SMTLIBStrategy());
	}

	/**
	 * @see StdProver#getResult(String output)
	 */
	@Override
	public ProverResult getResult(String output) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}