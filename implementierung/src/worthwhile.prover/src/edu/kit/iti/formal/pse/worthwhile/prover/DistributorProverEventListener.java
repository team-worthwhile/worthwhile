package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashSet;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Distributes events to multiple event listeners.
 * 
 * @author Leon Handreke
 * 
 */
public class DistributorProverEventListener extends AbstractProverEventListener {

	/**
	 * Set of {@link AbstractProverEventListener}s that all events should be distributed to.
	 */
	private Set<IProverEventListener> listeners = new HashSet<IProverEventListener>();

	/**
	 * Add a listener to the set of listeners that all events shall be distributed to.
	 * 
	 * @param proverEventListener
	 *                the event listener that shall be added
	 * @return true if the listener was successfully added, else false
	 */
	public final boolean addProverEventListener(final IProverEventListener proverEventListener) {
		return this.listeners.add(proverEventListener);
	}

	/**
	 * Remove a listener to the set of listeners that all events shall be distributed to.
	 * 
	 * @param proverEventListener
	 *                the event listener that shall be removed
	 * @return true if the listener was successfully removed, else false
	 */
	public final boolean removeProverEventListener(final IProverEventListener proverEventListener) {
		return this.listeners.remove(proverEventListener);
	}

	@Override
	public final void programVerified(final Program program, final Validity validity,
	                final ProverResult proverResult) {
		for (IProverEventListener l : this.listeners) {
			l.programVerified(program, validity, proverResult);
		}
	}

	@Override
	public void assertionVerified(Assertion assertion, Validity validity, ProverResult proverResult) {
		for (IProverEventListener l : this.listeners) {
			l.assertionVerified(assertion, validity, proverResult);
		}

	}

	@Override
	public void invariantValidAtEntryVerified(Invariant invariant, Validity validity, ProverResult proverResult) {
		for (IProverEventListener l : this.listeners) {
			l.invariantValidAtEntryVerified(invariant, validity, proverResult);
		}
	}

	@Override
	public void invariantAndConditionImplyLoopPreconditionVerified(Loop loop, Validity validity,
	                ProverResult proverResult) {
		for (IProverEventListener l : this.listeners) {
			l.invariantAndConditionImplyLoopPreconditionVerified(loop, validity, proverResult);
		}
	}

	@Override
	public void postconditionValidVerified(Postcondition postcondition, Validity validity, ProverResult proverResult) {
		for (IProverEventListener l : this.listeners) {
			l.postconditionValidVerified(postcondition, validity, proverResult);
		}
	}
}
