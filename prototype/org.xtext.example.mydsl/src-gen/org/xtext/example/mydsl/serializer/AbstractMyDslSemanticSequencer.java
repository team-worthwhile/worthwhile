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
import org.xtext.example.mydsl.myDsl.Annotation;
import org.xtext.example.mydsl.myDsl.ArrayAccess;
import org.xtext.example.mydsl.myDsl.ArrayType;
import org.xtext.example.mydsl.myDsl.Assignment;
import org.xtext.example.mydsl.myDsl.Block;
import org.xtext.example.mydsl.myDsl.BoolType;
import org.xtext.example.mydsl.myDsl.EqualComparisonType;
import org.xtext.example.mydsl.myDsl.Equals;
import org.xtext.example.mydsl.myDsl.FalseLiteral;
import org.xtext.example.mydsl.myDsl.FunctionCall;
import org.xtext.example.mydsl.myDsl.FunctionDeclaration;
import org.xtext.example.mydsl.myDsl.GreaterComparisonType;
import org.xtext.example.mydsl.myDsl.GreaterOrEqualComparisonType;
import org.xtext.example.mydsl.myDsl.IfStatement;
import org.xtext.example.mydsl.myDsl.IntType;
import org.xtext.example.mydsl.myDsl.LessComparisonType;
import org.xtext.example.mydsl.myDsl.LessOrEqualComparisonType;
import org.xtext.example.mydsl.myDsl.Model;
import org.xtext.example.mydsl.myDsl.Multi;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.NoOp;
import org.xtext.example.mydsl.myDsl.NumberLiteral;
import org.xtext.example.mydsl.myDsl.Parameter;
import org.xtext.example.mydsl.myDsl.Plus;
import org.xtext.example.mydsl.myDsl.ReturnStatement;
import org.xtext.example.mydsl.myDsl.SymbolRef;
import org.xtext.example.mydsl.myDsl.TrueLiteral;
import org.xtext.example.mydsl.myDsl.VariableDeclaration;
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
				   context == grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorsRule()) {
					sequence_PostfixOperators(context, (ArrayAccess) semanticObject); 
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
			case MyDslPackage.EQUAL_COMPARISON_TYPE:
				if(context == grammarAccess.getComparisonTypeRule() ||
				   context == grammarAccess.getEqualComparisonTypeRule()) {
					sequence_ComparisonType(context, (EqualComparisonType) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.EQUALS:
				if(context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getExprRule()) {
					sequence_Comparison(context, (Equals) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.FALSE_LITERAL:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getFalseLiteralRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorsRule() ||
				   context == grammarAccess.getPostfixOperatorsAccess().getArrayAccessExprAction_1_0()) {
					sequence_Expr(context, (FalseLiteral) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.FUNCTION_CALL:
				if(context == grammarAccess.getFunctionCallRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (FunctionCall) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.FUNCTION_DECLARATION:
				if(context == grammarAccess.getFunctionDeclarationRule()) {
					sequence_FunctionDeclaration(context, (FunctionDeclaration) semanticObject); 
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
					sequence_Statement(context, (IfStatement) semanticObject); 
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
			case MyDslPackage.MULTI:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0()) {
					sequence_Multiplication(context, (Multi) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.NO_OP:
				if(context == grammarAccess.getNoOpRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Statement(context, (NoOp) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.NUMBER_LITERAL:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorsRule() ||
				   context == grammarAccess.getPostfixOperatorsAccess().getArrayAccessExprAction_1_0()) {
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
				   context == grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0() ||
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
			case MyDslPackage.SYMBOL_REF:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorsRule() ||
				   context == grammarAccess.getPostfixOperatorsAccess().getArrayAccessExprAction_1_0()) {
					sequence_Atomic(context, (SymbolRef) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.TRUE_LITERAL:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0() ||
				   context == grammarAccess.getAtomicRule() ||
				   context == grammarAccess.getBooleanLiteralRule() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0() ||
				   context == grammarAccess.getExprRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0() ||
				   context == grammarAccess.getPostfixOperatorsRule() ||
				   context == grammarAccess.getPostfixOperatorsAccess().getArrayAccessExprAction_1_0() ||
				   context == grammarAccess.getTrueLiteralRule()) {
					sequence_Expr(context, (TrueLiteral) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.VARIABLE_DECLARATION:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getVariableDeclarationRule()) {
					sequence_VariableDeclaration(context, (VariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case MyDslPackage.WHILE_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getWhileStatementRule()) {
					sequence_Statement(context, (WhileStatement) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=Addition_Plus_1_0 right=Multiplication)
	 */
	protected void sequence_Addition(EObject context, Plus semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.PLUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.PLUS__LEFT));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.PLUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.PLUS__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     baseType=PrimitiveType
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
	 *     (variable=ID value=Expr)
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
		feeder.accept(grammarAccess.getAssignmentAccess().getVariableIDTerminalRuleCall_0_0(), semanticObject.getVariable());
		feeder.accept(grammarAccess.getAssignmentAccess().getValueExprParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_Atomic(EObject context, NumberLiteral semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.NUMBER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.NUMBER_LITERAL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (symbol=[Symbol|ID] (actuals+=Expr? actuals+=Expr*)?)
	 */
	protected void sequence_Atomic(EObject context, SymbolRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (statements+=Statement*)
	 */
	protected void sequence_Block(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {EqualComparisonType}
	 */
	protected void sequence_ComparisonType(EObject context, EqualComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {GreaterComparisonType}
	 */
	protected void sequence_ComparisonType(EObject context, GreaterComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {GreaterOrEqualComparisonType}
	 */
	protected void sequence_ComparisonType(EObject context, GreaterOrEqualComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LessComparisonType}
	 */
	protected void sequence_ComparisonType(EObject context, LessComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LessOrEqualComparisonType}
	 */
	protected void sequence_ComparisonType(EObject context, LessOrEqualComparisonType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Comparison_Equals_1_0 type=ComparisonType right=Addition)
	 */
	protected void sequence_Comparison(EObject context, Equals semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.EQUALS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.EQUALS__LEFT));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.EQUALS__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.EQUALS__TYPE));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.EQUALS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.EQUALS__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getComparisonAccess().getTypeComparisonTypeParserRuleCall_1_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {FalseLiteral}
	 */
	protected void sequence_Expr(EObject context, FalseLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {TrueLiteral}
	 */
	protected void sequence_Expr(EObject context, TrueLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (returnType=Type name=ID (params+=Parameter params+=Parameter*)? body=Block)
	 */
	protected void sequence_FunctionDeclaration(EObject context, FunctionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (statements+=Statement | functions+=FunctionDeclaration)*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Multi_1_0 right=PostfixOperators)
	 */
	protected void sequence_Multiplication(EObject context, Multi semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.MULTI__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.MULTI__LEFT));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.MULTI__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.MULTI__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicationAccess().getRightPostfixOperatorsParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=ID)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.PARAMETER__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.PARAMETER__TYPE));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.PARAMETER__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_1_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expr=PostfixOperators_ArrayAccess_1_0 index=Expr)
	 */
	protected void sequence_PostfixOperators(EObject context, ArrayAccess semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ARRAY_ACCESS__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ARRAY_ACCESS__EXPR));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.ARRAY_ACCESS__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.ARRAY_ACCESS__INDEX));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPostfixOperatorsAccess().getArrayAccessExprAction_1_0(), semanticObject.getExpr());
		feeder.accept(grammarAccess.getPostfixOperatorsAccess().getIndexExprParserRuleCall_1_2_0(), semanticObject.getIndex());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     returnExpr=Expr
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
	 */
	protected void sequence_Statement(EObject context, Annotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {FunctionCall}
	 */
	protected void sequence_Statement(EObject context, FunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {IfStatement}
	 */
	protected void sequence_Statement(EObject context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {NoOp}
	 */
	protected void sequence_Statement(EObject context, NoOp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {WhileStatement}
	 */
	protected void sequence_Statement(EObject context, WhileStatement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {BoolType}
	 */
	protected void sequence_Type(EObject context, BoolType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {IntType}
	 */
	protected void sequence_Type(EObject context, IntType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=Type name=ID initialValue=Expr)
	 */
	protected void sequence_VariableDeclaration(EObject context, VariableDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.VARIABLE_DECLARATION__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.VARIABLE_DECLARATION__TYPE));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.VARIABLE_DECLARATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.VARIABLE_DECLARATION__NAME));
			if(transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.VARIABLE_DECLARATION__INITIAL_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.VARIABLE_DECLARATION__INITIAL_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getVariableDeclarationAccess().getInitialValueExprParserRuleCall_2_1_0(), semanticObject.getInitialValue());
		feeder.finish();
	}
}
