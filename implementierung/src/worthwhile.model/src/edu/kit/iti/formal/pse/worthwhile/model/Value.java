package edu.kit.iti.formal.pse.worthwhile.model;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IValueVisitor;

/**
 * This class represents a value of a variable.
 * 
 * @author Joachim
 */
public abstract class Value {

	/**
	 * Accepts a visitor.
	 * 
	 * @param visitor
	 *                The visitor to accept.
	 */
	public abstract void accept(IValueVisitor visitor);

	/**
	 * @return the {@link Value}'s {@link Type}
	 */
	public abstract Type getType();
}