package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Greater;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * An AST node visitor that goes from the bottom to the top.
 * 
 * @param <R>
 *            The type of the return value.
 * 
 * @author matthias
 * 
 * @nocheckstyle:designforextension
 */
public abstract class ASTNodeBottomUpVisitor<R> extends ASTNodeReturnVisitor<R> {

	@Override
	public void visit(final Addition node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Annotation node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ArrayLength node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ArrayLiteral node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ArrayType node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Assertion node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Assignment node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Assumption node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ASTNode node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Axiom node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final BinaryExpression node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Block node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final BooleanLiteral node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final BooleanType node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Conditional node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Conjunction node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Disjunction node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Division node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Equal node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Equivalence node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ExistsQuantifier node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Expression node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ForAllQuantifier node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final FunctionCall node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final FunctionDeclaration node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Greater node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final GreaterOrEqual node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Implication node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final IntegerLiteral node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final IntegerType node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Invariant node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Less node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final LessOrEqual node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Literal node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Loop node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Minus node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Modulus node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Multiplication node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Negation node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Plus node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Postcondition node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Precondition node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final PrimitiveType node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Program node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final QuantifiedExpression node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ReturnStatement node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Sign node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Statement node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Subtraction node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Type node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final UnaryExpression node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final Unequal node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final VariableDeclaration node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final VariableReference node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

	@Override
	public void visit(final ReturnValueReference node) {
		if (node.eContainer() != null) {
			((ASTNode) node.eContainer()).accept(this);
		}
	}

}
