package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeEqualsHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeToStringHelper;
import edu.kit.iti.formal.pse.worthwhile.prover.transformer.FormulaGenerator;
import edu.kit.iti.formal.pse.worthwhile.prover.transformer.Proof;
import edu.kit.iti.formal.pse.worthwhile.prover.transformer.ProofImplication;
import edu.kit.iti.formal.pse.worthwhile.prover.transformer.WPStrategy;

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
	 * Parse the given program string, transform it using the calculus implemented by transformer and compare the
	 * formula calculated to prove that the whole program conforms to the specification with the given expected
	 * expression.
	 * 
	 * <code>expected</code> is parsed before the resulting {@link Expression} is compared to the actual result
	 * produced by the program transformer to be tested.
	 * 
	 * @param program
	 *                the program to parse and transform
	 * @param expected
	 *                the expected expression to parse and to prove the whole program conform
	 */
	private void testTransformProgram(final String program, final String expected) {
		final Expression e = this.getExpression(expected);
		final Program p = this.getProgram(program);
		p.accept(new ImplicitInitialValueInserter());
		p.accept(new ArrayFunctionInserter());
		p.accept(new FunctionCallPreconditionInserter());
		p.accept(new MacroSubstitution());
		p.accept(new FunctionCallSubstitution());
		// find the expression expressing the validity of the whole program
		for (Proof proof : this.transformer.transformProgram(p)) {
			if (proof.getImplication() == ProofImplication.PROGRAM_CONFORM) {
				TransformProgramTest.assertASTNodeEqual(e, proof.getExpression());
				return;
			}
		}
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
		this.testTransformProgram("Integer x := 1\n_assert x = 1\n", "true && 1 = 1");

		this.testTransformProgram("Integer x := 1\nx := 0\n_assert x = 1\n", "true && 0 = 1");

		this.testTransformProgram(
		                "function Boolean f() {\nBoolean fx\n_assert fx = false\nreturn fx\n}\nBoolean x\n_assert x = false\n",
		                "(true => true)"
		                + "&& (true => false = false)"
		                + "&& true"
		                + "&& (false = false)");

		this.testTransformProgram(
		                "function Integer f() {\nInteger fx\n_assert fx = 0\nreturn fx\n}\nInteger x\n_assert x = 0\n",
		                "(true => true)"
		                + "&& (true => 0 = 0)"
		                + "&& true"
		                + "&& 0 = 0");
	}

	/**
	 * Tests the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional}s.
	 */
	@Test
	public void conditionalRule() {
		this.testTransformProgram("Integer x := 1\nif x = 1 {\nx := 0\n}\n_assert x = 0\n",
		                "(1 = 1 => true)"
		                + "&& (1 = 1 => 0 = 0)"
		                + "&& (!(1 = 1) => true)"
		                + "&& (!(1 = 1) => 1 = 0)");
	}

	/**
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption}s.
	 */
	@Test
	public void assumptionRule() {
		this.testTransformProgram("Integer x := 1\n_assume x = 0\n_assert x = 10\n",
		                "(1 = 0 => true)"
		                + "&& (1 = 0 => 1 = 10)");
	}

	/**
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom}s.
	 */
	@Test
	public void axiomRule() {
		this.testTransformProgram(
		                "_axiom forall Integer a forall Integer b : a * b = b * a\nInteger x := 2 * 3\n_assert x = 3 * 2\n",
		                "((forall Integer a forall Integer b : a * b = b * a) => true)"
		                + "&& ((forall Integer a forall Integer b : a * b = b * a) => 2 * 3 = 3 * 2)");
	}

	/**
	 * Tests the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Loop}s.
	 */
	@Test
	public void loopRule() {
		// from http://wiki.pse.ndreke.de/test_zaehlvariable
		String programString = "Integer n := 42\n" + "Integer t := 0\n" + "while t < n _invariant t <=n\n"
		                + "{\n" + "    t := t + 1\n" + "}\n" + "_assert t = n\n";

		String expectedResultString = "0 <= 42 "
		                // condition true implies weakest block precondition
		                + "&& (forall Integer t : t < 42 && t <= 42 => t + 1 <= 42) "
		                // condition not true implies postcondition
		                + "&& (forall Integer t : !(t < 42) && t <= 42 => true)"
		                + "&& (forall Integer t : !(t < 42) && t <= 42 => t = 42)";

		this.testTransformProgram(programString, expectedResultString);
	}

	/**
	 * Test the transformation of {@link edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration}s.
	 */
	@Test
	public void functionDeclarationRule() {
		this.testTransformProgram("function Integer max(Integer a, Integer b)\n"
		                + "_ensures _return = a || _return = b\n_ensures _return >= a && _return >= b\n"
		                + "{\nif (a > b) {\nreturn a\n}\nreturn b\n}\n",
		                "(forall Integer b : forall Integer a : true => (a > b => a = a || a = b))"
		                + "&& (forall Integer b : forall Integer a : true => (a > b => a >= a && a >= b)) "
		                + "&& (forall Integer b : forall Integer a : true => (!(a > b) => b = a || b = b))"
		                + "&& (forall Integer b : forall Integer a : true => (!(a > b) => b >= a && b >= b))"
		                + "&& true");

	}

	/**
	 * Tests the transformation of {@link FunctionCalls} in initial value {@link Expression}s.
	 */
	@Test
	public void variableDeclarationFunctionCallRule() {
		this.testTransformProgram("function Integer f(Integer t)\n" + "_requires t = 0 || t = 1\n"
		                + "_ensures (t = 0 && _return = 1) || (t = 1 && _return = 0)\n" + "{\n"
		                + "    return -1\n" + "}\n" + "Integer v := f(2)\n",
		                "(forall Integer t : t = 0 || t = 1 => t = 0 && -1 = 1 || t = 1 && -1 = 0)"
		                + "&& (forall Integer $f@7@14 : 2 = 0 && $f@7@14 = 1 || 2 = 1 && $f@7@14 = 0 => true)"
		                + "&& (2 = 0 || 2 = 1)");
	}

	/**
	 * Tests the transformation of {@link FunctionCalls} in conditional condition {@link Expression}s.
	 */
	@Test
	public void conditionalFunctionCallRule() {
		this.testTransformProgram("function Integer f(Integer t)\n" + "_requires t = 0 || t = 1\n"
		                + "_ensures (t = 0 && _return = 1) || (t = 1 && _return = 0)\n" + "{\n"
		                + "    return -1\n" + "}\n" + "if f(2) = -1 {\n}\n",
		                "(forall Integer t : t = 0 || t = 1 => t = 0 && -1 = 1 || t = 1 && -1 = 0)"
		                + "&& (forall Integer $f@7@4 : 2 = 0 && $f@7@4 = 1 || 2 = 1 && $f@7@4 = 0 => ($f@7@4 = -1 => true))"
		                + "&& (forall Integer $f@7@4 : 2 = 0 && $f@7@4 = 1 || 2 = 1 && $f@7@4 = 0 => (!($f@7@4 = -1) => true))"
		                + "&& (2 = 0 || 2 = 1)");
	}

	/**
	 * Tests the transformation of {@link FunctionCalls} in loop condition and invariant {@link Expression}s.
	 */
	@Test
	public void loopFunctionCallRule() {
		this.testTransformProgram(
		                "function Integer f(Integer t)\n" + "_requires t = 0 || t = 1\n"
		                                + "_ensures (t = 0 && _return = 1) || (t = 1 && _return = 0)\n" + "{\n"
		                                + "    return -1\n" + "}\n"
		                                + "while f(2) = -1\n_invariant f(2) = -1\n{\n}\n",
		                "(forall Integer t : (t = 0 || t = 1) => (t = 0 && -1 = 1 || t = 1 && -1 = 0))"
		                                + "&&"
		                                + "(forall Integer $f@7@7 : 2 = 0 && $f@7@7 = 1 || 2 = 1 && $f@7@7 = 0 =>"
		                                + " (forall Integer $f@8@12 : 2 = 0 && $f@8@12 = 1 || 2 = 1 && $f@8@12 = 0 =>"
		                                + "  $f@8@12 = -1))"
		                                + "&&"
		                                + "(forall Integer $f@7@7 : 2 = 0 && $f@7@7 = 1 || 2 = 1 && $f@7@7 = 0 =>"
		                                + " (forall Integer $f@8@12 : 2 = 0 && $f@8@12 = 1 || 2 = 1 && $f@8@12 = 0 =>"
		                                + "  ($f@7@7 = -1 && $f@8@12 = -1 => $f@8@12 = -1)))"
		                                + "&&"
		                                + "(forall Integer $f@7@7 : 2 = 0 && $f@7@7 = 1 || 2 = 1 && $f@7@7 = 0 =>"
		                                + " (forall Integer $f@8@12 : 2 = 0 && $f@8@12 = 1 || 2 = 1 && $f@8@12 = 0 =>"
		                                + "  (!($f@7@7 = -1) && $f@8@12 = -1 => true)))"
		                                + "&&"
		                                + "(2 = 0 || 2 = 1)"
		                                + "&&"
		                                + "(2 = 0 || 2 = 1)");
	}

	/**
	 * Tests the transformation of {@link FunctionCall}s in function contract {@link Precondition}s/
	 * {@link Postcondition}s.
	 */
	@Test
	public void contractFunctionCallRule() {
		this.testTransformProgram("function Integer fiver()\n" + "_ensures _return = 5\n" + "{\n"
		                + "return 5\n" + "}\n" + "function Integer five()\n" + "_ensures _return = fiver()\n"
		                + "{\n" + "return fiver()\n" + "}\n",
		                "(true => 5 = 5)"
		                + "&& (true => 5 = 5)"
		                + "&& true");
	}
}
