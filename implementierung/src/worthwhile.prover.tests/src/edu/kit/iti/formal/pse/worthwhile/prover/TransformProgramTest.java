package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
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
	private AstFactory model = AstFactory.init();

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
			Assert.fail("expected: " + AstNodeToStringHelper.toString(expected) + " was: "
			                + AstNodeToStringHelper.toString(was));
		}
	}

	/**
	 * Tests the transformation of {@link Assignment}s.
	 */
	@Test
	public void assignmentRule() {
		Expression expected;

		this.testTransformProgram("Integer x := 1\n_assert x = 1\n", "1 = 1 && true");

		this.testTransformProgram("Integer x := 1\nx := 0\n_assert x = 1\n", "0 = 1 && true");

		expected = AstNodeCreatorHelper.createConjunction(
		                AstNodeCreatorHelper.createImplication(AstNodeCreatorHelper.createTrueLiteral(),
		                                this.getExpression("false = false && true")),
		                this.getExpression("false = false && true"));
		this.testTransformProgram(
		                "function Boolean f() {\nBoolean fx\n_assert fx = false\nreturn fx\n}\nBoolean x\n_assert x = false\n",
		                expected);

		expected = AstNodeCreatorHelper.createConjunction(
		                AstNodeCreatorHelper.createImplication(AstNodeCreatorHelper.createTrueLiteral(),
		                                this.getExpression("0 = 0 && true")),
		                this.getExpression("0 = 0 && true"));
		this.testTransformProgram(
		                "function Integer f() {\nInteger fx\n_assert fx = 0\nreturn fx\n}\nInteger x\n_assert x = 0\n",
		                expected);

		expected = AstNodeCreatorHelper.createConjunction(
		                AstNodeCreatorHelper.createImplication(AstNodeCreatorHelper.createTrueLiteral(),
		                                this.getExpression("{ } = { } && true")),
		                this.getExpression("{ } = { } && true"));
		this.testTransformProgram(
		                "function Boolean[] f() {\nBoolean[] fx\n_assert fx = { }\nreturn fx\n}\nBoolean[] x\n_assert x = { }\n",
		                expected);

		expected = AstNodeCreatorHelper.createConjunction(
		                AstNodeCreatorHelper.createImplication(AstNodeCreatorHelper.createTrueLiteral(),
		                                this.getExpression("{ } = { } && true")),
		                this.getExpression("{ } = { } && true"));
		this.testTransformProgram(
		                "function Integer[] f() {\nInteger[] fx\n_assert fx = { }\nreturn fx\n}\nInteger[] x\n_assert x = { }\n",
		                expected);
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

	/**
	 * Test the transformation of {@link Assumption}s.
	 */
	@Test
	public void assumptionRule() {
		Program p = this.getProgram("Integer x := 1\n_assume x = 0\n_assert x = 10\n");
		Expression result = this.transformer.transformProgram(p);

		// getExpression cannot be used to build expected because `=>' is no valid Worthwhile operator
		Implication expected = AstFactory.init().createImplication();
		expected.setLeft(this.getExpression("1 = 0"));
		expected.setRight(this.getExpression("1 = 10 && true"));

		assertASTNodeEqual(expected, result);
	}

	/**
	 * Test the transformation of {@link Axiom}s.
	 */
	@Test
	public void axiomRule() {
		Program p = this.getProgram("_axiom forall Integer a forall Integer b : a * b = b * a\nInteger x := 2 * 3\n_assert x = 3 * 2\n");
		Expression result = this.transformer.transformProgram(p);

		Implication expected = AstFactory.init().createImplication();
		expected.setLeft(this.getExpression("forall Integer a forall Integer b : a * b = b * a"));
		expected.setRight(this.getExpression("2 * 3 = 3 * 2 && true"));

		assertASTNodeEqual(expected, result);
	}

	/**
	 * Tests the transformation of {@link Loop}s.
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

		String expectedResultString = "(((0 <= 42) " +
				// condition true implies weakest block precondition
				"&& forall Integer n : forall Integer t : (((t < n) && (t <= n)) => " +
				"((t + 1) <= n))) " +
				// condition not true implies postcondition
				"&& forall Integer n : forall Integer t : ((!(t < n) && (t <= n)) => " +
				"((t = n) && true)))";
		String resultString = AstNodeToStringHelper.toString(result);

		Assert.assertEquals(expectedResultString, resultString);
	}

	/**
	 * Test the transformation of {@link FunctionDeclaration}s.
	 */
	@Test
	public void functionDeclarationRule() {
		Program p = this.getProgram("function Integer max(Integer a, Integer b)\n"
		                + "_ensures _return = a || _return = b\n_ensures _return >= a && _return >= b\n"
		                + "{\nif (a > b) {\nreturn a\n}\nreturn b\n}\n");
		Expression result = this.transformer.transformProgram(p);

		// some implications are specified as conjunctions because they cannot be parsed
		Expression expected = this.getExpression("(forall Integer b : forall Integer a : true && "
		                + "(((a > b) && ((a = a || a = b) && (a >= a && a >= b))) "
		                + "&& (!(a > b) && true))) && true");

		Assert.assertTrue(expected instanceof Conjunction);
		BinaryExpression binary = (BinaryExpression) expected;
		Assert.assertTrue(binary.getLeft() instanceof QuantifiedExpression);
		QuantifiedExpression quantifier = (QuantifiedExpression) binary.getLeft();
		Assert.assertTrue(quantifier.getExpression() instanceof QuantifiedExpression);
		quantifier = (QuantifiedExpression) quantifier.getExpression();
		Assert.assertTrue(quantifier.getExpression() instanceof Conjunction);

		// the first implication: precondition => wp(body, postcondition)
		binary = (BinaryExpression) quantifier.getExpression();
		Implication implication = model.createImplication();
		Expression left = binary.getLeft();
		binary.setLeft(null);
		implication.setLeft(left);
		Expression right = binary.getRight();
		binary.setRight(null);
		implication.setRight(right);
		quantifier.setExpression(implication);

		Assert.assertTrue(implication.getRight() instanceof Conjunction);
		Conjunction conjunction = (Conjunction) implication.getRight();

		// the second implication: a > b => (a = a || a = b) && (a >= a && a >= b)
		Assert.assertTrue(conjunction.getLeft() instanceof Conjunction);
		binary = (BinaryExpression) conjunction.getLeft();
		implication = model.createImplication();
		left = binary.getLeft();
		binary.setLeft(null);
		implication.setLeft(left);
		right = binary.getRight();
		binary.setRight(null);
		implication.setRight(right);
		conjunction.setLeft(implication);

		// the third implication: !(a > b) => (b = a || b = b) && (b >= a && b >= b)
		Assert.assertTrue(conjunction.getRight() instanceof Conjunction);
		binary = (BinaryExpression) conjunction.getRight();
		implication = model.createImplication();
		left = binary.getLeft();
		binary.setLeft(null);
		implication.setLeft(left);
		right = binary.getRight();
		binary.setRight(null);
		implication.setRight(right);
		conjunction.setRight(implication);

		TransformProgramTest.assertASTNodeEqual(expected, result);
	}
}
