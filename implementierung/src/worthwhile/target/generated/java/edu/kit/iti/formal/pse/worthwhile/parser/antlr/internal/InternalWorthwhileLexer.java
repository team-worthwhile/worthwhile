package edu.kit.iti.formal.pse.worthwhile.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWorthwhileLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=13;
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
    public static final int T__32=32;
    public static final int RULE_STRING=11;
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

    public InternalWorthwhileLexer() {;} 
    public InternalWorthwhileLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalWorthwhileLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:11:7: ( '_axiom' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:11:9: '_axiom'
            {
            match("_axiom"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:12:7: ( '{' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:12:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:13:7: ( '}' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:13:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:14:7: ( 'return' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:14:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:15:7: ( 'while' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:15:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:16:7: ( '_invariant' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:16:9: '_invariant'
            {
            match("_invariant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:17:7: ( 'if' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:17:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:18:7: ( 'else' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:18:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:19:7: ( 'function' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:19:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:20:7: ( '(' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:20:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:21:7: ( ',' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:21:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:22:7: ( ')' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:22:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:23:7: ( '_requires' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:23:9: '_requires'
            {
            match("_requires"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:24:7: ( '_ensures' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:24:9: '_ensures'
            {
            match("_ensures"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:25:7: ( 'Integer' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:25:9: 'Integer'
            {
            match("Integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:26:7: ( 'Boolean' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:26:9: 'Boolean'
            {
            match("Boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:27:7: ( '[' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:27:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:28:7: ( ']' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:28:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:29:7: ( '_assert' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:29:9: '_assert'
            {
            match("_assert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:30:7: ( '_assume' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:30:9: '_assume'
            {
            match("_assume"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:31:7: ( 'forall' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:31:9: 'forall'
            {
            match("forall"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:32:7: ( '\\u2200' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:32:9: '\\u2200'
            {
            match('\u2200'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:33:7: ( 'exists' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:33:9: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:34:7: ( '\\u2203' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:34:9: '\\u2203'
            {
            match('\u2203'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:35:7: ( ':' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:35:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:36:7: ( ':=' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:36:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:37:7: ( '\\u2228' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:37:9: '\\u2228'
            {
            match('\u2228'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:38:7: ( '||' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:38:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:39:7: ( '\\u2227' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:39:9: '\\u2227'
            {
            match('\u2227'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:40:7: ( '&&' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:40:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:41:7: ( '=' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:41:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:42:7: ( '!=' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:42:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:43:7: ( '\\u2260' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:43:9: '\\u2260'
            {
            match('\u2260'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:44:7: ( '<' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:44:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:45:7: ( '<=' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:45:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:46:7: ( '\\u2264' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:46:9: '\\u2264'
            {
            match('\u2264'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:47:7: ( '>=' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:47:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:48:7: ( '\\u2265' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:48:9: '\\u2265'
            {
            match('\u2265'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:49:7: ( '>' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:49:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:50:7: ( '+' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:50:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:51:7: ( '-' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:51:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:52:7: ( '*' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:52:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:53:7: ( '\\u00B7' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:53:9: '\\u00B7'
            {
            match('\u00B7'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:54:7: ( '/' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:54:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:55:7: ( '\\u00F7' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:55:9: '\\u00F7'
            {
            match('\u00F7'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:56:7: ( '%' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:56:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:57:7: ( '\\u00AC' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:57:9: '\\u00AC'
            {
            match('\u00AC'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:58:7: ( '!' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:58:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:59:7: ( 'length' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:59:9: 'length'
            {
            match("length"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2347:9: ( ( ' ' | '\\t' )+ )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2347:11: ( ' ' | '\\t' )+
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2347:11: ( ' ' | '\\t' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_NL"
    public final void mRULE_NL() throws RecognitionException {
        try {
            int _type = RULE_NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:9: ( ( '\\r' | '\\n' | RULE_WS )* '\\n' ( RULE_WS )* )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:11: ( '\\r' | '\\n' | RULE_WS )* '\\n' ( RULE_WS )*
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:11: ( '\\r' | '\\n' | RULE_WS )*
            loop2:
            do {
                int alt2=4;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:12: '\\r'
            	    {
            	    match('\r'); 

            	    }
            	    break;
            	case 2 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:17: '\\n'
            	    {
            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:22: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match('\n'); 
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:37: ( RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2349:37: RULE_WS
            	    {
            	    mRULE_WS(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NL"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2351:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2351:19: '//' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match("//"); 

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2351:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2351:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2353:13: ( ( '-' )? ( '0' .. '9' )+ )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2353:15: ( '-' )? ( '0' .. '9' )+
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2353:15: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2353:15: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2353:20: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2353:21: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2355:10: ( '%%% DONT USE THIS ANYMORE %%%' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2355:12: '%%% DONT USE THIS ANYMORE %%%'
            {
            match("%%% DONT USE THIS ANYMORE %%%"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_BOOL"
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2357:11: ( ( 'true' | 'false' ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2357:13: ( 'true' | 'false' )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2357:13: ( 'true' | 'false' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='t') ) {
                alt7=1;
            }
            else if ( (LA7_0=='f') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2357:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2357:21: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2359:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2359:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2359:11: ( '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='^') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2359:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2359:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\"') ) {
                alt12=1;
            }
            else if ( (LA12_0=='\'') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\\') ) {
                            alt10=1;
                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='!')||(LA10_0>='#' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\\') ) {
                            alt11=1;
                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='&')||(LA11_0>='(' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2361:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2363:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2363:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2363:24: ( options {greedy=false; } : . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='*') ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1=='/') ) {
                        alt13=2;
                    }
                    else if ( ((LA13_1>='\u0000' && LA13_1<='.')||(LA13_1>='0' && LA13_1<='\uFFFF')) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0>='\u0000' && LA13_0<=')')||(LA13_0>='+' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2363:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2365:16: ( . )
            // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:2365:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | RULE_WS | RULE_NL | RULE_SL_COMMENT | RULE_NUMBER | RULE_INT | RULE_BOOL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_ANY_OTHER )
        int alt14=59;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:232: T__51
                {
                mT__51(); 

                }
                break;
            case 39 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:238: T__52
                {
                mT__52(); 

                }
                break;
            case 40 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:244: T__53
                {
                mT__53(); 

                }
                break;
            case 41 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:250: T__54
                {
                mT__54(); 

                }
                break;
            case 42 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:256: T__55
                {
                mT__55(); 

                }
                break;
            case 43 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:262: T__56
                {
                mT__56(); 

                }
                break;
            case 44 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:268: T__57
                {
                mT__57(); 

                }
                break;
            case 45 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:274: T__58
                {
                mT__58(); 

                }
                break;
            case 46 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:280: T__59
                {
                mT__59(); 

                }
                break;
            case 47 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:286: T__60
                {
                mT__60(); 

                }
                break;
            case 48 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:292: T__61
                {
                mT__61(); 

                }
                break;
            case 49 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:298: T__62
                {
                mT__62(); 

                }
                break;
            case 50 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:304: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 51 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:312: RULE_NL
                {
                mRULE_NL(); 

                }
                break;
            case 52 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:320: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 53 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:336: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;
            case 54 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:348: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 55 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:357: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 56 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:367: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 57 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:375: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 58 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:387: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 59 :
                // ../worthwhile/target/generated/java/edu/kit/iti/formal/pse/worthwhile/parser/antlr/internal/InternalWorthwhile.g:1:403: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA2_eotS =
        "\1\uffff\1\6\3\uffff\1\6\1\uffff";
    static final String DFA2_eofS =
        "\7\uffff";
    static final String DFA2_minS =
        "\2\11\3\uffff\1\11\1\uffff";
    static final String DFA2_maxS =
        "\2\40\3\uffff\1\40\1\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\1\1\3\1\2\1\uffff\1\4";
    static final String DFA2_specialS =
        "\7\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\3\1\1\2\uffff\1\2\22\uffff\1\3",
            "\1\5\1\4\2\uffff\1\4\22\uffff\1\5",
            "",
            "",
            "",
            "\1\5\1\4\2\uffff\1\4\22\uffff\1\5",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    static class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 2349:11: ( '\\r' | '\\n' | RULE_WS )*";
        }
    }
    static final String DFA14_eotS =
        "\1\uffff\1\65\2\uffff\5\65\3\uffff\2\65\4\uffff\1\112\1\uffff\1"+
        "\60\1\uffff\1\60\1\uffff\1\121\1\uffff\1\124\1\uffff\1\127\2\uffff"+
        "\1\132\2\uffff\1\140\1\uffff\1\143\1\uffff\1\65\1\146\1\60\2\uffff"+
        "\1\65\1\60\1\uffff\2\60\1\uffff\4\65\3\uffff\2\65\1\162\5\65\3\uffff"+
        "\2\65\40\uffff\1\65\2\uffff\1\146\1\65\1\uffff\7\65\1\uffff\20\65"+
        "\1\u0094\7\65\1\u009c\7\65\1\u00a4\1\uffff\3\65\1\u009c\3\65\1\uffff"+
        "\1\u00ab\5\65\1\u00b1\1\uffff\1\u00b2\1\65\1\u00b4\2\65\1\u00b7"+
        "\1\uffff\1\u00b8\1\u00b9\3\65\2\uffff\1\65\1\uffff\1\u00be\1\u00bf"+
        "\3\uffff\2\65\1\u00c2\1\u00c3\2\uffff\1\65\1\u00c5\2\uffff\1\u00c6"+
        "\2\uffff";
    static final String DFA14_eofS =
        "\u00c7\uffff";
    static final String DFA14_minS =
        "\1\0\1\141\2\uffff\1\145\1\150\1\146\1\154\1\141\3\uffff\1\156\1"+
        "\157\4\uffff\1\75\1\uffff\1\174\1\uffff\1\46\1\uffff\1\75\1\uffff"+
        "\1\75\1\uffff\1\75\2\uffff\1\60\2\uffff\1\52\1\uffff\1\45\1\uffff"+
        "\1\145\2\11\2\uffff\1\162\1\101\1\uffff\2\0\1\uffff\1\163\1\156"+
        "\1\145\1\156\3\uffff\1\164\1\151\1\60\1\163\1\151\1\156\1\162\1"+
        "\154\3\uffff\1\164\1\157\40\uffff\1\156\2\uffff\1\11\1\165\1\uffff"+
        "\1\151\1\163\1\166\1\161\1\163\1\165\1\154\1\uffff\1\145\1\163\1"+
        "\143\1\141\1\163\1\145\1\154\1\147\1\145\1\157\1\145\1\141\2\165"+
        "\1\162\1\145\1\60\2\164\1\154\1\145\1\147\1\145\1\164\1\60\1\155"+
        "\1\162\1\155\1\162\1\151\1\162\1\156\1\60\1\uffff\1\163\1\151\1"+
        "\154\1\60\1\145\1\141\1\150\1\uffff\1\60\1\164\1\145\1\151\1\162"+
        "\1\145\1\60\1\uffff\1\60\1\157\1\60\1\162\1\156\1\60\1\uffff\2\60"+
        "\1\141\1\145\1\163\2\uffff\1\156\1\uffff\2\60\3\uffff\1\156\1\163"+
        "\2\60\2\uffff\1\164\1\60\2\uffff\1\60\2\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\162\2\uffff\1\145\1\150\1\146\1\170\1\165\3\uffff\1\156"+
        "\1\157\4\uffff\1\75\1\uffff\1\174\1\uffff\1\46\1\uffff\1\75\1\uffff"+
        "\1\75\1\uffff\1\75\2\uffff\1\71\2\uffff\1\57\1\uffff\1\45\1\uffff"+
        "\1\145\2\40\2\uffff\1\162\1\172\1\uffff\2\uffff\1\uffff\1\170\1"+
        "\156\1\145\1\156\3\uffff\1\164\1\151\1\172\1\163\1\151\1\156\1\162"+
        "\1\154\3\uffff\1\164\1\157\40\uffff\1\156\2\uffff\1\40\1\165\1\uffff"+
        "\1\151\1\163\1\166\1\161\1\163\1\165\1\154\1\uffff\1\145\1\163\1"+
        "\143\1\141\1\163\1\145\1\154\1\147\1\145\1\157\1\165\1\141\2\165"+
        "\1\162\1\145\1\172\2\164\1\154\1\145\1\147\1\145\1\164\1\172\1\155"+
        "\1\162\1\155\1\162\1\151\1\162\1\156\1\172\1\uffff\1\163\1\151\1"+
        "\154\1\172\1\145\1\141\1\150\1\uffff\1\172\1\164\1\145\1\151\1\162"+
        "\1\145\1\172\1\uffff\1\172\1\157\1\172\1\162\1\156\1\172\1\uffff"+
        "\2\172\1\141\1\145\1\163\2\uffff\1\156\1\uffff\2\172\3\uffff\1\156"+
        "\1\163\2\172\2\uffff\1\164\1\172\2\uffff\1\172\2\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\1\3\5\uffff\1\12\1\13\1\14\2\uffff\1\21\1\22\1\26\1"+
        "\30\1\uffff\1\33\1\uffff\1\35\1\uffff\1\37\1\uffff\1\41\1\uffff"+
        "\1\44\1\uffff\1\46\1\50\1\uffff\1\52\1\53\1\uffff\1\55\1\uffff\1"+
        "\57\3\uffff\1\63\1\65\2\uffff\1\70\2\uffff\1\73\4\uffff\1\70\1\2"+
        "\1\3\10\uffff\1\12\1\13\1\14\2\uffff\1\21\1\22\1\26\1\30\1\32\1"+
        "\31\1\33\1\34\1\35\1\36\1\37\1\40\1\60\1\41\1\43\1\42\1\44\1\45"+
        "\1\47\1\46\1\50\1\51\1\65\1\52\1\53\1\64\1\72\1\54\1\55\1\66\1\56"+
        "\1\57\1\uffff\1\62\1\63\2\uffff\1\71\7\uffff\1\7\41\uffff\1\10\7"+
        "\uffff\1\67\7\uffff\1\5\6\uffff\1\1\5\uffff\1\4\1\27\1\uffff\1\25"+
        "\2\uffff\1\61\1\23\1\24\4\uffff\1\17\1\20\2\uffff\1\16\1\11\1\uffff"+
        "\1\15\1\6";
    static final String DFA14_specialS =
        "\1\0\55\uffff\1\2\1\1\u0097\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\60\1\47\1\51\2\60\1\50\22\60\1\47\1\30\1\56\2\60\1\44\1"+
            "\26\1\57\1\11\1\13\1\40\1\36\1\12\1\37\1\60\1\42\12\52\1\22"+
            "\1\60\1\32\1\27\1\34\2\60\1\55\1\15\6\55\1\14\21\55\1\16\1\60"+
            "\1\17\1\54\1\1\1\60\4\55\1\7\1\10\2\55\1\6\2\55\1\46\5\55\1"+
            "\4\1\55\1\53\2\55\1\5\3\55\1\2\1\24\1\3\56\60\1\45\12\60\1\41"+
            "\77\60\1\43\u2108\60\1\20\2\60\1\21\43\60\1\25\1\23\67\60\1"+
            "\31\3\60\1\33\1\35\udd9a\60",
            "\1\61\3\uffff\1\64\3\uffff\1\62\10\uffff\1\63",
            "",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73\13\uffff\1\74",
            "\1\77\15\uffff\1\76\5\uffff\1\75",
            "",
            "",
            "",
            "\1\103",
            "\1\104",
            "",
            "",
            "",
            "",
            "\1\111",
            "",
            "\1\114",
            "",
            "\1\116",
            "",
            "\1\120",
            "",
            "\1\123",
            "",
            "\1\126",
            "",
            "",
            "\12\133",
            "",
            "",
            "\1\137\4\uffff\1\136",
            "",
            "\1\142",
            "",
            "\1\145",
            "\1\150\1\147\2\uffff\1\147\22\uffff\1\150",
            "\2\147\2\uffff\1\147\22\uffff\1\147",
            "",
            "",
            "\1\151",
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\0\152",
            "\0\152",
            "",
            "\1\154\4\uffff\1\153",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "",
            "\1\160",
            "\1\161",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "",
            "",
            "\1\170",
            "\1\171",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\172",
            "",
            "",
            "\1\150\1\147\2\uffff\1\147\22\uffff\1\150",
            "\1\173",
            "",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d\17\uffff\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u00b3",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u00b5",
            "\1\u00b6",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "",
            "\1\u00bd",
            "",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "",
            "\1\u00c0",
            "\1\u00c1",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\u00c4",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | RULE_WS | RULE_NL | RULE_SL_COMMENT | RULE_NUMBER | RULE_INT | RULE_BOOL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='_') ) {s = 1;}

                        else if ( (LA14_0=='{') ) {s = 2;}

                        else if ( (LA14_0=='}') ) {s = 3;}

                        else if ( (LA14_0=='r') ) {s = 4;}

                        else if ( (LA14_0=='w') ) {s = 5;}

                        else if ( (LA14_0=='i') ) {s = 6;}

                        else if ( (LA14_0=='e') ) {s = 7;}

                        else if ( (LA14_0=='f') ) {s = 8;}

                        else if ( (LA14_0=='(') ) {s = 9;}

                        else if ( (LA14_0==',') ) {s = 10;}

                        else if ( (LA14_0==')') ) {s = 11;}

                        else if ( (LA14_0=='I') ) {s = 12;}

                        else if ( (LA14_0=='B') ) {s = 13;}

                        else if ( (LA14_0=='[') ) {s = 14;}

                        else if ( (LA14_0==']') ) {s = 15;}

                        else if ( (LA14_0=='\u2200') ) {s = 16;}

                        else if ( (LA14_0=='\u2203') ) {s = 17;}

                        else if ( (LA14_0==':') ) {s = 18;}

                        else if ( (LA14_0=='\u2228') ) {s = 19;}

                        else if ( (LA14_0=='|') ) {s = 20;}

                        else if ( (LA14_0=='\u2227') ) {s = 21;}

                        else if ( (LA14_0=='&') ) {s = 22;}

                        else if ( (LA14_0=='=') ) {s = 23;}

                        else if ( (LA14_0=='!') ) {s = 24;}

                        else if ( (LA14_0=='\u2260') ) {s = 25;}

                        else if ( (LA14_0=='<') ) {s = 26;}

                        else if ( (LA14_0=='\u2264') ) {s = 27;}

                        else if ( (LA14_0=='>') ) {s = 28;}

                        else if ( (LA14_0=='\u2265') ) {s = 29;}

                        else if ( (LA14_0=='+') ) {s = 30;}

                        else if ( (LA14_0=='-') ) {s = 31;}

                        else if ( (LA14_0=='*') ) {s = 32;}

                        else if ( (LA14_0=='\u00B7') ) {s = 33;}

                        else if ( (LA14_0=='/') ) {s = 34;}

                        else if ( (LA14_0=='\u00F7') ) {s = 35;}

                        else if ( (LA14_0=='%') ) {s = 36;}

                        else if ( (LA14_0=='\u00AC') ) {s = 37;}

                        else if ( (LA14_0=='l') ) {s = 38;}

                        else if ( (LA14_0=='\t'||LA14_0==' ') ) {s = 39;}

                        else if ( (LA14_0=='\r') ) {s = 40;}

                        else if ( (LA14_0=='\n') ) {s = 41;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 42;}

                        else if ( (LA14_0=='t') ) {s = 43;}

                        else if ( (LA14_0=='^') ) {s = 44;}

                        else if ( (LA14_0=='A'||(LA14_0>='C' && LA14_0<='H')||(LA14_0>='J' && LA14_0<='Z')||(LA14_0>='a' && LA14_0<='d')||(LA14_0>='g' && LA14_0<='h')||(LA14_0>='j' && LA14_0<='k')||(LA14_0>='m' && LA14_0<='q')||LA14_0=='s'||(LA14_0>='u' && LA14_0<='v')||(LA14_0>='x' && LA14_0<='z')) ) {s = 45;}

                        else if ( (LA14_0=='\"') ) {s = 46;}

                        else if ( (LA14_0=='\'') ) {s = 47;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||(LA14_0>='#' && LA14_0<='$')||LA14_0=='.'||LA14_0==';'||(LA14_0>='?' && LA14_0<='@')||LA14_0=='\\'||LA14_0=='`'||(LA14_0>='~' && LA14_0<='\u00AB')||(LA14_0>='\u00AD' && LA14_0<='\u00B6')||(LA14_0>='\u00B8' && LA14_0<='\u00F6')||(LA14_0>='\u00F8' && LA14_0<='\u21FF')||(LA14_0>='\u2201' && LA14_0<='\u2202')||(LA14_0>='\u2204' && LA14_0<='\u2226')||(LA14_0>='\u2229' && LA14_0<='\u225F')||(LA14_0>='\u2261' && LA14_0<='\u2263')||(LA14_0>='\u2266' && LA14_0<='\uFFFF')) ) {s = 48;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_47 = input.LA(1);

                        s = -1;
                        if ( ((LA14_47>='\u0000' && LA14_47<='\uFFFF')) ) {s = 106;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_46 = input.LA(1);

                        s = -1;
                        if ( ((LA14_46>='\u0000' && LA14_46<='\uFFFF')) ) {s = 106;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}