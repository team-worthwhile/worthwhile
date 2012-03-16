package edu.kit.iti.formal.pse.worthwhile.z3model;

import java.util.Iterator;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionCall;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;
import edu.kit.iti.formal.pse.worthwhile.model.ast.ReturnStatement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Statement;
import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeToStringHelper;

/**
 * An {@link AstNodeToStringHelper} specialized for parsed Z3 models
 * 
 * @author Joachim
 * 
 */
public class Z3ModelToStringHelper extends AstNodeToStringHelper {

	/**
	 * A single instance of {@link Z3ModelToStringHelper}.
	 */
	private static Z3ModelToStringHelper singleton = new Z3ModelToStringHelper();

	private Z3ModelToStringHelper() {
	}

	/**
	 * Returns a {@link String} representing an {@link ASTNode}.
	 * 
	 * @param node
	 *                the ASTNode that is represented by the returned String
	 * @return a String representing <code>node</code>
	 */
	public static String toString(final ASTNode node) {
		if (node != null) {
			Z3ModelToStringHelper.singleton.setBuffer(new StringBuffer());
			node.accept(Z3ModelToStringHelper.singleton);
			return Z3ModelToStringHelper.singleton.getBuffer().toString();
		} else {
			return "";
		}
	}

	@Override
	public void visit(final FunctionDeclaration functionDeclaration) {
		functionDeclaration.getReturnType().accept(this);
		this.append(" ");
		this.append(this.getFunctionDeclarationDisplayName(functionDeclaration));

		List<VariableDeclaration> params = functionDeclaration.getParameters();
		if (!params.isEmpty()) {
			this.append(" (");
			Iterator<VariableDeclaration> i = functionDeclaration.getParameters().iterator();
			// params is not empty, i has next
			i.next().accept(this);
			while (i.hasNext()) {
				this.append(", ");
				i.next().accept(this);
			}
			this.append(")");
		}

		this.append(" := ");

		functionDeclaration.getBody().accept(this);
	}

	/**
	 * Computes a nice user-visible name for the given function declaration.
	 * 
	 * @param functionDeclaration
	 *                The function declaration.
	 * @return A nice user-visible name.
	 */
	private final String getFunctionDeclarationDisplayName(final FunctionDeclaration functionDeclaration) {
		String[] nameParts = this.getFunctionDeclarationNameParts(functionDeclaration);
		Program program = (Program) functionDeclaration.eContainer();

		boolean showNumberPart = false;

		for (FunctionDeclaration funcdec : program.getFunctionDeclarations()) {
			if (funcdec != functionDeclaration
			                && this.getFunctionDeclarationNameParts(funcdec)[0].equals(nameParts[0])) {
				showNumberPart = true;
			}
		}

		if (showNumberPart) {
			return nameParts[0] + "<" + nameParts[1] + ">";
		} else {
			return nameParts[0];
		}
	}

	/**
	 * Extracts the parts before and after the exclamation mark from a function declaration's name.
	 * 
	 * @param functionDeclaration
	 *                The function declaration
	 * @return The two parts (before and after the exclamation mark) of the function declaration's name.
	 */
	private final String[] getFunctionDeclarationNameParts(final FunctionDeclaration functionDeclaration) {
		int exclamationMarkIndex = functionDeclaration.getName().indexOf("!");

		if (exclamationMarkIndex == -1) {
			return new String[] { functionDeclaration.getName(), "" };
		} else {
			return new String[] { functionDeclaration.getName().substring(0, exclamationMarkIndex),
			                functionDeclaration.getName().substring(exclamationMarkIndex + 1) };
		}
	}

	@Override
	public void visit(final ReturnStatement returnStatement) {
		returnStatement.getReturnValue().accept(this);
	}

	@Override
	public void visit(final Block block) {
		for (Statement stmt : block.getStatements()) {
			stmt.accept(this);
			this.append("\n");
		}
	}

	@Override
	public void visit(final FunctionCall functionCall) {
		this.append(this.getFunctionDeclarationDisplayName(functionCall.getFunction()));
		this.append("(");
		final List<Expression> actuals = functionCall.getActuals();
		if (!actuals.isEmpty()) {
			final Iterator<Expression> i = actuals.iterator();
			i.next().accept(this);
			while (i.hasNext()) {
				this.append(", ");
				i.next().accept(this);
			}
		}
		this.append(")");
	}

}
