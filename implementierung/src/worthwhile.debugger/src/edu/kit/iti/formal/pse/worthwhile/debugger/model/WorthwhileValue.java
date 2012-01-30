package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.ValueTypeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ValueReturnVisitor;

/**
 * Represents a value of a variable in a Worthwhile program.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileValue extends WorthwhileDebugElement implements IValue {

	/**
	 * The variable this value belongs to.
	 */
	private final IVariable variable;

	/**
	 * The value represented by this object.
	 */
	private final Value value;

	/**
	 * Creates a new instance of the {@link WorthwhileValue} class.
	 * 
	 * @param debugTarget
	 *                The debug target this object belongs to
	 * @param variable
	 *                The variable this value belongs to.
	 * @param value
	 *                The value represented by this object.
	 */
	public WorthwhileValue(final WorthwhileDebugTarget debugTarget, final IVariable variable, final Value value) {
		super(debugTarget);
		this.variable = variable;
		this.value = value;
	}

	/**
	 * Returns the variable this value belongs to.
	 * 
	 * @return the variable this value belongs to.
	 */
	public final IVariable getVariable() {
		return this.variable;
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

	/**
	 * Creates a new array entry.
	 * 
	 * @param index
	 *                The index of the array entry.
	 * @param value
	 *                The value of the array entry.
	 * @return A new array entry with the specified index and value.
	 */
	private IVariable createArrayEntry(final int index, final WorthwhileValue value) {
		return new WorthwhileArrayEntry(this.getDebugTarget(), this.variable, index, value);
	}

	/**
	 * Creates a new subvalue of this value.
	 * 
	 * @param value
	 *                The value represented by the subvalue
	 * @return A new subvalue that represents the specified value.
	 */
	private WorthwhileValue createSubValue(final Value value) {
		return new WorthwhileValue(getDebugTarget(), this.getVariable(), value);
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
			IVariable[] result = new IVariable[value.getSubValues().size()];

			// Create an array entry for each of the sub values.
			int i = 0;
			for (int index : value.getSubValues().keySet()) {
				result[i++] = createArrayEntry(i, createSubValue(value.getSubValues().get(index)));
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
			
			int i = 0;
			for (int index : value.getSubValues().keySet()) {
				sb.append(this.apply(value.getSubValues().get(index)));
				
				if (i < value.getSubValues().size() - 1) {
					sb.append(", ");
				}
				
				i++;
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

}
