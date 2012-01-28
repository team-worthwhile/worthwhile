package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldedPosition;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * A folding region provider for a Worthwhile document.
 * 
 * @author Joachim
 * 
 */
public class WorthwhileFoldingRegionProvider extends DefaultFoldingRegionProvider {

	@Override
	protected final Collection<FoldedPosition> doGetFoldingRegions(final IXtextDocument xtextDocument,
	                final XtextResource xtextResource) {

		ASTNode root = (ASTNode) xtextResource.getParseResult().getRootASTElement();
		Collection<ASTNode> nodesToFold = (new WorthwhileFoldingVisitor()).apply(root);
		Collection<FoldedPosition> foldedPositions = new ArrayList<FoldedPosition>();
		
		for (ASTNode node : nodesToFold) {
			int offset = NodeHelper.getOffset(node);
			int length = NodeHelper.getLength(node);
			foldedPositions.add(new DefaultFoldedPosition(offset, length, 0, 0));
		}
		
		return foldedPositions;
	}

	/**
	 * A visitor which provides folding regions for a Worthwhile document.
	 * 
	 * @author Joachim
	 * 
	 */
	private class WorthwhileFoldingVisitor extends ASTNodeReturnVisitor<Collection<ASTNode>> {

		/**
		 * Creates a new instance of the {@link WorthwhileFoldingVisitor} class.
		 */
		public WorthwhileFoldingVisitor() {
			this.setReturnValue(new ArrayList<ASTNode>());
		}

		@Override
		public void defaultOperation(final ASTNode node) {
		}

		@Override
		public void visit(final Block node) {
			for (Statement statement : node.getStatements()) {
				statement.accept(this);
			}
		}

		@Override
		public void visit(final Conditional node) {
			if (node.getTrueBlock() != null) {
				this.getReturnValue().add(node.getTrueBlock());
			}

			if (node.getFalseBlock() != null) {
				this.getReturnValue().add(node.getFalseBlock());
			}
		}

		@Override
		public void visit(final FunctionDeclaration node) {
			this.getReturnValue().add(node);
			node.getBody().accept(this);
		}

		@Override
		public void visit(final Loop node) {
			this.getReturnValue().add(node);
			node.getBody().accept(this);
		}

		@Override
		public void visit(final Program node) {
			if (node.getFunctionDeclarations() != null) {
				for (FunctionDeclaration funcdec : node.getFunctionDeclarations()) {
					funcdec.accept(this);
				}
			}

			if (node.getMainBlock() != null) {
				this.getReturnValue().add(node.getMainBlock());
				node.getMainBlock().accept(this);
			}
		}

	}

}
