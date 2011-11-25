/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.example.mydsl.myDsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MyDslFactoryImpl extends EFactoryImpl implements MyDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MyDslFactory init()
  {
    try
    {
      MyDslFactory theMyDslFactory = (MyDslFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.xtext.org/example/mydsl/MyDsl"); 
      if (theMyDslFactory != null)
      {
        return theMyDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MyDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MyDslPackage.MODEL: return createModel();
      case MyDslPackage.BLOCK: return createBlock();
      case MyDslPackage.STATEMENT: return createStatement();
      case MyDslPackage.RETURN_STATEMENT: return createReturnStatement();
      case MyDslPackage.WHILE_STATEMENT: return createWhileStatement();
      case MyDslPackage.IF_STATEMENT: return createIfStatement();
      case MyDslPackage.FUNCTION: return createFunction();
      case MyDslPackage.VARIABLE: return createVariable();
      case MyDslPackage.TYPE: return createType();
      case MyDslPackage.PRIMITIVE_TYPE: return createPrimitiveType();
      case MyDslPackage.INT_TYPE: return createIntType();
      case MyDslPackage.BOOL_TYPE: return createBoolType();
      case MyDslPackage.ARRAY_TYPE: return createArrayType();
      case MyDslPackage.FUNCTION_CALL: return createFunctionCall();
      case MyDslPackage.ANNOTATION: return createAnnotation();
      case MyDslPackage.ASSIGNMENT: return createAssignment();
      case MyDslPackage.EXPR: return createExpr();
      case MyDslPackage.EXPRESSION: return createExpression();
      case MyDslPackage.COMPARISON_TYPE: return createComparisonType();
      case MyDslPackage.LESS_COMPARISON_TYPE: return createLessComparisonType();
      case MyDslPackage.LESS_OR_EQUAL_COMPARISON_TYPE: return createLessOrEqualComparisonType();
      case MyDslPackage.GREATER_OR_EQUAL_COMPARISON_TYPE: return createGreaterOrEqualComparisonType();
      case MyDslPackage.GREATER_COMPARISON_TYPE: return createGreaterComparisonType();
      case MyDslPackage.ADDITION_TYPE: return createAdditionType();
      case MyDslPackage.ADDITION_OP: return createAdditionOp();
      case MyDslPackage.SUBTRACTION_OP: return createSubtractionOp();
      case MyDslPackage.MULTIPLICATION_TYPE: return createMultiplicationType();
      case MyDslPackage.MULTIPLICATION_OP: return createMultiplicationOp();
      case MyDslPackage.DIVISION_OP: return createDivisionOp();
      case MyDslPackage.MODULO_OP: return createModuloOp();
      case MyDslPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case MyDslPackage.FALSE_LITERAL: return createFalseLiteral();
      case MyDslPackage.TRUE_LITERAL: return createTrueLiteral();
      case MyDslPackage.VARIABLE_REF: return createVariableRef();
      case MyDslPackage.PARAMETER: return createParameter();
      case MyDslPackage.FUNCTION_REF: return createFunctionRef();
      case MyDslPackage.EQUALS: return createEquals();
      case MyDslPackage.COMPARE: return createCompare();
      case MyDslPackage.PLUS: return createPlus();
      case MyDslPackage.MULTI: return createMulti();
      case MyDslPackage.ARRAY_ACCESS: return createArrayAccess();
      case MyDslPackage.NUMBER_LITERAL: return createNumberLiteral();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType createPrimitiveType()
  {
    PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
    return primitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntType createIntType()
  {
    IntTypeImpl intType = new IntTypeImpl();
    return intType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolType createBoolType()
  {
    BoolTypeImpl boolType = new BoolTypeImpl();
    return boolType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayType createArrayType()
  {
    ArrayTypeImpl arrayType = new ArrayTypeImpl();
    return arrayType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionCall createFunctionCall()
  {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr createExpr()
  {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComparisonType createComparisonType()
  {
    ComparisonTypeImpl comparisonType = new ComparisonTypeImpl();
    return comparisonType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LessComparisonType createLessComparisonType()
  {
    LessComparisonTypeImpl lessComparisonType = new LessComparisonTypeImpl();
    return lessComparisonType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LessOrEqualComparisonType createLessOrEqualComparisonType()
  {
    LessOrEqualComparisonTypeImpl lessOrEqualComparisonType = new LessOrEqualComparisonTypeImpl();
    return lessOrEqualComparisonType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterOrEqualComparisonType createGreaterOrEqualComparisonType()
  {
    GreaterOrEqualComparisonTypeImpl greaterOrEqualComparisonType = new GreaterOrEqualComparisonTypeImpl();
    return greaterOrEqualComparisonType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterComparisonType createGreaterComparisonType()
  {
    GreaterComparisonTypeImpl greaterComparisonType = new GreaterComparisonTypeImpl();
    return greaterComparisonType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditionType createAdditionType()
  {
    AdditionTypeImpl additionType = new AdditionTypeImpl();
    return additionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditionOp createAdditionOp()
  {
    AdditionOpImpl additionOp = new AdditionOpImpl();
    return additionOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubtractionOp createSubtractionOp()
  {
    SubtractionOpImpl subtractionOp = new SubtractionOpImpl();
    return subtractionOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicationType createMultiplicationType()
  {
    MultiplicationTypeImpl multiplicationType = new MultiplicationTypeImpl();
    return multiplicationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicationOp createMultiplicationOp()
  {
    MultiplicationOpImpl multiplicationOp = new MultiplicationOpImpl();
    return multiplicationOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DivisionOp createDivisionOp()
  {
    DivisionOpImpl divisionOp = new DivisionOpImpl();
    return divisionOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuloOp createModuloOp()
  {
    ModuloOpImpl moduloOp = new ModuloOpImpl();
    return moduloOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral createBooleanLiteral()
  {
    BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
    return booleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FalseLiteral createFalseLiteral()
  {
    FalseLiteralImpl falseLiteral = new FalseLiteralImpl();
    return falseLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrueLiteral createTrueLiteral()
  {
    TrueLiteralImpl trueLiteral = new TrueLiteralImpl();
    return trueLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableRef createVariableRef()
  {
    VariableRefImpl variableRef = new VariableRefImpl();
    return variableRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionRef createFunctionRef()
  {
    FunctionRefImpl functionRef = new FunctionRefImpl();
    return functionRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Equals createEquals()
  {
    EqualsImpl equals = new EqualsImpl();
    return equals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Compare createCompare()
  {
    CompareImpl compare = new CompareImpl();
    return compare;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plus createPlus()
  {
    PlusImpl plus = new PlusImpl();
    return plus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multi createMulti()
  {
    MultiImpl multi = new MultiImpl();
    return multi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayAccess createArrayAccess()
  {
    ArrayAccessImpl arrayAccess = new ArrayAccessImpl();
    return arrayAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberLiteral createNumberLiteral()
  {
    NumberLiteralImpl numberLiteral = new NumberLiteralImpl();
    return numberLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslPackage getMyDslPackage()
  {
    return (MyDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MyDslPackage getPackage()
  {
    return MyDslPackage.eINSTANCE;
  }

} //MyDslFactoryImpl
