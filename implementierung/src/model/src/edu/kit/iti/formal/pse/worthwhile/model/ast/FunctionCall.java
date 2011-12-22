/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getActuals <em>Actuals</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends Expression {
	/**
	 * Returns the value of the '<em><b>Actuals</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actuals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actuals</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionCall_Actuals()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Expression> getActuals();

	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(FunctionDeclaration)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getFunctionCall_Function()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FunctionDeclaration getFunction();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionDeclaration value);

} // FunctionCall
