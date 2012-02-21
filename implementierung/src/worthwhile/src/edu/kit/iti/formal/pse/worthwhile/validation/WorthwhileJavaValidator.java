package edu.kit.iti.formal.pse.worthwhile.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;

import com.google.inject.Inject;

import de.itemis.xtext.typesystem.ITypesystem;
import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeBottomUpVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;

/**
 * Performs semantic validation on a Worthwhile program.
 * 
 */
public class WorthwhileJavaValidator extends AbstractWorthwhileJavaValidator {

	/**
	 * Error code for "Function has no valid return statement".
	 */
	public static final String FUNCDEC_NO_VALID_RETURN = "FuncdecNoValidReturn";
	/**
	 * Error code for "Return statement may only appear in a function".
	 */
	public static final String RETURN_STATEMENT_ONLY_IN_FUNCTION = "ReturnStatementOnlyInFunction";

	/**
	 * The language typesystem.
	 */
	@Inject
	private ITypesystem ts;

	/**
	 * Checks if a function declaration contains a return statement on all code paths.
	 * 
	 * @param functionDeclaration
	 *                The function declaration to check.
	 */
	@Check
	public final void checkFunctionDeclarationValidReturnStatment(final FunctionDeclaration functionDeclaration) {
		ValidatorASTNodeVisitor validatorASTNodeVisitor = new ValidatorASTNodeVisitor();
		validatorASTNodeVisitor.visit(functionDeclaration);
		if (!validatorASTNodeVisitor.getValidReturnFound()) {
			error("Function has no valid return statement.", functionDeclaration,
			                AstPackage.eINSTANCE.getFunctionDeclaration_Name(), FUNCDEC_NO_VALID_RETURN);
		}
	}

	/**
	 * Checks that a return value reference is only used in the postcondition of a function.
	 * 
	 * @param returnValueReference
	 *                The return value reference to check.
	 */
	@Check
	public final void checkReturnValueReference(final ReturnValueReference returnValueReference) {

		ASTNodeBottomUpVisitor<Boolean> visitor = new ASTNodeBottomUpVisitor<Boolean>() {

			public void visit(final Postcondition postcondition) {
				setReturnValue(true);
			}
		};
		if (visitor.apply(returnValueReference) == null) {
			error("The return value of a function may only be referenced in the postcondition.",
			                returnValueReference, null, -1);
		}
	}

	/**
	 * Checks if a return statement is only contained by a function block. If so the type of the return statement
	 * and its function will also be checked.
	 * 
	 * @param returnStatement
	 *                The return statement to check.
	 */
	@Check
	public final void checkReturnStatementOnlyFunction(final ReturnStatement returnStatement) {

		ASTNodeBottomUpVisitor<Type> visitor = new ASTNodeBottomUpVisitor<Type>() {

			public void visit(final FunctionDeclaration func) {
				setReturnValue(func.getReturnType());
			}
		};

		Type type = visitor.apply(returnStatement);
		// no function declaration found
		if (type == null) {
			error("The return statement has to be in a function block.", returnStatement, null,
			                RETURN_STATEMENT_ONLY_IN_FUNCTION);

			// compare the type of the function declaration and the returnStatement
		} else if (!ts.isSameType(returnStatement, ts.typeof(returnStatement, new TypeCalculationTrace()),
		                type, type, new TypeCalculationTrace())) {
			error("Type mismatch. Expected " + ts.typeString(type) + ", but found "
			                + ts.typeString(ts.typeof(returnStatement, new TypeCalculationTrace())) + ".",
			                returnStatement, null, -1);
		}
	}

	/**
	 * Checks if the function call parameters match with the ones of the called function.
	 * 
	 * @param functionCall
	 *                The function call to be checked.
	 */
	@Check
	public final void checkFunctionCallParameter(final FunctionCall functionCall) {
		// if a undeclared function is called
		if (functionCall.getFunction().getName() == null) {
			return;
		}
		if (functionCall.getActuals().size() != functionCall.getFunction().getParameters().size()) {
			error("The amount of parameters is incorrect. Expecting "
			                + functionCall.getFunction().getParameters().size() + " parameters, but found "
			                + functionCall.getActuals().size() + ".", functionCall, null, -1);
		} else {
			TypeCalculationTrace trace = new TypeCalculationTrace();
			EList<Expression> actuals = functionCall.getActuals();
			EList<VariableDeclaration> parameters = functionCall.getFunction().getParameters();

			for (int i = 0; i < actuals.size(); i++) {
				if (!ts.isSameType(functionCall, ts.typeof(actuals.get(i), trace),
				                functionCall.getFunction(), ts.typeof(parameters.get(i), trace), trace)) {

					error("Expected parameter "
					                + ts.typeString(ts.typeof(parameters.get(i), trace))
					                + " , but found "
					                + ts.typeString(ts.typeof(actuals.get(i), trace)) + ".",
					                actuals.get(i), null, -1);

				}
			}
		}
	}

	/**
	 * Checks if all elements of the {@link ArrayLiteral} have the same type. The type may not be {@link ArrayType}
	 * 
	 * @param arrayLiteral
	 *                The array literal to be checked.
	 */
	@Check
	public final void checkArrayLiteral(final ArrayLiteral arrayLiteral) {
		ASTNodeBottomUpVisitor<Boolean> visitor = new ASTNodeBottomUpVisitor<Boolean>() {

			public void visit(final ArrayLiteral arrayLiteral) {
				setReturnValue(true);
			}
		};
		// if this array literal is contained in an other one
		if (visitor.apply((ASTNode) arrayLiteral.eContainer()) != null) {
			error("An array may not contain an other array.", arrayLiteral, null, -1);
		} else {
			EList<Expression> actuals = arrayLiteral.getValues();
			TypeCalculationTrace trace = new TypeCalculationTrace();
			ASTNodeReturnVisitor<ArrayType> rv = new ASTNodeReturnVisitor<ArrayType>() {
				@Override
				protected void defaultOperation(final ASTNode node) {
					setReturnValue(null);
				}

				public void visit(final ArrayType arrayType) {
					setReturnValue(arrayType);
				}
			};
			if (actuals.size() != 0) {
				ArrayType arrayType = rv.apply((ASTNode) (ts.typeof(actuals.get(0), trace)));
				// the first element may not be of type arrayType
				if (arrayType != null) {
					error("An array may not contain an other array.", actuals.get(0), null, -1);
					// check the rest of the array elements if they have the same type as the first
				} else {
					Type type = ((ArrayType) ts.typeof(arrayLiteral, trace)).getBaseType();
					for (int i = 0; i < actuals.size(); i++) {
						if (!ts.isSameType(type, type, actuals.get(i),
						                ts.typeof(actuals.get(i), trace), trace)) {
							error("Element doesn't match type of the array. Expected parameter of type "
							                + ts.typeString(ts.typeof(actuals.get(0), trace))
							                + ", but found "
							                + ts.typeString(ts.typeof(actuals.get(i), trace))
							                + ".", actuals.get(i), null, -1);
						}
					}
				}
			}
		}

	}

	/**
	 * Checks if the {@link QuantifiedExpression} is used in a {@link Annotation}.
	 * 
	 * @param expression
	 *                The expression to be checked.
	 * 
	 */
	@Check
	public final void checkQuantifiedExpression(final QuantifiedExpression expression) {
		ASTNodeBottomUpVisitor<Boolean> visitor = new ASTNodeBottomUpVisitor<Boolean>() {

			public void visit(final Annotation annotation) {
				setReturnValue(true);
			}
		};
		// if the quantifiedExpression is not in an Annotation
		if (visitor.apply((ASTNode) expression.eContainer()) == null) {
			error("Quantified expressions may only be used in Annotations.", expression, null, -1);
		}

	}

	/**
	 * Checks if the {@link Assignment} is used correctly. If the assignment is in a {@link FunctionDeclaration}, it
	 * will be checked if it doesn't change any parameters of the function.
	 * 
	 * @param assignment
	 *                The assignment to be checked.
	 */
	@Check
	public final void checkFunctionParametersNotModified(final Assignment assignment) {
		ASTNodeBottomUpVisitor<FunctionDeclaration> visitor = new ASTNodeBottomUpVisitor<FunctionDeclaration>() {

			public void visit(final FunctionDeclaration functionDeclaration) {
				setReturnValue(functionDeclaration);
			}
		};
		FunctionDeclaration functionDeclaration = visitor.apply(assignment);
		// if the assignment is in a function
		if (functionDeclaration != null) {

			for (int i = 0; i < functionDeclaration.getParameters().size(); i++) {
				if (functionDeclaration.getParameters().get(i).getName()
				                .equals(assignment.getVariable().getVariable().getName())) {
					error("Parameters of a function may not be changed.", assignment, null, -1);
				}
			}
		}
	}

	/**
	 * Checks if the given AST node conforms to the typesystem rules.
	 * 
	 * @param node
	 *                The AST node to check.
	 */
	@Check
	public final void checkTypesystemRules(final ASTNode node) {
		ts.checkTypesystemConstraints(node, this);
	}
}
