package edu.kit.iti.formal.pse.worthwhile.debugger.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

public class WorthwhileDebugScopeProvider extends AbstractDeclarativeScopeProvider {
	
	private final WorthwhileDebugTarget debugTarget;
	
	public WorthwhileDebugScopeProvider(final WorthwhileDebugTarget debugTarget) {
		this.debugTarget = debugTarget;
	}

	public final IScope scope_VariableReference_variable(final VariableReference context, final EReference reference) {
		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>(); 
		
		for (VariableDeclaration vardec : this.debugTarget.getVariableDeclarations()) {
			descriptions.add(EObjectDescription.create(vardec.getName(), vardec));
		}

		return new SimpleScope(IScope.NULLSCOPE, descriptions);
	}

}
