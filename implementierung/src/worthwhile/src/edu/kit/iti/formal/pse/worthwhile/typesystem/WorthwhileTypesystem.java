package edu.kit.iti.formal.pse.worthwhile.typesystem;

import org.eclipse.emf.ecore.EObject;

import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
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

	@Override
	protected final EObject type(final ReturnStatement element, final TypeCalculationTrace trace) {
		EObject obj = element;

		// Go up the parse tree until we find a function declaration or arrive
		// at the top.
		do {
			obj = obj.eContainer();
		} while (obj != null && !(obj instanceof FunctionDeclaration));

		if (obj != null) {

			trace.add(element, "");
			return ((FunctionDeclaration) obj).getReturnType();
		} else {
			return null;
		}
	}
}
