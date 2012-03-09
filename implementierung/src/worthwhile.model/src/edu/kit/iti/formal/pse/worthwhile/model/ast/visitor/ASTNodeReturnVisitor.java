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
	 * Gets the return value.
	 * 
	 * @return The return value.
	 */
	protected final R getReturnValue() {
		return this.returnValue;
	}

	/**
	 * Applies this visitor to the specified node and returns the return value.
	 * 
	 * @param node
	 *                The node to visit.
	 * @return The return value as computed by this visitor.
	 */
	public final R apply(final ASTNode node) {
		node.accept(this);
		return this.returnValue;
	}

	/**
	 * Applies this visitor to the specified node and returns the return value. A default value can be specified.
	 * 
	 * @param node
	 *                The node to visit.
	 * @param defaultValue
	 *                The default value to set.
	 * @return The return value as computed by this visitor.
	 */
	public final R apply(final ASTNode node, final R defaultValue) {
		this.setReturnValue(defaultValue);
		return this.apply(node);
	}

}
