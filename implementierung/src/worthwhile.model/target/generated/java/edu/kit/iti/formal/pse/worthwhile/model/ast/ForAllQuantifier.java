/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast;

import org.eclipse.emf.ecore.EClass;

import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>For All Quantifier</b></em>'. <!-- end-user-doc
 * -->
 * 
 * 
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getForAllQuantifier()
 * @model kind="class"
 * @generated
 */
public class ForAllQuantifier extends QuantifiedExpression {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ForAllQuantifier() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.FOR_ALL_QUANTIFIER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model visitorType="edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.IASTNodeVisitor" visitorRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visit(this);'"
	 * @generated
	 */
	@Override
	public void accept(IASTNodeVisitor visitor) {
		visitor.visit(this);
	}

} // ForAllQuantifier
