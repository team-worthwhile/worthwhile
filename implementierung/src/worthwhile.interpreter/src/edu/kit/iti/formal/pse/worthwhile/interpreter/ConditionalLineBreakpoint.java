package edu.kit.iti.formal.pse.worthwhile.interpreter;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * A breakpoint that can be attached to a line that only triggers if the associated Expression evaluates to true
 */
public class ConditionalLineBreakpoint extends LineBreakpoint {

    /**
     * the condition that is required to be true for this breakpoint to be triggered
     */
    private Expression condition;

    /**
     * Construct a new instance with the given associated line and condition required for the breakpoint to be triggered
     * 
     * @param line
     *            the line that this breakpoint should be triggered on
     * @param condition
     *            the condition that has to be true for the breakpoint to trigger
     */
    public ConditionalLineBreakpoint(Integer line, Expression condition) {
	super(line);
	this.condition = condition;
    }

    /**
     * @return the condition required to be true for this breakpoint to be triggered
     */
    public Expression getCondition() {
	return this.condition;
    }

    /**
     * @param condition
     *            the condition to set
     */
    public void setCondition(Expression condition) {
	this.condition = condition;
    }
}