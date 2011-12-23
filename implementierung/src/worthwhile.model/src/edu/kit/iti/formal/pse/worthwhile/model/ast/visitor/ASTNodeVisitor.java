/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Axiom;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Loop;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Minus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Modulus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Multiplication;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Negation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Plus;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Postcondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Precondition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AST Node Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNodeVisitor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ASTNodeVisitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model additionRequired="true" additionOrdered="false"
	 * @generated
	 */
	void visit(Addition addition);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model arrayAccessRequired="true" arrayAccessOrdered="false"
	 * @generated
	 */
	void visit(ArrayAccess arrayAccess);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model arrayLengthRequired="true" arrayLengthOrdered="false"
	 * @generated
	 */
	void visit(ArrayLength arrayLength);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model arrayLiteralRequired="true" arrayLiteralOrdered="false"
	 * @generated
	 */
	void visit(ArrayLiteral arrayLiteral);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model arrayTypeRequired="true" arrayTypeOrdered="false"
	 * @generated
	 */
	void visit(ArrayType arrayType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model assertionRequired="true" assertionOrdered="false"
	 * @generated
	 */
	void visit(Assertion assertion);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model assignmentRequired="true" assignmentOrdered="false"
	 * @generated
	 */
	void visit(Assignment assignment);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model assumptionRequired="true" assumptionOrdered="false"
	 * @generated
	 */
	void visit(Assumption assumption);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model axiomRequired="true" axiomOrdered="false"
	 * @generated
	 */
	void visit(Axiom axiom);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model blockRequired="true" blockOrdered="false"
	 * @generated
	 */
	void visit(Block block);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model booleanLiteralRequired="true" booleanLiteralOrdered="false"
	 * @generated
	 */
	void visit(BooleanLiteral booleanLiteral);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model booleanTypeRequired="true" booleanTypeOrdered="false"
	 * @generated
	 */
	void visit(BooleanType booleanType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model conditionalRequired="true" conditionalOrdered="false"
	 * @generated
	 */
	void visit(Conditional conditional);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model conjunctionRequired="true" conjunctionOrdered="false"
	 * @generated
	 */
	void visit(Conjunction conjunction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model disjunctionRequired="true" disjunctionOrdered="false"
	 * @generated
	 */
	void visit(Disjunction disjunction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model divisionRequired="true" divisionOrdered="false"
	 * @generated
	 */
	void visit(Division division);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model equalRequired="true" equalOrdered="false"
	 * @generated
	 */
	void visit(Equal equal);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model equivalenceRequired="true" equivalenceOrdered="false"
	 * @generated
	 */
	void visit(Equivalence equivalence);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model existsQuantifierRequired="true" existsQuantifierOrdered="false"
	 * @generated
	 */
	void visit(ExistsQuantifier existsQuantifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model forAllQuantifierRequired="true" forAllQuantifierOrdered="false"
	 * @generated
	 */
	void visit(ForAllQuantifier forAllQuantifier);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model functionCallRequired="true" functionCallOrdered="false"
	 * @generated
	 */
	void visit(FunctionCall functionCall);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model functionDeclarationRequired="true" functionDeclarationOrdered="false"
	 * @generated
	 */
	void visit(FunctionDeclaration functionDeclaration);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model greaterRequired="true" greaterOrdered="false"
	 * @generated
	 */
	void visit(Greater greater);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model greaterOrEqualRequired="true" greaterOrEqualOrdered="false"
	 * @generated
	 */
	void visit(GreaterOrEqual greaterOrEqual);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model implicationRequired="true" implicationOrdered="false"
	 * @generated
	 */
	void visit(Implication implication);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model integerLiteralRequired="true" integerLiteralOrdered="false"
	 * @generated
	 */
	void visit(IntegerLiteral integerLiteral);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model integerTypeRequired="true" integerTypeOrdered="false"
	 * @generated
	 */
	void visit(IntegerType integerType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model invariantRequired="true" invariantOrdered="false"
	 * @generated
	 */
	void visit(Invariant invariant);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model lessRequired="true" lessOrdered="false"
	 * @generated
	 */
	void visit(Less less);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model lessOrEqualRequired="true" lessOrEqualOrdered="false"
	 * @generated
	 */
	void visit(LessOrEqual lessOrEqual);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model loopRequired="true" loopOrdered="false"
	 * @generated
	 */
	void visit(Loop loop);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model minusRequired="true" minusOrdered="false"
	 * @generated
	 */
	void visit(Minus minus);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model modulusRequired="true" modulusOrdered="false"
	 * @generated
	 */
	void visit(Modulus modulus);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model multiplicationRequired="true" multiplicationOrdered="false"
	 * @generated
	 */
	void visit(Multiplication multiplication);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model negationRequired="true" negationOrdered="false"
	 * @generated
	 */
	void visit(Negation negation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodeRequired="true" nodeOrdered="false"
	 * @generated
	 */
	void visit(ASTNode node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model plusRequired="true" plusOrdered="false"
	 * @generated
	 */
	void visit(Plus plus);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model postconditionRequired="true" postconditionOrdered="false"
	 * @generated
	 */
	void visit(Postcondition postcondition);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model preconditionRequired="true" preconditionOrdered="false"
	 * @generated
	 */
	void visit(Precondition precondition);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model programRequired="true" programOrdered="false"
	 * @generated
	 */
	void visit(Program program);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model returnStatementRequired="true" returnStatementOrdered="false"
	 * @generated
	 */
	void visit(ReturnStatement returnStatement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model subtractionRequired="true" subtractionOrdered="false"
	 * @generated
	 */
	void visit(Subtraction subtraction);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unequalRequired="true" unequalOrdered="false"
	 * @generated
	 */
	void visit(Unequal unequal);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model variableDeclarationRequired="true" variableDeclarationOrdered="false"
	 * @generated
	 */
	void visit(VariableDeclaration variableDeclaration);

} // ASTNodeVisitor
