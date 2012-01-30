package edu.kit.iti.formal.pse.worthwhile.prover;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 * Completes {@link VariableDeclaration}s that are missing an explicit initial value with the implicit default initial
 * value defined for the Worthwhile language.
 * 
 * @author fabian
 * 
 */
public final class ImplicitInitialValueInserter extends HierarchialASTNodeVisitor {
	@Override
	public void visit(final Program program) {
		for (final FunctionDeclaration f : program.getFunctionDeclarations()) {
			f.accept(this);
		}

		program.getMainBlock().accept(this);
	}

	@Override
	public void visit(final Annotation annotation) {
		// explicitly ignore default operation for Annotations
	}

	@Override
	public void visit(final Assignment assignment) {
		// explicitly ignore default operation for Annotations
	}

	@Override
	public void visit(final Block block) {
		for (final Statement s : block.getStatements()) {
			s.accept(this);
		}
	}

	@Override
	public void visit(final Conditional conditional) {
		conditional.getTrueBlock().accept(this);

		final Block falseBlock = conditional.getFalseBlock();
		if (falseBlock != null) {
			falseBlock.accept(this);
		}
	}

	@Override
	public void visit(final FunctionDeclaration functionDeclaration) {
		functionDeclaration.getBody().accept(this);
	}

	@Override
	public void visit(final Loop loop) {
		loop.getBody().accept(this);
	}

	@Override
	public void visit(final ReturnStatement returnStatement) {
		// explicitly ignore default operation for ReturnStatements
	}

	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		// the visit methods return an Expression representing the implicit default initial value
		if (variableDeclaration.getInitialValue() == null) {
			variableDeclaration.setInitialValue(new ASTNodeReturnVisitor<Expression>() {
				@Override
				public void visit(final BooleanType booleanType) {
					this.setReturnValue(AstNodeCreatorHelper.createFalseLiteral());
				};

				@Override
				public void visit(final IntegerType integerType) {
					this.setReturnValue(AstNodeCreatorHelper.createZeroLiteral());
				};

				@Override
				public void visit(final ArrayType arrayType) {
					this.setReturnValue(AstNodeCreatorHelper.createArrayLiteral());
				};
			}.apply(variableDeclaration.getType()));
		}
	}
}
