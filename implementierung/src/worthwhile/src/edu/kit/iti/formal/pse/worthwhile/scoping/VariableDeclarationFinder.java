package edu.kit.iti.formal.pse.worthwhile.scoping;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * A visitor that looks for variable declarations in a given AST, until reaching one "sentinel" variable declaration.
 * 
 * @author Joachim
 * 
 */
public class VariableDeclarationFinder extends HierarchialASTNodeVisitor {

	/**
	 * Whether to stop looking for variable declarations.
	 */
	private boolean stop = false;

	/**
	 * The variable name to stop at.
	 */
	private final Statement sentinel;

	/**
	 * A list of the found variable declarations.
	 */
	private List<VariableDeclaration> variableDeclarations = new ArrayList<VariableDeclaration>();

	/**
	 * Creates a new instance of the {@link VariableDeclarationFinder} type.
	 * 
	 * @param sentinel
	 *                The variable declaration to stop at.
	 */
	public VariableDeclarationFinder(final Statement sentinel) {
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

	@Override
	public final void visit(final Block node) {
		for (Statement statement : node.getStatements()) {
			if (!this.stop) {
				statement.accept(this);
			}
		}
	}

	@Override
	public final void visit(final FunctionDeclaration node) {
		if (!this.stop) {
			node.getBody().accept(this);
		}
	}

	@Override
	public final void visit(final Program node) {
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

}
