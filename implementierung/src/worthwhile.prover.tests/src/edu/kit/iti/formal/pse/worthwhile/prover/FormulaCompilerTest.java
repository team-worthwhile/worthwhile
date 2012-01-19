package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.common.tests.TestASTProvider;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

public final class FormulaCompilerTest {

	private FormulaCompiler compiler;

	/**
	 * Set up the compiler to test in the tests
	 */
	@Before
	public void setUp() {
		this.compiler = new SMTLIBStrategy();
	}

	@Test
	public void testSimpleTrueFormulaCompilation() {
		Expression formula = TestASTProvider.getTestFormula();
		Assert.assertNotNull(formula);
		String s = this.compiler.compileFormula(formula);
		Assert.assertNotNull(s);
	}

	/**
	 * Test the compilation of a formula with unbound variables
	 */
	@Test
	public void unboundVariable() {
		// construct a basic unbound VariableReference
		VariableDeclaration a = AstFactory.init().createVariableDeclaration();
		a.setName("a");
		a.setType(AstFactory.init().createBooleanType());
		VariableReference aRef = AstFactory.init().createVariableReference();
		aRef.setVariable(a);
		// try to compile it to SMTLIB
		String compiledFormula = compiler.compileFormula(aRef);
		// expect the compiler to declare the variable a before using it
		String expectedCompiledFormula = "(declare-const a Bool)\n" + "(assert a)\n" + "(check-sat)";
		Assert.assertEquals(expectedCompiledFormula, compiledFormula);
	}

}
