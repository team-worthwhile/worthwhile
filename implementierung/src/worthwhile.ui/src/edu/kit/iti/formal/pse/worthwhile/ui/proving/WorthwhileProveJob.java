package edu.kit.iti.formal.pse.worthwhile.ui.proving;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.IProverEventListener;
import edu.kit.iti.formal.pse.worthwhile.prover.ProverResult;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;

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
	 * Creates a new instance of the {@link WorthwhileProveJob} class.
	 * 
	 * @param name
	 *                The name of this prove job.
	 * @param checker
	 *                The specification checker to use.
	 * @param checkedProgram
	 *                The program to check.
	 */
	public WorthwhileProveJob(final String name, final SpecificationChecker checker, final Program checkedProgram) {
		super(name);
		this.checker = checker;
		this.checkedProgram = checkedProgram;
	}

	@Override
	protected final IStatus run(final IProgressMonitor monitor) {
		this.checker.addProverEventListener(this);
		checker.checkProgram(checkedProgram);
		
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

}
