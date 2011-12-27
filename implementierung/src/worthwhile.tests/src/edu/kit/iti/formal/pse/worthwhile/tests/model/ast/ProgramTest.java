/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.tests.model.ast;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProgramTest extends ASTNodeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ProgramTest.class);
	}

	/**
	 * Constructs a new Program test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Program test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Program getFixture() {
		return (Program)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AstFactory.eINSTANCE.createProgram());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ProgramTest
