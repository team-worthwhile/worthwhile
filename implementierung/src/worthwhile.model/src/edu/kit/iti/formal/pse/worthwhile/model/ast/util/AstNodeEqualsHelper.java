package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * Implements equals methods for {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
public final class AstNodeEqualsHelper {
	/**
	 * Private default constructor.
	 */
	private AstNodeEqualsHelper() {
		super();
	}

	/**
	 * Returns <code>true</code> if and only if <code>arg0</code> and <code>arg1</code> are equal.
	 * 
	 * @param arg0
	 *                the {@link ASTNode} to be compared to <code>arg1</code>
	 * @param arg1
	 *                the ASTNode to be compared to <code>arg0</code>
	 * @return whether <code>arg0</code> and <code>arg1</code> are equal
	 */
	public static Boolean equals(final ASTNode arg0, final ASTNode arg1) {
		return EcoreUtil.equals(arg0, arg1);
	}
}
