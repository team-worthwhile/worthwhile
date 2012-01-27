package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;

/**
 * An AST node visitor that goes from the bottom to the top.
 * 
 * @param <R>
 *            The type of the return value.
 * 
 * @author matthias
 * 
 * @nocheckstyle:designforextension
 */
public abstract class ASTNodeBottomUpVisitor<R> extends ASTNodeReturnVisitor<R> {

	@Override
	public void visit(final ASTNode node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}
}
