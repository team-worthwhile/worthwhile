/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.tests.model.ast;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor;

import junit.framework.TestCase;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>AST Node Visitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Addition) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Block) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Division) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Equal) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Greater) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Implication) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Less) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Loop) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Minus) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Negation) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Plus) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Program) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal) <em>Visit</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration) <em>Visit</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class ASTNodeVisitorTest extends TestCase {

	/**
	 * The fixture for this AST Node Visitor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ASTNodeVisitor fixture = null;

	/**
	 * Constructs a new AST Node Visitor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASTNodeVisitorTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this AST Node Visitor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ASTNodeVisitor fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this AST Node Visitor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ASTNodeVisitor getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Addition) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Addition)
	 * @generated
	 */
	public void testVisit__Addition() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess)
	 * @generated
	 */
	public void testVisit__ArrayAccess() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength)
	 * @generated
	 */
	public void testVisit__ArrayLength() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral)
	 * @generated
	 */
	public void testVisit__ArrayLiteral() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType)
	 * @generated
	 */
	public void testVisit__ArrayType() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion)
	 * @generated
	 */
	public void testVisit__Assertion() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment)
	 * @generated
	 */
	public void testVisit__Assignment() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption)
	 * @generated
	 */
	public void testVisit__Assumption() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom)
	 * @generated
	 */
	public void testVisit__Axiom() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Block) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Block)
	 * @generated
	 */
	public void testVisit__Block() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral)
	 * @generated
	 */
	public void testVisit__BooleanLiteral() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType)
	 * @generated
	 */
	public void testVisit__BooleanType() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional)
	 * @generated
	 */
	public void testVisit__Conditional() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction)
	 * @generated
	 */
	public void testVisit__Conjunction() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction)
	 * @generated
	 */
	public void testVisit__Disjunction() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Division) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Division)
	 * @generated
	 */
	public void testVisit__Division() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Equal) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Equal)
	 * @generated
	 */
	public void testVisit__Equal() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence)
	 * @generated
	 */
	public void testVisit__Equivalence() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier)
	 * @generated
	 */
	public void testVisit__ExistsQuantifier() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier)
	 * @generated
	 */
	public void testVisit__ForAllQuantifier() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall)
	 * @generated
	 */
	public void testVisit__FunctionCall() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration)
	 * @generated
	 */
	public void testVisit__FunctionDeclaration() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Greater) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Greater)
	 * @generated
	 */
	public void testVisit__Greater() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual)
	 * @generated
	 */
	public void testVisit__GreaterOrEqual() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Implication) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Implication)
	 * @generated
	 */
	public void testVisit__Implication() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral)
	 * @generated
	 */
	public void testVisit__IntegerLiteral() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType)
	 * @generated
	 */
	public void testVisit__IntegerType() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant)
	 * @generated
	 */
	public void testVisit__Invariant() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Less) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Less)
	 * @generated
	 */
	public void testVisit__Less() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual)
	 * @generated
	 */
	public void testVisit__LessOrEqual() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Loop) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Loop)
	 * @generated
	 */
	public void testVisit__Loop() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Minus) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Minus)
	 * @generated
	 */
	public void testVisit__Minus() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus)
	 * @generated
	 */
	public void testVisit__Modulus() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication)
	 * @generated
	 */
	public void testVisit__Multiplication() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Negation) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Negation)
	 * @generated
	 */
	public void testVisit__Negation() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode)
	 * @generated
	 */
	public void testVisit__ASTNode() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Parameter)
	 * @generated
	 */
	public void testVisit__Parameter() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Plus) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Plus)
	 * @generated
	 */
	public void testVisit__Plus() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition)
	 * @generated
	 */
	public void testVisit__Postcondition() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition)
	 * @generated
	 */
	public void testVisit__Precondition() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Program) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Program)
	 * @generated
	 */
	public void testVisit__Program() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement)
	 * @generated
	 */
	public void testVisit__ReturnStatement() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction)
	 * @generated
	 */
	public void testVisit__Subtraction() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal)
	 * @generated
	 */
	public void testVisit__Unequal() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration) <em>Visit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNodeVisitor#visit(edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration)
	 * @generated
	 */
	public void testVisit__VariableDeclaration() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ASTNodeVisitorTest
