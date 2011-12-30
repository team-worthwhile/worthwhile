/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.impl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;

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

    public void accept(ASTNodeVisitor visitor) {
        visitor.visit(this);
    }
} //ForAllQuantifierImpl
