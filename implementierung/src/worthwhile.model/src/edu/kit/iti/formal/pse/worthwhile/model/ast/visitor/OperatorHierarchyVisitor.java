/**
 * 
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunctionAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Greater;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;

/**
 * A visitor that returns a node's position in the operator hierarchy.
 * 
 * @nocheckstyle:magicnumber
 * 
 * @author Joachim
 *
 */
public class OperatorHierarchyVisitor extends ASTNodeReturnVisitor<Integer> {
	
	@Override
	public final void defaultOperation(final ASTNode node) {
		this.setReturnValue(-42);
	}

	@Override
        public final void visit(final Addition node) {
	        this.setReturnValue(5);
        }

	@Override
        public final void visit(final ArrayFunction node) {
	        this.setReturnValue(8);
        }

	@Override
        public final void visit(final ArrayFunctionAccess node) {
	        this.setReturnValue(8);
        }

	@Override
        public final void visit(final ArrayLiteral node) {
	        this.setReturnValue(8);
        }

	@Override
        public final void visit(final BooleanLiteral node) {
	        this.setReturnValue(8);
        }

	@Override
        public final void visit(final Conjunction node) {
	        this.setReturnValue(2);
        }

	@Override
        public final void visit(final Disjunction node) {
	        this.setReturnValue(1);
        }

	@Override
        public final void visit(final Division node) {
	        this.setReturnValue(6);
        }

	@Override
        public final void visit(final Equal node) {
	        this.setReturnValue(3);
        }

	@Override
        public final void visit(final Equivalence node) {
	        this.setReturnValue(-1);
        }

	@Override
        public final void visit(final FunctionCall node) {
	        this.setReturnValue(8);
        }

	@Override
        public final void visit(final Greater node) {
	        this.setReturnValue(4);
        }

	@Override
        public final void visit(final GreaterOrEqual node) {
	        this.setReturnValue(4);
        }

	@Override
        public final void visit(final Implication node) {
	        this.setReturnValue(0);
        }

	@Override
        public final void visit(final IntegerLiteral node) {
	        this.setReturnValue(8);
        }

	@Override
        public final void visit(final Less node) {
	        this.setReturnValue(4);
        }

	@Override
        public final void visit(final LessOrEqual node) {
	        this.setReturnValue(4);
        }

	@Override
        public final void visit(final Modulus node) {
	        this.setReturnValue(6);
        }

	@Override
        public final void visit(final Multiplication node) {
	        this.setReturnValue(6);
        }

	@Override
        public final void visit(final Negation node) {
	        this.setReturnValue(7);
        }
	@Override
        public final void visit(final QuantifiedExpression node) {
	       this.setReturnValue(-41);
        }

	@Override
        public final void visit(final Sign node) {
	        this.setReturnValue(7);
        }

	@Override
        public final void visit(final Subtraction node) {
	        this.setReturnValue(5);
        }

	@Override
        public final void visit(final Unequal node) {
	        this.setReturnValue(3);
        }

	@Override
        public final void visit(final SymbolReference node) {
	        this.setReturnValue(8);
        }

}
