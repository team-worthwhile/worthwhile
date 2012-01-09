package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * A visitor interface that can visit any ASTNode object
 * 
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNodeVisitor()
 */
public abstract class ASTNodeVisitor {

    private void throwUnsupportedASTNodeTypeException() {
	throw new UnsupportedOperationException("Visitor cannot Handle this type of ASTNode!");
    }

    public void visit(ASTNode node) {
	this.throwUnsupportedASTNodeTypeException();
    }
}
