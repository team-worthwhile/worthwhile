package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import edu.kit.iti.formal.pse.worthwhile.model.Value;

/**
 * Represents a variable in a suspended Worthwhile program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileVariable extends WorthwhileDebugElement implements IVariable {

	/**
	 * The name of this variable.
	 */
	private final String name;

	/**
	 * Creates a new instance of the {@link WorthwhileVariable} class.
	 * 
	 * @param debugTarget
	 * @param name
	 */
	public WorthwhileVariable(final WorthwhileDebugTarget debugTarget, final String name) {
		super(debugTarget);
		this.name = name;
	}

	@Override
        public final void setValue(final String expression) throws DebugException {
		// TODO Auto-generated method stub
		Value value = this.getDebugTarget().evaluateExpression(expression);
		System.out.println(value.toString());
	}

	@Override
	public void setValue(final IValue value) throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public final boolean supportsValueModification() {
		return true;
	}

	@Override
	public final boolean verifyValue(final String expression) throws DebugException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public final boolean verifyValue(final IValue value) throws DebugException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public final IValue getValue() throws DebugException {
		return this.getDebugTarget().getVariableValue(this.name);
	}

	@Override
	public final String getName() throws DebugException {
		return this.name;
	}

	@Override
	public final String getReferenceTypeName() throws DebugException {
		return this.getValue().getReferenceTypeName();
	}

	@Override
	public final boolean hasValueChanged() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

}
