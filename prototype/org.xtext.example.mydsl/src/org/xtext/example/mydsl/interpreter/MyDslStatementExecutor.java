package org.xtext.example.mydsl.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.xtext.example.mydsl.myDsl.Assignment;
import org.xtext.example.mydsl.myDsl.Block;
import org.xtext.example.mydsl.myDsl.Expression;
import org.xtext.example.mydsl.myDsl.IfStatement;
import org.xtext.example.mydsl.myDsl.VariableDeclaration;
import org.xtext.example.mydsl.myDsl.WhileStatement;

import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.logging.LogEntry;

public class MyDslStatementExecutor extends AbstractMyDslStatementExecutor {

	public MyDslStatementExecutor(ExecutionContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(EObject statement, LogEntry parentLog)
			throws InterpreterException {
		// TODO Auto-generated method stub
		
		// Hier kommen nachher die Breakpoints rein
		System.out.println("MyDslStatementExecutor.execute(, " + statement.toString() + ")'");
		super.execute(statement, parentLog);
	}
	
	protected void executeBlock( Block s, LogEntry log )  throws InterpreterException{
		ctx.getExecutor().execute(s.getStatements(), log);
	}
	
	@Override
	protected void executeVariableDeclaration( VariableDeclaration s, LogEntry log )  throws InterpreterException {
		// Variables are indexed by name
		ctx.environment.put(s.getName(), ctx.getEvaluator().eval(s.getInitialValue(), log));
	}
	
	@Override
	protected void executeAssignment( Assignment s, LogEntry log )  throws InterpreterException {
		ctx.environment.put(s.getVariable().getVariable().getName(), ctx.getEvaluator().eval(s.getValue(), log));
	}
	
	@Override
	protected void executeWhileStatement( WhileStatement s, LogEntry log )  throws InterpreterException {
		while (true) {
			Object e = ctx.getEvaluator().eval(((Expression)s.getCondition()).getExpr(), log);
			if (!(e instanceof Boolean)) {
				throw new InterpreterException(s.getCondition(), "while statement requires a boolean condition!");
			}
			// check if the expression evaluates to false - if so, kill the loop
			if (((Boolean) e).booleanValue() == false)
				break;
			
			// everything seems fine, so let's execute what's inside!
			//ctx.environment.push("while " + s.getCondition().toString());
			ctx.getExecutor().execute(s.getBody(), log);
			//ctx.environment.pop();
			
		}
	}
	
	@Override
	protected void executeIfStatement( IfStatement s, LogEntry log )  throws InterpreterException {
		Object e = ctx.getEvaluator().eval(((Expression) s.getCondition()).getExpr(), log);
		if (!(e instanceof Boolean)) {
			throw new InterpreterException(s.getCondition(), "if statement requires a boolean condition!");
		}
		
		if (((Boolean) e).booleanValue()) {
			ctx.getExecutor().execute(s.getThen(), log);
		} else {
			ctx.getExecutor().execute(s.getElse(), log);
		}	
	}
	
	
}
