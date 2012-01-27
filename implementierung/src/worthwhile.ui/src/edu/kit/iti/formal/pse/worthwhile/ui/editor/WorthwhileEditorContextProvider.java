package edu.kit.iti.formal.pse.worthwhile.ui.editor;

import org.eclipse.help.HelpSystem;
import org.eclipse.help.IContext;
import org.eclipse.help.IContextProvider;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;

/**
 * Provides help context IDs for a {@link WorthwhileEditor} depending on the current selection.
 * 
 * @see {@linkplain http://www.eclipse.org/articles/article.php?file=Article-DynamicCSH/index.html}
 * @author jojo
 * 
 */
public class WorthwhileEditorContextProvider implements IContextProvider {

	/**
	 * Creates a new instance of the {@link WorthwhileEditorContextProvider} class.
	 * 
	 * @param editor
	 *                The editor for which to provide help context IDs. May not be null.
	 */
	public WorthwhileEditorContextProvider(final WorthwhileEditor editor) {
		super();

		if (editor == null) {
			throw new IllegalArgumentException("Editor may not be null.");
		}

		this.editor = editor;
	}

	/**
	 * The editor for which to provide help context IDs.
	 */
	private WorthwhileEditor editor;

	@Override
	public final int getContextChangeMask() {
		return IContextProvider.SELECTION;
	}

	@Override
	public final IContext getContext(final Object target) {
		// Get the context for the keyword the cursor is currently on. If there is no such keyword, return null
		// which displays the generic help for the editor.
		ASTNode currentNode = editor.getCurrentNode();

		if (currentNode != null) {
			return HelpSystem.getContext("edu.kit.iti.formal.pse.worthwhile.help.keyword_"
			                + (new ASTNodeKeywordSwitch()).apply(currentNode));
		}

		return null;
	}

	@Override
	public final String getSearchExpression(final Object target) {
		return null;
	}

	/**
	 * Returns a help keyword for the given AST node.
	 */
	private class ASTNodeKeywordSwitch extends ASTNodeReturnVisitor<String> {

		@Override
		public void defaultOperation(final ASTNode node) {
			this.setReturnValue("Program");
		}

		@Override
		public void visit(final IntegerType node) {
			this.setReturnValue("Integer");
		}

		@Override
		public void visit(final BooleanType node) {
			this.setReturnValue("Boolean");
		}

		@Override
		public void visit(final ArrayType node) {
			this.setReturnValue("Array");
		}

		@Override
		public void visit(final ArrayLiteral node) {
			this.setReturnValue("Array");
		}

		@Override
		public void visit(final Assertion node) {
			this.setReturnValue("Assertion");
		}

		@Override
		public void visit(final Assignment node) {
			this.setReturnValue("Assignment");
		}

		@Override
		public void visit(final Assumption node) {
			this.setReturnValue("Assumption");
		}

		@Override
		public void visit(final Axiom node) {
			this.setReturnValue("Axiom");
		}

		@Override
		public void visit(final Conditional node) {
			this.setReturnValue("Condition");
		}

		@Override
		public void visit(final Expression node) {
			this.setReturnValue("Expression");
		}

		@Override
		public void visit(final FunctionDeclaration node) {
			this.setReturnValue("Function");
		}

		@Override
		public void visit(final FunctionCall node) {
			this.setReturnValue("Function");
		}

		@Override
		public void visit(final VariableReference node) {
			this.setReturnValue("Identifier");
		}

		@Override
		public void visit(final Invariant node) {
			this.setReturnValue("Invariant");
		}

		@Override
		public void visit(final Loop node) {
			this.setReturnValue("Loop");
		}

		@Override
		public void visit(final BinaryExpression node) {
			this.setReturnValue("Operator");
		}

		@Override
		public void visit(final UnaryExpression node) {
			this.setReturnValue("Operator");
		}

		@Override
		public void visit(final Precondition node) {
			this.setReturnValue("Precondition");
		}

		@Override
		public void visit(final Postcondition node) {
			this.setReturnValue("Postcondition");
		}

		@Override
		public void visit(final Program node) {
			this.setReturnValue("Program");
		}

		@Override
		public void visit(final QuantifiedExpression node) {
			this.setReturnValue("Quantified_Expression");
		}

		@Override
		public void visit(final ReturnStatement node) {
			this.setReturnValue("Return");
		}

		@Override
		public void visit(final Statement node) {
			this.setReturnValue("Statement");
		}

		@Override
		public void visit(final VariableDeclaration node) {
			this.setReturnValue("Variable_Declaration");
		}

	}

}
