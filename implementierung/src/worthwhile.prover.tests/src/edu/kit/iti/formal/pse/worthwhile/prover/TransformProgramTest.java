package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
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
	 * Tests the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment}s.
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
	 * Tests the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional}s.
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
		implication.setRight(this.getExpression("1 = 0 && true"));
		expected.setRight(implication);

		assertASTNodeEqual(expected, result);
	}

	/**
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption}s.
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
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom}s.
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

		QuantifiedExpression q;
		BinaryExpression o;

		// we cannot parse implications so replace the conjunction by an implication later
		q = (QuantifiedExpression) this.getExpression("forall Integer t :"
		                + "(t = 0 || t = 1) && (t = 0 && -1 = 1 || t = 1 && -1 = 0)");
		o = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o.getLeft(), o.getRight()));

		o = (BinaryExpression) this.getExpression("(2 = 0 || 2 = 1) && (forall Integer _f0 :"
		                + "(((2 = 0 && _f0 = 1) || (2 = 1 && _f0 = 0)) && true))");

		final Expression expected = AstNodeCreatorHelper.createConjunction(q, o);

		q = (QuantifiedExpression) o.getRight();
		o = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o.getLeft(), o.getRight()));

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

		QuantifiedExpression q;
		BinaryExpression o, o1, o2;

		// we cannot parse implications so replace the conjunction by an implication later
		q = (QuantifiedExpression) this.getExpression("forall Integer t :"
		                + "(t = 0 || t = 1) && (t = 0 && -1 = 1 || t = 1 && -1 = 0)");
		o = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o.getLeft(), o.getRight()));

		o = (BinaryExpression) this.getExpression("(2 = 0 || 2 = 1) && (forall Integer _f0 :"
		                + "(((2 = 0 && _f0 = 1) || (2 = 1 && _f0 = 0))"
		                + "&& ((_f0 = -1 && true) && (!(_f0 = -1) && true))))");

		final Expression expected = AstNodeCreatorHelper.createConjunction(q, o);

		q = (QuantifiedExpression) o.getRight();
		o = (BinaryExpression) q.getExpression();
		o1 = (BinaryExpression) o.getRight();
		o2 = (BinaryExpression) o1.getLeft();
		o1.setLeft(AstNodeCreatorHelper.createImplication(o2.getLeft(), o2.getRight()));
		o2 = (BinaryExpression) o1.getRight();
		o1.setRight(AstNodeCreatorHelper.createImplication(o2.getLeft(), o2.getRight()));
		q.setExpression(AstNodeCreatorHelper.createImplication(o.getLeft(), o.getRight()));

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

		QuantifiedExpression q;
		BinaryExpression o, o1, o2;

		// we cannot parse implications so replace the conjunction by an implication later
		q = (QuantifiedExpression) this.getExpression("forall Integer t : (t = 0 || t = 1) &&"
		                + "(t = 0 && -1 = 1 || t = 1 && -1 = 0)");
		o = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o.getLeft(), o.getRight()));

		o = (BinaryExpression) this.getExpression("(2 = 0 || 2 = 1)" + "&& (forall Integer _f0 :"
		                + "((2 = 0 && _f0 = 1) || (2 = 1 && _f0 = 0)) &&"
		                + "(((2 = 0 || 2 = 1) && (forall Integer _f1 :"
		                + "(((2 = 0 && _f1 = 1) || (2 = 1 && _f1 = 0)) &&"
		                + "((_f1 = -1) && (forall Integer _f1 : (forall Integer _f0 :"
		                + "(_f0 = -1 && _f1 = -1) && _f1 = -1)) && (forall Integer _f1 :"
		                + "(forall Integer _f0 :" + "(!(_f0 = -1) && _f1 = -1) && true))))))))");

		final Expression expected = AstNodeCreatorHelper.createConjunction(q, o);

		q = (QuantifiedExpression) o.getRight();
		o = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o.getLeft(), o.getRight()));

		q = (QuantifiedExpression) ((BinaryExpression) ((BinaryExpression) q.getExpression()).getRight())
		                .getRight();
		o = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o.getLeft(), o.getRight()));

		o = (BinaryExpression) ((BinaryExpression) q.getExpression()).getRight();
		o1 = (BinaryExpression) o.getLeft();

		q = (QuantifiedExpression) ((QuantifiedExpression) o1.getRight()).getExpression();
		o2 = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o2.getLeft(), o2.getRight()));

		q = (QuantifiedExpression) ((QuantifiedExpression) o.getRight()).getExpression();
		o2 = (BinaryExpression) q.getExpression();
		q.setExpression(AstNodeCreatorHelper.createImplication(o2.getLeft(), o2.getRight()));

		TransformProgramTest.assertASTNodeEqual(expected, actual);
	}
}
