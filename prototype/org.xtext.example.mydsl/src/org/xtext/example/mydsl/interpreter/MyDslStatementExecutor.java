package org.xtext.example.mydsl.interpreter;

import org.eclipse.emf.ecore.EObject;

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

	public MyDslStatementExecutor(ExecutionContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
}
