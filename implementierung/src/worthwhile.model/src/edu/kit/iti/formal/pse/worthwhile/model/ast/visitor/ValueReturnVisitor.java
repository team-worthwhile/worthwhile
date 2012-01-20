package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;

/**
 * A value visitor that has a return value.
 * 
 * @param <R>
 *                The type of return value.
 * 
 * @author Joachim
 */
public abstract class ValueReturnVisitor<R> implements IValueVisitor {

	/**
	 * The return value.
	 */
	private R returnValue;

	/**
	 * Sets the return value.
	 * 
	 * @param returnValue
	 *                The return value.
	 */
	protected final void setReturnValue(final R returnValue) {
		this.returnValue = returnValue;
	}

	/**
	 * Applies this visitor to the specified value and returns the return value.
	 * 
	 * @param value
	 *                The value to visit.
	 * @return The return value as computed by this visitor.
	 */
	public final R apply(final Value value) {
		value.accept(this);
		return this.returnValue;
	}

	@Override
	public abstract <T extends Value> void visitCompositeValue(final CompositeValue<T> value);

	@Override
	public abstract void visitIntegerValue(final IntegerValue value);

	@Override
	public abstract void visitBooleanValue(final BooleanValue value);

}
