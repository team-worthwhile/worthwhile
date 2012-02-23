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
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Visitor that substitutes one {@link VariableDeclaration} with another one.
 * 
 * @author Leon Handreke
 */
public class VariableDeclarationSubstitutionVisitor extends HierarchialASTNodeVisitor {
	/**
	 * {@link VariableDeclaration} that will be substituted.
	 */
	private VariableDeclaration substitutedVariableDeclaration;

	/**
	 * {@link VariableDeclaration} that the declaration to substitute will be substituted with.
	 */
	private VariableDeclaration substituteVariableDeclaration;

	/**
	 * Constructs a new instance with the given {@link VariableDeclaration} to substitute and the
	 * {@link VariableDeclaration} to substitute it with.
	 * 
	 * @param substitutedVariableDeclaration
	 *                the declaration to be substituted
	 * @param substituteVariableDeclaration
	 *                the declaration to substitute with
	 */
	public VariableDeclarationSubstitutionVisitor(final VariableDeclaration substitutedVariableDeclaration,
	                final VariableDeclaration substituteVariableDeclaration) {
		this.substitutedVariableDeclaration = substitutedVariableDeclaration;
		this.substituteVariableDeclaration = substituteVariableDeclaration;
	}

	@Override
	public final void visit(final Program program) {
		program.getMainBlock().accept(this);
	}

	@Override
	public final void visit(final FunctionDeclaration functionDeclaration) {
		for (final Precondition p : functionDeclaration.getPreconditions()) {
			p.accept(this);
		}
		for (final Postcondition p : functionDeclaration.getPostconditions()) {
			p.accept(this);
		}
		functionDeclaration.getBody().accept(this);
	}

	@Override
	public final void visit(final Annotation annotation) {
		annotation.getExpression().accept(this);
	}

	@Override
	public final void visit(final ArrayLiteral arrayLiteral) {
		final ListIterator<Expression> i = arrayLiteral.getValues().listIterator();
		while (i.hasNext()) {
			i.next().accept(this);
		}
	}

	@Override
	public final void visit(final ArrayFunction arrayFunction) {
		final Expression index = arrayFunction.getIndex();
		if (index != null) {
			index.accept(this);
		}
		arrayFunction.getValue().accept(this);
		final Expression chainedFunction = arrayFunction.getChainedFunction();
		if (chainedFunction != null) {
			chainedFunction.accept(this);
		}
	}

	@Override
	public final void visit(final ArrayFunctionAccess arrayFunctionAccess) {
		arrayFunctionAccess.getFunction().accept(this);
		arrayFunctionAccess.getIndex().accept(this);
	}

	@Override
	public final void visit(final Assignment assignment) {
		assignment.getValue().accept(this);
	}

	@Override
	public final void visit(final Block block) {
		for (final Statement s : block.getStatements()) {
			s.accept(this);
		}
	}

	@Override
	public final void visit(final Conditional conditional) {
		conditional.getCondition().accept(this);
		conditional.getTrueBlock().accept(this);
		final Block falseBlock = conditional.getFalseBlock();
		if (falseBlock != null) {
			falseBlock.accept(this);
		}
	}

	@Override
	public final void visit(final Loop loop) {
		loop.getCondition().accept(this);
		for (final Invariant i : loop.getInvariants()) {
			i.accept(this);
		}
		loop.getBody().accept(this);
	}

	@Override
	public final void visit(final ReturnStatement returnStatement) {
		returnStatement.getReturnValue().accept(this);
	}

	@Override
	public final void visit(final VariableDeclaration variableDeclaration) {
		// TODO: Maybe fiddling with the initial value is desired after all?
		//variableDeclaration.getInitialValue().accept(this);
	}

	@Override
	public final void visit(final QuantifiedExpression quantifiedExpression) {
		// replace the VariableDeclaration if matching
		if (quantifiedExpression.getParameter().equals(substitutedVariableDeclaration)) {
			quantifiedExpression.setParameter(substituteVariableDeclaration);
		}
		final Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			condition.accept(this);
		}

		quantifiedExpression.getExpression().accept(this);
	}

	@Override
	public final void visit(final BinaryExpression binaryExpression) {
		binaryExpression.getLeft().accept(this);
		binaryExpression.getRight().accept(this);
	}

	@Override
	public final void visit(final FunctionCall functionCall) {
		final ListIterator<Expression> i = functionCall.getActuals().listIterator();
		while (i.hasNext()) {
			i.next().accept(this);
		}
	};

	@Override
	public final void visit(final UnaryExpression unaryExpression) {
		unaryExpression.getOperand().accept(this);
	}

	@Override
	public void visit(final Literal literal) {
		// we reached an Expression leaf, ignore default operation
	}

	@Override
	public final void visit(final VariableReference variableReference) {
		// replace the VariableDeclaration if matching
		if (variableReference.getVariable().equals(substitutedVariableDeclaration)) {
			variableReference.setVariable(substituteVariableDeclaration);
		}
		final Expression index = variableReference.getIndex();
		if (index != null) {
			index.accept(this);
		}
	}
}
