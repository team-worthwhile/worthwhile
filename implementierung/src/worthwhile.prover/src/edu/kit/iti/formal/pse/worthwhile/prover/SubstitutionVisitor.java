package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Substitutes a child reference with some {@link Expression} in the parent {@link ASTNode} when indicated so by the
 * child.
 * 
 * Implements all {@link Statement} visit methods, {@link HierarchialASTNodeVisitor#visit(ArrayLiteral}, {@link
 * HierarchialASTNodeVisitor#visit(ArrayFunction}, {@link HierarchialASTNodeVisitor#visit(FunctionCall}, {@link
 * HierarchialASTNodeVisitor#visit(QuantifiedExpression}, {@link HierarchialASTNodeVisitor#visit(BinaryExpression)} and
 * {@link HierarchialASTNodeVisitor#visit(UnaryExpression)} to traverse {@link Expression}s and substitute the
 * respective child references when the visited children called {@link SubstitutionVisitor#setFound(Boolean)}.
 * {@link HierarchialASTNodeVisitor#visit(Expression)} is implemented with an empty body so that the default visit
 * operation is ignored and subclasses just have to override the visit methods in which they want to actually call
 * {@link SubstitutionVisitor#setFound(Boolean)}.
 * 
 * @author fabian
 * 
 */
class SubstitutionVisitor extends HierarchialASTNodeVisitor {
	/**
	 * The {@link Expression} children are substituted with when {@link SubstitutionVisitor#found} was set.
	 */
	private Expression substitute;

	/**
	 * Indicates whether a matching child has been found and has to be substituted in the parent {@link ASTNode}.
	 */
	private Boolean found = false;

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} found child {@link ASTNode}s are substituted with
	 */
	SubstitutionVisitor(final Expression substitute) {
		this.substitute = substitute;
	}

	/**
	 * @return the found
	 */
	final Boolean getFound() {
		return this.found;
	}

	/**
	 * @param found
	 *                the found to set
	 */
	final void setFound(final Boolean found) {
		this.found = found;
	}

	/**
	 * @return a clone of the {@link SubstitutionVisitor#substitute}
	 */
	final Expression getSubstitute() {
		return AstNodeCloneHelper.clone(this.substitute);
	}

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} found child {@link ASTNode}s are substituted with
	 */
	final void setSubstitute(final Expression substitute) {
		this.substitute = substitute;
	}

	@Override
	public void visit(final Program program) {
		for (final FunctionDeclaration f : program.getFunctionDeclarations()) {
			f.accept(this);
		}

		program.getMainBlock().accept(this);
	}

	@Override
	public void visit(final FunctionDeclaration functionDeclaration) {
		for (final Precondition p : functionDeclaration.getPreconditions()) {
			p.accept(this);
		}
		for (final Postcondition p : functionDeclaration.getPostconditions()) {
			p.accept(this);
		}
		functionDeclaration.getBody().accept(this);
	}

	@Override
	public void visit(final Annotation annotation) {
		annotation.getExpression().accept(this);
	}

	@Override
	public void visit(final ArrayLiteral arrayLiteral) {
		for (final Expression v : arrayLiteral.getValues()) {
			v.accept(this);
		}
	}

	@Override
	public void visit(final ArrayFunction arrayFunction) {
		for (final Expression i : arrayFunction.getValues().keySet()) {
			i.accept(this);
		}

		for (final Expression v : arrayFunction.getValues().values()) {
			v.accept(this);
		}

		arrayFunction.getChainedFunction().accept(this);
	}

	@Override
	public void visit(final Assignment assignment) {
		assignment.getValue().accept(this);
	}

	@Override
	public void visit(final Block block) {
		for (final Statement s : block.getStatements()) {
			s.accept(this);
		}
	}

	@Override
	public void visit(final Conditional conditional) {
		conditional.getCondition().accept(this);
	}

	@Override
	public void visit(final Loop loop) {
		loop.getCondition().accept(this);
		for (final Invariant i : loop.getInvariants()) {
			i.accept(this);
		}
		loop.getBody().accept(this);
	}

	@Override
	public void visit(final ReturnStatement returnStatement) {
		returnStatement.getReturnValue().accept(this);
	}

	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		variableDeclaration.getInitialValue().accept(this);
	}

	@Override
	public void visit(final QuantifiedExpression quantifiedExpression) {
		final Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			condition.accept(this);

			if (found) {
				quantifiedExpression.setCondition(this.getSubstitute());
				found = false;
			}
		}

		quantifiedExpression.getExpression().accept(this);
		if (found) {
			quantifiedExpression.setExpression(this.getSubstitute());
			found = false;
		}
	}

	@Override
	public void visit(final BinaryExpression binaryExpression) {
		binaryExpression.getLeft().accept(this);
		if (found) {
			binaryExpression.setLeft(this.getSubstitute());
			found = false;
		}

		binaryExpression.getRight().accept(this);
		if (found) {
			binaryExpression.setRight(this.getSubstitute());
			found = false;
		}
	}

	@Override
	public void visit(final FunctionCall functionCall) {
		for (final Expression a : functionCall.getActuals()) {
			a.accept(this);
		}
	};

	@Override
	public void visit(final UnaryExpression unaryExpression) {
		unaryExpression.getOperand().accept(this);
		if (found) {
			unaryExpression.setOperand(this.getSubstitute());
			found = false;
		}
	}

	@Override
	public void visit(final Literal literal) {
		// we reached an Expression leaf, ignore default operation
	}

	@Override
	public void visit(final VariableReference variableReference) {
		final Expression index = variableReference.getIndex();
		if (index != null) {
			index.accept(this);
		}
	}
}