package edu.kit.iti.formal.pse.worthwhile.validation;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 * TODO von wegen nur Functionsdeklarationsblöcke
 * 
 */
public class ValidatorASTNodeVisitor extends ASTNodeVisitor {
	/**
	 * TODO
	 */
	private boolean validReturnFound = false;

	/**
	 * TODO
	 */
	public final void visit(final ReturnStatement returnStatement) {
		setValidReturnFound(true);
	}

	/**
	 * TODO
	 */
	public final void visit(final FunctionDeclaration functionDeclaration) {
		functionDeclaration.getBody().accept(this);
	}

	/**
	 * TODO
	 */
	public final void visit(final Block block) {
		for (Statement statement : block.getStatements()) {
			statement.accept(this);
		}
	}

	/**
	 * TODO
	 */
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

	/**
	 * TODO
	 */
	public final void visit(final Assignment assignment) {
		return;
	}

	/**
	 * TODO
	 */
	public final void visit(final VariableDeclaration variableDeclaration) {
		return;
	}

	/**
	 * TODO
	 */
	public final void visit(final Loop loop) {
		return;
	}

	/**
	 * TODO
	 */
	public final void visit(final Annotation annotation) {
		return;
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public final boolean getValidReturnFound() {
		return validReturnFound;
	}

	/**
	 * TODO
	 * 
	 * @param validReturnFound
	 */
	public final void setValidReturnFound(final boolean validReturnFound) {
		this.validReturnFound = validReturnFound;
	}
}
