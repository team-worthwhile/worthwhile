/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.math.BigInteger;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;

/** 
 * 
 */
public abstract class Value {
    /** 
	 * 
	 */
    private ValueType valueType;

    /**
     * @return the valueType
     */
    public ValueType getValueType() {
	// begin-user-code
	return valueType;
	// end-user-code
    }

    /**
     * @param valueType
     *            the valueType to set
     */
    public void setValueType(ValueType valueType) {
	// begin-user-code
	this.valueType = valueType;
	// end-user-code
    }

    /**
     * @return
     */
    public ValueType getType() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * @return
     */
    public BigInteger getIntegerValue() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * @return
     */
    public Boolean getBooleanValue() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * @return
     */
    public Set<Boolean> getBooleanArray() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * @return
     */
    public Set<Integer> getIntegerArray() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    public abstract Literal getLiteral();
}