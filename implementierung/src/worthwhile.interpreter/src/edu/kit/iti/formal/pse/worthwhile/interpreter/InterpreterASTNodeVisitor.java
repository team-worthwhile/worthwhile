/**
 *
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
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
	private Stack<Map<VariableDeclaration, Value>> symbolStack = new Stack<Map<VariableDeclaration, Value>>();

	/**
	 * @param key
	 * @return
	 */
	protected Value getSymbol(VariableDeclaration key) {
		for (int i = this.symbolStack.size() - 1; i >= 0; i--) { // I won't take the 'nice' variant here because
			                                                 // I want to start at the top of the stack
			Value temp = this.symbolStack.get(i).get(key);
			if (temp != null) {
				return temp;
			}
		}
		return null;
	}

	/**
	 * Get the value of a symbol by its name
	 * 
	 * @param key
	 *                the name of the Symbol to look up the value for
	 * @return the current value of the Symbol or null if no such symbol exists
	 */
	protected Value getSymbol(String key) {
		for (VariableDeclaration declaration : this.getAllSymbols().keySet()) {
			if (declaration.getName().equals(key)) {
				return this.getSymbol(declaration);
			}
		}
		// no such symbol
		return null;
	}

	/**
	 * @param key
	 * @param value
	 */
	protected void setSymbol(VariableDeclaration key, Value value) {
		for (int i = this.symbolStack.size() - 1; i >= 0; i--) { // I won't take the 'nice' variant here because
			                                                 // I want to start at the top of the stack
			Map<VariableDeclaration, Value> temp = this.symbolStack.get(i);
			if(temp.get(key) != null) {
				temp.put(key, value);
				return;
			}
		}
		this.symbolStack.peek().put(key, value);
	}

	/**
	 * @return
	 */
	protected Map<VariableDeclaration, Value> getAllSymbols() {
		Map<VariableDeclaration, Value> result = new HashMap<VariableDeclaration, Value>();
		for (Map<VariableDeclaration, Value> item : this.symbolStack) {
			result.putAll(item);
		}
		return result;
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
		return this.resultStack.peek();
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

	/**
	 * Pops a boolean value from the result stack. Fails the execution if there is no boolean value on the stack.
	 * 
	 * @return the {@link BooleanValue} that is on top of the stack.
	 */
	private BooleanValue popBooleanValue() {
		synchronized (this.resultStack) {
			if (this.resultStack.peek() instanceof BooleanValue) {
				return (BooleanValue) this.resultStack.pop();
			} else {
				// TODO executionFailed
				return null;
			}
		}
	}

	/**
	 * Pops an integer value from the result stack. Fails the execution if there is no integer value on the stack.
	 * 
	 * @return the {@link IntegerValue} that is on top of the stack.
	 */
	private IntegerValue popIntegerValue() {
		synchronized (this.resultStack) {
			if (this.resultStack.peek() instanceof IntegerValue) {
				return (IntegerValue) this.resultStack.pop();
			} else {
				// TODO executionFailed
				return null;
			}
		}
	}

	public void visit(Addition addition) {
		addition.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		addition.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new IntegerValue(left.getValue().add(right.getValue())));
		this.expressionEvaluated(addition);
	}

	@Override
	public void visit(final ArrayLength arrayLength) {
		// the casts should be safe after validation
		final VariableDeclaration variable = ((VariableReference) arrayLength.getOperand()).getVariable();
		final Expression size = ((ArrayType) variable.getType()).getSize();
		size.accept(this);

		this.expressionEvaluated(arrayLength);
	}

	@Override
	public void visit(final ArrayLiteral arrayLiteral) {
		final List<Expression> values = arrayLiteral.getValues();
		final Value[] subValues = new Value[values.size()];

		int i = 0;
		for (Expression e : values) {
			e.accept(this);
			subValues[i++] = this.resultStack.pop();
		}

		this.resultStack.push(new CompositeValue<Value>(subValues));

		this.expressionEvaluated(arrayLiteral);
	}

	public void visit(Assertion assertion) {
		statementWillExecute(assertion);
		try {
			// TODO Auto-generated method stub
		} catch (StatementException e) {
			this.executionFailed(assertion, e.getError());
			return;
		}
		this.assertionSucceeded(assertion);
		this.statementExecuted(assertion);
	}

	public void visit(Assignment assignment) {
		this.statementWillExecute(assignment);
		try {
			assignment.getValue().accept(this);
			this.setSymbol(assignment.getVariable().getVariable(), resultStack.pop());
		} catch (StatementException e) {
			this.executionFailed(assignment, e.getError());
			return;
		}
		this.statementExecuted(assignment);
	}

	public void visit(Assumption assumption) {
		statementWillExecute(assumption);
		try {
			// TODO Auto-generated method stub
		} catch (StatementException e) {
			this.executionFailed(assumption, e.getError());
			return;
		}
		this.statementExecuted(assumption);
	}

	public void visit(Axiom axiom) {
		statementWillExecute(axiom);
		try {
			// TODO Auto-generated method stub
		} catch (StatementException e) {
			this.executionFailed(axiom, e.getError());
			return;
		}
		this.statementExecuted(axiom);
	}

	public void visit(Block block) {
		Map<VariableDeclaration, Value> symbolMap = new HashMap<VariableDeclaration, Value>();
		this.symbolStack.push(symbolMap);
		this.statementWillExecute(block);
		EList<Statement> statements = block.getStatements();
		for (Statement statement : statements) {
			statement.accept(this);
		}
		this.statementExecuted(block);
		this.symbolStack.pop();
	}

	public void visit(BooleanLiteral booleanLiteral) {
		this.resultStack.push(new BooleanValue(booleanLiteral.getValue()));
		this.expressionEvaluated(booleanLiteral);
	}

	public void visit(Conditional conditional) {
		this.statementWillExecute(conditional);
		try {
			conditional.getCondition().accept(this);
			if (this.popBooleanValue().getValue()) {
				conditional.getTrueBlock().accept(this);
			} else {
				conditional.getFalseBlock().accept(this);
			}
		} catch (StatementException e) {
			this.executionFailed(conditional, e.getError());
			return;
		}
		this.statementExecuted(conditional);
	}

	public void visit(Conjunction conjunction) {
		conjunction.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		conjunction.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(left.getValue() && right.getValue()));
		this.expressionEvaluated(conjunction);
	}

	public void visit(Disjunction disjunction) {
		disjunction.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		disjunction.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(left.getValue() || right.getValue()));
		this.expressionEvaluated(disjunction);
	}

	public void visit(Division division) {
		division.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		division.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		if (right.getValue().equals(BigInteger.ZERO)) {
			throw new StatementException(new DivisionByZeroInterpreterError());
		} else {
			this.resultStack.push(new IntegerValue(left.getValue().divide(right.getValue())));
			this.expressionEvaluated(division);
		}
	}

	public void visit(Equal equal) {
		equal.getLeft().accept(this);
		Value left = this.resultStack.pop();
		equal.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new BooleanValue(left.equals(right)));
		this.expressionEvaluated(equal);
	}

	public void visit(Equivalence equivalence) {
		equivalence.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		equivalence.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(left.getValue() == right.getValue()));
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
			functionVisitor.setSymbol(functionDeclaration.getParameters().get(i), this.resultStack.pop());
		}
		for (Precondition precondition : functionDeclaration.getPreconditions()) {
			precondition.accept(this);
		}
		functionDeclaration.getBody().accept(functionVisitor);
		for (Postcondition postcondition : functionDeclaration.getPostconditions()) {
			postcondition.accept(this);
		}
		this.resultStack.push(functionVisitor.getReturnValue());
		this.expressionEvaluated(functionCall);
	}

	public void visit(FunctionDeclaration functionDeclaration) {
		// does this even have to do anything?
	}

	public void visit(Greater greater) {
		greater.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		greater.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) == 1)));
		this.expressionEvaluated(greater);
	}

	public void visit(GreaterOrEqual greaterOrEqual) {
		greaterOrEqual.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		greaterOrEqual.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) != -1)));
		this.expressionEvaluated(greaterOrEqual);
	}

	public void visit(Implication implication) {
		implication.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		implication.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(!(left.getValue() && !right.getValue())));
		this.expressionEvaluated(implication);
	}

	public void visit(IntegerLiteral integerLiteral) {
		this.resultStack.push(new IntegerValue(integerLiteral.getValue()));
		this.expressionEvaluated(integerLiteral);
	}

	public void visit(Invariant invariant) {
		try {
			// TODO Auto-generated method stub
		} catch (StatementException e) {
			this.executionFailed(invariant, e.getError());
			return;
		}
		this.statementExecuted(invariant);
	}

	public void visit(Less less) {
		less.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		less.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) == -1)));
		this.expressionEvaluated(less);
	}

	public void visit(LessOrEqual lessOrEqual) {
		lessOrEqual.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		lessOrEqual.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) != 1)));
		this.expressionEvaluated(lessOrEqual);
	}

	public void visit(Loop loop) {
		// TODO incorporate invariant
		this.statementWillExecute(loop);
		try {
			loop.getCondition().accept(this);
			while (this.popBooleanValue().getValue()) {
				loop.getBody().accept(this);
				loop.getCondition().accept(this);
			}
		} catch (StatementException e) {
			this.executionFailed(loop, e.getError());
			return;
		}
		this.statementExecuted(loop);
	}

	public void visit(Minus minus) {
		this.resultStack.push(new IntegerValue(this.popIntegerValue().getValue().negate()));
		this.expressionEvaluated(minus);
	}

	public void visit(Modulus modulus) {
		modulus.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		modulus.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		if (right.getValue().equals(BigInteger.ZERO)) {
			throw new StatementException(new DivisionByZeroInterpreterError());
		} else {
			this.resultStack.push(new IntegerValue(left.getValue().mod(right.getValue())));
			this.expressionEvaluated(modulus);
		}
	}

	public void visit(Multiplication multiplication) {
		multiplication.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		multiplication.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new IntegerValue(left.getValue().multiply(right.getValue())));
		this.expressionEvaluated(multiplication);
	}

	public void visit(Negation negation) {
		negation.getOperand().accept(this);
		this.resultStack.push(new BooleanValue(!(this.popBooleanValue().getValue())));
		this.expressionEvaluated(negation);
	}

	@Override
	public void visit(ASTNode node) {
	}

	public void visit(Plus plus) {
		plus.accept(this);
		this.expressionEvaluated(plus);
	}

	public void visit(Postcondition postcondition) {
		statementWillExecute(postcondition);
		try {
			// TODO Auto-generated method stub
		} catch (StatementException e) {
			this.executionFailed(postcondition, e.getError());
			return;
		}
		this.statementExecuted(postcondition);
	}

	public void visit(Precondition precondition) {
		statementWillExecute(precondition);
		try {
			// TODO Auto-generated method stub
		} catch (StatementException e) {
			this.executionFailed(precondition, e.getError());
			return;
		}
		this.statementExecuted(precondition);
	}

	public void visit(Program program) {
		this.executionStarted();
		for (Axiom axiom : program.getAxioms()) {
			axiom.accept(this);
		}
		program.getMainBlock().accept(this);
		this.executionCompleted();
	}

	public void visit(ReturnStatement returnStatement) {
		this.statementWillExecute(returnStatement);
		try {
			returnStatement.getReturnValue().accept(this);
		} catch (StatementException e) {
			this.executionFailed(returnStatement, e.getError());
			return;
		}
		this.statementExecuted(returnStatement);
	}

	public void visit(ReturnValueReference returnValueReference) {
	}

	public void visit(Subtraction subtraction) {
		subtraction.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		subtraction.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new IntegerValue(left.getValue().subtract(right.getValue())));
		this.expressionEvaluated(subtraction);
	}

	public void visit(Unequal unequal) {
		unequal.getLeft().accept(this);
		Value left = this.resultStack.pop();
		unequal.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new BooleanValue(!(left.equals(right))));
		this.expressionEvaluated(unequal);
	}

	public void visit(VariableDeclaration variableDeclaration) {
		this.statementWillExecute(variableDeclaration);
		try {
			if (variableDeclaration.getInitialValue() != null) {
				variableDeclaration.getInitialValue().accept(this);
				this.setSymbol(variableDeclaration, this.resultStack.pop());
			} else {
				if (variableDeclaration.getType() instanceof ArrayType) {
					final ArrayType arrayType = ((ArrayType) variableDeclaration.getType());

					// evaluate the size expression and assign the size value as literal
					arrayType.getSize().accept(this);
					final IntegerLiteral sizeLiteral = AstFactory.init().createIntegerLiteral();
					sizeLiteral.setValue(((IntegerValue) this.resultStack.pop()).getValue());
					arrayType.setSize(sizeLiteral);

					if (arrayType.getBaseType() instanceof BooleanType) {
						this.setSymbol(variableDeclaration, new CompositeValue<BooleanValue>(
						                new BooleanValue[this.popIntegerValue().getValue()
						                                .intValue()]));
					} else {
						this.setSymbol(variableDeclaration, new CompositeValue<IntegerValue>(
						                new IntegerValue[this.popIntegerValue().getValue()
						                                .intValue()]));
					}
				} else if (variableDeclaration.getType() instanceof BooleanType) {
					this.setSymbol(variableDeclaration, new BooleanValue(Boolean.FALSE));
				} else {
					this.setSymbol(variableDeclaration, new IntegerValue(BigInteger.ZERO));
				}
			}
		} catch (StatementException e) {
			this.executionFailed(variableDeclaration, e.getError());
			return;
		}
		this.statementExecuted(variableDeclaration);
	}

	public void visit(VariableReference variableReference) {
		this.resultStack.push(this.getSymbol(variableReference.getVariable()));
		this.expressionEvaluated(variableReference);
	}
}