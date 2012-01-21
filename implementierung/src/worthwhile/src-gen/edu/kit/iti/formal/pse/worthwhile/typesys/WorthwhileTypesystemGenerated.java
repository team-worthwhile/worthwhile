		package edu.kit.iti.formal.pse.worthwhile.typesys;

		import org.eclipse.emf.ecore.EObject;
		import de.itemis.xtext.typesystem.exceptions.TypesystemConfigurationException;
		import de.itemis.xtext.typesystem.trace.TypeCalculationTrace;

		public class WorthwhileTypesystemGenerated extends de.itemis.xtext.typesystem.DefaultTypesystem {

			protected edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage p = edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage.eINSTANCE;

			protected void initialize() {

				try {

						// ----------------------------------------------------------------
						// Section: BaseTypes

						useCloneAsType( p.getArrayType() );
						ensureFeatureType( p.getArrayType(), p.getArrayType_Size(), p.getIntegerType() );
						ensureFeatureType( p.getArrayType(), p.getArrayType_BaseType(), p.getBooleanType(), p.getIntegerType() );
						useCloneAsType( p.getIntegerType() );
						useCloneAsType( p.getBooleanType() );

						// ----------------------------------------------------------------
						// Section: Literals

						useFixedType( p.getBooleanLiteral(), p.getBooleanType() );
						useFixedType( p.getIntegerLiteral(), p.getIntegerType() );
						useFixedType( p.getArrayLiteral(), p.getArrayType() );

						// ----------------------------------------------------------------
						// Section: Variables

						useTypeOfFeature( p.getVariableDeclaration(), p.getVariableDeclaration_Type() );
						ensureFeatureType( p.getVariableDeclaration(), p.getVariableDeclaration_Type(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureUnorderedCompatibility( p.getVariableDeclaration(), p.getVariableDeclaration_InitialValue(), p.getVariableDeclaration_Type() );
						useTypeOfFeature( p.getAssignment(), p.getAssignment_Variable() );
						ensureFeatureType( p.getAssignment(), p.getAssignment_Value(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureUnorderedCompatibility( p.getAssignment(), p.getAssignment_Variable(), p.getAssignment_Value() );
						useTypeOfFeature( p.getVariableReference(), p.getVariableReference_Variable() );

						// ----------------------------------------------------------------
						// Section: Expressions

						// include subtypes!
						// ------
						useCloneAsType( p.getQuantifiedExpression() );
						ensureFeatureType( p.getQuantifiedExpression(), p.getQuantifiedExpression_Parameter(), p.getBooleanType(), p.getIntegerType() );
						ensureFeatureType( p.getQuantifiedExpression(), p.getQuantifiedExpression_Expression(), p.getBooleanType(), p.getForAllQuantifier(), p.getExistsQuantifier() );
						ensureFeatureType( p.getQuantifiedExpression(), p.getQuantifiedExpression_Condition(), p.getBooleanType() );
						useCloneAsType( p.getForAllQuantifier() );
						useCloneAsType( p.getExistsQuantifier() );

						// ----------------------------------------------------------------
						// Section: Annotation

						ensureFeatureType( p.getAssumption(), p.getAnnotation_Expression(), p.getBooleanType(), p.getQuantifiedExpression() );
						ensureFeatureType( p.getAssertion(), p.getAnnotation_Expression(), p.getBooleanType(), p.getQuantifiedExpression() );
						ensureFeatureType( p.getPostcondition(), p.getAnnotation_Expression(), p.getBooleanType(), p.getQuantifiedExpression() );
						ensureFeatureType( p.getPrecondition(), p.getAnnotation_Expression(), p.getBooleanType(), p.getQuantifiedExpression() );
						ensureFeatureType( p.getInvariant(), p.getAnnotation_Expression(), p.getBooleanType(), p.getQuantifiedExpression() );

						// ----------------------------------------------------------------
						// Section: Binary Expression with integer operands

						computeCommonType( p.getAddition(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right());
						ensureFeatureType( p.getAddition(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getAddition(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both summands have to be an Integer or an expression which returns an integer", p.getAddition(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						computeCommonType( p.getSubtraction(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right());
						ensureFeatureType( p.getSubtraction(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getSubtraction(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both minuend and subtrahend have to be an Integer or an expression which returns an integer", p.getSubtraction(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						computeCommonType( p.getMultiplication(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right());
						ensureFeatureType( p.getMultiplication(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getMultiplication(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both factors have to be an Integer or an expression which returns an integer", p.getMultiplication(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						computeCommonType( p.getModulus(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right());
						ensureFeatureType( p.getModulus(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getModulus(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both operands have to be be an Integer or an expression which returns an integer", p.getModulus(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						computeCommonType( p.getDivision(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right());
						ensureFeatureType( p.getDivision(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getDivision(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both dividend and divisor have to be an Integer or an expression which returns an integer", p.getDivision(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getLessOrEqual(), p.getBooleanType() );
						ensureFeatureType( p.getLessOrEqual(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getLessOrEqual(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both operands have to be be an Integer or an expression which returns an integer", p.getLessOrEqual(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getLess(), p.getBooleanType() );
						ensureFeatureType( p.getLess(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getLess(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both operands have to be be an Integer or an expression which returns an integer", p.getLess(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getGreater(), p.getBooleanType() );
						ensureFeatureType( p.getGreater(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getGreater(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both operands have to be be an Integer or an expression which returns an integer", p.getGreater(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getGreaterOrEqual(), p.getBooleanType() );
						ensureFeatureType( p.getGreaterOrEqual(), p.getBinaryExpression_Left(), p.getIntegerType() );
						ensureFeatureType( p.getGreaterOrEqual(), p.getBinaryExpression_Right(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both operands have to be be an Integer or an expression which returns an integer", p.getGreaterOrEqual(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );

						// ----------------------------------------------------------------
						// Section: Binary Expression with boolean operands

						useFixedType( p.getDisjunction(), p.getBooleanType() );
						ensureFeatureType( p.getDisjunction(), p.getBinaryExpression_Left(), p.getBooleanType() );
						ensureFeatureType( p.getDisjunction(), p.getBinaryExpression_Right(), p.getBooleanType() );
						ensureUnorderedCompatibility( "Both operands have to be be a value of Boolean or an expression which returns an value of Boolean", p.getDisjunction(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getConjunction(), p.getBooleanType() );
						ensureFeatureType( p.getConjunction(), p.getBinaryExpression_Left(), p.getBooleanType() );
						ensureFeatureType( p.getConjunction(), p.getBinaryExpression_Right(), p.getBooleanType() );
						ensureUnorderedCompatibility( "Both operands have to be be a value of Boolean or an expression which returns an value of Boolean", p.getConjunction(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );

						// ----------------------------------------------------------------
						// Section: Binary Expression with boolean operands or integer operands

						useFixedType( p.getEqual(), p.getBooleanType() );
						ensureFeatureType( p.getEqual(), p.getBinaryExpression_Left(), p.getBooleanType(), p.getIntegerType() );
						ensureFeatureType( p.getEqual(), p.getBinaryExpression_Right(), p.getBooleanType(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both operands have to be be of the same type", p.getEqual(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );
						useFixedType( p.getUnequal(), p.getBooleanType() );
						ensureFeatureType( p.getUnequal(), p.getBinaryExpression_Left(), p.getBooleanType(), p.getIntegerType() );
						ensureFeatureType( p.getUnequal(), p.getBinaryExpression_Right(), p.getBooleanType(), p.getIntegerType() );
						ensureUnorderedCompatibility( "Both operands have to be be of the same type", p.getUnequal(), p.getBinaryExpression_Left(), p.getBinaryExpression_Right() );

						// ----------------------------------------------------------------
						// Section: Unary Expression

						useFixedType( p.getNegation(), p.getBooleanType() );
						ensureFeatureType( "Only a Boolean operand can be negated", p.getNegation(), p.getUnaryExpression_Operand(), p.getBooleanType() );
						useTypeOfFeature( p.getPlus(), p.getUnaryExpression_Operand() );
						ensureFeatureType( "Only Integers have signs", p.getPlus(), p.getUnaryExpression_Operand(), p.getIntegerType() );
						useTypeOfFeature( p.getMinus(), p.getUnaryExpression_Operand() );
						ensureFeatureType( "Only Integers have signs", p.getMinus(), p.getUnaryExpression_Operand(), p.getIntegerType() );
						useFixedType( p.getArrayLength(), p.getIntegerType() );
						ensureFeatureType( "The Operand has to be an array", p.getArrayLength(), p.getUnaryExpression_Operand(), p.getArrayType() );

						// ----------------------------------------------------------------
						// Section: Conditional

						ensureFeatureType( "Has to be be a value of Boolean or an expression which returns an value of Boolean", p.getConditional(), p.getConditional_Condition(), p.getBooleanType() );
						ensureFeatureType( "Has to be be a value of Boolean or an expression which returns an value of Boolean", p.getLoop(), p.getLoop_Condition(), p.getBooleanType() );

						// ----------------------------------------------------------------
						// Section: Functions

						useTypeOfFeature( p.getFunctionDeclaration(), p.getFunctionDeclaration_ReturnType() );
						ensureFeatureType( p.getFunctionDeclaration(), p.getFunctionDeclaration_ReturnType(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						ensureFeatureType( p.getReturnStatement(), p.getReturnStatement_ReturnValue(), p.getBooleanType(), p.getIntegerType(), p.getArrayType() );
						useTypeOfFeature( p.getFunctionCall(), p.getFunctionCall_Function() );

				} catch ( TypesystemConfigurationException ex ) {
				}
			}


		}
