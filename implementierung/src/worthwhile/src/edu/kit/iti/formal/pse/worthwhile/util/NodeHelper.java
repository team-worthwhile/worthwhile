package edu.kit.iti.formal.pse.worthwhile.util;

import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * A collection of utility functions to deal with Worthwhile ASTs.
 * 
 * @author Joachim
 * 
 */
public final class NodeHelper {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private NodeHelper() {

	}

	/**
	 * Returns the 1-based line number of a node in the source file.
	 * 
	 * @param node
	 *                The node to locate in the source file.
	 * @return The (TODO: 0 or 1 based?) line number of the node in the source file.
	 */
	public static int getLine(final ASTNode node) {
		return NodeModelUtils.findActualNodeFor(node).getStartLine();
	}

}
