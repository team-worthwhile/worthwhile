package edu.kit.iti.formal.pse.worthwhile.model.ast.visitor;

import edu.kit.iti.formal.pse.worthwhile.model.ast.VariableDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.util.AstNodeCreatorHelper;

/**
 * Visitor that substitutes one {@link VariableDeclaration} with another one.
 * 
 * @author Leon Handreke
 */
public class VariableDeclarationSubstitutionVisitor extends VariableReferenceSubstitution {
	/**
	 * Constructs a new instance with the given {@link VariableDeclaration} to substitute and the
	 * {@link VariableDeclaration} to substitute it with.
	 * 
	 * @param substitutedVariableDeclaration
	 *                the declaration to be substituted
	 * @param substituteVariableDeclaration
	 *                the declaration to substitute with
	 */
	public VariableDeclarationSubstitutionVisitor(final VariableDeclaration substitutedVariableDeclaration,
	                final VariableDeclaration substituteVariableDeclaration) {
		super(substitutedVariableDeclaration, AstNodeCreatorHelper
		                .createVariableReference(substituteVariableDeclaration));
	}
}
