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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;

/**
 *
 */
class InterpreterASTNodeVisitor extends HierarchialASTNodeVisitor {
	/**
	 *
	 */
	private Set<AbstractExecutionEventListener> executionEventHandlers;

	/**
	 * @return the executionEventHandlers
	 */
	public Set<AbstractExecutionEventListener> getExecutionEventHandlers() {
		// begin-user-code
		return this.executionEventHandlers;
		// end-user-code
	}

	/**
	 * @param executionEventHandlers
	 *                the executionEventHandlers to set
	 */
	public void setExecutionEventHandlers(Set<AbstractExecutionEventListener> executionEventHandlers) {
		// begin-user-code
		this.executionEventHandlers = executionEventHandlers;
		// end-user-code
	}

	/**
	 *
	 */
	private Map<String, Value> symbolMap;

	/**
	 * @param key
	 * @return
	 */
	protected Value getSymbol(String key) {
		return this.symbolMap.get(key);
	}

	/**
	 * @param key
	 * @param value
	 */
	protected void setSymbol(String key, Value value) {
		this.symbolMap.put(key, value);
	}

	/**
	 * @return
	 */
	protected Map<String, Value> getAllSymbols() {
		return this.symbolMap;
	}
	
	/**
	 *
	 */
	protected InterpreterASTNodeVisitor() {
	}
	
	/**
	 * 
	 * @param statement
	 */
	private void statementExecuted(Statement statement) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.statementExecuted(statement);
		}
	}

	/**
	 * 
	 * @param statement
	 */
	private void statementWillExecute(Statement statement) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.statementWillExecute(statement);
		}
	}

	/**
	 * 
	 * @param statement
	 * @param error
	 */
	private void executionFailed(Statement statement, InterpreterError error) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.executionFailed(statement, error);
		}
	}

	/**
	 * 
	 */
	private void executionStarted() {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.executionStarted();
		}
	}

	/**
	 * 
	 */
	private void executionCompleted() {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.executionCompleted();
		}
	}

	/**
	 * 
	 * @param assertion
	 */
	private void assertionFailed(Assertion assertion) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.assertionFailed(assertion);
		}
	}

	/**
	 * 
	 * @param assertion
	 */
	private void assertionSucceeded(Assertion assertion) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.assertionSucceeded(assertion);
		}
	}

	/**
	 * 
	 * @param expression
	 */
	private void expressionEvaluated(Expression expression) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.expressionEvaluated(expression);
		}
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
	protected void addExecutionEventHandler(AbstractExecutionEventListener handler) {
		this.executionEventHandlers.add(handler);
	}

	/**
	 * Removes a debug event handler from this context
	 * 
	 * @param handler
	 */
	protected void removeExecutionEventHandler(AbstractExecutionEventListener handler) {
		this.executionEventHandlers.remove(handler);
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
		this.expressionEvaluated(addition);
	}

	public void visit(ArrayLength arrayLength) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(arrayLength);
	}

	public void visit(ArrayLiteral arrayLiteral) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(arrayLiteral);
	}

	public void visit(ArrayType arrayType) {
		// TODO Auto-generated method stub

	}

	public void visit(Assertion assertion) {
		// TODO Auto-generated method stub
		this.assertionSucceeded(assertion);
	}

	public void visit(Assignment assignment) {
		// TODO Auto-generated method stub
		this.statementWillExecute(assignment);
		this.statementExecuted(assignment);
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
		this.expressionEvaluated(booleanLiteral);
	}

	public void visit(BooleanType booleanType) {
		// TODO Auto-generated method stub

	}

	public void visit(Conditional conditional) {
		// TODO Auto-generated method stub
		this.statementWillExecute(conditional);
		this.statementExecuted(conditional);
	}

	public void visit(Conjunction conjunction) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(conjunction);
	}

	public void visit(Disjunction disjunction) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(disjunction);
	}

	public void visit(Division division) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(division);
	}

	public void visit(Equal equal) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(equal);
	}

	public void visit(Equivalence equivalence) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(equivalence);
	}

	public void visit(ExistsQuantifier existsQuantifier) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(existsQuantifier);
	}

	public void visit(ForAllQuantifier forAllQuantifier) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(forAllQuantifier);
	}

	public void visit(FunctionCall functionCall) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(functionCall);
	}

	public void visit(FunctionDeclaration functionDeclaration) {
		// TODO Auto-generated method stub

	}

	public void visit(Greater greater) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(greater);
	}

	public void visit(GreaterOrEqual greaterOrEqual) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(greaterOrEqual);
	}

	public void visit(Implication implication) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(implication);
	}

	public void visit(IntegerLiteral integerLiteral) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(integerLiteral);
	}

	public void visit(IntegerType integerType) {
		// TODO Auto-generated method stub

	}

	public void visit(Invariant invariant) {
		// TODO Auto-generated method stub

	}

	public void visit(Less less) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(less);
	}

	public void visit(LessOrEqual lessOrEqual) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(lessOrEqual);
	}

	public void visit(Loop loop) {
		// TODO Auto-generated method stub
		this.statementWillExecute(loop);
		this.statementExecuted(loop);
	}

	public void visit(Minus minus) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(minus);
	}

	public void visit(Modulus modulus) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(modulus);
	}

	public void visit(Multiplication multiplication) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(multiplication);
	}

	public void visit(Negation negation) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(negation);
	}

	@Override
	public void visit(ASTNode node) {
		// TODO Auto-generated method stub

	}

	public void visit(Plus plus) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(plus);
	}

	public void visit(Postcondition postcondition) {
		// TODO Auto-generated method stub

	}

	public void visit(Precondition precondition) {
		// TODO Auto-generated method stub

	}

	public void visit(Program program) {
		// TODO Auto-generated method stub
		this.executionStarted();
		this.executionCompleted();
	}

	public void visit(ReturnStatement returnStatement) {
		// TODO Auto-generated method stub
		this.statementWillExecute(returnStatement);
		this.statementExecuted(returnStatement);
	}

	public void visit(Subtraction subtraction) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(subtraction);
	}

	public void visit(Unequal unequal) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(unequal);
	}

	public void visit(VariableDeclaration variableDeclaration) {
		// TODO Auto-generated method stub
		this.statementWillExecute(variableDeclaration);
		this.statementExecuted(variableDeclaration);
	}
}