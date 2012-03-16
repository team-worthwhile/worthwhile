package edu.kit.iti.formal.pse.worthwhile.z3model;

import java.util.Iterator;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
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
		this.append(functionDeclaration.getName());
		
		List<VariableDeclaration> params = functionDeclaration.getParameters();
		if (!params.isEmpty()) {
			this.append("(");
			Iterator<VariableDeclaration> i = functionDeclaration.getParameters().iterator();
			// params is not empty, i has next
			i.next().accept(this);
			while (i.hasNext()) {
				this.append(", ");
				i.next().accept(this);
			}
			this.append(") ");
		}
		
		this.append(" := ");

		functionDeclaration.getBody().accept(this);
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

}
