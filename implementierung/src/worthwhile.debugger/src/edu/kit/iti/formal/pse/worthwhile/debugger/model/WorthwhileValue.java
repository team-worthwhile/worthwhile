package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ValueReturnVisitor;

/**
 * Represents a value of a variable in a Worthwhile program.
 * 
 * @author Joachim
 * 
 */
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

	/**
	 * Returns the value represented by this object.
	 * 
	 * @return the value represented by this object.
	 */
	public final Value getValue() {
		return this.value;
	}

	@Override
	public final String getReferenceTypeName() throws DebugException {
		return (new ValueTypeVisitor()).apply(this.value);
	}

	@Override
	public final String getValueString() throws DebugException {
		return (new ValueToStringVisitor()).apply(this.value);
	}

	@Override
	public final boolean isAllocated() throws DebugException {
		return true;
	}

	@Override
	public final IVariable[] getVariables() throws DebugException {
		return (new GetVariablesVisitor()).apply(this.value);
	}

	@Override
	public final boolean hasVariables() throws DebugException {
		return (new GetVariablesVisitor()).apply(this.value).length > 0;
	}

	private IVariable createSubVariable(final int index) {
		// return new WorthwhileVariable(this.getDebugTarget(), )
		// TODO implement
		return null;
	}

	/**
	 * A visitor that returns the sub-variables for a specific value (if present).
	 * 
	 * @author Joachim
	 * 
	 */
	private class GetVariablesVisitor extends ValueReturnVisitor<IVariable[]> {

		@Override
		public <T extends Value> void visitCompositeValue(final CompositeValue<T> value) {
			IVariable[] result = new IVariable[value.getSubValues().length];

			for (int i = 0; i < value.getSubValues().length; i++) {
				result[i++] = createSubVariable(i);
			}

			this.setReturnValue(result);
		}

		@Override
		public void visitIntegerValue(final IntegerValue value) {
			this.setReturnValue(new IVariable[0]);
		}

		@Override
		public void visitBooleanValue(final BooleanValue value) {
			this.setReturnValue(new IVariable[0]);
		}

	}

	/**
	 * A visitor that returns a string representation of a value.
	 * 
	 * @author Joachim
	 * 
	 */
	private class ValueToStringVisitor extends ValueReturnVisitor<String> {

		@Override
		public <T extends Value> void visitCompositeValue(final CompositeValue<T> value) {
			StringBuilder sb = new StringBuilder();
			sb.append("{");

			for (int i = 0; i < value.getSubValues().length; i++) {
				sb.append(this.apply(value.getSubValues()[i]));

				if (i < value.getSubValues().length - 1) {
					sb.append(", ");
				}
			}

			sb.append("}");
			this.setReturnValue(sb.toString());
		}

		@Override
		public void visitIntegerValue(final IntegerValue value) {
			this.setReturnValue(value.getValue().toString());
		}

		@Override
		public void visitBooleanValue(final BooleanValue value) {
			this.setReturnValue(value.getValue() ? "true" : "false");
		}

	}

	/**
	 * A visitor that returns a string representation of a value’s type.
	 * 
	 * @author Joachim
	 * 
	 */
	private class ValueTypeVisitor extends ValueReturnVisitor<String> {

		@Override
		public <T extends Value> void visitCompositeValue(final CompositeValue<T> value) {
			StringBuilder sb = new StringBuilder();
			if (value.getSubValues().length > 0) {
				sb.append(this.apply(value.getSubValues()[0]));
			} else {
				sb.append("?"); // FIXME
			}
			sb.append("[]");
			this.setReturnValue(sb.toString());
		}

		@Override
		public void visitIntegerValue(final IntegerValue value) {
			this.setReturnValue("Integer");
		}

		@Override
		public void visitBooleanValue(final BooleanValue value) {
			this.setReturnValue("Boolean");
		}

	}

}
