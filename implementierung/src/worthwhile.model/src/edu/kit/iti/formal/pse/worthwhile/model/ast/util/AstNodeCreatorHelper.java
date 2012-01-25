package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import java.math.BigInteger;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * Provides convenience methods for the creation of several {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
public final class AstNodeCreatorHelper {
	/**
	 * Private default constructor.
	 */
	private AstNodeCreatorHelper() {
		super();
	}

	/**
	 * The {@link AstFactory} singleton whose create methods are used to instantiate the {@link ASTNode}s.
	 */
	private static AstFactory factory = AstFactory.eINSTANCE;

	/**
	 * 
	 * @param value
	 *                the {@link Boolean} value to be represented by the {@link BooleanLiteral}
	 * @return a <code>BooleanLiteral</code> that represents <code>value</code>
	 */
	public static BooleanLiteral createBooleanLiteral(final Boolean value) {
		final BooleanLiteral booleanLiteral = AstNodeCreatorHelper.factory.createBooleanLiteral();
		booleanLiteral.setValue(value);
		return booleanLiteral;
	}

	/**
	 * 
	 * @return a {@link BooleanLiteral} that represents the value <code>true</code>
	 */
	public static BooleanLiteral createTrueLiteral() {
		return AstNodeCreatorHelper.createBooleanLiteral(true);
	}

	/**
	 * 
	 * @return a {@link BooleanLiteral} that represents the value <code>false</code>
	 */
	public static BooleanLiteral createFalseLiteral() {
		return AstNodeCreatorHelper.createBooleanLiteral(false);
	}

	/**
	 * 
	 * @param value
	 *                the {@link BigInteger} value to be represented by the {@link IntegerLiteral}
	 * @return an <code>IntegerLiteral</code> that represents <code>value</code>
	 */
	public static IntegerLiteral createIntegerLiteral(final BigInteger value) {
		final IntegerLiteral integerLiteral = AstNodeCreatorHelper.factory.createIntegerLiteral();
		integerLiteral.setValue(value);
		return integerLiteral;
	}

	/**
	 * 
	 * @param operand
	 *                the {@link Negation} operand
	 * @return a <code>Negation</code> that has the given operand
	 */
	public static Negation createNegation(final Expression operand) {
		final Negation negation = AstNodeCreatorHelper.factory.createNegation();
		negation.setOperand(operand);
		return negation;
	}

	/**
	 * 
	 * @param left
	 *                the left {@link Conjunction} operand
	 * @param right
	 *                the right <code>Conjunction</code> operand
	 * @return a <code>Conjunction</code> that has the given <code>left</code> and <code>right</code> operands
	 */
	public static Conjunction createConjunction(final Expression left, final Expression right) {
		final Conjunction conjunction = AstNodeCreatorHelper.factory.createConjunction();
		conjunction.setLeft(left);
		conjunction.setRight(right);
		return conjunction;
	}

	/**
	 * 
	 * @return a {@link Conjunction} that does not have any operands set yet
	 */
	public static Conjunction createConjunction() {
		return AstNodeCreatorHelper.createConjunction(null, null);
	}

	/**
	 * 
	 * @param left
	 *                the left {@link Equal} operand
	 * @param right
	 *                the right <code>Equal</code> operand
	 * @return an <code>Equal</code> that has the given <code>left</code> and <code>right</code> operands
	 */
	public static Equal createEqual(final Expression left, final Expression right) {
		final Equal equal = AstNodeCreatorHelper.factory.createEqual();
		equal.setLeft(left);
		equal.setRight(right);
		return equal;
	}

	/**
	 * 
	 * @param left
	 *                the left {@link Implication} operand
	 * @param right
	 *                the right <code>Implication</code> operand
	 * @return an <code>Implication</code> that has the given <code>left</code> and <code>right</code> operands
	 */
	public static Implication createImplication(final Expression left, final Expression right) {
		final Implication implication = AstNodeCreatorHelper.factory.createImplication();
		implication.setLeft(left);
		implication.setRight(right);
		return implication;
	}

	/**
	 * 
	 * @return an {@link Implication} that does not have any operands set yet
	 */
	public static Implication createImplication() {
		return AstNodeCreatorHelper.createImplication(null, null);
	}

	/**
	 * 
	 * @param parameter
	 *                the bound {@link VariableDeclaration}
	 * @param condition
	 *                the <code>parameters</code> attribute
	 * @param expression
	 *                the quantified {@link Expression}
	 * @return a {@link ForAllQuantifier} that bounds the given constrained <code>parameter</code> in the given
	 *         <code>expression</code>
	 */
	public static ForAllQuantifier createForAllQuantifier(final VariableDeclaration parameter,
	                final Expression condition, final Expression expression) {
		final ForAllQuantifier forAllQuantifier = AstNodeCreatorHelper.factory.createForAllQuantifier();
		forAllQuantifier.setParameter(parameter);
		forAllQuantifier.setExpression(expression);
		return forAllQuantifier;
	}

	/**
	 * 
	 * @param parameter
	 *                the bound {@link VariableDeclaration}
	 * @param expression
	 *                the quantified {@link Expression}
	 * @return a {@link ForAllQuantifier} that bounds the given <code>parameter</code> in the given
	 *         <code>expression</code>
	 */
	public static ForAllQuantifier createForAllQuantifier(final VariableDeclaration parameter,
	                final Expression expression) {
		return AstNodeCreatorHelper.createForAllQuantifier(parameter, null, expression);
	}

	/**
	 * 
	 * @param variable
	 *                the {@link VariableDeclaration} that is referenced
	 * @return a {@link VariableReference} that references the given <code>variable</code>
	 */
	public static VariableReference createVariableReference(final VariableDeclaration variable) {
		final VariableReference variableReference = AstNodeCreatorHelper.factory.createVariableReference();
		variableReference.setVariable(variable);
		return variableReference;
	}
}
