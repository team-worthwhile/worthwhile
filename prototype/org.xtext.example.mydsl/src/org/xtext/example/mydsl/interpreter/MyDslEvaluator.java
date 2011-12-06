package org.xtext.example.mydsl.interpreter;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;
import org.xtext.example.mydsl.myDsl.BooleanLiteral;
import org.xtext.example.mydsl.myDsl.Equals;
import org.xtext.example.mydsl.myDsl.FalseLiteral;
import org.xtext.example.mydsl.myDsl.Multi;
import org.xtext.example.mydsl.myDsl.NumberLiteral;
import org.xtext.example.mydsl.myDsl.Plus;
import org.xtext.example.mydsl.myDsl.TrueLiteral;
import org.xtext.example.mydsl.myDsl.VariableRef;

import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.logging.LogEntry;

public class MyDslEvaluator extends AbstractMyDslExpressionEvaluator {
	
	public MyDslEvaluator(ExecutionContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	public Object eval( EObject expr, LogEntry parentLog ) throws InterpreterException {
		Object r = super.eval(expr, parentLog);
		System.out.println(expr.toString()  + " evaluated to " + r);
		return r;
	}
	
	/*@Override
	protected Object evalFunctionRef( FunctionRef expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalFunctionRef not implemented");
	}
	
	@Override
	protected Object evalFunctionCall( FunctionCall expr, LogEntry log )  throws InterpreterException {
		throw new MethodNotImplementedException(expr, "method evalFunctionCall not implemented");
	}*/
	
	@Override
	protected Object evalFalseLiteral( FalseLiteral expr, LogEntry log )  throws InterpreterException {
		return new Boolean(false);
	} 

	@Override
	protected Object evalTrueLiteral( TrueLiteral expr, LogEntry log )  throws InterpreterException {
		return new Boolean(true);
	} 

	@Override
	protected Object evalBooleanLiteral( BooleanLiteral expr, LogEntry log )  throws InterpreterException {
		return ctx.getEvaluator().eval(expr.getExpr(), log);
	} 

	@Override
	protected Object evalVariableRef( VariableRef expr, LogEntry log )  throws InterpreterException {
		// return the value stored in the context under this name
		return ctx.environment.get(expr.getVariable().getName());
	} 

	@Override
	protected Object evalEquals( Equals expr, LogEntry log )  throws InterpreterException {
		Object l = ctx.getEvaluator().eval(expr.getLeft(), log);
		Object r = ctx.getEvaluator().eval(expr.getRight(), log);
		
		return new Boolean(l.equals(r));
	}

	@Override
	protected Object evalPlus( Plus expr, LogEntry log )  throws InterpreterException {
		Object l = ctx.getEvaluator().eval(expr.getLeft(), log);
		Object r = ctx.getEvaluator().eval(expr.getRight(), log);
		if (!(l instanceof BigInteger && r instanceof BigInteger)) {
			throw new InterpreterException(expr, "Only Integers can be added!");
		}
		return ((BigInteger) l).add((BigInteger) r);
	} 

	@Override
	protected Object evalMulti( Multi expr, LogEntry log )  throws InterpreterException {
		Object l = ctx.getEvaluator().eval(expr.getLeft(), log);
		Object r = ctx.getEvaluator().eval(expr.getRight(), log);
		if (!(l instanceof BigInteger && r instanceof BigInteger)) {
			throw new InterpreterException(expr, "Only Integers can be multiplied!");
		}
		return ((BigInteger) l).multiply((BigInteger) r);
	} 

	@Override
	protected Object evalNumberLiteral( NumberLiteral expr, LogEntry log )  throws InterpreterException {
		return new BigInteger(String.valueOf(expr.getValue()));
	}

}
