// Generated from O:/java_project/jProlog\Prolog.g4 by ANTLR 4.5.1
package com.bajdcc.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrologLexer extends Lexer {
    public static final int
            Existential = 1, Universal = 2, NOT = 3, ART1 = 4, ART2 = 5, CMP1 = 6, CMP2 = 7, CMP3 = 8,
            CMP4 = 9, LOG1 = 10, LOG2 = 11, XOR = 12, IMPLY = 13, SEMI = 14, COMMA = 15, RANGE = 16,
            LeftParen = 17, RightParen = 18, LeftBracket = 19, RightBracket = 20, LeftBrace = 21,
            RightBrace = 22, ID = 23, Literal = 24, Number = 25, Whitespace = 26, Newline = 27,
            BlockComment = 28, LineComment = 29;
    public static final String[] ruleNames = {
            "Existential", "Universal", "NOT", "ART1", "ART2", "CMP1", "CMP2", "CMP3",
            "CMP4", "LOG1", "LOG2", "XOR", "IMPLY", "SEMI", "COMMA", "RANGE", "LeftParen",
            "RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace",
            "ID", "Literal", "Number", "Plus", "Minus", "Star", "Div", "Mod", "Equal",
            "Less", "Greater", "DIGIT", "WORD", "Whitespace", "Newline", "BlockComment",
            "LineComment"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00f2\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t" +
                    " \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2" +
                    "\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\5\5`\n\5\3\6\3\6\5\6d\n\6\3\7" +
                    "\3\7\5\7h\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bp\n\b\3\t\3\t\3\t\3\t\5\tv\n" +
                    "\t\3\n\3\n\3\n\3\n\5\n|\n\n\3\13\3\13\3\13\5\13\u0081\n\13\3\f\3\f\3\f" +
                    "\5\f\u0086\n\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3" +
                    "\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3" +
                    "\30\3\30\7\30\u00a3\n\30\f\30\16\30\u00a6\13\30\3\31\3\31\7\31\u00aa\n" +
                    "\31\f\31\16\31\u00ad\13\31\3\31\3\31\3\32\6\32\u00b2\n\32\r\32\16\32\u00b3" +
                    "\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"" +
                    "\3#\3#\3$\3$\3%\6%\u00cb\n%\r%\16%\u00cc\3%\3%\3&\3&\5&\u00d3\n&\3&\5" +
                    "&\u00d6\n&\3&\3&\3\'\3\'\3\'\3\'\7\'\u00de\n\'\f\'\16\'\u00e1\13\'\3\'" +
                    "\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u00ec\n(\f(\16(\u00ef\13(\3(\3(\4\u00ab" +
                    "\u00df\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33" +
                    "\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\2\67\2" +
                    "9\2;\2=\2?\2A\2C\2E\2G\2I\34K\35M\36O\37\3\2\6\4\2##\u0080\u0080\7\2&" +
                    "&C\\aac|\u4e02\u9fa7\4\2\13\13\"\"\4\2\f\f\17\17\u00f9\2\3\3\2\2\2\2\5" +
                    "\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2" +
                    "\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33" +
                    "\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2" +
                    "\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2" +
                    "\63\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5U" +
                    "\3\2\2\2\7Z\3\2\2\2\t_\3\2\2\2\13c\3\2\2\2\rg\3\2\2\2\17o\3\2\2\2\21u" +
                    "\3\2\2\2\23{\3\2\2\2\25\u0080\3\2\2\2\27\u0085\3\2\2\2\31\u0087\3\2\2" +
                    "\2\33\u0089\3\2\2\2\35\u008c\3\2\2\2\37\u008e\3\2\2\2!\u0090\3\2\2\2#" +
                    "\u0093\3\2\2\2%\u0095\3\2\2\2\'\u0097\3\2\2\2)\u0099\3\2\2\2+\u009b\3" +
                    "\2\2\2-\u009d\3\2\2\2/\u009f\3\2\2\2\61\u00a7\3\2\2\2\63\u00b1\3\2\2\2" +
                    "\65\u00b5\3\2\2\2\67\u00b7\3\2\2\29\u00b9\3\2\2\2;\u00bb\3\2\2\2=\u00bd" +
                    "\3\2\2\2?\u00bf\3\2\2\2A\u00c1\3\2\2\2C\u00c3\3\2\2\2E\u00c5\3\2\2\2G" +
                    "\u00c7\3\2\2\2I\u00ca\3\2\2\2K\u00d5\3\2\2\2M\u00d9\3\2\2\2O\u00e7\3\2" +
                    "\2\2QR\7\u701d\2\2RS\7\u6a3c\2\2ST\7\u6e6c\2\2T\4\3\2\2\2UV\7\u93b7\2" +
                    "\2VW\7\uffff\2\2WX\7\u93ca\2\2XY\7\uffff\2\2Y\6\3\2\2\2Z[\t\2\2\2[\b\3" +
                    "\2\2\2\\`\59\35\2]`\5;\36\2^`\5=\37\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`" +
                    "\n\3\2\2\2ad\5\65\33\2bd\5\67\34\2ca\3\2\2\2cb\3\2\2\2d\f\3\2\2\2eh\5" +
                    "A!\2fh\5C\"\2ge\3\2\2\2gf\3\2\2\2h\16\3\2\2\2ij\5A!\2jk\5? \2kp\3\2\2" +
                    "\2lm\5C\"\2mn\5? \2np\3\2\2\2oi\3\2\2\2ol\3\2\2\2p\20\3\2\2\2qr\5? \2" +
                    "rs\5? \2sv\3\2\2\2tv\5? \2uq\3\2\2\2ut\3\2\2\2v\22\3\2\2\2wx\7#\2\2x|" +
                    "\7?\2\2yz\7>\2\2z|\7@\2\2{w\3\2\2\2{y\3\2\2\2|\24\3\2\2\2}\u0081\7(\2" +
                    "\2~\177\7(\2\2\177\u0081\7(\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0081\26" +
                    "\3\2\2\2\u0082\u0086\7~\2\2\u0083\u0084\7~\2\2\u0084\u0086\7~\2\2\u0085" +
                    "\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0086\30\3\2\2\2\u0087\u0088\7`\2\2" +
                    "\u0088\32\3\2\2\2\u0089\u008a\7/\2\2\u008a\u008b\7@\2\2\u008b\34\3\2\2" +
                    "\2\u008c\u008d\7=\2\2\u008d\36\3\2\2\2\u008e\u008f\7.\2\2\u008f \3\2\2" +
                    "\2\u0090\u0091\7\60\2\2\u0091\u0092\7\60\2\2\u0092\"\3\2\2\2\u0093\u0094" +
                    "\7*\2\2\u0094$\3\2\2\2\u0095\u0096\7+\2\2\u0096&\3\2\2\2\u0097\u0098\7" +
                    "]\2\2\u0098(\3\2\2\2\u0099\u009a\7_\2\2\u009a*\3\2\2\2\u009b\u009c\7}" +
                    "\2\2\u009c,\3\2\2\2\u009d\u009e\7\177\2\2\u009e.\3\2\2\2\u009f\u00a4\5" +
                    "G$\2\u00a0\u00a3\5G$\2\u00a1\u00a3\4\62;\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1" +
                    "\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5" +
                    "\60\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00ab\7$\2\2\u00a8\u00aa\13\2\2" +
                    "\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ab\u00a9" +
                    "\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7$\2\2\u00af" +
                    "\62\3\2\2\2\u00b0\u00b2\5E#\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2" +
                    "\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\64\3\2\2\2\u00b5\u00b6" +
                    "\7-\2\2\u00b6\66\3\2\2\2\u00b7\u00b8\7/\2\2\u00b88\3\2\2\2\u00b9\u00ba" +
                    "\7,\2\2\u00ba:\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc<\3\2\2\2\u00bd\u00be" +
                    "\7\'\2\2\u00be>\3\2\2\2\u00bf\u00c0\7?\2\2\u00c0@\3\2\2\2\u00c1\u00c2" +
                    "\7>\2\2\u00c2B\3\2\2\2\u00c3\u00c4\7@\2\2\u00c4D\3\2\2\2\u00c5\u00c6\4" +
                    "\62;\2\u00c6F\3\2\2\2\u00c7\u00c8\t\3\2\2\u00c8H\3\2\2\2\u00c9\u00cb\t" +
                    "\4\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc" +
                    "\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\b%\2\2\u00cfJ\3\2\2\2\u00d0" +
                    "\u00d2\7\17\2\2\u00d1\u00d3\7\f\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3" +
                    "\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d6\7\f\2\2\u00d5\u00d0\3\2\2\2\u00d5" +
                    "\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\b&\2\2\u00d8L\3\2\2\2\u00d9" +
                    "\u00da\7\61\2\2\u00da\u00db\7,\2\2\u00db\u00df\3\2\2\2\u00dc\u00de\13" +
                    "\2\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00e0\3\2\2\2\u00df" +
                    "\u00dd\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7," +
                    "\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\b\'\2\2\u00e6" +
                    "N\3\2\2\2\u00e7\u00e8\7\61\2\2\u00e8\u00e9\7\61\2\2\u00e9\u00ed\3\2\2" +
                    "\2\u00ea\u00ec\n\5\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb" +
                    "\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0" +
                    "\u00f1\b(\2\2\u00f1P\3\2\2\2\24\2_cgou{\u0080\u0085\u00a2\u00a4\u00ab" +
                    "\u00b3\u00cc\u00d2\u00d5\u00df\u00ed\3\b\2\2";
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
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

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

    public PrologLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}