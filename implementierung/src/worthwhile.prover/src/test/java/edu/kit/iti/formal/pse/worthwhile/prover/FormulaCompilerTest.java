package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.tests.SimpleTestASTProvider;

public class FormulaCompilerTest {

	private FormulaCompiler compiler;

	@Before
	public void setUp() {
		this.compiler = new SMTLIBStrategy();
	}


	@Test
	public void testSimpleTrueFormulaCompilation() {
		Expression formula = SimpleTestASTProvider.getSimpleTrueFormula();
		Assert.assertNotNull(formula);
		System.out.println("Troll");
		String s = this.compiler.compileFormula(formula);
		Assert.assertNotNull(s);
	}

}
