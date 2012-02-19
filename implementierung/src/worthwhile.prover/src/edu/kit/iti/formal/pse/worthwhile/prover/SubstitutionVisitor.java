package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.ListIterator;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess;
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
 * Implements all {@link Statement} visit methods as well as
 * 
 * <ul>
 * <li>{@link HierarchialASTNodeVisitor#visit(ArrayFunction)}</li>
 * <li>{@link HierarchialASTNodeVisitor#visit(ArrayLiteral)}</li>
 * <li>{@link HierarchialASTNodeVisitor#visit(BinaryExpression)}</li>
 * <li>{@link HierarchialASTNodeVisitor#visit(FunctionCall)}</li>
 * <li>{@link HierarchialASTNodeVisitor#visit(QuantifiedExpression)}</li>
 * <li>{@link HierarchialASTNodeVisitor#visit(UnaryExpression)}</li>
 * <li>{@link HierarchialASTNodeVisitor#visit(VariableReference)} (for array index expressions)</li>
 * </ul>
 * 
 * to traverse {@link Expression}s and substitute the respective child references when the visited children called
 * {@link SubstitutionVisitor#setFound(Boolean)}. {@link HierarchialASTNodeVisitor#visit(Literal)} is implemented with
 * an empty body so that the default visit operation is ignored and subclasses just have to override the visit methods
 * in which they want to actually call {@link SubstitutionVisitor#setFound(Boolean)}.
 * 
 * @param <T>
 *                the substitute's, which a child reference is replaced with, <code>Expression</code> type
 * 
 * @author fabian
 * 
 */
class SubstitutionVisitor<T extends Expression> extends HierarchialASTNodeVisitor {
	/**
	 * The {@link Expression} children are substituted with when {@link SubstitutionVisitor#found} was set.
	 */
	private T substitute;

	/**
	 * Indicates whether a matching child has been found and has to be substituted in the parent {@link ASTNode}.
	 */
	private Boolean found = false;

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} found child {@link ASTNode}s are substituted with
	 */
	SubstitutionVisitor(final T substitute) {
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
	 * 
	 * @param cloned
	 *                indicates whether a clone of the {@link SubstitutionVisitor#substitute} or the
	 *                <code>substitute</code> itself should be returned
	 * @return the <code>substitute</code>
	 */
	final T getSubstitute(final boolean cloned) {
		if (cloned) {
			return AstNodeCloneHelper.clone(this.substitute);
		} else {
			return this.substitute;
		}
	}

	/**
	 * @return a clone of the {@link SubstitutionVisitor#substitute}
	 */
	final T getSubstitute() {
		return this.getSubstitute(true);
	}

	/**
	 * 
	 * @param substitute
	 *                the {@link Expression} found child {@link ASTNode}s are substituted with
	 */
	final void setSubstitute(final T substitute) {
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

		if (this.found) {
			this.found = false;
			annotation.setExpression(this.getSubstitute());
		}
	}

	@Override
	public void visit(final ArrayLiteral arrayLiteral) {
		final ListIterator<Expression> i = arrayLiteral.getValues().listIterator();
		while (i.hasNext()) {
			i.next().accept(this);

			if (this.found) {
				this.found = false;
				i.set(this.getSubstitute());
			}
		}
	}

	@Override
	public void visit(final ArrayFunction arrayFunction) {
		// FIXME: substitute child reference when found is still set after accept returned
		final Expression index = arrayFunction.getIndex();
		if (index != null) {
			index.accept(this);
			if (this.found) {
				this.found = false;
				arrayFunction.setIndex(this.getSubstitute());
			}
		}

		arrayFunction.getValue().accept(this);
		if (this.found) {
			this.found = false;
			arrayFunction.setValue(this.getSubstitute());
		}

		final Expression chainedFunction = arrayFunction.getChainedFunction();
		if (chainedFunction != null) {
			chainedFunction.accept(this);
			if (this.found) {
				this.found = false;
				arrayFunction.setChainedFunction(this.getSubstitute());
			}
		}
	}

	@Override
	public void visit(final ArrayFunctionAccess arrayFunctionAccess) {
		arrayFunctionAccess.getFunction().accept(this);

		arrayFunctionAccess.getIndex().accept(this);
		if (this.found) {
			this.found = false;
			arrayFunctionAccess.setIndex(this.getSubstitute());
		}
	}

	@Override
	public void visit(final Assignment assignment) {
		assignment.getValue().accept(this);

		if (this.found) {
			this.found = false;
			assignment.setValue(this.getSubstitute());
		}
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

		if (this.found) {
			this.found = false;
			conditional.setCondition(this.getSubstitute());
		}

		conditional.getTrueBlock().accept(this);

		final Block falseBlock = conditional.getFalseBlock();
		if (falseBlock != null) {
			falseBlock.accept(this);
		}
	}

	@Override
	public void visit(final Loop loop) {
		loop.getCondition().accept(this);

		if (this.found) {
			this.found = false;
			loop.setCondition(this.getSubstitute());
		}

		for (final Invariant i : loop.getInvariants()) {
			i.accept(this);
		}
		loop.getBody().accept(this);
	}

	@Override
	public void visit(final ReturnStatement returnStatement) {
		returnStatement.getReturnValue().accept(this);

		if (this.found) {
			this.found = false;
			returnStatement.setReturnValue(this.getSubstitute());
		}
	}

	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		variableDeclaration.getInitialValue().accept(this);

		if (this.found) {
			this.found = false;
			variableDeclaration.setInitialValue(this.getSubstitute());
		}
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
		final ListIterator<Expression> i = functionCall.getActuals().listIterator();
		while (i.hasNext()) {
			i.next().accept(this);

			if (this.found) {
				this.found = false;
				i.set(this.getSubstitute());
			}
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

			if (this.found) {
				found = false;
				variableReference.setIndex(this.getSubstitute());
			}
		}
	}
}