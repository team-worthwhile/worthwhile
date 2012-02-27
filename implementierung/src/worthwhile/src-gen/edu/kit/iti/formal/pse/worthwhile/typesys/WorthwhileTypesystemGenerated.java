		package edu.kit.iti.formal.pse.worthwhile.typesys;

		import org.eclipse.emf.ecore.EObject;
		import de.itemis.xtext.typesystem.exceptions.TypesystemConfigurationException;
		import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

		public  abstract class WorthwhileTypesystemGenerated extends de.itemis.xtext.typesystem.DefaultTypesystem {

			protected edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage p = edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage.eINSTANCE;

			protected void initialize() {

				try {

						// ----------------------------------------------------------------
						// Section: BaseTypes

						useCloneAsType( p.getArrayType() );
						ensureFeatureType( p.getArrayType(), p.getArrayType_BaseType(), p.getBooleanType(), p.getIntegerType() );
						useCloneAsType( p.getIntegerType() );
						useCloneAsType( p.getBooleanType() );

						// ----------------------------------------------------------------
						// Section: Literals

						useFixedType( p.getBooleanLiteral(), p.getBooleanType() );
						useFixedType( p.getIntegerLiteral(), p.getIntegerType() );

						// ----------------------------------------------------------------
						// Section: Variables

						useTypeOfFeature( p.getVariableDeclaration(), p.getVariableDeclaration_Type() );
						ensureFeatureType( p.getVariableDeclaration(), p.getVariableDeclaration_Type(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureUnorderedCompatibility( p.getVariableDeclaration(), p.getVariableDeclaration_InitialValue(), p.getVariableDeclaration_Type() );
						useTypeOfFeature( p.getAssignment(), p.getAssignment_Variable() );
						ensureFeatureType( p.getAssignment(), p.getAssignment_Value(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureUnorderedCompatibility( p.getAssignment(), p.getAssignment_Variable(), p.getAssignment_Value() );
						ensureFeatureType( p.getVariableReference(), p.getSymbolReference_Index(), p.getIntegerType() );

						// ----------------------------------------------------------------
						// Section: Expressions

						// include subtypes!
						// ------
						useFixedType( p.getForAllQuantifier(), p.getBooleanType() );
						useFixedType( p.getExistsQuantifier(), p.getBooleanType() );
						useFixedType( p.getQuantifiedExpression(), p.getBooleanType() );
						ensureFeatureType( p.getQuantifiedExpression(), p.getQuantifiedExpression_Expression(), p.getBooleanType() );
						ensureFeatureType( p.getQuantifiedExpression(), p.getQuantifiedExpression_Condition(), p.getBooleanType() );

						// ----------------------------------------------------------------
						// Section: Annotation

						ensureFeatureType( p.getAssumption(), p.getAnnotation_Expression(), p.getBooleanType() );
						ensureFeatureType( p.getAssertion(), p.getAnnotation_Expression(), p.getBooleanType() );
						ensureFeatureType( p.getPostcondition(), p.getAnnotation_Expression(), p.getBooleanType() );
						ensureFeatureType( p.getPrecondition(), p.getAnnotation_Expression(), p.getBooleanType() );
						ensureFeatureType( p.getInvariant(), p.getAnnotation_Expression(), p.getBooleanType() );

						// ----------------------------------------------------------------
						// Section: Binary Expression with integer operands

						useFixedType( p.getAddition(), p.getIntegerType() );
						ensureFeatureType( p.getAddition(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getAddition(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getAddition(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getSubtraction(), p.getIntegerType() );
						ensureFeatureType( p.getSubtraction(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getSubtraction(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getSubtraction(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getMultiplication(), p.getIntegerType() );
						ensureFeatureType( p.getMultiplication(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getMultiplication(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getMultiplication(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getModulus(), p.getIntegerType() );
						ensureFeatureType( p.getModulus(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getModulus(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getModulus(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getDivision(), p.getIntegerType() );
						ensureFeatureType( p.getDivision(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getDivision(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getDivision(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getLessOrEqual(), p.getBooleanType() );
						ensureFeatureType( p.getLessOrEqual(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getLessOrEqual(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getLessOrEqual(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getLess(), p.getBooleanType() );
						ensureFeatureType( p.getLess(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getLess(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getLess(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getGreater(), p.getBooleanType() );
						ensureFeatureType( p.getGreater(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getGreater(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getGreater(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getGreaterOrEqual(), p.getBooleanType() );
						ensureFeatureType( p.getGreaterOrEqual(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getGreaterOrEqual(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( p.getGreaterOrEqual(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );

						// ----------------------------------------------------------------
						// Section: Binary Expression with boolean operands

						useFixedType( p.getDisjunction(), p.getBooleanType() );
						ensureFeatureType( p.getDisjunction(), p.getBinaryExpression_Left(), p.getBooleanType() );
						ensureFeatureType( p.getDisjunction(), p.getBinaryExpression_Right(), p.getBooleanType() );
						ensureUnorderedCompatibility( p.getDisjunction(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getConjunction(), p.getBooleanType() );
						ensureFeatureType( p.getConjunction(), p.getBinaryExpression_Left(), p.getBooleanType() );
						ensureFeatureType( p.getConjunction(), p.getBinaryExpression_Right(), p.getBooleanType() );
						ensureUnorderedCompatibility( p.getConjunction(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getEquivalence(), p.getBooleanType() );
						ensureFeatureType( p.getEquivalence(), p.getBinaryExpression_Left(), p.getBooleanType() );
						ensureFeatureType( p.getEquivalence(), p.getBinaryExpression_Right(), p.getBooleanType() );
						ensureUnorderedCompatibility( p.getEquivalence(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getImplication(), p.getBooleanType() );
						ensureFeatureType( p.getImplication(), p.getBinaryExpression_Left(), p.getBooleanType() );
						ensureFeatureType( p.getImplication(), p.getBinaryExpression_Right(), p.getBooleanType() );
						ensureUnorderedCompatibility( p.getImplication(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );

						// ----------------------------------------------------------------
						// Section: Binary Expression with boolean, integer or array operands

						useFixedType( p.getEqual(), p.getBooleanType() );
						ensureFeatureType( p.getEqual(), p.getBinaryExpression_Left(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureFeatureType( p.getEqual(), p.getBinaryExpression_Right(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureUnorderedCompatibility( "Both operands have to be be of the same type", p.getEqual(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getUnequal(), p.getBooleanType() );
						ensureFeatureType( p.getUnequal(), p.getBinaryExpression_Left(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureFeatureType( p.getUnequal(), p.getBinaryExpression_Right(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureUnorderedCompatibility( "Both operands have to be be of the same type", p.getUnequal(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );

						// ----------------------------------------------------------------
						// Section: Unary Expression

						useFixedType( p.getNegation(), p.getBooleanType() );
						ensureFeatureType( "Only a Boolean operand can be negated", p.getNegation(), p.getUnaryExpression_Operand(), p.getBooleanType() );
						useTypeOfFeature( p.getPlus(), p.getUnaryExpression_Operand() );
						ensureFeatureType( "Only Integers have signs", p.getPlus(), p.getUnaryExpression_Operand(), p.getIntegerType() );
						useTypeOfFeature( p.getMinus(), p.getUnaryExpression_Operand() );
						ensureFeatureType( "Only Integers have signs", p.getMinus(), p.getUnaryExpression_Operand(), p.getIntegerType() );

						// ----------------------------------------------------------------
						// Section: Conditional

						ensureFeatureType( "Has to be be a value of Boolean or an expression which returns an value of Boolean", p.getConditional(), p.getConditional_Condition(), p.getBooleanType() );
						ensureFeatureType( "Has to be be a value of Boolean or an expression which returns an value of Boolean", p.getLoop(), p.getLoop_Condition(), p.getBooleanType() );

						// ----------------------------------------------------------------
						// Section: Functions

						useTypeOfFeature( p.getFunctionDeclaration(), p.getFunctionDeclaration_ReturnType() );
						ensureFeatureType( p.getFunctionDeclaration(), p.getFunctionDeclaration_ReturnType(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						useTypeOfFeature( p.getReturnStatement(), p.getReturnStatement_ReturnValue() );
						ensureFeatureType( p.getReturnStatement(), p.getReturnStatement_ReturnValue(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						useTypeOfFeature( p.getFunctionCall(), p.getFunctionCall_Function() );

				} catch ( TypesystemConfigurationException ex ) {
				}
			}

			protected abstract EObject type( edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral element, TypeCalculationTrace trace );
			protected abstract EObject type( edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference element, TypeCalculationTrace trace );
			protected abstract EObject type( edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference element, TypeCalculationTrace trace );

		}
