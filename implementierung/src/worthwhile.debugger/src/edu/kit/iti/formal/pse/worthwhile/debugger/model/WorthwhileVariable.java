package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeEqualsHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ValueTypeVisitor;

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
	 *                The debug target to use.
	 * @param name
	 *                The name of the variable.
	 */
	public WorthwhileVariable(final WorthwhileDebugTarget debugTarget, final String name) {
		super(debugTarget);
		this.name = name;
	}

	@Override
	public final void setValue(final String expression) throws DebugException {
		Value value = this.getDebugTarget().evaluateExpression(expression);
		this.setValue(new WorthwhileValue(this.getDebugTarget(), this, value));
	}

	@Override
	public final void setValue(final IValue value) throws DebugException {
		if (value instanceof WorthwhileValue) {
			this.getDebugTarget().setVariableValue(this, ((WorthwhileValue) value).getValue());
			this.fireEvent(new DebugEvent(this, DebugEvent.CHANGE));
		}
	}

	@Override
	public final boolean supportsValueModification() {
		return true;
	}

	@Override
	public final boolean verifyValue(final String expression) throws DebugException {
		Value value = this.getDebugTarget().evaluateExpression(expression);
		return this.verifyValue(new WorthwhileValue(this.getDebugTarget(), this, value));
	}

	@Override
	public final boolean verifyValue(final IValue value) throws DebugException {
		if (!(value instanceof WorthwhileValue)) {
			return false;
		}

		// Retrieve types of current and designed value and accept if they are equal.
		Type originalType = this.getDebugTarget().getVariableType(this.getName());
		Type newType = new ValueTypeVisitor().apply(((WorthwhileValue) value).getValue());

		if (originalType instanceof ArrayType) {
			if (!(newType instanceof ArrayType)) {
				return false;
			} else {
				ArrayType aOriginalType = (ArrayType) originalType;
				ArrayType aNewType = (ArrayType) newType;
				return (aOriginalType.getBaseType() == null || aNewType.getBaseType() == null || AstNodeEqualsHelper
				                .equals(aOriginalType, aNewType));
			}
		} else {
			return AstNodeEqualsHelper.equals(originalType, newType);
		}
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
		return this.getDebugTarget().hasVariableValueChanged(this.getName());
	}

}
