/**
 *
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLength;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayLiteral;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ArrayType;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assertion;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assignment;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Assumption;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstFactory;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
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
	private Stack<Value> resultStack = new Stack<Value>();

	/**
	 *
	 */
	// private Map<String, Value> symbolMap;
	private Stack<Map<String, Value>> symbolStack = new Stack<Map<String, Value>>();

	/**
	 * @param key
	 * @return
	 */
	protected Value getSymbol(String key) {
		Value temp = null;
		for (int i = this.symbolStack.size() - 1; i >= 0; i--) { // I won't take the 'nice' variant here because
									 // I want to start at the top of the stack
			temp = symbolStack.get(i).get(key);
			if (temp.getClass().equals(Value.class)) {
				return temp;
			}
		}
		return null;
	}

	/**
	 * @param key
	 * @param value
	 */
	protected void setSymbol(String key, Value value) {
		this.symbolStack.peek().put(key, value);
	}

	/**
	 * @return
	 */
	protected Stack<Map<String, Value>> getAllSymbols() {
		return this.symbolStack;
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
		addition.getLeft().accept(this);
		Value left = this.resultStack.pop();
		addition.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getIntegerValue().add(right.getIntegerValue())));
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
		Map<String, Value> symbolMap = new HashMap<String, Value>();
		this.symbolStack.push(symbolMap);
		EList<Statement> statements = block.getStatements();
		for (Statement statement : statements) {
			statement.accept(this);
		}
		this.symbolStack.pop();
	}

	public void visit(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		this.expressionEvaluated(booleanLiteral);
	}

	public void visit(BooleanType booleanType) {
		// TODO Auto-generated method stub

	}

	public void visit(Conditional conditional) {
		this.statementWillExecute(conditional);
		conditional.getCondition().accept(this);
		if (this.resultStack.pop().getBooleanValue()) {
			conditional.getTrueBlock().accept(this);
		} else {
			conditional.getFalseBlock().accept(this);
		}
		this.statementExecuted(conditional);
	}

	public void visit(Conjunction conjunction) {
		conjunction.getLeft().accept(this);
		Value left = this.resultStack.pop();
		conjunction.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getBooleanValue() && right.getBooleanValue()));
		this.expressionEvaluated(conjunction);
	}

	public void visit(Disjunction disjunction) {
		disjunction.getLeft().accept(this);
		Value left = this.resultStack.pop();
		disjunction.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getBooleanValue() || right.getBooleanValue()));
		this.expressionEvaluated(disjunction);
	}

	public void visit(Division division) {
		// TODO handle division by zero
		division.getLeft().accept(this);
		Value left = this.resultStack.pop();
		division.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getIntegerValue().divide(right.getIntegerValue())));
		this.expressionEvaluated(division);
	}

	public void visit(Equal equal) {
		equal.getLeft().accept(this);
		Value left = this.resultStack.pop();
		equal.getRight().accept(this);
		Value right = this.resultStack.pop();
		if (left.getValueType() == ValueType.BOOLEAN_TYPE) {
			this.resultStack.push(new Value(left.getBooleanValue() == (right.getBooleanValue())));
		} else {
			this.resultStack.push(new Value(left.getIntegerValue().equals(right.getIntegerValue())));
		}
		this.expressionEvaluated(equal);
	}

	public void visit(Equivalence equivalence) {
		equivalence.getLeft().accept(this);
		Value left = this.resultStack.pop();
		equivalence.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getBooleanValue() == right.getBooleanValue()));
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
		InterpreterASTNodeVisitor functionVisitor = new InterpreterASTNodeVisitor();
		functionVisitor.setExecutionEventHandlers(this.executionEventHandlers);
		FunctionDeclaration functionDeclaration = functionCall.getFunction();
		EList<Expression> actuals = functionCall.getActuals();
		for (int i = 0; i < actuals.size(); i++) {
			actuals.get(i).accept(this);
			functionVisitor.setSymbol(functionDeclaration.getParameters().get(i).getName(),
			                resultStack.pop());
		}
		functionVisitor.visit(functionDeclaration.getBody());
		this.expressionEvaluated(functionCall);
	}

	public void visit(FunctionDeclaration functionDeclaration) {
		// TODO Auto-generated method stub - does this even have to do anything?
	}

	public void visit(Greater greater) {
		greater.getLeft().accept(this);
		Value left = this.resultStack.pop();
		greater.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value((left.getIntegerValue().compareTo(right.getIntegerValue()) == 1)));
		this.expressionEvaluated(greater);
	}

	public void visit(GreaterOrEqual greaterOrEqual) {
		greaterOrEqual.getLeft().accept(this);
		Value left = this.resultStack.pop();
		greaterOrEqual.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value((left.getIntegerValue().compareTo(right.getIntegerValue()) != -1)));
		this.expressionEvaluated(greaterOrEqual);
	}

	public void visit(Implication implication) {
		implication.getLeft().accept(this);
		Value left = this.resultStack.pop();
		implication.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(!(left.getBooleanValue() && !right.getBooleanValue())));
		this.expressionEvaluated(implication);
	}

	public void visit(IntegerLiteral integerLiteral) {
		// TODO Auto-generated method stub
		this.resultStack.push(new Value(integerLiteral.getValue()));
		this.expressionEvaluated(integerLiteral);
	}

	public void visit(IntegerType integerType) {
		// TODO Auto-generated method stub

	}

	public void visit(Invariant invariant) {
		// TODO Auto-generated method stub

	}

	public void visit(Less less) {
		less.getLeft().accept(this);
		Value left = this.resultStack.pop();
		less.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value((left.getIntegerValue().compareTo(right.getIntegerValue()) == -1)));
		this.expressionEvaluated(less);
	}

	public void visit(LessOrEqual lessOrEqual) {
		lessOrEqual.getLeft().accept(this);
		Value left = this.resultStack.pop();
		lessOrEqual.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value((left.getIntegerValue().compareTo(right.getIntegerValue()) != 1)));
		this.expressionEvaluated(lessOrEqual);
	}

	public void visit(Loop loop) {
		// TODO incorporate invariant
		this.statementWillExecute(loop);
		loop.getCondition().accept(this);
		while (this.resultStack.pop().getBooleanValue()) {
			loop.getBody().accept(this);
			loop.getCondition().accept(this);
		}
		this.statementExecuted(loop);
	}

	public void visit(Minus minus) {
		this.resultStack.push(new Value(this.resultStack.pop().getIntegerValue().negate()));
		this.expressionEvaluated(minus);
	}

	public void visit(Modulus modulus) {
		// TODO handle modulo by zero
		modulus.getLeft().accept(this);
		Value left = this.resultStack.pop();
		modulus.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getIntegerValue().mod(right.getIntegerValue())));
		this.expressionEvaluated(modulus);
	}

	public void visit(Multiplication multiplication) {
		multiplication.getLeft().accept(this);
		Value left = this.resultStack.pop();
		multiplication.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getIntegerValue().multiply(right.getIntegerValue())));
		this.expressionEvaluated(multiplication);
	}

	public void visit(Negation negation) {
		this.resultStack.push(new Value(!(this.resultStack.pop().getBooleanValue())));
		this.expressionEvaluated(negation);
	}

	@Override
	public void visit(ASTNode node) {
		// TODO Auto-generated method stub

	}

	public void visit(Plus plus) {
		plus.accept(this);
		this.expressionEvaluated(plus);
	}

	public void visit(Postcondition postcondition) {
		// TODO Auto-generated method stub

	}

	public void visit(Precondition precondition) {
		// TODO Auto-generated method stub

	}

	public void visit(Program program) {
		// TODO FIX THIS
		/*
		 * EList<FunctionDeclaration> functionDeclarations = program.getFunctionDeclarations(); for
		 * (FunctionDeclaration functionDeclaration : functionDeclarations) { functionDeclaration.accept(this);
		 * }
		 */
		this.executionStarted();
		program.getMainBlock().accept(this);
		this.executionCompleted();
	}

	public void visit(ReturnStatement returnStatement) {
		// TODO Auto-generated method stub
		this.statementWillExecute(returnStatement);
		this.statementExecuted(returnStatement);
	}

	public void visit(Subtraction subtraction) {
		subtraction.getLeft().accept(this);
		Value left = this.resultStack.pop();
		subtraction.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new Value(left.getIntegerValue().subtract(right.getIntegerValue())));
		this.expressionEvaluated(subtraction);
	}

	public void visit(Unequal unequal) {
		unequal.getLeft().accept(this);
		Value left = this.resultStack.pop();
		unequal.getRight().accept(this);
		Value right = this.resultStack.pop();
		if (left.getValueType() == ValueType.BOOLEAN_TYPE) {
			this.resultStack.push(new Value(!(left.getBooleanValue() == (right.getBooleanValue()))));
		} else {
			this.resultStack.push(new Value(!(left.getIntegerValue().equals(right.getIntegerValue()))));
		}
		this.expressionEvaluated(unequal);
	}

	public void visit(VariableDeclaration variableDeclaration) {
		this.statementWillExecute(variableDeclaration);
		/*if (variableDeclaration.getInitialValue() == null) {
			IntegerLiteral defaultValue = AstFactory.eINSTANCE.createIntegerLiteral();
			defaultValue.setValue(BigInteger.valueOf(42));
			variableDeclaration.setInitialValue(defaultValue);
		}*/
		variableDeclaration.getInitialValue().accept(this);
		this.setSymbol(variableDeclaration.getName(), this.resultStack.pop());
		this.statementExecuted(variableDeclaration);
	}

	public void visit(VariableReference variableReference) {
		this.resultStack.push(this.getSymbol(variableReference.getVariable().getName()));
		this.expressionEvaluated(variableReference);
	}
}