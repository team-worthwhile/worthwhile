package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Event listener for events that may occur while the prover is running.
 * 
 * @author Leon Handreke
 * 
 */
public interface IProverEventListener {
	/**
	 * Signals that all verifiable elements in a program were verified.
	 * 
	 * @param program
	 *                the program that has been verified
	 * @param validity
	 *                the validity of the program
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void programVerified(final Program program, final Validity validity, final Expression formula,
	                final ProverResult proverResult);

	/**
	 * Signals that that an assertion has been verified to be valid for one branch of execution.
	 * 
	 * @param assertion
	 *                the {@link Assertion} that has been verified
	 * @param validity
	 *                the validity of the {@link Assertion}
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void assertionVerified(final Assertion assertion, final Validity validity, final Expression formula,
	                final ProverResult proverResult);

	/**
	 * Signals that an {@link Invariant} for a loop has been verified to be valid at entry into the loop.
	 * 
	 * @param invariant
	 *                the {@link Invariant} that has been verified
	 * @param validity
	 *                the validity of the {@link Invariant}
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void invariantValidAtEntryVerified(final Invariant invariant, final Validity validity,
	                final Expression formula, final ProverResult proverResult);

	/**
	 * Signals that the {@link Invariant} and condition of a loop implying the block postcondition has been
	 * verified.
	 * 
	 * @param program
	 *                the invariant that has been verified
	 * @param validity
	 *                the validity of the program
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void invariantAndConditionImplyLoopPreconditionVerified(final Loop loop, final Validity validity,
	                final Expression formula, final ProverResult proverResult);

	/**
	 * Signals that the inequality to zero of a divisor has been verified.
	 * 
	 * @param divisor
	 *                the divisor that has been verified
	 * @param validity
	 *                the validity of the program
	 * @param formula
	 *                the formula that was attempted to prove
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void divisorNotZeroVerified(final Expression divisor, final Validity validity, final Expression formula,
	                final ProverResult proverResult);

	/**
	 * Signals that the validity of a function precondition before a function call has been verified.
	 * 
	 * @param functionCall
	 *                the function call for which the precondition that has been verified
	 * @param validity
	 *                the validity of the program
	 * @param formula
	 *                the formula that was attempted to prove
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void functionCallPreconditionValidVerified(final FunctionCall functionCall, final Validity validity,
	                final Expression formula, final ProverResult proverResult);

	/**
	 * Signals that the Validity of a function {@link Postcondition} has been verified.
	 * 
	 * @param postcondition
	 *                the {@link Postcondition} that has been verified
	 * @param validity
	 *                the validity of the program
	 * @param proverResult
	 *                the result returned by the prover
	 */
	void postconditionValidVerified(final Postcondition postcondition, final Validity validity,
	                final Expression formula, final ProverResult proverResult);
}
