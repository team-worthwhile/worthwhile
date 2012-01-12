package edu.kit.iti.formal.pse.worthwhile.prover;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * Implements equals methods for {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
public final class ASTNodeEqualator {
	/**
	 * Private default constructor.
	 */
	private ASTNodeEqualator() {
		// left empty intentionally
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public static Boolean equal(final ASTNode arg0, final ASTNode arg1) {
		return EcoreUtil.equals(arg0, arg1);
	}
}