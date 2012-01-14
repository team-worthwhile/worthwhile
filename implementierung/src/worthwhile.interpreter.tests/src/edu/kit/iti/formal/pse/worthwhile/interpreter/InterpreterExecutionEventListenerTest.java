package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

public class InterpreterExecutionEventListenerTest {

	public boolean test;
	public int counter;
	Interpreter interpreter;

	@Before
	public void intitialize() {
		this.test = false;
	}

	private void testStatements(AbstractExecutionEventListener listener) {
		// Boolean VariableDeclaration
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n")), listener);
		assertFalse(this.test);
		this.interpreter.execute();
		assertTrue(this.test);

		// Integer VariableDeclaration
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\n")), listener);
		assertFalse(this.test);
		this.interpreter.execute();
		assertTrue(this.test);

		// Boolean Assignment
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\na := false\n")), listener);
		assertEquals(this.counter, 0);
		this.interpreter.execute();
		assertEquals(this.counter, 2);

		// Integer Assignment
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\na := 4\n")), listener);
		assertEquals(this.counter, 0);
		this.interpreter.execute();
		assertEquals(this.counter, 2);

		// Loop
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("while(false)\n")), listener);
		assertFalse(this.test);
		this.interpreter.execute();
		assertTrue(this.test);

		// Precondition Annotation
		this.reset(new Interpreter(TestASTProvider
		                .getRootASTNode("function Boolean test()\n_requires(true)\n{\n}\ntest()\n")), listener);
		assertEquals(this.counter, 0);
		this.interpreter.execute();
		assertEquals(this.counter, 2);

		// Postcondition Annotation
		this.reset(new Interpreter(TestASTProvider
		                .getRootASTNode("function Boolean test()\n{\n}\n_ensures(true)\ntest()\n")), listener);
		assertEquals(this.counter, 0);
		this.interpreter.execute();
		assertEquals(this.counter, 2);

		// Assertion Annotation
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("_assert(true)\n")), listener);
		assertFalse(this.test);
		this.interpreter.execute();
		assertTrue(this.test);

		// Assumption Annotation
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("_assume(true)\n")), listener);
		assertFalse(this.test);
		this.interpreter.execute();
		assertTrue(this.test);

		// Axiom Annotation
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("_axiom(true)\n")), listener);
		assertFalse(this.test);
		this.interpreter.execute();
		assertTrue(this.test);

		// Condition
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("if(true) {\n}\n")), listener);
		assertFalse(this.test);
		this.interpreter.execute();
		assertTrue(this.test);

		// Boolean ReturnStatement
		this.reset(new Interpreter(TestASTProvider
		                .getRootASTNode("function Boolean test() {\nreturn true\n}\ntest()\n")), listener);
		assertEquals(this.counter, 0);
		this.interpreter.execute();
		assertEquals(this.counter, 2);

		// Integer ReturnStatement
		this.reset(new Interpreter(TestASTProvider
		                .getRootASTNode("function Integer test() {\nreturn 3\n}\ntest()\n")), listener);
		assertEquals(this.counter, 0);
		this.interpreter.execute();
		assertEquals(this.counter, 2);
	}

	@Test
	public void testStatementExecuted() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void statementExecuted(Statement statement) {
				test = true;
				counter++;
			}
		};

		this.testStatements(listener);
	}

	@Test
	public void testStatementWillExecute() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void statementWillExecute(Statement statement) {
				test = true;
				counter++;
			}
		};

		this.testStatements(listener);

	}

	@Test
	public void testExecutionFailed() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void executionFailed(Statement statement, InterpreterError interpreterError) {
				test = true;
			}
		};
		// Check division by zero
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 ÷ 0 \n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);

		// Check modulo 0
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2 % 0 \n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}

	@Test
	public void testExecutionStarted() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void executionStarted() {
				test = true;
			}
		};
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2\n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}

	@Test
	public void testExecutionCompleted() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void executionStarted() {
				test = true;
			}
		};
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 2\n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}

	@Test
	public void testAssertionFailed() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void assertionFailed(Assertion assertion) {
				test = true;
			}
		};
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 10\n_assert(a > 10)")),
		                listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}

	@Test
	public void testAssertionSucceeded() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void assertionSucceeded(Assertion assertion) {
				test = true;
			}
		};
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 10\n_assert(a >= 10)")),
		                listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}

	@Test
	public void testExpressionEvaluated() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void expressionEvaluated(Expression expression) {
				test = true;
			}
		};
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 10\n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}

	private void reset(Interpreter inter, AbstractExecutionEventListener listener) {
		this.interpreter = inter;
		this.interpreter.addExecutionEventHandler(listener);
		this.test = false;
		this.counter = 0;
	}
}
