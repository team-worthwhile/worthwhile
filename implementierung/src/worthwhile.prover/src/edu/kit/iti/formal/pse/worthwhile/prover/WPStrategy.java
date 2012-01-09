package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstFactoryImpl;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 * Applies the Weakest Precondition calculus to a {@link Program}.
 */
class WPStrategy extends ASTNodeVisitor implements FormulaGenerator {
	/**
	 * The weakest precondition that implies the correctness of the remainder {@link Program}.
	 */
	private Expression weakestPrecondition;

	/**
	 * @return the weakestPrecondition
	 */
	public Expression getWeakestPrecondition() {
		// begin-user-code
		return this.weakestPrecondition;
		// end-user-code
	}

	/**
	 * @param program
	 *            the {@link Program} to calculate the weakest precondition for
	 * @return the weakest precondition that implies the correctness of <code>program</code>
	 * @see FormulaGenerator#transformProgram(Program program)
	 */
	public Expression transformProgram(Program program) {
		// initialize the weakest precondition to true
		BooleanLiteral trueLiteral = AstFactoryImpl.init().createBooleanLiteral();
		trueLiteral.setValue(true);
		this.weakestPrecondition = trueLiteral;

		/*
		 * pass us as visitor from statement to statement:
		 * 
		 * 1. get the weakest precondition, 2. apply the appropriate calculus rule, 3. set the weakest precondition, 4.
		 * forward us to the next statement
		 * 
		 * finally the weakest precondition implies the correctness of the whole program
		 */
		program.accept(this);

		return this.weakestPrecondition;
	}

	/**
	 * @see ASTNodeVisitor#visit(Assertion assertion)
	 */
	public void visit(Assertion assertion) {
		Conjunction conjunction = AstFactoryImpl.init().createConjunction();
		conjunction.setRight(this.weakestPrecondition);
		conjunction.setLeft(assertion.getExpression());
		this.weakestPrecondition = conjunction;
	}

	/**
	 * @see ASTNodeVisitor#visit(Assignment assignment)
	 */
	public void visit(final Assignment assignment) {
		VariableDeclaration variableDeclaration = assignment.getVariable().getVariable();
		weakestPrecondition.accept(new VariableSubstitution(variableDeclaration, assignment.getValue(),
				new VariableSubstitution.SubstituteCommand() {
			@Override
			void substitute() {
				WPStrategy.this.weakestPrecondition = assignment.getValue();
			}
		}));
	}

	/**
	 * @see ASTNodeVisitor#visit(Assumption assumption)
	 */
	public void visit(Assumption assumption) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Axiom axiom)
	 */
	public void visit(Axiom axiom) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Block block)
	 */
	public void visit(Block block) {
		// visit all block statements in the order they were parsed reversed
		List<Statement> stmts = new ArrayList<Statement>(block.getStatements());
		Collections.reverse(stmts);
		for (Statement stmt : stmts) {
			stmt.accept(this);
		}
	}

	/**
	 * @see ASTNodeVisitor#visit(Conditional conditional)
	 */
	public void visit(Conditional conditional) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(FunctionDeclaration functionDeclaration)
	 */
	public void visit(FunctionDeclaration functionDeclaration) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Invariant invariant)
	 */
	public void visit(Invariant invariant) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Loop loop)
	 */
	public void visit(Loop loop) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Postcondition postcondition)
	 */
	public void visit(Postcondition postcondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Precondition precondition)
	 */
	public void visit(Precondition precondition) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(Program program)
	 */
	public void visit(Program program) {
		// visit program's main block
		program.getMainBlock().accept(this);
	}

	/**
	 * @see ASTNodeVisitor#visit(ReturnStatement returnStatement)
	 */
	public void visit(ReturnStatement returnStatement) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	/**
	 * @see ASTNodeVisitor#visit(VariableDeclaration variableDeclaration)
	 */
	public void visit(final VariableDeclaration variableDeclaration) {
		weakestPrecondition.accept(new VariableSubstitution(variableDeclaration, variableDeclaration.getInitialValue(),
				new VariableSubstitution.SubstituteCommand() {
			@Override
			void substitute() {
				WPStrategy.this.weakestPrecondition = variableDeclaration.getInitialValue();
			}
		}));
	}
}