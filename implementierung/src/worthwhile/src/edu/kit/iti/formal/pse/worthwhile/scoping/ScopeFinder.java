package edu.kit.iti.formal.pse.worthwhile.scoping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionAnnotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.QuantifiedExpression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.visitor.HierarchialASTNodeVisitor;
import edu.kit.iti.formal.pse.worthwhile.util.NodeHelper;

/**
 * A visitor that looks for variable and function declarations that are valid for a given AST node.
 * 
 * @author Joachim
 * 
 */
public class ScopeFinder extends HierarchialASTNodeVisitor {

	/**
	 * The node for which to compute the scope.
	 */
	private ASTNode node;

	/**
	 * A list of the found variable declarations.
	 */
	private Set<VariableDeclaration> variableDeclarations = new HashSet<VariableDeclaration>();

	/**
	 * A list of the found function declarations.
	 */
	private Set<FunctionDeclaration> functionDeclarations = new HashSet<FunctionDeclaration>();

	/**
	 * Indicates whether the node we have to provide the scope for is in a function annotation. In that case, we
	 * cannot allow cyclic or recursive function references.
	 */
	private boolean inFunctionAnnotation = false;

	/**
	 * Returns the list of found variable declarations.
	 * 
	 * @return the list of found variable declarations
	 */
	public final Set<VariableDeclaration> getVariableDeclarations() {
		return this.variableDeclarations;
	}

	/**
	 * Returns the list of found function declarations.
	 * 
	 * @return the list of found function declarations
	 */
	public final Set<FunctionDeclaration> getFunctionDeclarations() {
		return this.functionDeclarations;
	}

	/**
	 * Creates a new instance of the {@link ScopeFinder} class.
	 * 
	 * @param node
	 *                The AST node for which to compute the scope.
	 */
	public ScopeFinder(final ASTNode node) {
		// Get the node in the parse tree that equals the given AST node.
		this.node = node;
		computeScope();
	}

	/**
	 * Computes the scope of the node.
	 */
	private void computeScope() {
		ASTNode current = this.node;

		while (current != null) {

			// Check all siblings preceding this node.
			ASTNode prevSibling = (ASTNode) getPreviousSibling(current);

			while (prevSibling != null) {
				prevSibling.accept(this);
				current = prevSibling;
				prevSibling = (ASTNode) getPreviousSibling(current);
			}

			// Check the parent of this node.
			if (current.eContainer() != null) {
				current = (ASTNode) current.eContainer();
				current.accept(this);
			} else {
				current = null;
			}
		}
	}

	/**
	 * Gets the previous sibling of a given AST node in the AST.
	 * 
	 * Partially copied from Xtext 2.1 sources (EcoreUtil2.java).
	 * 
	 * @param eObject
	 *                The node to get the sibling of.
	 * @return The previous sibling, if it exists, {@code null} otherwise.
	 */
	private static EObject getPreviousSibling(final EObject eObject) {
		EObject previous = null;

		// special treatment for the main block: treat the function declarations as its siblings
		if (eObject instanceof Block && eObject.eContainer() instanceof Program) {
			Program program = (Program) (eObject.eContainer());

			// The previous sibling is the last function declaration of the program.
			if (!program.getFunctionDeclarations().isEmpty()) {
				previous = program.getFunctionDeclarations().get(
				                program.getFunctionDeclarations().size() - 1);
			}
		} else {
			if (eObject.eContainingFeature() != null && eObject.eContainingFeature().isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> siblings = (List<EObject>) eObject.eContainer().eGet(
				                eObject.eContainingFeature());

				int indexOf = siblings.indexOf(eObject);
				if (indexOf > 0) {
					previous = siblings.get(indexOf - 1);
				}
			}
		}

		return previous;
	}

	@Override
	protected final void defaultOperation(final ASTNode node) {
		// Do nothing.
	}

	@Override
	public final void visit(final FunctionDeclaration node) {
		// The parameters of the function are always visible in the function, but not outside
		if (NodeHelper.isAncestor(node, this.node)) {
			for (VariableDeclaration param : node.getParameters()) {
				this.variableDeclarations.add(param);
			}
		} else {
			// The function can be called anywhere but in its own precondition or postcondition.
			// Therefore, we ensure here that we are not providing the scope for an element in the function.
			// If necessary, this function declaration is added later in visit(Program).
			this.functionDeclarations.add(node);
		}
	}

	@Override
	public final void visit(final QuantifiedExpression node) {
		this.variableDeclarations.add(node.getParameter());
	}

	@Override
	public final void visit(final VariableDeclaration node) {
		// Direct ancestors are not allowed to provide a variable declaration
		if (!NodeHelper.isAncestor(node, this.node)) {
			this.variableDeclarations.add(node);
		}
	}

	@Override
	public final void visit(final FunctionAnnotation node) {
		this.inFunctionAnnotation = true;
	}

	@Override
	public final void visit(final Program node) {
		// If we are not providing the scope for an element in a function annotation, we can add all function
		// declarations of the program, not just the one preceding the element.
		if (node.getFunctionDeclarations() != null && !this.inFunctionAnnotation) {
			for (FunctionDeclaration funcdec : node.getFunctionDeclarations()) {
				this.functionDeclarations.add(funcdec);
			}
		}
	}

}
