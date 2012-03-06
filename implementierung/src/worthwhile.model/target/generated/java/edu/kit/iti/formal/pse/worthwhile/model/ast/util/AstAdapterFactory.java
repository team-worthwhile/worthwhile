/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import edu.kit.iti.formal.pse.worthwhile.model.ast.*;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Greater;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage
 * @generated
 */
public class AstAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static AstPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AstAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AstPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object
	 * of the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected AstSwitch<Adapter> modelSwitch = new AstSwitch<Adapter>() {
		@Override
		public Adapter caseProgram(Program object) {
			return createProgramAdapter();
		}

		@Override
		public Adapter caseASTNode(ASTNode object) {
			return createASTNodeAdapter();
		}

		@Override
		public Adapter caseAddition(Addition object) {
			return createAdditionAdapter();
		}

		@Override
		public Adapter caseBinaryExpression(BinaryExpression object) {
			return createBinaryExpressionAdapter();
		}

		@Override
		public Adapter caseExpression(Expression object) {
			return createExpressionAdapter();
		}

		@Override
		public Adapter caseUnaryExpression(UnaryExpression object) {
			return createUnaryExpressionAdapter();
		}

		@Override
		public Adapter caseArrayLiteral(ArrayLiteral object) {
			return createArrayLiteralAdapter();
		}

		@Override
		public Adapter caseLiteral(Literal object) {
			return createLiteralAdapter();
		}

		@Override
		public Adapter caseArrayType(ArrayType object) {
			return createArrayTypeAdapter();
		}

		@Override
		public Adapter caseType(Type object) {
			return createTypeAdapter();
		}

		@Override
		public Adapter casePrimitiveType(PrimitiveType object) {
			return createPrimitiveTypeAdapter();
		}

		@Override
		public Adapter caseAssertion(Assertion object) {
			return createAssertionAdapter();
		}

		@Override
		public Adapter caseGuardAssertion(GuardAssertion object) {
			return createGuardAssertionAdapter();
		}

		@Override
		public Adapter caseFunctionCallPreconditionAssertion(FunctionCallPreconditionAssertion object) {
			return createFunctionCallPreconditionAssertionAdapter();
		}

		@Override
		public Adapter caseDivisorNotZeroAssertion(DivisorNotZeroAssertion object) {
			return createDivisorNotZeroAssertionAdapter();
		}

		@Override
		public Adapter caseAnnotation(Annotation object) {
			return createAnnotationAdapter();
		}

		@Override
		public Adapter caseAssignment(Assignment object) {
			return createAssignmentAdapter();
		}

		@Override
		public Adapter caseVariableDeclaration(VariableDeclaration object) {
			return createVariableDeclarationAdapter();
		}

		@Override
		public Adapter caseAssumption(Assumption object) {
			return createAssumptionAdapter();
		}

		@Override
		public Adapter caseAxiom(Axiom object) {
			return createAxiomAdapter();
		}

		@Override
		public Adapter caseBlock(Block object) {
			return createBlockAdapter();
		}

		@Override
		public Adapter caseBooleanLiteral(BooleanLiteral object) {
			return createBooleanLiteralAdapter();
		}

		@Override
		public Adapter caseBooleanType(BooleanType object) {
			return createBooleanTypeAdapter();
		}

		@Override
		public Adapter caseConditional(Conditional object) {
			return createConditionalAdapter();
		}

		@Override
		public Adapter caseConjunction(Conjunction object) {
			return createConjunctionAdapter();
		}

		@Override
		public Adapter caseDisjunction(Disjunction object) {
			return createDisjunctionAdapter();
		}

		@Override
		public Adapter caseDivision(Division object) {
			return createDivisionAdapter();
		}

		@Override
		public Adapter caseEqual(Equal object) {
			return createEqualAdapter();
		}

		@Override
		public Adapter caseEquivalence(Equivalence object) {
			return createEquivalenceAdapter();
		}

		@Override
		public Adapter caseExistsQuantifier(ExistsQuantifier object) {
			return createExistsQuantifierAdapter();
		}

		@Override
		public Adapter caseQuantifiedExpression(QuantifiedExpression object) {
			return createQuantifiedExpressionAdapter();
		}

		@Override
		public Adapter caseForAllQuantifier(ForAllQuantifier object) {
			return createForAllQuantifierAdapter();
		}

		@Override
		public Adapter caseFunctionCall(FunctionCall object) {
			return createFunctionCallAdapter();
		}

		@Override
		public Adapter caseFunctionDeclaration(FunctionDeclaration object) {
			return createFunctionDeclarationAdapter();
		}

		@Override
		public Adapter casePrecondition(Precondition object) {
			return createPreconditionAdapter();
		}

		@Override
		public Adapter casePostcondition(Postcondition object) {
			return createPostconditionAdapter();
		}

		@Override
		public Adapter caseGreater(Greater object) {
			return createGreaterAdapter();
		}

		@Override
		public Adapter caseGreaterOrEqual(GreaterOrEqual object) {
			return createGreaterOrEqualAdapter();
		}

		@Override
		public Adapter caseImplication(Implication object) {
			return createImplicationAdapter();
		}

		@Override
		public Adapter caseIntegerLiteral(IntegerLiteral object) {
			return createIntegerLiteralAdapter();
		}

		@Override
		public Adapter caseIntegerType(IntegerType object) {
			return createIntegerTypeAdapter();
		}

		@Override
		public Adapter caseInvariant(Invariant object) {
			return createInvariantAdapter();
		}

		@Override
		public Adapter caseLess(Less object) {
			return createLessAdapter();
		}

		@Override
		public Adapter caseLessOrEqual(LessOrEqual object) {
			return createLessOrEqualAdapter();
		}

		@Override
		public Adapter caseLoop(Loop object) {
			return createLoopAdapter();
		}

		@Override
		public Adapter caseMinus(Minus object) {
			return createMinusAdapter();
		}

		@Override
		public Adapter caseSign(Sign object) {
			return createSignAdapter();
		}

		@Override
		public Adapter caseModulus(Modulus object) {
			return createModulusAdapter();
		}

		@Override
		public Adapter caseMultiplication(Multiplication object) {
			return createMultiplicationAdapter();
		}

		@Override
		public Adapter caseNegation(Negation object) {
			return createNegationAdapter();
		}

		@Override
		public Adapter casePlus(Plus object) {
			return createPlusAdapter();
		}

		@Override
		public Adapter caseReturnStatement(ReturnStatement object) {
			return createReturnStatementAdapter();
		}

		@Override
		public Adapter caseSubtraction(Subtraction object) {
			return createSubtractionAdapter();
		}

		@Override
		public Adapter caseUnequal(Unequal object) {
			return createUnequalAdapter();
		}

		@Override
		public Adapter caseVariableReference(VariableReference object) {
			return createVariableReferenceAdapter();
		}

		@Override
		public Adapter caseStatement(Statement object) {
			return createStatementAdapter();
		}

		@Override
		public Adapter caseReturnValueReference(ReturnValueReference object) {
			return createReturnValueReferenceAdapter();
		}

		@Override
		public Adapter caseSymbolReference(SymbolReference object) {
			return createSymbolReferenceAdapter();
		}

		@Override
		public Adapter caseExpressionEvaluation(ExpressionEvaluation object) {
			return createExpressionEvaluationAdapter();
		}

		@Override
		public Adapter caseArrayFunction(ArrayFunction object) {
			return createArrayFunctionAdapter();
		}

		@Override
		public Adapter caseArrayAccess(ArrayAccess object) {
			return createArrayAccessAdapter();
		}

		@Override
		public Adapter caseExpressionToExpressionMap(Map.Entry<Expression, Expression> object) {
			return createExpressionToExpressionMapAdapter();
		}

		@Override
		public Adapter caseFunctionAnnotation(FunctionAnnotation object) {
			return createFunctionAnnotationAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program <em>Program</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode <em>AST Node</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode
	 * @generated
	 */
	public Adapter createASTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Addition <em>Addition</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Addition
	 * @generated
	 */
	public Adapter createAdditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression <em>Binary Expression</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression
	 * @generated
	 */
	public Adapter createBinaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression <em>Unary Expression</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression
	 * @generated
	 */
	public Adapter createUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral <em>Array Literal</em>}'.
	 * <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral
	 * @generated
	 */
	public Adapter createArrayLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType
	 * @generated
	 */
	public Adapter createArrayTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Type <em>Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType <em>Primitive Type</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion
	 * @generated
	 */
	public Adapter createAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion <em>Guard Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion
	 * @generated
	 */
	public Adapter createGuardAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion <em>Function Call Precondition Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion
	 * @generated
	 */
	public Adapter createFunctionCallPreconditionAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion <em>Divisor Not Zero Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion
	 * @generated
	 */
	public Adapter createDivisorNotZeroAssertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration <em>Variable Declaration</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption
	 * @generated
	 */
	public Adapter createAssumptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom <em>Axiom</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom
	 * @generated
	 */
	public Adapter createAxiomAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Block <em>Block</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Block
	 * @generated
	 */
	public Adapter createBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral <em>Boolean Literal</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral
	 * @generated
	 */
	public Adapter createBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType
	 * @generated
	 */
	public Adapter createBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional <em>Conditional</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional
	 * @generated
	 */
	public Adapter createConditionalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction <em>Conjunction</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction
	 * @generated
	 */
	public Adapter createConjunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction <em>Disjunction</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction
	 * @generated
	 */
	public Adapter createDisjunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Division <em>Division</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Division
	 * @generated
	 */
	public Adapter createDivisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equal
	 * @generated
	 */
	public Adapter createEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence <em>Equivalence</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence
	 * @generated
	 */
	public Adapter createEquivalenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier <em>Exists Quantifier</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier
	 * @generated
	 */
	public Adapter createExistsQuantifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression <em>Quantified Expression</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression
	 * @generated
	 */
	public Adapter createQuantifiedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier <em>For All Quantifier</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier
	 * @generated
	 */
	public Adapter createForAllQuantifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall
	 * @generated
	 */
	public Adapter createFunctionCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration <em>Function Declaration</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration
	 * @generated
	 */
	public Adapter createFunctionDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition
	 * @generated
	 */
	public Adapter createPreconditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition <em>Postcondition</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition
	 * @generated
	 */
	public Adapter createPostconditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Greater <em>Greater</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Greater
	 * @generated
	 */
	public Adapter createGreaterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual <em>Greater Or Equal</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual
	 * @generated
	 */
	public Adapter createGreaterOrEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Implication <em>Implication</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Implication
	 * @generated
	 */
	public Adapter createImplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral <em>Integer Literal</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral
	 * @generated
	 */
	public Adapter createIntegerLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType
	 * @generated
	 */
	public Adapter createIntegerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant
	 * @generated
	 */
	public Adapter createInvariantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Less <em>Less</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Less
	 * @generated
	 */
	public Adapter createLessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual <em>Less Or Equal</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual
	 * @generated
	 */
	public Adapter createLessOrEqualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop
	 * @generated
	 */
	public Adapter createLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Minus <em>Minus</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Minus
	 * @generated
	 */
	public Adapter createMinusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Sign <em>Sign</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Sign
	 * @generated
	 */
	public Adapter createSignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus <em>Modulus</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus
	 * @generated
	 */
	public Adapter createModulusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication <em>Multiplication</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication
	 * @generated
	 */
	public Adapter createMultiplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Negation <em>Negation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Negation
	 * @generated
	 */
	public Adapter createNegationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Plus
	 * @generated
	 */
	public Adapter createPlusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement <em>Return Statement</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement
	 * @generated
	 */
	public Adapter createReturnStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction <em>Subtraction</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction
	 * @generated
	 */
	public Adapter createSubtractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal <em>Unequal</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal
	 * @generated
	 */
	public Adapter createUnequalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference <em>Variable Reference</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference
	 * @generated
	 */
	public Adapter createVariableReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference <em>Return Value Reference</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference
	 * @generated
	 */
	public Adapter createReturnValueReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference <em>Symbol Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference
	 * @generated
	 */
	public Adapter createSymbolReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation <em>Expression Evaluation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation
	 * @generated
	 */
	public Adapter createExpressionEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction <em>Array Function</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction
	 * @generated
	 */
	public Adapter createArrayFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess <em>Array Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess
	 * @generated
	 */
	public Adapter createArrayAccessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Expression To Expression Map</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createExpressionToExpressionMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation <em>Function Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation
	 * @generated
	 */
	public Adapter createFunctionAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // AstAdapterFactory
