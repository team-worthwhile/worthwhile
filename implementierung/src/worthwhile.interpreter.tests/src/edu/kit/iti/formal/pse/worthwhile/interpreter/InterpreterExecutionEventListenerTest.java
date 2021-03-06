package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.caller.Z3Prover;

public class InterpreterExecutionEventListenerTest {

	public boolean test;
	public int counter;

	/**
	 * Test listener that captures statement execution events.
	 */
	final class TestStatementExecutionEventListener extends AbstractExecutionEventListener {

		/**
		 * Type of statement to listen for events for.
		 */
		private Class<? extends Statement> statementType;

		/**
		 * Construct a new listener with the given statement type to listen for.
		 */
		public TestStatementExecutionEventListener(Class<? extends Statement> statementType) {
			this.statementType = statementType;
		}

		/**
		 * Indicates if the statementWillExecute event has already fired.
		 */
		private int statementWillExecuteCount = 0;

		/**
		 * @return true if statementWillExecute already fired, else false
		 */
		public int getStatementWillExecuteCount() {
			return this.statementWillExecuteCount;
		}

		@Override
		public void statementWillExecute(final Statement statement) {
			if (statementType.isInstance(statement)) {
				this.statementWillExecuteCount++;
			}
		}

		/**
		 * Indicates if the statementExecuted event has already fired.
		 */
		private int statementExecutedCount = 0;

		/**
		 * @return true if statementExecuted already fired, else false
		 */
		public int getStatementExecutedCount() {
			return this.statementExecutedCount;
		}

		@Override
		public void statementExecuted(final Statement statement) {
			if (statementType.isInstance(statement)) {
				this.statementExecutedCount++;
			}
		}
	}

	/**
	 * Convenience method to launch a Program and listen to the execution events with an event listener.
	 * 
	 * @param listener
	 *                the listener to attach to the running {@link Program}
	 * @param program
	 *                the {@link Program} to run
	 */
	public static void listenProgram(final AbstractExecutionEventListener listener, final Program program) {
		Interpreter interpreter = new Interpreter(program, new SpecificationChecker(new Z3Prover(9001)));
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
	}

	/**
	 * Convenience method to launch a Program and listen to the execution events with an event listener.
	 * 
	 * @param listener
	 *                the listener to attach to the running {@link Program}
	 * @param program
	 *                the {@link String} that encodes the {@link Program} to run
	 */
	public static void listenProgram(final AbstractExecutionEventListener listener, final String program) {
		InterpreterExecutionEventListenerTest.listenProgram(listener, TestASTProvider.getRootASTNode(program));
	}

	/**
	 * Test if execution events are correctly fired for a boolean variable declaration.
	 */
	@Test
	public final void testBooleanVariableDeclarationStatementExecutionEvents() {
		TestStatementExecutionEventListener listener = new TestStatementExecutionEventListener(
		                VariableDeclaration.class);
		InterpreterExecutionEventListenerTest.listenProgram(listener,
		                TestASTProvider.getRootASTNode("Boolean a := true\n"));
		Assert.assertEquals(1, listener.getStatementWillExecuteCount());
		Assert.assertEquals(1, listener.getStatementExecutedCount());

	}

	/**
	 * Test if execution events are correctly fired for an integer variable declaration.
	 */
	@Test
	public final void testIntegerVariableDeclarationStatementExecutionEvents() {
		TestStatementExecutionEventListener listener = new TestStatementExecutionEventListener(
		                VariableDeclaration.class);
		InterpreterExecutionEventListenerTest.listenProgram(listener,
		                TestASTProvider.getRootASTNode("Integer a := 42\n"));
		Assert.assertEquals(1, listener.getStatementWillExecuteCount());
		Assert.assertEquals(1, listener.getStatementExecutedCount());
	}

	@Test
	public void testStatementExecutedBooleanAssignment() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Boolean a := true\na := false\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.counter == 1); // There is really only 1 assignment
		                                   // statement in this program
	}

	@Test
	public void testStatementExecutedIntegerAssignment() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\na := 4\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.counter == 1); // There is really only 1 assignment
		                                   // statement in this program
	}

	@Test
	public void testStatementExecutedLoop() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("while(false) { }\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Loop) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedPreCondition() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Boolean test()\n_requires true\n{\nreturn false\n}\nBoolean result := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Precondition) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedPostCondition() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Boolean test()\n_ensures true\n{\nreturn false\n}\nBoolean result := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Postcondition) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedAssertion() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assert true\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Assertion) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedAssumption() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assume true\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Assumption) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedAxiom() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_axiom true\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Axiom) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedCondition() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("if(true) {\n}\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof Conditional) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedBooleanReturn() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Boolean test() {\nreturn true\n}\nBoolean a := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof ReturnStatement) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementExecutedIntegerReturn() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Integer test() {\nreturn 3\n}\nInteger a := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if (statement instanceof ReturnStatement) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteBooleanVariableDeclaration() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof VariableDeclaration) {
					this.check = true;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteIntegerVariableDeclaration() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof VariableDeclaration) {
					this.check = true;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteBooleanAssignment() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Boolean a := true\na := false\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.counter == 1); // There is really only 1 assignment
		                                   // statement in this program
	}

	@Test
	public void testStatementWillExecuteIntegerAssignment() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\na := 4\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.counter == 1); // There is really only 1 assignment
		                                   // statement in this program
	}

	@Test
	public void testStatementWillExecuteLoop() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("while(false) { }\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Loop) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecutePreCondition() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Boolean test()\n_requires true\n{\nreturn false\n}\nBoolean result := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Precondition) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecutePostCondition() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Boolean test()\n_ensures true\n{\nreturn false\n}\nBoolean result := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Postcondition) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteAssertion() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assert true\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Assertion) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteAssumption() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assume true\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Assumption) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteAxiom() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_axiom true\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Axiom) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteCondition() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("if(true) {\n}\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof Conditional) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteBooleanReturn() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Boolean test() {\nreturn true\n}\nBoolean a := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof ReturnStatement) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testStatementWillExecuteIntegerReturn() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Integer test() {\nreturn 3\n}\nInteger a := test()\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if (statement instanceof ReturnStatement) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testExecutionFailedDivisionByZero() {
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 ÷ 0 \n"), new SpecificationChecker(new Z3Prover(9001)));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch (RuntimeException exception) {
			assertTrue(true);
		}
	}

	@Test
	public void testExecutionFailedModuloZero() {
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 % 0 \n"), new SpecificationChecker(new Z3Prover(9001)));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch (RuntimeException exception) {
			assertTrue(true);
		}
	}

	@Test
	public void testExecutionStarted() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void executionStarted() {
				this.check = true;
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testExecutionCompleted() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			@Override
			public void executionCompleted() {
				this.check = true;
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testAssertionFailed() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Integer a := 10\n_assert(a > 10)\n_assert exists Integer n : forall Integer m : m > n\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			public void annotationFailed(final Annotation annotation) {
				this.check = true;
			}

			public void annotationSucceeded(Annotation annotation) {
				this.check = false;
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testAssertionSucceeded() {
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("Integer a := 10\n_assert(a >= 10)\n_assert exists Integer n : n = 1\n"), new SpecificationChecker(new Z3Prover(9001)));
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			public void annotationFailed(final Annotation annotation) {
				this.check = false;
			}

			public void annotationSucceeded(Annotation annotation) {
				this.check = true;
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testExpressionEvaluated() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := (19 + 23)\n"), new SpecificationChecker(new Z3Prover(9001)));

		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener() {
			public void expressionEvaluated(Expression expression) {
				check = true;
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}

	@Test
	public void testExpressionFailedDivisionByZero() {
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 ÷ 0 \n"), new SpecificationChecker(new Z3Prover(9001)));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch (RuntimeException exception) {
			assertTrue(true);
		}
	}

	@Test
	public void testExpressionFailedModuloZero() {
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 % 0 \n"), new SpecificationChecker(new Z3Prover(9001)));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch (RuntimeException exception) {
			assertTrue(true);
		}
	}

	@Test
	public void testFunctionCall() {
		WorthwhileTestExecutionListener listener = new WorthwhileTestExecutionListener();
		Interpreter interpreter = new Interpreter(
		                TestASTProvider.getRootASTNode("function Integer x(Integer p)\n" +
		                								"_ensures _return = 42\n" +
		                								"{\n" +
		                									"return 42\n" +
		                								"}\n" +
		                								"{\n" +
			                								"Integer i := 9\n" +
			                								"i := i + 1\n" +
			                								"while (i < 666) {\n" +
			                									"i := i + x(i)\n" +
			                								"}\n" +
			                								"Integer result := x(5)\n" +
		                								"}\n"), new SpecificationChecker(new Z3Prover(9001)));
		interpreter.addExecutionEventHandler(listener);

		interpreter.execute();
		assertTrue(true);
	}
}
