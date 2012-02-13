package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestUtils;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;

public class InterpreterErrorTest {

	@Test
	public void TestUnknownValidityInterpreterError() throws IOException {
		Program program = TestASTProvider.getRootASTNode(TestUtils.loadTestProgram(this.getClass(), "fermat.ww"));
		Interpreter interpreter = new Interpreter(program, new SpecificationChecker());
		
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public final void expressionFailed(final Expression expression, final InterpreterError error) {
				this.check = true;
				assertNotNull(error);
				assertTrue(error instanceof UnknownValidityInterpreterError);
				assertFalse(error.getDescription().equals(""));
				assertNotNull(((StatementInterpreterError) error).getStatement());
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}
	
}
