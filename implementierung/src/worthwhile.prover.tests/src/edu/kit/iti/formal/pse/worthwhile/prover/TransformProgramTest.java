package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * JUnit TestCases for {@link WPStrategy#transformProgram}.
 * 
 * @author fabian
 * 
 */
public final class TransformProgramTest {
	/**
	 * Generates an {@link Expression} from a Worthwhile {@link String}.
	 * 
	 * @param exprString
	 *                some Worthwhile expression code
	 * @return {@link Expression} AST representing <code>exprString</code>
	 */
	Expression getExpression(final String exprString) {
		Expression e = TestASTProvider.parseFormulaString(exprString);
		Assert.assertNotNull(e);
		return e;
	}

	/**
	 * Generates an {@link Program} from a Worthwhile {@link String}.
	 * 
	 * @param progString
	 *                some Worthwhile program code
	 * @return {@link Program} AST representing <code>progString</code>
	 */
	Program getProgram(final String progString) {
		Program p = TestASTProvider.getRootASTNode(progString);
		Assert.assertNotNull(p);
		return p;
	}

	/**
	 * The {@link FormulaGenerator} implementation to test.
	 */
	private FormulaGenerator transformer = new WPStrategy();

	/**
	 * Asserts equality of an expected and actual {@link ASTNode} result.
	 * 
	 * Fails the TestCase if <code>expected</code> and <code>was</code> do not equal according to
	 * {@link ASTNodeEqualator}.
	 * 
	 * @param expected
	 *                the expected ASTNode
	 * @param was
	 *                the ASTNode result which must equal <code>expected</code> for the test to pass
	 */
	private static void assertASTNodeEqual(final ASTNode expected, final ASTNode was) {
		if (!ASTNodeEqualator.equals(expected, was)) {
			ASTNodeToStringHelper toString = new ASTNodeToStringHelper();
			Assert.fail("expected: " + toString.toString(expected) + " was: " + toString.toString(was));
		}
	}

	/**
	 * Tests the transformation of {@link Assignment}s.
	 */
	@Test
	public void assignmentRule() {
		Program p = this.getProgram("Integer x := 1\n_assert x = 1\n");
		Expression result = this.transformer.transformProgram(p);
		assertASTNodeEqual(this.getExpression("1 = 1 && true"), result);

		p = this.getProgram("Integer x := 1\nx := 0\n_assert x = 1\n");
		result = this.transformer.transformProgram(p);
		assertASTNodeEqual(this.getExpression("0 = 1 && true"), result);
	}

	/**
	 * Tests the transformation of {@link Conditional}s.
	 */
	@Test
	public void conditionalRule() {
		Program p = this.getProgram("Integer x := 1\nif x = 1 {\nx := 0\n}\n_assert x = 0\n");
		Expression result = this.transformer.transformProgram(p);

		// getExpression cannot be used to build expected because `=>' is no valid Worthwhile operator
		Conjunction expected = AstFactory.init().createConjunction();

		Implication implication = AstFactory.init().createImplication();
		implication.setLeft(this.getExpression("1 = 1"));
		implication.setRight(this.getExpression("0 = 0 && true"));
		expected.setLeft(implication);

		implication = AstFactory.init().createImplication();
		implication.setLeft(this.getExpression("!(1 = 1)"));
		implication.setRight(this.getExpression("true"));
		expected.setRight(implication);

		assertASTNodeEqual(expected, result);
	}
}
