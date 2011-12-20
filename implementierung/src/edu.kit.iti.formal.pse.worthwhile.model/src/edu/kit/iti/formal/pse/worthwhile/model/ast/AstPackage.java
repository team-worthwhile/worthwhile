/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

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
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory
 * @model kind="package"
 * @generated
 */
public interface AstPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ast";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///ast.model.worthwhile.pse.formal.iti.kit.edu";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.kit.iti.formal.pse.worthwhile.model.ast";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstPackage eINSTANCE = edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ASTNodeImpl <em>AST Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ASTNodeImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getASTNode()
	 * @generated
	 */
	int AST_NODE = 1;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE__LINE_NUMBER = 0;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE__POSITION_IN_LINE = 1;

	/**
	 * The number of structural features of the '<em>AST Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ProgramImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__LINE_NUMBER = AST_NODE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__POSITION_IN_LINE = AST_NODE__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Function Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__FUNCTION_DECLARATIONS = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__MAIN_BLOCK = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Axioms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__AXIOMS = AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor <em>AST Node Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getASTNodeVisitor()
	 * @generated
	 */
	int AST_NODE_VISITOR = 2;

	/**
	 * The number of structural features of the '<em>AST Node Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AST_NODE_VISITOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExpressionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__LINE_NUMBER = AST_NODE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__POSITION_IN_LINE = AST_NODE__POSITION_IN_LINE;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BinaryExpressionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LINE_NUMBER = EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__POSITION_IN_LINE = EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AdditionImpl <em>Addition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AdditionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAddition()
	 * @generated
	 */
	int ADDITION = 3;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Addition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnaryExpressionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__LINE_NUMBER = EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__POSITION_IN_LINE = EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayAccessImpl <em>Array Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayAccessImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayAccess()
	 * @generated
	 */
	int ARRAY_ACCESS = 6;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS__LINE_NUMBER = UNARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS__POSITION_IN_LINE = UNARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS__INDEX = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ACCESS_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLengthImpl <em>Array Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLengthImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayLength()
	 * @generated
	 */
	int ARRAY_LENGTH = 8;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LENGTH__LINE_NUMBER = UNARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LENGTH__POSITION_IN_LINE = UNARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LENGTH__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Array Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LENGTH_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LiteralImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 10;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__LINE_NUMBER = EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__POSITION_IN_LINE = EXPRESSION__POSITION_IN_LINE;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLiteralImpl <em>Array Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLiteralImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayLiteral()
	 * @generated
	 */
	int ARRAY_LITERAL = 9;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__LINE_NUMBER = LITERAL__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__POSITION_IN_LINE = LITERAL__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__VALUES = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.TypeImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 12;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__LINE_NUMBER = AST_NODE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__POSITION_IN_LINE = AST_NODE__POSITION_IN_LINE;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayTypeImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__LINE_NUMBER = TYPE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__POSITION_IN_LINE = TYPE__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__BASE_TYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__SIZE = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PrimitiveTypeImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__LINE_NUMBER = TYPE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__POSITION_IN_LINE = TYPE__POSITION_IN_LINE;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.StatementImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 56;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__LINE_NUMBER = AST_NODE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__POSITION_IN_LINE = AST_NODE__POSITION_IN_LINE;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AnnotationImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 15;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__LINE_NUMBER = STATEMENT__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__POSITION_IN_LINE = STATEMENT__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssertionImpl <em>Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssertionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAssertion()
	 * @generated
	 */
	int ASSERTION = 14;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION__LINE_NUMBER = ANNOTATION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION__POSITION_IN_LINE = ANNOTATION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssignmentImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 16;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__LINE_NUMBER = STATEMENT__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__POSITION_IN_LINE = STATEMENT__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VARIABLE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableDeclarationImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 17;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__LINE_NUMBER = STATEMENT__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__POSITION_IN_LINE = STATEMENT__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INITIAL_VALUE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssumptionImpl <em>Assumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssumptionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAssumption()
	 * @generated
	 */
	int ASSUMPTION = 18;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__LINE_NUMBER = ANNOTATION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__POSITION_IN_LINE = ANNOTATION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AxiomImpl <em>Axiom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AxiomImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAxiom()
	 * @generated
	 */
	int AXIOM = 19;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM__LINE_NUMBER = ANNOTATION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM__POSITION_IN_LINE = ANNOTATION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Axiom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIOM_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BlockImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 20;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__LINE_NUMBER = STATEMENT__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__POSITION_IN_LINE = STATEMENT__POSITION_IN_LINE;

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
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanLiteralImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 21;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__LINE_NUMBER = LITERAL__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__POSITION_IN_LINE = LITERAL__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanTypeImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 22;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__LINE_NUMBER = PRIMITIVE_TYPE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__POSITION_IN_LINE = PRIMITIVE_TYPE__POSITION_IN_LINE;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConditionalImpl <em>Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConditionalImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getConditional()
	 * @generated
	 */
	int CONDITIONAL = 23;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__LINE_NUMBER = STATEMENT__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__POSITION_IN_LINE = STATEMENT__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>True Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__TRUE_BLOCK = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>False Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__FALSE_BLOCK = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConjunctionImpl <em>Conjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConjunctionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getConjunction()
	 * @generated
	 */
	int CONJUNCTION = 24;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUNCTION__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUNCTION__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUNCTION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUNCTION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Conjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONJUNCTION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DisjunctionImpl <em>Disjunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DisjunctionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getDisjunction()
	 * @generated
	 */
	int DISJUNCTION = 25;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTION__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTION__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Disjunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DivisionImpl <em>Division</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DivisionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getDivision()
	 * @generated
	 */
	int DIVISION = 26;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Division</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIVISION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EqualImpl <em>Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EqualImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getEqual()
	 * @generated
	 */
	int EQUAL = 27;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EquivalenceImpl <em>Equivalence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EquivalenceImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getEquivalence()
	 * @generated
	 */
	int EQUIVALENCE = 28;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Equivalence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUIVALENCE_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.QuantifiedExpressionImpl <em>Quantified Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.QuantifiedExpressionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getQuantifiedExpression()
	 * @generated
	 */
	int QUANTIFIED_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_EXPRESSION__LINE_NUMBER = EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_EXPRESSION__POSITION_IN_LINE = EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_EXPRESSION__PARAMETER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_EXPRESSION__CONDITION = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Quantified Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTIFIED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExistsQuantifierImpl <em>Exists Quantifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExistsQuantifierImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getExistsQuantifier()
	 * @generated
	 */
	int EXISTS_QUANTIFIER = 29;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_QUANTIFIER__LINE_NUMBER = QUANTIFIED_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_QUANTIFIER__POSITION_IN_LINE = QUANTIFIED_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_QUANTIFIER__PARAMETER = QUANTIFIED_EXPRESSION__PARAMETER;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_QUANTIFIER__EXPRESSION = QUANTIFIED_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_QUANTIFIER__CONDITION = QUANTIFIED_EXPRESSION__CONDITION;

	/**
	 * The number of structural features of the '<em>Exists Quantifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_QUANTIFIER_FEATURE_COUNT = QUANTIFIED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ParameterImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 31;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__LINE_NUMBER = AST_NODE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__POSITION_IN_LINE = AST_NODE__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ForAllQuantifierImpl <em>For All Quantifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ForAllQuantifierImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getForAllQuantifier()
	 * @generated
	 */
	int FOR_ALL_QUANTIFIER = 32;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_QUANTIFIER__LINE_NUMBER = QUANTIFIED_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_QUANTIFIER__POSITION_IN_LINE = QUANTIFIED_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_QUANTIFIER__PARAMETER = QUANTIFIED_EXPRESSION__PARAMETER;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_QUANTIFIER__EXPRESSION = QUANTIFIED_EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_QUANTIFIER__CONDITION = QUANTIFIED_EXPRESSION__CONDITION;

	/**
	 * The number of structural features of the '<em>For All Quantifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_QUANTIFIER_FEATURE_COUNT = QUANTIFIED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionCallImpl <em>Function Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionCallImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getFunctionCall()
	 * @generated
	 */
	int FUNCTION_CALL = 33;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__LINE_NUMBER = EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__POSITION_IN_LINE = EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Actuals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__ACTUALS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__FUNCTION = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionDeclarationImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getFunctionDeclaration()
	 * @generated
	 */
	int FUNCTION_DECLARATION = 34;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__LINE_NUMBER = AST_NODE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__POSITION_IN_LINE = AST_NODE__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__PRECONDITIONS = AST_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__POSTCONDITIONS = AST_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__PARAMETERS = AST_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__BODY = AST_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__RETURN_TYPE = AST_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION__NAME = AST_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Function Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DECLARATION_FEATURE_COUNT = AST_NODE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PreconditionImpl <em>Precondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PreconditionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPrecondition()
	 * @generated
	 */
	int PRECONDITION = 35;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION__LINE_NUMBER = ANNOTATION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION__POSITION_IN_LINE = ANNOTATION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Precondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PostconditionImpl <em>Postcondition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PostconditionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPostcondition()
	 * @generated
	 */
	int POSTCONDITION = 36;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION__LINE_NUMBER = ANNOTATION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION__POSITION_IN_LINE = ANNOTATION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Postcondition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTCONDITION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterImpl <em>Greater</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getGreater()
	 * @generated
	 */
	int GREATER = 37;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterOrEqualImpl <em>Greater Or Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterOrEqualImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getGreaterOrEqual()
	 * @generated
	 */
	int GREATER_OR_EQUAL = 38;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater Or Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ImplicationImpl <em>Implication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ImplicationImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getImplication()
	 * @generated
	 */
	int IMPLICATION = 39;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Implication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLICATION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerLiteralImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 40;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__LINE_NUMBER = LITERAL__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__POSITION_IN_LINE = LITERAL__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerTypeImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 41;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__LINE_NUMBER = PRIMITIVE_TYPE__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__POSITION_IN_LINE = PRIMITIVE_TYPE__POSITION_IN_LINE;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.InvariantImpl <em>Invariant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.InvariantImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getInvariant()
	 * @generated
	 */
	int INVARIANT = 42;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__LINE_NUMBER = ANNOTATION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__POSITION_IN_LINE = ANNOTATION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__EXPRESSION = ANNOTATION__EXPRESSION;

	/**
	 * The number of structural features of the '<em>Invariant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessImpl <em>Less</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLess()
	 * @generated
	 */
	int LESS = 43;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Less</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessOrEqualImpl <em>Less Or Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessOrEqualImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLessOrEqual()
	 * @generated
	 */
	int LESS_OR_EQUAL = 44;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Less Or Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LoopImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 45;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__LINE_NUMBER = STATEMENT__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__POSITION_IN_LINE = STATEMENT__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__BODY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__INVARIANTS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SignImpl <em>Sign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SignImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getSign()
	 * @generated
	 */
	int SIGN = 47;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGN__LINE_NUMBER = UNARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGN__POSITION_IN_LINE = UNARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGN__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Sign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGN_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MinusImpl <em>Minus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MinusImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getMinus()
	 * @generated
	 */
	int MINUS = 46;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__LINE_NUMBER = SIGN__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__POSITION_IN_LINE = SIGN__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS__OPERAND = SIGN__OPERAND;

	/**
	 * The number of structural features of the '<em>Minus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINUS_FEATURE_COUNT = SIGN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ModulusImpl <em>Modulus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ModulusImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getModulus()
	 * @generated
	 */
	int MODULUS = 48;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULUS__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULUS__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULUS__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULUS__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Modulus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULUS_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MultiplicationImpl <em>Multiplication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MultiplicationImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getMultiplication()
	 * @generated
	 */
	int MULTIPLICATION = 49;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Multiplication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.NegationImpl <em>Negation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.NegationImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getNegation()
	 * @generated
	 */
	int NEGATION = 50;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION__LINE_NUMBER = UNARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION__POSITION_IN_LINE = UNARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION__OPERAND = UNARY_EXPRESSION__OPERAND;

	/**
	 * The number of structural features of the '<em>Negation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATION_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PlusImpl <em>Plus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PlusImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPlus()
	 * @generated
	 */
	int PLUS = 51;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__LINE_NUMBER = SIGN__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__POSITION_IN_LINE = SIGN__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS__OPERAND = SIGN__OPERAND;

	/**
	 * The number of structural features of the '<em>Plus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_FEATURE_COUNT = SIGN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ReturnStatementImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getReturnStatement()
	 * @generated
	 */
	int RETURN_STATEMENT = 52;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__LINE_NUMBER = STATEMENT__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__POSITION_IN_LINE = STATEMENT__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Return Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__RETURN_VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SubtractionImpl <em>Subtraction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SubtractionImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getSubtraction()
	 * @generated
	 */
	int SUBTRACTION = 53;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACTION__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACTION__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACTION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACTION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Subtraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBTRACTION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnequalImpl <em>Unequal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnequalImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getUnequal()
	 * @generated
	 */
	int UNEQUAL = 54;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEQUAL__LINE_NUMBER = BINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEQUAL__POSITION_IN_LINE = BINARY_EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEQUAL__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEQUAL__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Unequal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNEQUAL_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableReferenceImpl
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 55;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__LINE_NUMBER = EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__POSITION_IN_LINE = EXPRESSION__POSITION_IN_LINE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__VARIABLE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__INDEX = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getFunctionDeclarations <em>Function Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Declarations</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getFunctionDeclarations()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_FunctionDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock <em>Main Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Main Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_MainBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getAxioms <em>Axioms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Axioms</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getAxioms()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Axioms();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode <em>AST Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AST Node</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode
	 * @generated
	 */
	EClass getASTNode();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getLineNumber()
	 * @see #getASTNode()
	 * @generated
	 */
	EAttribute getASTNode_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getPositionInLine <em>Position In Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position In Line</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getPositionInLine()
	 * @see #getASTNode()
	 * @generated
	 */
	EAttribute getASTNode_PositionInLine();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor <em>AST Node Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AST Node Visitor</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor
	 * @generated
	 */
	EClass getASTNodeVisitor();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Addition <em>Addition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Addition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Addition
	 * @generated
	 */
	EClass getAddition();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getLeft()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression#getRight()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Right();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess <em>Array Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Access</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess
	 * @generated
	 */
	EClass getArrayAccess();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess#getIndex()
	 * @see #getArrayAccess()
	 * @generated
	 */
	EReference getArrayAccess_Index();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression#getOperand()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Operand();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength <em>Array Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Length</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength
	 * @generated
	 */
	EClass getArrayLength();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral <em>Array Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral
	 * @generated
	 */
	EClass getArrayLiteral();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral#getValues()
	 * @see #getArrayLiteral()
	 * @generated
	 */
	EReference getArrayLiteral_Values();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType
	 * @generated
	 */
	EClass getArrayType();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getBaseType()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_BaseType();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getSize()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_Size();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assertion</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion
	 * @generated
	 */
	EClass getAssertion();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation#getExpression()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Expression();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Value();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment#getVariable()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Variable();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Type();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getInitialValue()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_InitialValue();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assumption</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption
	 * @generated
	 */
	EClass getAssumption();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom <em>Axiom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axiom</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom
	 * @generated
	 */
	EClass getAxiom();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Block#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Block#getStatements()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Statements();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral#isValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Value();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional <em>Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional
	 * @generated
	 */
	EClass getConditional();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getCondition()
	 * @see #getConditional()
	 * @generated
	 */
	EReference getConditional_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getTrueBlock <em>True Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>True Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getTrueBlock()
	 * @see #getConditional()
	 * @generated
	 */
	EReference getConditional_TrueBlock();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getFalseBlock <em>False Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>False Block</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getFalseBlock()
	 * @see #getConditional()
	 * @generated
	 */
	EReference getConditional_FalseBlock();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction <em>Conjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conjunction</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction
	 * @generated
	 */
	EClass getConjunction();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction <em>Disjunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disjunction</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction
	 * @generated
	 */
	EClass getDisjunction();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Division <em>Division</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Division</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Division
	 * @generated
	 */
	EClass getDivision();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equal <em>Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equal
	 * @generated
	 */
	EClass getEqual();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence <em>Equivalence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equivalence</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence
	 * @generated
	 */
	EClass getEquivalence();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier <em>Exists Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists Quantifier</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier
	 * @generated
	 */
	EClass getExistsQuantifier();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression <em>Quantified Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantified Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression
	 * @generated
	 */
	EClass getQuantifiedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getParameter()
	 * @see #getQuantifiedExpression()
	 * @generated
	 */
	EReference getQuantifiedExpression_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getExpression()
	 * @see #getQuantifiedExpression()
	 * @generated
	 */
	EReference getQuantifiedExpression_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression#getCondition()
	 * @see #getQuantifiedExpression()
	 * @generated
	 */
	EReference getQuantifiedExpression_Condition();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier <em>For All Quantifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For All Quantifier</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier
	 * @generated
	 */
	EClass getForAllQuantifier();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall
	 * @generated
	 */
	EClass getFunctionCall();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getActuals <em>Actuals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actuals</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getActuals()
	 * @see #getFunctionCall()
	 * @generated
	 */
	EReference getFunctionCall_Actuals();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getFunction()
	 * @see #getFunctionCall()
	 * @generated
	 */
	EReference getFunctionCall_Function();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration <em>Function Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Declaration</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration
	 * @generated
	 */
	EClass getFunctionDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPreconditions()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EReference getFunctionDeclaration_Preconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPostconditions <em>Postconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Postconditions</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPostconditions()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EReference getFunctionDeclaration_Postconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getParameters()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EReference getFunctionDeclaration_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getBody()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EReference getFunctionDeclaration_Body();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getReturnType()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EReference getFunctionDeclaration_ReturnType();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getName()
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	EAttribute getFunctionDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precondition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition
	 * @generated
	 */
	EClass getPrecondition();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postcondition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition
	 * @generated
	 */
	EClass getPostcondition();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Greater <em>Greater</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Greater
	 * @generated
	 */
	EClass getGreater();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual <em>Greater Or Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Or Equal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual
	 * @generated
	 */
	EClass getGreaterOrEqual();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Implication <em>Implication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implication</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Implication
	 * @generated
	 */
	EClass getImplication();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant
	 * @generated
	 */
	EClass getInvariant();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Less <em>Less</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Less
	 * @generated
	 */
	EClass getLess();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual <em>Less Or Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Or Equal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual
	 * @generated
	 */
	EClass getLessOrEqual();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getCondition()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getBody()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Body();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getInvariants <em>Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Loop#getInvariants()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Invariants();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Minus <em>Minus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minus</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Minus
	 * @generated
	 */
	EClass getMinus();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Sign <em>Sign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sign</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Sign
	 * @generated
	 */
	EClass getSign();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus <em>Modulus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modulus</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus
	 * @generated
	 */
	EClass getModulus();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication <em>Multiplication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplication</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication
	 * @generated
	 */
	EClass getMultiplication();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Negation <em>Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Negation</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Negation
	 * @generated
	 */
	EClass getNegation();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Plus
	 * @generated
	 */
	EClass getPlus();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Statement</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement
	 * @generated
	 */
	EClass getReturnStatement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement#getReturnValue <em>Return Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Value</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement#getReturnValue()
	 * @see #getReturnStatement()
	 * @generated
	 */
	EReference getReturnStatement_ReturnValue();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction <em>Subtraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subtraction</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction
	 * @generated
	 */
	EClass getSubtraction();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal <em>Unequal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unequal</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal
	 * @generated
	 */
	EClass getUnequal();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getVariable()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getIndex()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_Index();

	/**
	 * Returns the meta object for class '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AstFactory getAstFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ProgramImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Function Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__FUNCTION_DECLARATIONS = eINSTANCE.getProgram_FunctionDeclarations();

		/**
		 * The meta object literal for the '<em><b>Main Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__MAIN_BLOCK = eINSTANCE.getProgram_MainBlock();

		/**
		 * The meta object literal for the '<em><b>Axioms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__AXIOMS = eINSTANCE.getProgram_Axioms();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ASTNodeImpl <em>AST Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ASTNodeImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getASTNode()
		 * @generated
		 */
		EClass AST_NODE = eINSTANCE.getASTNode();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AST_NODE__LINE_NUMBER = eINSTANCE.getASTNode_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Position In Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AST_NODE__POSITION_IN_LINE = eINSTANCE.getASTNode_PositionInLine();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor <em>AST Node Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getASTNodeVisitor()
		 * @generated
		 */
		EClass AST_NODE_VISITOR = eINSTANCE.getASTNodeVisitor();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AdditionImpl <em>Addition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AdditionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAddition()
		 * @generated
		 */
		EClass ADDITION = eINSTANCE.getAddition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BinaryExpressionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__LEFT = eINSTANCE.getBinaryExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__RIGHT = eINSTANCE.getBinaryExpression_Right();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExpressionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayAccessImpl <em>Array Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayAccessImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayAccess()
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
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnaryExpressionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__OPERAND = eINSTANCE.getUnaryExpression_Operand();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLengthImpl <em>Array Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLengthImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayLength()
		 * @generated
		 */
		EClass ARRAY_LENGTH = eINSTANCE.getArrayLength();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLiteralImpl <em>Array Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayLiteralImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayLiteral()
		 * @generated
		 */
		EClass ARRAY_LITERAL = eINSTANCE.getArrayLiteral();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_LITERAL__VALUES = eINSTANCE.getArrayLiteral_Values();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LiteralImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayTypeImpl <em>Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ArrayTypeImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getArrayType()
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
		 * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__SIZE = eINSTANCE.getArrayType_Size();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.TypeImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PrimitiveTypeImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssertionImpl <em>Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssertionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAssertion()
		 * @generated
		 */
		EClass ASSERTION = eINSTANCE.getAssertion();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AnnotationImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__EXPRESSION = eINSTANCE.getAnnotation_Expression();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssignmentImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VARIABLE = eINSTANCE.getAssignment_Variable();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableDeclarationImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__INITIAL_VALUE = eINSTANCE.getVariableDeclaration_InitialValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssumptionImpl <em>Assumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AssumptionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAssumption()
		 * @generated
		 */
		EClass ASSUMPTION = eINSTANCE.getAssumption();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AxiomImpl <em>Axiom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AxiomImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getAxiom()
		 * @generated
		 */
		EClass AXIOM = eINSTANCE.getAxiom();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BlockImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBlock()
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
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanLiteralImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.BooleanTypeImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConditionalImpl <em>Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConditionalImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getConditional()
		 * @generated
		 */
		EClass CONDITIONAL = eINSTANCE.getConditional();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL__CONDITION = eINSTANCE.getConditional_Condition();

		/**
		 * The meta object literal for the '<em><b>True Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL__TRUE_BLOCK = eINSTANCE.getConditional_TrueBlock();

		/**
		 * The meta object literal for the '<em><b>False Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL__FALSE_BLOCK = eINSTANCE.getConditional_FalseBlock();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConjunctionImpl <em>Conjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConjunctionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getConjunction()
		 * @generated
		 */
		EClass CONJUNCTION = eINSTANCE.getConjunction();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DisjunctionImpl <em>Disjunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DisjunctionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getDisjunction()
		 * @generated
		 */
		EClass DISJUNCTION = eINSTANCE.getDisjunction();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DivisionImpl <em>Division</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.DivisionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getDivision()
		 * @generated
		 */
		EClass DIVISION = eINSTANCE.getDivision();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EqualImpl <em>Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EqualImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getEqual()
		 * @generated
		 */
		EClass EQUAL = eINSTANCE.getEqual();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EquivalenceImpl <em>Equivalence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.EquivalenceImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getEquivalence()
		 * @generated
		 */
		EClass EQUIVALENCE = eINSTANCE.getEquivalence();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExistsQuantifierImpl <em>Exists Quantifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ExistsQuantifierImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getExistsQuantifier()
		 * @generated
		 */
		EClass EXISTS_QUANTIFIER = eINSTANCE.getExistsQuantifier();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.QuantifiedExpressionImpl <em>Quantified Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.QuantifiedExpressionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getQuantifiedExpression()
		 * @generated
		 */
		EClass QUANTIFIED_EXPRESSION = eINSTANCE.getQuantifiedExpression();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUANTIFIED_EXPRESSION__PARAMETER = eINSTANCE.getQuantifiedExpression_Parameter();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUANTIFIED_EXPRESSION__EXPRESSION = eINSTANCE.getQuantifiedExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUANTIFIED_EXPRESSION__CONDITION = eINSTANCE.getQuantifiedExpression_Condition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ParameterImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ForAllQuantifierImpl <em>For All Quantifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ForAllQuantifierImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getForAllQuantifier()
		 * @generated
		 */
		EClass FOR_ALL_QUANTIFIER = eINSTANCE.getForAllQuantifier();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionCallImpl <em>Function Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionCallImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getFunctionCall()
		 * @generated
		 */
		EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

		/**
		 * The meta object literal for the '<em><b>Actuals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL__ACTUALS = eINSTANCE.getFunctionCall_Actuals();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL__FUNCTION = eINSTANCE.getFunctionCall_Function();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionDeclarationImpl <em>Function Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.FunctionDeclarationImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getFunctionDeclaration()
		 * @generated
		 */
		EClass FUNCTION_DECLARATION = eINSTANCE.getFunctionDeclaration();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DECLARATION__PRECONDITIONS = eINSTANCE.getFunctionDeclaration_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DECLARATION__POSTCONDITIONS = eINSTANCE.getFunctionDeclaration_Postconditions();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DECLARATION__PARAMETERS = eINSTANCE.getFunctionDeclaration_Parameters();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DECLARATION__BODY = eINSTANCE.getFunctionDeclaration_Body();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DECLARATION__RETURN_TYPE = eINSTANCE.getFunctionDeclaration_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_DECLARATION__NAME = eINSTANCE.getFunctionDeclaration_Name();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PreconditionImpl <em>Precondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PreconditionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPrecondition()
		 * @generated
		 */
		EClass PRECONDITION = eINSTANCE.getPrecondition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PostconditionImpl <em>Postcondition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PostconditionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPostcondition()
		 * @generated
		 */
		EClass POSTCONDITION = eINSTANCE.getPostcondition();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterImpl <em>Greater</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getGreater()
		 * @generated
		 */
		EClass GREATER = eINSTANCE.getGreater();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterOrEqualImpl <em>Greater Or Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.GreaterOrEqualImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getGreaterOrEqual()
		 * @generated
		 */
		EClass GREATER_OR_EQUAL = eINSTANCE.getGreaterOrEqual();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ImplicationImpl <em>Implication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ImplicationImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getImplication()
		 * @generated
		 */
		EClass IMPLICATION = eINSTANCE.getImplication();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerLiteralImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.IntegerTypeImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.InvariantImpl <em>Invariant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.InvariantImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getInvariant()
		 * @generated
		 */
		EClass INVARIANT = eINSTANCE.getInvariant();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessImpl <em>Less</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLess()
		 * @generated
		 */
		EClass LESS = eINSTANCE.getLess();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessOrEqualImpl <em>Less Or Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LessOrEqualImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLessOrEqual()
		 * @generated
		 */
		EClass LESS_OR_EQUAL = eINSTANCE.getLessOrEqual();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.LoopImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__CONDITION = eINSTANCE.getLoop_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__BODY = eINSTANCE.getLoop_Body();

		/**
		 * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__INVARIANTS = eINSTANCE.getLoop_Invariants();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MinusImpl <em>Minus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MinusImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getMinus()
		 * @generated
		 */
		EClass MINUS = eINSTANCE.getMinus();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SignImpl <em>Sign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SignImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getSign()
		 * @generated
		 */
		EClass SIGN = eINSTANCE.getSign();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ModulusImpl <em>Modulus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ModulusImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getModulus()
		 * @generated
		 */
		EClass MODULUS = eINSTANCE.getModulus();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MultiplicationImpl <em>Multiplication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.MultiplicationImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getMultiplication()
		 * @generated
		 */
		EClass MULTIPLICATION = eINSTANCE.getMultiplication();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.NegationImpl <em>Negation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.NegationImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getNegation()
		 * @generated
		 */
		EClass NEGATION = eINSTANCE.getNegation();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PlusImpl <em>Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.PlusImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getPlus()
		 * @generated
		 */
		EClass PLUS = eINSTANCE.getPlus();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ReturnStatementImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getReturnStatement()
		 * @generated
		 */
		EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

		/**
		 * The meta object literal for the '<em><b>Return Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_STATEMENT__RETURN_VALUE = eINSTANCE.getReturnStatement_ReturnValue();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SubtractionImpl <em>Subtraction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.SubtractionImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getSubtraction()
		 * @generated
		 */
		EClass SUBTRACTION = eINSTANCE.getSubtraction();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnequalImpl <em>Unequal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.UnequalImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getUnequal()
		 * @generated
		 */
		EClass UNEQUAL = eINSTANCE.getUnequal();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.VariableReferenceImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__INDEX = eINSTANCE.getVariableReference_Index();

		/**
		 * The meta object literal for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.StatementImpl
		 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.impl.AstPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

	}

} //AstPackage
