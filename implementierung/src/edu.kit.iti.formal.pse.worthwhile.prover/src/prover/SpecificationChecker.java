/**
 * 
 */
package prover;

import static AST.Program.*;
import static AST.Expression.*;
import static prover.Validity.*;
import prover.ProgramTransformer.FormulaGenerator;
import AST.Expression;
import Interpreter.StringToValueMap;
import AST.Program;

/** 
 * 
 */
public class SpecificationChecker {
	/** 
	 * 
	 */
	private Integer timeout = 0;

	/** 
	 * @return the timeout
	 */
	public Integer getTimeout() {
		// begin-user-code
		return timeout;
		// end-user-code
	}

	/** 
	 * @param timeout the timeout to set
	 */
	public void setTimeout(Integer timeout) {
		// begin-user-code
		this.timeout = timeout;
		// end-user-code
	}

	/** 
	 * 
	 */
	private ProverCaller prover;

	/** 
	 * @return the prover
	 */
	public ProverCaller getProver() {
		// begin-user-code
		return prover;
		// end-user-code
	}

	/** 
	 * @param prover the prover to set
	 */
	public void setProver(ProverCaller prover) {
		// begin-user-code
		this.prover = prover;
		// end-user-code
	}

	/** 
	 * 
	 */
	private FormulaGenerator transformer;

	/** 
	 * @return the transformer
	 */
	public FormulaGenerator getTransformer() {
		// begin-user-code
		return transformer;
		// end-user-code
	}

	/** 
	 * @param transformer the transformer to set
	 */
	public void setTransformer(FormulaGenerator transformer) {
		// begin-user-code
		this.transformer = transformer;
		// end-user-code
	}

	/** 
	 * 
	 */
	private ProverResult checkResult;

	/** 
	 * @return the checkResult
	 */
	public ProverResult getCheckResult() {
		// begin-user-code
		return checkResult;
		// end-user-code
	}

	/** 
	 * @param checkResult the checkResult to set
	 */
	public void setCheckResult(ProverResult checkResult) {
		// begin-user-code
		this.checkResult = checkResult;
		// end-user-code
	}

	/** 
	 * 
	 */
	public SpecificationChecker() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	 * @param transformer
	 */
	public SpecificationChecker(FormulaGenerator transformer) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	/** 
	 * @param formula
	 * @param environment
	 * @return
	 */
	public Validity checkFormula(Expression formula,
			StringToValueMap environment) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	 * @param program
	 * @return
	 */
	public Validity checkProgram(Program program) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}
}