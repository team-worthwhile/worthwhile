package org.xtext.example.mydsl.interpreter;

import org.xtext.example.mydsl.myDsl.Model;

import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.xtext.typesystem.ITypesystem;

public class ExprModelInterpreter {

	public void runModel(Model m, ITypesystem ts) throws InterpreterException {
		ExecutionContext ctx = new ExecutionContext(ts);
		new MyDslEvaluator(ctx);
		new MyDslStatementExecutor(ctx).execute(m.getStatements(), null);
	}
	
}
