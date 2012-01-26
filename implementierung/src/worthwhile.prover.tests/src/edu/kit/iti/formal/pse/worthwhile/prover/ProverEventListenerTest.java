package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Test the functionality of the event listener mechanism in {@link SpecificationChecker}.
 * 
 * @author Leon Handreke
 */
public class ProverEventListenerTest {
	/**
	 * Test listener that counts the number of times each event was fired.
	 */
	class CountingProverEventListener extends AbstractProverEventListener {
		/**
		 * Counter for how often programVerified was called.
		 */
		private int programVerifiedCounter = 0;

		/**
		 * @return the number of times that programVerified was called
		 */
		public int getProgramVerifiedCounter() {
			return programVerifiedCounter;
		}

		@Override
		public void programVerified(final Program program, final Validity validity,
		                final ProverResult proverResult) {
			this.programVerifiedCounter++;
		}
	}

	/**
	 * Test the functionality of {@link DistributorProverEventListener}.
	 */
	@Test
	public final void testDistributorEventListener() {
		/**
		 * Test-specific event listener class that also checks for validity.
		 */
		class TestDistributorCountingProverEventListener extends CountingProverEventListener {
			@Override
			public void programVerified(final Program program, final Validity validity,
			                final ProverResult proverResult) {
				super.programVerified(program, validity, proverResult);
				Assert.assertEquals(Validity.VALID, validity);
			}
		}
		TestDistributorCountingProverEventListener firstListener = new TestDistributorCountingProverEventListener();
		TestDistributorCountingProverEventListener secondListener = new TestDistributorCountingProverEventListener();

		SpecificationChecker checker = new SpecificationChecker();
		checker.addProverEventListener(firstListener);
		checker.addProverEventListener(secondListener);

		Program p = TestASTProvider.getRootASTNode("Integer i := 0\n_assert i = 0\n");
		checker.checkProgram(p);

		Assert.assertEquals(1, firstListener.getProgramVerifiedCounter());
		Assert.assertEquals(1, secondListener.getProgramVerifiedCounter());

		checker.removeProverEventListener(secondListener);
		checker.checkProgram(p);

		Assert.assertEquals(2, firstListener.getProgramVerifiedCounter());
		Assert.assertEquals(1, secondListener.getProgramVerifiedCounter());
	}
}
