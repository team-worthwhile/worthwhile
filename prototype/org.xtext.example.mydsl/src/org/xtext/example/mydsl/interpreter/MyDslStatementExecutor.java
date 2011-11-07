package org.xtext.example.mydsl.interpreter;

import org.eclipse.emf.ecore.EObject;

import de.itemis.interpreter.AbstractStatementExecutor;
import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.logging.LogEntry;

public class MyDslStatementExecutor extends AbstractStatementExecutor {

	public MyDslStatementExecutor(ExecutionContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(EObject arg0, LogEntry arg1)
			throws InterpreterException {
		// TODO Auto-generated method stub

	}

}
