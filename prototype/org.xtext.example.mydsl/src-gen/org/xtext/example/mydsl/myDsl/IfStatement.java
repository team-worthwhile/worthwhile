/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.IfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.IfStatement#getThen <em>Then</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.IfStatement#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expr)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getIfStatement_Condition()
   * @model containment="true"
   * @generated
   */
  Expr getCondition();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.IfStatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expr value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(Block)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getIfStatement_Then()
   * @model containment="true"
   * @generated
   */
  Block getThen();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.IfStatement#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Block value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Block)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getIfStatement_Else()
   * @model containment="true"
   * @generated
   */
  Block getElse();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.IfStatement#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Block value);

} // IfStatement
