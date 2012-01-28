package edu.kit.iti.formal.pse.worthwhile.util;

import org.eclipse.xtext.nodemodel.ICompositeNode;
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
	 * @return The 1-based line number of the node in the source file.
	 */
	public static int getLine(final ASTNode node) {
		final ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(node);
		if (actualNode != null) {
			return actualNode.getStartLine();
		} else {
			return -1;
		}
	}

	/**
	 * Returns the offset of a node in the entire document.
	 * 
	 * @param node
	 *                The node to locate in the source file.
	 * @return The offset of the node in the document
	 */
	public static int getOffset(final ASTNode node) {
		final ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(node);
		if (actualNode != null) {
			return actualNode.getOffset();
		} else {
			return -1;
		}
	}

	/**
	 * Returns the length of a node in the source file.
	 * 
	 * @param node
	 *                The node whose length to get.
	 * @return The length of the node in the source file.
	 */
	public static int getLength(final ASTNode node) {
		final ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(node);
		if (actualNode != null) {
			return actualNode.getLength();
		} else {
			return -1;
		}
	}
	
	/**
	 * Returns the text of an AST node.
	 * 
	 * @param node
	 *                The AST node to get the text of.
	 * @return The text contained in the AST node.
	 */
	public static String getText(final ASTNode node) {
		final ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(node);
		if (actualNode != null) {
			return actualNode.getText();
		} else {
			return "";
		}
	}

	/**
	 * Returns whether the node {@code node} is a direct ancestor in the AST of the node {@code child}.
	 * 
	 * @param node
	 *                The node for which to check whether it is an ancestor of {@code child}
	 * @param child
	 *                The child node for which to check for ancestors.
	 * @return Whether the node {@code node} is a direct ancestor in the AST of the node {@code child}.
	 */
	public static boolean isAncestor(final ASTNode node, final ASTNode child) {
		ASTNode current = child;

		while (current != null && !(node.equals(current))) {
			current = (ASTNode) current.eContainer();
		}

		return node.equals(current);
	}

}
