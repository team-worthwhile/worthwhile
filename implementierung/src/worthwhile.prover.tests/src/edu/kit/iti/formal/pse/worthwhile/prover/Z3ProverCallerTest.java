package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * Test the prover caller and result parser for the prover Z3.
 * 
 * @author Leon Handreke
 */
public final class Z3ProverCallerTest {
	/**
	 * The prover to use for testing.
	 */
	private ProverCaller prover;

	/**
	 * Instantiates the appropriate Z3 prover before every test.
	 */
	@Before
	public void instantiateProverCaller() {
		this.prover = new Z3Prover();
	}

	/**
	 * Test the prover caller with a simple formula containing only literals.
	 * 
	 * @throws ProverCallerException
	 *                 if calling the prover fails
	 */
	@Test
	public void testLiteralFormula() throws ProverCallerException {
		ProverResult result;

		Expression formula = TestASTProvider
		                .parseFormulaString("((!false || ((9 % 4) = 1)) && true) && ((3 + 3) = 6)");
		Assert.assertNotNull(formula);
		ProverCaller caller = new Z3Prover();
		result = caller.checkFormula(formula);
		// the formula is pretty easy and should be satisfiable
		Assert.assertEquals(FormulaSatisfiability.SATISFIABLE, result.getSatisfiability());

		// the same formula again, but negated, so it should not be satisfiable
		formula = TestASTProvider.parseFormulaString("!((!false || ((9 % 4) = 1)) && true) && ((3 + 3) = 6)");
		Assert.assertNotNull(formula);
		result = caller.checkFormula(formula);
		Assert.assertEquals(FormulaSatisfiability.UNSATISFIABLE, result.getSatisfiability());
	}

	/**
	 * Test if two literal integer array compare equal.
	 * @throws ProverCallerException if calling the prover fails
	 */
	@Test
	public void testIntegerArrayEquals() throws ProverCallerException {
		Expression formula = TestASTProvider.parseFormulaString("{1, 2, 3} = {1 + 3 - 2, 2 * 1, 2 + 1}");
		ProverResult result = this.prover.checkFormula(formula);
		Assert.assertEquals(FormulaSatisfiability.SATISFIABLE, result.getSatisfiability());
	}

	/**
	 * Test if two literal boolean arrays compare equal.
	 * @throws ProverCallerException if calling the prover fails
	 */
	@Test
	public void testBooleanArrayEquals() throws ProverCallerException {
		Expression formula = TestASTProvider.parseFormulaString("{true, false} = { true || false, 5 + 1 = 3}");
		ProverResult result = this.prover.checkFormula(formula);
		Assert.assertEquals(FormulaSatisfiability.SATISFIABLE, result.getSatisfiability());
	}
 }
