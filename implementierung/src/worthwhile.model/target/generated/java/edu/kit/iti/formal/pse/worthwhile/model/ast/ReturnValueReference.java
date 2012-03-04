/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Return Value Reference</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getReturnValueReference()
 * @model kind="class"
 * @generated
 */
public class ReturnValueReference extends SymbolReference {
	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected FunctionDeclaration function;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReturnValueReference() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.RETURN_VALUE_REFERENCE;
	}

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(FunctionDeclaration)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getReturnValueReference_Function()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	public FunctionDeclaration getFunction() {
		if (function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject) function;
			function = (FunctionDeclaration) eResolveProxy(oldFunction);
			if (function != oldFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					                AstPackage.RETURN_VALUE_REFERENCE__FUNCTION, oldFunction,
					                function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration basicGetFunction() {
		return function;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	public void setFunction(FunctionDeclaration newFunction) {
		FunctionDeclaration oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			                AstPackage.RETURN_VALUE_REFERENCE__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model visitorType="edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor" visitorRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visit(this);'"
	 * @generated
	 */
	@Override
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
			case AstPackage.RETURN_VALUE_REFERENCE__FUNCTION:
				if (resolve)
					return getFunction();
				return basicGetFunction();
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
			case AstPackage.RETURN_VALUE_REFERENCE__FUNCTION:
				setFunction((FunctionDeclaration) newValue);
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
			case AstPackage.RETURN_VALUE_REFERENCE__FUNCTION:
				setFunction((FunctionDeclaration) null);
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
			case AstPackage.RETURN_VALUE_REFERENCE__FUNCTION:
				return function != null;
		}
		return super.eIsSet(featureID);
	}

} // ReturnValueReference
