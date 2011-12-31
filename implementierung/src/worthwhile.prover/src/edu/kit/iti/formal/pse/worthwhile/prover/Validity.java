/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

/**
 * Expresses the validity of a formula. A formula is valid if (not formula) is
 * unsatisfiable, i.e. the formula is true for all possible interpretations.
 */
public enum Validity {
	VALID,
	INVALID,
	UNKNOWN
}