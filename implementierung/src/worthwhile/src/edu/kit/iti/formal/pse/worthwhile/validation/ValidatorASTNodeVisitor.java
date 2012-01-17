package edu.kit.iti.formal.pse.worthwhile.validation;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 * The visitor for validation.
 * 
 * 
 */
public class ValidatorASTNodeVisitor extends ASTNodeVisitor {
	/**
	 * Indicates if a valid {@link ReturnStatement} was found.
	 */
	private boolean validReturnFound = false;

	@Override
	public final void visit(final ReturnStatement returnStatement) {
		setValidReturnFound(true);
	}

	@Override
	public final void visit(final Assertion node) {
		return;
	}

	@Override
	public final void visit(final Assumption node) {
		return;
	}

	@Override
	public final void visit(final Axiom node) {
		return;
	}

	@Override
	public final void visit(final Invariant node) {
		return;
	}

	@Override
	public final void visit(final Postcondition node) {
		return;
	}

	@Override
	public final void visit(final Precondition node) {
		return;
	}

	@Override
	public final void visit(final FunctionDeclaration functionDeclaration) {
		functionDeclaration.getBody().accept(this);
	}

	@Override
	public final void visit(final Block block) {
		for (Statement statement : block.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public final void visit(final Conditional conditional) {
		ValidatorASTNodeVisitor trueVisitor = new ValidatorASTNodeVisitor();
		ValidatorASTNodeVisitor falseVisitor = new ValidatorASTNodeVisitor();

		if (conditional.getTrueBlock() != null && conditional.getFalseBlock() != null) {
			conditional.getTrueBlock().accept(trueVisitor);
			conditional.getFalseBlock().accept(falseVisitor);
			if (trueVisitor.getValidReturnFound() && falseVisitor.getValidReturnFound()) {
				setValidReturnFound(true);
			}
		}
	}

	@Override
	public final void visit(final Assignment assignment) {
		return;
	}

	@Override
	public final void visit(final VariableDeclaration variableDeclaration) {
		return;
	}

	@Override
	public final void visit(final Loop loop) {
		return;
	}

	@Override
	public final void visit(final Annotation annotation) {
		return;
	}

	/**
	 * Returns true if a valid {@link ReturnStatement} was found.
	 * 
	 * @return true if a valid {@link ReturnStatement} was found, otherwise false.
	 */
	public final boolean getValidReturnFound() {
		return validReturnFound;
	}

	/**
	 * Sets the value for validReturnFound.
	 * 
	 * @param validReturnFound
	 *                the value to be set
	 */
	private void setValidReturnFound(final boolean validReturnFound) {
		this.validReturnFound = validReturnFound;
	}
}
