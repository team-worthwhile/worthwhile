/**
 * JUnit TestCases for {@link SpecificationChecker#checkFormula}.
 */
package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.interpreter.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

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
	private Map<String, Value> emptyEnv;

	/**
	 * A formula environment containing only a x assignment.
	 */
	private Map<String, Value> xEnv;

	/**
	 * A formula environment containing only a y assignment.
	 */
	private Map<String, Value> yEnv;

	/**
	 * A formula environment containing both a x and a y assignment so that x and y do not equal.
	 */
	private Map<String, Value> xyEqualEnv;

	/**
	 * A formula environment containing both a x and a y assignment so that x and y do equal.
	 */
	private Map<String, Value> xyUnequalEnv;

	/**
	 * A list of the environments available for these TestCases.
	 */
	private List<Map<String, Value>> envs;

	/**
	 * Empty default constructor.
	 */
	public CheckFormulaTest() {
	}

	/**
	 * AssertEquals validity for expr in all available environments.
	 * 
	 * The available environments are defined by {@link initEnvs}.
	 * 
	 * @param expr
	 * @param validity
	 */
	void assertEnvIndependentEquals(final Expression expr, final Validity validity) {
		for (Map<String, Value> env : envs) {
			Assert.assertEquals(validity, checker.checkFormula(expr, env));
		}
	}

	/**
	 * Generates an {@link Expression} from a Worthwhile {@link String}.
	 * 
	 * @param exprString
	 * @return {@link Expression} AST representing the exprString
	 */
	Expression getExpression(final String exprString) {
		Expression e = TestASTProvider.parseFormulaString(exprString);
		Assert.assertNotNull(e);
		return e;
	}

	/**
	 * Initializes a {@link SpecificationChecker}.
	 */
	@Before
	public void initChecker() {
		checker = new SpecificationChecker();
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
	 */
	@Before
	public void initEnvs() {
		emptyEnv = new HashMap<String, Value>();

		xEnv = new HashMap<String, Value>();
		xEnv.put("x", new Value());
		yEnv = new HashMap<String, Value>();
		yEnv.put("y", new Value());

		xyEqualEnv = new HashMap<String, Value>();
		xyEqualEnv.putAll(xEnv);
		xyEqualEnv.putAll(yEnv);

		xyUnequalEnv = new HashMap<String, Value>();
		xyUnequalEnv.putAll(xEnv);
		xyUnequalEnv.putAll(yEnv);

		envs = new ArrayList<Map<String, Value>>();
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
	 * Tests validity check of <code>\forall x : x = x and \exists x : x = x</code>.
	 */
	@Test
	public void equalSameBoundVariable() {
		Expression expr = getExpression("\\forall Integer x : x = x");
		assertEnvIndependentEquals(expr, Validity.VALID);

		expr = getExpression("\\exists Integer x : x = x");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>\forall x : x != x and \exists x : x != x</code>.
	 */
	@Test
	public void unequalSameBoundVariable() {
		Expression expr = getExpression("\\forall Integer x : x != x");
		assertEnvIndependentEquals(expr, Validity.INVALID);

		expr = getExpression("\\exists Integer x : x != x");
		assertEnvIndependentEquals(expr, Validity.INVALID);
	}

	/**
	 * Tests validity check of <code>\forall x \exists y : x = y and \exists x \forall y : x = y</code>.
	 */
	@Test
	public void equalDiffBoundVariable() {
		Expression expr = getExpression("\\forall Integer x \\exists Integer y : x = y");
		assertEnvIndependentEquals(expr, Validity.VALID);

		expr = getExpression("\\exists Integer x \\forall Integer y : x = y");
		assertEnvIndependentEquals(expr, Validity.INVALID);
	}

	/**
	 * Tests validity check of <code>\forall x \exists y : x != y and \exists x \forall y : x != y</code>.
	 */
	@Test
	public void unequalDiffBoundVariable() {
		Expression expr = getExpression("\\forall Integer x \\exists Integer y : x != y");
		assertEnvIndependentEquals(expr, Validity.VALID);

		expr = getExpression("\\exists Integer x \\forall Integer y : x != y");
		assertEnvIndependentEquals(expr, Validity.INVALID);
	}

	/**
	 * Tests validity check of <code>x = y && y = z => x = z</code>.
	 */
	@Test
	public void equalTransitiveFreeVariables() {
		Expression expr = getExpression("x = y && y = z => x = z");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x => y = !x || y</code>.
	 */
	@Test
	public void implicationNotOrEquivalence() {
		Expression expr = getExpression("x => y = !x || y");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>!(x || y) = !x && !y</code>.
	 */
	@Test
	public void notAndNotOrDeMorganEquivalence() {
		Expression expr = getExpression("!(x || y) = !x && !y");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>!(x && y) = !x || !y</code>.
	 */
	@Test
	public void notOrNotAndDeMorganEquivalence() {
		Expression expr = getExpression("!(x && y) = !x || !y");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x && (y || z) = x && y || x && z</code>.
	 */
	@Test
	public void andOrDistributivity() {
		Expression expr = getExpression("x && (y || z) = x && y || x && z");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x || (y && z) = (x || y) && (x || z)</code>.
	 */
	@Test
	public void orAndDistributivity() {
		Expression expr = getExpression("x || (y && z) = (x || y) && (x || z)");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x || (y || z) = (x || y) || z</code>.
	 */
	@Test
	public void orAssociativity() {
		Expression expr = getExpression("x || (y || z) = (x || y) || z");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x && (y && z) = (x && y) && z</code>.
	 */
	@Test
	public void andAssociativity() {
		Expression expr = getExpression("x && (y && z) = (x && y) && z");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x + x = 2 * x</code>.
	 */
	@Test
	public void vectorSpaceNeutralNeutralDistributivity() {
		Expression expr = getExpression("x + x = 2 * x");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>x = x - 1 <=> x + 1 = x</code>.
	 */
	@Test
	public void groupInverseAdditionEqualityTransformation() {
		Expression expr = getExpression("x = x - 1 <=> x + 1 = x");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}

	/**
	 * Tests validity check of <code>\forall x \exists y : y = x + 1</code>.
	 */
	@Test
	public void forallIntegersExistsSuccessor() {
		Expression expr = getExpression("\\forall Integer x \\exists Integer y : y = x + 1");
		assertEnvIndependentEquals(expr, Validity.VALID);
	}
}
