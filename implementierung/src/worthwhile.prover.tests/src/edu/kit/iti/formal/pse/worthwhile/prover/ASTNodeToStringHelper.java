package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstSwitch;

/**
 * Implements toString methods for {@link ASTNode}s.
 * 
 * @author fabian
 * 
 */
class ASTNodeToStringHelper extends AstSwitch<String> {
	@Override
	public String caseASTNode(ASTNode aSTNode) {
		return aSTNode.toString();
	}

	@Override
	public String caseAssertion(Assertion assertion) {
		return "_assert " + assertion.getExpression();
	}

	@Override
	public String caseAssignment(Assignment assignment) {
		return assignment.getVariable() + " := " + assignment.getValue();
	}

	@Override
	public String caseBlock(Block block) {
		StringBuffer buf = new StringBuffer();
		for (Statement stmt : block.getStatements()) {
			buf.append(this.doSwitch(stmt) + "\n");
		}
		return buf.toString();
	}

	@Override
	public String caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return String.valueOf(booleanLiteral.getValue());
	}

	@Override
	public String caseConjunction(Conjunction conjunction) {
		return this.doSwitch(conjunction.getLeft()) + " && " + this.doSwitch(conjunction.getRight());
	}

	@Override
	public String caseEqual(Equal equal) {
		return this.doSwitch(equal.getLeft()) + " = " + this.doSwitch(equal.getRight());
	}

	@Override
	public String caseIntegerLiteral(IntegerLiteral integerLiteral) {
		return integerLiteral.getValue().toString();
	}

	@Override
	public String caseIntegerType(IntegerType integerType) {
		return "Integer";
	}

	@Override
	public String caseProgram(Program program) {
		return this.doSwitch(program.getMainBlock());
	}

	@Override
	public String caseVariableDeclaration(VariableDeclaration variableDeclaration) {
		return variableDeclaration.getType() + " " + variableDeclaration.getName() + " := "
		        + variableDeclaration.getInitialValue();
	}

	@Override
	public String caseVariableReference(VariableReference variableReference) {
		return variableReference.getVariable().getName();
	}
}