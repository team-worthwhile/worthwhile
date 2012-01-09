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
		if (this.getOutput().equals("sat")) {
			return FormulaSatisfiability.SATISFIABLE;
		} else if (this.getOutput().equals("unsat")) {
			return FormulaSatisfiability.UNSATISFIABLE;
		}
		// TODO: Do something even more intelligent here
		// maybe some error checking, but how would we report the error?
		return FormulaSatisfiability.UNKOWN;
	}

}
