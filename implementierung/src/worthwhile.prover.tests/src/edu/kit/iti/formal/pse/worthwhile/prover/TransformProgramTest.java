package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * JUnit TestCases for {@link WPStrategy#transformProgram}.
 * 
 * @author fabian
 * 
 */
public class TransformProgramTest {
    /**
     * Generates an {@link Expression} from a Worthwhile {@link String}.
     * 
     * @param exprString
     *            some Worthwhile expression code
     * @return {@link Expression} AST representing <code>exprString</code>
     */
    Expression getExpression(String exprString) {
	return TestASTProvider.parseFormulaString(exprString);
    }

    /**
     * Generates an {@link Program} from a Worthwhile {@link String}.
     * 
     * @param progString
     *            some Worthwhile program code
     * @return {@link Program} AST representing <code>progString</code>
     */
    Program getProgram(String progString) {
	return TestASTProvider.getRootASTNode(progString);
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
	Expression result = this.transformer.transformProgram(this.getProgram("Integer x := 1\n_assert x = 1\n"));
	Assert.assertEquals(this.getExpression("1 = 1 && true"), result);

	result = this.transformer.transformProgram(this.getProgram("Integer x\nx := 1\n_assert x = 1\n"));
	Assert.assertEquals(this.getExpression("1 = 1 && true"), result);
    }
}
