package edu.kit.iti.formal.pse.worthwhile.ui.outline;

import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

import com.google.inject.Inject;

import edu.kit.iti.formal.pse.worthwhile.model.ast.Annotation;
import edu.kit.iti.formal.pse.worthwhile.model.ast.AstPackage;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Block;
import edu.kit.iti.formal.pse.worthwhile.model.ast.FunctionDeclaration;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Program;

/**
 * Provides an outline structure for a Worthwhile program.
 * 
 * @author Joachim
 * 
 * @nocheckstyle:methodname (convention requires method names to contain underscores)
 * 
 */
public class WorthwhileOutlineTreeProvider extends DefaultOutlineTreeProvider {

	/**
	 * The image helper.
	 */
	@Inject
	private PluginImageHelper imageHelper;

	/**
	 * Computes the child outline nodes of a {@link Program}.
	 * 
	 * @param parentNode
	 *                The root node in the outline.
	 * @param program
	 *                The program.
	 */
	protected final void _createChildren(final DocumentRootNode parentNode, final Program program) {
		createEStructuralFeatureNode(parentNode, program, AstPackage.eINSTANCE.getProgram_Axioms(),
		                imageHelper.getImage(imageHelper.getDefaultImage()), "Axioms",
		                program.getAxioms() == null || program.getAxioms().size() == 0);

		createEStructuralFeatureNode(parentNode, program,
		                AstPackage.eINSTANCE.getProgram_FunctionDeclarations(),
		                imageHelper.getImage(imageHelper.getDefaultImage()), "Function declarations",
		                program.getFunctionDeclarations() == null
		                                || program.getFunctionDeclarations().size() == 0);

		createEStructuralFeatureNode(parentNode, program, AstPackage.eINSTANCE.getProgram_MainBlock(),
		                imageHelper.getImage(imageHelper.getDefaultImage()), "Main block", true);
	}

	/**
	 * Computes the child outline nodes of a {@link FunctionDeclaration}.
	 * 
	 * @param parentNode
	 *                The parent node in the outline.
	 * @param funcdec
	 *                The function declaration.
	 */
	protected final void _createChildren(final IOutlineNode parentNode, final FunctionDeclaration funcdec) {
		createEStructuralFeatureNode(parentNode, funcdec,
		                AstPackage.eINSTANCE.getFunctionDeclaration_Preconditions(),
		                imageHelper.getImage(imageHelper.getDefaultImage()), "Preconditions",
		                funcdec.getPreconditions() == null || funcdec.getPreconditions().size() == 0);

		createEStructuralFeatureNode(parentNode, funcdec,
		                AstPackage.eINSTANCE.getFunctionDeclaration_Postconditions(),
		                imageHelper.getImage(imageHelper.getDefaultImage()), "Postconditions",
		                funcdec.getPostconditions() == null || funcdec.getPostconditions().size() == 0);

		createEStructuralFeatureNode(parentNode, funcdec, AstPackage.eINSTANCE.getFunctionDeclaration_Body(),
		                imageHelper.getImage(imageHelper.getDefaultImage()), "Body", true);
	}

	/**
	 * Specifies whether an annotation node is a leaf.
	 * 
	 * @param annotation
	 *                The annotation node.
	 * @return whether this annotation node is a leaf.
	 */
	protected final boolean _isLeaf(final Annotation annotation) {
		return true;
	}

	/**
	 * Specifies whether a block node is a leaf.
	 * 
	 * @param block
	 *                The block node.
	 * @return whether this block node is a leaf.
	 */
	protected final boolean _isLeaf(final Block block) {
		return true;
	}
}
