package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Represents a prover result returned by the Z3 Prover
 */
public class Z3ProverResult extends ProverResult {

	/**
	 * @see ProverResult#ProverResult(String)
	 */
	protected Z3ProverResult(String output) {
		super(output);
	}

	/**
	 * @see ProverResult#getSatisfiability()
	 */
	@Override
	public FormulaSatisfiability getSatisfiability() {
		// TODO Auto-generated method stub
		return null;
	}

}
