package edu.kit.iti.formal.pse.worthwhile.typesystem;

import org.eclipse.emf.ecore.EObject;

import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.typesys.WorthwhileTypesystemGenerated;

/**
 * The type system for validation.
 * 
 */
public class WorthwhileTypesystem extends WorthwhileTypesystemGenerated {

	@Override
	protected final void initialize() {
		super.initialize();
	}

	/**
	 * Returns the type of the given return statement.
	 * 
	 * @param returnStatement
	 *                The return statement of which you want to know the type.
	 * @return The type of the return statement.
	 */
	public final EObject type(final ReturnStatement returnStatement) {
		return typeof(returnStatement.getReturnValue(), new TypeCalculationTrace());

	}

	/**
	 * Returns the return type of the given function declaration.
	 * 
	 * @param functionDeclaration
	 *                The function declaration of which you want to know the type.
	 * @return The type of the function declaration.
	 */
	public final EObject type(final FunctionDeclaration functionDeclaration) {
		return functionDeclaration.getReturnType();
	}
	/**
	 * Returns the type of the given return statement.
	 * 
	 * @param expression
	 *                The expression of which you want to know the type.
	 * @return The type of the return statement.
	 */
	public final EObject type(final Expression expression) {
		return typeof(expression, new TypeCalculationTrace());

	}
	/**
	 * Returns the type of the given variable declaration.
	 * 
	 * @param variableDeclaration
	 *                The variable declaration of which you want to know the type.
	 * @return The type of the variable declaration.
	 */
	public final EObject type(final VariableDeclaration variableDeclaration) {
		return variableDeclaration.getType();

	}
}
