package edu.kit.iti.formal.pse.worthwhile.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.kit.iti.formal.pse.worthwhile.services.WorthwhileGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWorthwhileParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_ID", "RULE_NUMBER", "RULE_BOOL", "RULE_WS", "RULE_SL_COMMENT", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'_axiom'", "'{'", "'}'", "'return'", "'while'", "'_invariant'", "'if'", "'else'", "'function'", "'('", "','", "')'", "'_requires'", "'_ensures'", "'Integer'", "'Boolean'", "'['", "']'", "'_assert'", "'_assume'", "'forall'", "'\\u2200'", "'exists'", "'\\u2203'", "':'", "':='", "'\\u2228'", "'||'", "'\\u2227'", "'&&'", "'='", "'!='", "'\\u2260'", "'<'", "'<='", "'\\u2264'", "'>='", "'\\u2265'", "'>'", "'+'", "'-'", "'*'", "'\\u00B7'", "'/'", "'\\u00F7'", "'%'", "'\\u00AC'", "'!'", "'length'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_BOOL=7;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__14=14;
    public static final int T__59=59;
    public static final int RULE_INT=10;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_NL=4;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=11;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=8;

    // delegates
    // delegators


        public InternalWorthwhileParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWorthwhileParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWorthwhileParser.tokenNames; }
    public String getGrammarFileName() { return "../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g"; }



     	private WorthwhileGrammarAccess grammarAccess;
     	
        public InternalWorthwhileParser(TokenStream input, WorthwhileGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Program";	
       	}
       	
       	@Override
       	protected WorthwhileGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleProgram"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:67:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:68:2: (iv_ruleProgram= ruleProgram EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:69:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram75);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:76:1: ruleProgram returns [EObject current=null] : ( () (this_NL_1= RULE_NL )* ( ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) ) (this_NL_4= RULE_NL )+ )* ( (lv_mainBlock_5_0= ruleBlock ) ) ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token this_NL_1=null;
        Token this_NL_4=null;
        EObject lv_axioms_2_0 = null;

        EObject lv_functionDeclarations_3_0 = null;

        EObject lv_mainBlock_5_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:79:28: ( ( () (this_NL_1= RULE_NL )* ( ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) ) (this_NL_4= RULE_NL )+ )* ( (lv_mainBlock_5_0= ruleBlock ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:80:1: ( () (this_NL_1= RULE_NL )* ( ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) ) (this_NL_4= RULE_NL )+ )* ( (lv_mainBlock_5_0= ruleBlock ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:80:1: ( () (this_NL_1= RULE_NL )* ( ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) ) (this_NL_4= RULE_NL )+ )* ( (lv_mainBlock_5_0= ruleBlock ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:80:2: () (this_NL_1= RULE_NL )* ( ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) ) (this_NL_4= RULE_NL )+ )* ( (lv_mainBlock_5_0= ruleBlock ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:80:2: ()
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProgramAccess().getProgramAction_0(),
                        current);
                

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:86:2: (this_NL_1= RULE_NL )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:86:3: this_NL_1= RULE_NL
            	    {
            	    this_NL_1=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleProgram131); 
            	     
            	        newLeafNode(this_NL_1, grammarAccess.getProgramAccess().getNLTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:90:3: ( ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) ) (this_NL_4= RULE_NL )+ )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14||LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:90:4: ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) ) (this_NL_4= RULE_NL )+
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:90:4: ( ( (lv_axioms_2_0= ruleAxiom ) ) | ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) ) )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==14) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==22) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:90:5: ( (lv_axioms_2_0= ruleAxiom ) )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:90:5: ( (lv_axioms_2_0= ruleAxiom ) )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:91:1: (lv_axioms_2_0= ruleAxiom )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:91:1: (lv_axioms_2_0= ruleAxiom )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:92:3: lv_axioms_2_0= ruleAxiom
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getProgramAccess().getAxiomsAxiomParserRuleCall_2_0_0_0()); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_ruleAxiom_in_ruleProgram155);
            	            lv_axioms_2_0=ruleAxiom();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"axioms",
            	                    		lv_axioms_2_0, 
            	                    		"Axiom");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:109:6: ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:109:6: ( (lv_functionDeclarations_3_0= ruleFunctionDeclaration ) )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:110:1: (lv_functionDeclarations_3_0= ruleFunctionDeclaration )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:110:1: (lv_functionDeclarations_3_0= ruleFunctionDeclaration )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:111:3: lv_functionDeclarations_3_0= ruleFunctionDeclaration
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getProgramAccess().getFunctionDeclarationsFunctionDeclarationParserRuleCall_2_0_1_0()); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_ruleFunctionDeclaration_in_ruleProgram182);
            	            lv_functionDeclarations_3_0=ruleFunctionDeclaration();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"functionDeclarations",
            	                    		lv_functionDeclarations_3_0, 
            	                    		"FunctionDeclaration");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:127:3: (this_NL_4= RULE_NL )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_NL) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:127:4: this_NL_4= RULE_NL
            	    	    {
            	    	    this_NL_4=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleProgram195); 
            	    	     
            	    	        newLeafNode(this_NL_4, grammarAccess.getProgramAccess().getNLTerminalRuleCall_2_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:131:5: ( (lv_mainBlock_5_0= ruleBlock ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:132:1: (lv_mainBlock_5_0= ruleBlock )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:132:1: (lv_mainBlock_5_0= ruleBlock )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:133:3: lv_mainBlock_5_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getMainBlockBlockParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_ruleProgram219);
            lv_mainBlock_5_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"mainBlock",
                    		lv_mainBlock_5_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleAxiom"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:157:1: entryRuleAxiom returns [EObject current=null] : iv_ruleAxiom= ruleAxiom EOF ;
    public final EObject entryRuleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAxiom = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:158:2: (iv_ruleAxiom= ruleAxiom EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:159:2: iv_ruleAxiom= ruleAxiom EOF
            {
             newCompositeNode(grammarAccess.getAxiomRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAxiom_in_entryRuleAxiom255);
            iv_ruleAxiom=ruleAxiom();

            state._fsp--;

             current =iv_ruleAxiom; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAxiom265); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAxiom"


    // $ANTLR start "ruleAxiom"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:166:1: ruleAxiom returns [EObject current=null] : (otherlv_0= '_axiom' ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:169:28: ( (otherlv_0= '_axiom' ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:170:1: (otherlv_0= '_axiom' ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:170:1: (otherlv_0= '_axiom' ( (lv_expression_1_0= ruleExpression ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:170:3: otherlv_0= '_axiom' ( (lv_expression_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleAxiom302); 

                	newLeafNode(otherlv_0, grammarAccess.getAxiomAccess().get_axiomKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:174:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:175:1: (lv_expression_1_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:175:1: (lv_expression_1_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:176:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAxiomAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleAxiom323);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAxiomRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAxiom"


    // $ANTLR start "entryRuleBlock"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:200:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:201:2: (iv_ruleBlock= ruleBlock EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:202:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_entryRuleBlock359);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBlock369); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:209:1: ruleBlock returns [EObject current=null] : ( () ( ( (lv_statements_1_0= ruleStatement ) ) (this_NL_2= RULE_NL )+ )* ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token this_NL_2=null;
        EObject lv_statements_1_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:212:28: ( ( () ( ( (lv_statements_1_0= ruleStatement ) ) (this_NL_2= RULE_NL )+ )* ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:213:1: ( () ( ( (lv_statements_1_0= ruleStatement ) ) (this_NL_2= RULE_NL )+ )* )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:213:1: ( () ( ( (lv_statements_1_0= ruleStatement ) ) (this_NL_2= RULE_NL )+ )* )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:213:2: () ( ( (lv_statements_1_0= ruleStatement ) ) (this_NL_2= RULE_NL )+ )*
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:213:2: ()
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:214:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlockAccess().getBlockAction_0(),
                        current);
                

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:219:2: ( ( (lv_statements_1_0= ruleStatement ) ) (this_NL_2= RULE_NL )+ )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||LA6_0==15||(LA6_0>=17 && LA6_0<=18)||LA6_0==20||(LA6_0>=28 && LA6_0<=29)||(LA6_0>=32 && LA6_0<=33)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:219:3: ( (lv_statements_1_0= ruleStatement ) ) (this_NL_2= RULE_NL )+
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:219:3: ( (lv_statements_1_0= ruleStatement ) )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:220:1: (lv_statements_1_0= ruleStatement )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:220:1: (lv_statements_1_0= ruleStatement )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:221:3: lv_statements_1_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleBlock425);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_1_0, 
            	            		"Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:237:2: (this_NL_2= RULE_NL )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==RULE_NL) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:237:3: this_NL_2= RULE_NL
            	    	    {
            	    	    this_NL_2=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleBlock437); 
            	    	     
            	    	        newLeafNode(this_NL_2, grammarAccess.getBlockAccess().getNLTerminalRuleCall_1_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleBracedBlock"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:249:1: entryRuleBracedBlock returns [EObject current=null] : iv_ruleBracedBlock= ruleBracedBlock EOF ;
    public final EObject entryRuleBracedBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBracedBlock = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:250:2: (iv_ruleBracedBlock= ruleBracedBlock EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:251:2: iv_ruleBracedBlock= ruleBracedBlock EOF
            {
             newCompositeNode(grammarAccess.getBracedBlockRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBracedBlock_in_entryRuleBracedBlock476);
            iv_ruleBracedBlock=ruleBracedBlock();

            state._fsp--;

             current =iv_ruleBracedBlock; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBracedBlock486); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBracedBlock"


    // $ANTLR start "ruleBracedBlock"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:258:1: ruleBracedBlock returns [EObject current=null] : ( () otherlv_1= '{' (this_NL_2= RULE_NL )* ( ( (lv_statements_3_0= ruleStatement ) ) (this_NL_4= RULE_NL )+ )* otherlv_5= '}' ) ;
    public final EObject ruleBracedBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_NL_2=null;
        Token this_NL_4=null;
        Token otherlv_5=null;
        EObject lv_statements_3_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:261:28: ( ( () otherlv_1= '{' (this_NL_2= RULE_NL )* ( ( (lv_statements_3_0= ruleStatement ) ) (this_NL_4= RULE_NL )+ )* otherlv_5= '}' ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:262:1: ( () otherlv_1= '{' (this_NL_2= RULE_NL )* ( ( (lv_statements_3_0= ruleStatement ) ) (this_NL_4= RULE_NL )+ )* otherlv_5= '}' )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:262:1: ( () otherlv_1= '{' (this_NL_2= RULE_NL )* ( ( (lv_statements_3_0= ruleStatement ) ) (this_NL_4= RULE_NL )+ )* otherlv_5= '}' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:262:2: () otherlv_1= '{' (this_NL_2= RULE_NL )* ( ( (lv_statements_3_0= ruleStatement ) ) (this_NL_4= RULE_NL )+ )* otherlv_5= '}'
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:262:2: ()
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:263:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBracedBlockAccess().getBlockAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleBracedBlock532); 

                	newLeafNode(otherlv_1, grammarAccess.getBracedBlockAccess().getLeftCurlyBracketKeyword_1());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:272:1: (this_NL_2= RULE_NL )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_NL) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:272:2: this_NL_2= RULE_NL
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleBracedBlock544); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getBracedBlockAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:276:3: ( ( (lv_statements_3_0= ruleStatement ) ) (this_NL_4= RULE_NL )+ )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==15||(LA9_0>=17 && LA9_0<=18)||LA9_0==20||(LA9_0>=28 && LA9_0<=29)||(LA9_0>=32 && LA9_0<=33)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:276:4: ( (lv_statements_3_0= ruleStatement ) ) (this_NL_4= RULE_NL )+
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:276:4: ( (lv_statements_3_0= ruleStatement ) )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:277:1: (lv_statements_3_0= ruleStatement )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:277:1: (lv_statements_3_0= ruleStatement )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:278:3: lv_statements_3_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBracedBlockAccess().getStatementsStatementParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleBracedBlock567);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBracedBlockRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_3_0, 
            	            		"Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:294:2: (this_NL_4= RULE_NL )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==RULE_NL) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:294:3: this_NL_4= RULE_NL
            	    	    {
            	    	    this_NL_4=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleBracedBlock579); 
            	    	     
            	    	        newLeafNode(this_NL_4, grammarAccess.getBracedBlockAccess().getNLTerminalRuleCall_3_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleBracedBlock594); 

                	newLeafNode(otherlv_5, grammarAccess.getBracedBlockAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBracedBlock"


    // $ANTLR start "entryRuleStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:310:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:311:2: (iv_ruleStatement= ruleStatement EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:312:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStatement_in_entryRuleStatement630);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStatement640); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:319:1: ruleStatement returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_BracedBlock_2= ruleBracedBlock | this_Annotation_3= ruleAnnotation | this_IfStatement_4= ruleIfStatement | this_WhileStatement_5= ruleWhileStatement | this_ReturnStatement_6= ruleReturnStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_Assignment_1 = null;

        EObject this_BracedBlock_2 = null;

        EObject this_Annotation_3 = null;

        EObject this_IfStatement_4 = null;

        EObject this_WhileStatement_5 = null;

        EObject this_ReturnStatement_6 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:322:28: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_BracedBlock_2= ruleBracedBlock | this_Annotation_3= ruleAnnotation | this_IfStatement_4= ruleIfStatement | this_WhileStatement_5= ruleWhileStatement | this_ReturnStatement_6= ruleReturnStatement ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:323:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_BracedBlock_2= ruleBracedBlock | this_Annotation_3= ruleAnnotation | this_IfStatement_4= ruleIfStatement | this_WhileStatement_5= ruleWhileStatement | this_ReturnStatement_6= ruleReturnStatement )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:323:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_BracedBlock_2= ruleBracedBlock | this_Annotation_3= ruleAnnotation | this_IfStatement_4= ruleIfStatement | this_WhileStatement_5= ruleWhileStatement | this_ReturnStatement_6= ruleReturnStatement )
            int alt10=7;
            switch ( input.LA(1) ) {
            case 28:
            case 29:
                {
                alt10=1;
                }
                break;
            case RULE_ID:
                {
                alt10=2;
                }
                break;
            case 15:
                {
                alt10=3;
                }
                break;
            case 32:
            case 33:
                {
                alt10=4;
                }
                break;
            case 20:
                {
                alt10=5;
                }
                break;
            case 18:
                {
                alt10=6;
                }
                break;
            case 17:
                {
                alt10=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:324:5: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleVariableDeclaration_in_ruleStatement687);
                    this_VariableDeclaration_0=ruleVariableDeclaration();

                    state._fsp--;

                     
                            current = this_VariableDeclaration_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:334:5: this_Assignment_1= ruleAssignment
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_ruleStatement714);
                    this_Assignment_1=ruleAssignment();

                    state._fsp--;

                     
                            current = this_Assignment_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:344:5: this_BracedBlock_2= ruleBracedBlock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBracedBlockParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBracedBlock_in_ruleStatement741);
                    this_BracedBlock_2=ruleBracedBlock();

                    state._fsp--;

                     
                            current = this_BracedBlock_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:354:5: this_Annotation_3= ruleAnnotation
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getAnnotationParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_ruleStatement768);
                    this_Annotation_3=ruleAnnotation();

                    state._fsp--;

                     
                            current = this_Annotation_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:364:5: this_IfStatement_4= ruleIfStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIfStatement_in_ruleStatement795);
                    this_IfStatement_4=ruleIfStatement();

                    state._fsp--;

                     
                            current = this_IfStatement_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:374:5: this_WhileStatement_5= ruleWhileStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleWhileStatement_in_ruleStatement822);
                    this_WhileStatement_5=ruleWhileStatement();

                    state._fsp--;

                     
                            current = this_WhileStatement_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:384:5: this_ReturnStatement_6= ruleReturnStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReturnStatement_in_ruleStatement849);
                    this_ReturnStatement_6=ruleReturnStatement();

                    state._fsp--;

                     
                            current = this_ReturnStatement_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:400:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:401:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:402:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             newCompositeNode(grammarAccess.getReturnStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement884);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReturnStatement894); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturnStatement"


    // $ANTLR start "ruleReturnStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:409:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' ( (lv_returnValue_1_0= ruleExpression ) ) ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_returnValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:412:28: ( (otherlv_0= 'return' ( (lv_returnValue_1_0= ruleExpression ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:413:1: (otherlv_0= 'return' ( (lv_returnValue_1_0= ruleExpression ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:413:1: (otherlv_0= 'return' ( (lv_returnValue_1_0= ruleExpression ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:413:3: otherlv_0= 'return' ( (lv_returnValue_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleReturnStatement931); 

                	newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:417:1: ( (lv_returnValue_1_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:418:1: (lv_returnValue_1_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:418:1: (lv_returnValue_1_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:419:3: lv_returnValue_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getReturnStatementAccess().getReturnValueExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleReturnStatement952);
            lv_returnValue_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReturnStatementRule());
            	        }
                   		set(
                   			current, 
                   			"returnValue",
                    		lv_returnValue_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:443:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:444:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:445:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement988);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWhileStatement998); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:452:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_invariants_2_0= ruleInvariant ) )* ( (lv_body_3_0= ruleBracedBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject lv_invariants_2_0 = null;

        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:455:28: ( (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_invariants_2_0= ruleInvariant ) )* ( (lv_body_3_0= ruleBracedBlock ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:456:1: (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_invariants_2_0= ruleInvariant ) )* ( (lv_body_3_0= ruleBracedBlock ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:456:1: (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_invariants_2_0= ruleInvariant ) )* ( (lv_body_3_0= ruleBracedBlock ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:456:3: otherlv_0= 'while' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_invariants_2_0= ruleInvariant ) )* ( (lv_body_3_0= ruleBracedBlock ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleWhileStatement1035); 

                	newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:460:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:461:1: (lv_condition_1_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:461:1: (lv_condition_1_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:462:3: lv_condition_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleWhileStatement1056);
            lv_condition_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:478:2: ( (lv_invariants_2_0= ruleInvariant ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==19) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:479:1: (lv_invariants_2_0= ruleInvariant )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:479:1: (lv_invariants_2_0= ruleInvariant )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:480:3: lv_invariants_2_0= ruleInvariant
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWhileStatementAccess().getInvariantsInvariantParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleInvariant_in_ruleWhileStatement1077);
            	    lv_invariants_2_0=ruleInvariant();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"invariants",
            	            		lv_invariants_2_0, 
            	            		"Invariant");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:496:3: ( (lv_body_3_0= ruleBracedBlock ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:497:1: (lv_body_3_0= ruleBracedBlock )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:497:1: (lv_body_3_0= ruleBracedBlock )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:498:3: lv_body_3_0= ruleBracedBlock
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBracedBlockParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBracedBlock_in_ruleWhileStatement1099);
            lv_body_3_0=ruleBracedBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_3_0, 
                    		"BracedBlock");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleInvariant"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:522:1: entryRuleInvariant returns [EObject current=null] : iv_ruleInvariant= ruleInvariant EOF ;
    public final EObject entryRuleInvariant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvariant = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:523:2: (iv_ruleInvariant= ruleInvariant EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:524:2: iv_ruleInvariant= ruleInvariant EOF
            {
             newCompositeNode(grammarAccess.getInvariantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInvariant_in_entryRuleInvariant1135);
            iv_ruleInvariant=ruleInvariant();

            state._fsp--;

             current =iv_ruleInvariant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvariant1145); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvariant"


    // $ANTLR start "ruleInvariant"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:531:1: ruleInvariant returns [EObject current=null] : (otherlv_0= '_invariant' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ ) ;
    public final EObject ruleInvariant() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NL_2=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:534:28: ( (otherlv_0= '_invariant' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:535:1: (otherlv_0= '_invariant' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:535:1: (otherlv_0= '_invariant' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:535:3: otherlv_0= '_invariant' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleInvariant1182); 

                	newLeafNode(otherlv_0, grammarAccess.getInvariantAccess().get_invariantKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:539:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:540:1: (lv_expression_1_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:540:1: (lv_expression_1_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:541:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getInvariantAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleInvariant1203);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvariantRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:557:2: (this_NL_2= RULE_NL )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NL) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:557:3: this_NL_2= RULE_NL
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleInvariant1215); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getInvariantAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvariant"


    // $ANTLR start "entryRuleIfStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:569:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:570:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:571:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIfStatement_in_entryRuleIfStatement1252);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfStatement1262); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:578:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_trueBlock_2_0= ruleBracedBlock ) ) (otherlv_3= 'else' ( (lv_falseBlock_4_0= ruleBracedBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_condition_1_0 = null;

        EObject lv_trueBlock_2_0 = null;

        EObject lv_falseBlock_4_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:581:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_trueBlock_2_0= ruleBracedBlock ) ) (otherlv_3= 'else' ( (lv_falseBlock_4_0= ruleBracedBlock ) ) )? ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:582:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_trueBlock_2_0= ruleBracedBlock ) ) (otherlv_3= 'else' ( (lv_falseBlock_4_0= ruleBracedBlock ) ) )? )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:582:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_trueBlock_2_0= ruleBracedBlock ) ) (otherlv_3= 'else' ( (lv_falseBlock_4_0= ruleBracedBlock ) ) )? )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:582:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpression ) ) ( (lv_trueBlock_2_0= ruleBracedBlock ) ) (otherlv_3= 'else' ( (lv_falseBlock_4_0= ruleBracedBlock ) ) )?
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIfStatement1299); 

                	newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:586:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:587:1: (lv_condition_1_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:587:1: (lv_condition_1_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:588:3: lv_condition_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getConditionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleIfStatement1320);
            lv_condition_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:604:2: ( (lv_trueBlock_2_0= ruleBracedBlock ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:605:1: (lv_trueBlock_2_0= ruleBracedBlock )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:605:1: (lv_trueBlock_2_0= ruleBracedBlock )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:606:3: lv_trueBlock_2_0= ruleBracedBlock
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getTrueBlockBracedBlockParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBracedBlock_in_ruleIfStatement1341);
            lv_trueBlock_2_0=ruleBracedBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	        }
                   		set(
                   			current, 
                   			"trueBlock",
                    		lv_trueBlock_2_0, 
                    		"BracedBlock");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:622:2: (otherlv_3= 'else' ( (lv_falseBlock_4_0= ruleBracedBlock ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:622:4: otherlv_3= 'else' ( (lv_falseBlock_4_0= ruleBracedBlock ) )
                    {
                    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleIfStatement1354); 

                        	newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getElseKeyword_3_0());
                        
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:626:1: ( (lv_falseBlock_4_0= ruleBracedBlock ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:627:1: (lv_falseBlock_4_0= ruleBracedBlock )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:627:1: (lv_falseBlock_4_0= ruleBracedBlock )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:628:3: lv_falseBlock_4_0= ruleBracedBlock
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfStatementAccess().getFalseBlockBracedBlockParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBracedBlock_in_ruleIfStatement1375);
                    lv_falseBlock_4_0=ruleBracedBlock();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"falseBlock",
                            		lv_falseBlock_4_0, 
                            		"BracedBlock");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleFunctionDeclaration"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:652:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:653:2: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:654:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getFunctionDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFunctionDeclaration_in_entryRuleFunctionDeclaration1413);
            iv_ruleFunctionDeclaration=ruleFunctionDeclaration();

            state._fsp--;

             current =iv_ruleFunctionDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFunctionDeclaration1423); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDeclaration"


    // $ANTLR start "ruleFunctionDeclaration"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:661:1: ruleFunctionDeclaration returns [EObject current=null] : (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (this_NL_8= RULE_NL )* ( ( (lv_preconditions_9_0= ruleRequire ) ) | ( (lv_postconditions_10_0= ruleEnsure ) ) )* ( (lv_body_11_0= ruleBracedBlock ) ) ) ;
    public final EObject ruleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_NL_8=null;
        EObject lv_returnType_1_0 = null;

        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_preconditions_9_0 = null;

        EObject lv_postconditions_10_0 = null;

        EObject lv_body_11_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:664:28: ( (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (this_NL_8= RULE_NL )* ( ( (lv_preconditions_9_0= ruleRequire ) ) | ( (lv_postconditions_10_0= ruleEnsure ) ) )* ( (lv_body_11_0= ruleBracedBlock ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:665:1: (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (this_NL_8= RULE_NL )* ( ( (lv_preconditions_9_0= ruleRequire ) ) | ( (lv_postconditions_10_0= ruleEnsure ) ) )* ( (lv_body_11_0= ruleBracedBlock ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:665:1: (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (this_NL_8= RULE_NL )* ( ( (lv_preconditions_9_0= ruleRequire ) ) | ( (lv_postconditions_10_0= ruleEnsure ) ) )* ( (lv_body_11_0= ruleBracedBlock ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:665:3: otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (this_NL_8= RULE_NL )* ( ( (lv_preconditions_9_0= ruleRequire ) ) | ( (lv_postconditions_10_0= ruleEnsure ) ) )* ( (lv_body_11_0= ruleBracedBlock ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFunctionDeclaration1460); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionDeclarationAccess().getFunctionKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:669:1: ( (lv_returnType_1_0= ruleType ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:670:1: (lv_returnType_1_0= ruleType )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:670:1: (lv_returnType_1_0= ruleType )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:671:3: lv_returnType_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getReturnTypeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleFunctionDeclaration1481);
            lv_returnType_1_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"returnType",
                    		lv_returnType_1_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:687:2: ( (lv_name_2_0= RULE_ID ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:688:1: (lv_name_2_0= RULE_ID )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:688:1: (lv_name_2_0= RULE_ID )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:689:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFunctionDeclaration1498); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFunctionDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFunctionDeclaration1515); 

                	newLeafNode(otherlv_3, grammarAccess.getFunctionDeclarationAccess().getLeftParenthesisKeyword_3());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:709:1: ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=28 && LA15_0<=29)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:709:2: ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:709:2: ( (lv_parameters_4_0= ruleParameter ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:710:1: (lv_parameters_4_0= ruleParameter )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:710:1: (lv_parameters_4_0= ruleParameter )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:711:3: lv_parameters_4_0= ruleParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersParameterParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleFunctionDeclaration1537);
                    lv_parameters_4_0=ruleParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    	        }
                           		add(
                           			current, 
                           			"parameters",
                            		lv_parameters_4_0, 
                            		"Parameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:727:2: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==24) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:727:4: otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleFunctionDeclaration1550); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getFunctionDeclarationAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:731:1: ( (lv_parameters_6_0= ruleParameter ) )
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:732:1: (lv_parameters_6_0= ruleParameter )
                    	    {
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:732:1: (lv_parameters_6_0= ruleParameter )
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:733:3: lv_parameters_6_0= ruleParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersParameterParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleFunctionDeclaration1571);
                    	    lv_parameters_6_0=ruleParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_6_0, 
                    	            		"Parameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleFunctionDeclaration1587); 

                	newLeafNode(otherlv_7, grammarAccess.getFunctionDeclarationAccess().getRightParenthesisKeyword_5());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:753:1: (this_NL_8= RULE_NL )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NL) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:753:2: this_NL_8= RULE_NL
            	    {
            	    this_NL_8=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleFunctionDeclaration1599); 
            	     
            	        newLeafNode(this_NL_8, grammarAccess.getFunctionDeclarationAccess().getNLTerminalRuleCall_6()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:757:3: ( ( (lv_preconditions_9_0= ruleRequire ) ) | ( (lv_postconditions_10_0= ruleEnsure ) ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    alt17=1;
                }
                else if ( (LA17_0==27) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:757:4: ( (lv_preconditions_9_0= ruleRequire ) )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:757:4: ( (lv_preconditions_9_0= ruleRequire ) )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:758:1: (lv_preconditions_9_0= ruleRequire )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:758:1: (lv_preconditions_9_0= ruleRequire )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:759:3: lv_preconditions_9_0= ruleRequire
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getPreconditionsRequireParserRuleCall_7_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRequire_in_ruleFunctionDeclaration1622);
            	    lv_preconditions_9_0=ruleRequire();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"preconditions",
            	            		lv_preconditions_9_0, 
            	            		"Require");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:776:6: ( (lv_postconditions_10_0= ruleEnsure ) )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:776:6: ( (lv_postconditions_10_0= ruleEnsure ) )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:777:1: (lv_postconditions_10_0= ruleEnsure )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:777:1: (lv_postconditions_10_0= ruleEnsure )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:778:3: lv_postconditions_10_0= ruleEnsure
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getPostconditionsEnsureParserRuleCall_7_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnsure_in_ruleFunctionDeclaration1649);
            	    lv_postconditions_10_0=ruleEnsure();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"postconditions",
            	            		lv_postconditions_10_0, 
            	            		"Ensure");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:794:4: ( (lv_body_11_0= ruleBracedBlock ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:795:1: (lv_body_11_0= ruleBracedBlock )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:795:1: (lv_body_11_0= ruleBracedBlock )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:796:3: lv_body_11_0= ruleBracedBlock
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getBodyBracedBlockParserRuleCall_8_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleBracedBlock_in_ruleFunctionDeclaration1672);
            lv_body_11_0=ruleBracedBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_11_0, 
                    		"BracedBlock");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDeclaration"


    // $ANTLR start "entryRuleRequire"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:820:1: entryRuleRequire returns [EObject current=null] : iv_ruleRequire= ruleRequire EOF ;
    public final EObject entryRuleRequire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequire = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:821:2: (iv_ruleRequire= ruleRequire EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:822:2: iv_ruleRequire= ruleRequire EOF
            {
             newCompositeNode(grammarAccess.getRequireRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRequire_in_entryRuleRequire1708);
            iv_ruleRequire=ruleRequire();

            state._fsp--;

             current =iv_ruleRequire; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRequire1718); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequire"


    // $ANTLR start "ruleRequire"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:829:1: ruleRequire returns [EObject current=null] : (otherlv_0= '_requires' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ ) ;
    public final EObject ruleRequire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NL_2=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:832:28: ( (otherlv_0= '_requires' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:833:1: (otherlv_0= '_requires' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:833:1: (otherlv_0= '_requires' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:833:3: otherlv_0= '_requires' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRequire1755); 

                	newLeafNode(otherlv_0, grammarAccess.getRequireAccess().get_requiresKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:837:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:838:1: (lv_expression_1_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:838:1: (lv_expression_1_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:839:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getRequireAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRequire1776);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRequireRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:855:2: (this_NL_2= RULE_NL )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NL) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:855:3: this_NL_2= RULE_NL
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleRequire1788); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getRequireAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequire"


    // $ANTLR start "entryRuleEnsure"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:867:1: entryRuleEnsure returns [EObject current=null] : iv_ruleEnsure= ruleEnsure EOF ;
    public final EObject entryRuleEnsure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnsure = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:868:2: (iv_ruleEnsure= ruleEnsure EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:869:2: iv_ruleEnsure= ruleEnsure EOF
            {
             newCompositeNode(grammarAccess.getEnsureRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnsure_in_entryRuleEnsure1825);
            iv_ruleEnsure=ruleEnsure();

            state._fsp--;

             current =iv_ruleEnsure; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnsure1835); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnsure"


    // $ANTLR start "ruleEnsure"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:876:1: ruleEnsure returns [EObject current=null] : (otherlv_0= '_ensures' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ ) ;
    public final EObject ruleEnsure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NL_2=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:879:28: ( (otherlv_0= '_ensures' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:880:1: (otherlv_0= '_ensures' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:880:1: (otherlv_0= '_ensures' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+ )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:880:3: otherlv_0= '_ensures' ( (lv_expression_1_0= ruleExpression ) ) (this_NL_2= RULE_NL )+
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEnsure1872); 

                	newLeafNode(otherlv_0, grammarAccess.getEnsureAccess().get_ensuresKeyword_0());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:884:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:885:1: (lv_expression_1_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:885:1: (lv_expression_1_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:886:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getEnsureAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleEnsure1893);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEnsureRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:902:2: (this_NL_2= RULE_NL )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_NL) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:902:3: this_NL_2= RULE_NL
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_RULE_NL_in_ruleEnsure1905); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getEnsureAccess().getNLTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnsure"


    // $ANTLR start "entryRuleParameter"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:914:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:915:2: (iv_ruleParameter= ruleParameter EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:916:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter1942);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter1952); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:923:1: ruleParameter returns [EObject current=null] : ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:926:28: ( ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:927:1: ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:927:1: ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:927:2: () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:927:2: ()
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:928:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParameterAccess().getVariableDeclarationAction_0(),
                        current);
                

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:933:2: ( (lv_type_1_0= ruleType ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:934:1: (lv_type_1_0= ruleType )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:934:1: (lv_type_1_0= ruleType )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:935:3: lv_type_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleParameter2007);
            lv_type_1_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:951:2: ( (lv_name_2_0= RULE_ID ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:952:1: (lv_name_2_0= RULE_ID )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:952:1: (lv_name_2_0= RULE_ID )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:953:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter2024); 

            			newLeafNode(lv_name_2_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleType"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:977:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:978:2: (iv_ruleType= ruleType EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:979:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType2065);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType2075); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:986:1: ruleType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_ArrayType_1 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:989:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:990:1: (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:990:1: (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==EOF||LA20_1==RULE_ID) ) {
                    alt20=1;
                }
                else if ( (LA20_1==30) ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA20_0==29) ) {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==EOF||LA20_2==RULE_ID) ) {
                    alt20=1;
                }
                else if ( (LA20_2==30) ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:991:5: this_PrimitiveType_0= rulePrimitiveType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveType_in_ruleType2122);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;

                     
                            current = this_PrimitiveType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1001:5: this_ArrayType_1= ruleArrayType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getArrayTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleArrayType_in_ruleType2149);
                    this_ArrayType_1=ruleArrayType();

                    state._fsp--;

                     
                            current = this_ArrayType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRulePrimitiveType"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1017:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1018:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1019:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType2184);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveType2194); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1026:1: rulePrimitiveType returns [EObject current=null] : ( ( () otherlv_1= 'Integer' ) | ( () otherlv_3= 'Boolean' ) ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1029:28: ( ( ( () otherlv_1= 'Integer' ) | ( () otherlv_3= 'Boolean' ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1030:1: ( ( () otherlv_1= 'Integer' ) | ( () otherlv_3= 'Boolean' ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1030:1: ( ( () otherlv_1= 'Integer' ) | ( () otherlv_3= 'Boolean' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            else if ( (LA21_0==29) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1030:2: ( () otherlv_1= 'Integer' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1030:2: ( () otherlv_1= 'Integer' )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1030:3: () otherlv_1= 'Integer'
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1030:3: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1031:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimitiveTypeAccess().getIntegerTypeAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_rulePrimitiveType2241); 

                        	newLeafNode(otherlv_1, grammarAccess.getPrimitiveTypeAccess().getIntegerKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1041:6: ( () otherlv_3= 'Boolean' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1041:6: ( () otherlv_3= 'Boolean' )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1041:7: () otherlv_3= 'Boolean'
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1041:7: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1042:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimitiveTypeAccess().getBooleanTypeAction_1_0(),
                                current);
                        

                    }

                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_rulePrimitiveType2270); 

                        	newLeafNode(otherlv_3, grammarAccess.getPrimitiveTypeAccess().getBooleanKeyword_1_1());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleArrayType"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1059:1: entryRuleArrayType returns [EObject current=null] : iv_ruleArrayType= ruleArrayType EOF ;
    public final EObject entryRuleArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayType = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1060:2: (iv_ruleArrayType= ruleArrayType EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1061:2: iv_ruleArrayType= ruleArrayType EOF
            {
             newCompositeNode(grammarAccess.getArrayTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleArrayType_in_entryRuleArrayType2307);
            iv_ruleArrayType=ruleArrayType();

            state._fsp--;

             current =iv_ruleArrayType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleArrayType2317); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayType"


    // $ANTLR start "ruleArrayType"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1068:1: ruleArrayType returns [EObject current=null] : ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' ( (lv_size_3_0= ruleExpression ) ) otherlv_4= ']' ) ;
    public final EObject ruleArrayType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_baseType_1_0 = null;

        EObject lv_size_3_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1071:28: ( ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' ( (lv_size_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1072:1: ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' ( (lv_size_3_0= ruleExpression ) ) otherlv_4= ']' )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1072:1: ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' ( (lv_size_3_0= ruleExpression ) ) otherlv_4= ']' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1072:2: () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' ( (lv_size_3_0= ruleExpression ) ) otherlv_4= ']'
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1072:2: ()
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1073:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayTypeAccess().getArrayTypeAction_0(),
                        current);
                

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1078:2: ( (lv_baseType_1_0= rulePrimitiveType ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1079:1: (lv_baseType_1_0= rulePrimitiveType )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1079:1: (lv_baseType_1_0= rulePrimitiveType )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1080:3: lv_baseType_1_0= rulePrimitiveType
            {
             
            	        newCompositeNode(grammarAccess.getArrayTypeAccess().getBaseTypePrimitiveTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveType_in_ruleArrayType2372);
            lv_baseType_1_0=rulePrimitiveType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayTypeRule());
            	        }
                   		set(
                   			current, 
                   			"baseType",
                    		lv_baseType_1_0, 
                    		"PrimitiveType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleArrayType2384); 

                	newLeafNode(otherlv_2, grammarAccess.getArrayTypeAccess().getLeftSquareBracketKeyword_2());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1100:1: ( (lv_size_3_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1101:1: (lv_size_3_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1101:1: (lv_size_3_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1102:3: lv_size_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getArrayTypeAccess().getSizeExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleArrayType2405);
            lv_size_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayTypeRule());
            	        }
                   		set(
                   			current, 
                   			"size",
                    		lv_size_3_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleArrayType2417); 

                	newLeafNode(otherlv_4, grammarAccess.getArrayTypeAccess().getRightSquareBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayType"


    // $ANTLR start "entryRuleFunctionCall"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1130:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1131:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1132:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall2453);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFunctionCall2463); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1139:1: ruleFunctionCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_actuals_2_0= ruleExpression ) )? (otherlv_3= ',' ( (lv_actuals_4_0= ruleExpression ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_actuals_2_0 = null;

        EObject lv_actuals_4_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1142:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_actuals_2_0= ruleExpression ) )? (otherlv_3= ',' ( (lv_actuals_4_0= ruleExpression ) ) )* otherlv_5= ')' ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1143:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_actuals_2_0= ruleExpression ) )? (otherlv_3= ',' ( (lv_actuals_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1143:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_actuals_2_0= ruleExpression ) )? (otherlv_3= ',' ( (lv_actuals_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1143:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_actuals_2_0= ruleExpression ) )? (otherlv_3= ',' ( (lv_actuals_4_0= ruleExpression ) ) )* otherlv_5= ')'
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1143:2: ( (otherlv_0= RULE_ID ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1144:1: (otherlv_0= RULE_ID )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1144:1: (otherlv_0= RULE_ID )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1145:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionCallRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFunctionCall2508); 

            		newLeafNode(otherlv_0, grammarAccess.getFunctionCallAccess().getFunctionFunctionDeclarationCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFunctionCall2520); 

                	newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1160:1: ( (lv_actuals_2_0= ruleExpression ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_BOOL)||LA22_0==23||(LA22_0>=34 && LA22_0<=37)||(LA22_0>=53 && LA22_0<=54)||(LA22_0>=60 && LA22_0<=62)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1161:1: (lv_actuals_2_0= ruleExpression )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1161:1: (lv_actuals_2_0= ruleExpression )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1162:3: lv_actuals_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getActualsExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleFunctionCall2541);
                    lv_actuals_2_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	        }
                           		add(
                           			current, 
                           			"actuals",
                            		lv_actuals_2_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1178:3: (otherlv_3= ',' ( (lv_actuals_4_0= ruleExpression ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1178:5: otherlv_3= ',' ( (lv_actuals_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleFunctionCall2555); 

            	        	newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_0());
            	        
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1182:1: ( (lv_actuals_4_0= ruleExpression ) )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1183:1: (lv_actuals_4_0= ruleExpression )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1183:1: (lv_actuals_4_0= ruleExpression )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1184:3: lv_actuals_4_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getActualsExpressionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleFunctionCall2576);
            	    lv_actuals_4_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"actuals",
            	            		lv_actuals_4_0, 
            	            		"Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleFunctionCall2590); 

                	newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleAnnotation"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1212:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1213:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1214:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnnotation_in_entryRuleAnnotation2626);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnnotation2636); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1221:1: ruleAnnotation returns [EObject current=null] : ( ( ( () otherlv_1= '_assert' ) | ( () otherlv_3= '_assume' ) ) ( (lv_expression_4_0= ruleExpression ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1224:28: ( ( ( ( () otherlv_1= '_assert' ) | ( () otherlv_3= '_assume' ) ) ( (lv_expression_4_0= ruleExpression ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:1: ( ( ( () otherlv_1= '_assert' ) | ( () otherlv_3= '_assume' ) ) ( (lv_expression_4_0= ruleExpression ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:1: ( ( ( () otherlv_1= '_assert' ) | ( () otherlv_3= '_assume' ) ) ( (lv_expression_4_0= ruleExpression ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:2: ( ( () otherlv_1= '_assert' ) | ( () otherlv_3= '_assume' ) ) ( (lv_expression_4_0= ruleExpression ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:2: ( ( () otherlv_1= '_assert' ) | ( () otherlv_3= '_assume' ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            else if ( (LA24_0==33) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:3: ( () otherlv_1= '_assert' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:3: ( () otherlv_1= '_assert' )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:4: () otherlv_1= '_assert'
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1225:4: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1226:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getAnnotationAccess().getAssertionAction_0_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleAnnotation2684); 

                        	newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().get_assertKeyword_0_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1236:6: ( () otherlv_3= '_assume' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1236:6: ( () otherlv_3= '_assume' )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1236:7: () otherlv_3= '_assume'
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1236:7: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1237:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getAnnotationAccess().getAssumptionAction_0_1_0(),
                                current);
                        

                    }

                    otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleAnnotation2713); 

                        	newLeafNode(otherlv_3, grammarAccess.getAnnotationAccess().get_assumeKeyword_0_1_1());
                        

                    }


                    }
                    break;

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1246:3: ( (lv_expression_4_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1247:1: (lv_expression_4_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1247:1: (lv_expression_4_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1248:3: lv_expression_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleAnnotation2736);
            lv_expression_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleQuantifiedExpression"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1272:1: entryRuleQuantifiedExpression returns [EObject current=null] : iv_ruleQuantifiedExpression= ruleQuantifiedExpression EOF ;
    public final EObject entryRuleQuantifiedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuantifiedExpression = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1273:2: (iv_ruleQuantifiedExpression= ruleQuantifiedExpression EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1274:2: iv_ruleQuantifiedExpression= ruleQuantifiedExpression EOF
            {
             newCompositeNode(grammarAccess.getQuantifiedExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuantifiedExpression_in_entryRuleQuantifiedExpression2772);
            iv_ruleQuantifiedExpression=ruleQuantifiedExpression();

            state._fsp--;

             current =iv_ruleQuantifiedExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuantifiedExpression2782); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuantifiedExpression"


    // $ANTLR start "ruleQuantifiedExpression"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1281:1: ruleQuantifiedExpression returns [EObject current=null] : ( ( ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) ) ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )? ) ( ( (lv_expression_9_0= ruleQuantifiedExpression ) ) | (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) ) ) ) ;
    public final EObject ruleQuantifiedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_parameter_6_0 = null;

        EObject lv_condition_8_0 = null;

        EObject lv_expression_9_0 = null;

        EObject lv_expression_11_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1284:28: ( ( ( ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) ) ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )? ) ( ( (lv_expression_9_0= ruleQuantifiedExpression ) ) | (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:1: ( ( ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) ) ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )? ) ( ( (lv_expression_9_0= ruleQuantifiedExpression ) ) | (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:1: ( ( ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) ) ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )? ) ( ( (lv_expression_9_0= ruleQuantifiedExpression ) ) | (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:2: ( ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) ) ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )? ) ( ( (lv_expression_9_0= ruleQuantifiedExpression ) ) | (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:2: ( ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) ) ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )? )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:3: ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) ) ( (lv_parameter_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )?
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:3: ( ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) ) | ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=34 && LA27_0<=35)) ) {
                alt27=1;
            }
            else if ( ((LA27_0>=36 && LA27_0<=37)) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:4: ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:4: ( () (otherlv_1= 'forall' | otherlv_2= '\\u2200' ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:5: () (otherlv_1= 'forall' | otherlv_2= '\\u2200' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1285:5: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1286:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getQuantifiedExpressionAccess().getForAllQuantifierAction_0_0_0_0(),
                                current);
                        

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1291:2: (otherlv_1= 'forall' | otherlv_2= '\\u2200' )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==34) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==35) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1291:4: otherlv_1= 'forall'
                            {
                            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleQuantifiedExpression2832); 

                                	newLeafNode(otherlv_1, grammarAccess.getQuantifiedExpressionAccess().getForallKeyword_0_0_0_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1296:7: otherlv_2= '\\u2200'
                            {
                            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleQuantifiedExpression2850); 

                                	newLeafNode(otherlv_2, grammarAccess.getQuantifiedExpressionAccess().getForAllKeyword_0_0_0_1_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1301:6: ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1301:6: ( () (otherlv_4= 'exists' | otherlv_5= '\\u2203' ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1301:7: () (otherlv_4= 'exists' | otherlv_5= '\\u2203' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1301:7: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1302:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getQuantifiedExpressionAccess().getExistsQuantifierAction_0_0_1_0(),
                                current);
                        

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1307:2: (otherlv_4= 'exists' | otherlv_5= '\\u2203' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==36) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==37) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1307:4: otherlv_4= 'exists'
                            {
                            otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleQuantifiedExpression2881); 

                                	newLeafNode(otherlv_4, grammarAccess.getQuantifiedExpressionAccess().getExistsKeyword_0_0_1_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1312:7: otherlv_5= '\\u2203'
                            {
                            otherlv_5=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleQuantifiedExpression2899); 

                                	newLeafNode(otherlv_5, grammarAccess.getQuantifiedExpressionAccess().getThereExistsKeyword_0_0_1_1_1());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1316:4: ( (lv_parameter_6_0= ruleParameter ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1317:1: (lv_parameter_6_0= ruleParameter )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1317:1: (lv_parameter_6_0= ruleParameter )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1318:3: lv_parameter_6_0= ruleParameter
            {
             
            	        newCompositeNode(grammarAccess.getQuantifiedExpressionAccess().getParameterParameterParserRuleCall_0_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleQuantifiedExpression2923);
            lv_parameter_6_0=ruleParameter();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQuantifiedExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"parameter",
                    		lv_parameter_6_0, 
                    		"Parameter");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1334:2: (otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==24) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1334:4: otherlv_7= ',' ( (lv_condition_8_0= ruleExpression ) )
                    {
                    otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleQuantifiedExpression2936); 

                        	newLeafNode(otherlv_7, grammarAccess.getQuantifiedExpressionAccess().getCommaKeyword_0_2_0());
                        
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1338:1: ( (lv_condition_8_0= ruleExpression ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1339:1: (lv_condition_8_0= ruleExpression )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1339:1: (lv_condition_8_0= ruleExpression )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1340:3: lv_condition_8_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getQuantifiedExpressionAccess().getConditionExpressionParserRuleCall_0_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleQuantifiedExpression2957);
                    lv_condition_8_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQuantifiedExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"condition",
                            		lv_condition_8_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1356:5: ( ( (lv_expression_9_0= ruleQuantifiedExpression ) ) | (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=34 && LA29_0<=37)) ) {
                alt29=1;
            }
            else if ( (LA29_0==38) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1356:6: ( (lv_expression_9_0= ruleQuantifiedExpression ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1356:6: ( (lv_expression_9_0= ruleQuantifiedExpression ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1357:1: (lv_expression_9_0= ruleQuantifiedExpression )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1357:1: (lv_expression_9_0= ruleQuantifiedExpression )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1358:3: lv_expression_9_0= ruleQuantifiedExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getQuantifiedExpressionAccess().getExpressionQuantifiedExpressionParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQuantifiedExpression_in_ruleQuantifiedExpression2982);
                    lv_expression_9_0=ruleQuantifiedExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQuantifiedExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_9_0, 
                            		"QuantifiedExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1375:6: (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1375:6: (otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1375:8: otherlv_10= ':' ( (lv_expression_11_0= ruleExpression ) )
                    {
                    otherlv_10=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleQuantifiedExpression3001); 

                        	newLeafNode(otherlv_10, grammarAccess.getQuantifiedExpressionAccess().getColonKeyword_1_1_0());
                        
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1379:1: ( (lv_expression_11_0= ruleExpression ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1380:1: (lv_expression_11_0= ruleExpression )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1380:1: (lv_expression_11_0= ruleExpression )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1381:3: lv_expression_11_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getQuantifiedExpressionAccess().getExpressionExpressionParserRuleCall_1_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleQuantifiedExpression3022);
                    lv_expression_11_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQuantifiedExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_11_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuantifiedExpression"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1405:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1406:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1407:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3060);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableDeclaration3070); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1414:1: ruleVariableDeclaration returns [EObject current=null] : ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' ( (lv_initialValue_4_0= ruleExpression ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_type_1_0 = null;

        EObject lv_initialValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1417:28: ( ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' ( (lv_initialValue_4_0= ruleExpression ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1418:1: ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' ( (lv_initialValue_4_0= ruleExpression ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1418:1: ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' ( (lv_initialValue_4_0= ruleExpression ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1418:2: () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':=' ( (lv_initialValue_4_0= ruleExpression ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1418:2: ()
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1419:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0(),
                        current);
                

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1424:2: ( (lv_type_1_0= ruleType ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1425:1: (lv_type_1_0= ruleType )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1425:1: (lv_type_1_0= ruleType )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1426:3: lv_type_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleVariableDeclaration3125);
            lv_type_1_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1442:2: ( (lv_name_2_0= RULE_ID ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1443:1: (lv_name_2_0= RULE_ID )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1443:1: (lv_name_2_0= RULE_ID )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1444:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableDeclaration3142); 

            			newLeafNode(lv_name_2_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleVariableDeclaration3159); 

                	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getColonEqualsSignKeyword_3());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1464:1: ( (lv_initialValue_4_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1465:1: (lv_initialValue_4_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1465:1: (lv_initialValue_4_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1466:3: lv_initialValue_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitialValueExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleVariableDeclaration3180);
            lv_initialValue_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"initialValue",
                    		lv_initialValue_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleAssignment"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1490:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1491:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1492:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignment_in_entryRuleAssignment3216);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignment3226); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1499:1: ruleAssignment returns [EObject current=null] : ( ( (lv_variable_0_0= ruleVariableReference ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_variable_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1502:28: ( ( ( (lv_variable_0_0= ruleVariableReference ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1503:1: ( ( (lv_variable_0_0= ruleVariableReference ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1503:1: ( ( (lv_variable_0_0= ruleVariableReference ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpression ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1503:2: ( (lv_variable_0_0= ruleVariableReference ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpression ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1503:2: ( (lv_variable_0_0= ruleVariableReference ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1504:1: (lv_variable_0_0= ruleVariableReference )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1504:1: (lv_variable_0_0= ruleVariableReference )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1505:3: lv_variable_0_0= ruleVariableReference
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getVariableVariableReferenceParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleVariableReference_in_ruleAssignment3272);
            lv_variable_0_0=ruleVariableReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"variable",
                    		lv_variable_0_0, 
                    		"VariableReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAssignment3284); 

                	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getColonEqualsSignKeyword_1());
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1525:1: ( (lv_value_2_0= ruleExpression ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1526:1: (lv_value_2_0= ruleExpression )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1526:1: (lv_value_2_0= ruleExpression )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1527:3: lv_value_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleAssignment3305);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleExpression"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1551:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1552:2: (iv_ruleExpression= ruleExpression EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1553:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression3341);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression3351); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1560:1: ruleExpression returns [EObject current=null] : (this_QuantifiedExpression_0= ruleQuantifiedExpression | this_BooleanOr_1= ruleBooleanOr ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_QuantifiedExpression_0 = null;

        EObject this_BooleanOr_1 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1563:28: ( (this_QuantifiedExpression_0= ruleQuantifiedExpression | this_BooleanOr_1= ruleBooleanOr ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1564:1: (this_QuantifiedExpression_0= ruleQuantifiedExpression | this_BooleanOr_1= ruleBooleanOr )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1564:1: (this_QuantifiedExpression_0= ruleQuantifiedExpression | this_BooleanOr_1= ruleBooleanOr )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=34 && LA30_0<=37)) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_BOOL)||LA30_0==23||(LA30_0>=53 && LA30_0<=54)||(LA30_0>=60 && LA30_0<=62)) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1565:5: this_QuantifiedExpression_0= ruleQuantifiedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getQuantifiedExpressionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleQuantifiedExpression_in_ruleExpression3398);
                    this_QuantifiedExpression_0=ruleQuantifiedExpression();

                    state._fsp--;

                     
                            current = this_QuantifiedExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1575:5: this_BooleanOr_1= ruleBooleanOr
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getBooleanOrParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanOr_in_ruleExpression3425);
                    this_BooleanOr_1=ruleBooleanOr();

                    state._fsp--;

                     
                            current = this_BooleanOr_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBooleanOr"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1591:1: entryRuleBooleanOr returns [EObject current=null] : iv_ruleBooleanOr= ruleBooleanOr EOF ;
    public final EObject entryRuleBooleanOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOr = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1592:2: (iv_ruleBooleanOr= ruleBooleanOr EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1593:2: iv_ruleBooleanOr= ruleBooleanOr EOF
            {
             newCompositeNode(grammarAccess.getBooleanOrRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanOr_in_entryRuleBooleanOr3460);
            iv_ruleBooleanOr=ruleBooleanOr();

            state._fsp--;

             current =iv_ruleBooleanOr; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanOr3470); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanOr"


    // $ANTLR start "ruleBooleanOr"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1600:1: ruleBooleanOr returns [EObject current=null] : (this_BooleanAnd_0= ruleBooleanAnd ( () (otherlv_2= '\\u2228' | otherlv_3= '||' ) ( (lv_right_4_0= ruleBooleanAnd ) ) )? ) ;
    public final EObject ruleBooleanOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_BooleanAnd_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1603:28: ( (this_BooleanAnd_0= ruleBooleanAnd ( () (otherlv_2= '\\u2228' | otherlv_3= '||' ) ( (lv_right_4_0= ruleBooleanAnd ) ) )? ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1604:1: (this_BooleanAnd_0= ruleBooleanAnd ( () (otherlv_2= '\\u2228' | otherlv_3= '||' ) ( (lv_right_4_0= ruleBooleanAnd ) ) )? )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1604:1: (this_BooleanAnd_0= ruleBooleanAnd ( () (otherlv_2= '\\u2228' | otherlv_3= '||' ) ( (lv_right_4_0= ruleBooleanAnd ) ) )? )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1605:5: this_BooleanAnd_0= ruleBooleanAnd ( () (otherlv_2= '\\u2228' | otherlv_3= '||' ) ( (lv_right_4_0= ruleBooleanAnd ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getBooleanOrAccess().getBooleanAndParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAnd_in_ruleBooleanOr3517);
            this_BooleanAnd_0=ruleBooleanAnd();

            state._fsp--;

             
                    current = this_BooleanAnd_0; 
                    afterParserOrEnumRuleCall();
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1613:1: ( () (otherlv_2= '\\u2228' | otherlv_3= '||' ) ( (lv_right_4_0= ruleBooleanAnd ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=40 && LA32_0<=41)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1613:2: () (otherlv_2= '\\u2228' | otherlv_3= '||' ) ( (lv_right_4_0= ruleBooleanAnd ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1613:2: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1614:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getBooleanOrAccess().getDisjunctionLeftAction_1_0(),
                                current);
                        

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1619:2: (otherlv_2= '\\u2228' | otherlv_3= '||' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==40) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==41) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1619:4: otherlv_2= '\\u2228'
                            {
                            otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleBooleanOr3539); 

                                	newLeafNode(otherlv_2, grammarAccess.getBooleanOrAccess().getLogicalOrKeyword_1_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1624:7: otherlv_3= '||'
                            {
                            otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleBooleanOr3557); 

                                	newLeafNode(otherlv_3, grammarAccess.getBooleanOrAccess().getVerticalLineVerticalLineKeyword_1_1_1());
                                

                            }
                            break;

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1628:2: ( (lv_right_4_0= ruleBooleanAnd ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1629:1: (lv_right_4_0= ruleBooleanAnd )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1629:1: (lv_right_4_0= ruleBooleanAnd )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1630:3: lv_right_4_0= ruleBooleanAnd
                    {
                     
                    	        newCompositeNode(grammarAccess.getBooleanOrAccess().getRightBooleanAndParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanAnd_in_ruleBooleanOr3579);
                    lv_right_4_0=ruleBooleanAnd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBooleanOrRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_4_0, 
                            		"BooleanAnd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanOr"


    // $ANTLR start "entryRuleBooleanAnd"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1654:1: entryRuleBooleanAnd returns [EObject current=null] : iv_ruleBooleanAnd= ruleBooleanAnd EOF ;
    public final EObject entryRuleBooleanAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAnd = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1655:2: (iv_ruleBooleanAnd= ruleBooleanAnd EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1656:2: iv_ruleBooleanAnd= ruleBooleanAnd EOF
            {
             newCompositeNode(grammarAccess.getBooleanAndRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAnd_in_entryRuleBooleanAnd3617);
            iv_ruleBooleanAnd=ruleBooleanAnd();

            state._fsp--;

             current =iv_ruleBooleanAnd; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAnd3627); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanAnd"


    // $ANTLR start "ruleBooleanAnd"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1663:1: ruleBooleanAnd returns [EObject current=null] : (this_EqualsComparison_0= ruleEqualsComparison ( () (otherlv_2= '\\u2227' | otherlv_3= '&&' ) ( (lv_right_4_0= ruleEqualsComparison ) ) )? ) ;
    public final EObject ruleBooleanAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject this_EqualsComparison_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1666:28: ( (this_EqualsComparison_0= ruleEqualsComparison ( () (otherlv_2= '\\u2227' | otherlv_3= '&&' ) ( (lv_right_4_0= ruleEqualsComparison ) ) )? ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1667:1: (this_EqualsComparison_0= ruleEqualsComparison ( () (otherlv_2= '\\u2227' | otherlv_3= '&&' ) ( (lv_right_4_0= ruleEqualsComparison ) ) )? )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1667:1: (this_EqualsComparison_0= ruleEqualsComparison ( () (otherlv_2= '\\u2227' | otherlv_3= '&&' ) ( (lv_right_4_0= ruleEqualsComparison ) ) )? )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1668:5: this_EqualsComparison_0= ruleEqualsComparison ( () (otherlv_2= '\\u2227' | otherlv_3= '&&' ) ( (lv_right_4_0= ruleEqualsComparison ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getBooleanAndAccess().getEqualsComparisonParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleEqualsComparison_in_ruleBooleanAnd3674);
            this_EqualsComparison_0=ruleEqualsComparison();

            state._fsp--;

             
                    current = this_EqualsComparison_0; 
                    afterParserOrEnumRuleCall();
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1676:1: ( () (otherlv_2= '\\u2227' | otherlv_3= '&&' ) ( (lv_right_4_0= ruleEqualsComparison ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=42 && LA34_0<=43)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1676:2: () (otherlv_2= '\\u2227' | otherlv_3= '&&' ) ( (lv_right_4_0= ruleEqualsComparison ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1676:2: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1677:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getBooleanAndAccess().getConjunctionLeftAction_1_0(),
                                current);
                        

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1682:2: (otherlv_2= '\\u2227' | otherlv_3= '&&' )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==42) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==43) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1682:4: otherlv_2= '\\u2227'
                            {
                            otherlv_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleBooleanAnd3696); 

                                	newLeafNode(otherlv_2, grammarAccess.getBooleanAndAccess().getLogicalAndKeyword_1_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1687:7: otherlv_3= '&&'
                            {
                            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleBooleanAnd3714); 

                                	newLeafNode(otherlv_3, grammarAccess.getBooleanAndAccess().getAmpersandAmpersandKeyword_1_1_1());
                                

                            }
                            break;

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1691:2: ( (lv_right_4_0= ruleEqualsComparison ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1692:1: (lv_right_4_0= ruleEqualsComparison )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1692:1: (lv_right_4_0= ruleEqualsComparison )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1693:3: lv_right_4_0= ruleEqualsComparison
                    {
                     
                    	        newCompositeNode(grammarAccess.getBooleanAndAccess().getRightEqualsComparisonParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEqualsComparison_in_ruleBooleanAnd3736);
                    lv_right_4_0=ruleEqualsComparison();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBooleanAndRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_4_0, 
                            		"EqualsComparison");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanAnd"


    // $ANTLR start "entryRuleEqualsComparison"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1717:1: entryRuleEqualsComparison returns [EObject current=null] : iv_ruleEqualsComparison= ruleEqualsComparison EOF ;
    public final EObject entryRuleEqualsComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualsComparison = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1718:2: (iv_ruleEqualsComparison= ruleEqualsComparison EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1719:2: iv_ruleEqualsComparison= ruleEqualsComparison EOF
            {
             newCompositeNode(grammarAccess.getEqualsComparisonRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEqualsComparison_in_entryRuleEqualsComparison3774);
            iv_ruleEqualsComparison=ruleEqualsComparison();

            state._fsp--;

             current =iv_ruleEqualsComparison; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEqualsComparison3784); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualsComparison"


    // $ANTLR start "ruleEqualsComparison"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1726:1: ruleEqualsComparison returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) ) ( (lv_right_6_0= ruleComparison ) ) )? ) ;
    public final EObject ruleEqualsComparison() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_6_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1729:28: ( (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) ) ( (lv_right_6_0= ruleComparison ) ) )? ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1730:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) ) ( (lv_right_6_0= ruleComparison ) ) )? )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1730:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) ) ( (lv_right_6_0= ruleComparison ) ) )? )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1731:5: this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) ) ( (lv_right_6_0= ruleComparison ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getEqualsComparisonAccess().getComparisonParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleComparison_in_ruleEqualsComparison3831);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    afterParserOrEnumRuleCall();
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1739:1: ( ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) ) ( (lv_right_6_0= ruleComparison ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=44 && LA37_0<=46)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1739:2: ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) ) ( (lv_right_6_0= ruleComparison ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1739:2: ( ( () otherlv_2= '=' ) | ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) ) )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==44) ) {
                        alt36=1;
                    }
                    else if ( ((LA36_0>=45 && LA36_0<=46)) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1739:3: ( () otherlv_2= '=' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1739:3: ( () otherlv_2= '=' )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1739:4: () otherlv_2= '='
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1739:4: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1740:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getEqualsComparisonAccess().getEqualLeftAction_1_0_0_0(),
                                        current);
                                

                            }

                            otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEqualsComparison3854); 

                                	newLeafNode(otherlv_2, grammarAccess.getEqualsComparisonAccess().getEqualsSignKeyword_1_0_0_1());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1750:6: ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1750:6: ( () (otherlv_4= '!=' | otherlv_5= '\\u2260' ) )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1750:7: () (otherlv_4= '!=' | otherlv_5= '\\u2260' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1750:7: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1751:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getEqualsComparisonAccess().getUnequalLeftAction_1_0_1_0(),
                                        current);
                                

                            }

                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1756:2: (otherlv_4= '!=' | otherlv_5= '\\u2260' )
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==45) ) {
                                alt35=1;
                            }
                            else if ( (LA35_0==46) ) {
                                alt35=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 35, 0, input);

                                throw nvae;
                            }
                            switch (alt35) {
                                case 1 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1756:4: otherlv_4= '!='
                                    {
                                    otherlv_4=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEqualsComparison3884); 

                                        	newLeafNode(otherlv_4, grammarAccess.getEqualsComparisonAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1_0());
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1761:7: otherlv_5= '\\u2260'
                                    {
                                    otherlv_5=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEqualsComparison3902); 

                                        	newLeafNode(otherlv_5, grammarAccess.getEqualsComparisonAccess().getNotEqualToKeyword_1_0_1_1_1());
                                        

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1765:4: ( (lv_right_6_0= ruleComparison ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1766:1: (lv_right_6_0= ruleComparison )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1766:1: (lv_right_6_0= ruleComparison )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1767:3: lv_right_6_0= ruleComparison
                    {
                     
                    	        newCompositeNode(grammarAccess.getEqualsComparisonAccess().getRightComparisonParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleComparison_in_ruleEqualsComparison3926);
                    lv_right_6_0=ruleComparison();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEqualsComparisonRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_6_0, 
                            		"Comparison");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualsComparison"


    // $ANTLR start "entryRuleComparison"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1791:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1792:2: (iv_ruleComparison= ruleComparison EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1793:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleComparison_in_entryRuleComparison3964);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComparison3974); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1800:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) ) ( (lv_right_11_0= ruleAddition ) ) )? ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject this_Addition_0 = null;

        EObject lv_right_11_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1803:28: ( (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) ) ( (lv_right_11_0= ruleAddition ) ) )? ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1804:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) ) ( (lv_right_11_0= ruleAddition ) ) )? )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1804:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) ) ( (lv_right_11_0= ruleAddition ) ) )? )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1805:5: this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) ) ( (lv_right_11_0= ruleAddition ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleAddition_in_ruleComparison4021);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    afterParserOrEnumRuleCall();
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1813:1: ( ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) ) ( (lv_right_11_0= ruleAddition ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=47 && LA41_0<=52)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1813:2: ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) ) ( (lv_right_11_0= ruleAddition ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1813:2: ( ( () otherlv_2= '<' ) | ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) ) | ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) ) | ( () otherlv_10= '>' ) )
                    int alt40=4;
                    switch ( input.LA(1) ) {
                    case 47:
                        {
                        alt40=1;
                        }
                        break;
                    case 48:
                    case 49:
                        {
                        alt40=2;
                        }
                        break;
                    case 50:
                    case 51:
                        {
                        alt40=3;
                        }
                        break;
                    case 52:
                        {
                        alt40=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }

                    switch (alt40) {
                        case 1 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1813:3: ( () otherlv_2= '<' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1813:3: ( () otherlv_2= '<' )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1813:4: () otherlv_2= '<'
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1813:4: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1814:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getComparisonAccess().getLessLeftAction_1_0_0_0(),
                                        current);
                                

                            }

                            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleComparison4044); 

                                	newLeafNode(otherlv_2, grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1824:6: ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1824:6: ( () (otherlv_4= '<=' | otherlv_5= '\\u2264' ) )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1824:7: () (otherlv_4= '<=' | otherlv_5= '\\u2264' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1824:7: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1825:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getComparisonAccess().getLessOrEqualLeftAction_1_0_1_0(),
                                        current);
                                

                            }

                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1830:2: (otherlv_4= '<=' | otherlv_5= '\\u2264' )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==48) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==49) ) {
                                alt38=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1830:4: otherlv_4= '<='
                                    {
                                    otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleComparison4074); 

                                        	newLeafNode(otherlv_4, grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1_0());
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1835:7: otherlv_5= '\\u2264'
                                    {
                                    otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleComparison4092); 

                                        	newLeafNode(otherlv_5, grammarAccess.getComparisonAccess().getLessThanOrEqualToKeyword_1_0_1_1_1());
                                        

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1840:6: ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1840:6: ( () (otherlv_7= '>=' | otherlv_8= '\\u2265' ) )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1840:7: () (otherlv_7= '>=' | otherlv_8= '\\u2265' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1840:7: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1841:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getComparisonAccess().getGreaterOrEqualLeftAction_1_0_2_0(),
                                        current);
                                

                            }

                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1846:2: (otherlv_7= '>=' | otherlv_8= '\\u2265' )
                            int alt39=2;
                            int LA39_0 = input.LA(1);

                            if ( (LA39_0==50) ) {
                                alt39=1;
                            }
                            else if ( (LA39_0==51) ) {
                                alt39=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 39, 0, input);

                                throw nvae;
                            }
                            switch (alt39) {
                                case 1 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1846:4: otherlv_7= '>='
                                    {
                                    otherlv_7=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleComparison4123); 

                                        	newLeafNode(otherlv_7, grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_2_1_0());
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1851:7: otherlv_8= '\\u2265'
                                    {
                                    otherlv_8=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleComparison4141); 

                                        	newLeafNode(otherlv_8, grammarAccess.getComparisonAccess().getGreaterThanOrEqualToKeyword_1_0_2_1_1());
                                        

                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 4 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1856:6: ( () otherlv_10= '>' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1856:6: ( () otherlv_10= '>' )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1856:7: () otherlv_10= '>'
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1856:7: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1857:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_3_0(),
                                        current);
                                

                            }

                            otherlv_10=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleComparison4171); 

                                	newLeafNode(otherlv_10, grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_3_1());
                                

                            }


                            }
                            break;

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1866:3: ( (lv_right_11_0= ruleAddition ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1867:1: (lv_right_11_0= ruleAddition )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1867:1: (lv_right_11_0= ruleAddition )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1868:3: lv_right_11_0= ruleAddition
                    {
                     
                    	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAddition_in_ruleComparison4194);
                    lv_right_11_0=ruleAddition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getComparisonRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_11_0, 
                            		"Addition");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1892:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1893:2: (iv_ruleAddition= ruleAddition EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1894:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAddition_in_entryRuleAddition4232);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAddition4242); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1901:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1904:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1905:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1905:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1906:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication_in_ruleAddition4289);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    afterParserOrEnumRuleCall();
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1914:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=53 && LA43_0<=54)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1914:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1914:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==53) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==54) ) {
            	        alt42=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1914:3: ( () otherlv_2= '+' )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1914:3: ( () otherlv_2= '+' )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1914:4: () otherlv_2= '+'
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1914:4: ()
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1915:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleAddition4312); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1925:6: ( () otherlv_4= '-' )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1925:6: ( () otherlv_4= '-' )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1925:7: () otherlv_4= '-'
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1925:7: ()
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1926:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getSubtractionLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleAddition4341); 

            	                	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1935:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1936:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1936:1: (lv_right_5_0= ruleMultiplication )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1937:3: lv_right_5_0= ruleMultiplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMultiplication_in_ruleAddition4364);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_5_0, 
            	            		"Multiplication");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1961:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1962:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1963:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiplication_in_entryRuleMultiplication4402);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplication4412); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1970:1: ruleMultiplication returns [EObject current=null] : (this_UnaryOperation_0= ruleUnaryOperation ( ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) ) ( (lv_right_9_0= ruleUnaryOperation ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_UnaryOperation_0 = null;

        EObject lv_right_9_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1973:28: ( (this_UnaryOperation_0= ruleUnaryOperation ( ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) ) ( (lv_right_9_0= ruleUnaryOperation ) ) )* ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1974:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) ) ( (lv_right_9_0= ruleUnaryOperation ) ) )* )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1974:1: (this_UnaryOperation_0= ruleUnaryOperation ( ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) ) ( (lv_right_9_0= ruleUnaryOperation ) ) )* )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1975:5: this_UnaryOperation_0= ruleUnaryOperation ( ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) ) ( (lv_right_9_0= ruleUnaryOperation ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryOperationParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperation_in_ruleMultiplication4459);
            this_UnaryOperation_0=ruleUnaryOperation();

            state._fsp--;

             
                    current = this_UnaryOperation_0; 
                    afterParserOrEnumRuleCall();
                
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1983:1: ( ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) ) ( (lv_right_9_0= ruleUnaryOperation ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=55 && LA47_0<=59)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1983:2: ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) ) ( (lv_right_9_0= ruleUnaryOperation ) )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1983:2: ( ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) ) | ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) ) | ( () otherlv_8= '%' ) )
            	    int alt46=3;
            	    switch ( input.LA(1) ) {
            	    case 55:
            	    case 56:
            	        {
            	        alt46=1;
            	        }
            	        break;
            	    case 57:
            	    case 58:
            	        {
            	        alt46=2;
            	        }
            	        break;
            	    case 59:
            	        {
            	        alt46=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt46) {
            	        case 1 :
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1983:3: ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1983:3: ( () (otherlv_2= '*' | otherlv_3= '\\u00B7' ) )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1983:4: () (otherlv_2= '*' | otherlv_3= '\\u00B7' )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1983:4: ()
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1984:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1989:2: (otherlv_2= '*' | otherlv_3= '\\u00B7' )
            	            int alt44=2;
            	            int LA44_0 = input.LA(1);

            	            if ( (LA44_0==55) ) {
            	                alt44=1;
            	            }
            	            else if ( (LA44_0==56) ) {
            	                alt44=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 44, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt44) {
            	                case 1 :
            	                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1989:4: otherlv_2= '*'
            	                    {
            	                    otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMultiplication4483); 

            	                        	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1_0());
            	                        

            	                    }
            	                    break;
            	                case 2 :
            	                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1994:7: otherlv_3= '\\u00B7'
            	                    {
            	                    otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMultiplication4501); 

            	                        	newLeafNode(otherlv_3, grammarAccess.getMultiplicationAccess().getMiddleDotKeyword_1_0_0_1_1());
            	                        

            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1999:6: ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1999:6: ( () (otherlv_5= '/' | otherlv_6= '\\u00F7' ) )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1999:7: () (otherlv_5= '/' | otherlv_6= '\\u00F7' )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1999:7: ()
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2000:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getDivisionLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2005:2: (otherlv_5= '/' | otherlv_6= '\\u00F7' )
            	            int alt45=2;
            	            int LA45_0 = input.LA(1);

            	            if ( (LA45_0==57) ) {
            	                alt45=1;
            	            }
            	            else if ( (LA45_0==58) ) {
            	                alt45=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 45, 0, input);

            	                throw nvae;
            	            }
            	            switch (alt45) {
            	                case 1 :
            	                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2005:4: otherlv_5= '/'
            	                    {
            	                    otherlv_5=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleMultiplication4532); 

            	                        	newLeafNode(otherlv_5, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1_0());
            	                        

            	                    }
            	                    break;
            	                case 2 :
            	                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2010:7: otherlv_6= '\\u00F7'
            	                    {
            	                    otherlv_6=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleMultiplication4550); 

            	                        	newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getDivisionSignKeyword_1_0_1_1_1());
            	                        

            	                    }
            	                    break;

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2015:6: ( () otherlv_8= '%' )
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2015:6: ( () otherlv_8= '%' )
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2015:7: () otherlv_8= '%'
            	            {
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2015:7: ()
            	            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2016:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getModulusLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_8=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleMultiplication4580); 

            	                	newLeafNode(otherlv_8, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2025:3: ( (lv_right_9_0= ruleUnaryOperation ) )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2026:1: (lv_right_9_0= ruleUnaryOperation )
            	    {
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2026:1: (lv_right_9_0= ruleUnaryOperation )
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2027:3: lv_right_9_0= ruleUnaryOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryOperationParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperation_in_ruleMultiplication4603);
            	    lv_right_9_0=ruleUnaryOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_9_0, 
            	            		"UnaryOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnaryOperation"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2051:1: entryRuleUnaryOperation returns [EObject current=null] : iv_ruleUnaryOperation= ruleUnaryOperation EOF ;
    public final EObject entryRuleUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperation = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2052:2: (iv_ruleUnaryOperation= ruleUnaryOperation EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2053:2: iv_ruleUnaryOperation= ruleUnaryOperation EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation4641);
            iv_ruleUnaryOperation=ruleUnaryOperation();

            state._fsp--;

             current =iv_ruleUnaryOperation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperation4651); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperation"


    // $ANTLR start "ruleUnaryOperation"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2060:1: ruleUnaryOperation returns [EObject current=null] : (this_Atomic_0= ruleAtomic | ( ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) ) ( (lv_operand_8_0= ruleAtomic ) ) ) | ( () otherlv_10= 'length' otherlv_11= '(' ( (lv_operand_12_0= ruleAtomic ) ) otherlv_13= ')' ) ) ;
    public final EObject ruleUnaryOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject this_Atomic_0 = null;

        EObject lv_operand_8_0 = null;

        EObject lv_operand_12_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2063:28: ( (this_Atomic_0= ruleAtomic | ( ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) ) ( (lv_operand_8_0= ruleAtomic ) ) ) | ( () otherlv_10= 'length' otherlv_11= '(' ( (lv_operand_12_0= ruleAtomic ) ) otherlv_13= ')' ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2064:1: (this_Atomic_0= ruleAtomic | ( ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) ) ( (lv_operand_8_0= ruleAtomic ) ) ) | ( () otherlv_10= 'length' otherlv_11= '(' ( (lv_operand_12_0= ruleAtomic ) ) otherlv_13= ')' ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2064:1: (this_Atomic_0= ruleAtomic | ( ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) ) ( (lv_operand_8_0= ruleAtomic ) ) ) | ( () otherlv_10= 'length' otherlv_11= '(' ( (lv_operand_12_0= ruleAtomic ) ) otherlv_13= ')' ) )
            int alt50=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_NUMBER:
            case RULE_BOOL:
            case 23:
                {
                alt50=1;
                }
                break;
            case 53:
            case 54:
            case 60:
            case 61:
                {
                alt50=2;
                }
                break;
            case 62:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2065:5: this_Atomic_0= ruleAtomic
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryOperationAccess().getAtomicParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAtomic_in_ruleUnaryOperation4698);
                    this_Atomic_0=ruleAtomic();

                    state._fsp--;

                     
                            current = this_Atomic_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:6: ( ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) ) ( (lv_operand_8_0= ruleAtomic ) ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:6: ( ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) ) ( (lv_operand_8_0= ruleAtomic ) ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:7: ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) ) ( (lv_operand_8_0= ruleAtomic ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:7: ( ( () otherlv_2= '-' ) | ( () otherlv_4= '+' ) | ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) ) )
                    int alt49=3;
                    switch ( input.LA(1) ) {
                    case 54:
                        {
                        alt49=1;
                        }
                        break;
                    case 53:
                        {
                        alt49=2;
                        }
                        break;
                    case 60:
                    case 61:
                        {
                        alt49=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }

                    switch (alt49) {
                        case 1 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:8: ( () otherlv_2= '-' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:8: ( () otherlv_2= '-' )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:9: () otherlv_2= '-'
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2074:9: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2075:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryOperationAccess().getPlusAction_1_0_0_0(),
                                        current);
                                

                            }

                            otherlv_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleUnaryOperation4727); 

                                	newLeafNode(otherlv_2, grammarAccess.getUnaryOperationAccess().getHyphenMinusKeyword_1_0_0_1());
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2085:6: ( () otherlv_4= '+' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2085:6: ( () otherlv_4= '+' )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2085:7: () otherlv_4= '+'
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2085:7: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2086:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryOperationAccess().getMinusAction_1_0_1_0(),
                                        current);
                                

                            }

                            otherlv_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleUnaryOperation4756); 

                                	newLeafNode(otherlv_4, grammarAccess.getUnaryOperationAccess().getPlusSignKeyword_1_0_1_1());
                                

                            }


                            }
                            break;
                        case 3 :
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2096:6: ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2096:6: ( () (otherlv_6= '\\u00AC' | otherlv_7= '!' ) )
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2096:7: () (otherlv_6= '\\u00AC' | otherlv_7= '!' )
                            {
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2096:7: ()
                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2097:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryOperationAccess().getNegationAction_1_0_2_0(),
                                        current);
                                

                            }

                            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2102:2: (otherlv_6= '\\u00AC' | otherlv_7= '!' )
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==60) ) {
                                alt48=1;
                            }
                            else if ( (LA48_0==61) ) {
                                alt48=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 48, 0, input);

                                throw nvae;
                            }
                            switch (alt48) {
                                case 1 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2102:4: otherlv_6= '\\u00AC'
                                    {
                                    otherlv_6=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleUnaryOperation4786); 

                                        	newLeafNode(otherlv_6, grammarAccess.getUnaryOperationAccess().getNotSignKeyword_1_0_2_1_0());
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2107:7: otherlv_7= '!'
                                    {
                                    otherlv_7=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleUnaryOperation4804); 

                                        	newLeafNode(otherlv_7, grammarAccess.getUnaryOperationAccess().getExclamationMarkKeyword_1_0_2_1_1());
                                        

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2111:4: ( (lv_operand_8_0= ruleAtomic ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2112:1: (lv_operand_8_0= ruleAtomic )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2112:1: (lv_operand_8_0= ruleAtomic )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2113:3: lv_operand_8_0= ruleAtomic
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperandAtomicParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAtomic_in_ruleUnaryOperation4828);
                    lv_operand_8_0=ruleAtomic();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"operand",
                            		lv_operand_8_0, 
                            		"Atomic");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2130:6: ( () otherlv_10= 'length' otherlv_11= '(' ( (lv_operand_12_0= ruleAtomic ) ) otherlv_13= ')' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2130:6: ( () otherlv_10= 'length' otherlv_11= '(' ( (lv_operand_12_0= ruleAtomic ) ) otherlv_13= ')' )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2130:7: () otherlv_10= 'length' otherlv_11= '(' ( (lv_operand_12_0= ruleAtomic ) ) otherlv_13= ')'
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2130:7: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2131:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getUnaryOperationAccess().getArrayLengthAction_2_0(),
                                current);
                        

                    }

                    otherlv_10=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleUnaryOperation4857); 

                        	newLeafNode(otherlv_10, grammarAccess.getUnaryOperationAccess().getLengthKeyword_2_1());
                        
                    otherlv_11=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleUnaryOperation4869); 

                        	newLeafNode(otherlv_11, grammarAccess.getUnaryOperationAccess().getLeftParenthesisKeyword_2_2());
                        
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2144:1: ( (lv_operand_12_0= ruleAtomic ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2145:1: (lv_operand_12_0= ruleAtomic )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2145:1: (lv_operand_12_0= ruleAtomic )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2146:3: lv_operand_12_0= ruleAtomic
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryOperationAccess().getOperandAtomicParserRuleCall_2_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAtomic_in_ruleUnaryOperation4890);
                    lv_operand_12_0=ruleAtomic();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"operand",
                            		lv_operand_12_0, 
                            		"Atomic");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_13=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleUnaryOperation4902); 

                        	newLeafNode(otherlv_13, grammarAccess.getUnaryOperationAccess().getRightParenthesisKeyword_2_4());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperation"


    // $ANTLR start "entryRuleAtomic"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2174:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2175:2: (iv_ruleAtomic= ruleAtomic EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2176:2: iv_ruleAtomic= ruleAtomic EOF
            {
             newCompositeNode(grammarAccess.getAtomicRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAtomic_in_entryRuleAtomic4939);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;

             current =iv_ruleAtomic; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtomic4949); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2183:1: ruleAtomic returns [EObject current=null] : (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_NUMBER ) ) ) | ( () ( (lv_value_4_0= RULE_BOOL ) ) ) | this_VariableReference_5= ruleVariableReference | (otherlv_6= '(' this_Expression_7= ruleExpression otherlv_8= ')' ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;
        Token lv_value_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_FunctionCall_0 = null;

        EObject this_VariableReference_5 = null;

        EObject this_Expression_7 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2186:28: ( (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_NUMBER ) ) ) | ( () ( (lv_value_4_0= RULE_BOOL ) ) ) | this_VariableReference_5= ruleVariableReference | (otherlv_6= '(' this_Expression_7= ruleExpression otherlv_8= ')' ) ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2187:1: (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_NUMBER ) ) ) | ( () ( (lv_value_4_0= RULE_BOOL ) ) ) | this_VariableReference_5= ruleVariableReference | (otherlv_6= '(' this_Expression_7= ruleExpression otherlv_8= ')' ) )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2187:1: (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_NUMBER ) ) ) | ( () ( (lv_value_4_0= RULE_BOOL ) ) ) | this_VariableReference_5= ruleVariableReference | (otherlv_6= '(' this_Expression_7= ruleExpression otherlv_8= ')' ) )
            int alt51=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==EOF||LA51_1==RULE_NL||LA51_1==15||LA51_1==19||(LA51_1>=24 && LA51_1<=25)||(LA51_1>=30 && LA51_1<=31)||(LA51_1>=34 && LA51_1<=38)||(LA51_1>=40 && LA51_1<=59)) ) {
                    alt51=4;
                }
                else if ( (LA51_1==23) ) {
                    alt51=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_NUMBER:
                {
                alt51=2;
                }
                break;
            case RULE_BOOL:
                {
                alt51=3;
                }
                break;
            case 23:
                {
                alt51=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2188:5: this_FunctionCall_0= ruleFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getAtomicAccess().getFunctionCallParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleFunctionCall_in_ruleAtomic4996);
                    this_FunctionCall_0=ruleFunctionCall();

                    state._fsp--;

                     
                            current = this_FunctionCall_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2197:6: ( () ( (lv_value_2_0= RULE_NUMBER ) ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2197:6: ( () ( (lv_value_2_0= RULE_NUMBER ) ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2197:7: () ( (lv_value_2_0= RULE_NUMBER ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2197:7: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2198:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getAtomicAccess().getIntegerLiteralAction_1_0(),
                                current);
                        

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2203:2: ( (lv_value_2_0= RULE_NUMBER ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2204:1: (lv_value_2_0= RULE_NUMBER )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2204:1: (lv_value_2_0= RULE_NUMBER )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2205:3: lv_value_2_0= RULE_NUMBER
                    {
                    lv_value_2_0=(Token)match(input,RULE_NUMBER,FollowSets000.FOLLOW_RULE_NUMBER_in_ruleAtomic5028); 

                    			newLeafNode(lv_value_2_0, grammarAccess.getAtomicAccess().getValueNUMBERTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAtomicRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_2_0, 
                            		"NUMBER");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2222:6: ( () ( (lv_value_4_0= RULE_BOOL ) ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2222:6: ( () ( (lv_value_4_0= RULE_BOOL ) ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2222:7: () ( (lv_value_4_0= RULE_BOOL ) )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2222:7: ()
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2223:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getAtomicAccess().getBooleanLiteralAction_2_0(),
                                current);
                        

                    }

                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2228:2: ( (lv_value_4_0= RULE_BOOL ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2229:1: (lv_value_4_0= RULE_BOOL )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2229:1: (lv_value_4_0= RULE_BOOL )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2230:3: lv_value_4_0= RULE_BOOL
                    {
                    lv_value_4_0=(Token)match(input,RULE_BOOL,FollowSets000.FOLLOW_RULE_BOOL_in_ruleAtomic5067); 

                    			newLeafNode(lv_value_4_0, grammarAccess.getAtomicAccess().getValueBOOLTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAtomicRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"BOOL");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2248:5: this_VariableReference_5= ruleVariableReference
                    {
                     
                            newCompositeNode(grammarAccess.getAtomicAccess().getVariableReferenceParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleVariableReference_in_ruleAtomic5101);
                    this_VariableReference_5=ruleVariableReference();

                    state._fsp--;

                     
                            current = this_VariableReference_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2257:6: (otherlv_6= '(' this_Expression_7= ruleExpression otherlv_8= ')' )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2257:6: (otherlv_6= '(' this_Expression_7= ruleExpression otherlv_8= ')' )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2257:8: otherlv_6= '(' this_Expression_7= ruleExpression otherlv_8= ')'
                    {
                    otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAtomic5119); 

                        	newLeafNode(otherlv_6, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_4_0());
                        
                     
                            newCompositeNode(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_4_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleAtomic5141);
                    this_Expression_7=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_7; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleAtomic5152); 

                        	newLeafNode(otherlv_8, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_4_2());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "entryRuleVariableReference"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2282:1: entryRuleVariableReference returns [EObject current=null] : iv_ruleVariableReference= ruleVariableReference EOF ;
    public final EObject entryRuleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReference = null;


        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2283:2: (iv_ruleVariableReference= ruleVariableReference EOF )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2284:2: iv_ruleVariableReference= ruleVariableReference EOF
            {
             newCompositeNode(grammarAccess.getVariableReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariableReference_in_entryRuleVariableReference5189);
            iv_ruleVariableReference=ruleVariableReference();

            state._fsp--;

             current =iv_ruleVariableReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariableReference5199); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableReference"


    // $ANTLR start "ruleVariableReference"
    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2291:1: ruleVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_index_3_0 = null;


         enterRule(); 
            
        try {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2294:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2295:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2295:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2295:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )?
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2295:2: ()
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2296:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableReferenceAccess().getVariableReferenceAction_0(),
                        current);
                

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2301:2: ( (otherlv_1= RULE_ID ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2302:1: (otherlv_1= RULE_ID )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2302:1: (otherlv_1= RULE_ID )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2303:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableReferenceRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVariableReference5253); 

            		newLeafNode(otherlv_1, grammarAccess.getVariableReferenceAccess().getVariableVariableDeclarationCrossReference_1_0()); 
            	

            }


            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2314:2: (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==30) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2314:4: otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVariableReference5266); 

                        	newLeafNode(otherlv_2, grammarAccess.getVariableReferenceAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2318:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2319:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2319:1: (lv_index_3_0= ruleExpression )
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2320:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableReferenceAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleVariableReference5287);
                    lv_index_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_3_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVariableReference5299); 

                        	newLeafNode(otherlv_4, grammarAccess.getVariableReferenceAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableReference"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleProgram131 = new BitSet(new long[]{0x000000033056C030L});
        public static final BitSet FOLLOW_ruleAxiom_in_ruleProgram155 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFunctionDeclaration_in_ruleProgram182 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleProgram195 = new BitSet(new long[]{0x000000033056C030L});
        public static final BitSet FOLLOW_ruleBlock_in_ruleProgram219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAxiom_in_entryRuleAxiom255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAxiom265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAxiom302 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleAxiom323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock359 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBlock369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleBlock425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleBlock437 = new BitSet(new long[]{0x0000000330168032L});
        public static final BitSet FOLLOW_ruleBracedBlock_in_entryRuleBracedBlock476 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBracedBlock486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleBracedBlock532 = new BitSet(new long[]{0x0000000330178030L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleBracedBlock544 = new BitSet(new long[]{0x0000000330178030L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleBracedBlock567 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleBracedBlock579 = new BitSet(new long[]{0x0000000330178030L});
        public static final BitSet FOLLOW_16_in_ruleBracedBlock594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement630 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStatement640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStatement687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_ruleStatement714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBracedBlock_in_ruleStatement741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_ruleStatement768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement884 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleReturnStatement931 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement988 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleWhileStatement1035 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleWhileStatement1056 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleInvariant_in_ruleWhileStatement1077 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_ruleBracedBlock_in_ruleWhileStatement1099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvariant_in_entryRuleInvariant1135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvariant1145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleInvariant1182 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleInvariant1203 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleInvariant1215 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement1252 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement1262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleIfStatement1299 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleIfStatement1320 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleBracedBlock_in_ruleIfStatement1341 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleIfStatement1354 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleBracedBlock_in_ruleIfStatement1375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionDeclaration_in_entryRuleFunctionDeclaration1413 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDeclaration1423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleFunctionDeclaration1460 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_ruleType_in_ruleFunctionDeclaration1481 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionDeclaration1498 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleFunctionDeclaration1515 = new BitSet(new long[]{0x0000000032000000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleFunctionDeclaration1537 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleFunctionDeclaration1550 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleFunctionDeclaration1571 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_25_in_ruleFunctionDeclaration1587 = new BitSet(new long[]{0x000000000C008010L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleFunctionDeclaration1599 = new BitSet(new long[]{0x000000000C008010L});
        public static final BitSet FOLLOW_ruleRequire_in_ruleFunctionDeclaration1622 = new BitSet(new long[]{0x000000000C008000L});
        public static final BitSet FOLLOW_ruleEnsure_in_ruleFunctionDeclaration1649 = new BitSet(new long[]{0x000000000C008000L});
        public static final BitSet FOLLOW_ruleBracedBlock_in_ruleFunctionDeclaration1672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRequire_in_entryRuleRequire1708 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRequire1718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleRequire1755 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRequire1776 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleRequire1788 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleEnsure_in_entryRuleEnsure1825 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnsure1835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleEnsure1872 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleEnsure1893 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_NL_in_ruleEnsure1905 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter1952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleParameter2007 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter2024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType2065 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType2075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveType_in_ruleType2122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleArrayType_in_ruleType2149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType2184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveType2194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rulePrimitiveType2241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rulePrimitiveType2270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleArrayType_in_entryRuleArrayType2307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleArrayType2317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveType_in_ruleArrayType2372 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleArrayType2384 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleArrayType2405 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleArrayType2417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall2453 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall2463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall2508 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleFunctionCall2520 = new BitSet(new long[]{0x7060003C038000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall2541 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleFunctionCall2555 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall2576 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_25_in_ruleFunctionCall2590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation2626 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation2636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleAnnotation2684 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_33_in_ruleAnnotation2713 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleAnnotation2736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantifiedExpression_in_entryRuleQuantifiedExpression2772 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuantifiedExpression2782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleQuantifiedExpression2832 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_35_in_ruleQuantifiedExpression2850 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_36_in_ruleQuantifiedExpression2881 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_37_in_ruleQuantifiedExpression2899 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleQuantifiedExpression2923 = new BitSet(new long[]{0x0000007C01000000L});
        public static final BitSet FOLLOW_24_in_ruleQuantifiedExpression2936 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleQuantifiedExpression2957 = new BitSet(new long[]{0x0000007C00000000L});
        public static final BitSet FOLLOW_ruleQuantifiedExpression_in_ruleQuantifiedExpression2982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleQuantifiedExpression3001 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleQuantifiedExpression3022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3060 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3125 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration3142 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleVariableDeclaration3159 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableReference_in_ruleAssignment3272 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleAssignment3284 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment3305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression3341 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression3351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuantifiedExpression_in_ruleExpression3398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanOr_in_ruleExpression3425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanOr_in_entryRuleBooleanOr3460 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanOr3470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAnd_in_ruleBooleanOr3517 = new BitSet(new long[]{0x0000030000000002L});
        public static final BitSet FOLLOW_40_in_ruleBooleanOr3539 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_41_in_ruleBooleanOr3557 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleBooleanAnd_in_ruleBooleanOr3579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAnd_in_entryRuleBooleanAnd3617 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAnd3627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEqualsComparison_in_ruleBooleanAnd3674 = new BitSet(new long[]{0x00000C0000000002L});
        public static final BitSet FOLLOW_42_in_ruleBooleanAnd3696 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_43_in_ruleBooleanAnd3714 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleEqualsComparison_in_ruleBooleanAnd3736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEqualsComparison_in_entryRuleEqualsComparison3774 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEqualsComparison3784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComparison_in_ruleEqualsComparison3831 = new BitSet(new long[]{0x0000700000000002L});
        public static final BitSet FOLLOW_44_in_ruleEqualsComparison3854 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_45_in_ruleEqualsComparison3884 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_46_in_ruleEqualsComparison3902 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleComparison_in_ruleEqualsComparison3926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison3964 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComparison3974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition_in_ruleComparison4021 = new BitSet(new long[]{0x001F800000000002L});
        public static final BitSet FOLLOW_47_in_ruleComparison4044 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_48_in_ruleComparison4074 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_49_in_ruleComparison4092 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_50_in_ruleComparison4123 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_51_in_ruleComparison4141 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_52_in_ruleComparison4171 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleAddition_in_ruleComparison4194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition4232 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAddition4242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition4289 = new BitSet(new long[]{0x0060000000000002L});
        public static final BitSet FOLLOW_53_in_ruleAddition4312 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_54_in_ruleAddition4341 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition4364 = new BitSet(new long[]{0x0060000000000002L});
        public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication4402 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication4412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleMultiplication4459 = new BitSet(new long[]{0x0F80000000000002L});
        public static final BitSet FOLLOW_55_in_ruleMultiplication4483 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_56_in_ruleMultiplication4501 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_57_in_ruleMultiplication4532 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_58_in_ruleMultiplication4550 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_59_in_ruleMultiplication4580 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleUnaryOperation_in_ruleMultiplication4603 = new BitSet(new long[]{0x0F80000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperation_in_entryRuleUnaryOperation4641 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperation4651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomic_in_ruleUnaryOperation4698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleUnaryOperation4727 = new BitSet(new long[]{0x00000000008000E0L});
        public static final BitSet FOLLOW_53_in_ruleUnaryOperation4756 = new BitSet(new long[]{0x00000000008000E0L});
        public static final BitSet FOLLOW_60_in_ruleUnaryOperation4786 = new BitSet(new long[]{0x00000000008000E0L});
        public static final BitSet FOLLOW_61_in_ruleUnaryOperation4804 = new BitSet(new long[]{0x00000000008000E0L});
        public static final BitSet FOLLOW_ruleAtomic_in_ruleUnaryOperation4828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleUnaryOperation4857 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleUnaryOperation4869 = new BitSet(new long[]{0x00000000008000E0L});
        public static final BitSet FOLLOW_ruleAtomic_in_ruleUnaryOperation4890 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleUnaryOperation4902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic4939 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtomic4949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFunctionCall_in_ruleAtomic4996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NUMBER_in_ruleAtomic5028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_BOOL_in_ruleAtomic5067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableReference_in_ruleAtomic5101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleAtomic5119 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleAtomic5141 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleAtomic5152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableReference_in_entryRuleVariableReference5189 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariableReference5199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVariableReference5253 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleVariableReference5266 = new BitSet(new long[]{0x7060003C008000E0L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleVariableReference5287 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleVariableReference5299 = new BitSet(new long[]{0x0000000000000002L});
    }


}