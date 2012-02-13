package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeEqualsHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeToStringHelper;

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

	private void testTransformProgram(final String program, final String expected) {
		this.testTransformProgram(program, this.getExpression(expected));
	}

	private void testTransformProgram(final String program, final Expression expected) {
		final Program p = this.getProgram(program);
		p.accept(new ImplicitInitialValueInserter());
		final Expression actual = this.transformer.transformProgram(p);
		TransformProgramTest.assertASTNodeEqual(expected, actual);
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
		if (!AstNodeEqualsHelper.equals(expected, was)) {
			Assert.fail("\nexpected: " + AstNodeToStringHelper.toString(expected) + "\nwas: "
			                + AstNodeToStringHelper.toString(was) + "\n");
		}
	}

	/**
	 * Tests the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment}s.
	 */
	@Test
	public void assignmentRule() {
		Expression expected;

		this.testTransformProgram("Integer x := 1\n_assert x = 1\n", "1 = 1 && true");

		this.testTransformProgram("Integer x := 1\nx := 0\n_assert x = 1\n", "0 = 1 && true");

		expected = this.getExpression("(true => (false = false && true)) && (false = false && true)");
		this.testTransformProgram(
		                "function Boolean f() {\nBoolean fx\n_assert fx = false\nreturn fx\n}\nBoolean x\n_assert x = false\n",
		                expected);

		expected = this.getExpression("(true => (0 = 0 && true)) && (0 = 0 && true)");
		this.testTransformProgram(
		                "function Integer f() {\nInteger fx\n_assert fx = 0\nreturn fx\n}\nInteger x\n_assert x = 0\n",
		                expected);

		expected = this.getExpression("(true => ({ } = { } && true)) && ({ } = { } && true)");
		this.testTransformProgram(
		                "function Boolean[] f() {\nBoolean[] fx\n_assert fx = { }\nreturn fx\n}\nBoolean[] x\n_assert x = { }\n",
		                expected);

		expected = this.getExpression("(true => ({ } = { } && true)) && ({ } = { } && true)");
		this.testTransformProgram(
		                "function Integer[] f() {\nInteger[] fx\n_assert fx = { }\nreturn fx\n}\nInteger[] x\n_assert x = { }\n",
		                expected);
	}

	/**
	 * Tests the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional}s.
	 */
	@Test
	public void conditionalRule() {
		Program p = this.getProgram("Integer x := 1\nif x = 1 {\nx := 0\n}\n_assert x = 0\n");
		Expression result = this.transformer.transformProgram(p);

		Expression expected = this.getExpression("(1 = 1 => (0 = 0 && true))"
		                + "&& (!(1 = 1) => (1 = 0 && true))");

		assertASTNodeEqual(expected, result);
	}

	/**
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption}s.
	 */
	@Test
	public void assumptionRule() {
		Program p = this.getProgram("Integer x := 1\n_assume x = 0\n_assert x = 10\n");
		Expression result = this.transformer.transformProgram(p);

		Expression expected = this.getExpression("(1 = 0) => (1 = 10 && true)");

		assertASTNodeEqual(expected, result);
	}

	/**
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom}s.
	 */
	@Test
	public void axiomRule() {
		Program p = this.getProgram("_axiom forall Integer a forall Integer b : a * b = b * a\nInteger x := 2 * 3\n_assert x = 3 * 2\n");
		Expression result = this.transformer.transformProgram(p);

		Expression expected = this.getExpression("(forall Integer a forall Integer b : a * b = b * a)"
		                + "=> (2 * 3 = 3 * 2 && true)");

		assertASTNodeEqual(expected, result);
	}

	/**
	 * Tests the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop}s.
	 */
	@Test
	public void loopRule() {
		// from http://wiki.pse.ndreke.de/test_zaehlvariable
		Program p = this.getProgram("Integer n := 42\n"
				+ "Integer t := 0\n"
				+ "while t < n _invariant t <=n\n"
				+ "{\n"
				+ "    t := t + 1\n"
				+ "}\n"
				+ "_assert t = n\n");
		Expression result = this.transformer.transformProgram(p);

		String expectedResultString = "(((0 <= 42) "
				// condition true implies weakest block precondition
				+ "&& forall Integer n : forall Integer t : (((t < n) && (t <= n)) => "
				+ "((t + 1) <= n))) "
				// condition not true implies postcondition
				+ "&& forall Integer n : forall Integer t : ((!(t < n) && (t <= n)) => "
				+ "((t = n) && true)))";
		String resultString = AstNodeToStringHelper.toString(result);

		Assert.assertEquals(expectedResultString, resultString);
	}

	/**
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration}s.
	 */
	@Test
	public void functionDeclarationRule() {
		Program p = this.getProgram("function Integer max(Integer a, Integer b)\n"
		                + "_ensures _return = a || _return = b\n_ensures _return >= a && _return >= b\n"
		                + "{\nif (a > b) {\nreturn a\n}\nreturn b\n}\n");
		Expression result = this.transformer.transformProgram(p);

		Expression expected = this.getExpression("(forall Integer b : forall Integer a : true => "
		                + "(((a > b) => ((a = a || a = b) && (a >= a && a >= b))) "
		                + "&& (!(a > b) => ((b = a || b = b) && (b >= a && b >= b))))) && true");

		TransformProgramTest.assertASTNodeEqual(expected, result);
	}

	/**
	 * Tests the transformation of {@link FunctionCalls} in initial value {@link Expression}s.
	 */
	@Test
	public void variableDeclarationFunctionCallRule() {
		final Program testProgram = this.getProgram("function Integer f(Integer t)\n"
		                + "_requires t = 0 || t = 1\n"
		                + "_ensures (t = 0 && _return = 1) || (t = 1 && _return = 0)\n" + "{\n"
		                + "    return -1\n" + "}\n" + "Integer v := f(2)\n");
		testProgram.accept(new FunctionCallSubstitution());
		final Expression actual = this.transformer.transformProgram(testProgram);

		final Expression expected = this.getExpression("(forall Integer t :"
		                + "(t = 0 || t = 1) => (t = 0 && -1 = 1 || t = 1 && -1 = 0))"
		                + "&& ((2 = 0 || 2 = 1) && (forall Integer _f0 :"
		                + "(((2 = 0 && _f0 = 1) || (2 = 1 && _f0 = 0)) => true)))");

		TransformProgramTest.assertASTNodeEqual(expected, actual);
	}

	/**
	 * Tests the transformation of {@link FunctionCalls} in conditional condition {@link Expression}s.
	 */
	@Test
	public void conditionalFunctionCallRule() {
		final Program testProgram = this.getProgram("function Integer f(Integer t)\n"
		                + "_requires t = 0 || t = 1\n"
		                + "_ensures (t = 0 && _return = 1) || (t = 1 && _return = 0)\n" + "{\n"
		                + "    return -1\n" + "}\n" + "if f(2) = -1 {\n}\n");
		testProgram.accept(new FunctionCallSubstitution());
		final Expression actual = this.transformer.transformProgram(testProgram);

		final Expression expected = this.getExpression("(forall Integer t :"
		                + "(t = 0 || t = 1) => (t = 0 && -1 = 1 || t = 1 && -1 = 0))"
		                + "&& ((2 = 0 || 2 = 1) && (forall Integer _f0 :"
		                + "(((2 = 0 && _f0 = 1) || (2 = 1 && _f0 = 0))"
		                + "=> ((_f0 = -1 => true) && (!(_f0 = -1) => true)))))");

		TransformProgramTest.assertASTNodeEqual(expected, actual);
	}

	/**
	 * Tests the transformation of {@link FunctionCalls} in loop condition and invariant {@link Expression}s.
	 */
	@Test
	public void loopFunctionCallRule() {
		final Program testProgram = this.getProgram("function Integer f(Integer t)\n"
		                + "_requires t = 0 || t = 1\n"
		                + "_ensures (t = 0 && _return = 1) || (t = 1 && _return = 0)\n" + "{\n"
		                + "    return -1\n" + "}\n" + "while f(2) = -1\n_invariant f(2) = -1\n{\n}\n");
		testProgram.accept(new FunctionCallSubstitution());
		final Expression actual = this.transformer.transformProgram(testProgram);

		final Expression expected = this.getExpression("(forall Integer t : (t = 0 || t = 1) =>"
		                + "(t = 0 && -1 = 1 || t = 1 && -1 = 0))"
		                + "&& ((2 = 0 || 2 = 1)" + "&& (forall Integer _f0 :"
		                + "((2 = 0 && _f0 = 1) || (2 = 1 && _f0 = 0)) =>"
		                + "(((2 = 0 || 2 = 1) && (forall Integer _f1 :"
		                + "(((2 = 0 && _f1 = 1) || (2 = 1 && _f1 = 0)) =>"
		                + "((_f1 = -1) && (forall Integer _f1 : (forall Integer _f0 :"
		                + "(_f0 = -1 && _f1 = -1) => _f1 = -1)) && (forall Integer _f1 :"
		                + "(forall Integer _f0 :" + "(!(_f0 = -1) && _f1 = -1) => true)))))))))");

		TransformProgramTest.assertASTNodeEqual(expected, actual);
	}
}
