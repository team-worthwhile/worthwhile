package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeCloneVisitor;

/**
 * Cloner for an ASTNode.
 *
 * @author Leon Handreke
 *
 * @param <T> the type of ASTNode to clone
 */
public class AstNodeCloneHelper<T extends ASTNode> {

	/**
	 * @param n the {@link ASTNode} to clone.
	 * @return a clone of the given {@link ASTNode}
	 */
	public final T clone(final T n) {
		ASTNodeCloneVisitor visitor = new ASTNodeCloneVisitor();
		n.accept(visitor);
		return (T) visitor.getClone();
	}
}
