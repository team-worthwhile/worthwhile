/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Divisor Not Zero Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion#getGuardedNode <em>Guarded Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDivisorNotZeroAssertion()
 * @model kind="class"
 * @generated
 */
public class DivisorNotZeroAssertion extends GuardAssertion {
	/**
	 * The cached value of the '{@link #getGuardedNode() <em>Guarded Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardedNode()
	 * @generated
	 * @ordered
	 */
	protected Expression guardedNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DivisorNotZeroAssertion() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.DIVISOR_NOT_ZERO_ASSERTION;
	}

	/**
	 * Returns the value of the '<em><b>Guarded Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guarded Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guarded Node</em>' reference.
	 * @see #setGuardedNode(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getDivisorNotZeroAssertion_GuardedNode()
	 * @model required="true"
	 * @generated
	 */
	public Expression getGuardedNode() {
		if (guardedNode != null && guardedNode.eIsProxy()) {
			InternalEObject oldGuardedNode = (InternalEObject) guardedNode;
			guardedNode = (Expression) eResolveProxy(oldGuardedNode);
			if (guardedNode != oldGuardedNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					                AstPackage.DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE,
					                oldGuardedNode, guardedNode));
			}
		}
		return guardedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetGuardedNode() {
		return guardedNode;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.DivisorNotZeroAssertion#getGuardedNode <em>Guarded Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guarded Node</em>' reference.
	 * @see #getGuardedNode()
	 * @generated
	 */
	public void setGuardedNode(Expression newGuardedNode) {
		Expression oldGuardedNode = guardedNode;
		guardedNode = newGuardedNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			                AstPackage.DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE, oldGuardedNode,
			                guardedNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorType="edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor" visitorRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visit(this);'"
	 * @generated
	 */
	public void accept(IASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE:
				if (resolve)
					return getGuardedNode();
				return basicGetGuardedNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE:
				setGuardedNode((Expression) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AstPackage.DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE:
				setGuardedNode((Expression) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AstPackage.DIVISOR_NOT_ZERO_ASSERTION__GUARDED_NODE:
				return guardedNode != null;
		}
		return super.eIsSet(featureID);
	}

} // DivisorNotZeroAssertion
