package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;

public class InterpreterValueTest {

	@Test
	public void testArrayAssignments() {
		Program testProgram = TestASTProvider
		                .getRootASTNode("Integer[] j := {1, 2, 43}\nj[5] := 9\n_assert j[2] ≠ 9\n");
		Interpreter interpreter = new Interpreter(testProgram, new SpecificationChecker());
		TestExecutionListener listener = new TestExecutionListener() {

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
	
}
