package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ValueReturnVisitor;

/**
 * A visitor that returns a string representation of a value’s type.
 * 
 * @author Joachim
 * 
 */
public class ValueTypeVisitor extends ValueReturnVisitor<String> {

	@Override
	public final <T extends Value> void visitCompositeValue(final CompositeValue<T> value) {
		StringBuilder sb = new StringBuilder();
		if (value.getSubValues().size() > 0) {
			sb.append(this.apply(value.getSubValues().entrySet().iterator().next().getValue()));
		} else {
			sb.append("-");
		}
		sb.append("[]");
		this.setReturnValue(sb.toString());
	}

	@Override
	public final void visitIntegerValue(final IntegerValue value) {
		this.setReturnValue("Integer");
	}

	@Override
	public final void visitBooleanValue(final BooleanValue value) {
		this.setReturnValue("Boolean");
	}

}