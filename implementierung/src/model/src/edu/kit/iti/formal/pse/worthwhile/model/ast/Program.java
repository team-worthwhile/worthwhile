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
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getFunctionDeclarations <em>Function Declarations</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock <em>Main Block</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getAxioms <em>Axioms</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends ASTNode {
	/**
	 * Returns the value of the '<em><b>Function Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Declarations</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram_FunctionDeclarations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FunctionDeclaration> getFunctionDeclarations();

	/**
	 * Returns the value of the '<em><b>Main Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Block</em>' containment reference.
	 * @see #setMainBlock(Block)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram_MainBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Block getMainBlock();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program#getMainBlock <em>Main Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Block</em>' containment reference.
	 * @see #getMainBlock()
	 * @generated
	 */
	void setMainBlock(Block value);

	/**
	 * Returns the value of the '<em><b>Axioms</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axioms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axioms</em>' containment reference list.
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getProgram_Axioms()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Axiom> getAxioms();

} // Program
