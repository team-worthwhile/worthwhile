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
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getReturnValueReference()
 * @model kind="class"
 * @generated
 */
public class ReturnValueReference extends SymbolReference {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model visitorType="edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor" visitorRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visit(this);'"
	 * @generated
	 */
	@Override
	public void accept(IASTNodeVisitor visitor) {
		visitor.visit(this);
	}

} // ReturnValueReference
