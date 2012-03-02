package edu.kit.iti.formal.pse.worthwhile.prover;

import org.junit.Assert;
import org.junit.Test;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeEqualsHelper;

/**
 * Test the correct functionality of {@link SubstitutionVisitor}.
 * 
 * @author Leon Handreke
 */
public class SubstitutionVisitorTest {

	/**
	 * Test if the getSubstitute method returns the correct substitute and creates clones if requested.
	 */
	@Test
	public final void testGetSubstitute() {
		Expression trueLiteral = AstNodeCreatorHelper.createTrueLiteral();
		SubstitutionVisitor<Expression> visitor = new SubstitutionVisitor<Expression>(trueLiteral);
		Assert.assertSame(trueLiteral, visitor.getSubstitute(false));
		Assert.assertNotSame(trueLiteral, visitor.getSubstitute(true));
		assert (AstNodeEqualsHelper.equals(trueLiteral, visitor.getSubstitute(true)));

	}
}
