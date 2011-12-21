/**
 * 
 */
package prover;

/** 
 * 
 */
abstract class ProverResult {
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
	 * @return the satisfiability
	 */
	public abstract FormulaSatisfiability getSatisfiability();

	/** 
	 * @param satisfiability
	 * @param output
	 */
	protected ProverResult(String output) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}
}