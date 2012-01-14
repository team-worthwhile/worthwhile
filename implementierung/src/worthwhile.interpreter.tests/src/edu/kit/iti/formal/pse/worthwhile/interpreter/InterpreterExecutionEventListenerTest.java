package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

public class InterpreterExecutionEventListenerTest {
	
	public boolean test;
	public Interpreter interpreter;
	public AbstractExecutionEventListener listener;
	
	@Before
	public void intitialize() {
		this.interpreter = new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n"));
		this.test = false;
		this.listener = new AbstractExecutionEventListener() {
			public void statementExecuted(Statement statement) {
				test = true;
			}
			public void statementWillExecute(Statement statement) {
				test = true;
			}
			public void executionFailed(Statement statement, InterpreterError error) {
				test = true;
			}
		};
	}
	
	@Test
	public void testStatementExuted() {	
		this.interpreter.addExecutionEventHandler(this.listener);
		this.interpreter.execute();
		assertTrue(this.test);
		reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\n")), this.listener);
		
	}
	
	@Test
	public void testStatementWillExecuted() {
		this.interpreter.addExecutionEventHandler(this.listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}
	
	
	@Test
	public void testExecutionFailed() {	
		this.interpreter.addExecutionEventHandler(this.listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}
	
	private void reset(Interpreter inter, AbstractExecutionEventListener listener ) {
		this.interpreter = inter;
		this.interpreter.addExecutionEventHandler(listener);
		this.test = false;
	}
}
