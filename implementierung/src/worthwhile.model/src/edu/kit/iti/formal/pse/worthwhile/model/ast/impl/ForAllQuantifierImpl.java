/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.impl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For All Quantifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ForAllQuantifierImpl extends QuantifiedExpressionImpl implements ForAllQuantifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForAllQuantifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.FOR_ALL_QUANTIFIER;
	}
	
	/**
	 * Accept a visitor to this ForAllQuantifier.
	 * 
	 * @param visitor
	 *                the visitor to be accepted
	 */
	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

} //ForAllQuantifierImpl
