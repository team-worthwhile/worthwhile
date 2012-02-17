package edu.kit.iti.formal.pse.worthwhile.prover;

import java.util.HashMap;
import java.util.Map;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
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

	/**
	 * Maps each array variable to its current (when statements are traversed in source order) value.
	 */
	// FIXME: arrayFunctions needs to be cleared first when visitor is executed again
	private final Map<VariableDeclaration, ArrayFunction> arrayFunctions = new HashMap<VariableDeclaration, ArrayFunction>();

	@Override
	public void visit(final Assignment assignment) {
		ArrayFunction newArrayFunction = null;

		final VariableReference varref = assignment.getVariable();
		final VariableDeclaration variable = varref.getVariable();
		final Expression value = assignment.getValue();

		final Expression index = varref.getIndex();
		// the access is a field access
		if (index != null) {
			// get the current ArrayFunction assigned to the array variable and wrap it in a new
			// ArrayFunction that does a case distinction (for the field index) when accessed
			final ArrayFunction arrayFunction = arrayFunctions.get(variable);
			newArrayFunction = AstNodeCreatorHelper.createArrayFunction(index, value, arrayFunction);

			// modify the source code so that the array variable is assigned the newArrayFunction
			varref.setIndex(null);
		} else {
			value.accept(this);
			// the variable has array type
			if (this.getFound()) {
				this.setFound(false);
				newArrayFunction = this.getSubstitute(false);
			}
		}

		if (newArrayFunction != null) {
			// the ArrayFunction already in the map (maybe just initially defined) will be replaced with
			// the newArrayFunction
			arrayFunctions.remove(variable);

			// map the VariableDeclaration to the newArrayFunction which represents the just assigned
			// ArrayLiteral value(s)
			arrayFunctions.put(variable, newArrayFunction);

			assignment.setValue(newArrayFunction);
		}

		super.visit(assignment);
	}

	@Override
	public void visit(final VariableDeclaration variableDeclaration) {
		variableDeclaration.getInitialValue().accept(this);
		// the variable has array type
		if (this.getFound()) {
			this.setFound(false);

			// map the VariableDeclaration to an ArrayFunction representing the initial ArrayLiteral values
			arrayFunctions.put(variableDeclaration, this.getSubstitute(false));

			// modify the source code that the array variable is initialized with the created ArrayFunction
			variableDeclaration.setInitialValue(this.getSubstitute(false));
		}

		super.visit(variableDeclaration);
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

		this.setSubstitute(AstNodeCreatorHelper.createArrayFunction(arrayLiteral.getValues(),
		                implicitArrayFunction));
		this.setFound(true);
	}
}
