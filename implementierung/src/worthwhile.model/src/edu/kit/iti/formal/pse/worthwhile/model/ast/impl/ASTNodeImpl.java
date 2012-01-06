/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AST Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ASTNodeImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link edu.kit.iti.formal.pse.worthwhile.model.ast.impl.ASTNodeImpl#getPositionInLine <em>Position In Line</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ASTNodeImpl extends EObjectImpl implements ASTNode {
	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPositionInLine() <em>Position In Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionInLine()
	 * @generated
	 * @ordered
	 */
	protected static final int POSITION_IN_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPositionInLine() <em>Position In Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPositionInLine()
	 * @generated
	 * @ordered
	 */
	protected int positionInLine = POSITION_IN_LINE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ASTNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.AST_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return this.lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = this.lineNumber;
		this.lineNumber = newLineNumber;
		if (this.eNotificationRequired())
			this.eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.AST_NODE__LINE_NUMBER, oldLineNumber, this.lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPositionInLine() {
		return this.positionInLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPositionInLine(int newPositionInLine) {
		int oldPositionInLine = this.positionInLine;
		this.positionInLine = newPositionInLine;
		if (this.eNotificationRequired())
			this.eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.AST_NODE__POSITION_IN_LINE, oldPositionInLine, this.positionInLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.AST_NODE__LINE_NUMBER:
				return this.getLineNumber();
			case AstPackage.AST_NODE__POSITION_IN_LINE:
				return this.getPositionInLine();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.AST_NODE__LINE_NUMBER:
				this.setLineNumber((Integer)newValue);
				return;
			case AstPackage.AST_NODE__POSITION_IN_LINE:
				this.setPositionInLine((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AstPackage.AST_NODE__LINE_NUMBER:
				this.setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case AstPackage.AST_NODE__POSITION_IN_LINE:
				this.setPositionInLine(POSITION_IN_LINE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AstPackage.AST_NODE__LINE_NUMBER:
				return this.lineNumber != LINE_NUMBER_EDEFAULT;
			case AstPackage.AST_NODE__POSITION_IN_LINE:
				return this.positionInLine != POSITION_IN_LINE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (this.eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lineNumber: ");
		result.append(this.lineNumber);
		result.append(", positionInLine: ");
		result.append(this.positionInLine);
		result.append(')');
		return result.toString();
	}

    /**
     * 
     * @param visitor
     */
    public void accept(ASTNodeVisitor visitor) {
	Deque<Class<?>> classes = new LinkedList<Class<?>>();
	classes.add(this.getClass());
	Class<?> c;
	do {
	    c = classes.removeFirst();

	    List<Class<?>> ifaces = Arrays.asList(c.getInterfaces());
	    Collections.reverse(ifaces);
	    classes.addAll(ifaces);

	    if (c.getSuperclass() != null) {
		classes.add(c.getSuperclass());
	    }
	} while (!tryVisit(visitor, c) && !classes.isEmpty());
    }

    /**
     * 
     * @param visitor
     * @param c
     * @return
     */
    private Boolean tryVisit(ASTNodeVisitor visitor, Class<?> c) {
	try {
	    Method m = visitor.getClass().getMethod("visit", c);
	    m.setAccessible(true);
	    m.invoke(visitor, this);
	    return true;
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    throw new RuntimeException(e.getCause());
	} catch (NoSuchMethodException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SecurityException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return false;
    }
} //ASTNodeImpl
