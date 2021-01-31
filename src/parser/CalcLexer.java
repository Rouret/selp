// Generated from C:/Users/lucas/Documents/IMT/lang/selp/src/parser\Calc.g4 by ANTLR 4.9
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, OpMult=7, OpRelational=8, 
		OpEquality=9, AND=10, OR=11, MINUS=12, NOT=13, PLUS=14, BOOLEAN=15, IDENTIFIER=16, 
		LITERAL=17, WS=18, LINE_COMMENT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "OpMult", "OpRelational", 
			"OpEquality", "AND", "OR", "MINUS", "NOT", "PLUS", "BOOLEAN", "IDENTIFIER", 
			"LITERAL", "WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'defun'", "')'", "'='", "'?'", "':'", null, null, null, 
			"'&&'", "'||'", "'-'", "'!'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "OpMult", "OpRelational", "OpEquality", 
			"AND", "OR", "MINUS", "NOT", "PLUS", "BOOLEAN", "IDENTIFIER", "LITERAL", 
			"WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0084\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tA\n\t\3\n\3\n\3\n"+
		"\3\n\5\nG\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20^\n\20\3\21\3\21\7\21"+
		"b\n\21\f\21\16\21e\13\21\3\22\3\22\3\22\7\22j\n\22\f\22\16\22m\13\22\5"+
		"\22o\n\22\3\23\6\23r\n\23\r\23\16\23s\3\23\3\23\3\24\3\24\3\24\3\24\7"+
		"\24|\n\24\f\24\16\24\177\13\24\3\24\3\24\3\24\3\24\2\2\25\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25\3\2\7\4\2,,\61\61\4\2>>@@\4\2\62;c|\5\2\13\f\17\17\"\"\3\2\f"+
		"\f\2\u008c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7\61\3\2\2"+
		"\2\t\63\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21@\3\2\2\2\23"+
		"F\3\2\2\2\25H\3\2\2\2\27K\3\2\2\2\31N\3\2\2\2\33P\3\2\2\2\35R\3\2\2\2"+
		"\37]\3\2\2\2!_\3\2\2\2#n\3\2\2\2%q\3\2\2\2\'w\3\2\2\2)*\7*\2\2*\4\3\2"+
		"\2\2+,\7f\2\2,-\7g\2\2-.\7h\2\2./\7w\2\2/\60\7p\2\2\60\6\3\2\2\2\61\62"+
		"\7+\2\2\62\b\3\2\2\2\63\64\7?\2\2\64\n\3\2\2\2\65\66\7A\2\2\66\f\3\2\2"+
		"\2\678\7<\2\28\16\3\2\2\29:\t\2\2\2:\20\3\2\2\2;A\t\3\2\2<=\7>\2\2=A\7"+
		"?\2\2>?\7@\2\2?A\7?\2\2@;\3\2\2\2@<\3\2\2\2@>\3\2\2\2A\22\3\2\2\2BC\7"+
		"?\2\2CG\7?\2\2DE\7#\2\2EG\7?\2\2FB\3\2\2\2FD\3\2\2\2G\24\3\2\2\2HI\7("+
		"\2\2IJ\7(\2\2J\26\3\2\2\2KL\7~\2\2LM\7~\2\2M\30\3\2\2\2NO\7/\2\2O\32\3"+
		"\2\2\2PQ\7#\2\2Q\34\3\2\2\2RS\7-\2\2S\36\3\2\2\2TU\7v\2\2UV\7t\2\2VW\7"+
		"w\2\2W^\7g\2\2XY\7h\2\2YZ\7c\2\2Z[\7n\2\2[\\\7u\2\2\\^\7g\2\2]T\3\2\2"+
		"\2]X\3\2\2\2^ \3\2\2\2_c\4c|\2`b\t\4\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2"+
		"cd\3\2\2\2d\"\3\2\2\2ec\3\2\2\2fo\7\62\2\2gk\4\63;\2hj\4\62;\2ih\3\2\2"+
		"\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2lo\3\2\2\2mk\3\2\2\2nf\3\2\2\2ng\3\2\2"+
		"\2o$\3\2\2\2pr\t\5\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2"+
		"\2uv\b\23\2\2v&\3\2\2\2wx\7\61\2\2xy\7\61\2\2y}\3\2\2\2z|\n\6\2\2{z\3"+
		"\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0081\7\f\2\2\u0081\u0082\3\2\2\2\u0082\u0083\b\24\2\2\u0083(\3\2\2\2"+
		"\13\2@F]ckns}\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}