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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Program</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getFunctionDeclarations <em>Function Declarations</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock <em>Main Block</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getAxioms <em>Axioms</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram()
 * @model kind="class"
 * @generated
 */
public class Program extends ASTNode {
	/**
	 * The cached value of the '{@link #getFunctionDeclarations() <em>Function Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFunctionDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionDeclaration> functionDeclarations;

	/**
	 * The cached value of the '{@link #getMainBlock() <em>Main Block</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMainBlock()
	 * @generated
	 * @ordered
	 */
	protected Block mainBlock;

	/**
	 * The cached value of the '{@link #getAxioms() <em>Axioms</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAxioms()
	 * @generated
	 * @ordered
	 */
	protected EList<Axiom> axioms;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Program() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.PROGRAM;
	}

	/**
	 * Returns the value of the '<em><b>Function Declarations</b></em>' containment reference list. The list
	 * contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Declarations</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Function Declarations</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram_FunctionDeclarations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public EList<FunctionDeclaration> getFunctionDeclarations() {
		if (functionDeclarations == null) {
			functionDeclarations = new EObjectContainmentEList<FunctionDeclaration>(
			                FunctionDeclaration.class, this, AstPackage.PROGRAM__FUNCTION_DECLARATIONS);
		}
		return functionDeclarations;
	}

	/**
	 * Returns the value of the '<em><b>Main Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Block</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Block</em>' containment reference.
	 * @see #setMainBlock(Block)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram_MainBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public Block getMainBlock() {
		return mainBlock;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMainBlock(Block newMainBlock, NotificationChain msgs) {
		Block oldMainBlock = mainBlock;
		mainBlock = newMainBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.PROGRAM__MAIN_BLOCK, oldMainBlock, newMainBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock <em>Main Block</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Block</em>' containment reference.
	 * @see #getMainBlock()
	 * @generated
	 */
	public void setMainBlock(Block newMainBlock) {
		if (newMainBlock != mainBlock) {
			NotificationChain msgs = null;
			if (mainBlock != null)
				msgs = ((InternalEObject) mainBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.PROGRAM__MAIN_BLOCK, null, msgs);
			if (newMainBlock != null)
				msgs = ((InternalEObject) newMainBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.PROGRAM__MAIN_BLOCK, null, msgs);
			msgs = basicSetMainBlock(newMainBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.PROGRAM__MAIN_BLOCK,
			                newMainBlock, newMainBlock));
	}

	/**
	 * Returns the value of the '<em><b>Axioms</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axioms</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axioms</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram_Axioms()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public EList<Axiom> getAxioms() {
		if (axioms == null) {
			axioms = new EObjectContainmentEList<Axiom>(Axiom.class, this, AstPackage.PROGRAM__AXIOMS);
		}
		return axioms;
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
			case AstPackage.PROGRAM__FUNCTION_DECLARATIONS:
				return ((InternalEList<?>) getFunctionDeclarations()).basicRemove(otherEnd, msgs);
			case AstPackage.PROGRAM__MAIN_BLOCK:
				return basicSetMainBlock(null, msgs);
			case AstPackage.PROGRAM__AXIOMS:
				return ((InternalEList<?>) getAxioms()).basicRemove(otherEnd, msgs);
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
			case AstPackage.PROGRAM__FUNCTION_DECLARATIONS:
				return getFunctionDeclarations();
			case AstPackage.PROGRAM__MAIN_BLOCK:
				return getMainBlock();
			case AstPackage.PROGRAM__AXIOMS:
				return getAxioms();
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
			case AstPackage.PROGRAM__FUNCTION_DECLARATIONS:
				getFunctionDeclarations().clear();
				getFunctionDeclarations().addAll((Collection<? extends FunctionDeclaration>) newValue);
				return;
			case AstPackage.PROGRAM__MAIN_BLOCK:
				setMainBlock((Block) newValue);
				return;
			case AstPackage.PROGRAM__AXIOMS:
				getAxioms().clear();
				getAxioms().addAll((Collection<? extends Axiom>) newValue);
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
			case AstPackage.PROGRAM__FUNCTION_DECLARATIONS:
				getFunctionDeclarations().clear();
				return;
			case AstPackage.PROGRAM__MAIN_BLOCK:
				setMainBlock((Block) null);
				return;
			case AstPackage.PROGRAM__AXIOMS:
				getAxioms().clear();
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
			case AstPackage.PROGRAM__FUNCTION_DECLARATIONS:
				return functionDeclarations != null && !functionDeclarations.isEmpty();
			case AstPackage.PROGRAM__MAIN_BLOCK:
				return mainBlock != null;
			case AstPackage.PROGRAM__AXIOMS:
				return axioms != null && !axioms.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // Program
