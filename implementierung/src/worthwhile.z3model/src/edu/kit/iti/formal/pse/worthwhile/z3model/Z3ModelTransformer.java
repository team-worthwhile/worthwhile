package edu.kit.iti.formal.pse.worthwhile.z3model;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.TernaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.SubstitutionVisitor;

/**
 * Class that transforms an AST generated from a Z3 model into a Worthwhile AST, replacing model-specific constructs
 * such as ternary expression cascades by Worthwhile constructs.
 * 
 * @author Joachim
 * 
 */
public class Z3ModelTransformer extends SubstitutionVisitor<ArrayAccess> {

	/**
	 * Creates a new instance of the {@link Z3ModelTransformer} class.
	 */
	public Z3ModelTransformer() {
		super(null);
	}

	public void defaultOperation(final ASTNode node) {
	}

	@Override
	public void visit(TernaryExpression node) {
		// Warning: This code is not for the faint of heart!

		// Because we are overriding SubstitutionVisitor#visit(TernaryExpression) we also have to
		// take care of substituting if needed. Not substituting here may become a problem if
		// condition is a TernaryExpression that demands a substitution
		node.getWhenTrue().accept(this);
		if (this.getFound()) {
			node.setWhenTrue(this.getSubstitute());
			this.setFound(false);
		}

		node.getWhenFalse().accept(this);
		if (this.getFound()) {
			node.setWhenFalse(this.getSubstitute());
			this.setFound(false);
		}

		// Substitute an expression of the form
		// x = val ? y : z
		// by an array function of the form
		// { val => y, any => z}[x]
		
		// Check preconditions
		if (node.getCondition() == null) {
			return;
		}

		if (!(node.getCondition() instanceof Equal)) {
			return;
		}

		Equal condition = (Equal) node.getCondition();

		if (!(condition.getLeft() instanceof VariableReference && condition.getRight() instanceof Literal)) {
			return;
		}

		VariableReference var = (VariableReference) condition.getLeft();
		Literal index = (Literal) condition.getRight();

		// Perform the actual substitution; arrayFunction is going to be our substitute.
		ArrayFunction arrayFunction = AstFactory.eINSTANCE.createArrayFunction();
		arrayFunction.setIndex(index);
		arrayFunction.setValue(node.getWhenTrue());

		if (node.getWhenFalse() instanceof ArrayAccess) {
			arrayFunction.setChainedFunction(((ArrayAccess) node.getWhenFalse()).getArray());
		} else if (node.getWhenFalse() instanceof ArrayFunction) {
			arrayFunction.setChainedFunction(node.getWhenFalse());
		} else {
			ArrayFunction arrayFunctionFalse = AstFactory.eINSTANCE.createArrayFunction();
			arrayFunctionFalse.setIndex(null);
			arrayFunctionFalse.setValue(node.getWhenFalse());

			arrayFunction.setChainedFunction(arrayFunctionFalse);
		}

		ArrayAccess arrayAccess = AstFactory.eINSTANCE.createArrayAccess();
		arrayAccess.setArray(arrayFunction);
		arrayAccess.setIndex(var);

		this.setSubstitute(arrayAccess);
		this.setFound(true);
	}

}
