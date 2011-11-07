package org.xtext.example.mydsl.interpreter;

import org.eclipse.emf.ecore.EObject;

import de.itemis.interpreter.AbstractExpressionEvaluator;
import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.InterpreterException;
import de.itemis.interpreter.logging.LogEntry;

public class MyDslEvaluator extends AbstractExpressionEvaluator {

	public MyDslEvaluator(ExecutionContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object eval(EObject arg0, LogEntry arg1) throws InterpreterException {
		// TODO Auto-generated method stub
		return null;
	}

}
