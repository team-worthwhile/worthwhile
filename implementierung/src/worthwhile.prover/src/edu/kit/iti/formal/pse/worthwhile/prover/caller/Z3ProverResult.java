package edu.kit.iti.formal.pse.worthwhile.prover.caller;

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
		for (final String s : this.getOutput().split("\n")) {
			if (s.contains("error")) {
				return FormulaSatisfiability.UNKOWN;
			} else if (s.equals("sat")) {
				return FormulaSatisfiability.SATISFIABLE;
			} else if (s.equals("unsat")) {
				return FormulaSatisfiability.UNSATISFIABLE;
			}
		}
		// TODO: Do something even more intelligent here
		// maybe some error checking, but how would we report the error?
		return FormulaSatisfiability.UNKOWN;
	}

}
