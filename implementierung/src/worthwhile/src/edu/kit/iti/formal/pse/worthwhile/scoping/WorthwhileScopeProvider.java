package edu.kit.iti.formal.pse.worthwhile.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * This class contains the custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on how and when to use it
 * 
 * @author Joachim
 * 
 */
public class WorthwhileScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Provides the scope for a function call's function reference.
	 * 
	 * @param context
	 *                The function call to provide the scope for.
	 * @param reference
	 *                The corresponding EReference in the Ecore model.
	 * @return A scope in which to look for the referenced function.
	 */
	public final IScope scope_FunctionCall_function(final FunctionCall context, final EReference reference) {
		ScopeFinder scopeFinder = new ScopeFinder(context);
		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();
				
		for (FunctionDeclaration funcdec : scopeFinder.getFunctionDeclarations()) {
			descriptions.add(EObjectDescription.create(funcdec.getName(), funcdec));
		}

		return new SimpleScope(IScope.NULLSCOPE, descriptions);
	}

	/**
	 * Provides the scope for a variable reference.
	 * 
	 * @param context
	 *                The variable reference to provide the scope for.
	 * @param reference
	 *                The corresponding EReference in the Ecore model.
	 * @return
	 */
	public final IScope scope_VariableReference_variable(final VariableReference context, final EReference reference) {
		ScopeFinder scopeFinder = new ScopeFinder(context);
		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();

		for (VariableDeclaration vardec : scopeFinder.getVariableDeclarations()) {
			descriptions.add(EObjectDescription.create(vardec.getName(), vardec));
		}

		return new SimpleScope(IScope.NULLSCOPE, descriptions);
	}

}
