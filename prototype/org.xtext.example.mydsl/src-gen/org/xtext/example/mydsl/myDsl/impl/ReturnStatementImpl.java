/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.example.mydsl.myDsl.Expr;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.ReturnStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Return Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.ReturnStatementImpl#getReturnExpr <em>Return Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReturnStatementImpl extends StatementImpl implements ReturnStatement
{
  /**
   * The cached value of the '{@link #getReturnExpr() <em>Return Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnExpr()
   * @generated
   * @ordered
   */
  protected Expr returnExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReturnStatementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.RETURN_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getReturnExpr()
  {
    return returnExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnExpr(Expr newReturnExpr, NotificationChain msgs)
  {
    Expr oldReturnExpr = returnExpr;
    returnExpr = newReturnExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.RETURN_STATEMENT__RETURN_EXPR, oldReturnExpr, newReturnExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnExpr(Expr newReturnExpr)
  {
    if (newReturnExpr != returnExpr)
    {
      NotificationChain msgs = null;
      if (returnExpr != null)
        msgs = ((InternalEObject)returnExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.RETURN_STATEMENT__RETURN_EXPR, null, msgs);
      if (newReturnExpr != null)
        msgs = ((InternalEObject)newReturnExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.RETURN_STATEMENT__RETURN_EXPR, null, msgs);
      msgs = basicSetReturnExpr(newReturnExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.RETURN_STATEMENT__RETURN_EXPR, newReturnExpr, newReturnExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.RETURN_STATEMENT__RETURN_EXPR:
        return basicSetReturnExpr(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.RETURN_STATEMENT__RETURN_EXPR:
        return getReturnExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.RETURN_STATEMENT__RETURN_EXPR:
        setReturnExpr((Expr)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.RETURN_STATEMENT__RETURN_EXPR:
        setReturnExpr((Expr)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.RETURN_STATEMENT__RETURN_EXPR:
        return returnExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //ReturnStatementImpl
