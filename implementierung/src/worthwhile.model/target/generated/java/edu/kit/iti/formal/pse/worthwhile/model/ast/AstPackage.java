/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VisitorPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory
 * @model kind="package"
 * @generated
 */
public class AstPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "ast";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http:///ast.model.worthwhile.pse.formal.iti.kit.edu";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "edu.kit.iti.formal.pse.worthwhile.model.ast";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final AstPackage eINSTANCE = edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage.init();

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode <em>AST Node</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNode()
	 * @generated
	 */
	public static final int AST_NODE = 1;

	/**
	 * The number of structural features of the '<em>AST Node</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int AST_NODE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program <em>Program</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram()
	 * @generated
	 */
	public static final int PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>Function Declarations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int PROGRAM__FUNCTION_DECLARATIONS = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main Block</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROGRAM__MAIN_BLOCK = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Axioms</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROGRAM__AXIOMS = AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Program</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int PROGRAM_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Expression <em>Expression</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Expression
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExpression()
	 * @generated
	 */
	public static final int EXPRESSION = 4;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBinaryExpression()
	 * @generated
	 */
	public static final int BINARY_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Addition <em>Addition</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Addition
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAddition()
	 * @generated
	 */
	public static final int ADDITION = 2;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDITION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ADDITION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Addition</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int ADDITION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getUnaryExpression()
	 * @generated
	 */
	public static final int UNARY_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Literal <em>Literal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Literal
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLiteral()
	 * @generated
	 */
	public static final int LITERAL = 7;

	/**
	 * The number of structural features of the '<em>Literal</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral <em>Array Literal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayLiteral()
	 * @generated
	 */
	public static final int ARRAY_LITERAL = 6;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_LITERAL__VALUES = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Literal</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Type <em>Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Type
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getType()
	 * @generated
	 */
	public static final int TYPE = 9;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType <em>Array Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayType()
	 * @generated
	 */
	public static final int ARRAY_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_TYPE__BASE_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPrimitiveType()
	 * @generated
	 */
	public static final int PRIMITIVE_TYPE = 10;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Statement <em>Statement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Statement
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getStatement()
	 * @generated
	 */
	public static final int STATEMENT = 55;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int STATEMENT_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation <em>Annotation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAnnotation()
	 * @generated
	 */
	public static final int ANNOTATION = 15;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ANNOTATION__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ANNOTATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion <em>Assertion</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAssertion()
	 * @generated
	 */
	public static final int ASSERTION = 11;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSERTION__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Assertion</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSERTION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion <em>Guard Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getGuardAssertion()
	 * @generated
	 */
	public static final int GUARD_ASSERTION = 12;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_ASSERTION__EXPRESSION = ASSERTION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Guard Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_ASSERTION_FEATURE_COUNT = ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion <em>Function Call Precondition Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionCallPreconditionAssertion()
	 * @generated
	 */
	public static final int FUNCTION_CALL_PRECONDITION_ASSERTION = 13;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_CALL_PRECONDITION_ASSERTION__EXPRESSION = GUARD_ASSERTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Guarded Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_CALL_PRECONDITION_ASSERTION__GUARDED_NODE = GUARD_ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Call Precondition Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_CALL_PRECONDITION_ASSERTION_FEATURE_COUNT = GUARD_ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion <em>Divisor Not Zero Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDivisorNotZeroAssertion()
	 * @generated
	 */
	public static final int DIVISOR_NOT_ZERO_ASSERTION = 14;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIVISOR_NOT_ZERO_ASSERTION__EXPRESSION = GUARD_ASSERTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Guarded Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE = GUARD_ASSERTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Divisor Not Zero Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIVISOR_NOT_ZERO_ASSERTION_FEATURE_COUNT = GUARD_ASSERTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment <em>Assignment</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAssignment()
	 * @generated
	 */
	public static final int ASSIGNMENT = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGNMENT__VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGNMENT__VARIABLE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getVariableDeclaration()
	 * @generated
	 */
	public static final int VARIABLE_DECLARATION = 17;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_DECLARATION__TYPE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_DECLARATION__INITIAL_VALUE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_DECLARATION__NAME = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_DECLARATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption <em>Assumption</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAssumption()
	 * @generated
	 */
	public static final int ASSUMPTION = 18;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSUMPTION__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ASSUMPTION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom <em>Axiom</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAxiom()
	 * @generated
	 */
	public static final int AXIOM = 19;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int AXIOM__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Axiom</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int AXIOM_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Block <em>Block</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Block
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBlock()
	 * @generated
	 */
	public static final int BLOCK = 20;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBooleanLiteral()
	 * @generated
	 */
	public static final int BOOLEAN_LITERAL = 21;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBooleanType()
	 * @generated
	 */
	public static final int BOOLEAN_TYPE = 22;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional <em>Conditional</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional()
	 * @generated
	 */
	public static final int CONDITIONAL = 23;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONDITIONAL__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>True Block</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONDITIONAL__TRUE_BLOCK = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>False Block</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONDITIONAL__FALSE_BLOCK = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Conditional</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONDITIONAL_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction <em>Conjunction</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConjunction()
	 * @generated
	 */
	public static final int CONJUNCTION = 24;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONJUNCTION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONJUNCTION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Conjunction</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONJUNCTION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction <em>Disjunction</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDisjunction()
	 * @generated
	 */
	public static final int DISJUNCTION = 25;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DISJUNCTION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DISJUNCTION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Disjunction</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DISJUNCTION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Division <em>Division</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Division
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDivision()
	 * @generated
	 */
	public static final int DIVISION = 26;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIVISION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIVISION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Division</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int DIVISION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equal <em>Equal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equal
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getEqual()
	 * @generated
	 */
	public static final int EQUAL = 27;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Equal</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence <em>Equivalence</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getEquivalence()
	 * @generated
	 */
	public static final int EQUIVALENCE = 28;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EQUIVALENCE__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EQUIVALENCE__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Equivalence</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EQUIVALENCE_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression <em>Quantified Expression</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getQuantifiedExpression()
	 * @generated
	 */
	public static final int QUANTIFIED_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUANTIFIED_EXPRESSION__PARAMETER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUANTIFIED_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUANTIFIED_EXPRESSION__CONDITION = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Quantified Expression</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int QUANTIFIED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier <em>Exists Quantifier</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExistsQuantifier()
	 * @generated
	 */
	public static final int EXISTS_QUANTIFIER = 29;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXISTS_QUANTIFIER__PARAMETER = QUANTIFIED_EXPRESSION__PARAMETER;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXISTS_QUANTIFIER__EXPRESSION = QUANTIFIED_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXISTS_QUANTIFIER__CONDITION = QUANTIFIED_EXPRESSION__CONDITION;

	/**
	 * The number of structural features of the '<em>Exists Quantifier</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXISTS_QUANTIFIER_FEATURE_COUNT = QUANTIFIED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier <em>For All Quantifier</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getForAllQuantifier()
	 * @generated
	 */
	public static final int FOR_ALL_QUANTIFIER = 31;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_ALL_QUANTIFIER__PARAMETER = QUANTIFIED_EXPRESSION__PARAMETER;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_ALL_QUANTIFIER__EXPRESSION = QUANTIFIED_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_ALL_QUANTIFIER__CONDITION = QUANTIFIED_EXPRESSION__CONDITION;

	/**
	 * The number of structural features of the '<em>For All Quantifier</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FOR_ALL_QUANTIFIER_FEATURE_COUNT = QUANTIFIED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall <em>Function Call</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionCall()
	 * @generated
	 */
	public static final int FUNCTION_CALL = 32;

	/**
	 * The feature id for the '<em><b>Actuals</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_CALL__ACTUALS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_CALL__FUNCTION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Call</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration <em>Function Declaration</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration()
	 * @generated
	 */
	public static final int FUNCTION_DECLARATION = 33;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_DECLARATION__PRECONDITIONS = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_DECLARATION__POSTCONDITIONS = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_DECLARATION__PARAMETERS = AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_DECLARATION__BODY = AST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_DECLARATION__RETURN_TYPE = AST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_DECLARATION__NAME = AST_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Function Declaration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_DECLARATION_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation <em>Function Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionAnnotation()
	 * @generated
	 */
	public static final int FUNCTION_ANNOTATION = 62;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_ANNOTATION__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Function Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition <em>Precondition</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPrecondition()
	 * @generated
	 */
	public static final int PRECONDITION = 34;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRECONDITION__EXPRESSION = FUNCTION_ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Precondition</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PRECONDITION_FEATURE_COUNT = FUNCTION_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition <em>Postcondition</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPostcondition()
	 * @generated
	 */
	public static final int POSTCONDITION = 35;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POSTCONDITION__EXPRESSION = FUNCTION_ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Postcondition</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int POSTCONDITION_FEATURE_COUNT = FUNCTION_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Greater <em>Greater</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Greater
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getGreater()
	 * @generated
	 */
	public static final int GREATER = 36;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GREATER__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GREATER__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual <em>Greater Or Equal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getGreaterOrEqual()
	 * @generated
	 */
	public static final int GREATER_OR_EQUAL = 37;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_OR_EQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_OR_EQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater Or Equal</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_OR_EQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Implication <em>Implication</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Implication
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getImplication()
	 * @generated
	 */
	public static final int IMPLICATION = 38;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IMPLICATION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IMPLICATION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Implication</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IMPLICATION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getIntegerLiteral()
	 * @generated
	 */
	public static final int INTEGER_LITERAL = 39;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getIntegerType()
	 * @generated
	 */
	public static final int INTEGER_TYPE = 40;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant <em>Invariant</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getInvariant()
	 * @generated
	 */
	public static final int INVARIANT = 41;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INVARIANT__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Invariant</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INVARIANT_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Less <em>Less</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Less
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLess()
	 * @generated
	 */
	public static final int LESS = 42;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LESS__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LESS__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Less</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LESS_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual <em>Less Or Equal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLessOrEqual()
	 * @generated
	 */
	public static final int LESS_OR_EQUAL = 43;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LESS_OR_EQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LESS_OR_EQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Less Or Equal</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LESS_OR_EQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop <em>Loop</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLoop()
	 * @generated
	 */
	public static final int LOOP = 44;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOP__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOP__BODY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOP__INVARIANTS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int LOOP_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Sign <em>Sign</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Sign
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getSign()
	 * @generated
	 */
	public static final int SIGN = 46;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIGN__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Sign</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIGN_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Minus <em>Minus</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Minus
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getMinus()
	 * @generated
	 */
	public static final int MINUS = 45;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MINUS__OPERAND = SIGN__OPERAND;

	/**
	 * The number of structural features of the '<em>Minus</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int MINUS_FEATURE_COUNT = SIGN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus <em>Modulus</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getModulus()
	 * @generated
	 */
	public static final int MODULUS = 47;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULUS__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODULUS__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Modulus</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int MODULUS_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication <em>Multiplication</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getMultiplication()
	 * @generated
	 */
	public static final int MULTIPLICATION = 48;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLICATION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLICATION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Multiplication</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MULTIPLICATION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Negation <em>Negation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Negation
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getNegation()
	 * @generated
	 */
	public static final int NEGATION = 49;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NEGATION__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Negation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int NEGATION_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Plus <em>Plus</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Plus
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPlus()
	 * @generated
	 */
	public static final int PLUS = 50;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PLUS__OPERAND = SIGN__OPERAND;

	/**
	 * The number of structural features of the '<em>Plus</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PLUS_FEATURE_COUNT = SIGN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement <em>Return Statement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getReturnStatement()
	 * @generated
	 */
	public static final int RETURN_STATEMENT = 51;

	/**
	 * The feature id for the '<em><b>Return Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_STATEMENT__RETURN_VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_STATEMENT__FUNCTION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Return Statement</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction <em>Subtraction</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getSubtraction()
	 * @generated
	 */
	public static final int SUBTRACTION = 52;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SUBTRACTION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SUBTRACTION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Subtraction</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SUBTRACTION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal <em>Unequal</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getUnequal()
	 * @generated
	 */
	public static final int UNEQUAL = 53;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNEQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int UNEQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Unequal</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	public static final int UNEQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference <em>Symbol Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getSymbolReference()
	 * @generated
	 */
	public static final int SYMBOL_REFERENCE = 57;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SYMBOL_REFERENCE__INDEX = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Symbol Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SYMBOL_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getVariableReference()
	 * @generated
	 */
	public static final int VARIABLE_REFERENCE = 54;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_REFERENCE__INDEX = SYMBOL_REFERENCE__INDEX;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_REFERENCE__VARIABLE = SYMBOL_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_REFERENCE_FEATURE_COUNT = SYMBOL_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference <em>Return Value Reference</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getReturnValueReference()
	 * @generated
	 */
	public static final int RETURN_VALUE_REFERENCE = 56;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_VALUE_REFERENCE__INDEX = SYMBOL_REFERENCE__INDEX;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_VALUE_REFERENCE__FUNCTION = SYMBOL_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Value Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_VALUE_REFERENCE_FEATURE_COUNT = SYMBOL_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation <em>Expression Evaluation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExpressionEvaluation()
	 * @generated
	 */
	public static final int EXPRESSION_EVALUATION = 58;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_EVALUATION__EXPRESSION = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Evaluation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_EVALUATION_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction <em>Array Function</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction()
	 * @generated
	 */
	public static final int ARRAY_FUNCTION = 59;

	/**
	 * The feature id for the '<em><b>Chained Function</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_FUNCTION__CHAINED_FUNCTION = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_FUNCTION__INDEX = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_FUNCTION__VALUE = LITERAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Array Function</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_FUNCTION_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess <em>Array Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayAccess()
	 * @generated
	 */
	public static final int ARRAY_ACCESS = 60;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_ACCESS__INDEX = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_ACCESS__ARRAY = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Array Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ARRAY_ACCESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionToExpressionMap <em>Expression To Expression Map</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionToExpressionMap
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExpressionToExpressionMap()
	 * @generated
	 */
	public static final int EXPRESSION_TO_EXPRESSION_MAP = 61;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_TO_EXPRESSION_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_TO_EXPRESSION_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Expression To Expression Map</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_TO_EXPRESSION_MAP_FEATURE_COUNT = 2;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass astNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayLiteralEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionCallPreconditionAssertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass divisorNotZeroAssertionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assumptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axiomEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conjunctionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disjunctionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass divisionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equivalenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existsQuantifierEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quantifiedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forAllQuantifierEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionCallEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preconditionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postconditionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass greaterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass greaterOrEqualEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessOrEqualEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modulusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass negationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnStatementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subtractionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unequalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableReferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnValueReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass symbolReferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayAccessEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionToExpressionMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionAnnotationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AstPackage() {
		super(eNS_URI, AstFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it
	 * depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link AstPackage#eINSTANCE} when that field is accessed. Clients should
	 * not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AstPackage init() {
		if (isInited)
			return (AstPackage) EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);

		// Obtain or create and register package
		AstPackage theAstPackage = (AstPackage) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE
		                .get(eNS_URI) : new AstPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		VisitorPackage theVisitorPackage = (VisitorPackage) (EPackage.Registry.INSTANCE
		                .getEPackage(VisitorPackage.eNS_URI) instanceof VisitorPackage ? EPackage.Registry.INSTANCE
		                .getEPackage(VisitorPackage.eNS_URI) : VisitorPackage.eINSTANCE);

		// Create package meta-data objects
		theAstPackage.createPackageContents();
		theVisitorPackage.createPackageContents();

		// Initialize created meta-data
		theAstPackage.initializePackageContents();
		theVisitorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAstPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AstPackage.eNS_URI, theAstPackage);
		return theAstPackage;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program <em>Program</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program
	 * @generated
	 */
	public EClass getProgram() {
		return programEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getFunctionDeclarations <em>Function Declarations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Declarations</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getFunctionDeclarations()
	 * @see #getProgram()
	 * @generated
	 */
	public EReference getProgram_FunctionDeclarations() {
		return (EReference) programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock <em>Main Block</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Main Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock()
	 * @see #getProgram()
	 * @generated
	 */
	public EReference getProgram_MainBlock() {
		return (EReference) programEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getAxioms <em>Axioms</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Axioms</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getAxioms()
	 * @see #getProgram()
	 * @generated
	 */
	public EReference getProgram_Axioms() {
		return (EReference) programEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode <em>AST Node</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AST Node</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode
	 * @generated
	 */
	public EClass getASTNode() {
		return astNodeEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Addition <em>Addition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Addition
	 * @generated
	 */
	public EClass getAddition() {
		return additionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression
	 * @generated
	 */
	public EClass getBinaryExpression() {
		return binaryExpressionEClass;
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getLeft <em>Left</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getLeft()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	public EReference getBinaryExpression_Left() {
		return (EReference) binaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getRight <em>Right</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getRight()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	public EReference getBinaryExpression_Right() {
		return (EReference) binaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Expression
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression
	 * @generated
	 */
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression#getOperand <em>Operand</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression#getOperand()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	public EReference getUnaryExpression_Operand() {
		return (EReference) unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral <em>Array Literal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral
	 * @generated
	 */
	public EClass getArrayLiteral() {
		return arrayLiteralEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral#getValues <em>Values</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral#getValues()
	 * @see #getArrayLiteral()
	 * @generated
	 */
	public EReference getArrayLiteral_Values() {
		return (EReference) arrayLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Literal
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType
	 * @generated
	 */
	public EClass getArrayType() {
		return arrayTypeEClass;
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getBaseType <em>Base Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Base Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getBaseType()
	 * @see #getArrayType()
	 * @generated
	 */
	public EReference getArrayType_BaseType() {
		return (EReference) arrayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Type <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Type
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assertion</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion
	 * @generated
	 */
	public EClass getAssertion() {
		return assertionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion <em>Guard Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Assertion</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion
	 * @generated
	 */
	public EClass getGuardAssertion() {
		return guardAssertionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion <em>Function Call Precondition Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call Precondition Assertion</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion
	 * @generated
	 */
	public EClass getFunctionCallPreconditionAssertion() {
		return functionCallPreconditionAssertionEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion#getGuardedNode <em>Guarded Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guarded Node</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion#getGuardedNode()
	 * @see #getFunctionCallPreconditionAssertion()
	 * @generated
	 */
	public EReference getFunctionCallPreconditionAssertion_GuardedNode() {
		return (EReference) functionCallPreconditionAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion <em>Divisor Not Zero Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Divisor Not Zero Assertion</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion
	 * @generated
	 */
	public EClass getDivisorNotZeroAssertion() {
		return divisorNotZeroAssertionEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion#getGuardedNode <em>Guarded Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guarded Node</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion#getGuardedNode()
	 * @see #getDivisorNotZeroAssertion()
	 * @generated
	 */
	public EReference getDivisorNotZeroAssertion_GuardedNode() {
		return (EReference) divisorNotZeroAssertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation#getExpression <em>Expression</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation#getExpression()
	 * @see #getAnnotation()
	 * @generated
	 */
	public EReference getAnnotation_Expression() {
		return (EReference) annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	public EReference getAssignment_Value() {
		return (EReference) assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getVariable <em>Variable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getVariable()
	 * @see #getAssignment()
	 * @generated
	 */
	public EReference getAssignment_Variable() {
		return (EReference) assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	public EReference getVariableDeclaration_Type() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getInitialValue()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	public EReference getVariableDeclaration_InitialValue() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	public EAttribute getVariableDeclaration_Name() {
		return (EAttribute) variableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assumption</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption
	 * @generated
	 */
	public EClass getAssumption() {
		return assumptionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom <em>Axiom</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axiom</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom
	 * @generated
	 */
	public EClass getAxiom() {
		return axiomEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Block <em>Block</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Block
	 * @generated
	 */
	public EClass getBlock() {
		return blockEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Block#getStatements <em>Statements</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Block#getStatements()
	 * @see #getBlock()
	 * @generated
	 */
	public EReference getBlock_Statements() {
		return (EReference) blockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral
	 * @generated
	 */
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral#isValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral#isValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	public EAttribute getBooleanLiteral_Value() {
		return (EAttribute) booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType
	 * @generated
	 */
	public EClass getBooleanType() {
		return booleanTypeEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional <em>Conditional</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional
	 * @generated
	 */
	public EClass getConditional() {
		return conditionalEClass;
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getCondition <em>Condition</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getCondition()
	 * @see #getConditional()
	 * @generated
	 */
	public EReference getConditional_Condition() {
		return (EReference) conditionalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getTrueBlock <em>True Block</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>True Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getTrueBlock()
	 * @see #getConditional()
	 * @generated
	 */
	public EReference getConditional_TrueBlock() {
		return (EReference) conditionalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getFalseBlock <em>False Block</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>False Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getFalseBlock()
	 * @see #getConditional()
	 * @generated
	 */
	public EReference getConditional_FalseBlock() {
		return (EReference) conditionalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction <em>Conjunction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conjunction</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction
	 * @generated
	 */
	public EClass getConjunction() {
		return conjunctionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction <em>Disjunction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disjunction</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction
	 * @generated
	 */
	public EClass getDisjunction() {
		return disjunctionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Division <em>Division</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Division</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Division
	 * @generated
	 */
	public EClass getDivision() {
		return divisionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equal
	 * @generated
	 */
	public EClass getEqual() {
		return equalEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence <em>Equivalence</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalence</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence
	 * @generated
	 */
	public EClass getEquivalence() {
		return equivalenceEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier <em>Exists Quantifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists Quantifier</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier
	 * @generated
	 */
	public EClass getExistsQuantifier() {
		return existsQuantifierEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression <em>Quantified Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantified Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression
	 * @generated
	 */
	public EClass getQuantifiedExpression() {
		return quantifiedExpressionEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getParameter()
	 * @see #getQuantifiedExpression()
	 * @generated
	 */
	public EReference getQuantifiedExpression_Parameter() {
		return (EReference) quantifiedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getExpression()
	 * @see #getQuantifiedExpression()
	 * @generated
	 */
	public EReference getQuantifiedExpression_Expression() {
		return (EReference) quantifiedExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getCondition()
	 * @see #getQuantifiedExpression()
	 * @generated
	 */
	public EReference getQuantifiedExpression_Condition() {
		return (EReference) quantifiedExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier <em>For All Quantifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>For All Quantifier</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier
	 * @generated
	 */
	public EClass getForAllQuantifier() {
		return forAllQuantifierEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall
	 * @generated
	 */
	public EClass getFunctionCall() {
		return functionCallEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getActuals <em>Actuals</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Actuals</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getActuals()
	 * @see #getFunctionCall()
	 * @generated
	 */
	public EReference getFunctionCall_Actuals() {
		return (EReference) functionCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getFunction <em>Function</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getFunction()
	 * @see #getFunctionCall()
	 * @generated
	 */
	public EReference getFunctionCall_Function() {
		return (EReference) functionCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration <em>Function Declaration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Declaration</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration
	 * @generated
	 */
	public EClass getFunctionDeclaration() {
		return functionDeclarationEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPreconditions()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	public EReference getFunctionDeclaration_Preconditions() {
		return (EReference) functionDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPostconditions <em>Postconditions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postconditions</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPostconditions()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	public EReference getFunctionDeclaration_Postconditions() {
		return (EReference) functionDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getParameters()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	public EReference getFunctionDeclaration_Parameters() {
		return (EReference) functionDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getBody <em>Body</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getBody()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	public EReference getFunctionDeclaration_Body() {
		return (EReference) functionDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getReturnType()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	public EReference getFunctionDeclaration_ReturnType() {
		return (EReference) functionDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getName()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	public EAttribute getFunctionDeclaration_Name() {
		return (EAttribute) functionDeclarationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precondition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition
	 * @generated
	 */
	public EClass getPrecondition() {
		return preconditionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postcondition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition
	 * @generated
	 */
	public EClass getPostcondition() {
		return postconditionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Greater <em>Greater</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Greater
	 * @generated
	 */
	public EClass getGreater() {
		return greaterEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual <em>Greater Or Equal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Or Equal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual
	 * @generated
	 */
	public EClass getGreaterOrEqual() {
		return greaterOrEqualEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Implication <em>Implication</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Implication
	 * @generated
	 */
	public EClass getImplication() {
		return implicationEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral
	 * @generated
	 */
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * Returns the meta object for the attribute '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute) integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType
	 * @generated
	 */
	public EClass getIntegerType() {
		return integerTypeEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant
	 * @generated
	 */
	public EClass getInvariant() {
		return invariantEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Less <em>Less</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Less
	 * @generated
	 */
	public EClass getLess() {
		return lessEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual <em>Less Or Equal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Or Equal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual
	 * @generated
	 */
	public EClass getLessOrEqual() {
		return lessOrEqualEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop
	 * @generated
	 */
	public EClass getLoop() {
		return loopEClass;
	}

	/**
	 * Returns the meta object for the containment reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getCondition <em>Condition</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getCondition()
	 * @see #getLoop()
	 * @generated
	 */
	public EReference getLoop_Condition() {
		return (EReference) loopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getBody()
	 * @see #getLoop()
	 * @generated
	 */
	public EReference getLoop_Body() {
		return (EReference) loopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getInvariants <em>Invariants</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getInvariants()
	 * @see #getLoop()
	 * @generated
	 */
	public EReference getLoop_Invariants() {
		return (EReference) loopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Minus <em>Minus</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minus</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Minus
	 * @generated
	 */
	public EClass getMinus() {
		return minusEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Sign <em>Sign</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sign</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Sign
	 * @generated
	 */
	public EClass getSign() {
		return signEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus <em>Modulus</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modulus</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus
	 * @generated
	 */
	public EClass getModulus() {
		return modulusEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication <em>Multiplication</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplication</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication
	 * @generated
	 */
	public EClass getMultiplication() {
		return multiplicationEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Negation <em>Negation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Negation</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Negation
	 * @generated
	 */
	public EClass getNegation() {
		return negationEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Plus
	 * @generated
	 */
	public EClass getPlus() {
		return plusEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Statement</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement
	 * @generated
	 */
	public EClass getReturnStatement() {
		return returnStatementEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement#getReturnValue <em>Return Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement#getReturnValue()
	 * @see #getReturnStatement()
	 * @generated
	 */
	public EReference getReturnStatement_ReturnValue() {
		return (EReference) returnStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement#getFunction()
	 * @see #getReturnStatement()
	 * @generated
	 */
	public EReference getReturnStatement_Function() {
		return (EReference) returnStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction <em>Subtraction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subtraction</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction
	 * @generated
	 */
	public EClass getSubtraction() {
		return subtractionEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal <em>Unequal</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unequal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal
	 * @generated
	 */
	public EClass getUnequal() {
		return unequalEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference
	 * @generated
	 */
	public EClass getVariableReference() {
		return variableReferenceEClass;
	}

	/**
	 * Returns the meta object for the reference '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getVariable <em>Variable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getVariable()
	 * @see #getVariableReference()
	 * @generated
	 */
	public EReference getVariableReference_Variable() {
		return (EReference) variableReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Statement
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference <em>Return Value Reference</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Value Reference</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference
	 * @generated
	 */
	public EClass getReturnValueReference() {
		return returnValueReferenceEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference#getFunction()
	 * @see #getReturnValueReference()
	 * @generated
	 */
	public EReference getReturnValueReference_Function() {
		return (EReference) returnValueReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference <em>Symbol Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbol Reference</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference
	 * @generated
	 */
	public EClass getSymbolReference() {
		return symbolReferenceEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference#getIndex()
	 * @see #getSymbolReference()
	 * @generated
	 */
	public EReference getSymbolReference_Index() {
		return (EReference) symbolReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation <em>Expression Evaluation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Evaluation</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation
	 * @generated
	 */
	public EClass getExpressionEvaluation() {
		return expressionEvaluationEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation#getExpression()
	 * @see #getExpressionEvaluation()
	 * @generated
	 */
	public EReference getExpressionEvaluation_Expression() {
		return (EReference) expressionEvaluationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction <em>Array Function</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Function</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction
	 * @generated
	 */
	public EClass getArrayFunction() {
		return arrayFunctionEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getChainedFunction <em>Chained Function</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Chained Function</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getChainedFunction()
	 * @see #getArrayFunction()
	 * @generated
	 */
	public EReference getArrayFunction_ChainedFunction() {
		return (EReference) arrayFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getIndex()
	 * @see #getArrayFunction()
	 * @generated
	 */
	public EReference getArrayFunction_Index() {
		return (EReference) arrayFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getValue()
	 * @see #getArrayFunction()
	 * @generated
	 */
	public EReference getArrayFunction_Value() {
		return (EReference) arrayFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess <em>Array Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Access</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess
	 * @generated
	 */
	public EClass getArrayAccess() {
		return arrayAccessEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess#getIndex()
	 * @see #getArrayAccess()
	 * @generated
	 */
	public EReference getArrayAccess_Index() {
		return (EReference) arrayAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess#getArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess#getArray()
	 * @see #getArrayAccess()
	 * @generated
	 */
	public EReference getArrayAccess_Array() {
		return (EReference) arrayAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Expression To Expression Map</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Expression To Expression Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="edu.kit.iti.formal.pse.worthwhile.model.ast.Expression"
	 *        valueType="edu.kit.iti.formal.pse.worthwhile.model.ast.Expression"
	 * @generated
	 */
	public EClass getExpressionToExpressionMap() {
		return expressionToExpressionMapEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getExpressionToExpressionMap()
	 * @generated
	 */
	public EReference getExpressionToExpressionMap_Key() {
		return (EReference) expressionToExpressionMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getExpressionToExpressionMap()
	 * @generated
	 */
	public EReference getExpressionToExpressionMap_Value() {
		return (EReference) expressionToExpressionMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation <em>Function Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Annotation</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation
	 * @generated
	 */
	public EClass getFunctionAnnotation() {
		return functionAnnotationEClass;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public AstFactory getAstFactory() {
		return (AstFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		programEClass = createEClass(PROGRAM);
		createEReference(programEClass, PROGRAM__FUNCTION_DECLARATIONS);
		createEReference(programEClass, PROGRAM__MAIN_BLOCK);
		createEReference(programEClass, PROGRAM__AXIOMS);

		astNodeEClass = createEClass(AST_NODE);

		additionEClass = createEClass(ADDITION);

		binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__LEFT);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__RIGHT);

		expressionEClass = createEClass(EXPRESSION);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OPERAND);

		arrayLiteralEClass = createEClass(ARRAY_LITERAL);
		createEReference(arrayLiteralEClass, ARRAY_LITERAL__VALUES);

		literalEClass = createEClass(LITERAL);

		arrayTypeEClass = createEClass(ARRAY_TYPE);
		createEReference(arrayTypeEClass, ARRAY_TYPE__BASE_TYPE);

		typeEClass = createEClass(TYPE);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		assertionEClass = createEClass(ASSERTION);

		guardAssertionEClass = createEClass(GUARD_ASSERTION);

		functionCallPreconditionAssertionEClass = createEClass(FUNCTION_CALL_PRECONDITION_ASSERTION);
		createEReference(functionCallPreconditionAssertionEClass,
		                FUNCTION_CALL_PRECONDITION_ASSERTION__GUARDED_NODE);

		divisorNotZeroAssertionEClass = createEClass(DIVISOR_NOT_ZERO_ASSERTION);
		createEReference(divisorNotZeroAssertionEClass, DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__EXPRESSION);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__VALUE);
		createEReference(assignmentEClass, ASSIGNMENT__VARIABLE);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__INITIAL_VALUE);
		createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__NAME);

		assumptionEClass = createEClass(ASSUMPTION);

		axiomEClass = createEClass(AXIOM);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__STATEMENTS);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

		booleanTypeEClass = createEClass(BOOLEAN_TYPE);

		conditionalEClass = createEClass(CONDITIONAL);
		createEReference(conditionalEClass, CONDITIONAL__CONDITION);
		createEReference(conditionalEClass, CONDITIONAL__TRUE_BLOCK);
		createEReference(conditionalEClass, CONDITIONAL__FALSE_BLOCK);

		conjunctionEClass = createEClass(CONJUNCTION);

		disjunctionEClass = createEClass(DISJUNCTION);

		divisionEClass = createEClass(DIVISION);

		equalEClass = createEClass(EQUAL);

		equivalenceEClass = createEClass(EQUIVALENCE);

		existsQuantifierEClass = createEClass(EXISTS_QUANTIFIER);

		quantifiedExpressionEClass = createEClass(QUANTIFIED_EXPRESSION);
		createEReference(quantifiedExpressionEClass, QUANTIFIED_EXPRESSION__PARAMETER);
		createEReference(quantifiedExpressionEClass, QUANTIFIED_EXPRESSION__EXPRESSION);
		createEReference(quantifiedExpressionEClass, QUANTIFIED_EXPRESSION__CONDITION);

		forAllQuantifierEClass = createEClass(FOR_ALL_QUANTIFIER);

		functionCallEClass = createEClass(FUNCTION_CALL);
		createEReference(functionCallEClass, FUNCTION_CALL__ACTUALS);
		createEReference(functionCallEClass, FUNCTION_CALL__FUNCTION);

		functionDeclarationEClass = createEClass(FUNCTION_DECLARATION);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__PRECONDITIONS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__POSTCONDITIONS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__PARAMETERS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__BODY);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__RETURN_TYPE);
		createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__NAME);

		preconditionEClass = createEClass(PRECONDITION);

		postconditionEClass = createEClass(POSTCONDITION);

		greaterEClass = createEClass(GREATER);

		greaterOrEqualEClass = createEClass(GREATER_OR_EQUAL);

		implicationEClass = createEClass(IMPLICATION);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

		integerTypeEClass = createEClass(INTEGER_TYPE);

		invariantEClass = createEClass(INVARIANT);

		lessEClass = createEClass(LESS);

		lessOrEqualEClass = createEClass(LESS_OR_EQUAL);

		loopEClass = createEClass(LOOP);
		createEReference(loopEClass, LOOP__CONDITION);
		createEReference(loopEClass, LOOP__BODY);
		createEReference(loopEClass, LOOP__INVARIANTS);

		minusEClass = createEClass(MINUS);

		signEClass = createEClass(SIGN);

		modulusEClass = createEClass(MODULUS);

		multiplicationEClass = createEClass(MULTIPLICATION);

		negationEClass = createEClass(NEGATION);

		plusEClass = createEClass(PLUS);

		returnStatementEClass = createEClass(RETURN_STATEMENT);
		createEReference(returnStatementEClass, RETURN_STATEMENT__RETURN_VALUE);
		createEReference(returnStatementEClass, RETURN_STATEMENT__FUNCTION);

		subtractionEClass = createEClass(SUBTRACTION);

		unequalEClass = createEClass(UNEQUAL);

		variableReferenceEClass = createEClass(VARIABLE_REFERENCE);
		createEReference(variableReferenceEClass, VARIABLE_REFERENCE__VARIABLE);

		statementEClass = createEClass(STATEMENT);

		returnValueReferenceEClass = createEClass(RETURN_VALUE_REFERENCE);
		createEReference(returnValueReferenceEClass, RETURN_VALUE_REFERENCE__FUNCTION);

		symbolReferenceEClass = createEClass(SYMBOL_REFERENCE);
		createEReference(symbolReferenceEClass, SYMBOL_REFERENCE__INDEX);

		expressionEvaluationEClass = createEClass(EXPRESSION_EVALUATION);
		createEReference(expressionEvaluationEClass, EXPRESSION_EVALUATION__EXPRESSION);

		arrayFunctionEClass = createEClass(ARRAY_FUNCTION);
		createEReference(arrayFunctionEClass, ARRAY_FUNCTION__CHAINED_FUNCTION);
		createEReference(arrayFunctionEClass, ARRAY_FUNCTION__INDEX);
		createEReference(arrayFunctionEClass, ARRAY_FUNCTION__VALUE);

		arrayAccessEClass = createEClass(ARRAY_ACCESS);
		createEReference(arrayAccessEClass, ARRAY_ACCESS__INDEX);
		createEReference(arrayAccessEClass, ARRAY_ACCESS__ARRAY);

		expressionToExpressionMapEClass = createEClass(EXPRESSION_TO_EXPRESSION_MAP);
		createEReference(expressionToExpressionMapEClass, EXPRESSION_TO_EXPRESSION_MAP__KEY);
		createEReference(expressionToExpressionMapEClass, EXPRESSION_TO_EXPRESSION_MAP__VALUE);

		functionAnnotationEClass = createEClass(FUNCTION_ANNOTATION);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		VisitorPackage theVisitorPackage = (VisitorPackage) EPackage.Registry.INSTANCE
		                .getEPackage(VisitorPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theVisitorPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		programEClass.getESuperTypes().add(this.getASTNode());
		additionEClass.getESuperTypes().add(this.getBinaryExpression());
		binaryExpressionEClass.getESuperTypes().add(this.getExpression());
		expressionEClass.getESuperTypes().add(this.getASTNode());
		unaryExpressionEClass.getESuperTypes().add(this.getExpression());
		arrayLiteralEClass.getESuperTypes().add(this.getLiteral());
		literalEClass.getESuperTypes().add(this.getExpression());
		arrayTypeEClass.getESuperTypes().add(this.getType());
		typeEClass.getESuperTypes().add(this.getASTNode());
		primitiveTypeEClass.getESuperTypes().add(this.getType());
		assertionEClass.getESuperTypes().add(this.getAnnotation());
		guardAssertionEClass.getESuperTypes().add(this.getAssertion());
		functionCallPreconditionAssertionEClass.getESuperTypes().add(this.getGuardAssertion());
		divisorNotZeroAssertionEClass.getESuperTypes().add(this.getGuardAssertion());
		annotationEClass.getESuperTypes().add(this.getStatement());
		assignmentEClass.getESuperTypes().add(this.getStatement());
		variableDeclarationEClass.getESuperTypes().add(this.getStatement());
		assumptionEClass.getESuperTypes().add(this.getAnnotation());
		axiomEClass.getESuperTypes().add(this.getAnnotation());
		blockEClass.getESuperTypes().add(this.getStatement());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
		booleanTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		conditionalEClass.getESuperTypes().add(this.getStatement());
		conjunctionEClass.getESuperTypes().add(this.getBinaryExpression());
		disjunctionEClass.getESuperTypes().add(this.getBinaryExpression());
		divisionEClass.getESuperTypes().add(this.getBinaryExpression());
		equalEClass.getESuperTypes().add(this.getBinaryExpression());
		equivalenceEClass.getESuperTypes().add(this.getBinaryExpression());
		existsQuantifierEClass.getESuperTypes().add(this.getQuantifiedExpression());
		quantifiedExpressionEClass.getESuperTypes().add(this.getExpression());
		forAllQuantifierEClass.getESuperTypes().add(this.getQuantifiedExpression());
		functionCallEClass.getESuperTypes().add(this.getExpression());
		functionDeclarationEClass.getESuperTypes().add(this.getASTNode());
		preconditionEClass.getESuperTypes().add(this.getFunctionAnnotation());
		postconditionEClass.getESuperTypes().add(this.getFunctionAnnotation());
		greaterEClass.getESuperTypes().add(this.getBinaryExpression());
		greaterOrEqualEClass.getESuperTypes().add(this.getBinaryExpression());
		implicationEClass.getESuperTypes().add(this.getBinaryExpression());
		integerLiteralEClass.getESuperTypes().add(this.getLiteral());
		integerTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		invariantEClass.getESuperTypes().add(this.getAnnotation());
		lessEClass.getESuperTypes().add(this.getBinaryExpression());
		lessOrEqualEClass.getESuperTypes().add(this.getBinaryExpression());
		loopEClass.getESuperTypes().add(this.getStatement());
		minusEClass.getESuperTypes().add(this.getSign());
		signEClass.getESuperTypes().add(this.getUnaryExpression());
		modulusEClass.getESuperTypes().add(this.getBinaryExpression());
		multiplicationEClass.getESuperTypes().add(this.getBinaryExpression());
		negationEClass.getESuperTypes().add(this.getUnaryExpression());
		plusEClass.getESuperTypes().add(this.getSign());
		returnStatementEClass.getESuperTypes().add(this.getStatement());
		subtractionEClass.getESuperTypes().add(this.getBinaryExpression());
		unequalEClass.getESuperTypes().add(this.getBinaryExpression());
		variableReferenceEClass.getESuperTypes().add(this.getSymbolReference());
		statementEClass.getESuperTypes().add(this.getASTNode());
		returnValueReferenceEClass.getESuperTypes().add(this.getSymbolReference());
		symbolReferenceEClass.getESuperTypes().add(this.getExpression());
		expressionEvaluationEClass.getESuperTypes().add(this.getASTNode());
		arrayFunctionEClass.getESuperTypes().add(this.getLiteral());
		arrayAccessEClass.getESuperTypes().add(this.getExpression());
		functionAnnotationEClass.getESuperTypes().add(this.getAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProgram_FunctionDeclarations(), this.getFunctionDeclaration(), null,
		                "functionDeclarations", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE,
		                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		                !IS_DERIVED, !IS_ORDERED);
		initEReference(getProgram_MainBlock(), this.getBlock(), null, "mainBlock", null, 0, 1, Program.class,
		                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProgram_Axioms(), this.getAxiom(), null, "axioms", null, 0, -1, Program.class,
		                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(programEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(astNodeEClass, ASTNode.class, "ASTNode", IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(astNodeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(additionEClass, Addition.class, "Addition", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(additionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExpression_Left(), this.getExpression(), null, "left", null, 1, 1,
		                BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBinaryExpression_Right(), this.getExpression(), null, "right", null, 1, 1,
		                BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(binaryExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(expressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 1, 1,
		                UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(unaryExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(arrayLiteralEClass, ArrayLiteral.class, "ArrayLiteral", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayLiteral_Values(), this.getExpression(), null, "values", null, 0, -1,
		                ArrayLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(arrayLiteralEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(literalEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(arrayTypeEClass, ArrayType.class, "ArrayType", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayType_BaseType(), this.getPrimitiveType(), null, "baseType", null, 1, 1,
		                ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(arrayTypeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(typeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(primitiveTypeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(assertionEClass, Assertion.class, "Assertion", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(assertionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(guardAssertionEClass, GuardAssertion.class, "GuardAssertion", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(guardAssertionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionCallPreconditionAssertionEClass, FunctionCallPreconditionAssertion.class,
		                "FunctionCallPreconditionAssertion", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionCallPreconditionAssertion_GuardedNode(), this.getFunctionCall(), null,
		                "guardedNode", null, 1, 1, FunctionCallPreconditionAssertion.class, !IS_TRANSIENT,
		                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
		                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(functionCallPreconditionAssertionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(divisorNotZeroAssertionEClass, DivisorNotZeroAssertion.class, "DivisorNotZeroAssertion",
		                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDivisorNotZeroAssertion_GuardedNode(), this.getExpression(), null, "guardedNode",
		                null, 1, 1, DivisorNotZeroAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(divisorNotZeroAssertionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_Expression(), this.getExpression(), null, "expression", null, 1, 1,
		                Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(annotationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Value(), this.getExpression(), null, "value", null, 1, 1,
		                Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssignment_Variable(), this.getVariableReference(), null, "variable", null, 1, 1,
		                Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(assignmentEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDeclaration_Type(), this.getType(), null, "type", null, 1, 1,
		                VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableDeclaration_InitialValue(), this.getExpression(), null, "initialValue", null,
		                0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1,
		                VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
		                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(assumptionEClass, Assumption.class, "Assumption", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(assumptionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(axiomEClass, Axiom.class, "Axiom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(axiomEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_Statements(), this.getStatement(), null, "statements", null, 0, -1,
		                Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(blockEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1,
		                BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
		                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(booleanLiteralEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(booleanLiteralEClass, ecorePackage.getEBoolean(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(booleanTypeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(conditionalEClass, Conditional.class, "Conditional", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditional_Condition(), this.getExpression(), null, "condition", null, 1, 1,
		                Conditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConditional_TrueBlock(), this.getBlock(), null, "trueBlock", null, 1, 1,
		                Conditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConditional_FalseBlock(), this.getBlock(), null, "falseBlock", null, 0, 1,
		                Conditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(conditionalEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(conjunctionEClass, Conjunction.class, "Conjunction", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(conjunctionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(disjunctionEClass, Disjunction.class, "Disjunction", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(disjunctionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(divisionEClass, Division.class, "Division", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(divisionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equalEClass, Equal.class, "Equal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(equalEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equivalenceEClass, Equivalence.class, "Equivalence", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(equivalenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(existsQuantifierEClass, ExistsQuantifier.class, "ExistsQuantifier", !IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(existsQuantifierEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(quantifiedExpressionEClass, QuantifiedExpression.class, "QuantifiedExpression", IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQuantifiedExpression_Parameter(), this.getVariableDeclaration(), null, "parameter",
		                null, 1, 1, QuantifiedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQuantifiedExpression_Expression(), this.getExpression(), null, "expression", null, 1,
		                1, QuantifiedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getQuantifiedExpression_Condition(), this.getExpression(), null, "condition", null, 0,
		                1, QuantifiedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(quantifiedExpressionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(forAllQuantifierEClass, ForAllQuantifier.class, "ForAllQuantifier", !IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(forAllQuantifierEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionCall_Actuals(), this.getExpression(), null, "actuals", null, 0, -1,
		                FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFunctionCall_Function(), this.getFunctionDeclaration(), null, "function", null, 1, 1,
		                FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(functionCallEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionDeclarationEClass, FunctionDeclaration.class, "FunctionDeclaration", !IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionDeclaration_Preconditions(), this.getPrecondition(), null, "preconditions",
		                null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFunctionDeclaration_Postconditions(), this.getPostcondition(), null,
		                "postconditions", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE,
		                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		                !IS_DERIVED, !IS_ORDERED);
		initEReference(getFunctionDeclaration_Parameters(), this.getVariableDeclaration(), null, "parameters",
		                null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFunctionDeclaration_Body(), this.getBlock(), null, "body", null, 1, 1,
		                FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFunctionDeclaration_ReturnType(), this.getType(), null, "returnType", null, 1, 1,
		                FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFunctionDeclaration_Name(), ecorePackage.getEString(), "name", null, 1, 1,
		                FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
		                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(functionDeclarationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(preconditionEClass, Precondition.class, "Precondition", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(preconditionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(postconditionEClass, Postcondition.class, "Postcondition", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(postconditionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(greaterEClass, Greater.class, "Greater", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(greaterEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(greaterOrEqualEClass, GreaterOrEqual.class, "GreaterOrEqual", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(greaterOrEqualEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(implicationEClass, Implication.class, "Implication", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(implicationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Value(), ecorePackage.getEBigInteger(), "value", null, 1, 1,
		                IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
		                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(integerLiteralEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(integerTypeEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(invariantEClass, Invariant.class, "Invariant", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(invariantEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(lessEClass, Less.class, "Less", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(lessEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(lessOrEqualEClass, LessOrEqual.class, "LessOrEqual", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(lessOrEqualEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(loopEClass, Loop.class, "Loop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoop_Condition(), this.getExpression(), null, "condition", null, 1, 1, Loop.class,
		                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLoop_Body(), this.getBlock(), null, "body", null, 1, 1, Loop.class, !IS_TRANSIENT,
		                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
		                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLoop_Invariants(), this.getInvariant(), null, "invariants", null, 0, -1, Loop.class,
		                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(loopEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(minusEClass, Minus.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(minusEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(signEClass, Sign.class, "Sign", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(signEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modulusEClass, Modulus.class, "Modulus", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(modulusEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(multiplicationEClass, Multiplication.class, "Multiplication", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(multiplicationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(negationEClass, Negation.class, "Negation", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(negationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(plusEClass, Plus.class, "Plus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(plusEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnStatement_ReturnValue(), this.getExpression(), null, "returnValue", null, 1, 1,
		                ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReturnStatement_Function(), this.getFunctionDeclaration(), null, "function", null, 0,
		                1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(returnStatementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(subtractionEClass, Subtraction.class, "Subtraction", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(subtractionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unequalEClass, Unequal.class, "Unequal", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(unequalEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableReferenceEClass, VariableReference.class, "VariableReference", !IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableReference_Variable(), this.getVariableDeclaration(), null, "variable", null,
		                1, 1, VariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(variableReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(statementEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(returnValueReferenceEClass, ReturnValueReference.class, "ReturnValueReference",
		                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnValueReference_Function(), this.getFunctionDeclaration(), null, "function",
		                null, 1, 1, ReturnValueReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(returnValueReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(symbolReferenceEClass, SymbolReference.class, "SymbolReference", !IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymbolReference_Index(), this.getExpression(), null, "index", null, 0, 1,
		                SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(symbolReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expressionEvaluationEClass, ExpressionEvaluation.class, "ExpressionEvaluation",
		                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionEvaluation_Expression(), this.getExpression(), null, "expression", null, 1,
		                1, ExpressionEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayFunctionEClass, ArrayFunction.class, "ArrayFunction", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayFunction_ChainedFunction(), this.getExpression(), null, "chainedFunction", null,
		                0, 1, ArrayFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayFunction_Index(), this.getExpression(), null, "index", null, 0, 1,
		                ArrayFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayFunction_Value(), this.getExpression(), null, "value", null, 0, 1,
		                ArrayFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(arrayFunctionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(arrayAccessEClass, ArrayAccess.class, "ArrayAccess", !IS_ABSTRACT, !IS_INTERFACE,
		                IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayAccess_Index(), this.getExpression(), null, "index", null, 1, 1,
		                ArrayAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayAccess_Array(), this.getExpression(), null, "array", null, 1, 1,
		                ArrayAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(arrayAccessEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expressionToExpressionMapEClass, Map.Entry.class, "ExpressionToExpressionMap", !IS_ABSTRACT,
		                !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionToExpressionMap_Key(), this.getExpression(), null, "key", null, 0, 1,
		                Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpressionToExpressionMap_Value(), this.getExpression(), null, "value", null, 0, 1,
		                Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionAnnotationEClass, FunctionAnnotation.class, "FunctionAnnotation", IS_ABSTRACT,
		                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(functionAnnotationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theVisitorPackage.getIASTNodeVisitor(), "visitor", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program <em>Program</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram()
		 * @generated
		 */
		public static final EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Function Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference PROGRAM__FUNCTION_DECLARATIONS = eINSTANCE
		                .getProgram_FunctionDeclarations();

		/**
		 * The meta object literal for the '<em><b>Main Block</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference PROGRAM__MAIN_BLOCK = eINSTANCE.getProgram_MainBlock();

		/**
		 * The meta object literal for the '<em><b>Axioms</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference PROGRAM__AXIOMS = eINSTANCE.getProgram_Axioms();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode <em>AST Node</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNode()
		 * @generated
		 */
		public static final EClass AST_NODE = eINSTANCE.getASTNode();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Addition <em>Addition</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Addition
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAddition()
		 * @generated
		 */
		public static final EClass ADDITION = eINSTANCE.getAddition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBinaryExpression()
		 * @generated
		 */
		public static final EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference BINARY_EXPRESSION__LEFT = eINSTANCE.getBinaryExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference BINARY_EXPRESSION__RIGHT = eINSTANCE.getBinaryExpression_Right();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Expression <em>Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Expression
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExpression()
		 * @generated
		 */
		public static final EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getUnaryExpression()
		 * @generated
		 */
		public static final EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference UNARY_EXPRESSION__OPERAND = eINSTANCE.getUnaryExpression_Operand();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral <em>Array Literal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayLiteral()
		 * @generated
		 */
		public static final EClass ARRAY_LITERAL = eINSTANCE.getArrayLiteral();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference ARRAY_LITERAL__VALUES = eINSTANCE.getArrayLiteral_Values();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Literal <em>Literal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Literal
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLiteral()
		 * @generated
		 */
		public static final EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType <em>Array Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayType()
		 * @generated
		 */
		public static final EClass ARRAY_TYPE = eINSTANCE.getArrayType();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference ARRAY_TYPE__BASE_TYPE = eINSTANCE.getArrayType_BaseType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Type <em>Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Type
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getType()
		 * @generated
		 */
		public static final EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPrimitiveType()
		 * @generated
		 */
		public static final EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion <em>Assertion</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAssertion()
		 * @generated
		 */
		public static final EClass ASSERTION = eINSTANCE.getAssertion();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion <em>Guard Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GuardAssertion
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getGuardAssertion()
		 * @generated
		 */
		public static final EClass GUARD_ASSERTION = eINSTANCE.getGuardAssertion();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion <em>Function Call Precondition Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCallPreconditionAssertion
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionCallPreconditionAssertion()
		 * @generated
		 */
		public static final EClass FUNCTION_CALL_PRECONDITION_ASSERTION = eINSTANCE
		                .getFunctionCallPreconditionAssertion();

		/**
		 * The meta object literal for the '<em><b>Guarded Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FUNCTION_CALL_PRECONDITION_ASSERTION__GUARDED_NODE = eINSTANCE
		                .getFunctionCallPreconditionAssertion_GuardedNode();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion <em>Divisor Not Zero Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDivisorNotZeroAssertion()
		 * @generated
		 */
		public static final EClass DIVISOR_NOT_ZERO_ASSERTION = eINSTANCE.getDivisorNotZeroAssertion();

		/**
		 * The meta object literal for the '<em><b>Guarded Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE = eINSTANCE
		                .getDivisorNotZeroAssertion_GuardedNode();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation <em>Annotation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAnnotation()
		 * @generated
		 */
		public static final EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference ANNOTATION__EXPRESSION = eINSTANCE.getAnnotation_Expression();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment <em>Assignment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAssignment()
		 * @generated
		 */
		public static final EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference ASSIGNMENT__VARIABLE = eINSTANCE.getAssignment_Variable();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getVariableDeclaration()
		 * @generated
		 */
		public static final EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference VARIABLE_DECLARATION__INITIAL_VALUE = eINSTANCE
		                .getVariableDeclaration_InitialValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption <em>Assumption</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAssumption()
		 * @generated
		 */
		public static final EClass ASSUMPTION = eINSTANCE.getAssumption();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom <em>Axiom</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getAxiom()
		 * @generated
		 */
		public static final EClass AXIOM = eINSTANCE.getAxiom();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Block <em>Block</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Block
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBlock()
		 * @generated
		 */
		public static final EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBooleanLiteral()
		 * @generated
		 */
		public static final EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getBooleanType()
		 * @generated
		 */
		public static final EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional <em>Conditional</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional()
		 * @generated
		 */
		public static final EClass CONDITIONAL = eINSTANCE.getConditional();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference CONDITIONAL__CONDITION = eINSTANCE.getConditional_Condition();

		/**
		 * The meta object literal for the '<em><b>True Block</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference CONDITIONAL__TRUE_BLOCK = eINSTANCE.getConditional_TrueBlock();

		/**
		 * The meta object literal for the '<em><b>False Block</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference CONDITIONAL__FALSE_BLOCK = eINSTANCE.getConditional_FalseBlock();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction <em>Conjunction</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConjunction()
		 * @generated
		 */
		public static final EClass CONJUNCTION = eINSTANCE.getConjunction();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction <em>Disjunction</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDisjunction()
		 * @generated
		 */
		public static final EClass DISJUNCTION = eINSTANCE.getDisjunction();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Division <em>Division</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Division
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDivision()
		 * @generated
		 */
		public static final EClass DIVISION = eINSTANCE.getDivision();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equal <em>Equal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equal
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getEqual()
		 * @generated
		 */
		public static final EClass EQUAL = eINSTANCE.getEqual();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence <em>Equivalence</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getEquivalence()
		 * @generated
		 */
		public static final EClass EQUIVALENCE = eINSTANCE.getEquivalence();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier <em>Exists Quantifier</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExistsQuantifier()
		 * @generated
		 */
		public static final EClass EXISTS_QUANTIFIER = eINSTANCE.getExistsQuantifier();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression <em>Quantified Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getQuantifiedExpression()
		 * @generated
		 */
		public static final EClass QUANTIFIED_EXPRESSION = eINSTANCE.getQuantifiedExpression();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference QUANTIFIED_EXPRESSION__PARAMETER = eINSTANCE
		                .getQuantifiedExpression_Parameter();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference QUANTIFIED_EXPRESSION__EXPRESSION = eINSTANCE
		                .getQuantifiedExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference QUANTIFIED_EXPRESSION__CONDITION = eINSTANCE
		                .getQuantifiedExpression_Condition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier <em>For All Quantifier</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getForAllQuantifier()
		 * @generated
		 */
		public static final EClass FOR_ALL_QUANTIFIER = eINSTANCE.getForAllQuantifier();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall <em>Function Call</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionCall()
		 * @generated
		 */
		public static final EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

		/**
		 * The meta object literal for the '<em><b>Actuals</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference FUNCTION_CALL__ACTUALS = eINSTANCE.getFunctionCall_Actuals();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FUNCTION_CALL__FUNCTION = eINSTANCE.getFunctionCall_Function();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration <em>Function Declaration</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration()
		 * @generated
		 */
		public static final EClass FUNCTION_DECLARATION = eINSTANCE.getFunctionDeclaration();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FUNCTION_DECLARATION__PRECONDITIONS = eINSTANCE
		                .getFunctionDeclaration_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FUNCTION_DECLARATION__POSTCONDITIONS = eINSTANCE
		                .getFunctionDeclaration_Postconditions();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference FUNCTION_DECLARATION__PARAMETERS = eINSTANCE
		                .getFunctionDeclaration_Parameters();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference FUNCTION_DECLARATION__BODY = eINSTANCE.getFunctionDeclaration_Body();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference FUNCTION_DECLARATION__RETURN_TYPE = eINSTANCE
		                .getFunctionDeclaration_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute FUNCTION_DECLARATION__NAME = eINSTANCE.getFunctionDeclaration_Name();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition <em>Precondition</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPrecondition()
		 * @generated
		 */
		public static final EClass PRECONDITION = eINSTANCE.getPrecondition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition <em>Postcondition</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPostcondition()
		 * @generated
		 */
		public static final EClass POSTCONDITION = eINSTANCE.getPostcondition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Greater <em>Greater</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Greater
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getGreater()
		 * @generated
		 */
		public static final EClass GREATER = eINSTANCE.getGreater();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual <em>Greater Or Equal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getGreaterOrEqual()
		 * @generated
		 */
		public static final EClass GREATER_OR_EQUAL = eINSTANCE.getGreaterOrEqual();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Implication <em>Implication</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Implication
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getImplication()
		 * @generated
		 */
		public static final EClass IMPLICATION = eINSTANCE.getImplication();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getIntegerLiteral()
		 * @generated
		 */
		public static final EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getIntegerType()
		 * @generated
		 */
		public static final EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant <em>Invariant</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getInvariant()
		 * @generated
		 */
		public static final EClass INVARIANT = eINSTANCE.getInvariant();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Less <em>Less</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Less
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLess()
		 * @generated
		 */
		public static final EClass LESS = eINSTANCE.getLess();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual <em>Less Or Equal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLessOrEqual()
		 * @generated
		 */
		public static final EClass LESS_OR_EQUAL = eINSTANCE.getLessOrEqual();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop <em>Loop</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getLoop()
		 * @generated
		 */
		public static final EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference LOOP__CONDITION = eINSTANCE.getLoop_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference LOOP__BODY = eINSTANCE.getLoop_Body();

		/**
		 * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference LOOP__INVARIANTS = eINSTANCE.getLoop_Invariants();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Minus <em>Minus</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Minus
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getMinus()
		 * @generated
		 */
		public static final EClass MINUS = eINSTANCE.getMinus();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Sign <em>Sign</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Sign
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getSign()
		 * @generated
		 */
		public static final EClass SIGN = eINSTANCE.getSign();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus <em>Modulus</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getModulus()
		 * @generated
		 */
		public static final EClass MODULUS = eINSTANCE.getModulus();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication <em>Multiplication</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getMultiplication()
		 * @generated
		 */
		public static final EClass MULTIPLICATION = eINSTANCE.getMultiplication();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Negation <em>Negation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Negation
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getNegation()
		 * @generated
		 */
		public static final EClass NEGATION = eINSTANCE.getNegation();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Plus <em>Plus</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Plus
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getPlus()
		 * @generated
		 */
		public static final EClass PLUS = eINSTANCE.getPlus();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement <em>Return Statement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getReturnStatement()
		 * @generated
		 */
		public static final EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

		/**
		 * The meta object literal for the '<em><b>Return Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference RETURN_STATEMENT__RETURN_VALUE = eINSTANCE
		                .getReturnStatement_ReturnValue();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RETURN_STATEMENT__FUNCTION = eINSTANCE.getReturnStatement_Function();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction <em>Subtraction</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getSubtraction()
		 * @generated
		 */
		public static final EClass SUBTRACTION = eINSTANCE.getSubtraction();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal <em>Unequal</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getUnequal()
		 * @generated
		 */
		public static final EClass UNEQUAL = eINSTANCE.getUnequal();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getVariableReference()
		 * @generated
		 */
		public static final EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Statement <em>Statement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Statement
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getStatement()
		 * @generated
		 */
		public static final EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference <em>Return Value Reference</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getReturnValueReference()
		 * @generated
		 */
		public static final EClass RETURN_VALUE_REFERENCE = eINSTANCE.getReturnValueReference();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RETURN_VALUE_REFERENCE__FUNCTION = eINSTANCE
		                .getReturnValueReference_Function();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference <em>Symbol Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getSymbolReference()
		 * @generated
		 */
		public static final EClass SYMBOL_REFERENCE = eINSTANCE.getSymbolReference();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SYMBOL_REFERENCE__INDEX = eINSTANCE.getSymbolReference_Index();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation <em>Expression Evaluation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExpressionEvaluation()
		 * @generated
		 */
		public static final EClass EXPRESSION_EVALUATION = eINSTANCE.getExpressionEvaluation();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference EXPRESSION_EVALUATION__EXPRESSION = eINSTANCE
		                .getExpressionEvaluation_Expression();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction <em>Array Function</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction()
		 * @generated
		 */
		public static final EClass ARRAY_FUNCTION = eINSTANCE.getArrayFunction();

		/**
		 * The meta object literal for the '<em><b>Chained Function</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public static final EReference ARRAY_FUNCTION__CHAINED_FUNCTION = eINSTANCE
		                .getArrayFunction_ChainedFunction();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference ARRAY_FUNCTION__INDEX = eINSTANCE.getArrayFunction_Index();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference ARRAY_FUNCTION__VALUE = eINSTANCE.getArrayFunction_Value();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess <em>Array Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayAccess()
		 * @generated
		 */
		public static final EClass ARRAY_ACCESS = eINSTANCE.getArrayAccess();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference ARRAY_ACCESS__INDEX = eINSTANCE.getArrayAccess_Index();

		/**
		 * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference ARRAY_ACCESS__ARRAY = eINSTANCE.getArrayAccess_Array();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionToExpressionMap <em>Expression To Expression Map</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionToExpressionMap
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getExpressionToExpressionMap()
		 * @generated
		 */
		public static final EClass EXPRESSION_TO_EXPRESSION_MAP = eINSTANCE.getExpressionToExpressionMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		public static final EReference EXPRESSION_TO_EXPRESSION_MAP__KEY = eINSTANCE
		                .getExpressionToExpressionMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference EXPRESSION_TO_EXPRESSION_MAP__VALUE = eINSTANCE
		                .getExpressionToExpressionMap_Value();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation <em>Function Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionAnnotation()
		 * @generated
		 */
		public static final EClass FUNCTION_ANNOTATION = eINSTANCE.getFunctionAnnotation();

	}

} // AstPackage
