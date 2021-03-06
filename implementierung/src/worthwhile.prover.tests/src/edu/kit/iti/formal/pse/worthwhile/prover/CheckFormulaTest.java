/**
 * JUnit TestCases for {@link SpecificationChecker#checkFormula}.
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.prover.caller.Z3Prover;

/**
 * @author fabian
 * 
 */
public final class CheckFormulaTest {
	/**
	 * The {@link SpecificationChecker} to test.
	 */
	private SpecificationChecker checker;

	/**
	 * An empty formula environment.
	 */
	private Map<VariableDeclaration, Value> emptyEnv;

	/**
	 * A formula environment containing only a x assignment.
	 */
	private Map<VariableDeclaration, Value> xEnv;

	/**
	 * A formula environment containing only a y assignment.
	 */
	private Map<VariableDeclaration, Value> yEnv;

	/**
	 * A formula environment containing both a x and a y assignment so that x and y do not equal.
	 */
	private Map<VariableDeclaration, Value> xyEqualEnv;

	/**
	 * A formula environment containing both a x and a y assignment so that x and y do equal.
	 */
	private Map<VariableDeclaration, Value> xyUnequalEnv;

	/**
	 * A list of the environments available for these TestCases.
	 */
	private List<Map<VariableDeclaration, Value>> envs;

	/**
	 * Empty default constructor.
	 */
	public CheckFormulaTest() {
	}

	/**
	 * AssertEquals validity for an {@link Expression} in all available environments.
	 * 
	 * The available environments are defined by {@link initEnvs}.
	 * 
	 * @param expr
	 *                the Expression to be checked for <code>validity</code>
	 * @param validity
	 *                the {@link Validity} <code>expr</code>'s Validity must be equal to for the test to pass
	 */
	void assertEnvIndependentEquals(final Expression expr, final Validity validity) {
		for (Map<VariableDeclaration, Value> env : envs) {
			Validity actual = checker.checkFormula(expr, env);
			Assert.assertEquals(checker.getCheckResult().getOutput(), validity, actual);
		}
	}

	/**
	 * Generates an {@link Expression} from a Worthwhile {@link String}.
	 * 
	 * @param exprString
	 *                the Worthwhile String to be parsed as Expression
	 * @return Expression AST representing <code>exprString</code>
	 */
	Expression getExpression(final String exprString) {
		// x, y and z are the variables used in these TestCases and they have to be declared first
		String program = "Boolean x := false\nBoolean y := false\nBoolean z := false\n_assert " + exprString
		                + "\n";
		Program p = TestASTProvider.getRootASTNode(program);
		Assert.assertNotNull(p);

		// the Expression encoded by exprString was encapsulated in an Assertion for parsing, get it from there
		List<Statement> stmts = p.getMainBlock().getStatements();
		Assert.assertEquals(4, stmts.size());
		Statement s = stmts.get(3);
		Assert.assertTrue(s instanceof Assertion);
		Assertion a = (Assertion) s;

		s = stmts.get(0);
		Assert.assertTrue(s instanceof VariableDeclaration);
		final VariableDeclaration x = (VariableDeclaration) s;

		s = stmts.get(1);
		Assert.assertTrue(s instanceof VariableDeclaration);
		final VariableDeclaration y = (VariableDeclaration) s;

		this.initEnvs(x, y);

		return a.getExpression();
	}

	/**
	 * Initializes a {@link SpecificationChecker}.
	 */
	@Before
	public void initChecker() {
		checker = new SpecificationChecker(new Z3Prover(5000));
	}

	/**
	 * Initializes formula environments.
	 * 
	 * <ul>
	 * <li>empty</li>
	 * <li>Integer x set</li>
	 * <li>Integer y set</li>
	 * <li>Integer x and y set and equal</li>
	 * <li>Integer x and y set and unequal</li>
	 * </ul>
	 * 
	 * @param x
	 *                the environment variable <code>x</code>
	 * @param y
	 *                the environment variable <code>y</code>
	 */
	public void initEnvs(final VariableDeclaration x, final VariableDeclaration y) {
		emptyEnv = new HashMap<VariableDeclaration, Value>();

		xEnv = new HashMap<VariableDeclaration, Value>();
		xEnv.put(x, new BooleanValue(false));

		yEnv = new HashMap<VariableDeclaration, Value>();
		yEnv.put(y, new BooleanValue(false));

		xyEqualEnv = new HashMap<VariableDeclaration, Value>();
		xyEqualEnv.put(x, new BooleanValue(true));
		xyEqualEnv.put(y, new BooleanValue(true));

		xyUnequalEnv = new HashMap<VariableDeclaration, Value>();
		xyUnequalEnv.put(x, new BooleanValue(false));
		xyUnequalEnv.put(y, new BooleanValue(true));

		envs = new ArrayList<Map<VariableDeclaration, Value>>();
		envs.add(emptyEnv);
		envs.add(xEnv);
		envs.add(yEnv);
		envs.add(xyEqualEnv);
		envs.add(xyUnequalEnv);
	}

	/**
	 * Tests validity check of <code>x = x</code>.
	 */
	@Test
	public void equalSameFreeVariable() {
		Expression expr = getExpression("x = x");
		Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, emptyEnv));
		Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xEnv));
		Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, yEnv));
		Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyEqualEnv));
		Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyUnequalEnv));
	}

	/**
	 * Tests validity check of <code>x != x</code>.
	 */
	@Test
	public void unequalSameFreeVariable() {
		Expression expr = getExpression("x != x");
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, emptyEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, yEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyEqualEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyUnequalEnv));
	}

	/**
	 * Tests validity check of <code>x = y</code>.
	 */
	@Test
	public void equalDiffFreeVariable() {
		Expression expr = getExpression("x = y");
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, emptyEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, yEnv));
		Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyEqualEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyUnequalEnv));
	}

	/**
	 * Tests validity check of <code>x != y</code>.
	 */
	@Test
	public void unequalDiffFreeVariable() {
		Expression expr = getExpression("x != y");
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, emptyEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, yEnv));
		Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyEqualEnv));
		Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyUnequalEnv));
	}

	/**
	 * Tests validity check of <code>forall x : x = x and exists x : x = x</code>.
	 */
	@Test
	public void equalSameBoundVariable() {
		Expression expr = getExpression("forall Integer n : n = n");
		assertEnvIndependentEquals(expr, Validity.VALID);

		expr = getExpression("exists Integer n : n = n");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>forall x : x != x and exists x : x != x</code>.
	 */
	@Test
	public void unequalSameBoundVariable() {
		Expression expr = getExpression("forall Integer n : n != n");
		assertEnvIndependentEquals(expr, Validity.INVALID);

		expr = getExpression("exists Integer n : n != n");
		assertEnvIndependentEquals(expr, Validity.INVALID);
	}

	/**
	 * Tests validity check of <code>forall x exists y : x = y and exists x forall y : x = y</code>.
	 */
	@Test
	public void equalDiffBoundVariable() {
		Expression expr = getExpression("forall Integer n exists Integer m : n = m");
		assertEnvIndependentEquals(expr, Validity.VALID);

		expr = getExpression("exists Integer n forall Integer m : n = m");
		assertEnvIndependentEquals(expr, Validity.INVALID);
	}

	/**
	 * Tests validity check of <code>forall x exists y : x != y and exists x forall y : x != y</code>.
	 */
	@Test
	public void unequalDiffBoundVariable() {
		Expression expr = getExpression("forall Integer n exists Integer m : n != m");
		assertEnvIndependentEquals(expr, Validity.VALID);

		expr = getExpression("exists Integer n forall Integer m : n != m");
		assertEnvIndependentEquals(expr, Validity.INVALID);
	}

	/**
	 * Tests validity check of <code>x = y && y = z => x = z</code>.
	 */
	@Test
	public void equalTransitiveFreeVariables() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : forall Boolean o : !(n = m && m = o) || n = o");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x => y = !x || y</code>.
	 */
	@Test
	public void implicationNotOrEquivalence() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : (!n || m) = (!n || m)");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>!(x || y) = !x && !y</code>.
	 */
	@Test
	public void notAndNotOrDeMorganEquivalence() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : !(n || m) = (!n && !m)");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>!(x && y) = !x || !y</code>.
	 */
	@Test
	public void notOrNotAndDeMorganEquivalence() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : !(n && m) = !n || !m");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x && (y || z) = x && y || x && z</code>.
	 */
	@Test
	public void andOrDistributivity() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : forall Boolean o : (n && (m || o)) = (n && m || n && o)");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x || (y && z) = (x || y) && (x || z)</code>.
	 */
	@Test
	public void orAndDistributivity() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : forall Boolean o : (n || (m && o)) = ((n || m) && (n || o))");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x || (y || z) = (x || y) || z</code>.
	 */
	@Test
	public void orAssociativity() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : forall Boolean o : (n || (m || o)) = ((n || m) || o)");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x && (y && z) = (x && y) && z</code>.
	 */
	@Test
	public void andAssociativity() {
		Expression expr = getExpression("forall Boolean n : forall Boolean m : forall Boolean o : (n && (m && o)) = ((n && m) && o)");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x + x = 2 * x</code>.
	 */
	@Test
	public void vectorSpaceNeutralNeutralDistributivity() {
		Expression expr = getExpression("forall Integer n : n + n = 2 * n");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x = x - 1 <=> x + 1 = x</code>.
	 */
	@Test
	public void groupInverseAdditionEqualityTransformation() {
		Expression expr = getExpression("forall Integer n : (n = n - 1) = (n + 1 = n)");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>forall x exists y : y = x + 1</code>.
	 */
	@Test
	public void forallIntegersExistsSuccessor() {
		Expression expr = getExpression("forall Integer n exists Integer m : m = n + 1");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Test if two literally equal arrays compare equal.
	 */
	@Test
	public void testArrayLiteralEquals() {
		Expression expression = this.getExpression("{1, 2, 3} = {1, 2, 3}");
		assertEnvIndependentEquals(expression, Validity.VALID);
	}
	
	/**
	 * Test if two empty arrays compare equal.
	 */
	@Test
	public void testEmptyArrayLiteralEquals() {
		Expression expression = this.getExpression("{} = {}");
		assertEnvIndependentEquals(expression, Validity.VALID);
	}
}
