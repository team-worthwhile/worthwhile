package edu.kit.iti.formal.pse.worthwhile.util;

import java.util.Iterator;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.impl.RuleCallImpl;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
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
	 * Returns the offset of a node in its line.
	 * 
	 * @param node
	 *                The node to locate in the source file.
	 * @return The offset of the node in its line
	 */
	public static int getColumn(final ASTNode node) {
		final ICompositeNode actualNode = NodeModelUtils.findActualNodeFor(node);
		if (actualNode != null) {
			ICompositeNode root = actualNode.getRootNode();
			String source = root.getText().substring(0, actualNode.getOffset());
			String line; // The line in the source until before the node
			int lastNL = source.lastIndexOf('\n');

			if (lastNL == -1) {
				line = source.substring(0, actualNode.getOffset());
			} else {
				line = source.substring(lastNL, actualNode.getOffset());
			}
			
			// FIXME: In the editor, tabs are counted by how much spaces they are equivalent to. We don't
			// have access to that number.
			line = line.replace("\t", "    ");
			return line.length();
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
			int len = actualNode.getLength();
			int subtractLen = 0;

			// Subtract length of hidden nodes that appear at the end of a node. They seem not to be
			// subtracted from the length although INode.getLength() claims
			// "Returns the length of this node excluding hidden tokens."
			for (INode child : actualNode.getChildren()) {
				if (child instanceof HiddenLeafNode
				                || (GrammarUtil.isTerminalRuleCall(child.getGrammarElement()) && ((RuleCallImpl) child
				                                .getGrammarElement()).getRule().getName().equals("NL"))) {
					subtractLen += child.getLength();
				} else {
					subtractLen = 0;
				}
			}

			return len - subtractLen;
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
