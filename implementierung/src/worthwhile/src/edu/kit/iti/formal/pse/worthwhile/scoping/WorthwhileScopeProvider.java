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
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeBottomUpVisitor;

/**
 * This class contains the custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on how and when to use it
 * 
 * @author Joachim
 * 
 * @nocheckstyle:methodname (convention requires the method names to contain underscores)
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
	 * @return A scope in which to look for the referenced variable.
	 */
	public final IScope scope_VariableReference_variable(final VariableReference context, final EReference reference) {
		ScopeFinder scopeFinder = new ScopeFinder(context);
		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();

		for (VariableDeclaration vardec : scopeFinder.getVariableDeclarations()) {
			descriptions.add(EObjectDescription.create(vardec.getName(), vardec));
		}

		return new SimpleScope(IScope.NULLSCOPE, descriptions);
	}

	/**
	 * Provides the scope for a function declaration reference of a ReturnValueReference.
	 * 
	 * @param context
	 *                The return value reference to provide the scope for.
	 * @param reference
	 *                The corresponding EReference in the Ecore model.
	 * @return A scope which contains the function declaration..
	 */
	public final IScope scope_ReturnValueReference_function(final ReturnValueReference context,
	                final EReference reference) {
		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();

		FunctionDeclaration funcdec = new ASTNodeBottomUpVisitor<FunctionDeclaration>() {

			@Override
			public void visit(final FunctionDeclaration node) {
				this.setReturnValue(node);
			}

		} .apply(context);
		
		if (funcdec != null) {
			descriptions.add(EObjectDescription.create("_return", funcdec));
		}

		return new SimpleScope(IScope.NULLSCOPE, descriptions);
	}

	/**
	 * Provides the scope for the {@link FunctionDeclaration} reference of a {@link ReturnStatement}.
	 * 
	 * @param context
	 *                the <code>ReturnStatement</code> to provide the scope for
	 * @param reference
	 *                the corresponding {@link EReference} in the Ecore model
	 * @return a scope which contains the <code>FunctionDeclaration</code>
	 */
	public final IScope scope_ReturnStatement_function(final ReturnStatement context, final EReference reference) {
		final List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();

		final FunctionDeclaration function = new ASTNodeBottomUpVisitor<FunctionDeclaration>() {
			@Override
			public void visit(final FunctionDeclaration function) {
				this.setReturnValue(function);
			}

		}.apply(context);

		if (function != null) {
			descriptions.add(EObjectDescription.create("return", function));
		}

		return new SimpleScope(IScope.NULLSCOPE, descriptions);
	}
}
