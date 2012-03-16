/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ternary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression#getWhenTrue <em>When True</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression#getWhenFalse <em>When False</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getTernaryExpression()
 * @model kind="class"
 * @generated
 */
public class TernaryExpression extends Expression {
	/**
	 * The cached value of the '{@link #getWhenTrue() <em>When True</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhenTrue()
	 * @generated
	 * @ordered
	 */
	protected Expression whenTrue;

	/**
	 * The cached value of the '{@link #getWhenFalse() <em>When False</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhenFalse()
	 * @generated
	 * @ordered
	 */
	protected Expression whenFalse;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TernaryExpression() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.TERNARY_EXPRESSION;
	}

	/**
	 * Returns the value of the '<em><b>When True</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When True</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When True</em>' containment reference.
	 * @see #setWhenTrue(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getTernaryExpression_WhenTrue()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public Expression getWhenTrue() {
		return whenTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhenTrue(Expression newWhenTrue, NotificationChain msgs) {
		Expression oldWhenTrue = whenTrue;
		whenTrue = newWhenTrue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.TERNARY_EXPRESSION__WHEN_TRUE, oldWhenTrue, newWhenTrue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression#getWhenTrue <em>When True</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When True</em>' containment reference.
	 * @see #getWhenTrue()
	 * @generated
	 */
	public void setWhenTrue(Expression newWhenTrue) {
		if (newWhenTrue != whenTrue) {
			NotificationChain msgs = null;
			if (whenTrue != null)
				msgs = ((InternalEObject) whenTrue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.TERNARY_EXPRESSION__WHEN_TRUE, null, msgs);
			if (newWhenTrue != null)
				msgs = ((InternalEObject) newWhenTrue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.TERNARY_EXPRESSION__WHEN_TRUE, null, msgs);
			msgs = basicSetWhenTrue(newWhenTrue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.TERNARY_EXPRESSION__WHEN_TRUE,
			                newWhenTrue, newWhenTrue));
	}

	/**
	 * Returns the value of the '<em><b>When False</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When False</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When False</em>' containment reference.
	 * @see #setWhenFalse(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getTernaryExpression_WhenFalse()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public Expression getWhenFalse() {
		return whenFalse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhenFalse(Expression newWhenFalse, NotificationChain msgs) {
		Expression oldWhenFalse = whenFalse;
		whenFalse = newWhenFalse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.TERNARY_EXPRESSION__WHEN_FALSE, oldWhenFalse, newWhenFalse);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression#getWhenFalse <em>When False</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When False</em>' containment reference.
	 * @see #getWhenFalse()
	 * @generated
	 */
	public void setWhenFalse(Expression newWhenFalse) {
		if (newWhenFalse != whenFalse) {
			NotificationChain msgs = null;
			if (whenFalse != null)
				msgs = ((InternalEObject) whenFalse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.TERNARY_EXPRESSION__WHEN_FALSE, null, msgs);
			if (newWhenFalse != null)
				msgs = ((InternalEObject) newWhenFalse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.TERNARY_EXPRESSION__WHEN_FALSE, null, msgs);
			msgs = basicSetWhenFalse(newWhenFalse, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			                AstPackage.TERNARY_EXPRESSION__WHEN_FALSE, newWhenFalse, newWhenFalse));
	}

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getTernaryExpression_Condition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.TERNARY_EXPRESSION__CONDITION, oldCondition, newCondition);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.TERNARY_EXPRESSION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.TERNARY_EXPRESSION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.TERNARY_EXPRESSION__CONDITION,
			                newCondition, newCondition));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.TERNARY_EXPRESSION__WHEN_TRUE:
				return basicSetWhenTrue(null, msgs);
			case AstPackage.TERNARY_EXPRESSION__WHEN_FALSE:
				return basicSetWhenFalse(null, msgs);
			case AstPackage.TERNARY_EXPRESSION__CONDITION:
				return basicSetCondition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.TERNARY_EXPRESSION__WHEN_TRUE:
				return getWhenTrue();
			case AstPackage.TERNARY_EXPRESSION__WHEN_FALSE:
				return getWhenFalse();
			case AstPackage.TERNARY_EXPRESSION__CONDITION:
				return getCondition();
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
			case AstPackage.TERNARY_EXPRESSION__WHEN_TRUE:
				setWhenTrue((Expression) newValue);
				return;
			case AstPackage.TERNARY_EXPRESSION__WHEN_FALSE:
				setWhenFalse((Expression) newValue);
				return;
			case AstPackage.TERNARY_EXPRESSION__CONDITION:
				setCondition((Expression) newValue);
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
			case AstPackage.TERNARY_EXPRESSION__WHEN_TRUE:
				setWhenTrue((Expression) null);
				return;
			case AstPackage.TERNARY_EXPRESSION__WHEN_FALSE:
				setWhenFalse((Expression) null);
				return;
			case AstPackage.TERNARY_EXPRESSION__CONDITION:
				setCondition((Expression) null);
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
			case AstPackage.TERNARY_EXPRESSION__WHEN_TRUE:
				return whenTrue != null;
			case AstPackage.TERNARY_EXPRESSION__WHEN_FALSE:
				return whenFalse != null;
			case AstPackage.TERNARY_EXPRESSION__CONDITION:
				return condition != null;
		}
		return super.eIsSet(featureID);
	}

} // TernaryExpression
