package edu.kit.iti.formal.pse.worthwhile.prover.transformer;

import java.util.ArrayList;
import java.util.List;

import edu.kit.iti.formal.pse.worthwhile.model.ast.ASTNode;
import edu.kit.iti.formal.pse.worthwhile.model.ast.Expression;

/**
 * Represents a provable {@link Expression} with "real world" implications for the correctness of Programs.
 * 
 * @author Leon Handreke
 */
public class Proof implements Cloneable {
	/**
	 * "Real world" implication that this proof carries.
	 */
	private ProofImplication implication;

	/**
	 * Expression that has to be proven correct.
	 */
	private Expression expression;

	/**
	 * {@link ASTNode}s that this Proof relates to, i.e. that "can be proven" using this Proof.
	 */
	private List<ASTNode> relatedAstNodes = new ArrayList<ASTNode>();

	/**
	 * Construct a new {@link Proof} instance with the given parameters.
	 * 
	 * @param expression
	 *                the {@link Expression} to prove
	 * @param implication
	 *                the "real world" implication of this proof.
	 */
	public Proof(final Expression expression, final ProofImplication implication) {
		this.expression = expression;
		this.implication = implication;
	}

	/**
	 * Construct a new {@link Proof} instance with the given parameters.
	 * 
	 * @param expression
	 *                the {@link Expression} to prove
	 * @param implication
	 *                the "real world" implication of this proof.
	 * @param relatedAstNode
	 *                a single {@link ASTNode} related to this {@link Proof}
	 */
	public Proof(final Expression expression, final ProofImplication implication, final ASTNode relatedAstNode) {
		this(expression, implication);
		this.relatedAstNodes.add(relatedAstNode);
	}

	/**
	 * @return the {@link ASTNode}s related to this {@link Proof} instance.
	 */
	public final List<ASTNode> getRelatedAstNodes() {
		return relatedAstNodes;
	}

	/**
	 * Set the {@link ASTNode}s related to this {@link Proof} instance.
	 * 
	 * @param relatedAstNodes
	 *                the related nodes to set
	 */
	public final void setRelatedAstNodes(final List<ASTNode> relatedAstNodes) {
		this.relatedAstNodes = relatedAstNodes;
	}

	/**
	 * @return the implication of this {@link Proof} instance
	 */
	public final ProofImplication getImplication() {
		return implication;
	}

	/**
	 * @return the {@link Expression} to be proven for this {@link Proof} instance.
	 */
	public final Expression getExpression() {
		return expression;
	}

	/**
	 * Set the {@link Expression} to be proven for this {@link Proof} instance.
	 * 
	 * @param expression
	 *                the expression to set
	 */
	public final void setExpression(final Expression expression) {
		this.expression = expression;
	}

	@Override
	public final Proof clone() {
		Proof newProof = new Proof(this.getExpression(), this.getImplication());
		newProof.setRelatedAstNodes(this.getRelatedAstNodes());
		return newProof;
	}

}
