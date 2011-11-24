/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.ReturnStatement#getReturnExpr <em>Return Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getReturnStatement()
 * @model
 * @generated
 */
public interface ReturnStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Return Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Expr</em>' containment reference.
   * @see #setReturnExpr(Expr)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getReturnStatement_ReturnExpr()
   * @model containment="true"
   * @generated
   */
  Expr getReturnExpr();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.ReturnStatement#getReturnExpr <em>Return Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Expr</em>' containment reference.
   * @see #getReturnExpr()
   * @generated
   */
  void setReturnExpr(Expr value);

} // ReturnStatement
