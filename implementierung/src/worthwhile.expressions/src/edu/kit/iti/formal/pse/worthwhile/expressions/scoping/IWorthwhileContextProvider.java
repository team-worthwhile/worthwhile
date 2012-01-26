package edu.kit.iti.formal.pse.worthwhile.expressions.scoping;

import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

/**
 * Provides a context of a running program, i.e. a list of variable declarations and function declarations visible in
 * the current execution context.
 * 
 * @author Joachim
 */
public interface IWorthwhileContextProvider {

	/**
	 * Returns the currently visible variable declarations.
	 * 
	 * @return a set of the currently visible variable declarations.
	 */
	Set<VariableDeclaration> getVariableDeclarations();

	/**
	 * Returns the currently visible function declarations.
	 * 
	 * @return a set of the currently visible function declarations.
	 */
	Set<FunctionDeclaration> getFunctionDeclarations();

}
