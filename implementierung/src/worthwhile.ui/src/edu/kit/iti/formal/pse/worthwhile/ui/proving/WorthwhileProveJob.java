package edu.kit.iti.formal.pse.worthwhile.ui.proving;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.IProverEventListener;
import edu.kit.iti.formal.pse.worthwhile.prover.ProverResult;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;
import edu.kit.iti.formal.pse.worthwhile.util.WorthwhileConstants;
import edu.kit.iti.formal.pse.worthwhile.util.WorthwhileMarkerHelper;

/**
 * A job for proving a program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileProveJob extends Job implements IProverEventListener {

	/**
	 * The specification checker to use.
	 */
	private final SpecificationChecker checker;

	/**
	 * The program to check.
	 */
	private final Program checkedProgram;

	/**
	 * The result of the prove process.
	 */
	private ProverResult proveResult;

	/**
	 * The resulting validity.
	 */
	private Validity validity;

	/**
	 * The marker helper for marking verified and failed statements.
	 */
	private final WorthwhileMarkerHelper markerHelper;

	/**
	 * Creates a new instance of the {@link WorthwhileProveJob} class.
	 * 
	 * @param name
	 *                The name of this prove job.
	 * @param checker
	 *                The specification checker to use.
	 * @param checkedProgram
	 *                The program to check.
	 * @param markerHelper
	 *                The marker helper for marking verified and failed statements.
	 */
	public WorthwhileProveJob(final String name, final SpecificationChecker checker, final Program checkedProgram,
	                final WorthwhileMarkerHelper markerHelper) {
		super(name);
		this.checker = checker;
		this.checkedProgram = checkedProgram;
		this.markerHelper = markerHelper;
	}

	@Override
	protected final IStatus run(final IProgressMonitor monitor) {
		this.checker.addProverEventListener(this);
		checker.checkProgram(this.checkedProgram);

		if (this.validity == null) {
			this.validity = Validity.UNKNOWN;
		}

		return new ProveResultStatus(this.proveResult, this.validity);
	}

	@Override
	public final void programVerified(final Program program, final Validity validity,
	                final ProverResult proverResult) {
		this.proveResult = proverResult;
		this.validity = validity;
	}

	@Override
	public final void assertionVerified(final Assertion assertion, final Validity validity,
	                final ProverResult proverResult) {
		this.markStatement(assertion, validity, proverResult.getOutput());
	}

	@Override
	public final void invariantValidAtEntryVerified(final Invariant invariant, final Validity validity,
	                final ProverResult proverResult) {
		this.markStatement(invariant, validity, proverResult.getOutput());
	}

	@Override
	public final void invariantAndConditionImplyLoopPreconditionVerified(final Loop loop, final Validity validity,
	                final ProverResult proverResult) {
		this.markStatement(loop, validity, proverResult.getOutput());
	}

	@Override
	public final void postconditionValidVerified(final Postcondition postcondition, final Validity validity,
	                final ProverResult proverResult) {
		this.markStatement(postcondition, validity, proverResult.getOutput());
	}

	/**
	 * Marks a statement as failed or succeeded. If the statement is already marked, it will only be re-marked if
	 * the validity gets "worse", i.e. from VALID to INVALID/UNKNOWN.
	 * 
	 * @param statement
	 *                The statement to mark
	 * @param validity
	 *                The validity of the statement
	 * @param message
	 *                An additional message.
	 */
	private void markStatement(final ASTNode statement, final Validity validity, final String message) {
		try {
			IMarker marker = this.markerHelper.getMarkerAt(statement);

			// Mark the statement if there is no mark or the validity gets worse.
			if (marker == null
			                || (marker.getType().equals(WorthwhileConstants.MARKER_SUCCEEDED_STATEMENT) && !validity
			                                .equals(Validity.VALID))) {

				switch (validity) {
					case VALID:
						this.markerHelper.markSucceededStatement(statement, message);
						break;
					case INVALID:
					case UNKNOWN:
						this.markerHelper.markFailedStatement(statement, message);
						break;
					default:
						break;
				}

			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
