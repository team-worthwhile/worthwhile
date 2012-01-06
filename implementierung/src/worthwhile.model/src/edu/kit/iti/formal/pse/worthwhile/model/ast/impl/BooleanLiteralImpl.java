/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;

/**
 * A literal representin a Boolean value
 */
public class BooleanLiteralImpl extends LiteralImpl implements BooleanLiteral {
	/**
	 * Default value of the literal
	 */
	protected static final boolean VALUE_EDEFAULT = false;

	protected boolean value = VALUE_EDEFAULT;

	protected BooleanLiteralImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.BOOLEAN_LITERAL;
	}

	@Override
	public boolean getValue() {
		return this.value;
	}

	@Override
	public void setValue(boolean newValue) {
		boolean oldValue = this.value;
		this.value = newValue;
		if (this.eNotificationRequired())
			this.eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.BOOLEAN_LITERAL__VALUE, oldValue, this.value));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AstPackage.BOOLEAN_LITERAL__VALUE:
			return this.getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case AstPackage.BOOLEAN_LITERAL__VALUE:
			this.setValue((Boolean)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case AstPackage.BOOLEAN_LITERAL__VALUE:
			this.setValue(VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case AstPackage.BOOLEAN_LITERAL__VALUE:
			return this.value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		if (this.eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(this.value);
		result.append(')');
		return result.toString();
	}

} //BooleanLiteralImpl
