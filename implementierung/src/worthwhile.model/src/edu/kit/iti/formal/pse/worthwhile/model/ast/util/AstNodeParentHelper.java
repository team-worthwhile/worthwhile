package edu.kit.iti.formal.pse.worthwhile.model.ast.util;

import org.eclipse.emf.ecore.EObject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;

public class AstNodeParentHelper {

	/**
	 * Finds the nearest parent node of type {@link Program}
	 * @param node The node from which to start the search.
	 * @return The nearest parent node of type {@link Program}.
	 */
	public static Program findParentProgram(ASTNode node) {
		EObject current = node;

		while (current != null && !(current instanceof Program)) {
			current = current.eContainer();
		}

		if (current == null) {
			return null;
		} else {
			return (Program) current;
		}
	}
	
	/**
	 * Finds the nearest parent node of type {@link FunctionDeclaration}
	 * @param node The node from which to start the search.
	 * @return The nearest parent node of type {@link FunctionDeclaration}.
	 */
	public static FunctionDeclaration findParentFunctionDeclaration(ASTNode node) {
		EObject current = node;

		while (current != null && !(current instanceof FunctionDeclaration)) {
			current = current.eContainer();
		}

		if (current == null) {
			return null;
		} else {
			return (FunctionDeclaration) current;
		}
	}
	
	/**
	 * Finds the nearest parent node of type {@link Statement}
	 * @param node The node from which to start the search.
	 * @return The nearest parent node of type {@link Statement}.
	 */
	public static Statement findParentStatement(ASTNode node) {
		EObject current = node;

		while (current != null && !(current instanceof Statement)) {
			current = current.eContainer();
		}

		if (current == null) {
			return null;
		} else {
			return (Statement) current;
		}
	}

}
