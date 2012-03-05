package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.prover.caller.FormulaSatisfiability;
import edu.kit.iti.formal.pse.worthwhile.prover.caller.Z3Prover;
import edu.kit.iti.formal.pse.worthwhile.prover.transformer.WPStrategy;

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
	 * Tests that the validity UNKNOWN is returned for an unprovable formula.
	 */
	@Test
	public final void testUnknownValidity() {
		Z3Prover prover = new Z3Prover(9001);
		SpecificationChecker checker = new SpecificationChecker(prover);

		// Try to disprove Fermat's last theorem … even Z3 cannot do that
		Program p = TestASTProvider
		                .getRootASTNode("_assert ∀ Integer i ∀ Integer j ∀ Integer k, i > 0 ∧ j > 0 ∧ k > 0 : i ⋅ i ⋅ i + j * j * j ≠ k * k * k\n");
		// if the prover could not be invoked, we know nothing about the validity of the formula
		Assert.assertEquals(Validity.UNKNOWN, checker.checkProgram(p));
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
