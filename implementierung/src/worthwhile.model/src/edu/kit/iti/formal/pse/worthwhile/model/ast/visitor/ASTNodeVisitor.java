package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * A visitor interface that can visit any ASTNode object
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNodeVisitor()
 */
public abstract class ASTNodeVisitor {
	public void visit(ASTNode node) {
		throw new RuntimeException(
				"Visitor cannot handle this type of ASTNode!");
	}
}
