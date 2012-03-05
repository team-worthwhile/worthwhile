package edu.kit.iti.formal.pse.worthwhile.prover.transformer;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;

/**
 * Represents an implication for the correctness of a (sub-) Program that a {@link Proof} has.
 * 
 * @author Leon Handreke
 */
public enum ProofImplication {
	/**
	 * an {@link Assertion} is correct.
	 */
	ASSERTION_VALID,

	/**
	 * a divisor is not zero.
	 */
	DIVISOR_NOT_ZERO,

	/**
	 * the precondition of a function is valid prior to the function call.
	 */
	FUNCTION_CALL_PRECONDITION_VALID,

	/**
	 * a function postcondition is correct.
	 */
	POSTCONDITION_VALID,

	/**
	 * a loop invariant is valid at the entry into a {@link Loop}.
	 */
	INVARIANT_VALID_AT_ENTRY,

	/**
	 * loop {@link Invariant}s and condition imply the {@link Loop} body precondition.
	 */
	INVARIANT_AND_CONDITION_IMPLIES_LOOP_BODY_PRECONDITION,

	/**
	 * a program conforms to its specification.
	 */
	PROGRAM_CONFORM
}
