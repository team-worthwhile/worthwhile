package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
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
	public void programVerified(final Program program, final Validity validity, final ProverResult proverResult) {
	}

	@Override
	public void assertionVerified(Assertion assertion, Validity validity, ProverResult proverResult) {
	}

	@Override
	public void invariantAndConditionImplyLoopPreconditionVerified(Loop loop, Validity validity,
	                ProverResult proverResult) {
	}

	@Override
	public void invariantValidAtEntryVerified(Invariant invariant, Validity validity, ProverResult proverResult) {
	}

	@Override
	public void postconditionValidVerified(Postcondition postcondition, Validity validity, ProverResult proverResult) {
	}
}