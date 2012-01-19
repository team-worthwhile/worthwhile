package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;

/**
 * A visitor for AST nodes.
 * 
 * @author Joachim
 * 
 */
public interface IValueVisitor {

	/**
	 * Visits a composite value.
	 * 
	 * @param value
	 *                The value to visit.
	 * @param <T>
	 *                The type of sub-value to for the composite value.
	 * @return
	 */
	<T extends Value> void visitCompositeValue(CompositeValue<T> value);

	/**
	 * Visits an Integer value.
	 * 
	 * @param value
	 *                The Integer value to visit.
	 */
	void visitIntegerValue(IntegerValue value);

	/**
	 * Visits a Boolean value.
	 * 
	 * @param value
	 *                The Boolean value to visit.
	 */
	void visitBooleanValue(BooleanValue value);

}
