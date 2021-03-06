package org.xtext.example.mydsl.interpreter;

import org.xtext.example.mydsl.myDsl.Program;

import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.MessageList;
import de.itemis.interpreter.logging.LogEntry;
import de.itemis.xtext.typesystem.ITypesystem;

public class ExprModelInterpreter {

	public MessageList runProgram(Program p, ITypesystem ts) throws InterpreterException {
		ExecutionContext ctx = new ExecutionContext(ts);
		LogEntry log = LogEntry.root("running program "+p.toString());
		LogEntry.setMostRecentRoot(log);
		new MyDslEvaluator(ctx);
		new MyDslStatementExecutor(ctx).execute(p.getStatements(), log);
		// return a message list to be used e.g. by the UI
		System.out.println(log);
		return ctx.messages;
	}
	
}
