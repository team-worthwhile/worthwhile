/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage
 * @generated
 */
public class AstFactory extends EFactoryImpl {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final AstFactory eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AstFactory init() {
		try {
			AstFactory theAstFactory = (AstFactory) EPackage.Registry.INSTANCE
			                .getEFactory("http:///ast.model.worthwhile.pse.formal.iti.kit.edu");
			if (theAstFactory != null) {
				return theAstFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AstFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AstFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AstPackage.PROGRAM:
				return createProgram();
			case AstPackage.ADDITION:
				return createAddition();
			case AstPackage.ARRAY_LITERAL:
				return createArrayLiteral();
			case AstPackage.ARRAY_TYPE:
				return createArrayType();
			case AstPackage.ASSERTION:
				return createAssertion();
			case AstPackage.GUARD_ASSERTION:
				return createGuardAssertion();
			case AstPackage.FUNCTION_CALL_PRECONDITION_ASSERTION:
				return createFunctionCallPreconditionAssertion();
			case AstPackage.DIVISOR_NOT_ZERO_ASSERTION:
				return createDivisorNotZeroAssertion();
			case AstPackage.ASSIGNMENT:
				return createAssignment();
			case AstPackage.VARIABLE_DECLARATION:
				return createVariableDeclaration();
			case AstPackage.ASSUMPTION:
				return createAssumption();
			case AstPackage.AXIOM:
				return createAxiom();
			case AstPackage.BLOCK:
				return createBlock();
			case AstPackage.BOOLEAN_LITERAL:
				return createBooleanLiteral();
			case AstPackage.BOOLEAN_TYPE:
				return createBooleanType();
			case AstPackage.CONDITIONAL:
				return createConditional();
			case AstPackage.CONJUNCTION:
				return createConjunction();
			case AstPackage.DISJUNCTION:
				return createDisjunction();
			case AstPackage.DIVISION:
				return createDivision();
			case AstPackage.EQUAL:
				return createEqual();
			case AstPackage.EQUIVALENCE:
				return createEquivalence();
			case AstPackage.EXISTS_QUANTIFIER:
				return createExistsQuantifier();
			case AstPackage.FOR_ALL_QUANTIFIER:
				return createForAllQuantifier();
			case AstPackage.FUNCTION_CALL:
				return createFunctionCall();
			case AstPackage.FUNCTION_DECLARATION:
				return createFunctionDeclaration();
			case AstPackage.PRECONDITION:
				return createPrecondition();
			case AstPackage.POSTCONDITION:
				return createPostcondition();
			case AstPackage.GREATER:
				return createGreater();
			case AstPackage.GREATER_OR_EQUAL:
				return createGreaterOrEqual();
			case AstPackage.IMPLICATION:
				return createImplication();
			case AstPackage.INTEGER_LITERAL:
				return createIntegerLiteral();
			case AstPackage.INTEGER_TYPE:
				return createIntegerType();
			case AstPackage.INVARIANT:
				return createInvariant();
			case AstPackage.LESS:
				return createLess();
			case AstPackage.LESS_OR_EQUAL:
				return createLessOrEqual();
			case AstPackage.LOOP:
				return createLoop();
			case AstPackage.MINUS:
				return createMinus();
			case AstPackage.MODULUS:
				return createModulus();
			case AstPackage.MULTIPLICATION:
				return createMultiplication();
			case AstPackage.NEGATION:
				return createNegation();
			case AstPackage.PLUS:
				return createPlus();
			case AstPackage.RETURN_STATEMENT:
				return createReturnStatement();
			case AstPackage.SUBTRACTION:
				return createSubtraction();
			case AstPackage.UNEQUAL:
				return createUnequal();
			case AstPackage.VARIABLE_REFERENCE:
				return createVariableReference();
			case AstPackage.RETURN_VALUE_REFERENCE:
				return createReturnValueReference();
			case AstPackage.EXPRESSION_EVALUATION:
				return createExpressionEvaluation();
			case AstPackage.ARRAY_FUNCTION:
				return createArrayFunction();
			case AstPackage.ARRAY_FUNCTION_ACCESS:
				return createArrayFunctionAccess();
			case AstPackage.EXPRESSION_TO_EXPRESSION_MAP:
				return (EObject) createExpressionToExpressionMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName()
				                + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		Program program = new Program();
		return program;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Addition createAddition() {
		Addition addition = new Addition();
		return addition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayLiteral createArrayLiteral() {
		ArrayLiteral arrayLiteral = new ArrayLiteral();
		return arrayLiteral;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayType createArrayType() {
		ArrayType arrayType = new ArrayType();
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Assertion createAssertion() {
		Assertion assertion = new Assertion();
		return assertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardAssertion createGuardAssertion() {
		GuardAssertion guardAssertion = new GuardAssertion();
		return guardAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCallPreconditionAssertion createFunctionCallPreconditionAssertion() {
		FunctionCallPreconditionAssertion functionCallPreconditionAssertion = new FunctionCallPreconditionAssertion();
		return functionCallPreconditionAssertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivisorNotZeroAssertion createDivisorNotZeroAssertion() {
		DivisorNotZeroAssertion divisorNotZeroAssertion = new DivisorNotZeroAssertion();
		return divisorNotZeroAssertion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		Assignment assignment = new Assignment();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclaration variableDeclaration = new VariableDeclaration();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Assumption createAssumption() {
		Assumption assumption = new Assumption();
		return assumption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Axiom createAxiom() {
		Axiom axiom = new Axiom();
		return axiom;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		Block block = new Block();
		return block;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteral booleanLiteral = new BooleanLiteral();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanType booleanType = new BooleanType();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Conditional createConditional() {
		Conditional conditional = new Conditional();
		return conditional;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Conjunction createConjunction() {
		Conjunction conjunction = new Conjunction();
		return conjunction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Disjunction createDisjunction() {
		Disjunction disjunction = new Disjunction();
		return disjunction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Division createDivision() {
		Division division = new Division();
		return division;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Equal createEqual() {
		Equal equal = new Equal();
		return equal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Equivalence createEquivalence() {
		Equivalence equivalence = new Equivalence();
		return equivalence;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExistsQuantifier createExistsQuantifier() {
		ExistsQuantifier existsQuantifier = new ExistsQuantifier();
		return existsQuantifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ForAllQuantifier createForAllQuantifier() {
		ForAllQuantifier forAllQuantifier = new ForAllQuantifier();
		return forAllQuantifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCall createFunctionCall() {
		FunctionCall functionCall = new FunctionCall();
		return functionCall;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration createFunctionDeclaration() {
		FunctionDeclaration functionDeclaration = new FunctionDeclaration();
		return functionDeclaration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Precondition createPrecondition() {
		Precondition precondition = new Precondition();
		return precondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Postcondition createPostcondition() {
		Postcondition postcondition = new Postcondition();
		return postcondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Greater createGreater() {
		Greater greater = new Greater();
		return greater;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterOrEqual createGreaterOrEqual() {
		GreaterOrEqual greaterOrEqual = new GreaterOrEqual();
		return greaterOrEqual;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Implication createImplication() {
		Implication implication = new Implication();
		return implication;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteral integerLiteral = new IntegerLiteral();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType createIntegerType() {
		IntegerType integerType = new IntegerType();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Invariant createInvariant() {
		Invariant invariant = new Invariant();
		return invariant;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Less createLess() {
		Less less = new Less();
		return less;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LessOrEqual createLessOrEqual() {
		LessOrEqual lessOrEqual = new LessOrEqual();
		return lessOrEqual;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Loop createLoop() {
		Loop loop = new Loop();
		return loop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Minus createMinus() {
		Minus minus = new Minus();
		return minus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Modulus createModulus() {
		Modulus modulus = new Modulus();
		return modulus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Multiplication createMultiplication() {
		Multiplication multiplication = new Multiplication();
		return multiplication;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Negation createNegation() {
		Negation negation = new Negation();
		return negation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Plus createPlus() {
		Plus plus = new Plus();
		return plus;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnStatement createReturnStatement() {
		ReturnStatement returnStatement = new ReturnStatement();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Subtraction createSubtraction() {
		Subtraction subtraction = new Subtraction();
		return subtraction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Unequal createUnequal() {
		Unequal unequal = new Unequal();
		return unequal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReference variableReference = new VariableReference();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnValueReference createReturnValueReference() {
		ReturnValueReference returnValueReference = new ReturnValueReference();
		return returnValueReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionEvaluation createExpressionEvaluation() {
		ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
		return expressionEvaluation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayFunction createArrayFunction() {
		ArrayFunction arrayFunction = new ArrayFunction();
		return arrayFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayFunctionAccess createArrayFunctionAccess() {
		ArrayFunctionAccess arrayFunctionAccess = new ArrayFunctionAccess();
		return arrayFunctionAccess;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Expression, Expression> createExpressionToExpressionMap() {
		ExpressionToExpressionMap expressionToExpressionMap = new ExpressionToExpressionMap();
		return expressionToExpressionMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AstPackage getAstPackage() {
		return (AstPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AstPackage getPackage() {
		return AstPackage.eINSTANCE;
	}

} // AstFactory
