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
 * A representation of the model object '<em><b>Array Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getChainedFunction <em>Chained Function</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getIndex <em>Index</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction()
 * @model kind="class"
 * @generated
 */
public class ArrayFunction extends Literal {
	/**
	 * The cached value of the '{@link #getChainedFunction() <em>Chained Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChainedFunction()
	 * @generated
	 * @ordered
	 */
	protected Expression chainedFunction;

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
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Expression value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayFunction() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.ARRAY_FUNCTION;
	}

	/**
	 * Returns the value of the '<em><b>Chained Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chained Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chained Function</em>' containment reference.
	 * @see #setChainedFunction(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction_ChainedFunction()
	 * @model containment="true"
	 * @generated
	 */
	public Expression getChainedFunction() {
		return chainedFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChainedFunction(Expression newChainedFunction, NotificationChain msgs) {
		Expression oldChainedFunction = chainedFunction;
		chainedFunction = newChainedFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION, oldChainedFunction,
			                newChainedFunction);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getChainedFunction <em>Chained Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chained Function</em>' containment reference.
	 * @see #getChainedFunction()
	 * @generated
	 */
	public void setChainedFunction(Expression newChainedFunction) {
		if (newChainedFunction != chainedFunction) {
			NotificationChain msgs = null;
			if (chainedFunction != null)
				msgs = ((InternalEObject) chainedFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION, null, msgs);
			if (newChainedFunction != null)
				msgs = ((InternalEObject) newChainedFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION, null, msgs);
			msgs = basicSetChainedFunction(newChainedFunction, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			                AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION, newChainedFunction,
			                newChainedFunction));
	}

	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' containment reference.
	 * @see #setIndex(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction_Index()
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
			                AstPackage.ARRAY_FUNCTION__INDEX, oldIndex, newIndex);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getIndex <em>Index</em>}' containment reference.
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
				                - AstPackage.ARRAY_FUNCTION__INDEX, null, msgs);
			if (newIndex != null)
				msgs = ((InternalEObject) newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION__INDEX, null, msgs);
			msgs = basicSetIndex(newIndex, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_FUNCTION__INDEX,
			                newIndex, newIndex));
	}

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction_Value()
	 * @model containment="true"
	 * @generated
	 */
	public Expression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Expression newValue, NotificationChain msgs) {
		Expression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.ARRAY_FUNCTION__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	public void setValue(Expression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.ARRAY_FUNCTION__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_FUNCTION__VALUE,
			                newValue, newValue));
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
			case AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION:
				return basicSetChainedFunction(null, msgs);
			case AstPackage.ARRAY_FUNCTION__INDEX:
				return basicSetIndex(null, msgs);
			case AstPackage.ARRAY_FUNCTION__VALUE:
				return basicSetValue(null, msgs);
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
			case AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION:
				return getChainedFunction();
			case AstPackage.ARRAY_FUNCTION__INDEX:
				return getIndex();
			case AstPackage.ARRAY_FUNCTION__VALUE:
				return getValue();
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
			case AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION:
				setChainedFunction((Expression) newValue);
				return;
			case AstPackage.ARRAY_FUNCTION__INDEX:
				setIndex((Expression) newValue);
				return;
			case AstPackage.ARRAY_FUNCTION__VALUE:
				setValue((Expression) newValue);
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
			case AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION:
				setChainedFunction((Expression) null);
				return;
			case AstPackage.ARRAY_FUNCTION__INDEX:
				setIndex((Expression) null);
				return;
			case AstPackage.ARRAY_FUNCTION__VALUE:
				setValue((Expression) null);
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
			case AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION:
				return chainedFunction != null;
			case AstPackage.ARRAY_FUNCTION__INDEX:
				return index != null;
			case AstPackage.ARRAY_FUNCTION__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} // ArrayFunction
