package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayAccess;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Sign;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.UnaryExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;

/**
 * A visitor interface that can visit any ASTNode object
 * 
 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage#getASTNodeVisitor()
 */
public abstract class ASTNodeVisitor {

    private void throwUnsupportedASTNodeTypeException() {
	throw new UnsupportedOperationException("Visitor cannot Handle this type of ASTNode!");
    }

    public void visit(ASTNode node) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Addition conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Annotation conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(ArrayAccess conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(ArrayLength conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(ArrayLiteral conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(ArrayType conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Assertion conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Assignment conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Assumption conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Axiom conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(BinaryExpression conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Block conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(BooleanLiteral conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(BooleanType conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Conditional conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Conjunction conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Disjunction conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Division conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Equal conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Equivalence conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(ExistsQuantifier conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Expression conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(ForAllQuantifier conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(FunctionCall conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(FunctionDeclaration conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Greater conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(GreaterOrEqual conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Implication conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(IntegerLiteral conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(IntegerType conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Invariant conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Less conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(LessOrEqual conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Literal conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Loop conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Minus conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Modulus conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Multiplication conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Negation conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Plus conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Postcondition conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Precondition conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(PrimitiveType conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Program conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(QuantifiedExpression conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(ReturnStatement conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Sign conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Statement conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Type conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(UnaryExpression conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(Unequal conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(VariableDeclaration conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }

    public void visit(VariableReference conjunction) {
	this.throwUnsupportedASTNodeTypeException();
    }
}
