/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.impl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sign</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class SignImpl extends UnaryExpressionImpl implements Sign {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SignImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.SIGN;
	}

    public void accept(ASTNodeVisitor visitor) {
        visitor.visit(this);
    }
} //SignImpl
