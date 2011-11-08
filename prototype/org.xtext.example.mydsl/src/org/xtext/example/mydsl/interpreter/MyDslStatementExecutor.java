package org.xtext.example.mydsl.interpreter;

import org.xtext.example.mydsl.myDsl.Greeting;
import org.xtext.example.mydsl.myDsl.WhileStatement;

import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.logging.LogEntry;

public class MyDslStatementExecutor extends AbstractMyDslStatementExecutor {

	@Override
	protected void executeWhileStatement(WhileStatement s, LogEntry log)
			throws InterpreterException {
		
			System.out.println("Simulating a while loop ...");
			
			for (int i = 0; i < 5; i++) {
				ctx.getExecutor().execute(s.getStatements(), log);
			}
	}

	@Override
	protected void executeGreeting(Greeting s, LogEntry log)
			throws InterpreterException {
		
			System.out.println("I hereby execute the greeting 'Hello, " + s.getName() + "!'");
	}

	public MyDslStatementExecutor(ExecutionContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
}
