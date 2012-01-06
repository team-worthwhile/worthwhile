package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileStandaloneSetup;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

public class TestASTProvider {

    public static Program getRootASTNode(String parseText) {
	// from http://wiki.pse.ndreke.de/proof_of_concept_ast_output
	// see also http://wiki.eclipse.org/Xtext/FAQ#How_do_I_load_my_model_in_a_standalone_Java_application.C2.A0.3F
	Injector guiceInjector = new WorthwhileStandaloneSetup().createInjectorAndDoEMFRegistration();
	XtextResourceSet resourceSet = guiceInjector.getInstance(XtextResourceSet.class);
	resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.ww"));
	InputStream in = new ByteArrayInputStream(parseText.getBytes());
	try {
	    resource.load(in, resourceSet.getLoadOptions());
	} catch (IOException e) {
	    // TODO
	}

	// System.out.println("Getting syntax errors ...");
	// Iterable<Diagnostic> errors = resource.getErrors();
	Program root = null;

	if (resource.getErrors().isEmpty()) {
	    root = (Program) resource.getContents().get(0);
	}

	return root;
    }

    /**
     * @return A simple, human-readable formula that evaluates to true (i.e. is always satisfiable) and covers a lot of
     *         the constructs supported by the language
     */
    public static Expression getTestFormula() {
	return parseFormulaString("((!false || ((9 % 4) = 1)) && true && ((3 + 3) = 6)");
    }

    public static Expression getNegatedTestFormula() {
	return parseFormulaString("!((!false || ((9 % 4) = 1)) && true && ((3 + 3) = 6)");
    }

    public static Expression parseFormulaString(String formulaString) {
	ASTNode n = TestASTProvider.getRootASTNode("{\nBoolean x := " + formulaString + "\n" + "}\n");

	if (n == null) {
	    return null;
	}

	List<Statement> statements = ((Block) ((Program) n).getMainBlock().getStatements().get(0)).getStatements();

	return ((VariableDeclaration) (statements.get(0))).getInitialValue();
    }
}
