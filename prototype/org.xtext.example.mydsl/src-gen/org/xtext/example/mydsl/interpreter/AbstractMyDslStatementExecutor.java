
package org.xtext.example.mydsl.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.xtext.example.mydsl.myDsl.*; 

import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.MethodNotImplementedException;
import de.itemis.interpreter.AbstractStatementExecutor;
import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.logging.LogEntry;
import de.itemis.interpreter.AbstractExpressionEvaluator;


public abstract class AbstractMyDslStatementExecutor extends AbstractStatementExecutor {

	public AbstractMyDslStatementExecutor( ExecutionContext ctx ) {
		super(ctx);
	}

	public void execute( EObject statement, LogEntry parentLog ) throws InterpreterException {
		
		LogEntry localLog = log( statement, parentLog );
	
		
		if ( statement instanceof WhileStatement ) {
			executeWhileStatement( (WhileStatement)statement, localLog );
			return;
		}
		
		if ( statement instanceof Greeting ) {
			executeGreeting( (Greeting)statement, localLog );
			return;
		}
		
		
		throw new InterpreterException(statement, "generated execute(...) method cannot handle type "+statement.eClass().getName());
		
	}

	
	
	protected void executeWhileStatement( WhileStatement s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeWhileStatement not implemented");
	} 
	
	protected void executeGreeting( Greeting s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeGreeting not implemented");
	} 
	


}
