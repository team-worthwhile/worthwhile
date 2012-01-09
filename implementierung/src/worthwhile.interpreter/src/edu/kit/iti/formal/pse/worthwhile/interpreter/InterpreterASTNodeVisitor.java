/**
 *
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.util.Map;
import java.util.Set;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeVisitor;

/**
 *
 */
class InterpreterASTNodeVisitor extends ASTNodeVisitor {
    /**
	 *
	 */
    private Set<AbstractDebugEventListener> debugEventHandlers;

    /**
     * @return the debugEventHandlers
     */
    public Set<AbstractDebugEventListener> getDebugEventHandlers() {
	// begin-user-code
	return this.debugEventHandlers;
	// end-user-code
    }

    /**
     * @param debugEventHandlers
     *            the debugEventHandlers to set
     */
    public void setDebugEventHandlers(Set<AbstractDebugEventListener> debugEventHandlers) {
	// begin-user-code
	this.debugEventHandlers = debugEventHandlers;
	// end-user-code
    }

    /**
	 *
	 */
    private Map<String, Value> symbolMap;

    /**
     * @return the symbol map for the current visitor state
     */
    private Map<String, Value> getSymbolMap() {
	return this.symbolMap;
    }

    /**
	 *
	 */
    protected InterpreterASTNodeVisitor() {
	// begin-user-code
	// TODO Auto-generated constructor stub
	// end-user-code
    }

    /**
     * @param key
     * @return
     */
    protected Value getSymbol(String key) {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * @param key
     * @param value
     */
    protected void setSymbol(String key, Value value) {
	// begin-user-code
	// TODO Auto-generated method stub

	// end-user-code
    }

    /**
     * @return
     */
    protected Map<String, Value> getAllSymbols() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * Returns the value generated by the last return statement ran in this context
     * 
     * @return the return value or null if none is available
     */
    protected Value getReturnValue() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    /**
     * Adds a debug event handler to this context
     * 
     * @param handler
     */
    protected void addDebugEventHandler(AbstractDebugEventListener handler) {
	// begin-user-code
	// TODO Auto-generated method stub

	// end-user-code
    }

    /**
     * Removes a debug event handler from this context
     * 
     * @param handler
     */
    protected void removeDebugEventHandler(AbstractDebugEventListener handler) {
	// begin-user-code
	// TODO Auto-generated method stub

	// end-user-code
    }

    /**
     * @return
     */
    @Override
    protected InterpreterASTNodeVisitor clone() {
	// begin-user-code
	// TODO Auto-generated method stub
	return null;
	// end-user-code
    }

    public void visit(Addition addition) {
	// TODO Auto-generated method stub

    }

    public void visit(ArrayLength arrayLength) {
	// TODO Auto-generated method stub

    }

    public void visit(ArrayLiteral arrayLiteral) {
	// TODO Auto-generated method stub

    }

    public void visit(ArrayType arrayType) {
	// TODO Auto-generated method stub

    }

    public void visit(Assertion assertion) {
	// TODO Auto-generated method stub

    }

    public void visit(Assignment assignment) {
	// TODO Auto-generated method stub

    }

    public void visit(Assumption assumption) {
	// TODO Auto-generated method stub

    }

    public void visit(Axiom axiom) {
	// TODO Auto-generated method stub

    }

    public void visit(Block block) {
	// TODO Auto-generated method stub

    }

    public void visit(BooleanLiteral booleanLiteral) {
	// TODO Auto-generated method stub

    }

    public void visit(BooleanType booleanType) {
	// TODO Auto-generated method stub

    }

    public void visit(Conditional conditional) {
	// TODO Auto-generated method stub

    }

    public void visit(Conjunction conjunction) {
	// TODO Auto-generated method stub

    }

    public void visit(Disjunction disjunction) {
	// TODO Auto-generated method stub

    }

    public void visit(Division division) {
	// TODO Auto-generated method stub

    }

    public void visit(Equal equal) {
	// TODO Auto-generated method stub

    }

    public void visit(Equivalence equivalence) {
	// TODO Auto-generated method stub

    }

    public void visit(ExistsQuantifier existsQuantifier) {
	// TODO Auto-generated method stub

    }

    public void visit(ForAllQuantifier forAllQuantifier) {
	// TODO Auto-generated method stub

    }

    public void visit(FunctionCall functionCall) {
	// TODO Auto-generated method stub

    }

    public void visit(FunctionDeclaration functionDeclaration) {
	// TODO Auto-generated method stub

    }

    public void visit(Greater greater) {
	// TODO Auto-generated method stub

    }

    public void visit(GreaterOrEqual greaterOrEqual) {
	// TODO Auto-generated method stub

    }

    public void visit(Implication implication) {
	// TODO Auto-generated method stub

    }

    public void visit(IntegerLiteral integerLiteral) {
	// TODO Auto-generated method stub

    }

    public void visit(IntegerType integerType) {
	// TODO Auto-generated method stub

    }

    public void visit(Invariant invariant) {
	// TODO Auto-generated method stub

    }

    public void visit(Less less) {
	// TODO Auto-generated method stub

    }

    public void visit(LessOrEqual lessOrEqual) {
	// TODO Auto-generated method stub

    }

    public void visit(Loop loop) {
	// TODO Auto-generated method stub

    }

    public void visit(Minus minus) {
	// TODO Auto-generated method stub

    }

    public void visit(Modulus modulus) {
	// TODO Auto-generated method stub

    }

    public void visit(Multiplication multiplication) {
	// TODO Auto-generated method stub

    }

    public void visit(Negation negation) {
	// TODO Auto-generated method stub

    }

    @Override
    public void visit(ASTNode node) {
	// TODO Auto-generated method stub

    }

    public void visit(Plus plus) {
	// TODO Auto-generated method stub

    }

    public void visit(Postcondition postcondition) {
	// TODO Auto-generated method stub

    }

    public void visit(Precondition precondition) {
	// TODO Auto-generated method stub

    }

    public void visit(Program program) {
	// TODO Auto-generated method stub

    }

    public void visit(ReturnStatement returnStatement) {
	// TODO Auto-generated method stub

    }

    public void visit(Subtraction subtraction) {
	// TODO Auto-generated method stub

    }

    public void visit(Unequal unequal) {
	// TODO Auto-generated method stub

    }

    public void visit(VariableDeclaration variableDeclaration) {
	// TODO Auto-generated method stub

    }
}