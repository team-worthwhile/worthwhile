package edu.kit.iti.formal.pse.worthwhile.ui.proving;

import java.text.ParseException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import edu.kit.iti.formal.pse.worthwhile.debugger.model.WorthwhileProverMarkerHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeToStringHelper;
import edu.kit.iti.formal.pse.worthwhile.prover.IProverEventListener;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;
import edu.kit.iti.formal.pse.worthwhile.prover.caller.ProverResult;
import edu.kit.iti.formal.pse.worthwhile.z3model.Z3ModelParser;
import edu.kit.iti.formal.pse.worthwhile.z3model.Z3ModelToStringHelper;

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
	private final WorthwhileProverMarkerHelper markerHelper;

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
	                final WorthwhileProverMarkerHelper markerHelper) {
		super(name);
		this.checker = checker;
		this.checkedProgram = checkedProgram;
		this.markerHelper = markerHelper;
	}

	@Override
	protected final IStatus run(final IProgressMonitor monitor) {
		// Clear all problem markers
		this.markerHelper.getMarkerHelper().clearMarkers();

		this.checker.addProverEventListener(this);
		checker.checkProgram(this.checkedProgram);

		if (this.validity == null) {
			this.validity = Validity.UNKNOWN;
		}

		return new ProveResultStatus(this.proveResult, this.validity);
	}

	/**
	 * Convenience method to generate a user-facing message describing a proof attempt.
	 * 
	 * @param validity
	 *                the validity of the formula that was proven
	 * @param formula
	 *                the formula that was proven
	 * @param proverResult
	 *                the {@link ProverResult} returned by the prover
	 * @return a human-readable tooltip message
	 */
	private static String getTooltipMessage(final Validity validity, final Expression formula,
	                final ProverResult proverResult) {
		String formulaString = AstNodeToStringHelper.toString(formula);
		String tooltipString = formulaString
		                + "\n\nProof attempt for the calculated formula resulted in Validity "
		                + validity.toString() + "\n\n" + "Prover output was:\n" + proverResult.getOutput();
		
		if (proverResult.getOutput().contains("(model")) {
			String modelString = proverResult.getOutput().substring(proverResult.getOutput().indexOf("(model"));
			try {
				Program program = Z3ModelParser.parseExpressionString(modelString);
				tooltipString += "\n" + Z3ModelToStringHelper.toString(program);
			} catch (ParseException e) {
				tooltipString += "\nError parsing the model: " + e.getMessage(); 
			}
		}
		
		return tooltipString;
	}

	@Override
	public final void programVerified(final Program program, final Validity validity, final Expression formula,
	                final ProverResult proverResult) {
		this.proveResult = proverResult;
		this.validity = validity;
	}

	@Override
	public final void assertionVerified(final Assertion assertion, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
		this.markerHelper.markStatement(this.getStatementToMark(assertion), validity,
		                "Verifying assertion:\n\n" + getTooltipMessage(validity, formula, proverResult));
	}

	@Override
	public final void invariantValidAtEntryVerified(final Invariant invariant, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
		this.markerHelper.markStatement(
		                this.getStatementToMark(invariant),
		                validity,
		                "Verifying that invariant holds at loop entry:\n\n"
		                                + getTooltipMessage(validity, formula, proverResult));
	}

	@Override
	public final void invariantAndConditionImplyLoopPreconditionVerified(final Loop loop, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
		this.markerHelper.markStatement(this.getStatementToMark(loop), validity,
		                "Verifying that invariant and loop condition imply the loop body’s postcondition:\n\n"
		                                + getTooltipMessage(validity, formula, proverResult));
	}

	@Override
	public final void postconditionValidVerified(final Postcondition postcondition, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
		this.markerHelper.markStatement(
		                this.getStatementToMark(postcondition),
		                validity,
		                "Verifying that the postcondition holds:\n\n"
		                                + getTooltipMessage(validity, formula, proverResult));
	}

	@Override
	public final void divisorNotZeroVerified(final Expression divisor, final Validity validity,
	                final Expression formula, final ProverResult proverResult) {
		this.markerHelper.markStatement(
		                this.getStatementToMark(divisor),
		                validity,
		                "Verifying that the divisor " + AstNodeToStringHelper.toString(divisor)
		                                + " is not equal to 0:\n\n"
		                                + getTooltipMessage(validity, formula, proverResult));

	}

	@Override
	public final void functionCallPreconditionValidVerified(final FunctionCall functionCall,
	                final Validity validity, final Expression formula, final ProverResult proverResult) {
		this.markerHelper.markStatement(this.getStatementToMark(functionCall), validity,
		                "Verifying that the function precondition holds before the function call:\n\n"
		                                + getTooltipMessage(validity, formula, proverResult));
	}

	/**
	 * Gets the statement to be marked in the UI when the prover reports a verified assertion on this statement.
	 * 
	 * @param statement
	 *                The statement that the prover marks as verified
	 * @return The statement to be marked in the UI
	 */
	private ASTNode getStatementToMark(final ASTNode statement) {
		if (statement instanceof Loop) {
			return ((Loop) statement).getCondition();
		} else {
			return statement;
		}
	}
}
