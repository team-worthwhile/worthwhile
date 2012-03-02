package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Test the correct behaviour of methods in {@link SpecificationChecker}.
 * 
 * @author Leon Handreke
 */
public class SpecificationCheckerTest {

	/**
	 * Test the handling of an invalid given prover path in {@link SpecificationChecker}.
	 */
	@Test
        public final void testInvalidProverPath() {
		// instantiate a prover with an invalid path
		Z3Prover prover = new Z3Prover("/this/path/should/be/invalid", 5000);
		SpecificationChecker checker = new SpecificationChecker(prover);
		// try to prove a simple true program
		Program p = TestASTProvider.getRootASTNode("_assert true\n");
		// if the prover could not be invoked, we know nothing about the validity of the formula
		Assert.assertEquals(Validity.UNKNOWN, checker.checkProgram(p));
		Assert.assertEquals(FormulaSatisfiability.UNKOWN, checker.getCheckResult().getSatisfiability());
		// we can't really test for any output since it is not defined by SpecificationChecker
	}

	/**
	 * Test if the getters and setters in {@link SpecificationChecker} work.
	 */
	@Test
	public final void testGettersAndSetters() {
		// test the prover getter/setter
		Z3Prover firstProver = new Z3Prover(1);
		Z3Prover secondProver = new Z3Prover(1);

		SpecificationChecker checker = new SpecificationChecker(firstProver);
		Assert.assertSame(firstProver, checker.getProver());
		checker.setProver(secondProver);
		Assert.assertSame(secondProver, checker.getProver());

		// test the transformer getter/setter
		WPStrategy otherTansformer = new WPStrategy();

		Assert.assertNotSame(otherTansformer, checker.getTransformer());
		checker.setTransformer(otherTansformer);
		Assert.assertSame(otherTansformer, checker.getTransformer());
	}

}
