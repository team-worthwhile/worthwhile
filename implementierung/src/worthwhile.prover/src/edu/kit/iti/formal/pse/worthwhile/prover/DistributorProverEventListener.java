package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashSet;
import java.util.Set;

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
	public final void programVerified(final Program program, final Validity validity, final ProverResult proverResult) {
		for (IProverEventListener l : this.listeners) {
			l.programVerified(program, validity, proverResult);
		}
	}
}
