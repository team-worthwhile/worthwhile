/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import org.eclipse.emf.ecore.EObject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AST Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getPositionInLine <em>Position In Line</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNode()
 * @model abstract="true"
 * @generated
 */
public interface ASTNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNode_LineNumber()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Position In Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position In Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position In Line</em>' attribute.
	 * @see #setPositionInLine(int)
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNode_PositionInLine()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getPositionInLine();

	/**
	 * Sets the value of the '{@link edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode#getPositionInLine <em>Position In Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position In Line</em>' attribute.
	 * @see #getPositionInLine()
	 * @generated
	 */
	void setPositionInLine(int value);

	/**
	 * Accept a visitor and call its corresponding visit method
	 * 
	 * @param visitor the visitor to accept
	 */
	void accept(ASTNodeVisitor visitor);

} // ASTNode
