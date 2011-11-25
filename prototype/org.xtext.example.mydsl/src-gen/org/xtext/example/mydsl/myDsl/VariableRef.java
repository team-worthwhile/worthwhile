/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.VariableRef#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getVariableRef()
 * @model
 * @generated
 */
public interface VariableRef extends Expression
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
   * @see #setSymbol(Variable)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getVariableRef_Symbol()
   * @model
   * @generated
   */
  Variable getSymbol();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.VariableRef#getSymbol <em>Symbol</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Symbol</em>' reference.
   * @see #getSymbol()
   * @generated
   */
  void setSymbol(Variable value);

} // VariableRef
