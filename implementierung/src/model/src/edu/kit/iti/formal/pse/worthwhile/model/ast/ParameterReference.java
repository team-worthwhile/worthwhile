/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ParameterReference#getParameter <em>Parameter</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ParameterReference#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see worthwhile.ast.AstPackage#getParameterReference()
 * @model
 * @generated
 */
public interface ParameterReference extends Expression {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Parameter)
	 * @see worthwhile.ast.AstPackage#getParameterReference_Parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ParameterReference#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' containment reference.
	 * @see #setIndex(Expression)
	 * @see worthwhile.ast.AstPackage#getParameterReference_Index()
	 * @model containment="true"
	 * @generated
	 */
	Expression getIndex();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ParameterReference#getIndex <em>Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' containment reference.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Expression value);

} // ParameterReference
