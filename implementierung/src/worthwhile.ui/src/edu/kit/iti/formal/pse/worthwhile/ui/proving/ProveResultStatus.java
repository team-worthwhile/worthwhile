package edu.kit.iti.formal.pse.worthwhile.ui.proving;

import org.eclipse.core.runtime.IStatus;

import edu.kit.iti.formal.pse.worthwhile.prover.ProverResult;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;

/**
 * A status representing the validity of a checked program.
 * 
 * @author Joachim
 * 
 */
public class ProveResultStatus implements IStatus {

	/**
	 * The prover result.
	 */
	private final ProverResult proverResult;

	/**
	 * The validity represented by this status.
	 */
	private final Validity validity;

	/**
	 * Creates a new instance of the {@link ProveResultStatus} class.
	 * 
	 * @param proverResult
	 *                The prover result.
	 * @param validity
	 *                The validity represented by this status.
	 */
	public ProveResultStatus(final ProverResult proverResult, final Validity validity) {
		this.proverResult = proverResult;
		this.validity = validity;
	}

	@Override
	public final IStatus[] getChildren() {
		return new IStatus[0];
	}

	@Override
	public final int getCode() {
		return this.validity.ordinal();
	}

	@Override
	public final Throwable getException() {
		return null;
	}

	@Override
	public final String getMessage() {
		if (this.proverResult == null) {
			return this.validity.name();
		} else {
			return this.proverResult.getOutput();
		}
	}

	@Override
	public final String getPlugin() {
		return "edu.kit.iti.formal.pse.worthwhile.prover";
	}

	@Override
	public final int getSeverity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public final boolean isMultiStatus() {
		return false;
	}

	@Override
	public final boolean isOK() {
		return this.validity.equals(Validity.VALID);
	}

	@Override
	public final boolean matches(final int severity) {
		return (severity & this.getSeverity()) == 0;
	}

}
