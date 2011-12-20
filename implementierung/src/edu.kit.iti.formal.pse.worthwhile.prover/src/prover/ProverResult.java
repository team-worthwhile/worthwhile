/**
 * 
 */
package prover;

/** 
 * 
 */
public class ProverResult {
	/** 
	 * 
	 */
	private String output;

	/** 
	 * @return the output
	 */
	public String getOutput() {
		// begin-user-code
		return output;
		// end-user-code
	}

	/** 
	 * @param output the output to set
	 */
	public void setOutput(String output) {
		// begin-user-code
		this.output = output;
		// end-user-code
	}

	/** 
	 * 
	 */
	private FormulaSatisfiability satisfiability;

	/** 
	 * @return the satisfiability
	 */
	public FormulaSatisfiability getSatisfiability() {
		// begin-user-code
		return satisfiability;
		// end-user-code
	}

	/** 
	 * @param satisfiability the satisfiability to set
	 */
	public void setSatisfiability(FormulaSatisfiability satisfiability) {
		// begin-user-code
		this.satisfiability = satisfiability;
		// end-user-code
	}

	/** 
	 * @param satisfiability
	 * @param output
	 */
	protected ProverResult(FormulaSatisfiability satisfiability, String output) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}
}