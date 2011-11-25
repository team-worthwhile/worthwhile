package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.myDsl.AdditionOp;
import org.xtext.example.mydsl.myDsl.Annotation;
import org.xtext.example.mydsl.myDsl.ArrayAccess;
import org.xtext.example.mydsl.myDsl.ArrayType;
import org.xtext.example.mydsl.myDsl.Assignment;
import org.xtext.example.mydsl.myDsl.Block;
import org.xtext.example.mydsl.myDsl.BoolType;
import org.xtext.example.mydsl.myDsl.Compare;
import org.xtext.example.mydsl.myDsl.DivisionOp;
import org.xtext.example.mydsl.myDsl.Equals;
import org.xtext.example.mydsl.myDsl.Expression;
import org.xtext.example.mydsl.myDsl.FalseLiteral;
import org.xtext.example.mydsl.myDsl.Function;
import org.xtext.example.mydsl.myDsl.FunctionRef;
import org.xtext.example.mydsl.myDsl.GreaterComparisonType;
import org.xtext.example.mydsl.myDsl.GreaterOrEqualComparisonType;
import org.xtext.example.mydsl.myDsl.IfStatement;
import org.xtext.example.mydsl.myDsl.IntType;
import org.xtext.example.mydsl.myDsl.LessComparisonType;
import org.xtext.example.mydsl.myDsl.LessOrEqualComparisonType;
import org.xtext.example.mydsl.myDsl.Model;
import org.xtext.example.mydsl.myDsl.ModuloOp;
import org.xtext.example.mydsl.myDsl.Multi;
import org.xtext.example.mydsl.myDsl.MultiplicationOp;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.NumberLiteral;
import org.xtext.example.mydsl.myDsl.Parameter;
import org.xtext.example.mydsl.myDsl.Plus;
import org.xtext.example.mydsl.myDsl.ReturnStatement;
import org.xtext.example.mydsl.myDsl.SubtractionOp;
import org.xtext.example.mydsl.myDsl.TrueLiteral;
import org.xtext.example.mydsl.myDsl.Variable;
import org.xtext.example.mydsl.myDsl.VariableRef;
import org.xtext.example.mydsl.myDsl.WhileStatement;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractMyDslSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected MyDslGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MyDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MyDslPackage.ADDITION_OP:
				if(context == grammarAccess.getAdditionOpRule() ||
				   context == grammarAccess.getAdditionTypeRule()) {
					sequence_AdditionType(context, (AdditionOp) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ANNOTATION:
				if(context == grammarAccess.getAnnotationRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (Annotation) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ARRAY_ACCESS:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorRule()) {
					sequence_PostfixOperator(context, (ArrayAccess) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ARRAY_TYPE:
				if(context == grammarAccess.getArrayTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_ArrayType(context, (ArrayType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.BLOCK:
				if(context == grammarAccess.getBlockRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Block(context, (Block) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.BOOL_TYPE:
				if(context == grammarAccess.getBoolTypeRule() ||
				   context == grammarAccess.getPrimitiveTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (BoolType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.COMPARE:
				if(context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule()) {
					sequence_Comparison(context, (Compare) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.DIVISION_OP:
				if(context == grammarAccess.getDivisionOpRule() ||
				   context == grammarAccess.getMultiplicationTypeRule()) {
					sequence_MultiplicationType(context, (DivisionOp) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.EQUALS:
				if(context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getExprRule()) {
					sequence_EqualsComparison(context, (Equals) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.EXPRESSION:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorRule() ||
				   context == grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0()) {
					sequence_Atomic(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.FALSE_LITERAL:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getFalseLiteralRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorRule() ||
				   context == grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0()) {
					sequence_Expr(context, (FalseLiteral) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.FUNCTION:
				if(context == grammarAccess.getFunctionDeclarationRule()) {
					sequence_FunctionDeclaration(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.FUNCTION_REF:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getFunctionCallRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorRule() ||
				   context == grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_FunctionCall(context, (FunctionRef) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.GREATER_COMPARISON_TYPE:
				if(context == grammarAccess.getComparisonTypeRule() ||
				   context == grammarAccess.getGreaterComparisonTypeRule()) {
					sequence_ComparisonType(context, (GreaterComparisonType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.GREATER_OR_EQUAL_COMPARISON_TYPE:
				if(context == grammarAccess.getComparisonTypeRule() ||
				   context == grammarAccess.getGreaterOrEqualComparisonTypeRule()) {
					sequence_ComparisonType(context, (GreaterOrEqualComparisonType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.IF_STATEMENT:
				if(context == grammarAccess.getIfStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_IfStatement(context, (IfStatement) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.INT_TYPE:
				if(context == grammarAccess.getIntTypeRule() ||
				   context == grammarAccess.getPrimitiveTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (IntType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.LESS_COMPARISON_TYPE:
				if(context == grammarAccess.getComparisonTypeRule() ||
				   context == grammarAccess.getLessComparisonTypeRule()) {
					sequence_ComparisonType(context, (LessComparisonType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.LESS_OR_EQUAL_COMPARISON_TYPE:
				if(context == grammarAccess.getComparisonTypeRule() ||
				   context == grammarAccess.getLessOrEqualComparisonTypeRule()) {
					sequence_ComparisonType(context, (LessOrEqualComparisonType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.MODULO_OP:
				if(context == grammarAccess.getModuloOpRule() ||
				   context == grammarAccess.getMultiplicationTypeRule()) {
					sequence_MultiplicationType(context, (ModuloOp) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.MULTI:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0()) {
					sequence_Multiplication(context, (Multi) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.MULTIPLICATION_OP:
				if(context == grammarAccess.getMultiplicationOpRule() ||
				   context == grammarAccess.getMultiplicationTypeRule()) {
					sequence_MultiplicationType(context, (MultiplicationOp) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.NUMBER_LITERAL:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorRule() ||
				   context == grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0()) {
					sequence_Atomic(context, (NumberLiteral) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.PARAMETER:
				if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.PLUS:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule()) {
					sequence_Addition(context, (Plus) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.RETURN_STATEMENT:
				if(context == grammarAccess.getReturnStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ReturnStatement(context, (ReturnStatement) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.SUBTRACTION_OP:
				if(context == grammarAccess.getAdditionTypeRule() ||
				   context == grammarAccess.getSubtractionOpRule()) {
					sequence_AdditionType(context, (SubtractionOp) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.TRUE_LITERAL:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorRule() ||
				   context == grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0() ||
				   context == grammarAccess.getTrueLiteralRule()) {
					sequence_Expr(context, (TrueLiteral) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.VARIABLE:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getVariableDeclarationRule()) {
					sequence_VariableDeclaration(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.VARIABLE_REF:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getCompareLeftAction_1_0() ||
				   context == grammarAccess.getEqualsComparisonRule() ||
				   context == grammarAccess.getEqualsComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorRule() ||
				   context == grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0() ||
				   context == grammarAccess.getVariableRefRule()) {
					sequence_VariableRef(context, (VariableRef) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.WHILE_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getWhileStatementRule()) {
					sequence_WhileStatement(context, (WhileStatement) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     {AdditionOp}
	 *
	 * Features:
	 */
	protected void sequence_AdditionType(EObject context, AdditionOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {SubtractionOp}
	 *
	 * Features:
	 */
	protected void sequence_AdditionType(EObject context, SubtractionOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition_Plus_1_0 type=AdditionType right=Multiplication)
	 *
	 * Features:
	 *    left[1, 1]
	 *    type[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition(EObject context, Plus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     baseType=PrimitiveType
	 *
	 * Features:
	 *    baseType[1, 1]
	 */
	protected void sequence_ArrayType(EObject context, ArrayType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ARRAY_TYPE__BASE_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ARRAY_TYPE__BASE_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArrayTypeAccess().getBaseTypePrimitiveTypeParserRuleCall_1_0(), semanticObject.getBaseType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (variable=[Variable|ID] value=Expr)
	 *
	 * Features:
	 *    variable[1, 1]
	 *    value[1, 1]
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ASSIGNMENT__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ASSIGNMENT__VARIABLE));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ASSIGNMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentAccess().getVariableVariableIDTerminalRuleCall_0_0_1(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getAssignmentAccess().getValueExprParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     expr=Expr
	 *
	 * Features:
	 *    expr[1, 1]
	 */
	protected void sequence_Atomic(EObject context, Expression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.EXPRESSION__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.EXPRESSION__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAtomicAccess().getExprExprParserRuleCall_4_1_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_Atomic(EObject context, NumberLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (statements+=Statement? statements+=Statement*)
	 *
	 * Features:
	 *    statements[0, *]
	 */
	protected void sequence_Block(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {GreaterComparisonType}
	 *
	 * Features:
	 */
	protected void sequence_ComparisonType(EObject context, GreaterComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {GreaterOrEqualComparisonType}
	 *
	 * Features:
	 */
	protected void sequence_ComparisonType(EObject context, GreaterOrEqualComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LessComparisonType}
	 *
	 * Features:
	 */
	protected void sequence_ComparisonType(EObject context, LessComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LessOrEqualComparisonType}
	 *
	 * Features:
	 */
	protected void sequence_ComparisonType(EObject context, LessOrEqualComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Comparison_Compare_1_0 type=ComparisonType right=Addition)
	 *
	 * Features:
	 *    left[1, 1]
	 *    type[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Comparison(EObject context, Compare semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=EqualsComparison_Equals_1_0 right=Comparison)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_EqualsComparison(EObject context, Equals semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {FalseLiteral}
	 *
	 * Features:
	 */
	protected void sequence_Expr(EObject context, FalseLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {TrueLiteral}
	 *
	 * Features:
	 */
	protected void sequence_Expr(EObject context, TrueLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (symbol=[Function|ID] actuals+=Expr? actuals+=Expr*)
	 *
	 * Features:
	 *    symbol[1, 1]
	 *    actuals[0, *]
	 */
	protected void sequence_FunctionCall(EObject context, FunctionRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (returnType=Type name=ID (params+=Parameter params+=Parameter*)? body=Block)
	 *
	 * Features:
	 *    returnType[1, 1]
	 *    name[1, 1]
	 *    params[0, *]
	 *    body[1, 1]
	 */
	protected void sequence_FunctionDeclaration(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expr then=Block else=Block?)
	 *
	 * Features:
	 *    condition[1, 1]
	 *    then[1, 1]
	 *    else[0, 1]
	 */
	protected void sequence_IfStatement(EObject context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((statements+=Statement | functions+=FunctionDeclaration)? (statements+=Statement | functions+=FunctionDeclaration)*)
	 *
	 * Features:
	 *    statements[0, *]
	 *    functions[0, *]
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {DivisionOp}
	 *
	 * Features:
	 */
	protected void sequence_MultiplicationType(EObject context, DivisionOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ModuloOp}
	 *
	 * Features:
	 */
	protected void sequence_MultiplicationType(EObject context, ModuloOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {MultiplicationOp}
	 *
	 * Features:
	 */
	protected void sequence_MultiplicationType(EObject context, MultiplicationOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Multi_1_0 type=MultiplicationType right=PostfixOperator)
	 *
	 * Features:
	 *    left[1, 1]
	 *    type[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication(EObject context, Multi semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=ID)
	 *
	 * Features:
	 *    type[1, 1]
	 *    name[1, 1]
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expr=PostfixOperator_ArrayAccess_1_0 index=Expr)
	 *
	 * Features:
	 *    expr[1, 1]
	 *    index[1, 1]
	 */
	protected void sequence_PostfixOperator(EObject context, ArrayAccess semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.EXPRESSION__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.EXPRESSION__EXPR));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ARRAY_ACCESS__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ARRAY_ACCESS__INDEX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0(), semanticObject.getExpr());
		feeder.accept(grammarAccess.getPostfixOperatorAccess().getIndexExprParserRuleCall_1_2_0(), semanticObject.getIndex());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     returnExpr=Expr
	 *
	 * Features:
	 *    returnExpr[1, 1]
	 */
	protected void sequence_ReturnStatement(EObject context, ReturnStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.RETURN_STATEMENT__RETURN_EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.RETURN_STATEMENT__RETURN_EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReturnStatementAccess().getReturnExprExprParserRuleCall_1_0(), semanticObject.getReturnExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {Annotation}
	 *
	 * Features:
	 */
	protected void sequence_Statement(EObject context, Annotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {BoolType}
	 *
	 * Features:
	 */
	protected void sequence_Type(EObject context, BoolType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {IntType}
	 *
	 * Features:
	 */
	protected void sequence_Type(EObject context, IntType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=ID initialValue=Expr)
	 *
	 * Features:
	 *    type[1, 1]
	 *    name[1, 1]
	 *    initialValue[1, 1]
	 */
	protected void sequence_VariableDeclaration(EObject context, Variable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.VARIABLE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.VARIABLE__TYPE));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.VARIABLE__NAME));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.VARIABLE__INITIAL_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.VARIABLE__INITIAL_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getVariableDeclarationAccess().getInitialValueExprParserRuleCall_2_1_0(), semanticObject.getInitialValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     symbol=[Variable|ID]
	 *
	 * Features:
	 *    symbol[1, 1]
	 */
	protected void sequence_VariableRef(EObject context, VariableRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expr body=Block)
	 *
	 * Features:
	 *    condition[1, 1]
	 *    body[1, 1]
	 */
	protected void sequence_WhileStatement(EObject context, WhileStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.WHILE_STATEMENT__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.WHILE_STATEMENT__CONDITION));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.WHILE_STATEMENT__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.WHILE_STATEMENT__BODY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getWhileStatementAccess().getConditionExprParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_2_0(), semanticObject.getBody());
		feeder.finish();
	}
}
