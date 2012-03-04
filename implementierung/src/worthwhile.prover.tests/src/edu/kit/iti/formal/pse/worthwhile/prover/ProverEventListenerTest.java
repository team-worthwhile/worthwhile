package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
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
		public void programVerified(final Program program, final Validity validity, final Expression formula,
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
			                final Expression formula, final ProverResult proverResult) {
				super.programVerified(program, validity, formula, proverResult);
				Assert.assertEquals(Validity.VALID, validity);
			}
		}
		TestDistributorCountingProverEventListener firstListener = new TestDistributorCountingProverEventListener();
		TestDistributorCountingProverEventListener secondListener = new TestDistributorCountingProverEventListener();

		SpecificationChecker checker = new SpecificationChecker(new Z3Prover(5000));
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

	@Test
	public final void testDivisorNotZeroVerified() {
		/**
		 * Test-specific event listener class that also checks whether the supplied statement is the correct one.
		 */
		class TestDistributorCountingProverEventListener extends CountingProverEventListener {
			
			public boolean checked = false;
			
			@Override
			public void divisorNotZeroVerified(final Expression divisor, final Validity validity,
			                final Expression formula, final ProverResult proverResult) {

				this.checked = true;
				Assert.assertTrue(divisor instanceof IntegerLiteral);
			}
		}
		
		TestDistributorCountingProverEventListener listener = new TestDistributorCountingProverEventListener();

		SpecificationChecker checker = new SpecificationChecker(new Z3Prover(5000));
		checker.addProverEventListener(listener);
		
		Program p = TestASTProvider.getRootASTNode("Integer i := 2/2\n");
		checker.checkProgram(p);

		Assert.assertEquals(true, listener.checked);
	}
	
	@Test
	public final void testFunctionCallPreconditionValidVerified() {
		/**
		 * Test-specific event listener class
		 */
		class TestDistributorCountingProverEventListener extends CountingProverEventListener {
			
			public boolean checked = false;
			
			@Override
			public void functionCallPreconditionValidVerified(final FunctionCall functionCall, final Validity validity,
			                final Expression formula, final ProverResult proverResult) {

				this.checked = true;
			}
		}
		
		TestDistributorCountingProverEventListener listener = new TestDistributorCountingProverEventListener();

		SpecificationChecker checker = new SpecificationChecker(new Z3Prover(5000));
		checker.addProverEventListener(listener);
		
		Program p = TestASTProvider.getRootASTNode("function Integer test()\n_requires true\n{return 42\n}\nInteger i := test()\n");
		checker.checkProgram(p);

		Assert.assertEquals(true, listener.checked);
	}
}
