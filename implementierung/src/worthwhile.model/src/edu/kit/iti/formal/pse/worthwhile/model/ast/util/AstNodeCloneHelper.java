package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Cloner for an ASTNode.
 * 
 * @author Leon Handreke, fabian
 */
public final class AstNodeCloneHelper extends HierarchialASTNodeVisitor {
	/**
	 * Private default constructor.
	 */
	private AstNodeCloneHelper() {
		super();
	}

	/**
	 * @param n
	 *                the {@link ASTNode} to clone.
	 * @param <T>
	 *                The type of the {@link ASTNode} to clone.
	 * @return a clone of the given {@link ASTNode}
	 */
	public static <T extends ASTNode> T clone(final T n) {
		return EcoreUtil.copy(n);
	}
}
