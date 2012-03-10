package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.SubstitutionVisitor;

/**
 * Visitor that inserts an implicit assertion that a function's precondition is met into the formula.
 * 
 * @author Joachim
 * 
 */
public class FunctionCallPreconditionInserter extends SubstitutionVisitor<Expression> {

	/**
	 * Default constructor.
	 */
	public FunctionCallPreconditionInserter() {
		super(null);
	}

	/**
	 * A stack that holds a set of function calls for each block, function annotation, and quantified expression
	 */
	private Stack<Set<FunctionCall>> functionCalls = new Stack<Set<FunctionCall>>();

	@Override
	public void visit(final FunctionCall functionCall) {
		// visit actuals, which are Expressions and could contain FunctionCalls themselves
		super.visit(functionCall);

		this.functionCalls.peek().add(functionCall);
	}

	@Override
	public void visit(final Block block) {
		final List<Statement> statements = block.getStatements();
		final ListIterator<Statement> i = statements.listIterator();
		while (i.hasNext()) {
			functionCalls.push(new HashSet<FunctionCall>());
			statements.get(i.nextIndex()).accept(this);

			for (final FunctionCall call : this.functionCalls.peek()) {
				final Expression precondition = AstNodeCreatorHelper
				                .createPreconditionConjunction(call);

				if (precondition != null) {
					// the function call is the node that is actually guarded
					FunctionCallPreconditionAssertion assertion;
					assertion = AstNodeCreatorHelper.createFunctionCallPreconditionAssertion(
					                precondition, call);
					i.add(assertion);
				}
			}

			// clear the function calls set before moving on to the next statement
			this.functionCalls.pop();

			i.next();
		}
	}

	@Override
	public void visit(final QuantifiedExpression quantifiedExpression) {
		final Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			this.functionCalls.push(new HashSet<FunctionCall>());
			condition.accept(this);
			quantifiedExpression.setCondition(this.applyFunctionPreconditions(quantifiedExpression
			                .getCondition()));

			this.functionCalls.pop();
		}

		this.functionCalls.push(new HashSet<FunctionCall>());
		quantifiedExpression.getExpression().accept(this);
		quantifiedExpression
		                .setExpression(this.applyFunctionPreconditions(quantifiedExpression.getExpression()));

		this.functionCalls.pop();
	}

	@Override
	public void visit(final FunctionAnnotation annotation) {
		this.functionCalls.push(new HashSet<FunctionCall>());
		annotation.getExpression().accept(this);
		annotation.setExpression(this.applyFunctionPreconditions(annotation.getExpression()));
		this.functionCalls.pop();
	}

	/**
	 * Builds an expression that asserts all precondition of functions currently on top of the function call stack.
	 * 
	 * @param expression
	 *                the {@link Expression} for which the current {@link FunctionCallSubstitution#functionCalls}
	 *                have been calculated
	 * @return a new <code>Expression</code> that implies <code>expression</code> when each function call's
	 *         (retrieved from <code>functionCalls</code>) precondition is fulfilled.
	 */
	private Expression applyFunctionPreconditions(final Expression expression) {
		Expression newExpression = expression;

		for (final FunctionCall call : this.functionCalls.peek()) {
			final Expression precondition = AstNodeCreatorHelper.createPreconditionConjunction(call);

			if (precondition != null) {
				newExpression = AstNodeCreatorHelper.createConjunction(precondition, newExpression);
			}
		}

		return newExpression;
	}

}
