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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, OpMult=6, OpRelational=7, OpEquality=8, 
		AND=9, OR=10, MINUS=11, NOT=12, PLUS=13, BOOLEAN=14, IDENTIFIER=15, LITERAL=16, 
		WS=17, LINE_COMMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "OpMult", "OpRelational", "OpEquality", 
			"AND", "OR", "MINUS", "NOT", "PLUS", "BOOLEAN", "IDENTIFIER", "LITERAL", 
			"WS", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'?'", "':'", "'('", "')'", null, null, null, "'&&'", "'||'", 
			"'-'", "'!'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "OpMult", "OpRelational", "OpEquality", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\5\b9\n\b\3\t\3\t\3\t\3\t\5\t?\n\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17V\n\17\3\20\3\20\7\20Z\n\20\f\20\16\20]\13\20\3\21\3\21\3\21\7\21"+
		"b\n\21\f\21\16\21e\13\21\5\21g\n\21\3\22\6\22j\n\22\r\22\16\22k\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\7\23t\n\23\f\23\16\23w\13\23\3\23\3\23\3\23\3"+
		"\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\3\2\7\4\2,,\61\61\4\2>>@@\4\2\62;c|\5\2\13"+
		"\f\17\17\"\"\3\2\f\f\2\u0084\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3"+
		"\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\178\3\2\2\2\21>\3\2\2\2\23"+
		"@\3\2\2\2\25C\3\2\2\2\27F\3\2\2\2\31H\3\2\2\2\33J\3\2\2\2\35U\3\2\2\2"+
		"\37W\3\2\2\2!f\3\2\2\2#i\3\2\2\2%o\3\2\2\2\'(\7?\2\2(\4\3\2\2\2)*\7A\2"+
		"\2*\6\3\2\2\2+,\7<\2\2,\b\3\2\2\2-.\7*\2\2.\n\3\2\2\2/\60\7+\2\2\60\f"+
		"\3\2\2\2\61\62\t\2\2\2\62\16\3\2\2\2\639\t\3\2\2\64\65\7>\2\2\659\7?\2"+
		"\2\66\67\7@\2\2\679\7?\2\28\63\3\2\2\28\64\3\2\2\28\66\3\2\2\29\20\3\2"+
		"\2\2:;\7?\2\2;?\7?\2\2<=\7#\2\2=?\7?\2\2>:\3\2\2\2><\3\2\2\2?\22\3\2\2"+
		"\2@A\7(\2\2AB\7(\2\2B\24\3\2\2\2CD\7~\2\2DE\7~\2\2E\26\3\2\2\2FG\7/\2"+
		"\2G\30\3\2\2\2HI\7#\2\2I\32\3\2\2\2JK\7-\2\2K\34\3\2\2\2LM\7v\2\2MN\7"+
		"t\2\2NO\7w\2\2OV\7g\2\2PQ\7h\2\2QR\7c\2\2RS\7n\2\2ST\7u\2\2TV\7g\2\2U"+
		"L\3\2\2\2UP\3\2\2\2V\36\3\2\2\2W[\4c|\2XZ\t\4\2\2YX\3\2\2\2Z]\3\2\2\2"+
		"[Y\3\2\2\2[\\\3\2\2\2\\ \3\2\2\2][\3\2\2\2^g\7\62\2\2_c\4\63;\2`b\4\62"+
		";\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f^\3\2"+
		"\2\2f_\3\2\2\2g\"\3\2\2\2hj\t\5\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3"+
		"\2\2\2lm\3\2\2\2mn\b\22\2\2n$\3\2\2\2op\7\61\2\2pq\7\61\2\2qu\3\2\2\2"+
		"rt\n\6\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2"+
		"xy\7\f\2\2yz\3\2\2\2z{\b\23\2\2{&\3\2\2\2\13\28>U[cfku\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}