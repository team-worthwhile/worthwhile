package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;

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

	/**
	 * Primitive to uniquely identify the newly created {@link VariableDeclaration}s that hold the function return
	 * values (uniquely among themselves).
	 */
	private int index = 0;

	@Override
	public void visit(final FunctionCall functionCall) {
		final FunctionDeclaration function = functionCall.getFunction();
		// FIXME these are legal identifiers in Worthwhile, avoid conflicts
		final String name = new String("_" + function.getName() + index++);
		final VariableDeclaration variable = AstNodeCreatorHelper.createVariableDeclaration(
		                AstNodeCloneHelper.clone(function.getReturnType()), name);

		this.parameters.peek().put(variable, functionCall);

		super.setFound(true);
		super.setSubstitute(AstNodeCreatorHelper.createVariableReference(variable));
	}

	/**
	 * 
	 * @param call
	 *                the {@link FunctionCall} the total precondition is calculated for
	 * @return a <code>Conjunction</code> of the {@link FunctionDeclaration}'s {@link Precondition}
	 *         {@link Expression}s that <code>call</code> references with the actuals inserted
	 */
	private Expression getPrecondition(final FunctionCall call) {
		Expression precondition = null;

		final FunctionDeclaration function = call.getFunction();

		final List<Precondition> preconditions = function.getPreconditions();
		if (!preconditions.isEmpty()) {
			final Iterator<Precondition> p = preconditions.iterator();
			precondition = AstNodeCloneHelper.clone(p.next().getExpression());
			while (p.hasNext()) {
				precondition = AstNodeCreatorHelper.createConjunction(precondition,
				                AstNodeCloneHelper.clone(p.next().getExpression()));
			}
		}

		// insert the actual Expressions into the FunctionCall parameters
		final Iterator<VariableDeclaration> parameters = function.getParameters().iterator();
		final Iterator<Expression> actuals = call.getActuals().iterator();
		while (parameters.hasNext()) {
			final VariableDeclaration parameter = parameters.next();
			final Expression actual = actuals.next();
			if (precondition != null) {
				VariableReferenceSubstitution.substitute(precondition, parameter, actual);
			}
		}

		return precondition;
	}

	/**
	 * 
	 * @param call
	 *                the {@link FunctionCall} the total postcondition is calculated for
	 * @return a <code>Conjunction</code> of the {@link FunctionDeclaration}'s {@link Postcondition}
	 *         {@link Expression}s that <code>call</code> references with the actuals inserted
	 */
	private Expression getPostcondition(final FunctionCall call) {
		Expression postcondition = null;

		final FunctionDeclaration function = call.getFunction();

		final List<Postcondition> postconditions = function.getPostconditions();
		if (!postconditions.isEmpty()) {
			final Iterator<Postcondition> p = postconditions.iterator();
			postcondition = AstNodeCloneHelper.clone(p.next().getExpression());
			while (p.hasNext()) {
				postcondition = AstNodeCreatorHelper.createConjunction(postcondition,
				                AstNodeCloneHelper.clone(p.next().getExpression()));
			}
		}

		// insert the actual Expressions into the FunctionCall parameters
		final Iterator<VariableDeclaration> parameters = function.getParameters().iterator();
		final Iterator<Expression> actuals = call.getActuals().iterator();
		while (parameters.hasNext()) {
			final VariableDeclaration parameter = parameters.next();
			final Expression actual = actuals.next();
			if (postcondition != null) {
				VariableReferenceSubstitution.substitute(postcondition, parameter, actual);
			}
		}

		return postcondition;
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
				final Expression precondition = getPrecondition(this.parameters.peek().get(variable));
				final Expression postcondition = getPostcondition(this.parameters.peek().get(variable));

				if (precondition != null) {
					i.add(AstNodeCreatorHelper.createAssertion(precondition));
				}

				i.add(variable);

				if (postcondition != null) {
					ReturnValueReferenceSubstitution.substitute(postcondition,
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
	public void visit(final Annotation annotation) {
		this.parameters.push(new LinkedHashMap<VariableDeclaration, FunctionCall>());
		annotation.getExpression().accept(this);
		final Set<VariableDeclaration> returnVariables = this.parameters.peek().keySet();
		for (final VariableDeclaration variable : returnVariables) {
			final Expression precondition = getPrecondition(this.parameters.peek().get(variable));
			final Expression postcondition = getPostcondition(this.parameters.peek().get(variable));

			Expression expression = annotation.getExpression();
			annotation.setExpression(null);

			if (postcondition != null) {
				ReturnValueReferenceSubstitution.substitute(postcondition,
				                AstNodeCreatorHelper.createVariableReference(variable));

				expression = AstNodeCreatorHelper.createImplication(postcondition, expression);
			}

			expression = AstNodeCreatorHelper.createForAllQuantifier(variable, expression);

			if (precondition != null) {
				expression = AstNodeCreatorHelper.createConjunction(precondition, expression);
			}

			annotation.setExpression(expression);
		}

		this.parameters.pop();
	}
}