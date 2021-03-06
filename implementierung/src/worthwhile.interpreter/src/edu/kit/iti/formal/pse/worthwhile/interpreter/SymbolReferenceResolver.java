package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.SubstitutionVisitor;

/**
 * This {@link SubstitutionVisitor} replaces {@link SymbolReference}s with {@link Literal}s representing the
 * {@link Value}s assigned to them by the execution state of an {@link InterpreterASTNodeVisitor}.
 * 
 * @author fabian
 */
// TODO: as soon as we are using ArrayAccess instead of VariableReference's index from the original AST on we can reset
// the substitute generic type to Literal again
public class SymbolReferenceResolver extends SubstitutionVisitor<Expression> {
	/**
	 * The execution state containing the {@link VariableDeclaration} to {@link Value} mapping that is used to
	 * resolve the {@link SymbolReference}s that occur in {@link Expression}s this visitor is applied to.
	 */
	private final InterpreterASTNodeVisitor interpreterState;

	/**
	 * Applies this {@link SymbolReferenceResolver} to the given {@link Expression}.
	 * 
	 * @param expression
	 *                the <code>Expression</code> in which {@link SymbolReference}s are resolved
	 * @param state
	 *                the {@link InterpreterASTNodeVisitor} whose execution state is used to resolve symbols in
	 *                <code>expression</code>
	 * @return <code>expression</code> with all symbols resolved that are mapped by <code>state</code>
	 */
	public static Expression apply(final Expression expression, final InterpreterASTNodeVisitor state) {
		final SymbolReferenceResolver visitor = new SymbolReferenceResolver(state);

		expression.accept(visitor);
		if (visitor.getFound()) {
			return visitor.getSubstitute();
		} else {
			return expression;
		}

	}

	/**
	 * @param interpreterState
	 *                an execution state containing the {@link VariableDeclaration} to {@link Value} mapping that is
	 *                used to resolve the {@link SymbolReference}s that occur in {@link Expression}s this visitor is
	 *                applied to
	 */
	SymbolReferenceResolver(final InterpreterASTNodeVisitor interpreterState) {
		// it is not necessary to clone the substitutes we set because they are not contained anywhere
		super(null, false);
		this.interpreterState = interpreterState;
	}

	@Override
	public final void visit(final ReturnValueReference returnValueReference) {
		// do not forget to visit index
		super.visit(returnValueReference);

		// when the InterpreterASTNodeVisitor is evaluating an Expression that contains ReturnValueReferences it
		// must have set a return value
		final Value value = this.interpreterState.getReturnValue();

		Expression substitute = AstNodeCreatorHelper.createLiteral(value);

		final Expression index = returnValueReference.getIndex();
		if (index != null) {
			substitute = AstNodeCreatorHelper.createArrayAccess(index, substitute);
		}

		this.setSubstitute(substitute);
		this.setFound(true);
	}

	@Override
	public final void visit(final VariableReference variableReference) {
		// do not forget to visit index
		super.visit(variableReference);

		final Value value = this.interpreterState.getSymbol(variableReference.getVariable());

		// since VariableReferences can refer to variables bound by a quantifier we do not require the state to
		// contain a mapping for all of them
		if (value != null) {
			Expression substitute = AstNodeCreatorHelper.createLiteral(value);

			final Expression index = variableReference.getIndex();
			if (index != null) {
				substitute = AstNodeCreatorHelper.createArrayAccess(index, substitute);
			}

			this.setSubstitute(substitute);
			this.setFound(true);
		}
	}
}
