package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstSwitch;

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
	 *            some Worthwhile expression code
	 * @return {@link Expression} AST representing <code>exprString</code>
	 */
	Expression getExpression(String exprString) {
		Expression e = TestASTProvider.parseFormulaString(exprString);
		Assert.assertNotNull(e);
		return e;
	}

	/**
	 * Generates an {@link Program} from a Worthwhile {@link String}.
	 * 
	 * @param progString
	 *            some Worthwhile program code
	 * @return {@link Program} AST representing <code>progString</code>
	 */
	Program getProgram(String progString) {
		Program p = TestASTProvider.getRootASTNode(progString);
		Assert.assertNotNull(p);
		return p;
	}

	/**
	 * The {@link FormulaGenerator} implementation to test.
	 */
	private FormulaGenerator transformer = new WPStrategy();

	/**
	 * Tests the transformation of {@link Assignment}s.
	 */
	@Test
	public void assignmentRule() {
		Program p = this.getProgram("Integer x := 1\n_assert x = 1\n");
		Expression result = this.transformer.transformProgram(p);
		Assert.assertTrue(ASTNodeEqualator.equal(this.getExpression("1 = 1 && true"), result));

		p = this.getProgram("Integer x := 1\nx := 0\n_assert x = 1\n");
		result = this.transformer.transformProgram(p);
		if (!ASTNodeEqualator.equal(this.getExpression("0 = 1 && true"), result)) {
			AstSwitch<?> toString = new ASTNodeToStringHelper();
			Assert.fail("expected: " + toString.doSwitch(this.getExpression("0 = 1 && true")) + " was: "
					+ toString.doSwitch(result));
		}
	}
}
