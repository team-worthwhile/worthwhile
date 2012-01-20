package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Represents a prover result returned by the Z3 Prover.
 */
public class Z3ProverResult extends ProverResult {

	/**
	 * Construct a new {@link Z3ProverResult} from the given prover output.
	 * 
	 * @param output
	 *                the output to interpret as a result
	 */
	protected Z3ProverResult(final String output) {
		super(output);
	}

	@Override
	public final FormulaSatisfiability getSatisfiability() {
		if (this.getOutput().startsWith("sat")) {
			return FormulaSatisfiability.SATISFIABLE;
		} else if (this.getOutput().startsWith("unsat")) {
			return FormulaSatisfiability.UNSATISFIABLE;
		}
		// TODO: Do something even more intelligent here
		// maybe some error checking, but how would we report the error?
		return FormulaSatisfiability.UNKOWN;
	}

}
