package edu.kit.iti.formal.pse.worthwhile.prover;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ValueReturnVisitor;

/**
 * Facade class for the {@link edu.kit.iti.formal.pse.worthwhile.prover} package.
 */
public class SpecificationChecker {
	/**
	 * The {@link ProverCaller} that is called for checking the satisfiability of formulae.
	 * 
	 * Defaults to {@link Z3Prover} instance.
	 */
	private ProverCaller prover;

	/**
	 * @return the {@link ProverCaller} that is called for checking the satisfiability of formulae
	 */
	public final ProverCaller getProver() {
		return this.prover;
	}

	/**
	 * @param prover
	 *                the {@link ProverCaller} that is called for checking the satisfiability of formulae
	 */
	public final void setProver(final ProverCaller prover) {
		this.prover = prover;
	}

	/**
	 * The {@link FormulaGenerator} that is called for generating a formula from a {@link Program}.
	 */
	private FormulaGenerator transformer;

	/**
	 * @return the transformer
	 */
	public final FormulaGenerator getTransformer() {
		return this.transformer;
	}

	/**
	 * @param transformer
	 *                the transformer to set
	 */
	public final void setTransformer(final FormulaGenerator transformer) {
		this.transformer = transformer;
	}

	/**
	 * The result of the last call to {@link prover}.
	 */
	private ProverResult checkResult;

	/**
	 * @return the checkResult
	 */
	public final ProverResult getCheckResult() {
		return this.checkResult;
	}

	/**
	 * The listener that distributes fired events to other event listeners attached to this instance.
	 */
	private final DistributorProverEventListener listener = new DistributorProverEventListener();

	/**
	 * Add an event listener to this instance.
	 * 
	 * @param listener
	 *                the listener to add
	 * @return true if adding the listener succeeded, else false
	 */
	public final boolean addProverEventListener(final IProverEventListener listener) {
		return this.listener.addProverEventListener(listener);
	}

	/**
	 * Remove an event listener to this instance.
	 * 
	 * @param listener
	 *                the listener to remove
	 * @return true if removing the listener succeeded, else false
	 */
	public final boolean removeProverEventListener(final IProverEventListener listener) {
		return this.listener.removeProverEventListener(listener);
	}

	/**
	 * Uses {@link WPStrategy} as {@link SpecificationChecker#transformer}.
	 * 
	 * @param prover
	 *                the {@link ProverCaller} that is called for checking the satisfiability of formulae
	 */
	public SpecificationChecker(final ProverCaller prover) {
		this.transformer = new WPStrategy();
		this.prover = prover;
	}

	/**
	 * This is a convenience method for calling {@link SpecificationChecker#checkFormula(Expression, Map, List)}
	 * with no axioms.
	 * 
	 * @param formula
	 *                the {@link Expression} to check
	 * @param environment
	 *                a list of variable values and axioms
	 * @return the {@link Validity} of <code>formula</code> when <code>environment</code> is applied
	 */
	// TODO we need error reporting, return UNKNOWN for now in case of ProverCallerException
	public final Validity checkFormula(final Expression formula, final Map<VariableDeclaration, Value> environment) {
		return this.checkFormula(formula, environment, Collections.EMPTY_LIST);
	}

	/**
	 * @param formula
	 *                the {@link Expression} to check
	 * @param environment
	 *                a list of variable to values mappings
	 * @param axioms
	 *                a list a of axioms
	 * @return the {@link Validity} of <code>formula</code> when <code>environment</code> is applied and
	 *         <code>axioms</code> are assumed
	 */
	public final Validity checkFormula(final Expression formula, final Map<VariableDeclaration, Value> environment,
	                final List<Expression> axioms) {
		// TODO apply Worthwhile specific runtime assertions

		Expression environmentExpression = AstNodeCreatorHelper.createTrueLiteral();
		for (final VariableDeclaration environmentVariable : environment.keySet()) {
			// create a reference to the variable
			VariableReference variableReference = AstNodeCreatorHelper
			                .createVariableReference(environmentVariable);

			Value variableValue = environment.get(environmentVariable);
			// create the literal that epxresses the value of the symbol
			Literal variableValueLiteral = new ValueReturnVisitor<Literal>() {
				@Override
				public void visitBooleanValue(final BooleanValue value) {
					this.setReturnValue(AstNodeCreatorHelper.createBooleanLiteral(value.getValue()));
				}

				@Override
				public <T extends Value> void visitCompositeValue(final CompositeValue<T> value) {
					ArrayFunction arrayValue = null;

					final Type baseType = ((ArrayType) environmentVariable.getType()).getBaseType();
					if (baseType instanceof BooleanType) {
						arrayValue = AstNodeCreatorHelper.createFalseArrayFunction();
					} else if (baseType instanceof IntegerType) {
						arrayValue = AstNodeCreatorHelper.createZeroArrayFunction();
					}

					for (Entry<BigInteger, T> entry : value.getSubValues().entrySet()) {
						final Literal indexLiteral = AstNodeCreatorHelper
						                .createIntegerLiteral(entry.getKey());
						final Literal valueLiteral = this.apply(entry.getValue());
						arrayValue = AstNodeCreatorHelper.createArrayFunction(indexLiteral,
						                valueLiteral, arrayValue);
					}

					this.setReturnValue(arrayValue);
				}

				@Override
				public void visitIntegerValue(final IntegerValue value) {
					this.setReturnValue(AstNodeCreatorHelper.createIntegerLiteral(value.getValue()));

				}
			}.apply(variableValue);

			// create the ref = literal expression
			Equal equal = AstNodeCreatorHelper.createEqual(variableReference, variableValueLiteral);

			// conjunctively add the equals to the expression expressing the environment
			environmentExpression = AstNodeCreatorHelper.createConjunction(environmentExpression, equal);
		}

		// assuming a value for a free variable is also an axiom since it cannot be proven, therefore just add
		// the actual (also called axioms in the method's signature) axioms to the environmentExpression, but
		// clone them first so that they do not get lost in their original context (like a source code AST)
		for (final Expression a : axioms) {
			environmentExpression = AstNodeCreatorHelper.createConjunction(environmentExpression,
			                AstNodeCloneHelper.clone(a));
		}

		// create the environment => expression implication
		Implication environmentImpliesFormula = AstNodeCreatorHelper.createImplication(environmentExpression,
		                AstNodeCloneHelper.clone(formula));
		return this.checkProgram(AstNodeCreatorHelper.createProgram(AstNodeCreatorHelper
		                .createAssertion(environmentImpliesFormula)));
	}

	/**
	 * Checks a formula's validity and returns the result.
	 * 
	 * @param formula
	 *                the {@link Expression} whose {@link Validity} to determine
	 * @return <code>formula</code>'s {@link Validity}
	 */
	private Validity getValidity(final Expression formula) {
		final Negation negation = AstNodeCreatorHelper.createNegation(formula);

		try {
			this.checkResult = this.prover.checkFormula(negation);
		} catch (ProverCallerException e) {
			this.checkResult = new ProverResult(e.getMessage()) {
				@Override
				public FormulaSatisfiability getSatisfiability() {
					return FormulaSatisfiability.UNKOWN;
				}
			};
		}

		// determine formula's validity based on negation's satisfiability, which is VALID only if the latter is
		// UNSATISFIABLE and INVALID only if the latter is SATISFIABLE, UNKNOWN otherwise
		Validity validity = Validity.UNKNOWN;
		if (this.checkResult != null) {
			switch (this.checkResult.getSatisfiability()) {
			case SATISFIABLE:
				validity = Validity.INVALID;
				break;
			case UNSATISFIABLE:
				validity = Validity.VALID;
				break;
			default:
				validity = Validity.UNKNOWN;
			}
		}

		return validity;
	}

	/**
	 * @param program
	 *                the {@link Program} to check
	 * @return the {@link Validity} of <code>program</code>
	 */
	public final Validity checkProgram(final Program program) {
		// TODO apply Worthwhile specific runtime assertions

		// add assertions to check that the divisors are not zero
		program.accept(new DivisionByZeroAssertionInserter());
		program.accept(new ImplicitInitialValueInserter());
		program.accept(new ArrayFunctionInserter());
		program.accept(new FunctionCallSubstitution());

		// generate formula from program
		List<Proof> provableFormulas = this.transformer.transformProgram(program);
		// remember the global program validity to return later
		Validity programValidity = Validity.UNKNOWN;
		ProverResult programProverResult = null;
		for (Proof provable : provableFormulas) {
			// get the validity from the prover
			Validity validity = this.getValidity(provable.getExpression());

			// TODO: could this be made more object-oriented by using Proof subclasses?
			// alert the event listeners of the Proof
			if (provable.getImplication() != null) {
				switch (provable.getImplication()) {
				case ASSERTION_VALID:
					this.listener.assertionVerified((Assertion) provable.getRelatedAstNodes()
					                .get(0), validity, provable.getExpression(), this
					                .getCheckResult());
					break;
				case INVARIANT_VALID_AT_ENTRY:
					this.listener.invariantValidAtEntryVerified((Invariant) provable
					                .getRelatedAstNodes().get(0), validity, provable
					                .getExpression(), this.getCheckResult());
					break;
				case INVARIANT_AND_CONDITION_IMPLIES_LOOP_BODY_PRECONDITION:
					this.listener.invariantAndConditionImplyLoopPreconditionVerified(
					                (Loop) provable.getRelatedAstNodes().get(0), validity,
					                provable.getExpression(), this.getCheckResult());
					break;
				case POSTCONDITION_VALID:
					this.listener.postconditionValidVerified((Postcondition) provable
					                .getRelatedAstNodes().get(0), validity, provable
					                .getExpression(), this.getCheckResult());
					break;
				case PROGRAM_CONFORM:
					this.listener.programVerified((Program) provable.getRelatedAstNodes().get(0),
					                validity, provable.getExpression(), this.getCheckResult());
					programValidity = validity;
					programProverResult = this.getCheckResult();
					break;
				case DIVISOR_NOT_ZERO:
					this.listener.divisorNotZeroVerified((Expression) provable.getRelatedAstNodes()
					                .get(0), validity, provable.getExpression(), this
					                .getCheckResult());
					break;
				case FUNCTION_CALL_PRECONDITION_VALID:
					this.listener.functionCallPreconditionValidVerified((FunctionCall) provable
					                .getRelatedAstNodes().get(0), validity, provable
					                .getExpression(), this.getCheckResult());
					break;
				default:
					throw new RuntimeException("Unhandled proof implication type");
				}
			}
		}
		// set the prover result for the whole program as the result to "return"
		this.checkResult = programProverResult;
		return programValidity;
	}
}
