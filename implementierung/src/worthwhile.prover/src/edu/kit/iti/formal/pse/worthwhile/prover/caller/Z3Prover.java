package edu.kit.iti.formal.pse.worthwhile.prover.caller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.z3model.Z3ModelParser;
import edu.kit.iti.formal.pse.worthwhile.z3model.Z3ModelTransformer;

/**
 * Caller for the Z3 Prover by Microsoft Research.
 */
public class Z3Prover extends StdProver {
	/**
	 * Construct a new prover caller with the default Z3 command line.
	 * 
	 * The default Z3 command line is <code>z3 -in -smt2 -nw -m</code>.
	 * 
	 * @param timeout
	 *                the timeout after which to kill the prover
	 */
	public Z3Prover(final int timeout) {
		/* we will assume that z3 is in the PATH */
		this("z3", timeout);
	}

	/**
	 * Construct a new {@link Z3Prover} with the given Z3 binary path.
	 * 
	 * @param binary
	 *                the path that is executed to run the Z3 prover with the default parameters
	 *                <code>-in -smt2 -nw -m</code>
	 * @param timeout
	 *                the timeout after which to kill the prover
	 * 
	 */
	public Z3Prover(final String binary, final int timeout) {
		this(Arrays.asList(binary, "-in", "-smt2", "-nw", "-m"), timeout);
	}

	/**
	 * Construct a new {@link Z3Prover} with the given command line.
	 * 
	 * @param command
	 *                the command line that is executed to run the Z3 prover binary
	 * @param timeout
	 *                the timeout after which to kill the prover
	 */
	public Z3Prover(final List<String> command, final int timeout) {
		/* we will use SMTLib as the input format */
		super(command, new SMTLIBStrategy(), timeout);
	}

	@Override
	public final ProverResult getResult(final String output) {
		// Get the generated model from the output, if available
		if (output.contains("(model")) {
			String modelString = output.substring(output.indexOf("(model"));
			try {
	                        Program program = Z3ModelParser.parseExpressionString(modelString);
	                        program.accept(new Z3ModelTransformer());
	                        return new Z3ProverResult(output, program);
                        } catch (ParseException e) {
	                        e.printStackTrace();
	                        return new Z3ProverResult(output);
                        }
		} else {
			return new Z3ProverResult(output);
		}
	}
}