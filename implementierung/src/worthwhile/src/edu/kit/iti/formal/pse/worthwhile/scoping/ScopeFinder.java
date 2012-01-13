package edu.kit.iti.formal.pse.worthwhile.scoping;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * A visitor that looks for variable and function declarations in the direct child nodes of a given AST node, until
 * reaching one "sentinel" statement.
 * 
 * @author Joachim
 * 
 */
public class ScopeFinder extends HierarchialASTNodeVisitor {

	/**
	 * Whether to recurse into statements containing other statements.
	 */
	private boolean recurse = true;

	/**
	 * Whether to stop looking for variable declarations.
	 */
	private boolean stop = false;

	/**
	 * The node to stop at.
	 */
	private final ASTNode sentinel;

	/**
	 * A list of the found variable declarations.
	 */
	private List<VariableDeclaration> variableDeclarations = new ArrayList<VariableDeclaration>();

	/**
	 * A list of the found function declarations.
	 */
	private List<FunctionDeclaration> functionDeclarations = new ArrayList<FunctionDeclaration>();

	/**
	 * Creates a new instance of the {@link VariableDeclarationFinder} type.
	 * 
	 * @param sentinel
	 *                The variable declaration to stop at.
	 */
	public ScopeFinder(final ASTNode sentinel) {
		this.sentinel = sentinel;
	}

	/**
	 * Returns the list of found variable declarations.
	 * 
	 * @return the list of found variable declarations
	 */
	public final List<VariableDeclaration> getVariableDeclarations() {
		return this.variableDeclarations;
	}

	/**
	 * Returns the list of found function declarations.
	 * 
	 * @return the list of found function declarations
	 */
	public final List<FunctionDeclaration> getFunctionDeclarations() {
		return this.functionDeclarations;
	}

	@Override
	public final void visit(final Block node) {
		if (node.equals(this.sentinel)) {
			this.stop = true;
		} else {
			if (this.recurse) {
				this.recurse = false;

				// Visit the statements that this block contains.
				for (Statement statement : node.getStatements()) {
					if (!this.stop) {
						statement.accept(this);
					}
				}
			}
		}	}

	@Override
	public final void visit(final FunctionDeclaration node) {
		if (node.equals(this.sentinel)) {
			this.stop = true;
		} else {
			if (!this.stop) {
				this.functionDeclarations.add(node);

				if (this.recurse) {
					node.getBody().accept(this);
				}
			}
		}
	}

	@Override
	public final void visit(final Program node) {
		// Visit all function declarations.
		for (FunctionDeclaration funcdec : node.getFunctionDeclarations()) {
			if (!this.stop) {
				funcdec.accept(this);
			}
		}

		// Visit the main block.
		if (!this.stop) {
			node.getMainBlock().accept(this);
		}
	}

	@Override
	public final void visit(final Statement node) {
		if (node.equals(this.sentinel)) {
			this.stop = true;
		}
	}

	@Override
	public final void visit(final VariableDeclaration node) {
		if (node.equals(this.sentinel)) {
			this.stop = true;
		} else {
			this.variableDeclarations.add(node);
		}
	}

	@Override
	public void visit(Conditional node) {
		if (node.equals(this.sentinel)) {
			this.stop = true;
		} else {
			// Visit the true and the false block, in that order.
			if (!this.stop && this.recurse) {
				node.getTrueBlock().accept(this);

				if (!this.stop) {
					node.getFalseBlock().accept(this);
				}
			}
		}
	}

	@Override
	public void visit(Loop node) {
		if (node.equals(this.sentinel)) {
			this.stop = true;
		} else {
			// Visit the body of the loop
			if (!this.stop && this.recurse) {
				node.getBody().accept(this);
			}
		}
	}

}
