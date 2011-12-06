package org.xtext.example.mydsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.xtext.example.mydsl.myDsl.Function;
import org.xtext.example.mydsl.myDsl.ReturnStatement;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;

public class MyDslJavaValidator extends AbstractMyDslJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
//		}
//	}
	
	@Check
	/**
	 * Checks whether a return statement is contained in a function declaration.
	 * @param stmt The statement to check
	 */
	public void checkReturnStatementOnlyInFunctions(ReturnStatement stmt) {
		EObject obj = stmt;
		
		// Go up the parse tree until we find a function declaration or arrive at the top.
		do {
			obj = obj.eContainer();
		} while (obj != null && !(obj instanceof Function));
		
		if (obj == null) {
			error("You can only use a return statement within a function body.", null);
		}
	}
	
	@Inject
	private ITypesystem ts;
	
	@Check
	public void checkTypesystemRules( EObject x ) {
	  ts.checkTypesystemConstraints(x, this);
	}

}
