package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractMyDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected MyDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Atomic___LeftParenthesisKeyword_0_2_0_RightParenthesisKeyword_0_2_3__q;
	protected AbstractElementAlias match_Block_LineFeedLfKeyword_2_q;
	protected AbstractElementAlias match_Block_LineFeedLfKeyword_4_q;
	protected AbstractElementAlias match_GreaterOrEqualComparisonType_GreaterThanOrEqualToKeyword_1_1_or_GreaterThanSignEqualsSignKeyword_1_0;
	protected AbstractElementAlias match_LessOrEqualComparisonType_LessThanOrEqualToKeyword_1_1_or_LessThanSignEqualsSignKeyword_1_0;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (MyDslGrammarAccess) access;
		match_Atomic___LeftParenthesisKeyword_0_2_0_RightParenthesisKeyword_0_2_3__q = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_2_0()), new TokenAlias(false, false, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2_3()));
		match_Block_LineFeedLfKeyword_2_q = new TokenAlias(true, false, grammarAccess.getBlockAccess().getLineFeedLfKeyword_2());
		match_Block_LineFeedLfKeyword_4_q = new TokenAlias(true, false, grammarAccess.getBlockAccess().getLineFeedLfKeyword_4());
		match_GreaterOrEqualComparisonType_GreaterThanOrEqualToKeyword_1_1_or_GreaterThanSignEqualsSignKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGreaterOrEqualComparisonTypeAccess().getGreaterThanOrEqualToKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getGreaterOrEqualComparisonTypeAccess().getGreaterThanSignEqualsSignKeyword_1_0()));
		match_LessOrEqualComparisonType_LessThanOrEqualToKeyword_1_1_or_LessThanSignEqualsSignKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLessOrEqualComparisonTypeAccess().getLessThanOrEqualToKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getLessOrEqualComparisonTypeAccess().getLessThanSignEqualsSignKeyword_1_0()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Atomic___LeftParenthesisKeyword_0_2_0_RightParenthesisKeyword_0_2_3__q.equals(syntax))
				emit_Atomic___LeftParenthesisKeyword_0_2_0_RightParenthesisKeyword_0_2_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Block_LineFeedLfKeyword_2_q.equals(syntax))
				emit_Block_LineFeedLfKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Block_LineFeedLfKeyword_4_q.equals(syntax))
				emit_Block_LineFeedLfKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GreaterOrEqualComparisonType_GreaterThanOrEqualToKeyword_1_1_or_GreaterThanSignEqualsSignKeyword_1_0.equals(syntax))
				emit_GreaterOrEqualComparisonType_GreaterThanOrEqualToKeyword_1_1_or_GreaterThanSignEqualsSignKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LessOrEqualComparisonType_LessThanOrEqualToKeyword_1_1_or_LessThanSignEqualsSignKeyword_1_0.equals(syntax))
				emit_LessOrEqualComparisonType_LessThanOrEqualToKeyword_1_1_or_LessThanSignEqualsSignKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_Atomic___LeftParenthesisKeyword_0_2_0_RightParenthesisKeyword_0_2_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '
	 '?
	 */
	protected void emit_Block_LineFeedLfKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '
	 '?
	 */
	protected void emit_Block_LineFeedLfKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '≥' | '>='
	 */
	protected void emit_GreaterOrEqualComparisonType_GreaterThanOrEqualToKeyword_1_1_or_GreaterThanSignEqualsSignKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '≤' | '<='
	 */
	protected void emit_LessOrEqualComparisonType_LessThanOrEqualToKeyword_1_1_or_LessThanSignEqualsSignKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
