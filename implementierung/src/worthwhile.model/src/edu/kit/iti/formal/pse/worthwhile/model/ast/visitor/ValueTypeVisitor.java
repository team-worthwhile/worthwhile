package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;

/**
 * Returns the {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Type} of a {@link Value}.
 * 
 * @author Joachim
 * 
 */
public class ValueTypeVisitor extends ValueReturnVisitor<Type> {

	@Override
	public final <T extends Value> void visitCompositeValue(final CompositeValue<T> value) {
		ArrayType arrayType = AstFactory.eINSTANCE.createArrayType();

		// Determine the base type from the sub values, if there are any.
		if (value.getSubValues().size() > 0) {
			arrayType.setBaseType((PrimitiveType) new ValueTypeVisitor().apply(value.getSubValues()
			                .entrySet().iterator().next().getValue()));
		}

		this.setReturnValue(arrayType);
	}

	@Override
	public final void visitIntegerValue(final IntegerValue value) {
		this.setReturnValue(AstFactory.eINSTANCE.createIntegerType());
	}

	@Override
	public final void visitBooleanValue(final BooleanValue value) {
		this.setReturnValue(AstFactory.eINSTANCE.createBooleanType());
	}

}
