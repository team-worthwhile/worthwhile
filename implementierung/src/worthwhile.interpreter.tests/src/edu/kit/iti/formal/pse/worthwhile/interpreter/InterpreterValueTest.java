package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Z3Prover;

public class InterpreterValueTest {

	@Test
	public void testArrayAssignments() {
		Program testProgram = TestASTProvider
		                .getRootASTNode("Integer[] j := {1, 2, 43}\nj[5] := 9\n_assert j[2] ≠ 9\n");
		Interpreter interpreter = new Interpreter(testProgram, new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {

			@Override
			public void annotationSucceeded(Annotation annotation) {
				this.check = true;
			}

			@Override
			public void annotationFailed(Annotation annotation) {
				this.check = false;
			}

		};
		interpreter.addExecutionEventHandler(listener);

		interpreter.execute();
		assertEquals(true, listener.check);
	}

	@Test
	public void testReturnStatmentExit() throws IOException {
		// the testFunction should return after the first return statement, so it should return 20.
		Program program = TestASTProvider
		                .getRootASTNode("function Integer testFunction () {\n if (true) {\n return 20\n}\n return 10\n return 0\n }\n Integer a := testFunction()\n");
		final Interpreter interpreter = new Interpreter(program, new SpecificationChecker(new Z3Prover(9001)));

		interpreter.addExecutionEventHandler(new AbstractExecutionEventListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (interpreter.getSymbol("a") != null) {
					Assert.assertTrue(interpreter.getSymbol("a") instanceof IntegerValue);
					Assert.assertEquals(new BigInteger("20"),
					                ((IntegerValue) interpreter.getSymbol("a")).getValue());
				}
			}
		});
		interpreter.execute();

	}
}
