/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/** 
 * 
 */
public class ConditionalLineBreakpoint extends LineBreakpoint {
	/**
	 * 
	 */
	private Expression condition;
	
	/** 
	 * @return the condition
	 */
	public Expression getCondition() {
		// begin-user-code
		return condition;
		// end-user-code
	}

	/** 
	 * @param condition the condition to set
	 */
	public void setCondition(Expression condition) {
		// begin-user-code
		this.condition = condition;
		// end-user-code
	}
}