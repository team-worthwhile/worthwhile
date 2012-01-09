package edu.kit.iti.formal.pse.worthwhile.interpreter;

/**
 * A breakpoint associated with a line that is triggered before any statements on the line are executed
 */
public class LineBreakpoint {
	private Integer line;

	/**
	 * Constructs a new instance with the given associated line
	 * 
	 * @param line
	 *            the line associated with the breakpoint
	 */
	public LineBreakpoint(Integer line) {
		this.line = line;
	}

	/**
	 * @return the line currently associated with this breakpoint
	 */
	public Integer getLine() {
		return this.line;
	}

	/**
	 * @param line
	 *            the line of code that this breakpoint should trigger on
	 */
	public void setLine(Integer line) {
		this.line = line;
	}
}