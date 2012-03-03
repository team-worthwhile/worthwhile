/**
 *
 */
package edu.kit.iti.formal.pse.worthwhile.interpreter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;

import edu.kit.iti.formal.pse.worthwhile.model.BooleanValue;
import edu.kit.iti.formal.pse.worthwhile.model.CompositeValue;
import edu.kit.iti.formal.pse.worthwhile.model.IntegerValue;
import edu.kit.iti.formal.pse.worthwhile.model.Value;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Addition;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
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
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnValueReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Subtraction;
import edu.kit.iti.formal.pse.worthwhile.model.ast.SymbolReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Type;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Unequal;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableReference;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCloneHelper;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeBottomUpVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.ASTNodeReturnVisitor;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.prover.SpecificationChecker;
import edu.kit.iti.formal.pse.worthwhile.prover.Validity;
import edu.kit.iti.formal.pse.worthwhile.typesystem.WorthwhileTypesystem;

/**
 * The AST-visitor implementing the functionality of the interpreter module.
 * 
 * @author Chris
 * 
 */
class InterpreterASTNodeVisitor extends HierarchialASTNodeVisitor {
	/**
	 * The specification checker.
	 */
	private SpecificationChecker specificationChecker;

	/**
	 * The execution event handlers.
	 */
	private Set<AbstractExecutionEventListener> executionEventHandlers = new HashSet<AbstractExecutionEventListener>();

	/**
	 * Gets the execution event handlers.
	 * 
	 * @return the executionEventHandlers
	 */
	public Set<AbstractExecutionEventListener> getExecutionEventHandlers() {
		return this.executionEventHandlers;
	}

	/**
	 * Sets the execution event handlers.
	 * 
	 * @param executionEventHandlers
	 *                the executionEventHandlers to set
	 */
	public void setExecutionEventHandlers(final Set<AbstractExecutionEventListener> executionEventHandlers) {
		this.executionEventHandlers = executionEventHandlers;
	}

	/**
	 * The {@link InterpreterASTNodeVisitor} that was created to execute a function.
	 * 
	 * <code>executingVisitor</code> is not <code>null</code> if and only if this
	 * <code>InterpreterASTNodeVisitor</code> has instantiated another <code>InterpreterASTNodeVisitor</code> and
	 * waits for that to finish the execution of a {@link FunctionDeclaration}.
	 */
	private InterpreterASTNodeVisitor executingVisitor = null;

	/**
	 * Determine the currently executing {@link InterpreterASTNodeVisitor}.
	 * 
	 * @return the currently executing <code>InterpreterASTNodeVisitor</code>
	 */
	InterpreterASTNodeVisitor getExecutingVisitor() {
		if (this.executingVisitor != null) {
			return this.executingVisitor.getExecutingVisitor();
		} else {
			return this;
		}
	}

	/**
	 * The result stack.
	 */
	private Stack<Value> resultStack = new Stack<Value>();

	/**
	 * Indicates whether the function handled by this visitor has returned.
	 */
	private boolean functionReturned = false;

	/**
	 * A stack of symbol maps.
	 */
	private Stack<Map<VariableDeclaration, Value>> symbolStack = new Stack<Map<VariableDeclaration, Value>>();

	/**
	 * A set of Expressions of Assumptions.
	 */
	private List<Expression> assumptions = new ArrayList<Expression>();

	/**
	 * A set of Expressions of Axioms.
	 */
	private List<Expression> axioms = new ArrayList<Expression>();

	/**
	 * sets the Axioms.
	 * 
	 * @param axioms
	 *                the Axioms to set
	 */
	public void setAxioms(List<Expression> axioms) {
		this.axioms = axioms;
	}

	/**
	 * Gets the symbol.
	 * 
	 * @param key
	 *                the key
	 * @return the symbol
	 */
	protected Value getSymbol(final VariableDeclaration key) {
		for (int i = this.symbolStack.size() - 1; i >= 0; i--) {
			// I won't take the 'nice' variant here because I want to start at the top of the stack
			Value temp = this.symbolStack.get(i).get(key);
			if (temp != null) {
				return temp;
			}
		}
		return null;
	}

	/**
	 * Get the value of a symbol by its name.
	 * 
	 * @param key
	 *                the name of the Symbol to look up the value for
	 * @return the current value of the Symbol or null if no such symbol exists
	 */
	protected Value getSymbol(final String key) {
		for (VariableDeclaration declaration : this.getAllSymbols().keySet()) {
			if (declaration.getName().equals(key)) {
				return this.getSymbol(declaration);
			}
		}
		// no such symbol
		return null;
	}

	/**
	 * Sets the symbol.
	 * 
	 * @param key
	 *                the key
	 * @param value
	 *                the value
	 */
	protected void setSymbol(final VariableDeclaration key, final Value value) {
		for (int i = this.symbolStack.size() - 1; i >= 0; i--) {
			// I won't take the 'nice' variant here because I want to start at the top of the stack
			Map<VariableDeclaration, Value> temp = this.symbolStack.get(i);
			if (temp.get(key) != null) {
				temp.put(key, value);
				return;
			}
		}
		this.symbolStack.peek().put(key, value);
	}

	/**
	 * Gets all symbols.
	 * 
	 * @return all symbols
	 */
	protected Map<VariableDeclaration, Value> getAllSymbols() {
		Map<VariableDeclaration, Value> result = new LinkedHashMap<VariableDeclaration, Value>();
		ListIterator<Map<VariableDeclaration, Value>> i = this.symbolStack
		                .listIterator(this.symbolStack.size());
		while (i.hasPrevious()) {
			result.putAll(i.previous());
		}
		return result;
	}

	/**
	 * Constructs a new {@link InterpreterASTNodeVisitor} with the given {@link SpecificationChecker}.
	 * 
	 * @param specificationChecker
	 *                the prover used to check formulas
	 */
	protected InterpreterASTNodeVisitor(final SpecificationChecker specificationChecker) {
		this.specificationChecker = specificationChecker;
	}

	/**
	 * Signals that a {@link Statement} has been executed by the {@link Interpreter}.
	 * 
	 * @param statement
	 *                the <code>Statement</code> that was executed
	 */
	private void statementExecuted(final Statement statement) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.statementExecuted(statement);
		}
	}

	/**
	 * the statement which is currently executed.
	 */
	private Statement currentStatement;

	/**
	 * the statement which is currently executed.
	 */
	private Annotation currentAnnotation;

	/**
	 * Signals that a {@link Statement} will be executed.
	 * 
	 * @param statement
	 *                the <code>Statement</code> that will be executed
	 */
	private void statementWillExecute(final Statement statement) {
		this.currentStatement = statement;
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.statementWillExecute(statement);
		}
	}

	/**
	 * Signals that the execution of a {@link Statement} failed.
	 * 
	 * @param statement
	 *                the <code>Statement</code> that failed to execute
	 * @param error
	 *                an {@link InterpreterError} object that describes the error
	 */
	private void executionFailed(final Statement statement, final InterpreterError error) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.executionFailed(statement, error);
		}
	}

	/**
	 * Signals the start of the execution of a {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program}.
	 */
	private void executionStarted() {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.executionStarted();
		}
	}

	/**
	 * Signals the successful completion of execution of a
	 * {@link edu.kit.iti.formal.pse.worthwhile.model.ast.Program}.
	 */
	private void executionCompleted() {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.executionCompleted();
		}
	}

	/**
	 * Signals the execution of an {@link Annotation} that was not valid.
	 * 
	 * @param annotation
	 *                the invalid <code>Annotation</code>
	 */
	private void annotationFailed(final Annotation annotation) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.annotationFailed(annotation);
		}
	}

	/**
	 * Signals the execution of an {@link Annotation} that was valid.
	 * 
	 * @param annotation
	 *                the valid <code>Annotation</code>
	 */
	private void annotationSucceeded(final Annotation annotation) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.annotationSucceeded(annotation);
		}
	}

	/**
	 * Signals the evaluation of a {@link Expression}.
	 * 
	 * @param expression
	 *                the <code>Expression</code> that was evaluated
	 */
	private void expressionEvaluated(final Expression expression) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.expressionEvaluated(expression);
		}
	}

	/**
	 * Signals the failure of a {@link Expression}.
	 * 
	 * @param expression
	 *                the <code>Expression</code> that failed
	 * @param error
	 *                the error that was caused
	 */
	private void expressionFailed(final Expression expression, final InterpreterError error) {
		for (AbstractExecutionEventListener listener : this.executionEventHandlers) {
			listener.expressionFailed(expression, error);
		}
	}

	/**
	 * Returns the value generated by the last return statement ran in this context.
	 * 
	 * @return the return value or null if none is available
	 */
	protected Value getReturnValue() {
		return this.resultStack.peek();
	}

	/**
	 * Adds a debug event handler to this context.
	 * 
	 * @param handler
	 *                the handler
	 */
	protected void addExecutionEventHandler(final AbstractExecutionEventListener handler) {
		this.executionEventHandlers.add(handler);
	}

	/**
	 * Removes a debug event handler from this context.
	 * 
	 * @param handler
	 *                the handler
	 */
	protected void removeExecutionEventHandler(final AbstractExecutionEventListener handler) {
		this.executionEventHandlers.remove(handler);
	}

	/**
	 * Clones this visitor.
	 * 
	 * @return a new {@link InterpreterASTNodeVisitor} that contains an equal {@link symbolStack}
	 */
	@Override
	protected InterpreterASTNodeVisitor clone() {
		final InterpreterASTNodeVisitor clone = new InterpreterASTNodeVisitor(this.specificationChecker);

		// Values are immutable so that it is efficient to clone the array and
		// not the elements
		for (final Map<VariableDeclaration, Value> m : this.symbolStack) {
			clone.symbolStack.push(new HashMap<VariableDeclaration, Value>(m));
		}

		return clone;
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
				throw new RuntimeException("result type error on resultStack: boolean expected");
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
				throw new RuntimeException("result type error on resultStack: integer expected");
			}
		}
	}

	/**
	 * Evaluates an annotation.
	 * 
	 * @param annotation
	 *                the Annotation to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Annotation)
	 */
	private void visitAnnotation(final Annotation annotation) {
		this.statementWillExecute(annotation);
		this.currentAnnotation = annotation;
		try {
			annotation.getExpression().accept(this);
			if (this.popBooleanValue().getValue()) {
				annotationSucceeded(annotation);
			} else {
				annotationFailed(annotation);
			}
		} catch (StatementException e) {
			this.executionFailed(annotation, e.getError());
			return;
		}
		this.currentAnnotation = null;
		this.statementExecuted(annotation);
	}

	/**
	 * adds the {@link IntegerValue}s of the {@link expression}s addition.left and addition.right and pushes the
	 * result on the resultStack.
	 * 
	 * @param addition
	 *                the Addition to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Addition)
	 */
	public void visit(final Addition addition) {
		addition.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		addition.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new IntegerValue(left.getValue().add(right.getValue())));
		this.expressionEvaluated(addition);
	}

	/**
	 * Pushes an array-literal onto the resultStack.
	 * 
	 * @param arrayLiteral
	 *                the ArrayLiteral to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.ArrayLiteral)
	 */
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

	/**
	 * Evaluates an assertion.
	 * 
	 * @param assertion
	 *                the Assertion to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Assertion)
	 */
	public void visit(final Assertion assertion) {
		this.visitAnnotation(assertion);
	}

	/**
	 * @param assumption
	 *                the Assumption to visit
	 */
	public void visit(final Assumption assumption) {
		this.statementWillExecute(assumption);
		this.assumptions.add(assumption.getExpression());
		this.statementExecuted(assumption);
	}

	/**
	 * assigns a new {@link Value} to a variable in the current symbol map.
	 * 
	 * @param assignment
	 *                the Assignment to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Assignment)
	 */
	public void visit(final Assignment assignment) {
		this.statementWillExecute(assignment);
		try {
			assignment.getValue().accept(this);
			VariableReference reference = assignment.getVariable();

			// Decide if we have to handle arrays
			if (reference.getIndex() == null) {
				this.setSymbol(reference.getVariable(), this.resultStack.pop());
			} else {
				// create a new array with the new value and replace the old one
				reference.getIndex().accept(this);
				IntegerValue index = this.popIntegerValue();
				CompositeValue<? extends Value> oldValue = (CompositeValue<?>) this.getSymbol(reference
				                .getVariable());
				CompositeValue<? extends Value> newValue = oldValue.replaceUntypedValue(
				                index.getValue(), this.resultStack.pop());
				this.setSymbol(reference.getVariable(), newValue);
			}
		} catch (StatementException e) {
			this.executionFailed(assignment, e.getError());
			return;
		}
		this.statementExecuted(assignment);
	}

	/**
	 * @param axiom
	 *                the Axiom to visit
	 */
	public void visit(final Axiom axiom) {
		this.statementWillExecute(axiom);
		this.axioms.add(axiom.getExpression());
		this.statementExecuted(axiom);
	}

	/**
	 * executes the statements of the block.
	 * 
	 * @param block
	 *                the Block to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Block)
	 */
	public void visit(final Block block) {
		Map<VariableDeclaration, Value> symbolMap = new HashMap<VariableDeclaration, Value>();
		this.symbolStack.push(symbolMap);
		this.statementWillExecute(block);
		EList<Statement> statements = block.getStatements();
		for (Statement statement : statements) {
			statement.accept(this);
			if (this.functionReturned) {
				this.statementExecuted(block);
				return;
			}
		}
		this.statementExecuted(block);
		this.symbolStack.pop();
	}

	/**
	 * Pushes the {@link BooleanValue} of the booleanLiteral onto the resultStack.
	 * 
	 * @param booleanLiteral
	 *                the BooleanLiteral to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.BooleanLiteral)
	 */
	public void visit(final BooleanLiteral booleanLiteral) {
		this.resultStack.push(new BooleanValue(booleanLiteral.getValue()));
		this.expressionEvaluated(booleanLiteral);
	}

	/**
	 * Visits one of two {@link Block}s depending on a condition.
	 * 
	 * @param conditional
	 *                the Conditional to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Conditional)
	 */
	public void visit(final Conditional conditional) {
		this.statementWillExecute(conditional);
		try {
			conditional.getCondition().accept(this);
			if (this.popBooleanValue().getValue()) {
				conditional.getTrueBlock().accept(this);
			} else {
				if (conditional.getFalseBlock() != null) {
					conditional.getFalseBlock().accept(this);
				}
			}
		} catch (StatementException e) {
			this.executionFailed(conditional, e.getError());
			return;
		}
		this.statementExecuted(conditional);
	}

	/**
	 * checks if the {@link Value}s of the {@link expression}s conjunction.left and conjunction.right are both true
	 * and pushes the result on the resultStack.
	 * 
	 * @param conjunction
	 *                the Conjunction to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Conjunction)
	 */
	public void visit(final Conjunction conjunction) {
		conjunction.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		conjunction.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(left.getValue() && right.getValue()));
		this.expressionEvaluated(conjunction);
	}

	/**
	 * checks if at least one the {@link Value}s of the {@link expression}s disjunction.left and disjunction.right
	 * are both true and pushes the result on the resultStack.
	 * 
	 * @param disjunction
	 *                the Disjunction to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Disjunction)
	 */
	public void visit(final Disjunction disjunction) {
		disjunction.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		disjunction.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(left.getValue() || right.getValue()));
		this.expressionEvaluated(disjunction);
	}

	/**
	 * divides the {@link IntegerValue} of the {@link expression} division.left by the {@link IntegerValue} of the
	 * {@link expression} division.right and pushes the result on the resultStack.
	 * 
	 * @param division
	 *                the Division to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Division)
	 */
	public void visit(final Division division) {
		division.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		division.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		if (right.getValue().equals(BigInteger.ZERO)) {
			expressionFailed(division, new DivisionByZeroInterpreterError(currentStatement));
			return;
		} else {
			this.resultStack.push(new IntegerValue(left.getValue().divide(right.getValue())));
			this.expressionEvaluated(division);
		}
	}

	/**
	 * checks if the {@link Value}s of the {@link expression}s equal.left and equal.right are equal and pushes the
	 * result on the resultStack.
	 * 
	 * @param equal
	 *                the Equal to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Equal)
	 */
	public void visit(final Equal equal) {
		equal.getLeft().accept(this);
		Value left = this.resultStack.pop();
		equal.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new BooleanValue(left.equals(right)));
		this.expressionEvaluated(equal);
	}

	/**
	 * compares the {@link BooleanValue}s of the {@link expression}s equivalence.left and equivalence.right and
	 * pushes the result on the resultStack.
	 * 
	 * @param equivalence
	 *                the Equivalence to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Equivalence)
	 */
	public void visit(final Equivalence equivalence) {
		equivalence.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		equivalence.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(left.getValue() == right.getValue()));
		this.expressionEvaluated(equivalence);
	}

	/**
	 * executes a function with a new InterpreterASTNodeVisitor.
	 * 
	 * @param functionCall
	 *                the called function
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.FunctionCall)
	 */
	public void visit(final FunctionCall functionCall) {
		this.executingVisitor = new InterpreterASTNodeVisitor(this.specificationChecker);
		this.executingVisitor.setExecutionEventHandlers(this.executionEventHandlers);
		this.executingVisitor.setAxioms(this.axioms);
		EList<Expression> actuals = functionCall.getActuals();
		this.executingVisitor.symbolStack.push(new HashMap<VariableDeclaration, Value>());

		// calculate the actual parameters
		for (int i = 0; i < actuals.size(); i++) {
			actuals.get(i).accept(this);
			this.executingVisitor.setSymbol(functionCall.getFunction().getParameters().get(i),
			                this.resultStack.pop());
		}
		functionCall.getFunction().accept(this);

		Value returnValue = this.executingVisitor.getReturnValue();
		this.executingVisitor.resultStack.push(returnValue);
		this.resultStack.push(returnValue);

		// get execution control back from the function visitor that just
		// returned
		this.executingVisitor = null;

		this.expressionEvaluated(functionCall);

	}

	/**
	 * handles preconditions, body and postconditions of a function.
	 * 
	 * @param functionDeclaration
	 *                the FunctionDeclaration to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.FunctionDeclaration)
	 */
	public void visit(final FunctionDeclaration functionDeclaration) {
		for (Precondition precondition : functionDeclaration.getPreconditions()) {
			precondition.accept(this.executingVisitor);
		}

		functionDeclaration.getBody().accept(this.executingVisitor);

		for (Postcondition postcondition : functionDeclaration.getPostconditions()) {
			postcondition.accept(this.executingVisitor);
		}
	}

	/**
	 * checks if the {@link IntegerValue} of the {@link expression} greater.left is greater as the
	 * {@link IntegerValue} of the {@link expression} greater.right and pushes the result on the resultStack.
	 * 
	 * @param greater
	 *                the Greater to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Greater)
	 */
	public void visit(final Greater greater) {
		greater.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		greater.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) == 1)));
		this.expressionEvaluated(greater);
	}

	/**
	 * checks if the {@link IntegerValue} of the {@link expression} greaterOrEqual.left is greater or equal as the
	 * {@link IntegerValue} of the {@link expression} greaterOrEqual.right and pushes the result on the resultStack.
	 * 
	 * @param greaterOrEqual
	 *                the GreaterOrEqual to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.GreaterOrEqual)
	 */
	public void visit(final GreaterOrEqual greaterOrEqual) {
		greaterOrEqual.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		greaterOrEqual.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) != -1)));
		this.expressionEvaluated(greaterOrEqual);
	}

	/**
	 * checks if the {@link BooleanValue} of the {@link expression} implication.left implies the
	 * {@link IntegerValue} of the {@link expression} implication.right and pushes the result on the resultStack.
	 * 
	 * @param implication
	 *                the Implication to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Implication)
	 */
	public void visit(final Implication implication) {
		implication.getLeft().accept(this);
		BooleanValue left = this.popBooleanValue();
		implication.getRight().accept(this);
		BooleanValue right = this.popBooleanValue();
		this.resultStack.push(new BooleanValue(!(left.getValue() && !right.getValue())));
		this.expressionEvaluated(implication);
	}

	/**
	 * Pushes the {@link IntegerValue} of the integerLiteral onto the resultStack.
	 * 
	 * @param integerLiteral
	 *                the IntegerLiteral to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.IntegerLiteral)
	 */
	public void visit(final IntegerLiteral integerLiteral) {
		this.resultStack.push(new IntegerValue(integerLiteral.getValue()));
		this.expressionEvaluated(integerLiteral);
	}

	/**
	 * Evaluates an invariant.
	 * 
	 * @param invariant
	 *                the Invariant to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Invariant)
	 */
	public void visit(final Invariant invariant) {
		this.visitAnnotation(invariant);
	}

	/**
	 * checks if the {@link IntegerValue} of the {@link expression} less.left is less than the {@link IntegerValue}
	 * of the {@link expression} less.right and pushes the result on the resultStack.
	 * 
	 * @param less
	 *                the Less to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Less)
	 */
	public void visit(final Less less) {
		less.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		less.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) == -1)));
		this.expressionEvaluated(less);
	}

	/**
	 * checks if the {@link IntegerValue} of the {@link expression} lessOrEqual.left is less or equal than the
	 * {@link IntegerValue} of the {@link expression} lessOrEqual.right and pushes the result on the resultStack.
	 * 
	 * @param lessOrEqual
	 *                the LessOrEqual to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.LessOrEqual)
	 */
	public void visit(final LessOrEqual lessOrEqual) {
		lessOrEqual.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		lessOrEqual.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new BooleanValue((left.getValue().compareTo(right.getValue()) != 1)));
		this.expressionEvaluated(lessOrEqual);
	}

	/**
	 * Visit a {@link Block} as long as a condition is true.
	 * 
	 * @param loop
	 *                the Loop to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Loop)
	 */
	public void visit(final Loop loop) {
		this.statementWillExecute(loop);
		try {
			for (Invariant invariant : loop.getInvariants()) {
				invariant.accept(this);
			}
			loop.getCondition().accept(this);
			while (this.popBooleanValue().getValue()) {
				loop.getBody().accept(this);
				for (Invariant invariant : loop.getInvariants()) {
					invariant.accept(this);
				}
				loop.getCondition().accept(this);
			}
		} catch (StatementException e) {
			this.executionFailed(loop, e.getError());
			return;
		}
		this.statementExecuted(loop);
	}

	/**
	 * negates the {@link IntegerValue} of the {@link expression} minus.operand and pushes the result on the
	 * resultStack.
	 * 
	 * @param minus
	 *                the Minus to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Minus)
	 */
	public void visit(final Minus minus) {
		minus.getOperand().accept(this);
		this.resultStack.push(new IntegerValue(this.popIntegerValue().getValue().negate()));
		this.expressionEvaluated(minus);
	}

	/**
	 * calculates the modulus of the {@link IntegerValue}s of the {@link expression}s modulus.left and modulus.right
	 * and pushes the result on the resultStack.
	 * 
	 * @param modulus
	 *                the Modulus to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Modulus)
	 */
	public void visit(final Modulus modulus) {
		modulus.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		modulus.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		if (right.getValue().equals(BigInteger.ZERO)) {
			expressionFailed(modulus, new DivisionByZeroInterpreterError(currentStatement));
			return;
		} else {
			this.resultStack.push(new IntegerValue(left.getValue().mod(right.getValue())));
			this.expressionEvaluated(modulus);
		}
	}

	/**
	 * multiplies the {@link IntegerValue}s of the {@link expression}s multiplication.left and multiplication.right
	 * and pushes the result on the resultStack.
	 * 
	 * @param multiplication
	 *                the Multiplication to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Multiplication)
	 */
	public void visit(final Multiplication multiplication) {
		multiplication.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		multiplication.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new IntegerValue(left.getValue().multiply(right.getValue())));
		this.expressionEvaluated(multiplication);
	}

	/**
	 * negates the {@link BooleanValue} of the {@link expression} negation.oparand and pushes the result on the
	 * resultStack.
	 * 
	 * @param negation
	 *                the Negation to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Negation)
	 */
	public void visit(final Negation negation) {
		negation.getOperand().accept(this);
		this.resultStack.push(new BooleanValue(!(this.popBooleanValue().getValue())));
		this.expressionEvaluated(negation);
	}

	/**
	 * does nothing with the {@link IntegerValue} of the {@link expression} plus.operand and pushes the result on
	 * the resultStack.
	 * 
	 * @param plus
	 *                the Plus to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Plus)
	 */
	public void visit(final Plus plus) {
		plus.getOperand().accept(this);
		this.expressionEvaluated(plus);
	}

	/**
	 * Evaluates an postcondition.
	 * 
	 * @param postcondition
	 *                the Postcondition to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Postcondition)
	 */
	public void visit(final Postcondition postcondition) {
		this.visitAnnotation(postcondition);
	}

	/**
	 * Evaluates an precondition.
	 * 
	 * @param precondition
	 *                the Precondition to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Precondition)
	 */
	public void visit(final Precondition precondition) {
		this.visitAnnotation(precondition);
	}

	/**
	 * Executes a program.
	 * 
	 * @param program
	 *                the Program to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Program)
	 */
	public void visit(final Program program) {
		this.executionStarted();
		for (Axiom axiom : program.getAxioms()) {
			axiom.accept(this);
		}
		program.getMainBlock().accept(this);
		this.executionCompleted();
	}

	/**
	 * Evaluates a quantified expression and pushes the result onto the resultStack.
	 * 
	 * @param quantifiedExpression
	 *                the QuantifiedExpression to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.QuantifiedExpression)
	 */
	public void visit(final QuantifiedExpression quantifiedExpression) {
		if (this.specificationChecker == null) {
			throw new IllegalArgumentException("No SpecificationChecker supplied");
		}
		List<Expression> axiomsAndAssumptions = new ArrayList<Expression>();
		axiomsAndAssumptions.addAll(this.assumptions);
		axiomsAndAssumptions.addAll(this.axioms);
		Validity validity = this.specificationChecker.checkFormula(quantifiedExpression, this.getAllSymbols(),
		                axiomsAndAssumptions);
		if (validity.equals(Validity.UNKNOWN)) {
			annotationFailed(this.currentAnnotation);
			this.resultStack.push(new BooleanValue(false));
			return;
		} else {
			this.resultStack.push(new BooleanValue(validity.equals(Validity.VALID)));
			this.expressionEvaluated(quantifiedExpression);
		}
	}

	/**
	 * Pushes the return-value onto the resultStack and terminate the execution of this function.
	 * 
	 * @param returnStatement
	 *                the ReturnStatement to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.ReturnStatement)
	 */
	public void visit(final ReturnStatement returnStatement) {
		this.statementWillExecute(returnStatement);
		try {
			returnStatement.getReturnValue().accept(this);

			// Put a new symbol named "_return" on the symbol stack to be used by the prover.
			VariableDeclaration variableDeclaration = AstFactory.eINSTANCE.createVariableDeclaration();
			variableDeclaration.setName("_return");

			// The type of this symbol is the function’s return type.
			variableDeclaration.setType(AstNodeCloneHelper.clone(new ASTNodeBottomUpVisitor<Type>() {

				@Override
				public final void visit(final FunctionDeclaration node) {
					this.setReturnValue(node.getReturnType());
				}

			}.apply(returnStatement)));

			Value returnValue = this.resultStack.peek();
			this.setSymbol(variableDeclaration, returnValue);
			this.functionReturned = true;
		} catch (StatementException e) {
			this.executionFailed(returnStatement, e.getError());
			return;
		}
		this.statementExecuted(returnStatement);
	}

	/**
	 * subtracts the {@link IntegerValue} of the {@link expression} subtraction.right from the {@link IntegerValue}
	 * of the {@link expression} subtraction.left and pushes the result on the resultStack.
	 * 
	 * @param subtraction
	 *                the subtraction to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Subtraction)
	 */
	public void visit(final Subtraction subtraction) {
		subtraction.getLeft().accept(this);
		IntegerValue left = this.popIntegerValue();
		subtraction.getRight().accept(this);
		IntegerValue right = this.popIntegerValue();
		this.resultStack.push(new IntegerValue(left.getValue().subtract(right.getValue())));
		this.expressionEvaluated(subtraction);
	}

	/**
	 * checks if the {@link Value}s of the {@link expression}s unequal.left and unequal.right are unequal and pushes
	 * the result on the resultStack.
	 * 
	 * @param unequal
	 *                the Unequal to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.Unequal)
	 */
	public void visit(final Unequal unequal) {
		unequal.getLeft().accept(this);
		Value left = this.resultStack.pop();
		unequal.getRight().accept(this);
		Value right = this.resultStack.pop();
		this.resultStack.push(new BooleanValue(!(left.equals(right))));
		this.expressionEvaluated(unequal);
	}

	/**
	 * Adds a variable to the actual symbol map.
	 * 
	 * @param variableDeclaration
	 *                the variableDeclaration to visit
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.VariableDeclaration)
	 */
	public void visit(final VariableDeclaration variableDeclaration) {
		this.statementWillExecute(variableDeclaration);
		try {
			// just set the variable if the declaration includes a definition...
			if (variableDeclaration.getInitialValue() != null) {
				variableDeclaration.getInitialValue().accept(this);
				this.setSymbol(variableDeclaration, this.resultStack.pop());
			} else {
				this.setSymbol(variableDeclaration,
				                this.getDefaultValueForType(variableDeclaration.getType()));
			}
		} catch (StatementException e) {
			this.executionFailed(variableDeclaration, e.getError());
			return;
		}
		this.statementExecuted(variableDeclaration);
	}

	/**
	 * Gets the default value for the given type.
	 * 
	 * @param type
	 *                The type to get the default value for.
	 * @return The default value for the given type.
	 */
	private Value getDefaultValueForType(final Type type) {
		return (new ASTNodeReturnVisitor<Value>() {

			@Override
			public void visit(final ArrayType node) {
				if (node.getBaseType() instanceof BooleanType) {
					this.setReturnValue(new CompositeValue<BooleanValue>(new BooleanValue[0]));
				} else if (node.getBaseType() instanceof IntegerType) {
					this.setReturnValue(new CompositeValue<IntegerValue>(new IntegerValue[0]));
				}
			}

			@Override
			public void visit(final BooleanType node) {
				this.setReturnValue(new BooleanValue(Boolean.FALSE));
			}

			@Override
			public void visit(final IntegerType node) {
				this.setReturnValue(new IntegerValue(BigInteger.ZERO));
			}

		}).apply(type);
	}

	/**
	 * Pushes the {@link Value} of the referenced symbol reference onto the resultStack, taking indices into
	 * account.
	 * 
	 * @param symbolReference
	 *                the SymbolReference whose value to push
	 * @param value
	 *                The value of the symbol reference.
	 * 
	 * @see edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor#visit(edu.kit.iti.formal.pse
	 *      .worthwhile.model.ast.VariableReference)
	 */
	private void pushSymbolReference(final SymbolReference symbolReference, final Value value) {
		if (symbolReference.getIndex() == null) {
			this.resultStack.push(value);
		} else {
			// Evaluate the index expression
			symbolReference.getIndex().accept(this);
			BigInteger index = this.popIntegerValue().getValue();

			// Get the appropriate value from the array, or get the default value
			CompositeValue<?> completeArray = (CompositeValue<?>) value;

			Map<BigInteger, ?> arrayValues = completeArray.getSubValues();
			if (arrayValues.containsKey(index)) {
				this.resultStack.push((Value) arrayValues.get(index));
			} else {
				// FIXME
				WorthwhileTypesystem ts = new WorthwhileTypesystem();

				// push the default value onto the result stack
				this.resultStack.push(this.getDefaultValueForType((Type) ts.typeof(symbolReference)));
			}
		}

	}

	@Override
	public void visit(final VariableReference variableReference) {
		this.pushSymbolReference(variableReference, this.getSymbol(variableReference.getVariable()));
		this.expressionEvaluated(variableReference);
	}

	@Override
	public void visit(final ReturnValueReference returnValueReference) {
		this.pushSymbolReference(returnValueReference, this.getReturnValue());
		this.expressionEvaluated(returnValueReference);
	}
}