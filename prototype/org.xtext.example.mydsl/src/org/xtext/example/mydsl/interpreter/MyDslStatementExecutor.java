package org.xtext.example.mydsl.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.xtext.example.mydsl.myDsl.Greeting;
import org.xtext.example.mydsl.myDsl.WhileStatement;

import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.logging.LogEntry;

public class MyDslStatementExecutor extends AbstractMyDslStatementExecutor {

	@Override
	public void execute(EObject statement, LogEntry parentLog)
			throws InterpreterException {
		// TODO Auto-generated method stub
		
		// Hier kommen nachher die Breakpoints rein
		System.out.println("MyDslStatementExecutor.execute(, " + statement.toString() + ")'");
		super.execute(statement, parentLog);
	}

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
