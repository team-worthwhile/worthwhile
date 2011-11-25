/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.FunctionRef#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.FunctionRef#getActuals <em>Actuals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getFunctionRef()
 * @model
 * @generated
 */
public interface FunctionRef extends FunctionCall
{
  /**
   * Returns the value of the '<em><b>Symbol</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Symbol</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Symbol</em>' reference.
   * @see #setSymbol(Function)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getFunctionRef_Symbol()
   * @model
   * @generated
   */
  Function getSymbol();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.FunctionRef#getSymbol <em>Symbol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Symbol</em>' reference.
   * @see #getSymbol()
   * @generated
   */
  void setSymbol(Function value);

  /**
   * Returns the value of the '<em><b>Actuals</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actuals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actuals</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getFunctionRef_Actuals()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getActuals();

} // FunctionRef
