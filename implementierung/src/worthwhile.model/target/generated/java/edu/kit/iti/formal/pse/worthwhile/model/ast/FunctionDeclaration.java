/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Function Declaration</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getBody <em>Body</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration()
 * @model kind="class"
 * @generated
 */
public class FunctionDeclaration extends ASTNode {
	/**
	 * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPreconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Precondition> preconditions;

	/**
	 * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPostconditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Postcondition> postconditions;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> parameters;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Block body;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected Type returnType;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionDeclaration() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.FUNCTION_DECLARATION;
	}

	/**
	 * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preconditions</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration_Preconditions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public EList<Precondition> getPreconditions() {
		if (preconditions == null) {
			preconditions = new EObjectContainmentEList<Precondition>(Precondition.class, this,
			                AstPackage.FUNCTION_DECLARATION__PRECONDITIONS);
		}
		return preconditions;
	}

	/**
	 * Returns the value of the '<em><b>Postconditions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postconditions</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration_Postconditions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public EList<Postcondition> getPostconditions() {
		if (postconditions == null) {
			postconditions = new EObjectContainmentEList<Postcondition>(Postcondition.class, this,
			                AstPackage.FUNCTION_DECLARATION__POSTCONDITIONS);
		}
		return postconditions;
	}

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration_Parameters()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public EList<VariableDeclaration> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this,
			                AstPackage.FUNCTION_DECLARATION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration_Body()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public Block getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Block newBody, NotificationChain msgs) {
		Block oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.FUNCTION_DECLARATION__BODY, oldBody, newBody);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	public void setBody(Block newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject) body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.FUNCTION_DECLARATION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject) newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.FUNCTION_DECLARATION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DECLARATION__BODY,
			                newBody, newBody));
	}

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(Type)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration_ReturnType()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public Type getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(Type newReturnType, NotificationChain msgs) {
		Type oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.FUNCTION_DECLARATION__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	public void setReturnType(Type newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject) returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.FUNCTION_DECLARATION__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject) newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.FUNCTION_DECLARATION__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			                AstPackage.FUNCTION_DECLARATION__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionDeclaration_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FUNCTION_DECLARATION__NAME,
			                oldName, name));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.FUNCTION_DECLARATION__PRECONDITIONS:
				return ((InternalEList<?>) getPreconditions()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DECLARATION__POSTCONDITIONS:
				return ((InternalEList<?>) getPostconditions()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DECLARATION__PARAMETERS:
				return ((InternalEList<?>) getParameters()).basicRemove(otherEnd, msgs);
			case AstPackage.FUNCTION_DECLARATION__BODY:
				return basicSetBody(null, msgs);
			case AstPackage.FUNCTION_DECLARATION__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.FUNCTION_DECLARATION__PRECONDITIONS:
				return getPreconditions();
			case AstPackage.FUNCTION_DECLARATION__POSTCONDITIONS:
				return getPostconditions();
			case AstPackage.FUNCTION_DECLARATION__PARAMETERS:
				return getParameters();
			case AstPackage.FUNCTION_DECLARATION__BODY:
				return getBody();
			case AstPackage.FUNCTION_DECLARATION__RETURN_TYPE:
				return getReturnType();
			case AstPackage.FUNCTION_DECLARATION__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.FUNCTION_DECLARATION__PRECONDITIONS:
				getPreconditions().clear();
				getPreconditions().addAll((Collection<? extends Precondition>) newValue);
				return;
			case AstPackage.FUNCTION_DECLARATION__POSTCONDITIONS:
				getPostconditions().clear();
				getPostconditions().addAll((Collection<? extends Postcondition>) newValue);
				return;
			case AstPackage.FUNCTION_DECLARATION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends VariableDeclaration>) newValue);
				return;
			case AstPackage.FUNCTION_DECLARATION__BODY:
				setBody((Block) newValue);
				return;
			case AstPackage.FUNCTION_DECLARATION__RETURN_TYPE:
				setReturnType((Type) newValue);
				return;
			case AstPackage.FUNCTION_DECLARATION__NAME:
				setName((String) newValue);
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
			case AstPackage.FUNCTION_DECLARATION__PRECONDITIONS:
				getPreconditions().clear();
				return;
			case AstPackage.FUNCTION_DECLARATION__POSTCONDITIONS:
				getPostconditions().clear();
				return;
			case AstPackage.FUNCTION_DECLARATION__PARAMETERS:
				getParameters().clear();
				return;
			case AstPackage.FUNCTION_DECLARATION__BODY:
				setBody((Block) null);
				return;
			case AstPackage.FUNCTION_DECLARATION__RETURN_TYPE:
				setReturnType((Type) null);
				return;
			case AstPackage.FUNCTION_DECLARATION__NAME:
				setName(NAME_EDEFAULT);
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
			case AstPackage.FUNCTION_DECLARATION__PRECONDITIONS:
				return preconditions != null && !preconditions.isEmpty();
			case AstPackage.FUNCTION_DECLARATION__POSTCONDITIONS:
				return postconditions != null && !postconditions.isEmpty();
			case AstPackage.FUNCTION_DECLARATION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case AstPackage.FUNCTION_DECLARATION__BODY:
				return body != null;
			case AstPackage.FUNCTION_DECLARATION__RETURN_TYPE:
				return returnType != null;
			case AstPackage.FUNCTION_DECLARATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // FunctionDeclaration
