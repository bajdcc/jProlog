// Generated from O:/java_project/jProlog\Prolog.g4 by ANTLR 4.5.1
package com.bajdcc.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrologParser extends Parser {
    public static final int
            Existential = 1, Universal = 2, NOT = 3, ART1 = 4, ART2 = 5, CMP1 = 6, CMP2 = 7, CMP3 = 8,
            CMP4 = 9, LOG1 = 10, LOG2 = 11, XOR = 12, IMPLY = 13, SEMI = 14, COMMA = 15, RANGE = 16,
            LeftParen = 17, RightParen = 18, LeftBracket = 19, RightBracket = 20, LeftBrace = 21,
            RightBrace = 22, ID = 23, Literal = 24, Number = 25, Whitespace = 26, Newline = 27,
            BlockComment = 28, LineComment = 29;
    public static final int
            RULE_start = 0, RULE_definitions = 1, RULE_definition = 2, RULE_setDef = 3,
            RULE_setParams = 4, RULE_setParam = 5, RULE_variableDef = 6, RULE_vDef1 = 7,
            RULE_vDef2 = 8, RULE_vDef3 = 9, RULE_typeParams = 10, RULE_conditionDef = 11,
            RULE_quantifiers = 12, RULE_quantifier = 13, RULE_parameters = 14, RULE_expression = 15;
    public static final String[] ruleNames = {
            "start", "definitions", "definition", "setDef", "setParams", "setParam",
            "variableDef", "vDef1", "vDef2", "vDef3", "typeParams", "conditionDef",
            "quantifiers", "quantifier", "parameters", "expression"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u00c9\4\2\t\2" +
                    "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2" +
                    "\3\3\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\5\4-\n\4\3\4\3\4\3\5\3\5\3\5\3\5" +
                    "\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\7\3\7\3\7\3\7\3" +
                    "\7\5\7F\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\7\tT\n\t" +
                    "\f\t\16\tW\13\t\3\n\3\n\3\n\7\n\\\n\n\f\n\16\n_\13\n\3\13\3\13\3\13\3" +
                    "\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13k\n\13\f\13\16\13n\13\13\3\f\3\f" +
                    "\3\f\7\fs\n\f\f\f\16\fv\13\f\3\r\5\ry\n\r\3\r\3\r\3\16\3\16\3\16\7\16" +
                    "\u0080\n\16\f\16\16\16\u0083\13\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20" +
                    "\7\20\u008c\n\20\f\20\16\20\u008f\13\20\3\21\3\21\3\21\3\21\3\21\3\21" +
                    "\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21" +
                    "\u00a4\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21" +
                    "\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21" +
                    "\3\21\3\21\3\21\3\21\7\21\u00c4\n\21\f\21\16\21\u00c7\13\21\3\21\2\3 " +
                    "\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\3\4\u00d7\2\"\3\2" +
                    "\2\2\4%\3\2\2\2\6,\3\2\2\2\b\60\3\2\2\2\n8\3\2\2\2\fE\3\2\2\2\16G\3\2" +
                    "\2\2\20P\3\2\2\2\22X\3\2\2\2\24`\3\2\2\2\26o\3\2\2\2\30x\3\2\2\2\32|\3" +
                    "\2\2\2\34\u0084\3\2\2\2\36\u0088\3\2\2\2 \u00a3\3\2\2\2\"#\5\4\3\2#\3" +
                    "\3\2\2\2$&\5\6\4\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2" +
                    "\2)-\5\b\5\2*-\5\16\b\2+-\5\30\r\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-.\3\2" +
                    "\2\2./\7\20\2\2/\7\3\2\2\2\60\61\7\31\2\2\61\62\7\27\2\2\62\63\7\30\2" +
                    "\2\63\64\7\n\2\2\64\65\7\27\2\2\65\66\5\n\6\2\66\67\7\30\2\2\67\t\3\2" +
                    "\2\28=\5\f\7\29:\7\21\2\2:<\5\f\7\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3" +
                    "\2\2\2>\13\3\2\2\2?=\3\2\2\2@F\7\32\2\2AF\7\33\2\2BC\7\33\2\2CD\7\22\2" +
                    "\2DF\7\33\2\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2F\r\3\2\2\2GN\7\31\2\2HO\5" +
                    "\20\t\2IJ\5\22\n\2JK\7\25\2\2KL\7\26\2\2LO\3\2\2\2MO\5\24\13\2NH\3\2\2" +
                    "\2NI\3\2\2\2NM\3\2\2\2O\17\3\2\2\2PU\7\31\2\2QR\7\21\2\2RT\7\31\2\2SQ" +
                    "\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\21\3\2\2\2WU\3\2\2\2X]\7\31\2" +
                    "\2YZ\7\21\2\2Z\\\7\31\2\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\23" +
                    "\3\2\2\2_]\3\2\2\2`a\7\31\2\2ab\7\23\2\2bc\5\26\f\2cl\7\24\2\2de\7\21" +
                    "\2\2ef\7\31\2\2fg\7\23\2\2gh\5\26\f\2hi\7\24\2\2ik\3\2\2\2jd\3\2\2\2k" +
                    "n\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\25\3\2\2\2nl\3\2\2\2ot\7\31\2\2pq\7\21" +
                    "\2\2qs\7\31\2\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\27\3\2\2\2vt" +
                    "\3\2\2\2wy\5\32\16\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\5 \21\2{\31\3\2\2" +
                    "\2|\u0081\5\34\17\2}~\7\21\2\2~\u0080\5\34\17\2\177}\3\2\2\2\u0080\u0083" +
                    "\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\33\3\2\2\2\u0083" +
                    "\u0081\3\2\2\2\u0084\u0085\t\2\2\2\u0085\u0086\7\31\2\2\u0086\u0087\7" +
                    "\31\2\2\u0087\35\3\2\2\2\u0088\u008d\5 \21\2\u0089\u008a\7\21\2\2\u008a" +
                    "\u008c\5 \21\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2" +
                    "\2\2\u008d\u008e\3\2\2\2\u008e\37\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091" +
                    "\b\21\1\2\u0091\u0092\7\5\2\2\u0092\u00a4\5 \21\r\u0093\u00a4\7\31\2\2" +
                    "\u0094\u00a4\7\33\2\2\u0095\u00a4\7\32\2\2\u0096\u0097\7\23\2\2\u0097" +
                    "\u0098\5 \21\2\u0098\u0099\7\24\2\2\u0099\u00a4\3\2\2\2\u009a\u009b\7" +
                    "\31\2\2\u009b\u009c\7\23\2\2\u009c\u009d\5\36\20\2\u009d\u009e\7\24\2" +
                    "\2\u009e\u00a4\3\2\2\2\u009f\u00a0\7\31\2\2\u00a0\u00a1\7\25\2\2\u00a1" +
                    "\u00a2\7\33\2\2\u00a2\u00a4\7\26\2\2\u00a3\u0090\3\2\2\2\u00a3\u0093\3" +
                    "\2\2\2\u00a3\u0094\3\2\2\2\u00a3\u0095\3\2\2\2\u00a3\u0096\3\2\2\2\u00a3" +
                    "\u009a\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4\u00c5\3\2\2\2\u00a5\u00a6\f\f" +
                    "\2\2\u00a6\u00a7\7\6\2\2\u00a7\u00c4\5 \21\r\u00a8\u00a9\f\13\2\2\u00a9" +
                    "\u00aa\7\7\2\2\u00aa\u00c4\5 \21\f\u00ab\u00ac\f\n\2\2\u00ac\u00ad\7\b" +
                    "\2\2\u00ad\u00c4\5 \21\13\u00ae\u00af\f\t\2\2\u00af\u00b0\7\t\2\2\u00b0" +
                    "\u00c4\5 \21\n\u00b1\u00b2\f\b\2\2\u00b2\u00b3\7\n\2\2\u00b3\u00c4\5 " +
                    "\21\t\u00b4\u00b5\f\7\2\2\u00b5\u00b6\7\13\2\2\u00b6\u00c4\5 \21\b\u00b7" +
                    "\u00b8\f\6\2\2\u00b8\u00b9\7\f\2\2\u00b9\u00c4\5 \21\7\u00ba\u00bb\f\5" +
                    "\2\2\u00bb\u00bc\7\r\2\2\u00bc\u00c4\5 \21\6\u00bd\u00be\f\4\2\2\u00be" +
                    "\u00bf\7\16\2\2\u00bf\u00c4\5 \21\5\u00c0\u00c1\f\3\2\2\u00c1\u00c2\7" +
                    "\17\2\2\u00c2\u00c4\5 \21\4\u00c3\u00a5\3\2\2\2\u00c3\u00a8\3\2\2\2\u00c3" +
                    "\u00ab\3\2\2\2\u00c3\u00ae\3\2\2\2\u00c3\u00b1\3\2\2\2\u00c3\u00b4\3\2" +
                    "\2\2\u00c3\u00b7\3\2\2\2\u00c3\u00ba\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3" +
                    "\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2" +
                    "\2\2\u00c6!\3\2\2\2\u00c7\u00c5\3\2\2\2\21\',=ENU]ltx\u0081\u008d\u00a3" +
                    "\u00c3\u00c5";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'存在'", "'�?�?'", null, null, null, null, null, null, null, null,
            null, null, null, "';'", "','", "'..'", "'('", "')'", "'['", "']'", "'{'",
            "'}'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "Existential", "Universal", "NOT", "ART1", "ART2", "CMP1", "CMP2",
            "CMP3", "CMP4", "LOG1", "LOG2", "XOR", "IMPLY", "SEMI", "COMMA", "RANGE",
            "LeftParen", "RightParen", "LeftBracket", "RightBracket", "LeftBrace",
            "RightBrace", "ID", "Literal", "Number", "Whitespace", "Newline", "BlockComment",
            "LineComment"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public PrologParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Prolog.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final StartContext start() throws RecognitionException {
        StartContext _localctx = new StartContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_start);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(32);
                definitions();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefinitionsContext definitions() throws RecognitionException {
        DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_definitions);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(35);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(34);
                            definition();
                        }
                    }
                    setState(37);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Existential) | (1L << Universal) | (1L << NOT) | (1L << LeftParen) | (1L << ID) | (1L << Literal) | (1L << Number))) != 0));
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefinitionContext definition() throws RecognitionException {
        DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_definition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(42);
                switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                    case 1: {
                        setState(39);
                        setDef();
                    }
                    break;
                    case 2: {
                        setState(40);
                        variableDef();
                    }
                    break;
                    case 3: {
                        setState(41);
                        conditionDef();
                    }
                    break;
                }
                setState(44);
                match(SEMI);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SetDefContext setDef() throws RecognitionException {
        SetDefContext _localctx = new SetDefContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_setDef);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(46);
                ((SetDefContext) _localctx).type = match(ID);
                setState(47);
                match(LeftBrace);
                setState(48);
                match(RightBrace);
                setState(49);
                match(CMP3);
                setState(50);
                match(LeftBrace);
                setState(51);
                setParams();
                setState(52);
                match(RightBrace);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SetParamsContext setParams() throws RecognitionException {
        SetParamsContext _localctx = new SetParamsContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_setParams);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(54);
                setParam();
                setState(59);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(55);
                            match(COMMA);
                            setState(56);
                            setParam();
                        }
                    }
                    setState(61);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SetParamContext setParam() throws RecognitionException {
        SetParamContext _localctx = new SetParamContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_setParam);
        try {
            setState(67);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(62);
                    ((SetParamContext) _localctx).string = match(Literal);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(63);
                    ((SetParamContext) _localctx).num = match(Number);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(64);
                    ((SetParamContext) _localctx).lower = match(Number);
                    setState(65);
                    match(RANGE);
                    setState(66);
                    ((SetParamContext) _localctx).upper = match(Number);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VariableDefContext variableDef() throws RecognitionException {
        VariableDefContext _localctx = new VariableDefContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_variableDef);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(69);
                ((VariableDefContext) _localctx).type = match(ID);
                setState(76);
                switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                    case 1: {
                        setState(70);
                        vDef1();
                    }
                    break;
                    case 2: {
                        setState(71);
                        vDef2();
                        setState(72);
                        match(LeftBracket);
                        setState(73);
                        match(RightBracket);
                    }
                    break;
                    case 3: {
                        setState(75);
                        vDef3();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VDef1Context vDef1() throws RecognitionException {
        VDef1Context _localctx = new VDef1Context(_ctx, getState());
        enterRule(_localctx, 14, RULE_vDef1);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(78);
                ((VDef1Context) _localctx).id = match(ID);
                setState(83);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(79);
                            match(COMMA);
                            setState(80);
                            ((VDef1Context) _localctx).id = match(ID);
                        }
                    }
                    setState(85);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VDef2Context vDef2() throws RecognitionException {
        VDef2Context _localctx = new VDef2Context(_ctx, getState());
        enterRule(_localctx, 16, RULE_vDef2);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                ((VDef2Context) _localctx).id = match(ID);
                setState(91);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(87);
                            match(COMMA);
                            setState(88);
                            ((VDef2Context) _localctx).id = match(ID);
                        }
                    }
                    setState(93);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VDef3Context vDef3() throws RecognitionException {
        VDef3Context _localctx = new VDef3Context(_ctx, getState());
        enterRule(_localctx, 18, RULE_vDef3);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(94);
                ((VDef3Context) _localctx).id = match(ID);
                setState(95);
                match(LeftParen);
                setState(96);
                typeParams();
                setState(97);
                match(RightParen);
                setState(106);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(98);
                            match(COMMA);
                            setState(99);
                            ((VDef3Context) _localctx).id = match(ID);
                            setState(100);
                            match(LeftParen);
                            setState(101);
                            typeParams();
                            setState(102);
                            match(RightParen);
                        }
                    }
                    setState(108);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeParamsContext typeParams() throws RecognitionException {
        TypeParamsContext _localctx = new TypeParamsContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_typeParams);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(109);
                match(ID);
                setState(114);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(110);
                            match(COMMA);
                            setState(111);
                            match(ID);
                        }
                    }
                    setState(116);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConditionDefContext conditionDef() throws RecognitionException {
        ConditionDefContext _localctx = new ConditionDefContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_conditionDef);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(118);
                _la = _input.LA(1);
                if (_la == Existential || _la == Universal) {
                    {
                        setState(117);
                        quantifiers();
                    }
                }

                setState(120);
                expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final QuantifiersContext quantifiers() throws RecognitionException {
        QuantifiersContext _localctx = new QuantifiersContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_quantifiers);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(122);
                quantifier();
                setState(127);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(123);
                            match(COMMA);
                            setState(124);
                            quantifier();
                        }
                    }
                    setState(129);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final QuantifierContext quantifier() throws RecognitionException {
        QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_quantifier);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(130);
                _la = _input.LA(1);
                if (!(_la == Existential || _la == Universal)) {
                    _errHandler.recoverInline(this);
                } else {
                    consume();
                }
                setState(131);
                ((QuantifierContext) _localctx).type = match(ID);
                setState(132);
                ((QuantifierContext) _localctx).id = match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ParametersContext parameters() throws RecognitionException {
        ParametersContext _localctx = new ParametersContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_parameters);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(134);
                expression(0);
                setState(139);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(135);
                            match(COMMA);
                            setState(136);
                            expression(0);
                        }
                    }
                    setState(141);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        return expression(0);
    }

    private ExpressionContext expression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
        ExpressionContext _prevctx = _localctx;
        int _startState = 30;
        enterRecursionRule(_localctx, 30, RULE_expression, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(161);
                switch (getInterpreter().adaptivePredict(_input, 12, _ctx)) {
                    case 1: {
                        setState(143);
                        ((ExpressionContext) _localctx).uop = match(NOT);
                        setState(144);
                        expression(11);
                    }
                    break;
                    case 2: {
                        setState(145);
                        match(ID);
                    }
                    break;
                    case 3: {
                        setState(146);
                        match(Number);
                    }
                    break;
                    case 4: {
                        setState(147);
                        match(Literal);
                    }
                    break;
                    case 5: {
                        setState(148);
                        match(LeftParen);
                        setState(149);
                        expression(0);
                        setState(150);
                        match(RightParen);
                    }
                    break;
                    case 6: {
                        setState(152);
                        ((ExpressionContext) _localctx).id = match(ID);
                        setState(153);
                        match(LeftParen);
                        setState(154);
                        parameters();
                        setState(155);
                        match(RightParen);
                    }
                    break;
                    case 7: {
                        setState(157);
                        ((ExpressionContext) _localctx).id = match(ID);
                        setState(158);
                        match(LeftBracket);
                        setState(159);
                        match(Number);
                        setState(160);
                        match(RightBracket);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(195);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(193);
                            switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                                case 1: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(163);
                                    if (!(precpred(_ctx, 10)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                                    setState(164);
                                    ((ExpressionContext) _localctx).bop = match(ART1);
                                    setState(165);
                                    expression(11);
                                }
                                break;
                                case 2: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(166);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(167);
                                    ((ExpressionContext) _localctx).bop = match(ART2);
                                    setState(168);
                                    expression(10);
                                }
                                break;
                                case 3: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(169);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(170);
                                    ((ExpressionContext) _localctx).bop = match(CMP1);
                                    setState(171);
                                    expression(9);
                                }
                                break;
                                case 4: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(172);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(173);
                                    ((ExpressionContext) _localctx).bop = match(CMP2);
                                    setState(174);
                                    expression(8);
                                }
                                break;
                                case 5: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(175);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(176);
                                    ((ExpressionContext) _localctx).bop = match(CMP3);
                                    setState(177);
                                    expression(7);
                                }
                                break;
                                case 6: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(178);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(179);
                                    ((ExpressionContext) _localctx).bop = match(CMP4);
                                    setState(180);
                                    expression(6);
                                }
                                break;
                                case 7: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(181);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(182);
                                    ((ExpressionContext) _localctx).bop = match(LOG1);
                                    setState(183);
                                    expression(5);
                                }
                                break;
                                case 8: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(184);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(185);
                                    ((ExpressionContext) _localctx).bop = match(LOG2);
                                    setState(186);
                                    expression(4);
                                }
                                break;
                                case 9: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(187);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(188);
                                    ((ExpressionContext) _localctx).bop = match(XOR);
                                    setState(189);
                                    expression(3);
                                }
                                break;
                                case 10: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(190);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(191);
                                    ((ExpressionContext) _localctx).bop = match(IMPLY);
                                    setState(192);
                                    expression(2);
                                }
                                break;
                            }
                        }
                    }
                    setState(197);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 15:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 10);
            case 1:
                return precpred(_ctx, 9);
            case 2:
                return precpred(_ctx, 8);
            case 3:
                return precpred(_ctx, 7);
            case 4:
                return precpred(_ctx, 6);
            case 5:
                return precpred(_ctx, 5);
            case 6:
                return precpred(_ctx, 4);
            case 7:
                return precpred(_ctx, 3);
            case 8:
                return precpred(_ctx, 2);
            case 9:
                return precpred(_ctx, 1);
        }
        return true;
    }

    public static class StartContext extends ParserRuleContext {
        public StartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public DefinitionsContext definitions() {
            return getRuleContext(DefinitionsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_start;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterStart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitStart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitStart(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DefinitionsContext extends ParserRuleContext {
        public DefinitionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<DefinitionContext> definition() {
            return getRuleContexts(DefinitionContext.class);
        }

        public DefinitionContext definition(int i) {
            return getRuleContext(DefinitionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_definitions;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterDefinitions(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitDefinitions(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitDefinitions(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class DefinitionContext extends ParserRuleContext {
        public DefinitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SEMI() {
            return getToken(PrologParser.SEMI, 0);
        }

        public SetDefContext setDef() {
            return getRuleContext(SetDefContext.class, 0);
        }

        public VariableDefContext variableDef() {
            return getRuleContext(VariableDefContext.class, 0);
        }

        public ConditionDefContext conditionDef() {
            return getRuleContext(ConditionDefContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_definition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterDefinition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitDefinition(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitDefinition(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SetDefContext extends ParserRuleContext {
        public Token type;

        public SetDefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> LeftBrace() {
            return getTokens(PrologParser.LeftBrace);
        }

        public TerminalNode LeftBrace(int i) {
            return getToken(PrologParser.LeftBrace, i);
        }

        public List<TerminalNode> RightBrace() {
            return getTokens(PrologParser.RightBrace);
        }

        public TerminalNode RightBrace(int i) {
            return getToken(PrologParser.RightBrace, i);
        }

        public TerminalNode CMP3() {
            return getToken(PrologParser.CMP3, 0);
        }

        public SetParamsContext setParams() {
            return getRuleContext(SetParamsContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(PrologParser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_setDef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterSetDef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitSetDef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitSetDef(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SetParamsContext extends ParserRuleContext {
        public SetParamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<SetParamContext> setParam() {
            return getRuleContexts(SetParamContext.class);
        }

        public SetParamContext setParam(int i) {
            return getRuleContext(SetParamContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PrologParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PrologParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_setParams;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterSetParams(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitSetParams(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitSetParams(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class SetParamContext extends ParserRuleContext {
        public Token string;
        public Token num;
        public Token lower;
        public Token upper;

        public SetParamContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Literal() {
            return getToken(PrologParser.Literal, 0);
        }

        public List<TerminalNode> Number() {
            return getTokens(PrologParser.Number);
        }

        public TerminalNode Number(int i) {
            return getToken(PrologParser.Number, i);
        }

        public TerminalNode RANGE() {
            return getToken(PrologParser.RANGE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_setParam;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterSetParam(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitSetParam(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitSetParam(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VariableDefContext extends ParserRuleContext {
        public Token type;

        public VariableDefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(PrologParser.ID, 0);
        }

        public VDef1Context vDef1() {
            return getRuleContext(VDef1Context.class, 0);
        }

        public VDef2Context vDef2() {
            return getRuleContext(VDef2Context.class, 0);
        }

        public TerminalNode LeftBracket() {
            return getToken(PrologParser.LeftBracket, 0);
        }

        public TerminalNode RightBracket() {
            return getToken(PrologParser.RightBracket, 0);
        }

        public VDef3Context vDef3() {
            return getRuleContext(VDef3Context.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableDef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterVariableDef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitVariableDef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitVariableDef(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VDef1Context extends ParserRuleContext {
        public Token id;

        public VDef1Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> ID() {
            return getTokens(PrologParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(PrologParser.ID, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PrologParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PrologParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vDef1;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterVDef1(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitVDef1(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitVDef1(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VDef2Context extends ParserRuleContext {
        public Token id;

        public VDef2Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> ID() {
            return getTokens(PrologParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(PrologParser.ID, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PrologParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PrologParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vDef2;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterVDef2(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitVDef2(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitVDef2(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class VDef3Context extends ParserRuleContext {
        public Token id;

        public VDef3Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> LeftParen() {
            return getTokens(PrologParser.LeftParen);
        }

        public TerminalNode LeftParen(int i) {
            return getToken(PrologParser.LeftParen, i);
        }

        public List<TypeParamsContext> typeParams() {
            return getRuleContexts(TypeParamsContext.class);
        }

        public TypeParamsContext typeParams(int i) {
            return getRuleContext(TypeParamsContext.class, i);
        }

        public List<TerminalNode> RightParen() {
            return getTokens(PrologParser.RightParen);
        }

        public TerminalNode RightParen(int i) {
            return getToken(PrologParser.RightParen, i);
        }

        public List<TerminalNode> ID() {
            return getTokens(PrologParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(PrologParser.ID, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PrologParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PrologParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vDef3;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterVDef3(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitVDef3(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitVDef3(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class TypeParamsContext extends ParserRuleContext {
        public TypeParamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> ID() {
            return getTokens(PrologParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(PrologParser.ID, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PrologParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PrologParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeParams;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterTypeParams(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitTypeParams(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitTypeParams(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ConditionDefContext extends ParserRuleContext {
        public ConditionDefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public QuantifiersContext quantifiers() {
            return getRuleContext(QuantifiersContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conditionDef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterConditionDef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitConditionDef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitConditionDef(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class QuantifiersContext extends ParserRuleContext {
        public QuantifiersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<QuantifierContext> quantifier() {
            return getRuleContexts(QuantifierContext.class);
        }

        public QuantifierContext quantifier(int i) {
            return getRuleContext(QuantifierContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PrologParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PrologParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_quantifiers;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterQuantifiers(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitQuantifiers(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitQuantifiers(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class QuantifierContext extends ParserRuleContext {
        public Token type;
        public Token id;

        public QuantifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Existential() {
            return getToken(PrologParser.Existential, 0);
        }

        public TerminalNode Universal() {
            return getToken(PrologParser.Universal, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(PrologParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(PrologParser.ID, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_quantifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterQuantifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitQuantifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitQuantifier(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ParametersContext extends ParserRuleContext {
        public ParametersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PrologParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PrologParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameters;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterParameters(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitParameters(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitParameters(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public Token uop;
        public Token id;
        public Token bop;

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode NOT() {
            return getToken(PrologParser.NOT, 0);
        }

        public TerminalNode ID() {
            return getToken(PrologParser.ID, 0);
        }

        public TerminalNode Number() {
            return getToken(PrologParser.Number, 0);
        }

        public TerminalNode Literal() {
            return getToken(PrologParser.Literal, 0);
        }

        public TerminalNode LeftParen() {
            return getToken(PrologParser.LeftParen, 0);
        }

        public TerminalNode RightParen() {
            return getToken(PrologParser.RightParen, 0);
        }

        public ParametersContext parameters() {
            return getRuleContext(ParametersContext.class, 0);
        }

        public TerminalNode LeftBracket() {
            return getToken(PrologParser.LeftBracket, 0);
        }

        public TerminalNode RightBracket() {
            return getToken(PrologParser.RightBracket, 0);
        }

        public TerminalNode ART1() {
            return getToken(PrologParser.ART1, 0);
        }

        public TerminalNode ART2() {
            return getToken(PrologParser.ART2, 0);
        }

        public TerminalNode CMP1() {
            return getToken(PrologParser.CMP1, 0);
        }

        public TerminalNode CMP2() {
            return getToken(PrologParser.CMP2, 0);
        }

        public TerminalNode CMP3() {
            return getToken(PrologParser.CMP3, 0);
        }

        public TerminalNode CMP4() {
            return getToken(PrologParser.CMP4, 0);
        }

        public TerminalNode LOG1() {
            return getToken(PrologParser.LOG1, 0);
        }

        public TerminalNode LOG2() {
            return getToken(PrologParser.LOG2, 0);
        }

        public TerminalNode XOR() {
            return getToken(PrologParser.XOR, 0);
        }

        public TerminalNode IMPLY() {
            return getToken(PrologParser.IMPLY, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PrologListener) ((PrologListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PrologVisitor) return ((PrologVisitor<? extends T>) visitor).visitExpression(this);
            else return visitor.visitChildren(this);
        }
    }
}