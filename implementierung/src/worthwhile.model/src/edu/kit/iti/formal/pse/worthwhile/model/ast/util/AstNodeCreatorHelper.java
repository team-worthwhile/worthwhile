package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
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
	 * Create an {@link Assertion} with the given {@link Expression}.
	 * 
	 * @param expression
	 *                the {@link Expression} to assert
	 * @return the created {@link Assertion}
	 */
	public static Assertion createAssertion(final Expression expression) {
		final Assertion assertion = AstNodeCreatorHelper.factory.createAssertion();
		assertion.setExpression(expression);
		return assertion;
	}

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
		final Conjunction conjunction = AstNodeCreatorHelper.createConjunction();
		conjunction.setLeft(left);
		conjunction.setRight(right);
		return conjunction;
	}

	/**
	 * 
	 * @return a {@link Conjunction} that does not have any operands set yet
	 */
	public static Conjunction createConjunction() {
		return AstNodeCreatorHelper.factory.createConjunction();
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
		final Implication implication = AstNodeCreatorHelper.createImplication();
		implication.setLeft(left);
		implication.setRight(right);
		return implication;
	}

	/**
	 * 
	 * @return an {@link Implication} that does not have any operands set yet
	 */
	public static Implication createImplication() {
		return AstNodeCreatorHelper.factory.createImplication();
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
		final ForAllQuantifier forAllQuantifier = AstNodeCreatorHelper.createForAllQuantifier(parameter,
		                expression);
		forAllQuantifier.setCondition(condition);
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
		final ForAllQuantifier forAllQuantifier = AstNodeCreatorHelper.factory.createForAllQuantifier();
		forAllQuantifier.setParameter(parameter);
		forAllQuantifier.setExpression(expression);
		return forAllQuantifier;
	}

	/**
	 * 
	 * @param block
	 *                the {@link Program} main {@link Block}
	 * @return a <code>Program</code> that consists of the given <code>block</code>
	 */
	public static Program createProgram(final Block block) {
		final Program program = AstNodeCreatorHelper.factory.createProgram();
		program.setMainBlock(block);
		return program;
	}

	/**
	 * 
	 * @param statements
	 *                the {@link Program} statements
	 * @return a <code>Program</code> whose main {@link Block} consists of the given <code>statements</code>
	 */
	public static Program createProgram(final List<Statement> statements) {
		return AstNodeCreatorHelper.createProgram(AstNodeCreatorHelper.createBlock(statements));
	}

	/**
	 * 
	 * @param statement
	 *                the only {@link Program} statement
	 * @return a <code>Program</code> whose main {@link Block} consists of the given <code>statement</code>
	 */
	public static Program createProgram(final Statement statement) {
		return AstNodeCreatorHelper.createProgram(AstNodeCreatorHelper.createBlock(statement));
	}

	/**
	 * 
	 * @param statements
	 *                the {@link Block} statements
	 * @return a <code>Block</code> that consists of the given <code>statements</code>
	 */
	public static Block createBlock(final List<Statement> statements) {
		final Block block = AstNodeCreatorHelper.factory.createBlock();
		block.getStatements().addAll(statements);
		return block;
	}

	/**
	 * 
	 * @param statement
	 *                the only {@link Block} statement
	 * @return a <code>Block</code> that consists of the given <code>statement</code>
	 */
	public static Block createBlock(final Statement statement) {
		return AstNodeCreatorHelper.createBlock(Arrays.asList(statement));
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

	/**
	 * 
	 * @param type
	 *                the {@link VariableDeclaration}'s {@link Type} to be
	 * @param name
	 *                the <code>VariableDeclaration</code>'s name to be
	 * @param initialValue
	 *                the <code>VariableDeclaration</code>'s initial value {@link Expression} to be
	 * @return a <code>VariableDeclaration</code> with the given <code>type</code>, <code>name</code> and
	 *         <code>initialValue</code>
	 */
	public static VariableDeclaration createVariableDeclaration(final Type type, final String name,
	                final Expression initialValue) {
		final VariableDeclaration variableDeclaration = AstNodeCreatorHelper.createVariableDeclaration(type,
		                name);
		variableDeclaration.setInitialValue(initialValue);
		return variableDeclaration;
	}

	/**
	 * 
	 * @param type
	 *                the {@link VariableDeclaration}'s {@link Type} to be
	 * @param name
	 *                the <code>VariableDeclaration</code>'s name to be
	 * @return an uninitialized <code>VariableDeclaration</code> with the given <code>type</code> and
	 *         <code>name</code>
	 */
	public static VariableDeclaration createVariableDeclaration(final Type type, final String name) {
		final VariableDeclaration variableDeclaration = AstNodeCreatorHelper.factory
		                .createVariableDeclaration();
		variableDeclaration.setType(type);
		variableDeclaration.setName(name);
		return variableDeclaration;
	}
}
