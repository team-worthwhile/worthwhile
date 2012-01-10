/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.impl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Minus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MinusImpl extends SignImpl implements Minus {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MinusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.MINUS;
	}
	
	/**
	 * Accept a visitor to this Minus.
	 * 
	 * @param visitor
	 *                the visitor to be accepted
	 */
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

} //MinusImpl
