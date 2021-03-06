package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IValueVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VariableReferenceSubstitution;

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
	 * Creates an {@link Assumption} with the given {@link Expression}.
	 * 
	 * @param expression
	 *                the <code>Expression</code> to assume
	 * @return the created <code>Assumption</code>
	 */
	public static Assumption createAssumption(final Expression expression) {
		final Assumption assumption = AstNodeCreatorHelper.factory.createAssumption();
		assumption.setExpression(expression);
		return assumption;
	}

	/**
	 * 
	 * @param values
	 *                the array element {@link Expression}s
	 * @return an {@link ArrayLiteral} whose first elements are initialized with the given <code>values</code>
	 */
	public static ArrayLiteral createArrayLiteral(final List<? extends Expression> values) {
		final ArrayLiteral arrayLiteral = AstNodeCreatorHelper.createArrayLiteral();
		arrayLiteral.getValues().addAll(values);
		return arrayLiteral;
	}

	/**
	 * Indexes not covered by the given <code>values</code> are initialized with <code>false</code>.
	 * 
	 * @param values
	 *                the value {@link Expression}s the new {@link ArrayFunction} is to be initialized with
	 * @return a new <code>ArrayFunction</code> initialized with the given <code>values</code>
	 */
	public static ArrayFunction createFalseArrayFunction(final List<? extends Expression> values) {
		final ArrayFunction arrayFunction = AstNodeCreatorHelper.createFalseArrayFunction();
		return AstNodeCreatorHelper.createArrayFunction(values, arrayFunction);
	}

	/**
	 * Indexes not covered by the given <code>values</code> are initialized with <code>0</code>.
	 * 
	 * @param values
	 *                the value {@link Expression}s the new {@link ArrayFunction} is to be initialized with
	 * @return a new <code>ArrayFunction</code> initialized with the given <code>values</code>
	 */
	public static ArrayFunction createZeroArrayFunction(final List<? extends Expression> values) {
		final ArrayFunction arrayFunction = AstNodeCreatorHelper.createZeroArrayFunction();
		return AstNodeCreatorHelper.createArrayFunction(values, arrayFunction);
	}

	/**
	 * 
	 * @param values
	 *                the {@link Expression}s to be assigned to <code>chainedFunction</code>
	 * @param chainedFunction
	 *                the to be modified {@link ArrayFunction}
	 * @return a new {@link ArrayFunction} that represents the assignment of <code>values</code> to
	 *         <code>chainedFunction</code>
	 */
	public static ArrayFunction createArrayFunction(final List<? extends Expression> values,
	                final ArrayFunction chainedFunction) {
		ArrayFunction arrayFunction = chainedFunction;

		int index = -1;
		for (final Expression v : values) {
			index++;
			final Expression indexLiteral = AstNodeCreatorHelper.createIntegerLiteral(BigInteger
			                .valueOf(index));
			arrayFunction = AstNodeCreatorHelper.createArrayFunction(indexLiteral, v, arrayFunction);
		}

		return arrayFunction;
	}

	/**
	 * 
	 * @param index
	 *                the explicit index {@link Expression} for the case distinction
	 * @param value
	 *                the value <code>Expression</code> that is returned for the given <code>index</code>
	 * @param chainedFunction
	 *                the {@link ArrayFunction} that is evaluated for all <code>Expression</code>s different from
	 *                the given <code>index</code>
	 * @return a new <code>ArrayFunction</code> returning <code>value</code> for <code>index</code> and evaluating
	 *         <code>chainedFunction</code> else
	 */
	public static ArrayFunction createArrayFunction(final Expression index, final Expression value,
	                final Expression chainedFunction) {
		final ArrayFunction arrayFunction = AstNodeCreatorHelper.createArrayFunction();
		arrayFunction.setIndex(index);
		arrayFunction.setValue(value);
		arrayFunction.setChainedFunction(chainedFunction);
		return arrayFunction;
	}

	/**
	 * 
	 * @return a new implicitly all <code>false</code> <code>ArrayFunction</code>
	 */
	public static ArrayFunction createFalseArrayFunction() {
		return AstNodeCreatorHelper.createArrayFunction(AstNodeCreatorHelper.createFalseLiteral());
	}

	/**
	 * 
	 * @return a new implicitly all <code>0</code> <code>ArrayFunction</code>
	 */
	public static ArrayFunction createZeroArrayFunction() {
		return AstNodeCreatorHelper.createArrayFunction(AstNodeCreatorHelper.createZeroLiteral());
	}

	/**
	 * @param value
	 *                the new {@link ArrayFunction}'s constant value {@link Expression}
	 * @return a new <code>ArrayFunction</code> with the given constant <code>value</code>
	 */
	public static ArrayFunction createArrayFunction(final Expression value) {
		final ArrayFunction arrayFunction = AstNodeCreatorHelper.createArrayFunction();
		arrayFunction.setIndex(null);
		arrayFunction.setValue(value);
		return arrayFunction;
	}

	/**
	 * 
	 * @return a new uninitialized <code>ArrayFunction</code>
	 */
	public static ArrayFunction createArrayFunction() {
		return AstNodeCreatorHelper.factory.createArrayFunction();
	}

	/**
	 * 
	 * @param index
	 *                the {@link Expression} for which <code>array</code> is evaluated
	 * @param array
	 *                the <code>Expression</code> to be evaluated at <code>index</code>
	 * @return a new {@link ArrayAccess} that evaluates <code>array</code> at <code>index</code>
	 */
	public static ArrayAccess createArrayAccess(final Expression index, final Expression array) {
		final ArrayAccess arrayAccess = AstNodeCreatorHelper.createArrayAccess();
		arrayAccess.setIndex(index);
		arrayAccess.setArray(array);
		return arrayAccess;
	}

	/**
	 * @return a new uninitialized {@link ArrayAccess}
	 * @return
	 */
	public static ArrayAccess createArrayAccess() {
		return AstNodeCreatorHelper.factory.createArrayAccess();
	}

	/**
	 * 
	 * @return an uninitialized {@link ArrayLiteral}
	 */
	public static ArrayLiteral createArrayLiteral() {
		return AstNodeCreatorHelper.factory.createArrayLiteral();
	}

	/**
	 * @param baseType
	 *                the {@link PrimitiveType} to set as the new {@link ArrayType}'s base type
	 * @return a new <code>ArrayType</code> with the given <code>baseType</code>
	 */
	public static ArrayType createArrayType(final PrimitiveType baseType) {
		final ArrayType arrayType = AstNodeCreatorHelper.factory.createArrayType();
		arrayType.setBaseType(baseType);
		return arrayType;
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
	 * @return a new {@link BooleanType} instance
	 */
	public static BooleanType createBooleanType() {
		return AstNodeCreatorHelper.factory.createBooleanType();
	}

	/**
	 * @param type
	 *                a {@link Type} instance
	 * @return a new {@link Literal} representing the <code>type</code>'s default value
	 */
	// FIXME: implement this logic directly in the Type classes
	public static Literal createDefaultLiteral(final Type type) {
		return new ASTNodeReturnVisitor<Literal>() {
			@Override
			public void visit(final ArrayType arrayType) {
				this.setReturnValue(AstNodeCreatorHelper.createArrayFunction(this.apply(arrayType
				                .getBaseType())));
			}

			@Override
			public void visit(final BooleanType booleanType) {
				this.setReturnValue(AstNodeCreatorHelper.createFalseLiteral());
			}

			@Override
			public void visit(final IntegerType integerType) {
				this.setReturnValue(AstNodeCreatorHelper.createZeroLiteral());

			}
		}.apply(type);
	}

	/**
	 * @param type
	 *                a {@link Type} instance
	 * @return a new {@link Value} representing the <code>type</code>'s default value
	 */
	// FIXME: implement this logic directly in the Value classes
	public static Value createDefaultValue(final Type type) {
		return new ASTNodeReturnVisitor<Value>() {
			@Override
			public void visit(final ArrayType arrayType) {
				arrayType.getBaseType().accept(this);
			}

			@Override
			public void visit(final BooleanType booleanType) {
				// visit(ArrayType) brought us here
				if (booleanType != type) {
					final Map<BigInteger, BooleanValue> map = Collections
					                .<BigInteger, BooleanValue> emptyMap();
					final PrimitiveType baseType = AstNodeCreatorHelper.createBooleanType();
					this.setReturnValue(new CompositeValue<BooleanValue>(map, baseType));
				} else {
					this.setReturnValue(new BooleanValue(false));
				}
			}

			@Override
			public void visit(final IntegerType integerType) {
				// visit(ArrayType) brought us here
				if (integerType != type) {
					final Map<BigInteger, IntegerValue> map = Collections
					                .<BigInteger, IntegerValue> emptyMap();
					final PrimitiveType baseType = AstNodeCreatorHelper.createIntegerType();
					this.setReturnValue(new CompositeValue<IntegerValue>(map, baseType));
				} else {
					this.setReturnValue(new IntegerValue(BigInteger.ZERO));
				}
			}
		}.apply(type);
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
	 * @return an <code>IntegerLiteral</code> that represents the value <code>zero</code>
	 */
	public static IntegerLiteral createZeroLiteral() {
		return AstNodeCreatorHelper.createIntegerLiteral(BigInteger.ZERO);
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
	 * Creates a {@link Conjunction} from a list of {@link Annotation} {@link Expression}s.
	 * 
	 * If <code>annotations</code> is empty a {@link BooleanLiteral} with value <code>true</code> is returned and if
	 * <code>annotations</code> consists of a single element the very same's <code>Expression</code> is returned.
	 * 
	 * @param annotations
	 *                the <code>Annotation</code>s whose <code>Expression</code>s to put together by conjunction
	 * @return a new <code>Conjunction</code> of the given <code>annotations</code>
	 */
	public static Expression createConjunction(final List<? extends Annotation> annotations) {
		Expression conjunction;

		if (annotations.isEmpty()) {
			conjunction = AstNodeCreatorHelper.createTrueLiteral();
		} else {
			final Iterator<? extends Annotation> i = annotations.iterator();
			// expressions is non empty, i has next
			conjunction = i.next().getExpression();
			while (i.hasNext()) {
				conjunction = AstNodeCreatorHelper.createConjunction(conjunction, i.next()
				                .getExpression());
			}
		}

		return conjunction;
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
	 * @param expression
	 *                the {@link Expression} the <code>guardedNode</code> is guarded with
	 * @param guardedNode
	 *                the {@link Expression} that is guarded with the given <code>expression</code>
	 * @return a new {@link DivisorNotZeroAssertion} for the given <code>guardedNode</code>
	 */
	public static DivisorNotZeroAssertion createDivisorNotZeroAssertion(final Expression expression,
	                final Expression guardedNode) {
		final DivisorNotZeroAssertion divisorNotZeroAssertion = AstNodeCreatorHelper
		                .createDivisorNotZeroAssertion();
		divisorNotZeroAssertion.setExpression(expression);
		divisorNotZeroAssertion.setGuardedNode(guardedNode);
		return divisorNotZeroAssertion;
	}

	/**
	 * @return a new {@link DivisorNotZeroAssertion}
	 */
	public static DivisorNotZeroAssertion createDivisorNotZeroAssertion() {
		return AstNodeCreatorHelper.factory.createDivisorNotZeroAssertion();
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
	 * @param expression
	 *                the {@link Expression} the <code>guardedNode</code> is guarded with
	 * @param guardedNode
	 *                the {@link FunctionCall} that is guarded with the given <code>expression</code>
	 * @return a new {@link FunctionCallPreconditionAssertion} for the given <code>guardedNode</code>
	 */
	public static FunctionCallPreconditionAssertion createFunctionCallPreconditionAssertion(
	                final Expression expression, final FunctionCall guardedNode) {
		FunctionCallPreconditionAssertion functionCallPreconditionAssertion = AstNodeCreatorHelper
		                .createFunctionCallPreconditionAssertion();
		functionCallPreconditionAssertion.setExpression(expression);
		functionCallPreconditionAssertion.setGuardedNode(guardedNode);
		return functionCallPreconditionAssertion;
	}

	/**
	 * @return a new {@link FunctionCallPreconditionAssertion}
	 */
	public static FunctionCallPreconditionAssertion createFunctionCallPreconditionAssertion() {
		return AstNodeCreatorHelper.factory.createFunctionCallPreconditionAssertion();
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
	 * @return a new {@link IntegerType} instance
	 */
	public static IntegerType createIntegerType() {
		return AstNodeCreatorHelper.factory.createIntegerType();
	}

	/**
	 * @param expression
	 *                the {@link Expression} the {@link Invariant} specifies
	 * @return a new <code>Invariant</code> with the given <code>expression</code>
	 */
	public static Invariant createInvariant(final Expression expression) {
		final edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant invariant = AstNodeCreatorHelper
		                .createInvariant();
		invariant.setExpression(expression);
		return invariant;
	}

	/**
	 * @return a new {@link Invariant} with no {@link Expression} set
	 */
	public static Invariant createInvariant() {
		return AstNodeCreatorHelper.factory.createInvariant();
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
	 * @param value
	 *                the {@link Value} to be represented by a {@link Literal}
	 * @return a <code>Literal</code> representing the given <code>value</code>
	 */
	public static Literal createLiteral(final Value value) {
		return new IValueVisitor() {
			/**
			 * A {@link Literal} representing the {@link Value} this visitor is applied to.
			 */
			private Literal literal = null;

			/**
			 * 
			 * @param value
			 *                the {@link Value} this visitor is applied to
			 * @return a {@link Literal} representing the given <code>value</code>
			 */
			private Literal apply(final Value value) {
				value.accept(this);
				return this.literal;
			}

			@Override
			public void visitIntegerValue(final IntegerValue value) {
				this.literal = AstNodeCreatorHelper.createIntegerLiteral(value.getValue());
			}

			@Override
			public <T extends Value> void visitCompositeValue(final CompositeValue<T> value) {
				this.literal = AstNodeCreatorHelper.createDefaultLiteral(value.getType());
				for (final Map.Entry<BigInteger, T> entry : value.getSubValues().entrySet()) {
					final Literal indexLiteral = AstNodeCreatorHelper.createIntegerLiteral(entry
					                .getKey());
					final Literal valueLiteral = AstNodeCreatorHelper.createLiteral(entry
					                .getValue());
					this.literal = AstNodeCreatorHelper.createArrayFunction(indexLiteral,
					                valueLiteral, this.literal);
				}
			}

			@Override
			public void visitBooleanValue(final BooleanValue value) {
				this.literal = AstNodeCreatorHelper.createBooleanLiteral(value.getValue());

			}
		}.apply(value);
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
	public static Program createProgram(final List<? extends Statement> statements) {
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
	 * @param left
	 *                the new {@link Unequal}'s left operand {@link Expression}
	 * @param right
	 *                the new <code>Unequal</code>'s right operand <code>Expression</code>
	 * @return a new <code>Unequal</code> with the given <code>left</code> and <code>right</code> operands set
	 */
	public static Unequal createUnequal(final Expression left, final Expression right) {
		final Unequal unequal = AstNodeCreatorHelper.createUnequal();
		unequal.setLeft(left);
		unequal.setRight(right);
		return unequal;
	}

	/**
	 * @return a new {@link Unequal} with no operands set
	 */
	public static Unequal createUnequal() {
		return AstNodeCreatorHelper.factory.createUnequal();
	}

	/**
	 * 
	 * @param statements
	 *                the {@link Block} statements
	 * @return a <code>Block</code> that consists of the given <code>statements</code>
	 */
	public static Block createBlock(final List<? extends Statement> statements) {
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

	/**
	 * @param call
	 *                the {@link FunctionCall} the total precondition is calculated for
	 * @return a <code>Conjunction</code> of the {@link FunctionDeclaration}'s {@link Precondition}
	 *         {@link Expression}s that <code>call</code> references with the actuals inserted
	 */
	public static Expression createPreconditionConjunction(final FunctionCall call) {
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
				precondition = VariableReferenceSubstitution
				                .substitute(precondition, parameter, actual);
			}
		}

		return precondition;
	}

	/**
	 * @param call
	 *                the {@link FunctionCall} the total postcondition is calculated for
	 * @return a <code>Conjunction</code> of the {@link FunctionDeclaration}'s {@link Postcondition}
	 *         {@link Expression}s that <code>call</code> references with the actuals inserted
	 */
	public static Expression createPostconditionConjunction(final FunctionCall call) {
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

			// insert the actual Expressions into the FunctionCall parameters
			final Iterator<VariableDeclaration> parameters = function.getParameters().iterator();
			final Iterator<Expression> actuals = call.getActuals().iterator();
			while (parameters.hasNext()) {
				final VariableDeclaration parameter = parameters.next();
				final Expression actual = actuals.next();
				postcondition = VariableReferenceSubstitution.substitute(postcondition, parameter,
				                actual);
			}
		}

		return postcondition;
	}
}
