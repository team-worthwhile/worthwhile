package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

public class Z3ProverCallerTest {

	@Test
	public void test() {
		Expression formula = TestASTProvider.getTestFormula();
		ProverCaller caller = new Z3Prover();
		ProverResult result = caller.checkFormula(formula);
		// the formula is pretty easy and should be satisfiable
		Assert.assertEquals(FormulaSatisfiability.SATISFIABLE, result.getSatisfiability());
	}

}
