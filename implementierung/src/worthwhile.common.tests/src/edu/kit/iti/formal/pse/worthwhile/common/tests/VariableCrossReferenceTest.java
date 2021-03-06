package edu.kit.iti.formal.pse.worthwhile.common.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * Tests that there exists a cross reference from a {@link VariableReference} to a {@link VariableDeclaration}.
 * 
 * @author fabian
 * 
 */
public final class VariableCrossReferenceTest {

    /**
     * Runs the test.
     */
    @Test
    public void variableCrossReference() {
	Program p = TestASTProvider.getRootASTNode("Integer x := 0\nx := x\n");
	Assert.assertNotNull(p);

	List<Statement> stmts = p.getMainBlock().getStatements();
	Assert.assertEquals(2, stmts.size());

	Assert.assertTrue(stmts.get(1) instanceof Assignment);
	Assignment a = (Assignment) stmts.get(1);

	VariableReference v = a.getVariable();
	Assert.assertNotNull(v);
	Assert.assertNotNull(v.getVariable());
    }

}
