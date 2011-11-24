package org.xtext.example.mydsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'{'", "'}'", "'return'", "'while'", "'if'", "'else'", "'function'", "'('", "','", "')'", "'int'", "'bool'", "'['", "']'", "'TODO5'", "':='", "'<'", "'<='", "'\\u2264'", "'='", "'>='", "'\\u2265'", "'>'", "'+'", "'*'", "'false'", "'true'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_NL=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=7;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;
     	
        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:76:1: ruleModel returns [EObject current=null] : ( ( ( (lv_statements_0_0= ruleStatement ) ) | ( (lv_functions_1_0= ruleFunctionDeclaration ) ) )? (this_NL_2= RULE_NL ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token this_NL_2=null;
        EObject lv_statements_0_0 = null;

        EObject lv_functions_1_0 = null;

        EObject lv_statements_3_0 = null;

        EObject lv_functions_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:79:28: ( ( ( ( (lv_statements_0_0= ruleStatement ) ) | ( (lv_functions_1_0= ruleFunctionDeclaration ) ) )? (this_NL_2= RULE_NL ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) ) )* ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:1: ( ( ( (lv_statements_0_0= ruleStatement ) ) | ( (lv_functions_1_0= ruleFunctionDeclaration ) ) )? (this_NL_2= RULE_NL ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) ) )* )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:1: ( ( ( (lv_statements_0_0= ruleStatement ) ) | ( (lv_functions_1_0= ruleFunctionDeclaration ) ) )? (this_NL_2= RULE_NL ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:2: ( ( (lv_statements_0_0= ruleStatement ) ) | ( (lv_functions_1_0= ruleFunctionDeclaration ) ) )? (this_NL_2= RULE_NL ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) ) )*
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:2: ( ( (lv_statements_0_0= ruleStatement ) ) | ( (lv_functions_1_0= ruleFunctionDeclaration ) ) )?
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID||LA1_0==12||(LA1_0>=14 && LA1_0<=16)||(LA1_0>=22 && LA1_0<=23)||LA1_0==26) ) {
                alt1=1;
            }
            else if ( (LA1_0==18) ) {
                alt1=2;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:3: ( (lv_statements_0_0= ruleStatement ) )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:80:3: ( (lv_statements_0_0= ruleStatement ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:1: (lv_statements_0_0= ruleStatement )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:81:1: (lv_statements_0_0= ruleStatement )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:82:3: lv_statements_0_0= ruleStatement
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStatement_in_ruleModel132);
                    lv_statements_0_0=ruleStatement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		add(
                           			current, 
                           			"statements",
                            		lv_statements_0_0, 
                            		"Statement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:99:6: ( (lv_functions_1_0= ruleFunctionDeclaration ) )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:99:6: ( (lv_functions_1_0= ruleFunctionDeclaration ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:100:1: (lv_functions_1_0= ruleFunctionDeclaration )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:100:1: (lv_functions_1_0= ruleFunctionDeclaration )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:101:3: lv_functions_1_0= ruleFunctionDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getFunctionsFunctionDeclarationParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFunctionDeclaration_in_ruleModel159);
                    lv_functions_1_0=ruleFunctionDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		add(
                           			current, 
                           			"functions",
                            		lv_functions_1_0, 
                            		"FunctionDeclaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:117:4: (this_NL_2= RULE_NL ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_NL) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:117:5: this_NL_2= RULE_NL ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) )
            	    {
            	    this_NL_2=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleModel173); 
            	     
            	        newLeafNode(this_NL_2, grammarAccess.getModelAccess().getNLTerminalRuleCall_1_0()); 
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:121:1: ( ( (lv_statements_3_0= ruleStatement ) ) | ( (lv_functions_4_0= ruleFunctionDeclaration ) ) )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==RULE_ID||LA2_0==12||(LA2_0>=14 && LA2_0<=16)||(LA2_0>=22 && LA2_0<=23)||LA2_0==26) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==18) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:121:2: ( (lv_statements_3_0= ruleStatement ) )
            	            {
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:121:2: ( (lv_statements_3_0= ruleStatement ) )
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:122:1: (lv_statements_3_0= ruleStatement )
            	            {
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:122:1: (lv_statements_3_0= ruleStatement )
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:123:3: lv_statements_3_0= ruleStatement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_1_1_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleStatement_in_ruleModel194);
            	            lv_statements_3_0=ruleStatement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"statements",
            	                    		lv_statements_3_0, 
            	                    		"Statement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:140:6: ( (lv_functions_4_0= ruleFunctionDeclaration ) )
            	            {
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:140:6: ( (lv_functions_4_0= ruleFunctionDeclaration ) )
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:141:1: (lv_functions_4_0= ruleFunctionDeclaration )
            	            {
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:141:1: (lv_functions_4_0= ruleFunctionDeclaration )
            	            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:142:3: lv_functions_4_0= ruleFunctionDeclaration
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getModelAccess().getFunctionsFunctionDeclarationParserRuleCall_1_1_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleFunctionDeclaration_in_ruleModel221);
            	            lv_functions_4_0=ruleFunctionDeclaration();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"functions",
            	                    		lv_functions_4_0, 
            	                    		"FunctionDeclaration");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleBlock"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:166:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:167:2: (iv_ruleBlock= ruleBlock EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:168:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock260);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock270); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:175:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )? (this_NL_3= RULE_NL ( (lv_statements_4_0= ruleStatement ) ) )* (this_NL_5= RULE_NL )? otherlv_6= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_NL_3=null;
        Token this_NL_5=null;
        Token otherlv_6=null;
        EObject lv_statements_2_0 = null;

        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:178:28: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )? (this_NL_3= RULE_NL ( (lv_statements_4_0= ruleStatement ) ) )* (this_NL_5= RULE_NL )? otherlv_6= '}' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:179:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )? (this_NL_3= RULE_NL ( (lv_statements_4_0= ruleStatement ) ) )* (this_NL_5= RULE_NL )? otherlv_6= '}' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:179:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )? (this_NL_3= RULE_NL ( (lv_statements_4_0= ruleStatement ) ) )* (this_NL_5= RULE_NL )? otherlv_6= '}' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:179:2: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )? (this_NL_3= RULE_NL ( (lv_statements_4_0= ruleStatement ) ) )* (this_NL_5= RULE_NL )? otherlv_6= '}'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:179:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:180:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlockAccess().getBlockAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleBlock316); 

                	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:189:1: ( (lv_statements_2_0= ruleStatement ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID||LA4_0==12||(LA4_0>=14 && LA4_0<=16)||(LA4_0>=22 && LA4_0<=23)||LA4_0==26) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:190:1: (lv_statements_2_0= ruleStatement )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:190:1: (lv_statements_2_0= ruleStatement )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:191:3: lv_statements_2_0= ruleStatement
                    {
                     
                    	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStatement_in_ruleBlock337);
                    lv_statements_2_0=ruleStatement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBlockRule());
                    	        }
                           		add(
                           			current, 
                           			"statements",
                            		lv_statements_2_0, 
                            		"Statement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:207:3: (this_NL_3= RULE_NL ( (lv_statements_4_0= ruleStatement ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_NL) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==RULE_ID||LA5_1==12||(LA5_1>=14 && LA5_1<=16)||(LA5_1>=22 && LA5_1<=23)||LA5_1==26) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:207:4: this_NL_3= RULE_NL ( (lv_statements_4_0= ruleStatement ) )
            	    {
            	    this_NL_3=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleBlock350); 
            	     
            	        newLeafNode(this_NL_3, grammarAccess.getBlockAccess().getNLTerminalRuleCall_3_0()); 
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:211:1: ( (lv_statements_4_0= ruleStatement ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:212:1: (lv_statements_4_0= ruleStatement )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:212:1: (lv_statements_4_0= ruleStatement )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:213:3: lv_statements_4_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock370);
            	    lv_statements_4_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_4_0, 
            	            		"Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:229:4: (this_NL_5= RULE_NL )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_NL) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:229:5: this_NL_5= RULE_NL
                    {
                    this_NL_5=(Token)match(input,RULE_NL,FOLLOW_RULE_NL_in_ruleBlock384); 
                     
                        newLeafNode(this_NL_5, grammarAccess.getBlockAccess().getNLTerminalRuleCall_4()); 
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleBlock397); 

                	newLeafNode(otherlv_6, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_5());
                

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


    // $ANTLR start "entryRuleStatement"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:245:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:246:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:247:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement433);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement443); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:254:1: ruleStatement returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_Block_2= ruleBlock | this_Annotation_3= ruleAnnotation | this_FunctionCall_4= ruleFunctionCall | this_IfStatement_5= ruleIfStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_Assignment_1 = null;

        EObject this_Block_2 = null;

        EObject this_Annotation_3 = null;

        EObject this_FunctionCall_4 = null;

        EObject this_IfStatement_5 = null;

        EObject this_WhileStatement_6 = null;

        EObject this_ReturnStatement_7 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:257:28: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_Block_2= ruleBlock | this_Annotation_3= ruleAnnotation | this_FunctionCall_4= ruleFunctionCall | this_IfStatement_5= ruleIfStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:258:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_Block_2= ruleBlock | this_Annotation_3= ruleAnnotation | this_FunctionCall_4= ruleFunctionCall | this_IfStatement_5= ruleIfStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:258:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_Block_2= ruleBlock | this_Annotation_3= ruleAnnotation | this_FunctionCall_4= ruleFunctionCall | this_IfStatement_5= ruleIfStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement )
            int alt7=8;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:259:5: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleStatement490);
                    this_VariableDeclaration_0=ruleVariableDeclaration();

                    state._fsp--;

                     
                            current = this_VariableDeclaration_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:269:5: this_Assignment_1= ruleAssignment
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAssignment_in_ruleStatement517);
                    this_Assignment_1=ruleAssignment();

                    state._fsp--;

                     
                            current = this_Assignment_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:279:5: this_Block_2= ruleBlock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement544);
                    this_Block_2=ruleBlock();

                    state._fsp--;

                     
                            current = this_Block_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:289:5: this_Annotation_3= ruleAnnotation
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getAnnotationParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleAnnotation_in_ruleStatement571);
                    this_Annotation_3=ruleAnnotation();

                    state._fsp--;

                     
                            current = this_Annotation_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:299:5: this_FunctionCall_4= ruleFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getFunctionCallParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_ruleStatement598);
                    this_FunctionCall_4=ruleFunctionCall();

                    state._fsp--;

                     
                            current = this_FunctionCall_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:309:5: this_IfStatement_5= ruleIfStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement625);
                    this_IfStatement_5=ruleIfStatement();

                    state._fsp--;

                     
                            current = this_IfStatement_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:319:5: this_WhileStatement_6= ruleWhileStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement652);
                    this_WhileStatement_6=ruleWhileStatement();

                    state._fsp--;

                     
                            current = this_WhileStatement_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:329:5: this_ReturnStatement_7= ruleReturnStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement679);
                    this_ReturnStatement_7=ruleReturnStatement();

                    state._fsp--;

                     
                            current = this_ReturnStatement_7; 
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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:345:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:346:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:347:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             newCompositeNode(grammarAccess.getReturnStatementRule()); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement714);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement724); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:354:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' ( (lv_returnExpr_1_0= ruleExpr ) ) ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_returnExpr_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:357:28: ( (otherlv_0= 'return' ( (lv_returnExpr_1_0= ruleExpr ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:358:1: (otherlv_0= 'return' ( (lv_returnExpr_1_0= ruleExpr ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:358:1: (otherlv_0= 'return' ( (lv_returnExpr_1_0= ruleExpr ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:358:3: otherlv_0= 'return' ( (lv_returnExpr_1_0= ruleExpr ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleReturnStatement761); 

                	newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:362:1: ( (lv_returnExpr_1_0= ruleExpr ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:363:1: (lv_returnExpr_1_0= ruleExpr )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:363:1: (lv_returnExpr_1_0= ruleExpr )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:364:3: lv_returnExpr_1_0= ruleExpr
            {
             
            	        newCompositeNode(grammarAccess.getReturnStatementAccess().getReturnExprExprParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpr_in_ruleReturnStatement782);
            lv_returnExpr_1_0=ruleExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReturnStatementRule());
            	        }
                   		set(
                   			current, 
                   			"returnExpr",
                    		lv_returnExpr_1_0, 
                    		"Expr");
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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:388:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:389:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:390:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement818);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement828); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:397:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_body_2_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject lv_body_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:400:28: ( (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_body_2_0= ruleBlock ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:401:1: (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_body_2_0= ruleBlock ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:401:1: (otherlv_0= 'while' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_body_2_0= ruleBlock ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:401:3: otherlv_0= 'while' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_body_2_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleWhileStatement865); 

                	newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:405:1: ( (lv_condition_1_0= ruleExpr ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:406:1: (lv_condition_1_0= ruleExpr )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:406:1: (lv_condition_1_0= ruleExpr )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:407:3: lv_condition_1_0= ruleExpr
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionExprParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpr_in_ruleWhileStatement886);
            lv_condition_1_0=ruleExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"Expr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:423:2: ( (lv_body_2_0= ruleBlock ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:424:1: (lv_body_2_0= ruleBlock )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:424:1: (lv_body_2_0= ruleBlock )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:425:3: lv_body_2_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement907);
            lv_body_2_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_2_0, 
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
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleIfStatement"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:449:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:450:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:451:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement943);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement953); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:458:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_then_2_0= ruleBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_condition_1_0 = null;

        EObject lv_then_2_0 = null;

        EObject lv_else_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:461:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_then_2_0= ruleBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleBlock ) ) )? ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:462:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_then_2_0= ruleBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleBlock ) ) )? )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:462:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_then_2_0= ruleBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleBlock ) ) )? )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:462:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpr ) ) ( (lv_then_2_0= ruleBlock ) ) (otherlv_3= 'else' ( (lv_else_4_0= ruleBlock ) ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleIfStatement990); 

                	newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:466:1: ( (lv_condition_1_0= ruleExpr ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:467:1: (lv_condition_1_0= ruleExpr )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:467:1: (lv_condition_1_0= ruleExpr )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:468:3: lv_condition_1_0= ruleExpr
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getConditionExprParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpr_in_ruleIfStatement1011);
            lv_condition_1_0=ruleExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"Expr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:484:2: ( (lv_then_2_0= ruleBlock ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:485:1: (lv_then_2_0= ruleBlock )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:485:1: (lv_then_2_0= ruleBlock )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:486:3: lv_then_2_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1032);
            lv_then_2_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	        }
                   		set(
                   			current, 
                   			"then",
                    		lv_then_2_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:502:2: (otherlv_3= 'else' ( (lv_else_4_0= ruleBlock ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:502:4: otherlv_3= 'else' ( (lv_else_4_0= ruleBlock ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleIfStatement1045); 

                        	newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getElseKeyword_3_0());
                        
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:506:1: ( (lv_else_4_0= ruleBlock ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:507:1: (lv_else_4_0= ruleBlock )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:507:1: (lv_else_4_0= ruleBlock )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:508:3: lv_else_4_0= ruleBlock
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1066);
                    lv_else_4_0=ruleBlock();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"else",
                            		lv_else_4_0, 
                            		"Block");
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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:532:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:533:2: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:534:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getFunctionDeclarationRule()); 
            pushFollow(FOLLOW_ruleFunctionDeclaration_in_entryRuleFunctionDeclaration1104);
            iv_ruleFunctionDeclaration=ruleFunctionDeclaration();

            state._fsp--;

             current =iv_ruleFunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDeclaration1114); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:541:1: ruleFunctionDeclaration returns [EObject current=null] : (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) ) ;
    public final EObject ruleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_returnType_1_0 = null;

        EObject lv_params_4_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_body_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:544:28: ( (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:545:1: (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:545:1: (otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:545:3: otherlv_0= 'function' ( (lv_returnType_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )? otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleFunctionDeclaration1151); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionDeclarationAccess().getFunctionKeyword_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:549:1: ( (lv_returnType_1_0= ruleType ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:550:1: (lv_returnType_1_0= ruleType )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:550:1: (lv_returnType_1_0= ruleType )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:551:3: lv_returnType_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getReturnTypeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleFunctionDeclaration1172);
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

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:567:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:568:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:568:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:569:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionDeclaration1189); 

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

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleFunctionDeclaration1206); 

                	newLeafNode(otherlv_3, grammarAccess.getFunctionDeclarationAccess().getLeftParenthesisKeyword_3());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:589:1: ( ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=22 && LA10_0<=23)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:589:2: ( (lv_params_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:589:2: ( (lv_params_4_0= ruleParameter ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:590:1: (lv_params_4_0= ruleParameter )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:590:1: (lv_params_4_0= ruleParameter )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:591:3: lv_params_4_0= ruleParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParamsParameterParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParameter_in_ruleFunctionDeclaration1228);
                    lv_params_4_0=ruleParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    	        }
                           		add(
                           			current, 
                           			"params",
                            		lv_params_4_0, 
                            		"Parameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:607:2: (otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==20) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:607:4: otherlv_5= ',' ( (lv_params_6_0= ruleParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleFunctionDeclaration1241); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getFunctionDeclarationAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:611:1: ( (lv_params_6_0= ruleParameter ) )
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:612:1: (lv_params_6_0= ruleParameter )
                    	    {
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:612:1: (lv_params_6_0= ruleParameter )
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:613:3: lv_params_6_0= ruleParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParamsParameterParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameter_in_ruleFunctionDeclaration1262);
                    	    lv_params_6_0=ruleParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"params",
                    	            		lv_params_6_0, 
                    	            		"Parameter");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleFunctionDeclaration1278); 

                	newLeafNode(otherlv_7, grammarAccess.getFunctionDeclarationAccess().getRightParenthesisKeyword_5());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:633:1: ( (lv_body_8_0= ruleBlock ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:634:1: (lv_body_8_0= ruleBlock )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:634:1: (lv_body_8_0= ruleBlock )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:635:3: lv_body_8_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getBodyBlockParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFunctionDeclaration1299);
            lv_body_8_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_8_0, 
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
    // $ANTLR end "ruleFunctionDeclaration"


    // $ANTLR start "entryRuleParameter"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:659:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:660:2: (iv_ruleParameter= ruleParameter EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:661:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1335);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1345); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:668:1: ruleParameter returns [EObject current=null] : ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:671:28: ( ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:672:1: ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:672:1: ( () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:672:2: () ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:672:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:673:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParameterAccess().getParameterAction_0(),
                        current);
                

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:678:2: ( (lv_type_1_0= ruleType ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:679:1: (lv_type_1_0= ruleType )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:679:1: (lv_type_1_0= ruleType )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:680:3: lv_type_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleParameter1400);
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

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:696:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:697:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:697:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:698:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameter1417); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:722:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:723:2: (iv_ruleType= ruleType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:724:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType1458);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1468); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:731:1: ruleType returns [EObject current=null] : (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveType_0 = null;

        EObject this_ArrayType_1 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:734:28: ( (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:735:1: (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:735:1: (this_PrimitiveType_0= rulePrimitiveType | this_ArrayType_1= ruleArrayType )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==EOF||LA11_1==RULE_ID) ) {
                    alt11=1;
                }
                else if ( (LA11_1==24) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==23) ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==24) ) {
                    alt11=2;
                }
                else if ( (LA11_2==EOF||LA11_2==RULE_ID) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:736:5: this_PrimitiveType_0= rulePrimitiveType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimitiveType_in_ruleType1515);
                    this_PrimitiveType_0=rulePrimitiveType();

                    state._fsp--;

                     
                            current = this_PrimitiveType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:746:5: this_ArrayType_1= ruleArrayType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getArrayTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrayType_in_ruleType1542);
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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:762:1: entryRulePrimitiveType returns [EObject current=null] : iv_rulePrimitiveType= rulePrimitiveType EOF ;
    public final EObject entryRulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:763:2: (iv_rulePrimitiveType= rulePrimitiveType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:764:2: iv_rulePrimitiveType= rulePrimitiveType EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1577);
            iv_rulePrimitiveType=rulePrimitiveType();

            state._fsp--;

             current =iv_rulePrimitiveType; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveType1587); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:771:1: rulePrimitiveType returns [EObject current=null] : (this_IntType_0= ruleIntType | this_BoolType_1= ruleBoolType ) ;
    public final EObject rulePrimitiveType() throws RecognitionException {
        EObject current = null;

        EObject this_IntType_0 = null;

        EObject this_BoolType_1 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:774:28: ( (this_IntType_0= ruleIntType | this_BoolType_1= ruleBoolType ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:775:1: (this_IntType_0= ruleIntType | this_BoolType_1= ruleBoolType )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:775:1: (this_IntType_0= ruleIntType | this_BoolType_1= ruleBoolType )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            else if ( (LA12_0==23) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:776:5: this_IntType_0= ruleIntType
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getIntTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIntType_in_rulePrimitiveType1634);
                    this_IntType_0=ruleIntType();

                    state._fsp--;

                     
                            current = this_IntType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:786:5: this_BoolType_1= ruleBoolType
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveTypeAccess().getBoolTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleBoolType_in_rulePrimitiveType1661);
                    this_BoolType_1=ruleBoolType();

                    state._fsp--;

                     
                            current = this_BoolType_1; 
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
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "entryRuleIntType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:802:1: entryRuleIntType returns [EObject current=null] : iv_ruleIntType= ruleIntType EOF ;
    public final EObject entryRuleIntType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:803:2: (iv_ruleIntType= ruleIntType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:804:2: iv_ruleIntType= ruleIntType EOF
            {
             newCompositeNode(grammarAccess.getIntTypeRule()); 
            pushFollow(FOLLOW_ruleIntType_in_entryRuleIntType1696);
            iv_ruleIntType=ruleIntType();

            state._fsp--;

             current =iv_ruleIntType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntType1706); 

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
    // $ANTLR end "entryRuleIntType"


    // $ANTLR start "ruleIntType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:811:1: ruleIntType returns [EObject current=null] : ( () otherlv_1= 'int' ) ;
    public final EObject ruleIntType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:814:28: ( ( () otherlv_1= 'int' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:815:1: ( () otherlv_1= 'int' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:815:1: ( () otherlv_1= 'int' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:815:2: () otherlv_1= 'int'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:815:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:816:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntTypeAccess().getIntTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleIntType1752); 

                	newLeafNode(otherlv_1, grammarAccess.getIntTypeAccess().getIntKeyword_1());
                

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
    // $ANTLR end "ruleIntType"


    // $ANTLR start "entryRuleBoolType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:833:1: entryRuleBoolType returns [EObject current=null] : iv_ruleBoolType= ruleBoolType EOF ;
    public final EObject entryRuleBoolType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:834:2: (iv_ruleBoolType= ruleBoolType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:835:2: iv_ruleBoolType= ruleBoolType EOF
            {
             newCompositeNode(grammarAccess.getBoolTypeRule()); 
            pushFollow(FOLLOW_ruleBoolType_in_entryRuleBoolType1788);
            iv_ruleBoolType=ruleBoolType();

            state._fsp--;

             current =iv_ruleBoolType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolType1798); 

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
    // $ANTLR end "entryRuleBoolType"


    // $ANTLR start "ruleBoolType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:842:1: ruleBoolType returns [EObject current=null] : ( () otherlv_1= 'bool' ) ;
    public final EObject ruleBoolType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:845:28: ( ( () otherlv_1= 'bool' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:846:1: ( () otherlv_1= 'bool' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:846:1: ( () otherlv_1= 'bool' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:846:2: () otherlv_1= 'bool'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:846:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:847:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBoolTypeAccess().getBoolTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleBoolType1844); 

                	newLeafNode(otherlv_1, grammarAccess.getBoolTypeAccess().getBoolKeyword_1());
                

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
    // $ANTLR end "ruleBoolType"


    // $ANTLR start "entryRuleArrayType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:864:1: entryRuleArrayType returns [EObject current=null] : iv_ruleArrayType= ruleArrayType EOF ;
    public final EObject entryRuleArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:865:2: (iv_ruleArrayType= ruleArrayType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:866:2: iv_ruleArrayType= ruleArrayType EOF
            {
             newCompositeNode(grammarAccess.getArrayTypeRule()); 
            pushFollow(FOLLOW_ruleArrayType_in_entryRuleArrayType1880);
            iv_ruleArrayType=ruleArrayType();

            state._fsp--;

             current =iv_ruleArrayType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayType1890); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:873:1: ruleArrayType returns [EObject current=null] : ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' otherlv_3= ']' ) ;
    public final EObject ruleArrayType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_baseType_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:876:28: ( ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' otherlv_3= ']' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:877:1: ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' otherlv_3= ']' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:877:1: ( () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' otherlv_3= ']' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:877:2: () ( (lv_baseType_1_0= rulePrimitiveType ) ) otherlv_2= '[' otherlv_3= ']'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:877:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:878:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayTypeAccess().getArrayTypeAction_0(),
                        current);
                

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:883:2: ( (lv_baseType_1_0= rulePrimitiveType ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:884:1: (lv_baseType_1_0= rulePrimitiveType )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:884:1: (lv_baseType_1_0= rulePrimitiveType )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:885:3: lv_baseType_1_0= rulePrimitiveType
            {
             
            	        newCompositeNode(grammarAccess.getArrayTypeAccess().getBaseTypePrimitiveTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePrimitiveType_in_ruleArrayType1945);
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleArrayType1957); 

                	newLeafNode(otherlv_2, grammarAccess.getArrayTypeAccess().getLeftSquareBracketKeyword_2());
                
            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleArrayType1969); 

                	newLeafNode(otherlv_3, grammarAccess.getArrayTypeAccess().getRightSquareBracketKeyword_3());
                

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:917:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:918:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:919:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall2005);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall2015); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:926:1: ruleFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_actuals_3_0= ruleExpr ) )? (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_actuals_3_0 = null;

        EObject lv_actuals_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:929:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_actuals_3_0= ruleExpr ) )? (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )* otherlv_6= ')' )? ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:930:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_actuals_3_0= ruleExpr ) )? (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )* otherlv_6= ')' )? )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:930:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_actuals_3_0= ruleExpr ) )? (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )* otherlv_6= ')' )? )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:930:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '(' ( (lv_actuals_3_0= ruleExpr ) )? (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )* otherlv_6= ')' )?
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:930:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:931:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionCallAccess().getSymbolRefAction_0(),
                        current);
                

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:936:2: ( (otherlv_1= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:937:1: (otherlv_1= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:937:1: (otherlv_1= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:938:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionCall2069); 

            		newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getSymbolSymbolCrossReference_1_0()); 
            	

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:949:2: (otherlv_2= '(' ( (lv_actuals_3_0= ruleExpr ) )? (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )* otherlv_6= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:949:4: otherlv_2= '(' ( (lv_actuals_3_0= ruleExpr ) )? (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleFunctionCall2082); 

                        	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:953:1: ( (lv_actuals_3_0= ruleExpr ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_INT)||(LA13_0>=37 && LA13_0<=38)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:954:1: (lv_actuals_3_0= ruleExpr )
                            {
                            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:954:1: (lv_actuals_3_0= ruleExpr )
                            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:955:3: lv_actuals_3_0= ruleExpr
                            {
                             
                            	        newCompositeNode(grammarAccess.getFunctionCallAccess().getActualsExprParserRuleCall_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpr_in_ruleFunctionCall2103);
                            lv_actuals_3_0=ruleExpr();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"actuals",
                                    		lv_actuals_3_0, 
                                    		"Expr");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:971:3: (otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==20) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:971:5: otherlv_4= ',' ( (lv_actuals_5_0= ruleExpr ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleFunctionCall2117); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:975:1: ( (lv_actuals_5_0= ruleExpr ) )
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:976:1: (lv_actuals_5_0= ruleExpr )
                    	    {
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:976:1: (lv_actuals_5_0= ruleExpr )
                    	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:977:3: lv_actuals_5_0= ruleExpr
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getActualsExprParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpr_in_ruleFunctionCall2138);
                    	    lv_actuals_5_0=ruleExpr();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"actuals",
                    	            		lv_actuals_5_0, 
                    	            		"Expr");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleFunctionCall2152); 

                        	newLeafNode(otherlv_6, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_2_3());
                        

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
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleAnnotation"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1005:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1006:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1007:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation2190);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation2200); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1014:1: ruleAnnotation returns [EObject current=null] : ( () otherlv_1= 'TODO5' ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1017:28: ( ( () otherlv_1= 'TODO5' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1018:1: ( () otherlv_1= 'TODO5' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1018:1: ( () otherlv_1= 'TODO5' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1018:2: () otherlv_1= 'TODO5'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1018:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1019:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAnnotationAccess().getAnnotationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleAnnotation2246); 

                	newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().getTODO5Keyword_1());
                

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


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1036:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1037:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1038:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2282);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration2292); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1045:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':=' ( (lv_initialValue_3_0= ruleExpr ) ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_initialValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1048:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':=' ( (lv_initialValue_3_0= ruleExpr ) ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1049:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':=' ( (lv_initialValue_3_0= ruleExpr ) ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1049:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':=' ( (lv_initialValue_3_0= ruleExpr ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1049:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':=' ( (lv_initialValue_3_0= ruleExpr ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1049:2: ( (lv_type_0_0= ruleType ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1050:1: (lv_type_0_0= ruleType )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1050:1: (lv_type_0_0= ruleType )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1051:3: lv_type_0_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration2338);
            lv_type_0_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1067:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1068:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1068:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1069:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclaration2355); 

            			newLeafNode(lv_name_1_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1085:2: (otherlv_2= ':=' ( (lv_initialValue_3_0= ruleExpr ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1085:4: otherlv_2= ':=' ( (lv_initialValue_3_0= ruleExpr ) )
            {
            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleVariableDeclaration2373); 

                	newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getColonEqualsSignKeyword_2_0());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1089:1: ( (lv_initialValue_3_0= ruleExpr ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1090:1: (lv_initialValue_3_0= ruleExpr )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1090:1: (lv_initialValue_3_0= ruleExpr )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1091:3: lv_initialValue_3_0= ruleExpr
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitialValueExprParserRuleCall_2_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpr_in_ruleVariableDeclaration2394);
            lv_initialValue_3_0=ruleExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"initialValue",
                    		lv_initialValue_3_0, 
                    		"Expr");
            	        afterParserOrEnumRuleCall();
            	    

            }


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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1115:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1116:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1117:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment2431);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment2441); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1124:1: ruleAssignment returns [EObject current=null] : ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpr ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_variable_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1127:28: ( ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpr ) ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1128:1: ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpr ) ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1128:1: ( ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpr ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1128:2: ( (lv_variable_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleExpr ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1128:2: ( (lv_variable_0_0= RULE_ID ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1129:1: (lv_variable_0_0= RULE_ID )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1129:1: (lv_variable_0_0= RULE_ID )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1130:3: lv_variable_0_0= RULE_ID
            {
            lv_variable_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment2483); 

            			newLeafNode(lv_variable_0_0, grammarAccess.getAssignmentAccess().getVariableIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"variable",
                    		lv_variable_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleAssignment2500); 

                	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getColonEqualsSignKeyword_1());
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1150:1: ( (lv_value_2_0= ruleExpr ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1151:1: (lv_value_2_0= ruleExpr )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1151:1: (lv_value_2_0= ruleExpr )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1152:3: lv_value_2_0= ruleExpr
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentAccess().getValueExprParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpr_in_ruleAssignment2521);
            lv_value_2_0=ruleExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Expr");
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


    // $ANTLR start "entryRuleExpr"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1176:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1177:2: (iv_ruleExpr= ruleExpr EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1178:2: iv_ruleExpr= ruleExpr EOF
            {
             newCompositeNode(grammarAccess.getExprRule()); 
            pushFollow(FOLLOW_ruleExpr_in_entryRuleExpr2557);
            iv_ruleExpr=ruleExpr();

            state._fsp--;

             current =iv_ruleExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpr2567); 

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
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1185:1: ruleExpr returns [EObject current=null] : this_Comparison_0= ruleComparison ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_Comparison_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1188:28: (this_Comparison_0= ruleComparison )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1190:5: this_Comparison_0= ruleComparison
            {
             
                    newCompositeNode(grammarAccess.getExprAccess().getComparisonParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleComparison_in_ruleExpr2613);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleExpr"


    // $ANTLR start "entryRuleComparison"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1206:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1207:2: (iv_ruleComparison= ruleComparison EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1208:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison2647);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison2657); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1215:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( (lv_type_2_0= ruleComparisonType ) ) ( (lv_right_3_0= ruleAddition ) ) )? ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1218:28: ( (this_Addition_0= ruleAddition ( () ( (lv_type_2_0= ruleComparisonType ) ) ( (lv_right_3_0= ruleAddition ) ) )? ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1219:1: (this_Addition_0= ruleAddition ( () ( (lv_type_2_0= ruleComparisonType ) ) ( (lv_right_3_0= ruleAddition ) ) )? )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1219:1: (this_Addition_0= ruleAddition ( () ( (lv_type_2_0= ruleComparisonType ) ) ( (lv_right_3_0= ruleAddition ) ) )? )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1220:5: this_Addition_0= ruleAddition ( () ( (lv_type_2_0= ruleComparisonType ) ) ( (lv_right_3_0= ruleAddition ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleComparison2704);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1228:1: ( () ( (lv_type_2_0= ruleComparisonType ) ) ( (lv_right_3_0= ruleAddition ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=28 && LA16_0<=34)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1228:2: () ( (lv_type_2_0= ruleComparisonType ) ) ( (lv_right_3_0= ruleAddition ) )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1228:2: ()
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1229:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getComparisonAccess().getEqualsLeftAction_1_0(),
                                current);
                        

                    }

                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1234:2: ( (lv_type_2_0= ruleComparisonType ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1235:1: (lv_type_2_0= ruleComparisonType )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1235:1: (lv_type_2_0= ruleComparisonType )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1236:3: lv_type_2_0= ruleComparisonType
                    {
                     
                    	        newCompositeNode(grammarAccess.getComparisonAccess().getTypeComparisonTypeParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleComparisonType_in_ruleComparison2734);
                    lv_type_2_0=ruleComparisonType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getComparisonRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_2_0, 
                            		"ComparisonType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1252:2: ( (lv_right_3_0= ruleAddition ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1253:1: (lv_right_3_0= ruleAddition )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1253:1: (lv_right_3_0= ruleAddition )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1254:3: lv_right_3_0= ruleAddition
                    {
                     
                    	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAddition_in_ruleComparison2755);
                    lv_right_3_0=ruleAddition();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getComparisonRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_3_0, 
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


    // $ANTLR start "entryRuleComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1278:1: entryRuleComparisonType returns [EObject current=null] : iv_ruleComparisonType= ruleComparisonType EOF ;
    public final EObject entryRuleComparisonType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1279:2: (iv_ruleComparisonType= ruleComparisonType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1280:2: iv_ruleComparisonType= ruleComparisonType EOF
            {
             newCompositeNode(grammarAccess.getComparisonTypeRule()); 
            pushFollow(FOLLOW_ruleComparisonType_in_entryRuleComparisonType2793);
            iv_ruleComparisonType=ruleComparisonType();

            state._fsp--;

             current =iv_ruleComparisonType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparisonType2803); 

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
    // $ANTLR end "entryRuleComparisonType"


    // $ANTLR start "ruleComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1287:1: ruleComparisonType returns [EObject current=null] : (this_LessComparisonType_0= ruleLessComparisonType | this_LessOrEqualComparisonType_1= ruleLessOrEqualComparisonType | this_EqualComparisonType_2= ruleEqualComparisonType | this_GreaterOrEqualComparisonType_3= ruleGreaterOrEqualComparisonType | this_GreaterComparisonType_4= ruleGreaterComparisonType ) ;
    public final EObject ruleComparisonType() throws RecognitionException {
        EObject current = null;

        EObject this_LessComparisonType_0 = null;

        EObject this_LessOrEqualComparisonType_1 = null;

        EObject this_EqualComparisonType_2 = null;

        EObject this_GreaterOrEqualComparisonType_3 = null;

        EObject this_GreaterComparisonType_4 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1290:28: ( (this_LessComparisonType_0= ruleLessComparisonType | this_LessOrEqualComparisonType_1= ruleLessOrEqualComparisonType | this_EqualComparisonType_2= ruleEqualComparisonType | this_GreaterOrEqualComparisonType_3= ruleGreaterOrEqualComparisonType | this_GreaterComparisonType_4= ruleGreaterComparisonType ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1291:1: (this_LessComparisonType_0= ruleLessComparisonType | this_LessOrEqualComparisonType_1= ruleLessOrEqualComparisonType | this_EqualComparisonType_2= ruleEqualComparisonType | this_GreaterOrEqualComparisonType_3= ruleGreaterOrEqualComparisonType | this_GreaterComparisonType_4= ruleGreaterComparisonType )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1291:1: (this_LessComparisonType_0= ruleLessComparisonType | this_LessOrEqualComparisonType_1= ruleLessOrEqualComparisonType | this_EqualComparisonType_2= ruleEqualComparisonType | this_GreaterOrEqualComparisonType_3= ruleGreaterOrEqualComparisonType | this_GreaterComparisonType_4= ruleGreaterComparisonType )
            int alt17=5;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt17=1;
                }
                break;
            case 29:
            case 30:
                {
                alt17=2;
                }
                break;
            case 31:
                {
                alt17=3;
                }
                break;
            case 32:
            case 33:
                {
                alt17=4;
                }
                break;
            case 34:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1292:5: this_LessComparisonType_0= ruleLessComparisonType
                    {
                     
                            newCompositeNode(grammarAccess.getComparisonTypeAccess().getLessComparisonTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLessComparisonType_in_ruleComparisonType2850);
                    this_LessComparisonType_0=ruleLessComparisonType();

                    state._fsp--;

                     
                            current = this_LessComparisonType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1302:5: this_LessOrEqualComparisonType_1= ruleLessOrEqualComparisonType
                    {
                     
                            newCompositeNode(grammarAccess.getComparisonTypeAccess().getLessOrEqualComparisonTypeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLessOrEqualComparisonType_in_ruleComparisonType2877);
                    this_LessOrEqualComparisonType_1=ruleLessOrEqualComparisonType();

                    state._fsp--;

                     
                            current = this_LessOrEqualComparisonType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1312:5: this_EqualComparisonType_2= ruleEqualComparisonType
                    {
                     
                            newCompositeNode(grammarAccess.getComparisonTypeAccess().getEqualComparisonTypeParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleEqualComparisonType_in_ruleComparisonType2904);
                    this_EqualComparisonType_2=ruleEqualComparisonType();

                    state._fsp--;

                     
                            current = this_EqualComparisonType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1322:5: this_GreaterOrEqualComparisonType_3= ruleGreaterOrEqualComparisonType
                    {
                     
                            newCompositeNode(grammarAccess.getComparisonTypeAccess().getGreaterOrEqualComparisonTypeParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleGreaterOrEqualComparisonType_in_ruleComparisonType2931);
                    this_GreaterOrEqualComparisonType_3=ruleGreaterOrEqualComparisonType();

                    state._fsp--;

                     
                            current = this_GreaterOrEqualComparisonType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1332:5: this_GreaterComparisonType_4= ruleGreaterComparisonType
                    {
                     
                            newCompositeNode(grammarAccess.getComparisonTypeAccess().getGreaterComparisonTypeParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleGreaterComparisonType_in_ruleComparisonType2958);
                    this_GreaterComparisonType_4=ruleGreaterComparisonType();

                    state._fsp--;

                     
                            current = this_GreaterComparisonType_4; 
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
    // $ANTLR end "ruleComparisonType"


    // $ANTLR start "entryRuleLessComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1348:1: entryRuleLessComparisonType returns [EObject current=null] : iv_ruleLessComparisonType= ruleLessComparisonType EOF ;
    public final EObject entryRuleLessComparisonType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLessComparisonType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1349:2: (iv_ruleLessComparisonType= ruleLessComparisonType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1350:2: iv_ruleLessComparisonType= ruleLessComparisonType EOF
            {
             newCompositeNode(grammarAccess.getLessComparisonTypeRule()); 
            pushFollow(FOLLOW_ruleLessComparisonType_in_entryRuleLessComparisonType2993);
            iv_ruleLessComparisonType=ruleLessComparisonType();

            state._fsp--;

             current =iv_ruleLessComparisonType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLessComparisonType3003); 

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
    // $ANTLR end "entryRuleLessComparisonType"


    // $ANTLR start "ruleLessComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1357:1: ruleLessComparisonType returns [EObject current=null] : ( () otherlv_1= '<' ) ;
    public final EObject ruleLessComparisonType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1360:28: ( ( () otherlv_1= '<' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1361:1: ( () otherlv_1= '<' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1361:1: ( () otherlv_1= '<' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1361:2: () otherlv_1= '<'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1361:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1362:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLessComparisonTypeAccess().getLessComparisonTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleLessComparisonType3049); 

                	newLeafNode(otherlv_1, grammarAccess.getLessComparisonTypeAccess().getLessThanSignKeyword_1());
                

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
    // $ANTLR end "ruleLessComparisonType"


    // $ANTLR start "entryRuleLessOrEqualComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1379:1: entryRuleLessOrEqualComparisonType returns [EObject current=null] : iv_ruleLessOrEqualComparisonType= ruleLessOrEqualComparisonType EOF ;
    public final EObject entryRuleLessOrEqualComparisonType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLessOrEqualComparisonType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1380:2: (iv_ruleLessOrEqualComparisonType= ruleLessOrEqualComparisonType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1381:2: iv_ruleLessOrEqualComparisonType= ruleLessOrEqualComparisonType EOF
            {
             newCompositeNode(grammarAccess.getLessOrEqualComparisonTypeRule()); 
            pushFollow(FOLLOW_ruleLessOrEqualComparisonType_in_entryRuleLessOrEqualComparisonType3085);
            iv_ruleLessOrEqualComparisonType=ruleLessOrEqualComparisonType();

            state._fsp--;

             current =iv_ruleLessOrEqualComparisonType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLessOrEqualComparisonType3095); 

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
    // $ANTLR end "entryRuleLessOrEqualComparisonType"


    // $ANTLR start "ruleLessOrEqualComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1388:1: ruleLessOrEqualComparisonType returns [EObject current=null] : ( () (otherlv_1= '<=' | otherlv_2= '\\u2264' ) ) ;
    public final EObject ruleLessOrEqualComparisonType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1391:28: ( ( () (otherlv_1= '<=' | otherlv_2= '\\u2264' ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1392:1: ( () (otherlv_1= '<=' | otherlv_2= '\\u2264' ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1392:1: ( () (otherlv_1= '<=' | otherlv_2= '\\u2264' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1392:2: () (otherlv_1= '<=' | otherlv_2= '\\u2264' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1392:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1393:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLessOrEqualComparisonTypeAccess().getLessOrEqualComparisonTypeAction_0(),
                        current);
                

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1398:2: (otherlv_1= '<=' | otherlv_2= '\\u2264' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            else if ( (LA18_0==30) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1398:4: otherlv_1= '<='
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleLessOrEqualComparisonType3142); 

                        	newLeafNode(otherlv_1, grammarAccess.getLessOrEqualComparisonTypeAccess().getLessThanSignEqualsSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1403:7: otherlv_2= '\\u2264'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleLessOrEqualComparisonType3160); 

                        	newLeafNode(otherlv_2, grammarAccess.getLessOrEqualComparisonTypeAccess().getLessThanOrEqualToKeyword_1_1());
                        

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
    // $ANTLR end "ruleLessOrEqualComparisonType"


    // $ANTLR start "entryRuleEqualComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1415:1: entryRuleEqualComparisonType returns [EObject current=null] : iv_ruleEqualComparisonType= ruleEqualComparisonType EOF ;
    public final EObject entryRuleEqualComparisonType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualComparisonType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1416:2: (iv_ruleEqualComparisonType= ruleEqualComparisonType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1417:2: iv_ruleEqualComparisonType= ruleEqualComparisonType EOF
            {
             newCompositeNode(grammarAccess.getEqualComparisonTypeRule()); 
            pushFollow(FOLLOW_ruleEqualComparisonType_in_entryRuleEqualComparisonType3197);
            iv_ruleEqualComparisonType=ruleEqualComparisonType();

            state._fsp--;

             current =iv_ruleEqualComparisonType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualComparisonType3207); 

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
    // $ANTLR end "entryRuleEqualComparisonType"


    // $ANTLR start "ruleEqualComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1424:1: ruleEqualComparisonType returns [EObject current=null] : ( () otherlv_1= '=' ) ;
    public final EObject ruleEqualComparisonType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1427:28: ( ( () otherlv_1= '=' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1428:1: ( () otherlv_1= '=' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1428:1: ( () otherlv_1= '=' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1428:2: () otherlv_1= '='
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1428:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1429:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEqualComparisonTypeAccess().getEqualComparisonTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleEqualComparisonType3253); 

                	newLeafNode(otherlv_1, grammarAccess.getEqualComparisonTypeAccess().getEqualsSignKeyword_1());
                

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
    // $ANTLR end "ruleEqualComparisonType"


    // $ANTLR start "entryRuleGreaterOrEqualComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1446:1: entryRuleGreaterOrEqualComparisonType returns [EObject current=null] : iv_ruleGreaterOrEqualComparisonType= ruleGreaterOrEqualComparisonType EOF ;
    public final EObject entryRuleGreaterOrEqualComparisonType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreaterOrEqualComparisonType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1447:2: (iv_ruleGreaterOrEqualComparisonType= ruleGreaterOrEqualComparisonType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1448:2: iv_ruleGreaterOrEqualComparisonType= ruleGreaterOrEqualComparisonType EOF
            {
             newCompositeNode(grammarAccess.getGreaterOrEqualComparisonTypeRule()); 
            pushFollow(FOLLOW_ruleGreaterOrEqualComparisonType_in_entryRuleGreaterOrEqualComparisonType3289);
            iv_ruleGreaterOrEqualComparisonType=ruleGreaterOrEqualComparisonType();

            state._fsp--;

             current =iv_ruleGreaterOrEqualComparisonType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreaterOrEqualComparisonType3299); 

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
    // $ANTLR end "entryRuleGreaterOrEqualComparisonType"


    // $ANTLR start "ruleGreaterOrEqualComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1455:1: ruleGreaterOrEqualComparisonType returns [EObject current=null] : ( () (otherlv_1= '>=' | otherlv_2= '\\u2265' ) ) ;
    public final EObject ruleGreaterOrEqualComparisonType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1458:28: ( ( () (otherlv_1= '>=' | otherlv_2= '\\u2265' ) ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1459:1: ( () (otherlv_1= '>=' | otherlv_2= '\\u2265' ) )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1459:1: ( () (otherlv_1= '>=' | otherlv_2= '\\u2265' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1459:2: () (otherlv_1= '>=' | otherlv_2= '\\u2265' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1459:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1460:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGreaterOrEqualComparisonTypeAccess().getGreaterOrEqualComparisonTypeAction_0(),
                        current);
                

            }

            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1465:2: (otherlv_1= '>=' | otherlv_2= '\\u2265' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            else if ( (LA19_0==33) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1465:4: otherlv_1= '>='
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleGreaterOrEqualComparisonType3346); 

                        	newLeafNode(otherlv_1, grammarAccess.getGreaterOrEqualComparisonTypeAccess().getGreaterThanSignEqualsSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1470:7: otherlv_2= '\\u2265'
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleGreaterOrEqualComparisonType3364); 

                        	newLeafNode(otherlv_2, grammarAccess.getGreaterOrEqualComparisonTypeAccess().getGreaterThanOrEqualToKeyword_1_1());
                        

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
    // $ANTLR end "ruleGreaterOrEqualComparisonType"


    // $ANTLR start "entryRuleGreaterComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1482:1: entryRuleGreaterComparisonType returns [EObject current=null] : iv_ruleGreaterComparisonType= ruleGreaterComparisonType EOF ;
    public final EObject entryRuleGreaterComparisonType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGreaterComparisonType = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1483:2: (iv_ruleGreaterComparisonType= ruleGreaterComparisonType EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1484:2: iv_ruleGreaterComparisonType= ruleGreaterComparisonType EOF
            {
             newCompositeNode(grammarAccess.getGreaterComparisonTypeRule()); 
            pushFollow(FOLLOW_ruleGreaterComparisonType_in_entryRuleGreaterComparisonType3401);
            iv_ruleGreaterComparisonType=ruleGreaterComparisonType();

            state._fsp--;

             current =iv_ruleGreaterComparisonType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGreaterComparisonType3411); 

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
    // $ANTLR end "entryRuleGreaterComparisonType"


    // $ANTLR start "ruleGreaterComparisonType"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1491:1: ruleGreaterComparisonType returns [EObject current=null] : ( () otherlv_1= '>' ) ;
    public final EObject ruleGreaterComparisonType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1494:28: ( ( () otherlv_1= '>' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1495:1: ( () otherlv_1= '>' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1495:1: ( () otherlv_1= '>' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1495:2: () otherlv_1= '>'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1495:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1496:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGreaterComparisonTypeAccess().getGreaterComparisonTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleGreaterComparisonType3457); 

                	newLeafNode(otherlv_1, grammarAccess.getGreaterComparisonTypeAccess().getGreaterThanSignKeyword_1());
                

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
    // $ANTLR end "ruleGreaterComparisonType"


    // $ANTLR start "entryRuleAddition"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1513:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1514:2: (iv_ruleAddition= ruleAddition EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1515:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition3493);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition3503); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1522:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1525:28: ( (this_Multiplication_0= ruleMultiplication ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )* ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1526:1: (this_Multiplication_0= ruleMultiplication ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )* )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1526:1: (this_Multiplication_0= ruleMultiplication ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1527:5: this_Multiplication_0= ruleMultiplication ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition3550);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1535:1: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==35) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1535:2: () otherlv_2= '+' ( (lv_right_3_0= ruleMultiplication ) )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1535:2: ()
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1536:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAdditionAccess().getPlusLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleAddition3571); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_1());
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1545:1: ( (lv_right_3_0= ruleMultiplication ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1546:1: (lv_right_3_0= ruleMultiplication )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1546:1: (lv_right_3_0= ruleMultiplication )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1547:3: lv_right_3_0= ruleMultiplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition3592);
            	    lv_right_3_0=ruleMultiplication();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"Multiplication");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1571:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1572:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1573:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication3630);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication3640); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1580:1: ruleMultiplication returns [EObject current=null] : (this_PostfixOperator_0= rulePostfixOperator ( () otherlv_2= '*' ( (lv_right_3_0= rulePostfixOperator ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PostfixOperator_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1583:28: ( (this_PostfixOperator_0= rulePostfixOperator ( () otherlv_2= '*' ( (lv_right_3_0= rulePostfixOperator ) ) )* ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1584:1: (this_PostfixOperator_0= rulePostfixOperator ( () otherlv_2= '*' ( (lv_right_3_0= rulePostfixOperator ) ) )* )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1584:1: (this_PostfixOperator_0= rulePostfixOperator ( () otherlv_2= '*' ( (lv_right_3_0= rulePostfixOperator ) ) )* )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1585:5: this_PostfixOperator_0= rulePostfixOperator ( () otherlv_2= '*' ( (lv_right_3_0= rulePostfixOperator ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplicationAccess().getPostfixOperatorParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulePostfixOperator_in_ruleMultiplication3687);
            this_PostfixOperator_0=rulePostfixOperator();

            state._fsp--;

             
                    current = this_PostfixOperator_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1593:1: ( () otherlv_2= '*' ( (lv_right_3_0= rulePostfixOperator ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==36) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1593:2: () otherlv_2= '*' ( (lv_right_3_0= rulePostfixOperator ) )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1593:2: ()
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1594:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleMultiplication3708); 

            	        	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_1());
            	        
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1603:1: ( (lv_right_3_0= rulePostfixOperator ) )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1604:1: (lv_right_3_0= rulePostfixOperator )
            	    {
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1604:1: (lv_right_3_0= rulePostfixOperator )
            	    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1605:3: lv_right_3_0= rulePostfixOperator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPostfixOperatorParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePostfixOperator_in_ruleMultiplication3729);
            	    lv_right_3_0=rulePostfixOperator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"PostfixOperator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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


    // $ANTLR start "entryRulePostfixOperator"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1629:1: entryRulePostfixOperator returns [EObject current=null] : iv_rulePostfixOperator= rulePostfixOperator EOF ;
    public final EObject entryRulePostfixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOperator = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1630:2: (iv_rulePostfixOperator= rulePostfixOperator EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1631:2: iv_rulePostfixOperator= rulePostfixOperator EOF
            {
             newCompositeNode(grammarAccess.getPostfixOperatorRule()); 
            pushFollow(FOLLOW_rulePostfixOperator_in_entryRulePostfixOperator3767);
            iv_rulePostfixOperator=rulePostfixOperator();

            state._fsp--;

             current =iv_rulePostfixOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixOperator3777); 

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
    // $ANTLR end "entryRulePostfixOperator"


    // $ANTLR start "rulePostfixOperator"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1638:1: rulePostfixOperator returns [EObject current=null] : (this_Atomic_0= ruleAtomic ( () otherlv_2= '[' ( (lv_index_3_0= ruleExpr ) ) otherlv_4= ']' )? ) ;
    public final EObject rulePostfixOperator() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Atomic_0 = null;

        EObject lv_index_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1641:28: ( (this_Atomic_0= ruleAtomic ( () otherlv_2= '[' ( (lv_index_3_0= ruleExpr ) ) otherlv_4= ']' )? ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1642:1: (this_Atomic_0= ruleAtomic ( () otherlv_2= '[' ( (lv_index_3_0= ruleExpr ) ) otherlv_4= ']' )? )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1642:1: (this_Atomic_0= ruleAtomic ( () otherlv_2= '[' ( (lv_index_3_0= ruleExpr ) ) otherlv_4= ']' )? )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1643:5: this_Atomic_0= ruleAtomic ( () otherlv_2= '[' ( (lv_index_3_0= ruleExpr ) ) otherlv_4= ']' )?
            {
             
                    newCompositeNode(grammarAccess.getPostfixOperatorAccess().getAtomicParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAtomic_in_rulePostfixOperator3824);
            this_Atomic_0=ruleAtomic();

            state._fsp--;

             
                    current = this_Atomic_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1651:1: ( () otherlv_2= '[' ( (lv_index_3_0= ruleExpr ) ) otherlv_4= ']' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==24) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1651:2: () otherlv_2= '[' ( (lv_index_3_0= ruleExpr ) ) otherlv_4= ']'
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1651:2: ()
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1652:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getPostfixOperatorAccess().getArrayAccessExprAction_1_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_rulePostfixOperator3845); 

                        	newLeafNode(otherlv_2, grammarAccess.getPostfixOperatorAccess().getLeftSquareBracketKeyword_1_1());
                        
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1661:1: ( (lv_index_3_0= ruleExpr ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1662:1: (lv_index_3_0= ruleExpr )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1662:1: (lv_index_3_0= ruleExpr )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1663:3: lv_index_3_0= ruleExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getPostfixOperatorAccess().getIndexExprParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpr_in_rulePostfixOperator3866);
                    lv_index_3_0=ruleExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPostfixOperatorRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_3_0, 
                            		"Expr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_rulePostfixOperator3878); 

                        	newLeafNode(otherlv_4, grammarAccess.getPostfixOperatorAccess().getRightSquareBracketKeyword_1_3());
                        

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
    // $ANTLR end "rulePostfixOperator"


    // $ANTLR start "entryRuleAtomic"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1691:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1692:2: (iv_ruleAtomic= ruleAtomic EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1693:2: iv_ruleAtomic= ruleAtomic EOF
            {
             newCompositeNode(grammarAccess.getAtomicRule()); 
            pushFollow(FOLLOW_ruleAtomic_in_entryRuleAtomic3916);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;

             current =iv_ruleAtomic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomic3926); 

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
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1700:1: ruleAtomic returns [EObject current=null] : (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_INT ) ) ) | this_BooleanLiteral_3= ruleBooleanLiteral ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;
        EObject this_FunctionCall_0 = null;

        EObject this_BooleanLiteral_3 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1703:28: ( (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_INT ) ) ) | this_BooleanLiteral_3= ruleBooleanLiteral ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1704:1: (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_INT ) ) ) | this_BooleanLiteral_3= ruleBooleanLiteral )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1704:1: (this_FunctionCall_0= ruleFunctionCall | ( () ( (lv_value_2_0= RULE_INT ) ) ) | this_BooleanLiteral_3= ruleBooleanLiteral )
            int alt23=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case RULE_INT:
                {
                alt23=2;
                }
                break;
            case 37:
            case 38:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1705:5: this_FunctionCall_0= ruleFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getAtomicAccess().getFunctionCallParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_ruleAtomic3973);
                    this_FunctionCall_0=ruleFunctionCall();

                    state._fsp--;

                     
                            current = this_FunctionCall_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1714:6: ( () ( (lv_value_2_0= RULE_INT ) ) )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1714:6: ( () ( (lv_value_2_0= RULE_INT ) ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1714:7: () ( (lv_value_2_0= RULE_INT ) )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1714:7: ()
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1715:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0(),
                                current);
                        

                    }

                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1720:2: ( (lv_value_2_0= RULE_INT ) )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1721:1: (lv_value_2_0= RULE_INT )
                    {
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1721:1: (lv_value_2_0= RULE_INT )
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1722:3: lv_value_2_0= RULE_INT
                    {
                    lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAtomic4005); 

                    			newLeafNode(lv_value_2_0, grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAtomicRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_2_0, 
                            		"INT");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1740:5: this_BooleanLiteral_3= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getAtomicAccess().getBooleanLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleAtomic4039);
                    this_BooleanLiteral_3=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_3; 
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
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "entryRuleBooleanLiteral"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1756:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1757:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1758:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral4074);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral4084); 

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
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1765:1: ruleBooleanLiteral returns [EObject current=null] : (this_TrueLiteral_0= ruleTrueLiteral | this_FalseLiteral_1= ruleFalseLiteral ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_TrueLiteral_0 = null;

        EObject this_FalseLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1768:28: ( (this_TrueLiteral_0= ruleTrueLiteral | this_FalseLiteral_1= ruleFalseLiteral ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1769:1: (this_TrueLiteral_0= ruleTrueLiteral | this_FalseLiteral_1= ruleFalseLiteral )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1769:1: (this_TrueLiteral_0= ruleTrueLiteral | this_FalseLiteral_1= ruleFalseLiteral )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            else if ( (LA24_0==37) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1770:5: this_TrueLiteral_0= ruleTrueLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanLiteralAccess().getTrueLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleTrueLiteral_in_ruleBooleanLiteral4131);
                    this_TrueLiteral_0=ruleTrueLiteral();

                    state._fsp--;

                     
                            current = this_TrueLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1780:5: this_FalseLiteral_1= ruleFalseLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanLiteralAccess().getFalseLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleFalseLiteral_in_ruleBooleanLiteral4158);
                    this_FalseLiteral_1=ruleFalseLiteral();

                    state._fsp--;

                     
                            current = this_FalseLiteral_1; 
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
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleFalseLiteral"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1796:1: entryRuleFalseLiteral returns [EObject current=null] : iv_ruleFalseLiteral= ruleFalseLiteral EOF ;
    public final EObject entryRuleFalseLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFalseLiteral = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1797:2: (iv_ruleFalseLiteral= ruleFalseLiteral EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1798:2: iv_ruleFalseLiteral= ruleFalseLiteral EOF
            {
             newCompositeNode(grammarAccess.getFalseLiteralRule()); 
            pushFollow(FOLLOW_ruleFalseLiteral_in_entryRuleFalseLiteral4193);
            iv_ruleFalseLiteral=ruleFalseLiteral();

            state._fsp--;

             current =iv_ruleFalseLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFalseLiteral4203); 

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
    // $ANTLR end "entryRuleFalseLiteral"


    // $ANTLR start "ruleFalseLiteral"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1805:1: ruleFalseLiteral returns [EObject current=null] : ( () otherlv_1= 'false' ) ;
    public final EObject ruleFalseLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1808:28: ( ( () otherlv_1= 'false' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1809:1: ( () otherlv_1= 'false' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1809:1: ( () otherlv_1= 'false' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1809:2: () otherlv_1= 'false'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1809:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1810:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFalseLiteralAccess().getFalseLiteralAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleFalseLiteral4249); 

                	newLeafNode(otherlv_1, grammarAccess.getFalseLiteralAccess().getFalseKeyword_1());
                

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
    // $ANTLR end "ruleFalseLiteral"


    // $ANTLR start "entryRuleTrueLiteral"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1827:1: entryRuleTrueLiteral returns [EObject current=null] : iv_ruleTrueLiteral= ruleTrueLiteral EOF ;
    public final EObject entryRuleTrueLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrueLiteral = null;


        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1828:2: (iv_ruleTrueLiteral= ruleTrueLiteral EOF )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1829:2: iv_ruleTrueLiteral= ruleTrueLiteral EOF
            {
             newCompositeNode(grammarAccess.getTrueLiteralRule()); 
            pushFollow(FOLLOW_ruleTrueLiteral_in_entryRuleTrueLiteral4285);
            iv_ruleTrueLiteral=ruleTrueLiteral();

            state._fsp--;

             current =iv_ruleTrueLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrueLiteral4295); 

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
    // $ANTLR end "entryRuleTrueLiteral"


    // $ANTLR start "ruleTrueLiteral"
    // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1836:1: ruleTrueLiteral returns [EObject current=null] : ( () otherlv_1= 'true' ) ;
    public final EObject ruleTrueLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1839:28: ( ( () otherlv_1= 'true' ) )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1840:1: ( () otherlv_1= 'true' )
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1840:1: ( () otherlv_1= 'true' )
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1840:2: () otherlv_1= 'true'
            {
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1840:2: ()
            // ../org.xtext.example.mydsl/src-gen/org/xtext/example/mydsl/parser/antlr/internal/InternalMyDsl.g:1841:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTrueLiteralAccess().getTrueLiteralAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleTrueLiteral4341); 

                	newLeafNode(otherlv_1, grammarAccess.getTrueLiteralAccess().getTrueKeyword_1());
                

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
    // $ANTLR end "ruleTrueLiteral"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\12\uffff";
    static final String DFA7_eofS =
        "\2\uffff\1\11\7\uffff";
    static final String DFA7_minS =
        "\1\5\1\uffff\1\4\7\uffff";
    static final String DFA7_maxS =
        "\1\32\1\uffff\1\33\7\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\6\1\7\1\10\1\2\1\5";
    static final String DFA7_specialS =
        "\12\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\2\6\uffff\1\3\1\uffff\1\7\1\6\1\5\5\uffff\2\1\2\uffff\1\4",
            "",
            "\1\11\10\uffff\1\11\5\uffff\1\11\7\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "258:1: (this_VariableDeclaration_0= ruleVariableDeclaration | this_Assignment_1= ruleAssignment | this_Block_2= ruleBlock | this_Annotation_3= ruleAnnotation | this_FunctionCall_4= ruleFunctionCall | this_IfStatement_5= ruleIfStatement | this_WhileStatement_6= ruleWhileStatement | this_ReturnStatement_7= ruleReturnStatement )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel132 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleFunctionDeclaration_in_ruleModel159 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleModel173 = new BitSet(new long[]{0x0000000004C5D020L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel194 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleFunctionDeclaration_in_ruleModel221 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleBlock316 = new BitSet(new long[]{0x0000000004C1F030L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock337 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleBlock350 = new BitSet(new long[]{0x0000000004C1D020L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock370 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_RULE_NL_in_ruleBlock384 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleBlock397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement433 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStatement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleStatement517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleStatement571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_ruleStatement598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleReturnStatement761 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleReturnStatement782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement818 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleWhileStatement865 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleWhileStatement886 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleIfStatement990 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleIfStatement1011 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1032 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleIfStatement1045 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDeclaration_in_entryRuleFunctionDeclaration1104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDeclaration1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleFunctionDeclaration1151 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_ruleType_in_ruleFunctionDeclaration1172 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionDeclaration1189 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFunctionDeclaration1206 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleFunctionDeclaration1228 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleFunctionDeclaration1241 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleFunctionDeclaration1262 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleFunctionDeclaration1278 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunctionDeclaration1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter1400 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameter1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1458 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleType1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayType_in_ruleType1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_entryRulePrimitiveType1577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveType1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntType_in_rulePrimitiveType1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolType_in_rulePrimitiveType1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntType_in_entryRuleIntType1696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntType1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleIntType1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolType_in_entryRuleBoolType1788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolType1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBoolType1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayType_in_entryRuleArrayType1880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayType1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveType_in_ruleArrayType1945 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleArrayType1957 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleArrayType1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall2005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall2069 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleFunctionCall2082 = new BitSet(new long[]{0x0000006000300060L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleFunctionCall2103 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleFunctionCall2117 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleFunctionCall2138 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_ruleFunctionCall2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation2190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation2200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleAnnotation2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration2338 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclaration2355 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleVariableDeclaration2373 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleVariableDeclaration2394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2483 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleAssignment2500 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleExpr_in_ruleAssignment2521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpr_in_entryRuleExpr2557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpr2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleExpr2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison2647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison2657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2704 = new BitSet(new long[]{0x00000007F0000002L});
    public static final BitSet FOLLOW_ruleComparisonType_in_ruleComparison2734 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonType_in_entryRuleComparisonType2793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparisonType2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLessComparisonType_in_ruleComparisonType2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLessOrEqualComparisonType_in_ruleComparisonType2877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualComparisonType_in_ruleComparisonType2904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreaterOrEqualComparisonType_in_ruleComparisonType2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreaterComparisonType_in_ruleComparisonType2958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLessComparisonType_in_entryRuleLessComparisonType2993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLessComparisonType3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleLessComparisonType3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLessOrEqualComparisonType_in_entryRuleLessOrEqualComparisonType3085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLessOrEqualComparisonType3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleLessOrEqualComparisonType3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleLessOrEqualComparisonType3160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualComparisonType_in_entryRuleEqualComparisonType3197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualComparisonType3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleEqualComparisonType3253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreaterOrEqualComparisonType_in_entryRuleGreaterOrEqualComparisonType3289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreaterOrEqualComparisonType3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleGreaterOrEqualComparisonType3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleGreaterOrEqualComparisonType3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGreaterComparisonType_in_entryRuleGreaterComparisonType3401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGreaterComparisonType3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleGreaterComparisonType3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition3493 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition3503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition3550 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleAddition3571 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition3592 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication3630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixOperator_in_ruleMultiplication3687 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleMultiplication3708 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_rulePostfixOperator_in_ruleMultiplication3729 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rulePostfixOperator_in_entryRulePostfixOperator3767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixOperator3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rulePostfixOperator3824 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_rulePostfixOperator3845 = new BitSet(new long[]{0x0000006000000060L});
    public static final BitSet FOLLOW_ruleExpr_in_rulePostfixOperator3866 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rulePostfixOperator3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic3916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomic3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_ruleAtomic3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAtomic4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleAtomic4039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral4074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrueLiteral_in_ruleBooleanLiteral4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFalseLiteral_in_ruleBooleanLiteral4158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFalseLiteral_in_entryRuleFalseLiteral4193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFalseLiteral4203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleFalseLiteral4249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrueLiteral_in_entryRuleTrueLiteral4285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrueLiteral4295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleTrueLiteral4341 = new BitSet(new long[]{0x0000000000000002L});

}