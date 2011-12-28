package edu.kit.iti.formal.pse.worthwhile.tests;

import java.io.StringReader;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileStandaloneSetup;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

public class SimpleTestASTProvider {

	public static ASTNode getSimpleTestAST() {
		// from http://wiki.pse.ndreke.de/proof_of_concept_ast_output
		String testString = "function Boolean func(Integer param1, Boolean param2) {\nBoolean ret := true\nInteger D:= 42\nret := param1 || param2\nreturn ret\n}\n{\nBoolean b := false\nInteger a := 4\nInteger b := 45\nBool trueTestFormula = ((true || false) && true)\nBool falseTestFormula = ((true || false) && false)}";
		Injector guiceInjector = new WorthwhileStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		IParser parser = guiceInjector.getInstance(IParser.class);

		IParseResult result = parser.parse(new StringReader(testString));

		// System.out.println("Getting syntax errors ...");
		// Iterable<INode> errors = result.getSyntaxErrors();
		ASTNode root = (ASTNode) result.getRootASTElement();
		return root;
	}

	public static Expression getSimpleTrueFormula() {
		ASTNode n = SimpleTestASTProvider.getSimpleTestAST();
		n.getLineNumber();
		return (Expression) n;
	}
}
