package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;


public class WorthwhileJavaValidator extends AbstractWorthwhileJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
//		}
//	}
	
	
	@Check
	public void checkFunctionDeclerationValidReturnStatment(FunctionDeclaration functionDeclaration) {
		ValidatorASTNodeVisitor validatorASTNodeVisitor = new ValidatorASTNodeVisitor();
		validatorASTNodeVisitor.visit(functionDeclaration);
		if(!validatorASTNodeVisitor.getValidReturnFound()) {
			error("Function has no valid return statement.", null);
		}
	}
	@Inject
	private ITypesystem ts;
	
	@Check
	public void checkTypesystemRules( EObject x ) {
	  ts.checkTypesystemConstraints(x, this);
	}


}
