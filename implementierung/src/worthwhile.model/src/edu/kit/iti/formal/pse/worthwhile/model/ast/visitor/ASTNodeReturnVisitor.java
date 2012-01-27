package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * An AST node visitor that has a return value.
 * 
 * @param <R>
 *                The type of the return value.
 * @author Joachim
 */
public abstract class ASTNodeReturnVisitor<R> extends HierarchialASTNodeVisitor {

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
	public final R apply(final ASTNode node) {
		node.accept(this);
		return this.returnValue;
	}
	
}
