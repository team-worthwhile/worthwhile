
package org.xtext.example.mydsl.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.xtext.example.mydsl.myDsl.*; 

import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.MethodNotImplementedException;
import de.itemis.interpreter.AbstractExpressionEvaluator;
import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.logging.LogEntry;


public abstract class AbstractMyDslExpressionEvaluator extends AbstractExpressionEvaluator {

	public AbstractMyDslExpressionEvaluator( ExecutionContext ctx ) {
		super(ctx);
	}

	public Object eval( EObject expr, LogEntry parentLog ) throws InterpreterException {

		LogEntry localLog = parentLog.child(LogEntry.Kind.eval, expr, "evaluating "+expr.eClass().getName());

		
		if ( expr instanceof FunctionRef ) {
			return evalFunctionRef( (FunctionRef)expr, localLog );
		}
		
		if ( expr instanceof FunctionCall ) {
			return evalFunctionCall( (FunctionCall)expr, localLog );
		}
		
		if ( expr instanceof FalseLiteral ) {
			return evalFalseLiteral( (FalseLiteral)expr, localLog );
		}
		
		if ( expr instanceof TrueLiteral ) {
			return evalTrueLiteral( (TrueLiteral)expr, localLog );
		}
		
		if ( expr instanceof BooleanLiteral ) {
			return evalBooleanLiteral( (BooleanLiteral)expr, localLog );
		}
		
		if ( expr instanceof VariableRef ) {
			return evalVariableRef( (VariableRef)expr, localLog );
		}
		
		if ( expr instanceof Equals ) {
			return evalEquals( (Equals)expr, localLog );
		}
		
		if ( expr instanceof Compare ) {
			return evalCompare( (Compare)expr, localLog );
		}
		
		if ( expr instanceof Plus ) {
			return evalPlus( (Plus)expr, localLog );
		}
		
		if ( expr instanceof Multi ) {
			return evalMulti( (Multi)expr, localLog );
		}
		
		if ( expr instanceof ArrayAccess ) {
			return evalArrayAccess( (ArrayAccess)expr, localLog );
		}
		
		if ( expr instanceof NumberLiteral ) {
			return evalNumberLiteral( (NumberLiteral)expr, localLog );
		}
		
		
		throw new InterpreterException(expr, "generated eval(...) method cannot handle type "+expr.eClass().getName());
	}

	
	
	protected Object evalFunctionRef( FunctionRef expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalFunctionRef not implemented");
	} 
	
	protected Object evalFunctionCall( FunctionCall expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalFunctionCall not implemented");
	} 
	
	protected Object evalFalseLiteral( FalseLiteral expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalFalseLiteral not implemented");
	} 
	
	protected Object evalTrueLiteral( TrueLiteral expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalTrueLiteral not implemented");
	} 
	
	protected Object evalBooleanLiteral( BooleanLiteral expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalBooleanLiteral not implemented");
	} 
	
	protected Object evalVariableRef( VariableRef expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalVariableRef not implemented");
	} 
	
	protected Object evalEquals( Equals expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalEquals not implemented");
	} 
	
	protected Object evalCompare( Compare expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalCompare not implemented");
	} 
	
	protected Object evalPlus( Plus expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalPlus not implemented");
	} 
	
	protected Object evalMulti( Multi expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalMulti not implemented");
	} 
	
	protected Object evalArrayAccess( ArrayAccess expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalArrayAccess not implemented");
	} 
	
	protected Object evalNumberLiteral( NumberLiteral expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalNumberLiteral not implemented");
	} 
	


}
