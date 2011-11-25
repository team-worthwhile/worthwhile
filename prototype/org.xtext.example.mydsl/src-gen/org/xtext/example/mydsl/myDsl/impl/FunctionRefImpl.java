/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.myDsl.Expr;
import org.xtext.example.mydsl.myDsl.Function;
import org.xtext.example.mydsl.myDsl.FunctionRef;
import org.xtext.example.mydsl.myDsl.MyDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.FunctionRefImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.FunctionRefImpl#getActuals <em>Actuals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionRefImpl extends FunctionCallImpl implements FunctionRef
{
  /**
   * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSymbol()
   * @generated
   * @ordered
   */
  protected Function symbol;

  /**
   * The cached value of the '{@link #getActuals() <em>Actuals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActuals()
   * @generated
   * @ordered
   */
  protected EList<Expr> actuals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionRefImpl()
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
    return MyDslPackage.Literals.FUNCTION_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function getSymbol()
  {
    if (symbol != null && symbol.eIsProxy())
    {
      InternalEObject oldSymbol = (InternalEObject)symbol;
      symbol = (Function)eResolveProxy(oldSymbol);
      if (symbol != oldSymbol)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MyDslPackage.FUNCTION_REF__SYMBOL, oldSymbol, symbol));
      }
    }
    return symbol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function basicGetSymbol()
  {
    return symbol;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSymbol(Function newSymbol)
  {
    Function oldSymbol = symbol;
    symbol = newSymbol;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.FUNCTION_REF__SYMBOL, oldSymbol, symbol));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expr> getActuals()
  {
    if (actuals == null)
    {
      actuals = new EObjectContainmentEList<Expr>(Expr.class, this, MyDslPackage.FUNCTION_REF__ACTUALS);
    }
    return actuals;
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
      case MyDslPackage.FUNCTION_REF__ACTUALS:
        return ((InternalEList<?>)getActuals()).basicRemove(otherEnd, msgs);
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
      case MyDslPackage.FUNCTION_REF__SYMBOL:
        if (resolve) return getSymbol();
        return basicGetSymbol();
      case MyDslPackage.FUNCTION_REF__ACTUALS:
        return getActuals();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.FUNCTION_REF__SYMBOL:
        setSymbol((Function)newValue);
        return;
      case MyDslPackage.FUNCTION_REF__ACTUALS:
        getActuals().clear();
        getActuals().addAll((Collection<? extends Expr>)newValue);
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
      case MyDslPackage.FUNCTION_REF__SYMBOL:
        setSymbol((Function)null);
        return;
      case MyDslPackage.FUNCTION_REF__ACTUALS:
        getActuals().clear();
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
      case MyDslPackage.FUNCTION_REF__SYMBOL:
        return symbol != null;
      case MyDslPackage.FUNCTION_REF__ACTUALS:
        return actuals != null && !actuals.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionRefImpl
