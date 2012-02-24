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
 * A representation of the model object '<em><b>Array Function Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess#getIndex <em>Index</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunctionAccess()
 * @model kind="class"
 * @generated
 */
public class ArrayFunctionAccess extends Expression {
	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected Expression index;

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected Expression function;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayFunctionAccess() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.ARRAY_FUNCTION_ACCESS;
	}

	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' containment reference.
	 * @see #setIndex(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunctionAccess_Index()
	 * @model containment="true"
	 * @generated
	 */
	public Expression getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIndex(Expression newIndex, NotificationChain msgs) {
		Expression oldIndex = index;
		index = newIndex;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.ARRAY_FUNCTION_ACCESS__INDEX, oldIndex, newIndex);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess#getIndex <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' containment reference.
	 * @see #getIndex()
	 * @generated
	 */
	public void setIndex(Expression newIndex) {
		if (newIndex != index) {
			NotificationChain msgs = null;
			if (index != null)
				msgs = ((InternalEObject) index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION_ACCESS__INDEX, null, msgs);
			if (newIndex != null)
				msgs = ((InternalEObject) newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION_ACCESS__INDEX, null, msgs);
			msgs = basicSetIndex(newIndex, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_FUNCTION_ACCESS__INDEX,
			                newIndex, newIndex));
	}

	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference.
	 * @see #setFunction(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunctionAccess_Function()
	 * @model containment="true"
	 * @generated
	 */
	public Expression getFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Expression newFunction, NotificationChain msgs) {
		Expression oldFunction = function;
		function = newFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION, oldFunction, newFunction);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess#getFunction <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' containment reference.
	 * @see #getFunction()
	 * @generated
	 */
	public void setFunction(Expression newFunction) {
		if (newFunction != function) {
			NotificationChain msgs = null;
			if (function != null)
				msgs = ((InternalEObject) function).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION, null, msgs);
			if (newFunction != null)
				msgs = ((InternalEObject) newFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION, null, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			                AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION, newFunction, newFunction));
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
			case AstPackage.ARRAY_FUNCTION_ACCESS__INDEX:
				return basicSetIndex(null, msgs);
			case AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION:
				return basicSetFunction(null, msgs);
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
			case AstPackage.ARRAY_FUNCTION_ACCESS__INDEX:
				return getIndex();
			case AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION:
				return getFunction();
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
			case AstPackage.ARRAY_FUNCTION_ACCESS__INDEX:
				setIndex((Expression) newValue);
				return;
			case AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION:
				setFunction((Expression) newValue);
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
			case AstPackage.ARRAY_FUNCTION_ACCESS__INDEX:
				setIndex((Expression) null);
				return;
			case AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION:
				setFunction((Expression) null);
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
			case AstPackage.ARRAY_FUNCTION_ACCESS__INDEX:
				return index != null;
			case AstPackage.ARRAY_FUNCTION_ACCESS__FUNCTION:
				return function != null;
		}
		return super.eIsSet(featureID);
	}

} // ArrayFunctionAccess
