package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * Test the functionality of {@link SpecificationChecker}.
 * 
 * @author Leon Handreke
 * 
 */
public class SpecificationCheckerTest {

	/**
	 * The {@link SpecificationChecker} to use.
	 */
	private SpecificationChecker checker;

	/**
	 * Instantiate a new {@link SpecificationChecker} for all tests.
	 */
	@Before
	public final void setUpSpecificationChecker() {
		this.checker = new SpecificationChecker();
	}

	/**
	 * Test the checkExpression method by asserting an expression about an environment.
	 */
	@Test
	public final void testEnvironmentAssertion() {
		// construct a new Boolean a
		VariableDeclaration aDeclaration = AstFactory.init().createVariableDeclaration();
		aDeclaration.setName("a");
		aDeclaration.setType(AstFactory.init().createBooleanType());

		// build the expression a = true
		VariableReference aReference = AstFactory.init().createVariableReference();
		aReference.setVariable(aDeclaration);
		BooleanLiteral trueLiteral = AstFactory.init().createBooleanLiteral();
		trueLiteral.setValue(true);
		Equal equal = AstFactory.init().createEqual();
		equal.setLeft(aReference);
		equal.setRight(trueLiteral);

		// build an environment that has a set to true
		Map<VariableDeclaration, Value> environment = new HashMap<VariableDeclaration, Value>();
		Value aValue = new BooleanValue(true);
		environment.put(aDeclaration, aValue);

		// check if the prover verifies the formula
		Validity validity = this.checker.checkFormula(equal, environment);
		Assert.assertEquals(Validity.VALID, validity);
	}

	/**
	 * Test assigning a number to an array at an index and proving that it's there.
	 */
	@Test
	public final void testArrayIndexAssignment() {
		Program p = TestASTProvider
		                .getRootASTNode("Integer[] a := {1, 2, 3}\na[0] := 42\n_assert a[0] = 42 && a[1] = 2 && a[2] = 3\n");
		Validity validity = this.checker.checkProgram(p);
		Assert.assertEquals(Validity.VALID, validity);
	}
}
