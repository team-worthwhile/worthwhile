package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;

/**
 * Implements equals methods for {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
public final class ASTNodeEqualator {
	/**
	 * Private default constructor.
	 */
	private ASTNodeEqualator() {
		// left empty intentionally
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public static Boolean equal(ASTNode arg0, ASTNode arg1) {
		if (arg0 == arg1) {
			return true;
		}
		// arg0 and arg1 cannot be both null
		if (arg1 == null) {
			return false;
		}
		if (arg0 instanceof BinaryExpression && arg1 instanceof BinaryExpression) {
			return equal((BinaryExpression) arg0, (BinaryExpression) arg1);
		} else if (arg0 instanceof UnaryExpression && arg1 instanceof UnaryExpression) {
			return equal((UnaryExpression) arg0, (UnaryExpression) arg1);
		} else if (arg0 instanceof BooleanLiteral && arg1 instanceof BooleanLiteral) {
			return equal((BooleanLiteral) arg0, (BooleanLiteral) arg1);
		} else if (arg0 instanceof IntegerLiteral && arg1 instanceof IntegerLiteral) {
			return equal((IntegerLiteral) arg0, (IntegerLiteral) arg1);
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	private static Boolean equal(BinaryExpression arg0, BinaryExpression arg1) {
		if (arg0 == arg1) {
			return true;
		}
		if (arg1 == null) {
			return false;
		}
		if (arg0.getLeft() == null) {
			if (arg1.getLeft() != null) {
				return false;
			}
		} else if (!equal(arg0.getLeft(), arg1.getLeft())) {
			return false;
		}
		if (arg0.getRight() == null) {
			if (arg1.getRight() != null) {
				return false;
			}
		} else if (!equal(arg0.getRight(), arg1.getRight())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	private static Boolean equal(BooleanLiteral arg0, BooleanLiteral arg1) {
		if (arg0 == arg1) {
			return true;
		}
		if (arg1 == null) {
			return false;
		}
		if (arg0.getValue() != arg1.getValue()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	private static Boolean equal(IntegerLiteral arg0, IntegerLiteral arg1) {
		if (arg0 == arg1) {
			return true;
		}
		if (arg1 == null) {
			return false;
		}
		if (arg0.getValue() == null) {
			if (arg1.getValue() != null) {
				return false;
			}
		} else if (!arg0.getValue().equals(arg1.getValue())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	private static Boolean equal(UnaryExpression arg0, UnaryExpression arg1) {
		if (arg0 == arg1) {
			return true;
		}
		if (arg1 == null) {
			return false;
		}
		if (arg0.getOperand() == null) {
			if (arg1.getOperand() != null) {
				return false;
			}
		} else if (!equal(arg0.getOperand(), arg1.getOperand())) {
			return false;
		}
		return true;
	}
}