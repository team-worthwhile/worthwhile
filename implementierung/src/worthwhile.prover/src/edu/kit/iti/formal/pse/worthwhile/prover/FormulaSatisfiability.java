/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Expresses the satisfiability of a formula. A formula is satisfiable if there exists an interpretation of the formula
 * so that it is true.
 */
public enum FormulaSatisfiability {
	/**
	 * Indicates satisfiability.
	 */
	SATISFIABLE,

	/**
	 * Indicates unsatisfiability.
	 */
	UNSATISFIABLE,

	/**
	 * Indicates unknown satisfiability.
	 */
	UNKOWN
}