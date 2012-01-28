package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;

/**
 * Tests {@link Interpreter#evaluateExpression(edu.kit.iti.formal.pse.worthwhile.model.ast.Expression).
 * 
 * @author fabian
 * 
 */
public final class EvaluateExpressionTest {
	/**
	 * Contains a loop that increments an Integer variable i, which is initialized to zero, ten times.
	 */
	private Program testProgram;

	/**
	 * The {@link Interpreter} executing the {@link testProgram}.
	 */
	private Interpreter interpreter;

	/**
	 * A reference to the Integer variable i in the {@link testProgram}.
	 */
	private VariableReference iVariableReference;

	/**
	 * Parses the source code to the {@link testProgram} and creates the {@link iVariableReference}.
	 */
	@Before
	public void setup() {
		this.testProgram = TestASTProvider.getRootASTNode("Integer i := 0\nwhile i < 10 {\n"
		                + "i := i + 1\n}\n");
		final VariableDeclaration i = (VariableDeclaration) this.testProgram.getMainBlock().getStatements()
		                .get(0);
		this.iVariableReference = AstFactory.init().createVariableReference();
		this.iVariableReference.setVariable(i);
	}

	/**
	 * Registers the given {@link AbstractExecutionEventListener} with the {@link interpreter} and executes the
	 * {@link testProgram}.
	 * 
	 * @param listener
	 *                the <code>AbstractExecutionEventListener</code> to register with the <code>interpreter</code>
	 *                before execution
	 */
	private void interpretTestProgramWithListener(final AbstractExecutionEventListener listener) {
		this.interpreter = new Interpreter(this.testProgram, new SpecificationChecker());
		this.interpreter.addExecutionEventHandler(listener);
		this.interpreter.execute();
	}

	/**
	 * Evaluates the {@link iVariableReference} and checks whether it was incremented after each loop body
	 * execution.
	 */
	@Test
	public void testEqualsIncrementAfterAssignment() {
		final AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			/**
			 * The expected value for the {@link iVariableReference}.
			 */
			private BigInteger iExpectedValue = BigInteger.ZERO;

			@Override
			public void statementExecuted(final Statement statement) {
				if (statement instanceof Assignment) {
					final Value v = EvaluateExpressionTest.this.interpreter
					                .evaluateExpression(EvaluateExpressionTest.this.iVariableReference);

					this.iExpectedValue = this.iExpectedValue.add(BigInteger.ONE);

					Assert.assertEquals(IntegerValue.class, v.getClass());
					Assert.assertEquals(this.iExpectedValue, ((IntegerValue) v).getValue());
				}
			}
		};

		this.interpretTestProgramWithListener(listener);
	}

	/**
	 * Evaluates the attribute <code>forall Integer j : j >= 10 => j > i</code> and checks whether it holds after
	 * each loop body execution.
	 */
	@Test
	public void testHasGreaterTenAttribute() {
		final QuantifiedExpression iTenAttribute = (QuantifiedExpression) TestASTProvider
		                .parseFormulaString("forall Integer j , j > 10 : true");
		final Less less = AstFactory.init().createLess();
		final VariableReference j = AstFactory.init().createVariableReference();
		j.setVariable(iTenAttribute.getParameter());
		less.setLeft(AstNodeCloneHelper.clone(this.iVariableReference));
		less.setRight(j);
		iTenAttribute.setExpression(less);

		final AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			@Override
			public void statementExecuted(final Statement statement) {
				if (statement instanceof Assignment) {
					final Value v = EvaluateExpressionTest.this.interpreter
					                .evaluateExpression(iTenAttribute);

					Assert.assertEquals(BooleanValue.class, v.getClass());
					Assert.assertEquals(true, ((BooleanValue) v).getValue());
				}
			}
		};

		this.interpretTestProgramWithListener(listener);
	}

	/**
	 * Evaluates the attribute <code>forall Integer j : j >= 9 => j > i</code> after each loop body execution.
	 */
	@Test
	public void testNotHaveGreaterZeroAttribute() {
		final QuantifiedExpression iZeroAttribute = (QuantifiedExpression) TestASTProvider
		                .parseFormulaString("forall Integer j , j > 0 : true");
		final Less less = AstFactory.init().createLess();
		final VariableReference j = AstFactory.init().createVariableReference();
		j.setVariable(iZeroAttribute.getParameter());
		less.setLeft(AstNodeCloneHelper.clone(this.iVariableReference));
		less.setRight(j);
		iZeroAttribute.setExpression(less);

		final AbstractExecutionEventListener listener = new AbstractExecutionEventListener() {
			@Override
			public void statementExecuted(final Statement statement) {
				if (statement instanceof Assignment) {
					final Value v = interpreter.evaluateExpression(iZeroAttribute);

					Assert.assertEquals(BooleanValue.class, v.getClass());
					Assert.assertEquals(false, ((BooleanValue) v).getValue());
				}
			}
		};

		this.interpretTestProgramWithListener(listener);
	}
}
