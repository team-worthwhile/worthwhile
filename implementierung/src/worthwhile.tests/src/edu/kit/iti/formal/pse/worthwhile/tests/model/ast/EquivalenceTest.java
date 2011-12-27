/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.tests.model.ast;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Equivalence</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EquivalenceTest extends BinaryExpressionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EquivalenceTest.class);
	}

	/**
	 * Constructs a new Equivalence test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquivalenceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Equivalence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Equivalence getFixture() {
		return (Equivalence)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AstFactory.eINSTANCE.createEquivalence());
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

} //EquivalenceTest
