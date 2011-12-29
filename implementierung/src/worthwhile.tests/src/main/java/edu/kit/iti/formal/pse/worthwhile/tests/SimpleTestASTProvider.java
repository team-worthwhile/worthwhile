package edu.kit.iti.formal.pse.worthwhile.tests;

import java.io.StringReader;
import java.util.List;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

import com.google.inject.Injector;

import edu.kit.iti.formal.pse.worthwhile.WorthwhileStandaloneSetup;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

public class SimpleTestASTProvider {

	public static ASTNode getSimpleTestAST() {
		// from http://wiki.pse.ndreke.de/proof_of_concept_ast_output
		String testString = "\n{\nBoolean b := false\nInteger a := 4\nInteger b := 45\nBoolean trueTestFormula := ((true || false) && true)\nBoolean falseTestFormula := ((true || false) && false)\n}";
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
		List<Statement> statements = ((Block) ((Program) n).getMainBlock()
				.getStatements().get(0)).getStatements();

		return ((VariableDeclaration) (statements.get(4))).getInitialValue();
	}
}
