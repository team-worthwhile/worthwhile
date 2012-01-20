package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import edu.kit.iti.formal.pse.worthwhile.model.Value;

public class WorthwhileValue extends WorthwhileDebugElement implements IValue {

	/**
	 * The value represented by this object.
	 */
	private final Value value;

	/**
	 * Creates a new instance of the {@link WorthwhileValue} class.
	 * 
	 * @param debugTarget
	 *                The debug target this object belongs to
	 * @param value
	 *                The value represented by this object.
	 */
	public WorthwhileValue(final WorthwhileDebugTarget debugTarget, final Value value) {
		super(debugTarget);
		this.value = value;
	}

	@Override
	public final String getReferenceTypeName() throws DebugException {
		return ""; // return this.value.getValueType().toString();
	}

	@Override
	public final String getValueString() throws DebugException {
		return this.value.toString();
	}

	@Override
	public final boolean isAllocated() throws DebugException {
		return true;
	}

	@Override
	public final IVariable[] getVariables() throws DebugException {
		// TODO Auto-generated method stub
		return new IVariable[0];
	}

	@Override
	public final boolean hasVariables() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

}
