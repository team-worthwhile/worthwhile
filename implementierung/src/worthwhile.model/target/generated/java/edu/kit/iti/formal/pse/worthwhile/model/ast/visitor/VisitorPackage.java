/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VisitorFactory
 * @model kind="package"
 * @generated
 */
public class VisitorPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "visitor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http:///visitor.ast.model.worthwhile.pse.formal.iti.kit.edu";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "edu.kit.iti.formal.pse.worthwhile.model.ast.visitor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final VisitorPackage eINSTANCE = edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VisitorPackage
	                .init();

	/**
	 * The meta object id for the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor <em>IAST Node Visitor</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VisitorPackage#getIASTNodeVisitor()
	 * @generated
	 */
	public static final int IAST_NODE_VISITOR = 0;

	/**
	 * The number of structural features of the '<em>IAST Node Visitor</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int IAST_NODE_VISITOR_FEATURE_COUNT = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iastNodeVisitorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.VisitorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VisitorPackage() {
		super(eNS_URI, VisitorFactory.eINSTANCE);
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
	 * This method is used to initialize {@link VisitorPackage#eINSTANCE} when that field is accessed. Clients
	 * should not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VisitorPackage init() {
		if (isInited)
			return (VisitorPackage) EPackage.Registry.INSTANCE.getEPackage(VisitorPackage.eNS_URI);

		// Obtain or create and register package
		VisitorPackage theVisitorPackage = (VisitorPackage) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VisitorPackage ? EPackage.Registry.INSTANCE
		                .get(eNS_URI) : new VisitorPackage());

		isInited = true;

		// Obtain or create and register interdependencies
		AstPackage theAstPackage = (AstPackage) (EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackage ? EPackage.Registry.INSTANCE
		                .getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);

		// Create package meta-data objects
		theVisitorPackage.createPackageContents();
		theAstPackage.createPackageContents();

		// Initialize created meta-data
		theVisitorPackage.initializePackageContents();
		theAstPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVisitorPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VisitorPackage.eNS_URI, theVisitorPackage);
		return theVisitorPackage;
	}

	/**
	 * Returns the meta object for class '
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor <em>IAST Node Visitor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IAST Node Visitor</em>'.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor
	 * @model instanceClass="edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor"
	 * @generated
	 */
	public EClass getIASTNodeVisitor() {
		return iastNodeVisitorEClass;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public VisitorFactory getVisitorFactory() {
		return (VisitorFactory) getEFactoryInstance();
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
		iastNodeVisitorEClass = createEClass(IAST_NODE_VISITOR);
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
		AstPackage theAstPackage = (AstPackage) EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(iastNodeVisitorEClass, IASTNodeVisitor.class, "IASTNodeVisitor", IS_ABSTRACT, IS_INTERFACE,
		                !IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getAddition(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getAnnotation(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getArrayLiteral(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getArrayType(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getAssertion(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getAssignment(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getAssumption(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getASTNode(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getAxiom(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getBinaryExpression(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getBlock(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getBooleanLiteral(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getBooleanType(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getConditional(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getConjunction(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getDisjunction(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getDivision(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getEqual(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getEquivalence(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getExistsQuantifier(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getExpression(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getForAllQuantifier(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getFunctionCall(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getFunctionDeclaration(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getGreater(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getGreaterOrEqual(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getImplication(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getIntegerLiteral(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getIntegerType(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getInvariant(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getLess(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getLessOrEqual(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getLiteral(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getLoop(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getMinus(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getModulus(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getMultiplication(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getNegation(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getPlus(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getPostcondition(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getPrecondition(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getPrimitiveType(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getProgram(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getQuantifiedExpression(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getReturnStatement(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getSign(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getStatement(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getSubtraction(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getType(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getUnaryExpression(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getUnequal(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getVariableDeclaration(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getVariableReference(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iastNodeVisitorEClass, null, "visit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAstPackage.getArrayFunction(), "node", 1, 1, IS_UNIQUE, IS_ORDERED);
	}

} // VisitorPackage
