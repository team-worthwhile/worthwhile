
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
	
		
		if ( statement instanceof FunctionRef ) {
			executeFunctionRef( (FunctionRef)statement, localLog );
			return;
		}
		
		if ( statement instanceof FunctionCall ) {
			executeFunctionCall( (FunctionCall)statement, localLog );
			return;
		}
		
		if ( statement instanceof Parameter ) {
			executeParameter( (Parameter)statement, localLog );
			return;
		}
		
		if ( statement instanceof Block ) {
			executeBlock( (Block)statement, localLog );
			return;
		}
		
		if ( statement instanceof ReturnStatement ) {
			executeReturnStatement( (ReturnStatement)statement, localLog );
			return;
		}
		
		if ( statement instanceof WhileStatement ) {
			executeWhileStatement( (WhileStatement)statement, localLog );
			return;
		}
		
		if ( statement instanceof IfStatement ) {
			executeIfStatement( (IfStatement)statement, localLog );
			return;
		}
		
		if ( statement instanceof Variable ) {
			executeVariable( (Variable)statement, localLog );
			return;
		}
		
		if ( statement instanceof Annotation ) {
			executeAnnotation( (Annotation)statement, localLog );
			return;
		}
		
		if ( statement instanceof Assignment ) {
			executeAssignment( (Assignment)statement, localLog );
			return;
		}
		
		
		throw new InterpreterException(statement, "generated execute(...) method cannot handle type "+statement.eClass().getName());
		
	}

	
	
	protected void executeFunctionRef( FunctionRef s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeFunctionRef not implemented");
	} 
	
	protected void executeFunctionCall( FunctionCall s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeFunctionCall not implemented");
	} 
	
	protected void executeParameter( Parameter s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeParameter not implemented");
	} 
	
	protected void executeBlock( Block s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeBlock not implemented");
	} 
	
	protected void executeReturnStatement( ReturnStatement s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeReturnStatement not implemented");
	} 
	
	protected void executeWhileStatement( WhileStatement s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeWhileStatement not implemented");
	} 
	
	protected void executeIfStatement( IfStatement s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeIfStatement not implemented");
	} 
	
	protected void executeVariable( Variable s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeVariable not implemented");
	} 
	
	protected void executeAnnotation( Annotation s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeAnnotation not implemented");
	} 
	
	protected void executeAssignment( Assignment s, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(s, "method executeAssignment not implemented");
	} 
	


}
