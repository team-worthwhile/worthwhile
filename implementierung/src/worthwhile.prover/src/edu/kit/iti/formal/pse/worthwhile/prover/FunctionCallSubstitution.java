package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ReturnValueReferenceSubstitution;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.SubstitutionVisitor;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * @author fabian
 * 
 */
public final class FunctionCallSubstitution extends SubstitutionVisitor<Expression> {
	/**
	 * Default constructor.
	 */
	FunctionCallSubstitution() {
		super(null);
	}

	/**
	 * The set of {@link VariableDeclaration}s that the visited {@link FunctionCall}s were replaced with.
	 * 
	 * Each <code>VariableDeclaration</code> is mapped to the <code>FunctionCall</code> it replaces.
	 */
	private Stack<Map<VariableDeclaration, FunctionCall>> parameters = new Stack<Map<VariableDeclaration, FunctionCall>>();

	@Override
	public void visit(final FunctionCall functionCall) {
		// visit actuals, which are Expressions and could contain FunctionCalls themselves
		super.visit(functionCall);

		final FunctionDeclaration function = functionCall.getFunction();
		final String name = this.getReturnVariableName(functionCall);
		final VariableDeclaration variable = AstNodeCreatorHelper.createVariableDeclaration(
		                AstNodeCloneHelper.clone(function.getReturnType()), name);

		this.parameters.peek().put(variable, functionCall);

		super.setFound(true);
		super.setSubstitute(AstNodeCreatorHelper.createVariableReference(variable));
	}

	/**
	 * Gets the name to use for a function call's return variable.
	 * 
	 * @param functionCall
	 *                The function call whose return variable to get
	 * @return A unique variable name for that function call's return variable
	 */
	private String getReturnVariableName(final FunctionCall functionCall) {
		// Prepend a "$" character to denote a function call
		String name = "$" + functionCall.getFunction().getName();

		// Append location of function call in the form @<line>@<column>
		int line = NodeHelper.getLine(functionCall);
		int offset = NodeHelper.getColumn(functionCall);

		return name + "@" + line + "@" + offset;
	}

	@Override
	public void visit(final Block block) {
		final List<Statement> statements = block.getStatements();
		final ListIterator<Statement> i = statements.listIterator();
		while (i.hasNext()) {
			parameters.push(new LinkedHashMap<VariableDeclaration, FunctionCall>());
			statements.get(i.nextIndex()).accept(this);

			// add the VariableDeclarations directly before the Statement whose Expressions references them
			final Set<VariableDeclaration> returnVariables = this.parameters.peek().keySet();
			for (final VariableDeclaration variable : returnVariables) {
				final FunctionCall call = this.parameters.peek().get(variable);
				Expression postcondition = AstNodeCreatorHelper.createPostconditionConjunction(call);

				i.add(variable);

				if (postcondition != null) {
					postcondition = ReturnValueReferenceSubstitution.substitute(call.getFunction(),
					                postcondition,
					                AstNodeCreatorHelper.createVariableReference(variable));

					i.add(AstNodeCreatorHelper.createAssumption(postcondition));
				}
			}

			// clear the return variables set before moving on to the next statement
			this.parameters.pop();

			i.next();
		}
	}

	@Override
	public void visit(final QuantifiedExpression quantifiedExpression) {
		final Expression condition = quantifiedExpression.getCondition();
		if (condition != null) {
			this.parameters.push(new LinkedHashMap<VariableDeclaration, FunctionCall>());
			condition.accept(this);

			// because we are overriding SubstitutionVisitor#visit(QuantifiedExpression) we also have to
			// take care of substituting if needed. Not substituting here may become a problem if
			// condition is a FunctionCall that demands a substitution
			if (this.getFound()) {
				quantifiedExpression.setCondition(this.getSubstitute());
				this.setFound(false);
			}

			quantifiedExpression.setCondition(this.applyFunctionAnnotations(quantifiedExpression
			                .getCondition()));

			this.parameters.pop();
		}

		this.parameters.push(new LinkedHashMap<VariableDeclaration, FunctionCall>());
		quantifiedExpression.getExpression().accept(this);

		// because we are overriding SubstitutionVisitor#visit(QuantifiedExpression) we also have to
		// take care of substituting if needed. Not substituting here may become a problem if
		// quantifiedExpression.getExpression() is a FunctionCall that demands a substitution
		if (this.getFound()) {
			quantifiedExpression.setExpression(this.getSubstitute());
			this.setFound(false);
		}

		quantifiedExpression.setExpression(this.applyFunctionAnnotations(quantifiedExpression.getExpression()));

		this.parameters.pop();
	}

	@Override
	public void visit(final FunctionAnnotation annotation) {
		this.parameters.push(new LinkedHashMap<VariableDeclaration, FunctionCall>());
		annotation.getExpression().accept(this);

		// because we are overriding SubstitutionVisitor#visit(FunctionAnnotation) we also have to take care of
		// substituting if needed. Not substituting here may become a problem if annotation.getExpression() is a
		// FunctionCall that demands a substitution
		if (this.getFound()) {
			this.setFound(false);
			annotation.setExpression(this.getSubstitute());
		}

		annotation.setExpression(this.applyFunctionAnnotations(annotation.getExpression()));

		this.parameters.pop();
	}

	/**
	 * 
	 * @param expression
	 *                the {@link Expression} for which the current {@link FunctionCallSubstitution#parameters} have
	 *                been calculated
	 * @return a new <code>Expression</code> that implies <code>expression</code> when each function call's
	 *         (retrieved from <code>parameters</code>) postcondition is assumed
	 */
	private Expression applyFunctionAnnotations(final Expression expression) {
		Expression newExpression = expression;

		final Set<VariableDeclaration> returnVariables = this.parameters.peek().keySet();
		for (final VariableDeclaration variable : returnVariables) {
			final FunctionCall call = this.parameters.peek().get(variable);
			Expression postcondition = AstNodeCreatorHelper.createPostconditionConjunction(call);

			if (postcondition != null) {
				postcondition = ReturnValueReferenceSubstitution.substitute(call.getFunction(),
				                postcondition, AstNodeCreatorHelper.createVariableReference(variable));

				newExpression = AstNodeCreatorHelper.createImplication(postcondition, newExpression);
			}

			newExpression = AstNodeCreatorHelper.createForAllQuantifier(variable, newExpression);
		}

		return newExpression;
	}
}