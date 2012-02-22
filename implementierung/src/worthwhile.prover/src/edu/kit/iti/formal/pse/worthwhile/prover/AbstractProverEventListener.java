package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * A no-op default implementation of {@link IProverEventListener}.
 * 
 * @author Joachim
 * @author Leon Handreke
 * 
 */
public abstract class AbstractProverEventListener implements IProverEventListener {
	@Override
	public void programVerified(final Program program, final Validity validity, final Expression formula,
	                final ProverResult proverResult) {
	}

	@Override
	public void assertionVerified(final Assertion assertion, final Validity validity, final Expression formula,
	                final ProverResult proverResult) {
	}

	@Override
	public void invariantAndConditionImplyLoopPreconditionVerified(final Loop loop, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
	}

	@Override
	public void invariantValidAtEntryVerified(final Invariant invariant, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
	}

	@Override
	public void postconditionValidVerified(final Postcondition postcondition, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
	}

	@Override
	public void divisorNotZeroVerified(final Expression divisor, final Validity validity, final Expression formula,
	                final ProverResult proverResult) {
	}

	@Override
	public void functionCallPreconditionValidVerified(final FunctionCall functionCall, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
	}
}