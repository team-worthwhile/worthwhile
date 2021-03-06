package edu.kit.iti.formal.pse.worthwhile.typesystem;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeBottomUpVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.typesys.WorthwhileTypesystemGenerated;

/**
 * The type system for validation.
 */
public class WorthwhileTypesystem extends WorthwhileTypesystemGenerated {

	/**
	 * Returns the type of the {@link VariableReference}. If the variable reference is an array access return the
	 * base type of the array.
	 * 
	 * @param element
	 *                The variable reference from which you want to get the type.
	 * @param trace
	 *                A type calculation trace.
	 * 
	 * @return the type of the variable reference.
	 */
	@Override
	protected final EObject type(final VariableReference element, final TypeCalculationTrace trace) {

		if (element.getIndex() != null
		                && isInstanceOf(element.getVariable().getType(), p.getArrayType(), trace)) {
			trace.add(element, "variableReference_arrayAccess");

			return ((ArrayType) element.getVariable().getType()).getBaseType();
		} else {
			trace.add(element, "variableReference");
			return typeof(element.getVariable().getType(), trace);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The {@link ArrayAccess}'s type is the <code>array</code>'s <code>baseType</code>.
	 */
	@Override
	protected final EObject type(final ArrayAccess element, final TypeCalculationTrace trace) {
		trace.add(element, "arrayAccess");

		return ((ArrayType) this.typeof(element.getArray())).getBaseType();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * The {@link ArrayFunction}'s type is an {@link ArrayType} with the <code>element</code>'s <code>value</code>'s
	 * {@link Type} set as <code>baseType</code>.
	 */
	@Override
	protected final EObject type(final ArrayFunction element, final TypeCalculationTrace trace) {
		final ArrayType arrayType = AstFactory.eINSTANCE.createArrayType();

		// the point with ArrayFunctions is that their completely defined so that value is always set
		PrimitiveType baseType = (PrimitiveType) this.typeof(element.getValue(), trace);
		arrayType.setBaseType(AstNodeCloneHelper.clone(baseType));

		trace.add(element, "arrayFunction");

		return arrayType;
	}

	/**
	 * Returns the type of the {@link ArrayLiteral}. Sets the base type of the array literal to the type of the
	 * first element of the array. If the array has no elements the base type is null.
	 * 
	 * @param element
	 *                The array literal from which you want to get the type.
	 * @param trace
	 *                A type calculation trace.
	 * 
	 * @return The type of the array literal.
	 */
	@Override
	protected final EObject type(final ArrayLiteral element, final TypeCalculationTrace trace) {

		final ArrayType at = AstFactory.eINSTANCE.createArrayType();
		PrimitiveType baseType;
		if (element.getValues().size() == 0) {
			// used to determine the base types of variables (also parameters) the ArrayLiteral is assigned
			// to or compared to (in Equal Expressions)
			final WorthwhileTypesystem ts = WorthwhileTypesystem.this;

			// derives the empty ArrayLiterals base type from the context (up in the AST an Assignment,
			// VariableDeclaration, FunctionCall or Equal) it is used in
			final ASTNodeBottomUpVisitor<PrimitiveType> visitor = new ASTNodeBottomUpVisitor<PrimitiveType>() {
				@Override
				public void visit(final Assignment assignment) {
					// base type is the assigned variable's one
					if (assignment.getVariable().getVariable().getType() instanceof ArrayType) {
						ts.typeof(assignment.getVariable()).accept(this);
					}
				}

				@Override
				public void visit(final ReturnStatement returnStatement) {
					// base type is the enclosing function's one, find it
					final FunctionDeclaration function = new ASTNodeBottomUpVisitor<FunctionDeclaration>() {
						public void visit(final FunctionDeclaration functionDeclaration) {
							this.setReturnValue(functionDeclaration);
						}
					}.apply(element);

					// there might be no FunctionDeclaration when the respective validator check was
					// not run yet, nested FunctionDeclarations do not bother us because then the
					// type cannot be correct (since not defined in the Worthwhile semantics) anyway
					if (function != null && function.getReturnType() instanceof ArrayType) {
						ts.typeof(function).accept(this);
					}
				}

				@Override
				public void visit(final VariableDeclaration variableDeclaration) {
					// base type is the initialized variable's one
					if (variableDeclaration.getType() instanceof ArrayType) {
						ts.typeof(variableDeclaration).accept(this);
					}
				}

				@Override
				public void visit(final Equal equal) {
					// base type is the compared to ArrayLiteral's, ArrayType variable's one or
					// BooleanType by convention when both operands are empty ArrayLiterals
					final ASTNodeReturnVisitor<Type> visitor = new ASTNodeReturnVisitor<Type>() {
						public void visit(final ArrayLiteral arrayLiteral) {
							if (arrayLiteral.getValues().size() == 0) {
								this.setReturnValue(AstFactory.eINSTANCE
								                .createBooleanType());
							} else {
								super.visit(arrayLiteral);
							}
						};

						public void visit(final Expression expression) {
							this.setReturnValue(ts.typeof(expression));
						};
					};

					if (equal.getLeft().eContains(element)) {
						visitor.apply(equal.getRight()).accept(this);
					} else if (equal.getRight().eContains(element)) {
						visitor.apply(equal.getLeft()).accept(this);
					}
				}

				@Override
				public void visit(final FunctionCall functionCall) {
					// base type is the assigned parameter's one
					final EList<VariableDeclaration> parlist = functionCall.getFunction()
					                .getParameters();
					final EList<Expression> exprlist = functionCall.getActuals();

					for (int i = 0; i < exprlist.size(); i++) {
						if (exprlist.get(i) == element
						                && parlist.get(i).getType() instanceof ArrayType) {
							ts.typeof(parlist.get(i)).accept(this);
						}
					}
				}

				@Override
				public void visit(final ArrayType arrayType) {
					this.setReturnValue(arrayType.getBaseType());
				}

				@Override
				public void visit(final PrimitiveType primitiveType) {
					this.setReturnValue(primitiveType);
				}
			};
			baseType = visitor.apply(element);
		} else {
			baseType = (PrimitiveType) typeof(element.getValues().get(0), trace);

		}
		at.setBaseType(AstNodeCloneHelper.clone(baseType));
		trace.add(element, "arrayType");
		return at;
	}

	/**
	 * @param element
	 *                The {@link ReturnValueReference} of which you want to get the type.
	 * 
	 * @param trace
	 *                A type calculation trace.
	 * 
	 * @return The type of the return value reference.
	 */
	@Override
	protected final EObject type(final ReturnValueReference element, final TypeCalculationTrace trace) {

		ASTNodeBottomUpVisitor<Type> visitor = new ASTNodeBottomUpVisitor<Type>() {

			public void visit(final FunctionDeclaration func) {
				setReturnValue(func.getReturnType());
			}
		};
		Type type = visitor.apply(element);
		trace.add(element, "returnValueReference");

		// Check if there is an array access on the return value reference. If yes, return the array's base
		// type.
		if (type instanceof ArrayType && element.getIndex() != null) {
			return ((ArrayType) type).getBaseType();
		} else {
			return type;
		}
	}

	/**
	 * Checks whether the two elements have the same type.
	 * 
	 * If both elements have the type {@link ArrayType} there base types will be compared and the result will be
	 * returned.
	 * 
	 * @param element1
	 *                The first element which shell be compared.
	 * @param type1
	 *                The type of the first element.
	 * @param element2
	 *                The second element which shell be compared.
	 * @param type2
	 *                The type of the second element.
	 * @param trace
	 *                A type calculation trace
	 * 
	 * @return True if both have the same type, otherwise false.
	 */
	@Override
	public final boolean isSameType(final EObject element1, final EObject type1, final EObject element2,
	                final EObject type2, final TypeCalculationTrace trace) {

		if (isInstanceOf(type1, p.getArrayType(), trace) && isInstanceOf(type2, p.getArrayType(), trace)) {
			ArrayType at1 = (ArrayType) type1;
			ArrayType at2 = (ArrayType) type2;
			if (at1.getBaseType() == null || at2.getBaseType() == null) {
				return true;
			}
			return super.isSameType(at1, at1.getBaseType(), at2, at2.getBaseType(), trace);
		}
		return super.isSameType(element1, type1, element2, type2, trace);
	}

	/**
	 * Returns a brief representation of the object.
	 * 
	 * @param type
	 *                The type whose representation to return.
	 * 
	 * @return A representation of the object.
	 */
	@Override
	public final String typeString(final Object type) {
		if (type instanceof ASTNode) {
			ASTNodeReturnVisitor<ArrayType> visitor = new ASTNodeReturnVisitor<ArrayType>() {
				@Override
				protected void defaultOperation(final ASTNode node) {
					setReturnValue(null);
				}

				public void visit(final ArrayType arrayType) {
					setReturnValue(arrayType);
				}
			};
			ArrayType arrayType = visitor.apply((ASTNode) type);

			if (arrayType != null) {
				return super.typeString(arrayType).replace("Type", "") + " (with base type "
				                + super.typeString(arrayType.getBaseType()).replace("Type", "") + ")";
			} else {
				ASTNodeReturnVisitor<Type> visitor2 = new ASTNodeReturnVisitor<Type>() {
					@Override
					protected void defaultOperation(final ASTNode node) {
						setReturnValue(null);
					}

					public void visit(final IntegerType integerType) {
						setReturnValue(integerType);
					}

					public void visit(final BooleanType booleanType) {
						setReturnValue(booleanType);
					}
				};
				return super.typeString(visitor2.apply((ASTNode) type)).replace("Type", "");
			}
		}
		return super.typeString(type);

	}

	/**
	 * Returns the type of the specified EObject.
	 * 
	 * @param element
	 *                The element whose type to return.
	 * @return The type of the specified EObject
	 */
	public final Type typeof(final EObject element) {
		return (Type) typeof(element, new TypeCalculationTrace());
	}

}
