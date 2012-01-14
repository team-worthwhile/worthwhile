package edu.kit.iti.formal.pse.worthwhile.interpreter;

import static org.junit.Assert.*;
import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;
import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

public class InterpreterExecutionEventListenerTest {
	
	public boolean test;
	Interpreter interpreter;
	
	@Before
	public void intitialize() {
		this.test = false;
	}
	
	@Test
	public void testStatementExecuted() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void statementExecuted(Statement statement) {
				test = true;
			}
		};
		
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);
		//this.reset(new Interpreter(TestASTProvider.getRootASTNode("Integer a := 5\n")), listener);
		
	}
	
	@Test
	public void testStatementWillExecute() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void statementWillExecute(Statement statement) {
				test = true;
			}
		};
		
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}
	
	
	@Test
	public void testExecutionFailed() {
		AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			public void executionFailed(Statement statement, InterpreterError interpreterError) {
				test = true;
			}
		};
		
		this.reset(new Interpreter(TestASTProvider.getRootASTNode("Boolean a := true\n")), listener);
		this.interpreter.execute();
		assertTrue(this.test);
	}
	
	private void reset(Interpreter inter, AbstractExecutionEventListener listener ) {
		this.interpreter = inter;
		this.interpreter.addExecutionEventHandler(listener);
		this.test = false;
	}
}
