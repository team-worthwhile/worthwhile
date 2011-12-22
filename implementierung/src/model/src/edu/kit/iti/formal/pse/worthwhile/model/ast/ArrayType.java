/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends Type {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Type</em>' containment reference.
	 * @see #setBaseType(PrimitiveType)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayType_BaseType()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PrimitiveType getBaseType();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getBaseType <em>Base Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Type</em>' containment reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getArrayType_Size()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getSize();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Expression value);

} // ArrayType
