/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.tests.model.ast;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Greater Or Equal</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GreaterOrEqualTest extends BinaryExpressionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GreaterOrEqualTest.class);
	}

	/**
	 * Constructs a new Greater Or Equal test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterOrEqualTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Greater Or Equal test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GreaterOrEqual getFixture() {
		return (GreaterOrEqual)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AstFactory.eINSTANCE.createGreaterOrEqual());
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

} //GreaterOrEqualTest
