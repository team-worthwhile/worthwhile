package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.scoping.WorthwhileScopeProvider;

/**
 * A scoping provider that uses the current program state to provide variable declarations.
 * 
 * @author Joachim
 * 
 * @nocheckstyle:methodname (convention requires the method names to contain underscores)
 * 
 */
public class WorthwhileDebugScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * The debug target to use.
	 */
	private final WorthwhileDebugTarget debugTarget;

	/**
	 * Creates a new instance of the {@link WorthwhileDebugScopeProvider} class.
	 * 
	 * @param debugTarget
	 *                The debug target to use.
	 */
	@Inject
	public WorthwhileDebugScopeProvider(final WorthwhileDebugTarget debugTarget) {
		this.debugTarget = debugTarget;
	}
	
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
		return new WorthwhileScopeProvider().scope_FunctionCall_function(context, reference);
	}

	/**
	 * Provides the scope for a variable reference.
	 * 
	 * @param context
	 *                The variable reference to provide the scope for.
	 * @param reference
	 *                The corresponding EReference in the Ecore model.
	 * @return A scope in which to look for the referenced variable.
	 */
	public final IScope scope_VariableReference_variable(final VariableReference context, final EReference reference) {
		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();

		for (VariableDeclaration vardec : this.debugTarget.getVariableDeclarations()) {
			descriptions.add(EObjectDescription.create(vardec.getName(), vardec));
		}

		return new SimpleScope(IScope.NULLSCOPE, descriptions);
	}

}
