/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variable Reference</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getVariable <em>Variable</em>}</li>
 * <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 * 
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getVariableReference()
 * @model kind="class"
 * @generated
 */
public class VariableReference extends SymbolReference {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration variable;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableReference() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.VARIABLE_REFERENCE;
	}

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(VariableDeclaration)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getVariableReference_Variable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	public VariableDeclaration getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject) variable;
			variable = (VariableDeclaration) eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					                AstPackage.VARIABLE_REFERENCE__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetVariable() {
		return variable;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	public void setVariable(VariableDeclaration newVariable) {
		VariableDeclaration oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.VARIABLE_REFERENCE__VARIABLE,
			                oldVariable, variable));
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.VARIABLE_REFERENCE__VARIABLE:
				if (resolve)
					return getVariable();
				return basicGetVariable();
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
			case AstPackage.VARIABLE_REFERENCE__VARIABLE:
				setVariable((VariableDeclaration) newValue);
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
			case AstPackage.VARIABLE_REFERENCE__VARIABLE:
				setVariable((VariableDeclaration) null);
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
			case AstPackage.VARIABLE_REFERENCE__VARIABLE:
				return variable != null;
		}
		return super.eIsSet(featureID);
	}

} // VariableReference
