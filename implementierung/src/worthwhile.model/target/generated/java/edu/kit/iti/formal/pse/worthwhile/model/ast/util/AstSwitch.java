/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import edu.kit.iti.formal.pse.worthwhile.model.ast.*;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayFunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BinaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.BooleanType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conditional;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Conjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Disjunction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Division;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Equivalence;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExistsQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ExpressionEvaluation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ForAllQuantifier;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Greater;
import edu.kit.iti.formal.pse.worthwhile.model.ast.GreaterOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Implication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.IntegerType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Invariant;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Less;
import edu.kit.iti.formal.pse.worthwhile.model.ast.LessOrEqual;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Literal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.PrimitiveType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage
 * @generated
 */
public class AstSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static AstPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AstSwitch() {
		if (modelPackage == null) {
			modelPackage = AstPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AstPackage.PROGRAM: {
				Program program = (Program) theEObject;
				T result = caseProgram(program);
				if (result == null)
					result = caseASTNode(program);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.AST_NODE: {
				ASTNode astNode = (ASTNode) theEObject;
				T result = caseASTNode(astNode);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ADDITION: {
				Addition addition = (Addition) theEObject;
				T result = caseAddition(addition);
				if (result == null)
					result = caseBinaryExpression(addition);
				if (result == null)
					result = caseExpression(addition);
				if (result == null)
					result = caseASTNode(addition);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BINARY_EXPRESSION: {
				BinaryExpression binaryExpression = (BinaryExpression) theEObject;
				T result = caseBinaryExpression(binaryExpression);
				if (result == null)
					result = caseExpression(binaryExpression);
				if (result == null)
					result = caseASTNode(binaryExpression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EXPRESSION: {
				Expression expression = (Expression) theEObject;
				T result = caseExpression(expression);
				if (result == null)
					result = caseASTNode(expression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression) theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null)
					result = caseExpression(unaryExpression);
				if (result == null)
					result = caseASTNode(unaryExpression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_LITERAL: {
				ArrayLiteral arrayLiteral = (ArrayLiteral) theEObject;
				T result = caseArrayLiteral(arrayLiteral);
				if (result == null)
					result = caseLiteral(arrayLiteral);
				if (result == null)
					result = caseExpression(arrayLiteral);
				if (result == null)
					result = caseASTNode(arrayLiteral);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LITERAL: {
				Literal literal = (Literal) theEObject;
				T result = caseLiteral(literal);
				if (result == null)
					result = caseExpression(literal);
				if (result == null)
					result = caseASTNode(literal);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_TYPE: {
				ArrayType arrayType = (ArrayType) theEObject;
				T result = caseArrayType(arrayType);
				if (result == null)
					result = caseType(arrayType);
				if (result == null)
					result = caseASTNode(arrayType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.TYPE: {
				Type type = (Type) theEObject;
				T result = caseType(type);
				if (result == null)
					result = caseASTNode(type);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType) theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null)
					result = caseType(primitiveType);
				if (result == null)
					result = caseASTNode(primitiveType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ASSERTION: {
				Assertion assertion = (Assertion) theEObject;
				T result = caseAssertion(assertion);
				if (result == null)
					result = caseAnnotation(assertion);
				if (result == null)
					result = caseStatement(assertion);
				if (result == null)
					result = caseASTNode(assertion);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.GUARD_ASSERTION: {
				GuardAssertion guardAssertion = (GuardAssertion) theEObject;
				T result = caseGuardAssertion(guardAssertion);
				if (result == null)
					result = caseAssertion(guardAssertion);
				if (result == null)
					result = caseAnnotation(guardAssertion);
				if (result == null)
					result = caseStatement(guardAssertion);
				if (result == null)
					result = caseASTNode(guardAssertion);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FUNCTION_CALL_PRECONDITION_ASSERTION: {
				FunctionCallPreconditionAssertion functionCallPreconditionAssertion = (FunctionCallPreconditionAssertion) theEObject;
				T result = caseFunctionCallPreconditionAssertion(functionCallPreconditionAssertion);
				if (result == null)
					result = caseGuardAssertion(functionCallPreconditionAssertion);
				if (result == null)
					result = caseAssertion(functionCallPreconditionAssertion);
				if (result == null)
					result = caseAnnotation(functionCallPreconditionAssertion);
				if (result == null)
					result = caseStatement(functionCallPreconditionAssertion);
				if (result == null)
					result = caseASTNode(functionCallPreconditionAssertion);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.DIVISOR_NOT_ZERO_ASSERTION: {
				DivisorNotZeroAssertion divisorNotZeroAssertion = (DivisorNotZeroAssertion) theEObject;
				T result = caseDivisorNotZeroAssertion(divisorNotZeroAssertion);
				if (result == null)
					result = caseGuardAssertion(divisorNotZeroAssertion);
				if (result == null)
					result = caseAssertion(divisorNotZeroAssertion);
				if (result == null)
					result = caseAnnotation(divisorNotZeroAssertion);
				if (result == null)
					result = caseStatement(divisorNotZeroAssertion);
				if (result == null)
					result = caseASTNode(divisorNotZeroAssertion);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ANNOTATION: {
				Annotation annotation = (Annotation) theEObject;
				T result = caseAnnotation(annotation);
				if (result == null)
					result = caseStatement(annotation);
				if (result == null)
					result = caseASTNode(annotation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment) theEObject;
				T result = caseAssignment(assignment);
				if (result == null)
					result = caseStatement(assignment);
				if (result == null)
					result = caseASTNode(assignment);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration) theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null)
					result = caseStatement(variableDeclaration);
				if (result == null)
					result = caseASTNode(variableDeclaration);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ASSUMPTION: {
				Assumption assumption = (Assumption) theEObject;
				T result = caseAssumption(assumption);
				if (result == null)
					result = caseAnnotation(assumption);
				if (result == null)
					result = caseStatement(assumption);
				if (result == null)
					result = caseASTNode(assumption);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.AXIOM: {
				Axiom axiom = (Axiom) theEObject;
				T result = caseAxiom(axiom);
				if (result == null)
					result = caseAnnotation(axiom);
				if (result == null)
					result = caseStatement(axiom);
				if (result == null)
					result = caseASTNode(axiom);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BLOCK: {
				Block block = (Block) theEObject;
				T result = caseBlock(block);
				if (result == null)
					result = caseStatement(block);
				if (result == null)
					result = caseASTNode(block);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral) theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null)
					result = caseLiteral(booleanLiteral);
				if (result == null)
					result = caseExpression(booleanLiteral);
				if (result == null)
					result = caseASTNode(booleanLiteral);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType) theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null)
					result = casePrimitiveType(booleanType);
				if (result == null)
					result = caseType(booleanType);
				if (result == null)
					result = caseASTNode(booleanType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.CONDITIONAL: {
				Conditional conditional = (Conditional) theEObject;
				T result = caseConditional(conditional);
				if (result == null)
					result = caseStatement(conditional);
				if (result == null)
					result = caseASTNode(conditional);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.CONJUNCTION: {
				Conjunction conjunction = (Conjunction) theEObject;
				T result = caseConjunction(conjunction);
				if (result == null)
					result = caseBinaryExpression(conjunction);
				if (result == null)
					result = caseExpression(conjunction);
				if (result == null)
					result = caseASTNode(conjunction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.DISJUNCTION: {
				Disjunction disjunction = (Disjunction) theEObject;
				T result = caseDisjunction(disjunction);
				if (result == null)
					result = caseBinaryExpression(disjunction);
				if (result == null)
					result = caseExpression(disjunction);
				if (result == null)
					result = caseASTNode(disjunction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.DIVISION: {
				Division division = (Division) theEObject;
				T result = caseDivision(division);
				if (result == null)
					result = caseBinaryExpression(division);
				if (result == null)
					result = caseExpression(division);
				if (result == null)
					result = caseASTNode(division);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EQUAL: {
				Equal equal = (Equal) theEObject;
				T result = caseEqual(equal);
				if (result == null)
					result = caseBinaryExpression(equal);
				if (result == null)
					result = caseExpression(equal);
				if (result == null)
					result = caseASTNode(equal);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EQUIVALENCE: {
				Equivalence equivalence = (Equivalence) theEObject;
				T result = caseEquivalence(equivalence);
				if (result == null)
					result = caseBinaryExpression(equivalence);
				if (result == null)
					result = caseExpression(equivalence);
				if (result == null)
					result = caseASTNode(equivalence);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EXISTS_QUANTIFIER: {
				ExistsQuantifier existsQuantifier = (ExistsQuantifier) theEObject;
				T result = caseExistsQuantifier(existsQuantifier);
				if (result == null)
					result = caseQuantifiedExpression(existsQuantifier);
				if (result == null)
					result = caseExpression(existsQuantifier);
				if (result == null)
					result = caseASTNode(existsQuantifier);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.QUANTIFIED_EXPRESSION: {
				QuantifiedExpression quantifiedExpression = (QuantifiedExpression) theEObject;
				T result = caseQuantifiedExpression(quantifiedExpression);
				if (result == null)
					result = caseExpression(quantifiedExpression);
				if (result == null)
					result = caseASTNode(quantifiedExpression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FOR_ALL_QUANTIFIER: {
				ForAllQuantifier forAllQuantifier = (ForAllQuantifier) theEObject;
				T result = caseForAllQuantifier(forAllQuantifier);
				if (result == null)
					result = caseQuantifiedExpression(forAllQuantifier);
				if (result == null)
					result = caseExpression(forAllQuantifier);
				if (result == null)
					result = caseASTNode(forAllQuantifier);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FUNCTION_CALL: {
				FunctionCall functionCall = (FunctionCall) theEObject;
				T result = caseFunctionCall(functionCall);
				if (result == null)
					result = caseExpression(functionCall);
				if (result == null)
					result = caseASTNode(functionCall);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FUNCTION_DECLARATION: {
				FunctionDeclaration functionDeclaration = (FunctionDeclaration) theEObject;
				T result = caseFunctionDeclaration(functionDeclaration);
				if (result == null)
					result = caseASTNode(functionDeclaration);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.PRECONDITION: {
				Precondition precondition = (Precondition) theEObject;
				T result = casePrecondition(precondition);
				if (result == null)
					result = caseAnnotation(precondition);
				if (result == null)
					result = caseStatement(precondition);
				if (result == null)
					result = caseASTNode(precondition);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.POSTCONDITION: {
				Postcondition postcondition = (Postcondition) theEObject;
				T result = casePostcondition(postcondition);
				if (result == null)
					result = caseAnnotation(postcondition);
				if (result == null)
					result = caseStatement(postcondition);
				if (result == null)
					result = caseASTNode(postcondition);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.GREATER: {
				Greater greater = (Greater) theEObject;
				T result = caseGreater(greater);
				if (result == null)
					result = caseBinaryExpression(greater);
				if (result == null)
					result = caseExpression(greater);
				if (result == null)
					result = caseASTNode(greater);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.GREATER_OR_EQUAL: {
				GreaterOrEqual greaterOrEqual = (GreaterOrEqual) theEObject;
				T result = caseGreaterOrEqual(greaterOrEqual);
				if (result == null)
					result = caseBinaryExpression(greaterOrEqual);
				if (result == null)
					result = caseExpression(greaterOrEqual);
				if (result == null)
					result = caseASTNode(greaterOrEqual);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.IMPLICATION: {
				Implication implication = (Implication) theEObject;
				T result = caseImplication(implication);
				if (result == null)
					result = caseBinaryExpression(implication);
				if (result == null)
					result = caseExpression(implication);
				if (result == null)
					result = caseASTNode(implication);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.INTEGER_LITERAL: {
				IntegerLiteral integerLiteral = (IntegerLiteral) theEObject;
				T result = caseIntegerLiteral(integerLiteral);
				if (result == null)
					result = caseLiteral(integerLiteral);
				if (result == null)
					result = caseExpression(integerLiteral);
				if (result == null)
					result = caseASTNode(integerLiteral);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType) theEObject;
				T result = caseIntegerType(integerType);
				if (result == null)
					result = casePrimitiveType(integerType);
				if (result == null)
					result = caseType(integerType);
				if (result == null)
					result = caseASTNode(integerType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.INVARIANT: {
				Invariant invariant = (Invariant) theEObject;
				T result = caseInvariant(invariant);
				if (result == null)
					result = caseAnnotation(invariant);
				if (result == null)
					result = caseStatement(invariant);
				if (result == null)
					result = caseASTNode(invariant);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LESS: {
				Less less = (Less) theEObject;
				T result = caseLess(less);
				if (result == null)
					result = caseBinaryExpression(less);
				if (result == null)
					result = caseExpression(less);
				if (result == null)
					result = caseASTNode(less);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LESS_OR_EQUAL: {
				LessOrEqual lessOrEqual = (LessOrEqual) theEObject;
				T result = caseLessOrEqual(lessOrEqual);
				if (result == null)
					result = caseBinaryExpression(lessOrEqual);
				if (result == null)
					result = caseExpression(lessOrEqual);
				if (result == null)
					result = caseASTNode(lessOrEqual);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LOOP: {
				Loop loop = (Loop) theEObject;
				T result = caseLoop(loop);
				if (result == null)
					result = caseStatement(loop);
				if (result == null)
					result = caseASTNode(loop);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.MINUS: {
				Minus minus = (Minus) theEObject;
				T result = caseMinus(minus);
				if (result == null)
					result = caseSign(minus);
				if (result == null)
					result = caseUnaryExpression(minus);
				if (result == null)
					result = caseExpression(minus);
				if (result == null)
					result = caseASTNode(minus);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.SIGN: {
				Sign sign = (Sign) theEObject;
				T result = caseSign(sign);
				if (result == null)
					result = caseUnaryExpression(sign);
				if (result == null)
					result = caseExpression(sign);
				if (result == null)
					result = caseASTNode(sign);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.MODULUS: {
				Modulus modulus = (Modulus) theEObject;
				T result = caseModulus(modulus);
				if (result == null)
					result = caseBinaryExpression(modulus);
				if (result == null)
					result = caseExpression(modulus);
				if (result == null)
					result = caseASTNode(modulus);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.MULTIPLICATION: {
				Multiplication multiplication = (Multiplication) theEObject;
				T result = caseMultiplication(multiplication);
				if (result == null)
					result = caseBinaryExpression(multiplication);
				if (result == null)
					result = caseExpression(multiplication);
				if (result == null)
					result = caseASTNode(multiplication);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.NEGATION: {
				Negation negation = (Negation) theEObject;
				T result = caseNegation(negation);
				if (result == null)
					result = caseUnaryExpression(negation);
				if (result == null)
					result = caseExpression(negation);
				if (result == null)
					result = caseASTNode(negation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.PLUS: {
				Plus plus = (Plus) theEObject;
				T result = casePlus(plus);
				if (result == null)
					result = caseSign(plus);
				if (result == null)
					result = caseUnaryExpression(plus);
				if (result == null)
					result = caseExpression(plus);
				if (result == null)
					result = caseASTNode(plus);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.RETURN_STATEMENT: {
				ReturnStatement returnStatement = (ReturnStatement) theEObject;
				T result = caseReturnStatement(returnStatement);
				if (result == null)
					result = caseStatement(returnStatement);
				if (result == null)
					result = caseASTNode(returnStatement);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.SUBTRACTION: {
				Subtraction subtraction = (Subtraction) theEObject;
				T result = caseSubtraction(subtraction);
				if (result == null)
					result = caseBinaryExpression(subtraction);
				if (result == null)
					result = caseExpression(subtraction);
				if (result == null)
					result = caseASTNode(subtraction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.UNEQUAL: {
				Unequal unequal = (Unequal) theEObject;
				T result = caseUnequal(unequal);
				if (result == null)
					result = caseBinaryExpression(unequal);
				if (result == null)
					result = caseExpression(unequal);
				if (result == null)
					result = caseASTNode(unequal);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference) theEObject;
				T result = caseVariableReference(variableReference);
				if (result == null)
					result = caseExpression(variableReference);
				if (result == null)
					result = caseASTNode(variableReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.STATEMENT: {
				Statement statement = (Statement) theEObject;
				T result = caseStatement(statement);
				if (result == null)
					result = caseASTNode(statement);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.RETURN_VALUE_REFERENCE: {
				ReturnValueReference returnValueReference = (ReturnValueReference) theEObject;
				T result = caseReturnValueReference(returnValueReference);
				if (result == null)
					result = caseExpression(returnValueReference);
				if (result == null)
					result = caseASTNode(returnValueReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EXPRESSION_EVALUATION: {
				ExpressionEvaluation expressionEvaluation = (ExpressionEvaluation) theEObject;
				T result = caseExpressionEvaluation(expressionEvaluation);
				if (result == null)
					result = caseASTNode(expressionEvaluation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_FUNCTION: {
				ArrayFunction arrayFunction = (ArrayFunction) theEObject;
				T result = caseArrayFunction(arrayFunction);
				if (result == null)
					result = caseLiteral(arrayFunction);
				if (result == null)
					result = caseExpression(arrayFunction);
				if (result == null)
					result = caseASTNode(arrayFunction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_FUNCTION_ACCESS: {
				ArrayFunctionAccess arrayFunctionAccess = (ArrayFunctionAccess) theEObject;
				T result = caseArrayFunctionAccess(arrayFunctionAccess);
				if (result == null)
					result = caseExpression(arrayFunctionAccess);
				if (result == null)
					result = caseASTNode(arrayFunctionAccess);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EXPRESSION_TO_EXPRESSION_MAP: {
				@SuppressWarnings("unchecked")
				Map.Entry<Expression, Expression> expressionToExpressionMap = (Map.Entry<Expression, Expression>) theEObject;
				T result = caseExpressionToExpressionMap(expressionToExpressionMap);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AST Node</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AST Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseASTNode(ASTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Addition</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Addition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddition(Addition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpression(BinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Literal</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayLiteral(ArrayLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayType(ArrayType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assertion</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertion(Assertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardAssertion(GuardAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Call Precondition Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Call Precondition Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionCallPreconditionAssertion(FunctionCallPreconditionAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Divisor Not Zero Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Divisor Not Zero Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivisorNotZeroAssertion(DivisorNotZeroAssertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assumption</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assumption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssumption(Assumption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Axiom</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Axiom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAxiom(Axiom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditional(Conditional object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conjunction</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conjunction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConjunction(Conjunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disjunction</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disjunction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisjunction(Disjunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Division</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Division</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivision(Division object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equal</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqual(Equal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalence</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquivalence(Equivalence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exists Quantifier</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exists Quantifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistsQuantifier(ExistsQuantifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quantified Expression</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quantified Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuantifiedExpression(QuantifiedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For All Quantifier</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For All Quantifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForAllQuantifier(ForAllQuantifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionCall(FunctionCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Declaration</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDeclaration(FunctionDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Precondition</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Precondition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrecondition(Precondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postcondition</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postcondition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostcondition(Postcondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreater(Greater object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Or Equal</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Or Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterOrEqual(GreaterOrEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implication</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implication</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplication(Implication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invariant</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invariant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvariant(Invariant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLess(Less object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Or Equal</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Or Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessOrEqual(LessOrEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoop(Loop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Minus</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinus(Minus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sign</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sign</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSign(Sign object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modulus</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modulus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModulus(Modulus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplication</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplication</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplication(Multiplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Negation</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Negation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNegation(Negation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plus</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlus(Plus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnStatement(ReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subtraction</em>'.
	 * <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subtraction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubtraction(Subtraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unequal</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unequal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnequal(Unequal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableReference(VariableReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Value Reference</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Value Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnValueReference(ReturnValueReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Evaluation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionEvaluation(ExpressionEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Function</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayFunction(ArrayFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Function Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Function Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayFunctionAccess(ArrayFunctionAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression To Expression Map</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *                the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression To Expression Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionToExpressionMap(Map.Entry<Expression, Expression> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch, but this is the last
	 * case anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // AstSwitch
