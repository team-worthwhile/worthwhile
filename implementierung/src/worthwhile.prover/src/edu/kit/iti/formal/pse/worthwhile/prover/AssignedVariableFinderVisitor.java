package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.LinkedHashSet;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Visitor to find {@link VariableDeclaration}s which have been assigned a new value.
 * 
 * @author Leon Handreke
 */
public class AssignedVariableFinderVisitor extends HierarchialASTNodeVisitor {

	/**
	 * Set of variables that something has been assigned to in the visited AST.
	 */
	private Set<VariableDeclaration> assignedVariables = new LinkedHashSet<VariableDeclaration>();

	/**
	 * @return the found assigned variables.
	 */
	public final Set<VariableDeclaration> getAssignedVariables() {
		return assignedVariables;
	}

	@Override
	public void visit(final Statement statement) {
		// for most statements, do nothing
	}

	@Override
	public final void visit(final Assignment assignment) {
		// add the variable declaration on the left side of the assignment to the list of assigned variables
		this.assignedVariables.add(assignment.getVariable().getVariable());
	}

	@Override
	public final void visit(final Block block) {
		for (Statement statement : block.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public final void visit(final Conditional conditional) {
		conditional.getTrueBlock().accept(this);
		if (conditional.getFalseBlock() != null) {
			conditional.getFalseBlock().accept(this);
		}
	}

	@Override
	public final void visit(final Loop loop) {
		loop.getBody().accept(this);
	}
}
