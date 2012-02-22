package edu.kit.iti.formal.pse.worthwhile.prover;

import java.math.BigInteger;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.typesystem.WorthwhileTypesystem;

/**
 * @author fabian
 * 
 */
public final class ArrayFunctionInserter extends SubstitutionVisitor<ArrayFunction> {
	/**
	 * Default constructor.
	 */
	ArrayFunctionInserter() {
		super(null);
	}

	@Override
	public void visit(final Assignment assignment) {
		final VariableReference varref = assignment.getVariable();
		final Expression value = assignment.getValue();

		final Expression index = varref.getIndex();
		// the access is a field access
		if (index != null) {
			// modify the source code (before being cloned for chainedFunction) so that the array variable
			// is assigned a complete arrayFunction
			varref.setIndex(null);

			final ArrayFunction arrayFunction = AstNodeCreatorHelper.createArrayFunction(index, value,
			                AstNodeCloneHelper.clone(varref));
			assignment.setValue(arrayFunction);
		}

		super.visit(assignment);
	}

	@Override
	public void visit(final ArrayLiteral arrayLiteral) {
		final ArrayFunction implicitArrayFunction = new ASTNodeReturnVisitor<ArrayFunction>() {
			@Override
			public void visit(final BooleanType booleanType) {
				this.setReturnValue(AstNodeCreatorHelper.createFalseArrayFunction());
			};

			@Override
			public void visit(final IntegerType integerType) {
				this.setReturnValue(AstNodeCreatorHelper.createZeroArrayFunction());
			};
		}.apply(((ArrayType) (new WorthwhileTypesystem()).typeof(arrayLiteral)).getBaseType());

		ArrayFunction arrayFunction = implicitArrayFunction;

		int index = -1;
		for (final Expression v : arrayLiteral.getValues()) {
			index++;
			final Expression indexLiteral = AstNodeCreatorHelper.createIntegerLiteral(BigInteger
			                .valueOf(index));
			arrayFunction = AstNodeCreatorHelper.createArrayFunction(indexLiteral,
			                AstNodeCloneHelper.clone(v), arrayFunction);
		}

		ArrayFunctionInserter.this.setSubstitute(arrayFunction);
		ArrayFunctionInserter.this.setFound(true);
	}
}
