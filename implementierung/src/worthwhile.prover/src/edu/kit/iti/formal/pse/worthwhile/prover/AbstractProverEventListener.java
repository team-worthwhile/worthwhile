package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * A no-op default implementation of {@link IProverEventListener}.
 * 
 * @author Joachim
 * 
 */
public abstract class AbstractProverEventListener implements IProverEventListener {

	@Override
	public void programVerified(final Program program, final Validity validity, final ProverResult proverResult) {
	}
}