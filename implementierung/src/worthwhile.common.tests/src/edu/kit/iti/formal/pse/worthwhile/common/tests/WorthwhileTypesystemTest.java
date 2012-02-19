package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.typesystem.WorthwhileTypesystem;

/**
 * Test cases for the {@link WorthwhileTypesystem}.
 * 
 * @author fabian
 * 
 */
public final class WorthwhileTypesystemTest {
	/**
	 * The {@link WorthwhileTypesystem} that is tested.
	 */
	private final WorthwhileTypesystem typesystem = new WorthwhileTypesystem();

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link Equal}s.
	 * 
	 * @param formula
	 *                <code>Expression</code> {@link String} containing a single <code>Equal</code>
	 *                <code>Expression</code> where the left operand is an {@link ArrayLiteral}
	 * @param type
	 *                the expected {@link Type} of the <code>ArrayLiteral</code> occurrence
	 */
	private void testTypeofEmptyArrayLiteralEqual(final String formula, final Class<? extends Type> type) {
		final Equal equal = (Equal) TestASTProvider.parseFormulaString(formula);
		final ArrayLiteral arrayLiteral = (ArrayLiteral) equal.getRight();
		final ArrayType arrayType = (ArrayType) typesystem.typeof(arrayLiteral);
		Assert.assertTrue(type.isInstance(arrayType.getBaseType()));
	}

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link Equal}s.
	 */
	@Test
	public void typeofEmptyArrayLiteralEqual() {
		this.testTypeofEmptyArrayLiteralEqual("{ false } = { }", BooleanType.class);
		this.testTypeofEmptyArrayLiteralEqual("{ 0 } = { }", IntegerType.class);
		// ArrayLiterals here have implementation defined but equal base types, no necessary type association is
		// possible but it is sufficient to associate any base type to both of them
		this.testTypeofEmptyArrayLiteralEqual("{ } = { }", BooleanType.class);
	}

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link VariableDeclaration}s.
	 * 
	 * @param source
	 *                {@link Program} {@link String} containing a single <code>VariableDeclaration</code>
	 *                <code>Statement</code> where the value is an {@link ArrayLiteral}
	 * @param type
	 *                the expected {@link Type} of the <code>ArrayLiteral</code> occurrence
	 */
	private void testTypeofEmptyArrayLiteralVariableDeclaration(final String source,
	                final Class<? extends Type> type) {
		final Program program = TestASTProvider.getRootASTNode(source);
		final VariableDeclaration declaration = (VariableDeclaration) program.getMainBlock().getStatements()
		                .get(0);
		final ArrayLiteral arrayLiteral = (ArrayLiteral) declaration.getInitialValue();
		final ArrayType arrayType = (ArrayType) typesystem.typeof(arrayLiteral);
		Assert.assertTrue(type.isInstance(arrayType.getBaseType()));
	}

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link VariableDeclaration}s.
	 */
	@Test
	public void typeofEmptyArrayLiteralVariableDeclaration() {
		this.testTypeofEmptyArrayLiteralVariableDeclaration("Boolean[] a := { }\n", BooleanType.class);
		this.testTypeofEmptyArrayLiteralVariableDeclaration("Integer[] a := { }\n", IntegerType.class);
	}

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link Assignment}s.
	 * 
	 * @param source
	 *                {@link Program} {@link String} containing a single {@link VariableDeclaration} and
	 *                <code>Assignment</code> <code>Statement</code> where the value is an {@link ArrayLiteral}
	 * @param type
	 *                the expected {@link Type} of the <code>ArrayLiteral</code> occurrence
	 */
	public void testTypeofEmptyArrayLiteralAssignment(final String source, final Class<? extends Type> type) {
		final Program program = TestASTProvider.getRootASTNode(source);
		final Assignment assignment = (Assignment) program.getMainBlock().getStatements().get(1);
		final ArrayLiteral arrayLiteral = (ArrayLiteral) assignment.getValue();
		final ArrayType arrayType = (ArrayType) typesystem.typeof(arrayLiteral);
		Assert.assertTrue(typesystem.isInstanceOf(arrayType.getBaseType(), AstFactory.eINSTANCE.getAstPackage().getBooleanType(), new TypeCalculationTrace()));
		//Assert.assertTrue(type.isInstance(arrayType.getBaseType()));
	}

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link Assignment}s.
	 */
	@Test
	public void typeofEmptyArrayLiteralAssignment() {
		this.testTypeofEmptyArrayLiteralAssignment("Boolean[] a\na := { }\n", BooleanType.class);
		//this.testTypeofEmptyArrayLiteralAssignment("Integer[] a\na := { }\n", IntegerType.class);
	}

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link FunctionCall}s.
	 * 
	 * @param source
	 *                {@link Program} {@link String} containing a single {@link VariableDeclaration}
	 *                <code>Statement</code> where the value is an <code>FunctionCall</code> with the first actual
	 *                being an {@link ArrayLiteral}
	 * @param type
	 *                the expected {@link Type} of the <code>ArrayLiteral</code> occurrence
	 */
	private void testTypeofEmptyArrayLiteralFunctionCall(final String source, final Class<? extends Type> type) {
		final Program program = TestASTProvider.getRootASTNode(source);
		final VariableDeclaration declaration = (VariableDeclaration) program.getMainBlock().getStatements()
		                .get(0);
		final FunctionCall call = (FunctionCall) declaration.getInitialValue();
		final ArrayLiteral arrayLiteral = (ArrayLiteral) call.getActuals().get(0);
		final ArrayType arrayType = (ArrayType) typesystem.typeof(arrayLiteral);
		Assert.assertTrue(type.isInstance(arrayType.getBaseType()));
	}

	/**
	 * Tests the type assigned to empty {@link ArrayLiteral}s in {@link FunctionCall}s.
	 */
	@Test
	public void typeofEmptyArrayLiteralFunctionCall() {
		this.testTypeofEmptyArrayLiteralFunctionCall(
		                "function Boolean f(Boolean[] a) {\nreturn false\n}\nBoolean v := f({ })\n",
		                BooleanType.class);
		this.testTypeofEmptyArrayLiteralFunctionCall(
		                "function Integer f(Integer[] a) {\nreturn 0\n}\nInteger v := f({ })\n",
		                IntegerType.class);
	}
	
	/**
	 * Tests that an empty array literal cannot be assigned to a scalar variable.
	 * @throws IOException when the test program fails to load
	 */
	@Test
	public void testEmptyArrayLiteralToScalarAssignment() throws IOException {
		String testProgram = TestUtils.loadTestProgram(this.getClass(), "test-validation-emptyarrayliteral.ww");
		TestUtils.assertErrorCountEquals(4, TestASTProvider.loadProgram(testProgram));
	}
}
