package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import edu.kit.iti.formal.pse.worthwhile.model.ast.util.ValueTypeVisitor;

/**
 * Represents an entry of an array.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileArrayEntry extends WorthwhileDebugElement implements IVariable {

	/**
	 * The array this entry belongs to.
	 */
	private final IVariable parentVariable;

	/**
	 * The index of this array element.
	 */
	private final int index;

	/**
	 * The value of this array element.
	 */
	private final WorthwhileValue value;

	/**
	 * Creates a new instance of the {@link WorthwhileArrayEntry} class.
	 * 
	 * @param debugTarget
	 *                The debug target.
	 * @param parentVariable
	 *                The array this entry belongs to.
	 * @param index
	 *                The index of the array entry.
	 * @param value
	 *                The value of the array entry.
	 */
	public WorthwhileArrayEntry(final WorthwhileDebugTarget debugTarget, final IVariable parentVariable,
	                final int index, final WorthwhileValue value) {
		super(debugTarget);
		this.parentVariable = parentVariable;
		this.index = index;
		this.value = value;
	}

	@Override
	public void setValue(final String expression) throws DebugException {
	}

	@Override
	public void setValue(final IValue value) throws DebugException {
	}

	@Override
	public final boolean supportsValueModification() {
		return false;
	}

	@Override
	public final boolean verifyValue(final String expression) throws DebugException {
		return false;
	}

	@Override
	public final boolean verifyValue(final IValue value) throws DebugException {
		return false;
	}

	@Override
	public final IValue getValue() throws DebugException {
		return this.value;
	}

	@Override
	public final String getName() throws DebugException {
		if (this.parentVariable != null) {
			return this.parentVariable.getName() + "[" + this.index + "]";
		} else {
			return "[" + this.index + "]";
		}
	}

	@Override
	public final String getReferenceTypeName() throws DebugException {
		return (new ValueTypeVisitor()).apply(this.value.getValue());
	}

	@Override
	public final boolean hasValueChanged() throws DebugException {
		return false;
	}

}
