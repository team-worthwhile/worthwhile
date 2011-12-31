package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Represents a prover result returned by the Z3 Prover
 */
public class Z3ProverResult extends ProverResult {

	protected Z3ProverResult(String output) {
		super(output);
	}

	@Override
	public FormulaSatisfiability getSatisfiability() {
		// FIXME: Do something more intelligent here
		return FormulaSatisfiability.SATISFIABLE;
	}

}
