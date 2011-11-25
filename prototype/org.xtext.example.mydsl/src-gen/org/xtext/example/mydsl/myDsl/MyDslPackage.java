/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslFactory
 * @model kind="package"
 * @generated
 */
public interface MyDslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "myDsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/example/mydsl/MyDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "myDsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MyDslPackage eINSTANCE = org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ModelImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__STATEMENTS = 0;

  /**
   * The feature id for the '<em><b>Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FUNCTIONS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.StatementImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 2;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.BlockImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 1;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ReturnStatementImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getReturnStatement()
   * @generated
   */
  int RETURN_STATEMENT = 3;

  /**
   * The feature id for the '<em><b>Return Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT__RETURN_EXPR = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Return Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.WhileStatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.WhileStatementImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getWhileStatement()
   * @generated
   */
  int WHILE_STATEMENT = 4;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.IfStatementImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 5;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__THEN = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.FunctionImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 6;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__RETURN_TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = 1;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__PARAMS = 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__BODY = 3;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.VariableImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__INITIAL_VALUE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.TypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getType()
   * @generated
   */
  int TYPE = 8;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.PrimitiveTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getPrimitiveType()
   * @generated
   */
  int PRIMITIVE_TYPE = 9;

  /**
   * The number of structural features of the '<em>Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.IntTypeImpl <em>Int Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.IntTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getIntType()
   * @generated
   */
  int INT_TYPE = 10;

  /**
   * The number of structural features of the '<em>Int Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.BoolTypeImpl <em>Bool Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.BoolTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getBoolType()
   * @generated
   */
  int BOOL_TYPE = 11;

  /**
   * The number of structural features of the '<em>Bool Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ArrayTypeImpl <em>Array Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ArrayTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getArrayType()
   * @generated
   */
  int ARRAY_TYPE = 12;

  /**
   * The feature id for the '<em><b>Base Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE__BASE_TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.FunctionCallImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 13;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__EXPR = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.AnnotationImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 14;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.AssignmentImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 15;

  /**
   * The feature id for the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__VARIABLE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__VALUE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ExprImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getExpr()
   * @generated
   */
  int EXPR = 16;

  /**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ExpressionImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 17;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPR = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ComparisonTypeImpl <em>Comparison Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ComparisonTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getComparisonType()
   * @generated
   */
  int COMPARISON_TYPE = 18;

  /**
   * The number of structural features of the '<em>Comparison Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.LessComparisonTypeImpl <em>Less Comparison Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.LessComparisonTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getLessComparisonType()
   * @generated
   */
  int LESS_COMPARISON_TYPE = 19;

  /**
   * The number of structural features of the '<em>Less Comparison Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_COMPARISON_TYPE_FEATURE_COUNT = COMPARISON_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.LessOrEqualComparisonTypeImpl <em>Less Or Equal Comparison Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.LessOrEqualComparisonTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getLessOrEqualComparisonType()
   * @generated
   */
  int LESS_OR_EQUAL_COMPARISON_TYPE = 20;

  /**
   * The number of structural features of the '<em>Less Or Equal Comparison Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_OR_EQUAL_COMPARISON_TYPE_FEATURE_COUNT = COMPARISON_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.GreaterOrEqualComparisonTypeImpl <em>Greater Or Equal Comparison Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.GreaterOrEqualComparisonTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getGreaterOrEqualComparisonType()
   * @generated
   */
  int GREATER_OR_EQUAL_COMPARISON_TYPE = 21;

  /**
   * The number of structural features of the '<em>Greater Or Equal Comparison Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_OR_EQUAL_COMPARISON_TYPE_FEATURE_COUNT = COMPARISON_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.GreaterComparisonTypeImpl <em>Greater Comparison Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.GreaterComparisonTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getGreaterComparisonType()
   * @generated
   */
  int GREATER_COMPARISON_TYPE = 22;

  /**
   * The number of structural features of the '<em>Greater Comparison Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_COMPARISON_TYPE_FEATURE_COUNT = COMPARISON_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.AdditionTypeImpl <em>Addition Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.AdditionTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAdditionType()
   * @generated
   */
  int ADDITION_TYPE = 23;

  /**
   * The number of structural features of the '<em>Addition Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.AdditionOpImpl <em>Addition Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.AdditionOpImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAdditionOp()
   * @generated
   */
  int ADDITION_OP = 24;

  /**
   * The number of structural features of the '<em>Addition Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION_OP_FEATURE_COUNT = ADDITION_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.SubtractionOpImpl <em>Subtraction Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.SubtractionOpImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSubtractionOp()
   * @generated
   */
  int SUBTRACTION_OP = 25;

  /**
   * The number of structural features of the '<em>Subtraction Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION_OP_FEATURE_COUNT = ADDITION_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.MultiplicationTypeImpl <em>Multiplication Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.MultiplicationTypeImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMultiplicationType()
   * @generated
   */
  int MULTIPLICATION_TYPE = 26;

  /**
   * The number of structural features of the '<em>Multiplication Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATION_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.MultiplicationOpImpl <em>Multiplication Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.MultiplicationOpImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMultiplicationOp()
   * @generated
   */
  int MULTIPLICATION_OP = 27;

  /**
   * The number of structural features of the '<em>Multiplication Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATION_OP_FEATURE_COUNT = MULTIPLICATION_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.DivisionOpImpl <em>Division Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.DivisionOpImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getDivisionOp()
   * @generated
   */
  int DIVISION_OP = 28;

  /**
   * The number of structural features of the '<em>Division Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVISION_OP_FEATURE_COUNT = MULTIPLICATION_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ModuloOpImpl <em>Modulo Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ModuloOpImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getModuloOp()
   * @generated
   */
  int MODULO_OP = 29;

  /**
   * The number of structural features of the '<em>Modulo Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO_OP_FEATURE_COUNT = MULTIPLICATION_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.BooleanLiteralImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 30;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__EXPR = EXPRESSION__EXPR;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.FalseLiteralImpl <em>False Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.FalseLiteralImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFalseLiteral()
   * @generated
   */
  int FALSE_LITERAL = 31;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FALSE_LITERAL__EXPR = BOOLEAN_LITERAL__EXPR;

  /**
   * The number of structural features of the '<em>False Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FALSE_LITERAL_FEATURE_COUNT = BOOLEAN_LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.TrueLiteralImpl <em>True Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.TrueLiteralImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getTrueLiteral()
   * @generated
   */
  int TRUE_LITERAL = 32;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUE_LITERAL__EXPR = BOOLEAN_LITERAL__EXPR;

  /**
   * The number of structural features of the '<em>True Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRUE_LITERAL_FEATURE_COUNT = BOOLEAN_LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.VariableRefImpl <em>Variable Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.VariableRefImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getVariableRef()
   * @generated
   */
  int VARIABLE_REF = 33;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Symbol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF__SYMBOL = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ParameterImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 34;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__TYPE = VARIABLE__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__INITIAL_VALUE = VARIABLE__INITIAL_VALUE;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionRefImpl <em>Function Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.FunctionRefImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionRef()
   * @generated
   */
  int FUNCTION_REF = 35;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_REF__EXPR = FUNCTION_CALL__EXPR;

  /**
   * The feature id for the '<em><b>Symbol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_REF__SYMBOL = FUNCTION_CALL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Actuals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_REF__ACTUALS = FUNCTION_CALL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_REF_FEATURE_COUNT = FUNCTION_CALL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.EqualsImpl <em>Equals</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.EqualsImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getEquals()
   * @generated
   */
  int EQUALS = 36;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Equals</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.CompareImpl <em>Compare</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.CompareImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getCompare()
   * @generated
   */
  int COMPARE = 37;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE__TYPE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Compare</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.PlusImpl <em>Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.PlusImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getPlus()
   * @generated
   */
  int PLUS = 38;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__TYPE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.MultiImpl <em>Multi</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.MultiImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMulti()
   * @generated
   */
  int MULTI = 39;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI__TYPE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Multi</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.ArrayAccessImpl <em>Array Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.ArrayAccessImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getArrayAccess()
   * @generated
   */
  int ARRAY_ACCESS = 40;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS__INDEX = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.example.mydsl.myDsl.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.example.mydsl.myDsl.impl.NumberLiteralImpl
   * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 41;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__EXPR = EXPRESSION__EXPR;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.xtext.example.mydsl.myDsl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.Model#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.xtext.example.mydsl.myDsl.Model#getStatements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Statements();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.Model#getFunctions <em>Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Functions</em>'.
   * @see org.xtext.example.mydsl.myDsl.Model#getFunctions()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Functions();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see org.xtext.example.mydsl.myDsl.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.Block#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.xtext.example.mydsl.myDsl.Block#getStatements()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Statements();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.xtext.example.mydsl.myDsl.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return Statement</em>'.
   * @see org.xtext.example.mydsl.myDsl.ReturnStatement
   * @generated
   */
  EClass getReturnStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.ReturnStatement#getReturnExpr <em>Return Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Expr</em>'.
   * @see org.xtext.example.mydsl.myDsl.ReturnStatement#getReturnExpr()
   * @see #getReturnStatement()
   * @generated
   */
  EReference getReturnStatement_ReturnExpr();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Statement</em>'.
   * @see org.xtext.example.mydsl.myDsl.WhileStatement
   * @generated
   */
  EClass getWhileStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.WhileStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.xtext.example.mydsl.myDsl.WhileStatement#getCondition()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.WhileStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.xtext.example.mydsl.myDsl.WhileStatement#getBody()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Body();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see org.xtext.example.mydsl.myDsl.IfStatement
   * @generated
   */
  EClass getIfStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.IfStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.xtext.example.mydsl.myDsl.IfStatement#getCondition()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.IfStatement#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see org.xtext.example.mydsl.myDsl.IfStatement#getThen()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Then();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.IfStatement#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see org.xtext.example.mydsl.myDsl.IfStatement#getElse()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Else();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see org.xtext.example.mydsl.myDsl.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Function#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.Function#getReturnType()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_ReturnType();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.Function#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.example.mydsl.myDsl.Function#getName()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.Function#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see org.xtext.example.mydsl.myDsl.Function#getParams()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Params();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Function#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.xtext.example.mydsl.myDsl.Function#getBody()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Body();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.xtext.example.mydsl.myDsl.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Type();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.example.mydsl.myDsl.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Variable#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Value</em>'.
   * @see org.xtext.example.mydsl.myDsl.Variable#getInitialValue()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_InitialValue();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.PrimitiveType
   * @generated
   */
  EClass getPrimitiveType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.IntType <em>Int Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.IntType
   * @generated
   */
  EClass getIntType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.BoolType <em>Bool Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.BoolType
   * @generated
   */
  EClass getBoolType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.ArrayType <em>Array Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.ArrayType
   * @generated
   */
  EClass getArrayType();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.ArrayType#getBaseType <em>Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.ArrayType#getBaseType()
   * @see #getArrayType()
   * @generated
   */
  EReference getArrayType_BaseType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Call</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionCall
   * @generated
   */
  EClass getFunctionCall();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see org.xtext.example.mydsl.myDsl.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.xtext.example.mydsl.myDsl.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the reference '{@link org.xtext.example.mydsl.myDsl.Assignment#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Variable</em>'.
   * @see org.xtext.example.mydsl.myDsl.Assignment#getVariable()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Assignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.xtext.example.mydsl.myDsl.Assignment#getValue()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Value();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expr
   * @generated
   */
  EClass getExpr();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Expression#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.xtext.example.mydsl.myDsl.Expression#getExpr()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Expr();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.ComparisonType <em>Comparison Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comparison Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.ComparisonType
   * @generated
   */
  EClass getComparisonType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.LessComparisonType <em>Less Comparison Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Less Comparison Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.LessComparisonType
   * @generated
   */
  EClass getLessComparisonType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.LessOrEqualComparisonType <em>Less Or Equal Comparison Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Less Or Equal Comparison Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.LessOrEqualComparisonType
   * @generated
   */
  EClass getLessOrEqualComparisonType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.GreaterOrEqualComparisonType <em>Greater Or Equal Comparison Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Or Equal Comparison Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.GreaterOrEqualComparisonType
   * @generated
   */
  EClass getGreaterOrEqualComparisonType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.GreaterComparisonType <em>Greater Comparison Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Comparison Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.GreaterComparisonType
   * @generated
   */
  EClass getGreaterComparisonType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.AdditionType <em>Addition Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Addition Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.AdditionType
   * @generated
   */
  EClass getAdditionType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.AdditionOp <em>Addition Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Addition Op</em>'.
   * @see org.xtext.example.mydsl.myDsl.AdditionOp
   * @generated
   */
  EClass getAdditionOp();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.SubtractionOp <em>Subtraction Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtraction Op</em>'.
   * @see org.xtext.example.mydsl.myDsl.SubtractionOp
   * @generated
   */
  EClass getSubtractionOp();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.MultiplicationType <em>Multiplication Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplication Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.MultiplicationType
   * @generated
   */
  EClass getMultiplicationType();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.MultiplicationOp <em>Multiplication Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplication Op</em>'.
   * @see org.xtext.example.mydsl.myDsl.MultiplicationOp
   * @generated
   */
  EClass getMultiplicationOp();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.DivisionOp <em>Division Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Division Op</em>'.
   * @see org.xtext.example.mydsl.myDsl.DivisionOp
   * @generated
   */
  EClass getDivisionOp();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.ModuloOp <em>Modulo Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modulo Op</em>'.
   * @see org.xtext.example.mydsl.myDsl.ModuloOp
   * @generated
   */
  EClass getModuloOp();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see org.xtext.example.mydsl.myDsl.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.FalseLiteral <em>False Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>False Literal</em>'.
   * @see org.xtext.example.mydsl.myDsl.FalseLiteral
   * @generated
   */
  EClass getFalseLiteral();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.TrueLiteral <em>True Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>True Literal</em>'.
   * @see org.xtext.example.mydsl.myDsl.TrueLiteral
   * @generated
   */
  EClass getTrueLiteral();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.VariableRef <em>Variable Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Ref</em>'.
   * @see org.xtext.example.mydsl.myDsl.VariableRef
   * @generated
   */
  EClass getVariableRef();

  /**
   * Returns the meta object for the reference '{@link org.xtext.example.mydsl.myDsl.VariableRef#getSymbol <em>Symbol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Symbol</em>'.
   * @see org.xtext.example.mydsl.myDsl.VariableRef#getSymbol()
   * @see #getVariableRef()
   * @generated
   */
  EReference getVariableRef_Symbol();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.xtext.example.mydsl.myDsl.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.FunctionRef <em>Function Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Ref</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionRef
   * @generated
   */
  EClass getFunctionRef();

  /**
   * Returns the meta object for the reference '{@link org.xtext.example.mydsl.myDsl.FunctionRef#getSymbol <em>Symbol</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Symbol</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionRef#getSymbol()
   * @see #getFunctionRef()
   * @generated
   */
  EReference getFunctionRef_Symbol();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.example.mydsl.myDsl.FunctionRef#getActuals <em>Actuals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actuals</em>'.
   * @see org.xtext.example.mydsl.myDsl.FunctionRef#getActuals()
   * @see #getFunctionRef()
   * @generated
   */
  EReference getFunctionRef_Actuals();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Equals <em>Equals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equals</em>'.
   * @see org.xtext.example.mydsl.myDsl.Equals
   * @generated
   */
  EClass getEquals();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Equals#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.example.mydsl.myDsl.Equals#getLeft()
   * @see #getEquals()
   * @generated
   */
  EReference getEquals_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Equals#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.example.mydsl.myDsl.Equals#getRight()
   * @see #getEquals()
   * @generated
   */
  EReference getEquals_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Compare <em>Compare</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compare</em>'.
   * @see org.xtext.example.mydsl.myDsl.Compare
   * @generated
   */
  EClass getCompare();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Compare#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.example.mydsl.myDsl.Compare#getLeft()
   * @see #getCompare()
   * @generated
   */
  EReference getCompare_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Compare#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.Compare#getType()
   * @see #getCompare()
   * @generated
   */
  EReference getCompare_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Compare#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.example.mydsl.myDsl.Compare#getRight()
   * @see #getCompare()
   * @generated
   */
  EReference getCompare_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus</em>'.
   * @see org.xtext.example.mydsl.myDsl.Plus
   * @generated
   */
  EClass getPlus();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Plus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.example.mydsl.myDsl.Plus#getLeft()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Plus#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.Plus#getType()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Plus#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.example.mydsl.myDsl.Plus#getRight()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.Multi <em>Multi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi</em>'.
   * @see org.xtext.example.mydsl.myDsl.Multi
   * @generated
   */
  EClass getMulti();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Multi#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.xtext.example.mydsl.myDsl.Multi#getLeft()
   * @see #getMulti()
   * @generated
   */
  EReference getMulti_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Multi#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.xtext.example.mydsl.myDsl.Multi#getType()
   * @see #getMulti()
   * @generated
   */
  EReference getMulti_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.Multi#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.xtext.example.mydsl.myDsl.Multi#getRight()
   * @see #getMulti()
   * @generated
   */
  EReference getMulti_Right();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.ArrayAccess <em>Array Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Access</em>'.
   * @see org.xtext.example.mydsl.myDsl.ArrayAccess
   * @generated
   */
  EClass getArrayAccess();

  /**
   * Returns the meta object for the containment reference '{@link org.xtext.example.mydsl.myDsl.ArrayAccess#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see org.xtext.example.mydsl.myDsl.ArrayAccess#getIndex()
   * @see #getArrayAccess()
   * @generated
   */
  EReference getArrayAccess_Index();

  /**
   * Returns the meta object for class '{@link org.xtext.example.mydsl.myDsl.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal</em>'.
   * @see org.xtext.example.mydsl.myDsl.NumberLiteral
   * @generated
   */
  EClass getNumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.example.mydsl.myDsl.NumberLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.xtext.example.mydsl.myDsl.NumberLiteral#getValue()
   * @see #getNumberLiteral()
   * @generated
   */
  EAttribute getNumberLiteral_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MyDslFactory getMyDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ModelImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__STATEMENTS = eINSTANCE.getModel_Statements();

    /**
     * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FUNCTIONS = eINSTANCE.getModel_Functions();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.BlockImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.StatementImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ReturnStatementImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getReturnStatement()
     * @generated
     */
    EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

    /**
     * The meta object literal for the '<em><b>Return Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETURN_STATEMENT__RETURN_EXPR = eINSTANCE.getReturnStatement_ReturnExpr();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.WhileStatementImpl <em>While Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.WhileStatementImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getWhileStatement()
     * @generated
     */
    EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__BODY = eINSTANCE.getWhileStatement_Body();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.IfStatementImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getIfStatement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__THEN = eINSTANCE.getIfStatement_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE = eINSTANCE.getIfStatement_Else();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.FunctionImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__RETURN_TYPE = eINSTANCE.getFunction_ReturnType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__PARAMS = eINSTANCE.getFunction_Params();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__BODY = eINSTANCE.getFunction_Body();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.VariableImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__INITIAL_VALUE = eINSTANCE.getVariable_InitialValue();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.TypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.PrimitiveTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getPrimitiveType()
     * @generated
     */
    EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.IntTypeImpl <em>Int Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.IntTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getIntType()
     * @generated
     */
    EClass INT_TYPE = eINSTANCE.getIntType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.BoolTypeImpl <em>Bool Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.BoolTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getBoolType()
     * @generated
     */
    EClass BOOL_TYPE = eINSTANCE.getBoolType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ArrayTypeImpl <em>Array Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ArrayTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getArrayType()
     * @generated
     */
    EClass ARRAY_TYPE = eINSTANCE.getArrayType();

    /**
     * The meta object literal for the '<em><b>Base Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE__BASE_TYPE = eINSTANCE.getArrayType_BaseType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionCallImpl <em>Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.FunctionCallImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionCall()
     * @generated
     */
    EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.AnnotationImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.AssignmentImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__VARIABLE = eINSTANCE.getAssignment_Variable();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ExprImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getExpr()
     * @generated
     */
    EClass EXPR = eINSTANCE.getExpr();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ExpressionImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPR = eINSTANCE.getExpression_Expr();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ComparisonTypeImpl <em>Comparison Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ComparisonTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getComparisonType()
     * @generated
     */
    EClass COMPARISON_TYPE = eINSTANCE.getComparisonType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.LessComparisonTypeImpl <em>Less Comparison Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.LessComparisonTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getLessComparisonType()
     * @generated
     */
    EClass LESS_COMPARISON_TYPE = eINSTANCE.getLessComparisonType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.LessOrEqualComparisonTypeImpl <em>Less Or Equal Comparison Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.LessOrEqualComparisonTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getLessOrEqualComparisonType()
     * @generated
     */
    EClass LESS_OR_EQUAL_COMPARISON_TYPE = eINSTANCE.getLessOrEqualComparisonType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.GreaterOrEqualComparisonTypeImpl <em>Greater Or Equal Comparison Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.GreaterOrEqualComparisonTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getGreaterOrEqualComparisonType()
     * @generated
     */
    EClass GREATER_OR_EQUAL_COMPARISON_TYPE = eINSTANCE.getGreaterOrEqualComparisonType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.GreaterComparisonTypeImpl <em>Greater Comparison Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.GreaterComparisonTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getGreaterComparisonType()
     * @generated
     */
    EClass GREATER_COMPARISON_TYPE = eINSTANCE.getGreaterComparisonType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.AdditionTypeImpl <em>Addition Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.AdditionTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAdditionType()
     * @generated
     */
    EClass ADDITION_TYPE = eINSTANCE.getAdditionType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.AdditionOpImpl <em>Addition Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.AdditionOpImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getAdditionOp()
     * @generated
     */
    EClass ADDITION_OP = eINSTANCE.getAdditionOp();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.SubtractionOpImpl <em>Subtraction Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.SubtractionOpImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getSubtractionOp()
     * @generated
     */
    EClass SUBTRACTION_OP = eINSTANCE.getSubtractionOp();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.MultiplicationTypeImpl <em>Multiplication Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.MultiplicationTypeImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMultiplicationType()
     * @generated
     */
    EClass MULTIPLICATION_TYPE = eINSTANCE.getMultiplicationType();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.MultiplicationOpImpl <em>Multiplication Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.MultiplicationOpImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMultiplicationOp()
     * @generated
     */
    EClass MULTIPLICATION_OP = eINSTANCE.getMultiplicationOp();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.DivisionOpImpl <em>Division Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.DivisionOpImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getDivisionOp()
     * @generated
     */
    EClass DIVISION_OP = eINSTANCE.getDivisionOp();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ModuloOpImpl <em>Modulo Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ModuloOpImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getModuloOp()
     * @generated
     */
    EClass MODULO_OP = eINSTANCE.getModuloOp();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.BooleanLiteralImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.FalseLiteralImpl <em>False Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.FalseLiteralImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFalseLiteral()
     * @generated
     */
    EClass FALSE_LITERAL = eINSTANCE.getFalseLiteral();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.TrueLiteralImpl <em>True Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.TrueLiteralImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getTrueLiteral()
     * @generated
     */
    EClass TRUE_LITERAL = eINSTANCE.getTrueLiteral();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.VariableRefImpl <em>Variable Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.VariableRefImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getVariableRef()
     * @generated
     */
    EClass VARIABLE_REF = eINSTANCE.getVariableRef();

    /**
     * The meta object literal for the '<em><b>Symbol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_REF__SYMBOL = eINSTANCE.getVariableRef_Symbol();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ParameterImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.FunctionRefImpl <em>Function Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.FunctionRefImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getFunctionRef()
     * @generated
     */
    EClass FUNCTION_REF = eINSTANCE.getFunctionRef();

    /**
     * The meta object literal for the '<em><b>Symbol</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_REF__SYMBOL = eINSTANCE.getFunctionRef_Symbol();

    /**
     * The meta object literal for the '<em><b>Actuals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_REF__ACTUALS = eINSTANCE.getFunctionRef_Actuals();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.EqualsImpl <em>Equals</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.EqualsImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getEquals()
     * @generated
     */
    EClass EQUALS = eINSTANCE.getEquals();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALS__LEFT = eINSTANCE.getEquals_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALS__RIGHT = eINSTANCE.getEquals_Right();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.CompareImpl <em>Compare</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.CompareImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getCompare()
     * @generated
     */
    EClass COMPARE = eINSTANCE.getCompare();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARE__LEFT = eINSTANCE.getCompare_Left();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARE__TYPE = eINSTANCE.getCompare_Type();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARE__RIGHT = eINSTANCE.getCompare_Right();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.PlusImpl <em>Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.PlusImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getPlus()
     * @generated
     */
    EClass PLUS = eINSTANCE.getPlus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__LEFT = eINSTANCE.getPlus_Left();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__TYPE = eINSTANCE.getPlus_Type();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__RIGHT = eINSTANCE.getPlus_Right();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.MultiImpl <em>Multi</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.MultiImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getMulti()
     * @generated
     */
    EClass MULTI = eINSTANCE.getMulti();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI__LEFT = eINSTANCE.getMulti_Left();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI__TYPE = eINSTANCE.getMulti_Type();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI__RIGHT = eINSTANCE.getMulti_Right();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.ArrayAccessImpl <em>Array Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.ArrayAccessImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getArrayAccess()
     * @generated
     */
    EClass ARRAY_ACCESS = eINSTANCE.getArrayAccess();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS__INDEX = eINSTANCE.getArrayAccess_Index();

    /**
     * The meta object literal for the '{@link org.xtext.example.mydsl.myDsl.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.example.mydsl.myDsl.impl.NumberLiteralImpl
     * @see org.xtext.example.mydsl.myDsl.impl.MyDslPackageImpl#getNumberLiteral()
     * @generated
     */
    EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_LITERAL__VALUE = eINSTANCE.getNumberLiteral_Value();

  }

} //MyDslPackage
