/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.impl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConditionalImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConditionalImpl#getTrueBlock <em>True Block</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ConditionalImpl#getFalseBlock <em>False Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalImpl extends StatementImpl implements Conditional {
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
	 * The cached value of the '{@link #getTrueBlock() <em>True Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueBlock()
	 * @generated
	 * @ordered
	 */
	protected Block trueBlock;

	/**
	 * The cached value of the '{@link #getFalseBlock() <em>False Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseBlock()
	 * @generated
	 * @ordered
	 */
	protected Block falseBlock;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.CONDITIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getTrueBlock() {
		return trueBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrueBlock(Block newTrueBlock, NotificationChain msgs) {
		Block oldTrueBlock = trueBlock;
		trueBlock = newTrueBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__TRUE_BLOCK, oldTrueBlock, newTrueBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueBlock(Block newTrueBlock) {
		if (newTrueBlock != trueBlock) {
			NotificationChain msgs = null;
			if (trueBlock != null)
				msgs = ((InternalEObject)trueBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL__TRUE_BLOCK, null, msgs);
			if (newTrueBlock != null)
				msgs = ((InternalEObject)newTrueBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL__TRUE_BLOCK, null, msgs);
			msgs = basicSetTrueBlock(newTrueBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__TRUE_BLOCK, newTrueBlock, newTrueBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getFalseBlock() {
		return falseBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFalseBlock(Block newFalseBlock, NotificationChain msgs) {
		Block oldFalseBlock = falseBlock;
		falseBlock = newFalseBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__FALSE_BLOCK, oldFalseBlock, newFalseBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseBlock(Block newFalseBlock) {
		if (newFalseBlock != falseBlock) {
			NotificationChain msgs = null;
			if (falseBlock != null)
				msgs = ((InternalEObject)falseBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL__FALSE_BLOCK, null, msgs);
			if (newFalseBlock != null)
				msgs = ((InternalEObject)newFalseBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL__FALSE_BLOCK, null, msgs);
			msgs = basicSetFalseBlock(newFalseBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL__FALSE_BLOCK, newFalseBlock, newFalseBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.CONDITIONAL__CONDITION:
				setCondition((Expression)newValue);
				return;
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				setTrueBlock((Block)newValue);
				return;
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				setFalseBlock((Block)newValue);
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
			case AstPackage.CONDITIONAL__CONDITION:
				setCondition((Expression)null);
				return;
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				setTrueBlock((Block)null);
				return;
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				setFalseBlock((Block)null);
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
			case AstPackage.CONDITIONAL__CONDITION:
				return condition != null;
			case AstPackage.CONDITIONAL__TRUE_BLOCK:
				return trueBlock != null;
			case AstPackage.CONDITIONAL__FALSE_BLOCK:
				return falseBlock != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * Accept a visitor to this Conditional.
	 * 
	 * @param visitor
	 *                the visitor to be accepted
	 */
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

} //ConditionalImpl
