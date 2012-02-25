package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Convenience method for cloning a {@link List} of {@link ASTNode}s at once.
	 * 
	 * @param nodes
	 *                a <code>List</code> of to be cloned <code>ASTNode</code>s
	 * @return a new <code>List</code> of clones of the <code>nodes</code> elements in the very same order
	 */
	public static <T extends ASTNode> List<T> clone(final List<T> nodes) {
		final List<T> clonesList = new ArrayList<T>();

		for (final T n : nodes) {
			clonesList.add(AstNodeCloneHelper.clone(n));
		}

		return clonesList;
	}
}
