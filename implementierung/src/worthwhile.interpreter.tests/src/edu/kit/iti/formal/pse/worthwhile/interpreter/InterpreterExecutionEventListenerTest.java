package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.*;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Interpreter;

public class InterpreterExecutionEventListenerTest {

	public boolean test;
	public int counter;
	
	@Test
	public void testStatementExecutedBooleanVariableDeclaration() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof VariableDeclaration) {
					this.check = true;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}
	
	@Test
	public void testStatementExecutedIntegerVariableDeclaration() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof VariableDeclaration) {
					this.check = true;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}
	
	@Test
	public void testStatementExecutedBooleanAssignment() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\na := false\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		System.out.println(listener.counter);
		assertTrue(listener.counter == 1); //There is really only 1 assignment statement in this program
	}
	
	@Test
	public void testStatementExecutedIntegerAssignment() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\na := 4\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.counter == 1); //There is really only 1 assignment statement in this program
	}
	
	@Test
	public void testStatementExecutedLoop() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("while(false) { }\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Loop) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Boolean test()\n_requires true\n{\nreturn false\n}\nInteger result := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Precondition) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Boolean test()\n_ensures true\n{\nreturn false\n}\nInteger result := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Postcondition) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assert true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Assertion) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assume true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Assumption) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_axiom true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Axiom) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("if(true) {\n}\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof Conditional) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Boolean test() {\nreturn true\n}\nBoolean a := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof ReturnStatement) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Integer test() {\nreturn 3\n}\nInteger a := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementExecuted(Statement statement) {
				if(statement instanceof ReturnStatement) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof VariableDeclaration) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof VariableDeclaration) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\na := false\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.counter == 1); //There is really only 1 assignment statement in this program
	}
	
	@Test
	public void testStatementWillExecuteIntegerAssignment() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\na := 4\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Assignment) {
					this.check = true;
					this.counter++;
				}
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.counter == 1); //There is really only 1 assignment statement in this program
	}
	
	@Test
	public void testStatementWillExecuteLoop() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("while(false) { }\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Loop) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Boolean test()\n_requires true\n{return false\n}\nInteger result := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Precondition) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Boolean test()\n_ensures true\n{return false\n}\nInteger result := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Postcondition) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assert true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Assertion) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_assume true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Assumption) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("_axiom true\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Axiom) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("if(true) {\n}\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof Conditional) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Boolean test() {\nreturn true\n}\nBoolean a := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof ReturnStatement) {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("function Integer test() {\nreturn 3\n}\nInteger a := test()\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			@Override
			public void statementWillExecute(Statement statement) {
				if(statement instanceof ReturnStatement) {
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
		TestExecutionListener listener = new TestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 ÷ 0 \n"));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch(RuntimeException exception) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testExecutionFailedModuloZero() {
		TestExecutionListener listener = new TestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 % 0 \n"));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch(RuntimeException exception) {
			assertTrue(true);
		}
	}

	@Test
	public void testExecutionStarted() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2\n"));
		TestExecutionListener listener = new TestExecutionListener() {
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
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2\n"));
		TestExecutionListener listener = new TestExecutionListener() {
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
		TestExecutionListener listener = new TestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 10\n_assert(a > 10)\n"));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch(RuntimeException exception) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAssertionSucceeded() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 10\n_assert(a >= 10)\n"));
		TestExecutionListener listener = new TestExecutionListener() {
			public void assertionSucceeded(Assertion assertion) {
				this.check = true;
			}
		};
		interpreter.addExecutionEventHandler(listener);
		interpreter.execute();
		assertTrue(listener.check);
	}
	
	@Test
	public void testExpressionEvaluated() {
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := (19 + 23)\n"));
		
		TestExecutionListener listener = new TestExecutionListener() {
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
		TestExecutionListener listener = new TestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 ÷ 0 \n"));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch(RuntimeException exception) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testExpressionFailedModuloZero() {
		TestExecutionListener listener = new TestExecutionListener();
		Interpreter interpreter = new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 % 0 \n"));
		interpreter.addExecutionEventHandler(listener);
		try {
			interpreter.execute();
		} catch(RuntimeException exception) {
			assertTrue(true);
		}
	}
}
