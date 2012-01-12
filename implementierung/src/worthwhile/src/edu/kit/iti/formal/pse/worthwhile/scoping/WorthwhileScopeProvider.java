/*
 * generated by Xtext
 */
package edu.kit.iti.formal.pse.worthwhile.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on how and when to use it
 * 
 */
public class WorthwhileScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Provides the scope for a function call's function reference.
	 * 
	 * @param context
	 *                The function call to provide the scope for.
	 * @param reference
	 *                TODO
	 * @return A scope in which to look for the referenced function.
	 */
	public final IScope scope_FunctionCall_function(final FunctionCall context, final EReference reference) {
		// Traverse the AST up to the Program.
		EObject current = context;

		while (current != null && !(current instanceof Program)) {
			current = current.eContainer();
		}

		// Return the Program's function declarations as a scope.
		if (current instanceof Program) {
			return new SimpleScope(IScope.NULLSCOPE, getFunctionDeclarations((Program) current));
		} else {
			return IScope.NULLSCOPE;
		}
	}

	/**
	 * 
	 * @param context
	 * @param reference
	 * @return
	 */
	public final IScope scope_VariableReference_variable(final VariableReference context, final EReference reference) {
		// Traverse the AST up to the containing function or program.
		EObject container = context;

		while (container != null && !(container instanceof Program) && !(container instanceof FunctionDeclaration)) {
			container = container.eContainer();
		}

		IScope parent = IScope.NULLSCOPE;

		// If we have a function declaration, add its parameters to the scope.
		if (container instanceof FunctionDeclaration) {
			parent = new SimpleScope(IScope.NULLSCOPE, getParameters((FunctionDeclaration) container));
		}

		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();

		// Traverse the AST up to the containing statement.
		EObject statement = context;

		while (statement  != null && !(statement  instanceof Statement)) {
			statement  = statement .eContainer();
		}

		if (statement instanceof Statement) {
			// Traverse the containing AST node depth-first until we arrive at the original variable
			// reference.
			VariableDeclarationFinder varDeclFinder = new VariableDeclarationFinder((Statement) statement);
			
			((ASTNode) container).accept(varDeclFinder);

			for (VariableDeclaration vardec : varDeclFinder.getVariableDeclarations()) {
				descriptions.add(EObjectDescription.create(vardec.getName(), vardec));
			}
		}

		return new SimpleScope(parent, descriptions);
	}

	/**
	 * Gets a list of the function declaration descriptions of a {@link Program}.
	 * 
	 * @param program
	 *                The program whose function declarations to return.
	 * @return A list of the {@link IEObjectDescription}s of the given program's functions.
	 */
	private Iterable<IEObjectDescription> getFunctionDeclarations(final Program program) {
		List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		for (FunctionDeclaration funcdec : program.getFunctionDeclarations()) {
			result.add(EObjectDescription.create(funcdec.getName(), funcdec));
		}
		return result;
	}

	/**
	 * Gets a list of the parameter descriptions of a {@link FunctionDeclaration}.
	 * 
	 * @param funcdec
	 *                The function declarations whose parameters to return.
	 * @return A list of the {@link IEObjectDescription}s of the given function's parameters.
	 */
	private Iterable<IEObjectDescription> getParameters(final FunctionDeclaration funcdec) {
		List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		for (VariableDeclaration param : funcdec.getParameters()) {
			result.add(EObjectDescription.create(param.getName(), param));
		}
		return result;
	}

}
