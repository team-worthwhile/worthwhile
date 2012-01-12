package edu.kit.iti.formal.pse.worthwhile.validation;

import edu.kit.iti.formal.pse.worthwhile.model.ast.*;
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
	public void visit(ReturnStatement returnStatement) {
		setValidReturnFound(true);
	}
	
	/**
	 * TODO
	 */
	public void visit(FunctionDeclaration functionDeclaration) {
		functionDeclaration.getBody().accept(this);
	}
	
	/**
	 * TODO
	 */
	public void visit(Block block) {
		for(Statement statement : block.getStatements()) {
			statement.accept(this);
		}
	}
	
	/**
	 * TODO
	 */
	public void visit(Conditional conditional) {
		ValidatorASTNodeVisitor trueVisitor = new ValidatorASTNodeVisitor();
		ValidatorASTNodeVisitor falseVisitor = new ValidatorASTNodeVisitor();
		
		if(conditional.getTrueBlock() != null && conditional.getFalseBlock() != null) {
			conditional.getTrueBlock().accept(trueVisitor);
			conditional.getFalseBlock().accept(falseVisitor);
			if(trueVisitor.getValidReturnFound() && falseVisitor.getValidReturnFound()) {
				setValidReturnFound(true);
			}
		}
	}
	
	/**
	 * TODO
	 */
	public void visit(Assignment assignment) {
		return;
	}
	
	/**
	 * TODO
	 */
	public void visit(VariableDeclaration variableDeclaration) {
		return;
	}
	
	/**
	 * TODO
	 */
	public void visit(Loop loop) {
		return;
	}
	
	/**
	 * TODO
	 */
	public void visit(Annotation annotation) {
		return;
	}

	/**
	 * TODO
	 * @return
	 */
	public boolean getValidReturnFound() {
	        return validReturnFound;
        }

	/**
	 * TODO
	 * @param validReturnFound
	 */
	public void setValidReturnFound(boolean validReturnFound) {
	        this.validReturnFound = validReturnFound;
        }
}
