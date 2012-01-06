package edu.kit.iti.formal.pse.worthwhile.common.tests;

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

public class TestASTProvider {

	public static Program getRootASTNode(String parseText) {
		// from http://wiki.pse.ndreke.de/proof_of_concept_ast_output
		Injector guiceInjector = new WorthwhileStandaloneSetup()
		.createInjectorAndDoEMFRegistration();
		IParser parser = guiceInjector.getInstance(IParser.class);

		IParseResult result = parser.parse(new StringReader(parseText));

		// System.out.println("Getting syntax errors ...");
		// Iterable<INode> errors = result.getSyntaxErrors();
		Program root = (Program) result.getRootASTElement();
		return root;
	}

	/**
	 * @return A simple, human-readable formula that evaluates to true (i.e. is
	 *         always satisfiable) and covers a lot of the constructs supported
	 *         by the language
	 */
	public static Expression getTestFormula() {
		return parseFormulaString("((!false || ((9 % 4) = 1)) && true && ((3 + 3) = 6)");
	}

	public static Expression getNegatedTestFormula() {
		return parseFormulaString("!((!false || ((9 % 4) = 1)) && true && ((3 + 3) = 6)");
	}

	public static Expression parseFormulaString(String formulaString) {
		ASTNode n = TestASTProvider.getRootASTNode("{\nBoolean x := " +
				formulaString + "\n" +
				"}\n");
		List<Statement> statements = ((Block) ((Program) n).getMainBlock()
				.getStatements().get(0)).getStatements();

		return ((VariableDeclaration) (statements.get(0))).getInitialValue();
	}
}
