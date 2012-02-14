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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Conditional</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getTrueBlock <em>True Block</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getFalseBlock <em>False Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional()
 * @model kind="class"
 * @generated
 */
public class Conditional extends Statement {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * The cached value of the '{@link #getTrueBlock() <em>True Block</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTrueBlock()
	 * @generated
	 * @ordered
	 */
	protected Block trueBlock;

	/**
	 * The cached value of the '{@link #getFalseBlock() <em>False Block</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFalseBlock()
	 * @generated
	 * @ordered
	 */
	protected Block falseBlock;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Conditional() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.CONDITIONAL;
	}

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional_Condition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.CONDITIONAL__CONDITION, oldCondition, newCondition);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.CONDITIONAL__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.CONDITIONAL__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__CONDITION,
			                newCondition, newCondition));
	}

	/**
	 * Returns the value of the '<em><b>True Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Block</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Block</em>' containment reference.
	 * @see #setTrueBlock(Block)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional_TrueBlock()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	public Block getTrueBlock() {
		return trueBlock;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrueBlock(Block newTrueBlock, NotificationChain msgs) {
		Block oldTrueBlock = trueBlock;
		trueBlock = newTrueBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.CONDITIONAL__TRUE_BLOCK, oldTrueBlock, newTrueBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getTrueBlock <em>True Block</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Block</em>' containment reference.
	 * @see #getTrueBlock()
	 * @generated
	 */
	public void setTrueBlock(Block newTrueBlock) {
		if (newTrueBlock != trueBlock) {
			NotificationChain msgs = null;
			if (trueBlock != null)
				msgs = ((InternalEObject) trueBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.CONDITIONAL__TRUE_BLOCK, null, msgs);
			if (newTrueBlock != null)
				msgs = ((InternalEObject) newTrueBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.CONDITIONAL__TRUE_BLOCK, null, msgs);
			msgs = basicSetTrueBlock(newTrueBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__TRUE_BLOCK,
			                newTrueBlock, newTrueBlock));
	}

	/**
	 * Returns the value of the '<em><b>False Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Block</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Block</em>' containment reference.
	 * @see #setFalseBlock(Block)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional_FalseBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	public Block getFalseBlock() {
		return falseBlock;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFalseBlock(Block newFalseBlock, NotificationChain msgs) {
		Block oldFalseBlock = falseBlock;
		falseBlock = newFalseBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
			                AstPackage.CONDITIONAL__FALSE_BLOCK, oldFalseBlock, newFalseBlock);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getFalseBlock <em>False Block</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Block</em>' containment reference.
	 * @see #getFalseBlock()
	 * @generated
	 */
	public void setFalseBlock(Block newFalseBlock) {
		if (newFalseBlock != falseBlock) {
			NotificationChain msgs = null;
			if (falseBlock != null)
				msgs = ((InternalEObject) falseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.CONDITIONAL__FALSE_BLOCK, null, msgs);
			if (newFalseBlock != null)
				msgs = ((InternalEObject) newFalseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
				                - AstPackage.CONDITIONAL__FALSE_BLOCK, null, msgs);
			msgs = basicSetFalseBlock(newFalseBlock, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__FALSE_BLOCK,
			                newFalseBlock, newFalseBlock));
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
			case AstPackage.CONDITIONAL__CONDITION:
				return basicSetCondition(null, msgs);
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				return basicSetTrueBlock(null, msgs);
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				return basicSetFalseBlock(null, msgs);
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
			case AstPackage.CONDITIONAL__CONDITION:
				return getCondition();
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				return getTrueBlock();
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				return getFalseBlock();
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
			case AstPackage.CONDITIONAL__CONDITION:
				setCondition((Expression) newValue);
				return;
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				setTrueBlock((Block) newValue);
				return;
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				setFalseBlock((Block) newValue);
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
			case AstPackage.CONDITIONAL__CONDITION:
				setCondition((Expression) null);
				return;
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				setTrueBlock((Block) null);
				return;
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				setFalseBlock((Block) null);
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
			case AstPackage.CONDITIONAL__CONDITION:
				return condition != null;
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				return trueBlock != null;
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				return falseBlock != null;
		}
		return super.eIsSet(featureID);
	}

} // Conditional
