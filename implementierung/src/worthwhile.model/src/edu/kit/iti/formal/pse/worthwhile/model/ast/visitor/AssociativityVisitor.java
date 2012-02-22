/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;

/**
 * Returns whether the law of associativity holds for an operator.
 * 
 * @author Joachim
 * 
 */
public class AssociativityVisitor extends ASTNodeReturnVisitor<Boolean> {

	@Override
	public final void defaultOperation(final ASTNode node) {
		this.setReturnValue(true);
	}

	@Override
        public final void visit(final Division node) {
		this.setReturnValue(false);
	}

	@Override
        public final void visit(final Equivalence node) {
		this.setReturnValue(false);
	}

	@Override
        public final void visit(final Implication node) {
		this.setReturnValue(false);
	}

	@Override
        public final void visit(final Modulus node) {
		this.setReturnValue(false);
	}

	@Override
        public final void visit(final Subtraction node) {
		this.setReturnValue(false);
	}

	@Override
        public final void visit(final Unequal node) {
		this.setReturnValue(false);
	}

}
