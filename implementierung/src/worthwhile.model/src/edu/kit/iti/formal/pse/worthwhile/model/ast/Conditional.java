/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional</b></em>'.
 * <!-- end-user-doc -->
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
 * @model
 * @generated
 */
public interface Conditional extends Statement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional_Condition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>True Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Block</em>' containment reference.
	 * @see #setTrueBlock(Block)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional_TrueBlock()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Block getTrueBlock();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getTrueBlock <em>True Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Block</em>' containment reference.
	 * @see #getTrueBlock()
	 * @generated
	 */
	void setTrueBlock(Block value);

	/**
	 * Returns the value of the '<em><b>False Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Block</em>' containment reference.
	 * @see #setFalseBlock(Block)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getConditional_FalseBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Block getFalseBlock();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional#getFalseBlock <em>False Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Block</em>' containment reference.
	 * @see #getFalseBlock()
	 * @generated
	 */
	void setFalseBlock(Block value);

} // Conditional
