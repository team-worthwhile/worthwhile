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
final public class CheckFormulaTest {
    private SpecificationChecker checker;
    private Map<String, Value> emptyEnv;
    private Map<String, Value> xEnv;
    private Map<String, Value> yEnv;
    private Map<String, Value> xyEqualEnv;
    private Map<String, Value> xyUnequalEnv;
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
    void assertEnvIndependentEquals(Expression expr, Validity validity) {
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
    Expression getExpression(String exprString) {
	return TestASTProvider.parseFormulaString(exprString);
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

    @Test
    public void equalSameFreeVariable() {
	Expression expr = getExpression("x = x");
	Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, emptyEnv));
	Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xEnv));
	Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, yEnv));
	Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyEqualEnv));
	Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyUnequalEnv));
    }

    @Test
    public void unequalSameFreeVariable() {
	Expression expr = getExpression("x != x");
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, emptyEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, yEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyEqualEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyUnequalEnv));
    }

    @Test
    public void equalDiffFreeVariable() {
	Expression expr = getExpression("x = y");
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, emptyEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, yEnv));
	Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyEqualEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyUnequalEnv));
    }

    @Test
    public void unequalDiffFreeVariable() {
	Expression expr = getExpression("x != y");
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, emptyEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, yEnv));
	Assert.assertEquals(Validity.INVALID, checker.checkFormula(expr, xyEqualEnv));
	Assert.assertEquals(Validity.VALID, checker.checkFormula(expr, xyUnequalEnv));
    }

    @Test
    public void equalSameBoundVariable() {
	Expression expr = getExpression("\\forall Integer x : x = x");
	assertEnvIndependentEquals(expr, Validity.VALID);

	expr = getExpression("\\exists Integer x : x = x");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void unequalSameBoundVariable() {
	Expression expr = getExpression("\\forall Integer x : x != x");
	assertEnvIndependentEquals(expr, Validity.INVALID);

	expr = getExpression("\\exists Integer x : x != x");
	assertEnvIndependentEquals(expr, Validity.INVALID);
    }

    @Test
    public void equalDiffBoundVariable() {
	Expression expr = getExpression("\\forall Integer x \\exists Integer y : x = y");
	assertEnvIndependentEquals(expr, Validity.VALID);

	expr = getExpression("\\exists Integer x \\forall Integer y : x = y");
	assertEnvIndependentEquals(expr, Validity.INVALID);
    }

    @Test
    public void unequalDiffBoundVariable() {
	Expression expr = getExpression("\\forall Integer x \\exists Integer y : x != y");
	assertEnvIndependentEquals(expr, Validity.VALID);

	expr = getExpression("\\exists Integer x \\forall Integer y : x != y");
	assertEnvIndependentEquals(expr, Validity.INVALID);
    }

    @Test
    public void equalTransitiveFreeVariables() {
	Expression expr = getExpression("x = y && y = z => x = z");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void implicationNotOrEquivalence() {
	Expression expr = getExpression("x => y = !x || y");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void notAndNotOrDeMorganEquivalence() {
	Expression expr = getExpression("!(x || y) = !x && !y");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void notOrNotAndDeMorganEquivalence() {
	Expression expr = getExpression("!(x && y) = !x || !y");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void andOrDistributivity() {
	Expression expr = getExpression("x && (y || z) = x && y || x && z");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void orAndDistributivity() {
	Expression expr = getExpression("x || (y && z) = (x || y) && (x || z)");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void orAssociativity() {
	Expression expr = getExpression("x || (y || z) = (x || y) || z");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void andAssociativity() {
	Expression expr = getExpression("x && (y && z) = (x && y) && z");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void vectorSpaceNeutralNeutralDistributivity() {
	Expression expr = getExpression("x + x = 2 * x");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void groupInverseAdditionEqualityTransformation() {
	Expression expr = getExpression("x = x - 1 <=> x + 1 = x");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }

    @Test
    public void forallIntegersExistsSuccessor() {
	Expression expr = getExpression("\\forall Integer x \\exists Integer y : y = x + 1");
	assertEnvIndependentEquals(expr, Validity.VALID);
    }
}
