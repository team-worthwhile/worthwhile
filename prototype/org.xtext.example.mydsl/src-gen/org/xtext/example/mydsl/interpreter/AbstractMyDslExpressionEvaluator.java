
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

		
		
		throw new InterpreterException(expr, "generated eval(...) method cannot handle type "+expr.eClass().getName());
	}

	
	


}
