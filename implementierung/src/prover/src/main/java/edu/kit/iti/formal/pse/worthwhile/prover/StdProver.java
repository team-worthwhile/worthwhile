/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/** 
 * 
 */
abstract class StdProver implements ProverCaller {
	/** 
	 * 
	 */
	private FormulaCompiler compiler;
	
	/** 
	 * 
	 */
	public StdProver() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	 * @param path
	 * @param compiler
	 */
	protected StdProver(String path, FormulaCompiler compiler) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	 * @return the compiler
	 */
	public FormulaCompiler getCompiler() {
		// begin-user-code
		return compiler;
		// end-user-code
	}

	/** 
	 * @param compiler the compiler to set
	 */
	public void setCompiler(FormulaCompiler compiler) {
		// begin-user-code
		this.compiler = compiler;
		// end-user-code
	}

	/** 
	 * 
	 */
	private String proverPath;

	/** 
	 * @return the proverPath
	 */
	public String getProverPath() {
		// begin-user-code
		return proverPath;
		// end-user-code
	}

	/** 
	 * @param proverPath the proverPath to set
	 */
	public void setProverPath(String proverPath) {
		// begin-user-code
		this.proverPath = proverPath;
		// end-user-code
	}

	/** 
	 * @param formula
	 * @return
	 */
	public ProverResult checkFormula(Expression formula) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * @param output
	 * @return
	 */
	public abstract ProverResult getResult(String output);
}