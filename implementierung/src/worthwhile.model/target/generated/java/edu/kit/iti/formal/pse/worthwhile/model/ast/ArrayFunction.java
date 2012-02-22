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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Array Function</b></em>'. <!-- end-user-doc -->
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
	 * The cached value of the '{@link #getChainedFunction() <em>Chained Function</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChainedFunction()
	 * @generated
	 * @ordered
	 */
	protected Expression chainedFunction;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected Expression index;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Expression value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayFunction() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.ARRAY_FUNCTION;
	}

	/**
	 * Returns the value of the '<em><b>Chained Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chained Function</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chained Function</em>' reference.
	 * @see #setChainedFunction(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction_ChainedFunction()
	 * @model
	 * @generated
	 */
	public Expression getChainedFunction() {
		if (chainedFunction != null && chainedFunction.eIsProxy()) {
			InternalEObject oldChainedFunction = (InternalEObject) chainedFunction;
			chainedFunction = (Expression) eResolveProxy(oldChainedFunction);
			if (chainedFunction != oldChainedFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					                AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION,
					                oldChainedFunction, chainedFunction));
			}
		}
		return chainedFunction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetChainedFunction() {
		return chainedFunction;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getChainedFunction <em>Chained Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chained Function</em>' reference.
	 * @see #getChainedFunction()
	 * @generated
	 */
	public void setChainedFunction(Expression newChainedFunction) {
		Expression oldChainedFunction = chainedFunction;
		chainedFunction = newChainedFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			                AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION, oldChainedFunction,
			                chainedFunction));
	}

	/**
	 * Returns the value of the '<em><b>Index</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' reference.
	 * @see #setIndex(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction_Index()
	 * @model
	 * @generated
	 */
	public Expression getIndex() {
		if (index != null && index.eIsProxy()) {
			InternalEObject oldIndex = (InternalEObject) index;
			index = (Expression) eResolveProxy(oldIndex);
			if (index != oldIndex) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					                AstPackage.ARRAY_FUNCTION__INDEX, oldIndex, index));
			}
		}
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetIndex() {
		return index;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getIndex <em>Index</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' reference.
	 * @see #getIndex()
	 * @generated
	 */
	public void setIndex(Expression newIndex) {
		Expression oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_FUNCTION__INDEX,
			                oldIndex, index));
	}

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayFunction_Value()
	 * @model
	 * @generated
	 */
	public Expression getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject) value;
			value = (Expression) eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					                AstPackage.ARRAY_FUNCTION__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetValue() {
		return value;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	public void setValue(Expression newValue) {
		Expression oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_FUNCTION__VALUE,
			                oldValue, value));
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.ARRAY_FUNCTION__CHAINED_FUNCTION:
				if (resolve)
					return getChainedFunction();
				return basicGetChainedFunction();
			case AstPackage.ARRAY_FUNCTION__INDEX:
				if (resolve)
					return getIndex();
				return basicGetIndex();
			case AstPackage.ARRAY_FUNCTION__VALUE:
				if (resolve)
					return getValue();
				return basicGetValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
