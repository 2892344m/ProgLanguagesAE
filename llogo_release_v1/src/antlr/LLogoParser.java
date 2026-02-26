// Generated from LLogo.g4 by ANTLR 4.9.1

package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLogoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, CASE=2, OF=3, PIPE=4, DIV=5, SUB=6, ADD=7, EQ=8, BACKSLASH=9, DOT=10, 
		COMMA=11, LET=12, IN=13, REC=14, FUN=15, TRUE=16, FALSE=17, EQQ=18, AND=19, 
		OR=20, LT=21, GT=22, LTE=23, GTE=24, IF=25, THEN=26, ELSE=27, RIGHTARROW=28, 
		SEMICOLON=29, TYINT=30, TYBOOL=31, LPAREN=32, RPAREN=33, LBRACKET=34, 
		RBRACKET=35, LBRACE=36, RBRACE=37, COLONCOLON=38, COLON=39, RED=40, BLUE=41, 
		GREEN=42, PINK=43, BLACK=44, FORWARD=45, BACKWARD=46, LEFT=47, RIGHT=48, 
		PENUP=49, PENDOWN=50, SETCOL=51, RANDCOL=52, FST=53, SND=54, TYCOLOUR=55, 
		STAR=56, TYUNIT=57, TYCOLOURLIST=58, IDENT=59, WS=60;
	public static final int
		RULE_expr = 0, RULE_base_expr = 1, RULE_list = 2, RULE_app = 3, RULE_prim = 4, 
		RULE_colour = 5, RULE_type = 6, RULE_prim_type = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "base_expr", "list", "app", "prim", "colour", "type", "prim_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'case'", "'of'", "'|'", "'/'", "'-'", "'+'", "'='", "'\\'", 
			"'.'", "','", "'let'", "'in'", "'rec'", "'fun'", "'true'", "'false'", 
			"'=='", "'&&'", "'||'", "'<'", "'>'", "'<='", "'>='", "'if'", "'then'", 
			"'else'", "'->'", "';'", "'Int'", "'Bool'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'::'", "':'", "'red'", "'blue'", "'green'", "'pink'", 
			"'black'", "'forward'", "'backward'", "'left'", "'right'", "'penUp'", 
			"'penDown'", "'setCol'", "'randCol'", "'fst'", "'snd'", "'Colour'", "'*'", 
			"'Unit'", "'ColourList'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "CASE", "OF", "PIPE", "DIV", "SUB", "ADD", "EQ", "BACKSLASH", 
			"DOT", "COMMA", "LET", "IN", "REC", "FUN", "TRUE", "FALSE", "EQQ", "AND", 
			"OR", "LT", "GT", "LTE", "GTE", "IF", "THEN", "ELSE", "RIGHTARROW", "SEMICOLON", 
			"TYINT", "TYBOOL", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", 
			"RBRACE", "COLONCOLON", "COLON", "RED", "BLUE", "GREEN", "PINK", "BLACK", 
			"FORWARD", "BACKWARD", "LEFT", "RIGHT", "PENUP", "PENDOWN", "SETCOL", 
			"RANDCOL", "FST", "SND", "TYCOLOUR", "STAR", "TYUNIT", "TYCOLOURLIST", 
			"IDENT", "WS"
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

	@Override
	public String getGrammarFileName() { return "LLogo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LLogoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetRecContext extends ExprContext {
		public TerminalNode LET() { return getToken(LLogoParser.LET, 0); }
		public TerminalNode REC() { return getToken(LLogoParser.REC, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LLogoParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LLogoParser.IDENT, i);
		}
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public List<TerminalNode> COLON() { return getTokens(LLogoParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(LLogoParser.COLON, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public TerminalNode EQ() { return getToken(LLogoParser.EQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(LLogoParser.IN, 0); }
		public LetRecContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLetRec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetFunContext extends ExprContext {
		public TerminalNode LET() { return getToken(LLogoParser.LET, 0); }
		public TerminalNode FUN() { return getToken(LLogoParser.FUN, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LLogoParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LLogoParser.IDENT, i);
		}
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public TerminalNode COLON() { return getToken(LLogoParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public TerminalNode EQ() { return getToken(LLogoParser.EQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(LLogoParser.IN, 0); }
		public LetFunContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLetFun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseExprContext extends ExprContext {
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public BaseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitBaseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends ExprContext {
		public TerminalNode LET() { return getToken(LLogoParser.LET, 0); }
		public TerminalNode IDENT() { return getToken(LLogoParser.IDENT, 0); }
		public TerminalNode EQ() { return getToken(LLogoParser.EQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(LLogoParser.IN, 0); }
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequenceContext extends ExprContext {
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LLogoParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SequenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetPairContext extends ExprContext {
		public TerminalNode LET() { return getToken(LLogoParser.LET, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LLogoParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LLogoParser.IDENT, i);
		}
		public TerminalNode COMMA() { return getToken(LLogoParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public TerminalNode EQ() { return getToken(LLogoParser.EQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(LLogoParser.IN, 0); }
		public LetPairContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLetPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SequenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				base_expr(0);
				setState(17);
				match(SEMICOLON);
				setState(18);
				expr();
				}
				break;
			case 2:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				match(LET);
				setState(21);
				match(IDENT);
				setState(22);
				match(EQ);
				setState(23);
				expr();
				setState(24);
				match(IN);
				setState(25);
				expr();
				}
				break;
			case 3:
				_localctx = new LetFunContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				match(LET);
				setState(28);
				match(FUN);
				setState(29);
				match(IDENT);
				setState(30);
				match(LPAREN);
				setState(31);
				match(IDENT);
				setState(32);
				match(COLON);
				setState(33);
				type();
				setState(34);
				match(RPAREN);
				setState(35);
				match(EQ);
				setState(36);
				expr();
				setState(37);
				match(IN);
				setState(38);
				expr();
				}
				break;
			case 4:
				_localctx = new LetRecContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				match(LET);
				setState(41);
				match(REC);
				setState(42);
				match(IDENT);
				setState(43);
				match(LPAREN);
				setState(44);
				match(IDENT);
				setState(45);
				match(COLON);
				setState(46);
				type();
				setState(47);
				match(RPAREN);
				setState(48);
				match(COLON);
				setState(49);
				type();
				setState(50);
				match(EQ);
				setState(51);
				expr();
				setState(52);
				match(IN);
				setState(53);
				expr();
				}
				break;
			case 5:
				_localctx = new LetPairContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				match(LET);
				setState(56);
				match(LPAREN);
				setState(57);
				match(IDENT);
				setState(58);
				match(COMMA);
				setState(59);
				match(IDENT);
				setState(60);
				match(RPAREN);
				setState(61);
				match(EQ);
				setState(62);
				expr();
				setState(63);
				match(IN);
				setState(64);
				expr();
				}
				break;
			case 6:
				_localctx = new BaseExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(66);
				base_expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_exprContext extends ParserRuleContext {
		public Base_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_expr; }
	 
		public Base_exprContext() { }
		public void copyFrom(Base_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(LLogoParser.ADD, 0); }
		public AddContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PenDownContext extends Base_exprContext {
		public TerminalNode PENDOWN() { return getToken(LLogoParser.PENDOWN, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public PenDownContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitPenDown(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode SUB() { return getToken(LLogoParser.SUB, 0); }
		public SubContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondContext extends Base_exprContext {
		public TerminalNode IF() { return getToken(LLogoParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(LLogoParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(LLogoParser.LBRACE, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(LLogoParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(LLogoParser.RBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(LLogoParser.ELSE, 0); }
		public CondContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PenUpContext extends Base_exprContext {
		public TerminalNode PENUP() { return getToken(LLogoParser.PENUP, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public PenUpContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitPenUp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeftContext extends Base_exprContext {
		public TerminalNode LEFT() { return getToken(LLogoParser.LEFT, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public LeftContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLeft(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(LLogoParser.OR, 0); }
		public OrContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(LLogoParser.STAR, 0); }
		public MulContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FstContext extends Base_exprContext {
		public TerminalNode FST() { return getToken(LLogoParser.FST, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public FstContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitFst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SndContext extends Base_exprContext {
		public TerminalNode SND() { return getToken(LLogoParser.SND, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public SndContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitSnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RightContext extends Base_exprContext {
		public TerminalNode RIGHT() { return getToken(LLogoParser.RIGHT, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public RightContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitRight(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode LT() { return getToken(LLogoParser.LT, 0); }
		public LtContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode EQQ() { return getToken(LLogoParser.EQQ, 0); }
		public EqContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GtContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode GT() { return getToken(LLogoParser.GT, 0); }
		public GtContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitGt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CaseContext extends Base_exprContext {
		public TerminalNode CASE() { return getToken(LLogoParser.CASE, 0); }
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode OF() { return getToken(LLogoParser.OF, 0); }
		public TerminalNode LBRACE() { return getToken(LLogoParser.LBRACE, 0); }
		public TerminalNode LBRACKET() { return getToken(LLogoParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(LLogoParser.RBRACKET, 0); }
		public List<TerminalNode> RIGHTARROW() { return getTokens(LLogoParser.RIGHTARROW); }
		public TerminalNode RIGHTARROW(int i) {
			return getToken(LLogoParser.RIGHTARROW, i);
		}
		public TerminalNode PIPE() { return getToken(LLogoParser.PIPE, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LLogoParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LLogoParser.IDENT, i);
		}
		public TerminalNode COLONCOLON() { return getToken(LLogoParser.COLONCOLON, 0); }
		public TerminalNode RBRACE() { return getToken(LLogoParser.RBRACE, 0); }
		public CaseContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(LLogoParser.DIV, 0); }
		public DivContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BackwardContext extends Base_exprContext {
		public TerminalNode BACKWARD() { return getToken(LLogoParser.BACKWARD, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public BackwardContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitBackward(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(LLogoParser.AND, 0); }
		public AndContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForwardContext extends Base_exprContext {
		public TerminalNode FORWARD() { return getToken(LLogoParser.FORWARD, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public ForwardContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitForward(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetColContext extends Base_exprContext {
		public TerminalNode SETCOL() { return getToken(LLogoParser.SETCOL, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public SetColContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitSetCol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GteContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode GTE() { return getToken(LLogoParser.GTE, 0); }
		public GteContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitGte(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RandColContext extends Base_exprContext {
		public TerminalNode RANDCOL() { return getToken(LLogoParser.RANDCOL, 0); }
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public RandColContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitRandCol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListExprContext extends Base_exprContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListExprContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitListExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LteContext extends Base_exprContext {
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode LTE() { return getToken(LLogoParser.LTE, 0); }
		public LteContext(Base_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_exprContext base_expr() throws RecognitionException {
		return base_expr(0);
	}

	private Base_exprContext base_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Base_exprContext _localctx = new Base_exprContext(_ctx, _parentState);
		Base_exprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_base_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				{
				_localctx = new CondContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(70);
				match(IF);
				setState(71);
				match(LPAREN);
				setState(72);
				base_expr(0);
				setState(73);
				match(RPAREN);
				setState(74);
				match(LBRACE);
				setState(75);
				expr();
				setState(76);
				match(RBRACE);
				setState(77);
				match(ELSE);
				setState(78);
				match(LBRACE);
				setState(79);
				expr();
				setState(80);
				match(RBRACE);
				}
				break;
			case CASE:
				{
				_localctx = new CaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(CASE);
				setState(83);
				base_expr(0);
				setState(84);
				match(OF);
				setState(85);
				match(LBRACE);
				setState(86);
				match(LBRACKET);
				setState(87);
				match(RBRACKET);
				setState(88);
				match(RIGHTARROW);
				setState(89);
				base_expr(0);
				setState(90);
				match(PIPE);
				setState(91);
				match(IDENT);
				setState(92);
				match(COLONCOLON);
				setState(93);
				match(IDENT);
				setState(94);
				match(RIGHTARROW);
				setState(95);
				base_expr(0);
				setState(96);
				match(RBRACE);
				}
				break;
			case FST:
				{
				_localctx = new FstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(FST);
				setState(99);
				match(LPAREN);
				setState(100);
				expr();
				setState(101);
				match(RPAREN);
				}
				break;
			case SND:
				{
				_localctx = new SndContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(SND);
				setState(104);
				match(LPAREN);
				setState(105);
				expr();
				setState(106);
				match(RPAREN);
				}
				break;
			case FORWARD:
				{
				_localctx = new ForwardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(FORWARD);
				setState(109);
				match(LPAREN);
				setState(110);
				expr();
				setState(111);
				match(RPAREN);
				}
				break;
			case BACKWARD:
				{
				_localctx = new BackwardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(BACKWARD);
				setState(114);
				match(LPAREN);
				setState(115);
				expr();
				setState(116);
				match(RPAREN);
				}
				break;
			case LEFT:
				{
				_localctx = new LeftContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(LEFT);
				setState(119);
				match(LPAREN);
				setState(120);
				expr();
				setState(121);
				match(RPAREN);
				}
				break;
			case RIGHT:
				{
				_localctx = new RightContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(RIGHT);
				setState(124);
				match(LPAREN);
				setState(125);
				expr();
				setState(126);
				match(RPAREN);
				}
				break;
			case PENUP:
				{
				_localctx = new PenUpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(PENUP);
				setState(129);
				match(LPAREN);
				setState(130);
				match(RPAREN);
				}
				break;
			case PENDOWN:
				{
				_localctx = new PenDownContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(PENDOWN);
				setState(132);
				match(LPAREN);
				setState(133);
				match(RPAREN);
				}
				break;
			case SETCOL:
				{
				_localctx = new SetColContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(SETCOL);
				setState(135);
				match(LPAREN);
				setState(136);
				expr();
				setState(137);
				match(RPAREN);
				}
				break;
			case RANDCOL:
				{
				_localctx = new RandColContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(RANDCOL);
				setState(140);
				match(LPAREN);
				setState(141);
				expr();
				setState(142);
				match(RPAREN);
				}
				break;
			case INT:
			case BACKSLASH:
			case REC:
			case TRUE:
			case FALSE:
			case LPAREN:
			case LBRACKET:
			case RED:
			case BLUE:
			case GREEN:
			case PINK:
			case BLACK:
			case IDENT:
				{
				_localctx = new ListExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DivContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(147);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(148);
						match(DIV);
						setState(149);
						base_expr(25);
						}
						break;
					case 2:
						{
						_localctx = new MulContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(150);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(151);
						match(STAR);
						setState(152);
						base_expr(24);
						}
						break;
					case 3:
						{
						_localctx = new AddContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(153);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(154);
						match(ADD);
						setState(155);
						base_expr(23);
						}
						break;
					case 4:
						{
						_localctx = new SubContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(156);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(157);
						match(SUB);
						setState(158);
						base_expr(22);
						}
						break;
					case 5:
						{
						_localctx = new EqContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(159);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(160);
						match(EQQ);
						setState(161);
						base_expr(21);
						}
						break;
					case 6:
						{
						_localctx = new LtContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(162);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(163);
						match(LT);
						setState(164);
						base_expr(20);
						}
						break;
					case 7:
						{
						_localctx = new GtContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(165);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(166);
						match(GT);
						setState(167);
						base_expr(19);
						}
						break;
					case 8:
						{
						_localctx = new LteContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(168);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(169);
						match(LTE);
						setState(170);
						base_expr(18);
						}
						break;
					case 9:
						{
						_localctx = new GteContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(171);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(172);
						match(GTE);
						setState(173);
						base_expr(17);
						}
						break;
					case 10:
						{
						_localctx = new AndContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(174);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(175);
						match(AND);
						setState(176);
						base_expr(16);
						}
						break;
					case 11:
						{
						_localctx = new OrContext(new Base_exprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_base_expr);
						setState(177);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(178);
						match(OR);
						setState(179);
						base_expr(15);
						}
						break;
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	 
		public ListContext() { }
		public void copyFrom(ListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConsContext extends ListContext {
		public AppContext app() {
			return getRuleContext(AppContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(LLogoParser.COLONCOLON, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ConsContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AppExprContext extends ListContext {
		public AppContext app() {
			return getRuleContext(AppContext.class,0);
		}
		public AppExprContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitAppExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_list);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new ConsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				app(0);
				setState(186);
				match(COLONCOLON);
				setState(187);
				list();
				}
				break;
			case 2:
				_localctx = new AppExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				app(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AppContext extends ParserRuleContext {
		public AppContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_app; }
	 
		public AppContext() { }
		public void copyFrom(AppContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactContext extends AppContext {
		public PrimContext prim() {
			return getRuleContext(PrimContext.class,0);
		}
		public FactContext(AppContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitFact(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplicationContext extends AppContext {
		public AppContext app() {
			return getRuleContext(AppContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public Base_exprContext base_expr() {
			return getRuleContext(Base_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public ApplicationContext(AppContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppContext app() throws RecognitionException {
		return app(0);
	}

	private AppContext app(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AppContext _localctx = new AppContext(_ctx, _parentState);
		AppContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_app, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FactContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(193);
			prim();
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ApplicationContext(new AppContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_app);
					setState(195);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(196);
					match(LPAREN);
					setState(197);
					base_expr(0);
					setState(198);
					match(RPAREN);
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimContext extends ParserRuleContext {
		public PrimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prim; }
	 
		public PrimContext() { }
		public void copyFrom(PrimContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyListContext extends PrimContext {
		public TerminalNode LBRACKET() { return getToken(LLogoParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(LLogoParser.RBRACKET, 0); }
		public EmptyListContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitEmptyList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RecContext extends PrimContext {
		public TerminalNode REC() { return getToken(LLogoParser.REC, 0); }
		public List<TerminalNode> IDENT() { return getTokens(LLogoParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LLogoParser.IDENT, i);
		}
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public List<TerminalNode> COLON() { return getTokens(LLogoParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(LLogoParser.COLON, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public TerminalNode DOT() { return getToken(LLogoParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RecContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitRec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends PrimContext {
		public TerminalNode IDENT() { return getToken(LLogoParser.IDENT, 0); }
		public VarContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends PrimContext {
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public ParensContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColourLitContext extends PrimContext {
		public ColourContext colour() {
			return getRuleContext(ColourContext.class,0);
		}
		public ColourLitContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitColourLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends PrimContext {
		public TerminalNode TRUE() { return getToken(LLogoParser.TRUE, 0); }
		public TrueContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends PrimContext {
		public TerminalNode FALSE() { return getToken(LLogoParser.FALSE, 0); }
		public FalseContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnitContext extends PrimContext {
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public UnitContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaContext extends PrimContext {
		public TerminalNode BACKSLASH() { return getToken(LLogoParser.BACKSLASH, 0); }
		public TerminalNode IDENT() { return getToken(LLogoParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(LLogoParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LLogoParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LambdaContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends PrimContext {
		public TerminalNode INT() { return getToken(LLogoParser.INT, 0); }
		public IntContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairContext extends PrimContext {
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public List<Base_exprContext> base_expr() {
			return getRuleContexts(Base_exprContext.class);
		}
		public Base_exprContext base_expr(int i) {
			return getRuleContext(Base_exprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(LLogoParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public PairContext(PrimContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimContext prim() throws RecognitionException {
		PrimContext _localctx = new PrimContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_prim);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new LambdaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(BACKSLASH);
				setState(206);
				match(IDENT);
				setState(207);
				match(COLON);
				setState(208);
				type();
				setState(209);
				match(DOT);
				setState(210);
				expr();
				}
				break;
			case 2:
				_localctx = new RecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(REC);
				setState(213);
				match(IDENT);
				setState(214);
				match(LPAREN);
				setState(215);
				match(IDENT);
				setState(216);
				match(COLON);
				setState(217);
				type();
				setState(218);
				match(RPAREN);
				setState(219);
				match(COLON);
				setState(220);
				type();
				setState(221);
				match(DOT);
				setState(222);
				expr();
				}
				break;
			case 3:
				_localctx = new VarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(IDENT);
				}
				break;
			case 4:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				match(INT);
				}
				break;
			case 5:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				match(TRUE);
				}
				break;
			case 6:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				match(FALSE);
				}
				break;
			case 7:
				_localctx = new ColourLitContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(228);
				colour();
				}
				break;
			case 8:
				_localctx = new UnitContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(229);
				match(LPAREN);
				setState(230);
				match(RPAREN);
				}
				break;
			case 9:
				_localctx = new EmptyListContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(231);
				match(LBRACKET);
				setState(232);
				match(RBRACKET);
				}
				break;
			case 10:
				_localctx = new PairContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(233);
				match(LPAREN);
				setState(234);
				base_expr(0);
				setState(235);
				match(COMMA);
				setState(236);
				base_expr(0);
				setState(237);
				match(RPAREN);
				}
				break;
			case 11:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(239);
				match(LPAREN);
				setState(240);
				expr();
				setState(241);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColourContext extends ParserRuleContext {
		public ColourContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colour; }
	 
		public ColourContext() { }
		public void copyFrom(ColourContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RedContext extends ColourContext {
		public TerminalNode RED() { return getToken(LLogoParser.RED, 0); }
		public RedContext(ColourContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitRed(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PinkContext extends ColourContext {
		public TerminalNode PINK() { return getToken(LLogoParser.PINK, 0); }
		public PinkContext(ColourContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitPink(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlueContext extends ColourContext {
		public TerminalNode BLUE() { return getToken(LLogoParser.BLUE, 0); }
		public BlueContext(ColourContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitBlue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlackContext extends ColourContext {
		public TerminalNode BLACK() { return getToken(LLogoParser.BLACK, 0); }
		public BlackContext(ColourContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitBlack(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreenContext extends ColourContext {
		public TerminalNode GREEN() { return getToken(LLogoParser.GREEN, 0); }
		public GreenContext(ColourContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitGreen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColourContext colour() throws RecognitionException {
		ColourContext _localctx = new ColourContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_colour);
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RED:
				_localctx = new RedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(RED);
				}
				break;
			case BLUE:
				_localctx = new BlueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(BLUE);
				}
				break;
			case GREEN:
				_localctx = new GreenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				match(GREEN);
				}
				break;
			case PINK:
				_localctx = new PinkContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				match(PINK);
				}
				break;
			case BLACK:
				_localctx = new BlackContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(249);
				match(BLACK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TyFunContext extends TypeContext {
		public Prim_typeContext prim_type() {
			return getRuleContext(Prim_typeContext.class,0);
		}
		public TerminalNode RIGHTARROW() { return getToken(LLogoParser.RIGHTARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TyFunContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyFun(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyPrimContext extends TypeContext {
		public Prim_typeContext prim_type() {
			return getRuleContext(Prim_typeContext.class,0);
		}
		public TyPrimContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyPrim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new TyFunContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				prim_type();
				setState(253);
				match(RIGHTARROW);
				setState(254);
				type();
				}
				break;
			case 2:
				_localctx = new TyPrimContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				prim_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Prim_typeContext extends ParserRuleContext {
		public Prim_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prim_type; }
	 
		public Prim_typeContext() { }
		public void copyFrom(Prim_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TyBoolContext extends Prim_typeContext {
		public TerminalNode TYBOOL() { return getToken(LLogoParser.TYBOOL, 0); }
		public TyBoolContext(Prim_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyUnitContext extends Prim_typeContext {
		public TerminalNode TYUNIT() { return getToken(LLogoParser.TYUNIT, 0); }
		public TyUnitContext(Prim_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyProductContext extends Prim_typeContext {
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode STAR() { return getToken(LLogoParser.STAR, 0); }
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public TyProductContext(Prim_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyProduct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyColourListContext extends Prim_typeContext {
		public TerminalNode TYCOLOURLIST() { return getToken(LLogoParser.TYCOLOURLIST, 0); }
		public TyColourListContext(Prim_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyColourList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyColourContext extends Prim_typeContext {
		public TerminalNode TYCOLOUR() { return getToken(LLogoParser.TYCOLOUR, 0); }
		public TyColourContext(Prim_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyColour(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyIntContext extends Prim_typeContext {
		public TerminalNode TYINT() { return getToken(LLogoParser.TYINT, 0); }
		public TyIntContext(Prim_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TyParenContext extends Prim_typeContext {
		public TerminalNode LPAREN() { return getToken(LLogoParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LLogoParser.RPAREN, 0); }
		public TyParenContext(Prim_typeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LLogoVisitor ) return ((LLogoVisitor<? extends T>)visitor).visitTyParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prim_typeContext prim_type() throws RecognitionException {
		Prim_typeContext _localctx = new Prim_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_prim_type);
		try {
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new TyIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(TYINT);
				}
				break;
			case 2:
				_localctx = new TyBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(TYBOOL);
				}
				break;
			case 3:
				_localctx = new TyColourContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				match(TYCOLOUR);
				}
				break;
			case 4:
				_localctx = new TyColourListContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				match(TYCOLOURLIST);
				}
				break;
			case 5:
				_localctx = new TyUnitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				match(TYUNIT);
				}
				break;
			case 6:
				_localctx = new TyProductContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(264);
				match(LPAREN);
				setState(265);
				type();
				setState(266);
				match(STAR);
				setState(267);
				type();
				setState(268);
				match(RPAREN);
				}
				break;
			case 7:
				_localctx = new TyParenContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(270);
				match(LPAREN);
				setState(271);
				type();
				setState(272);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return base_expr_sempred((Base_exprContext)_localctx, predIndex);
		case 3:
			return app_sempred((AppContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean base_expr_sempred(Base_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 24);
		case 1:
			return precpred(_ctx, 23);
		case 2:
			return precpred(_ctx, 22);
		case 3:
			return precpred(_ctx, 21);
		case 4:
			return precpred(_ctx, 20);
		case 5:
			return precpred(_ctx, 19);
		case 6:
			return precpred(_ctx, 18);
		case 7:
			return precpred(_ctx, 17);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 15);
		case 10:
			return precpred(_ctx, 14);
		}
		return true;
	}
	private boolean app_sempred(AppContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2F\n\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\u0094\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3\u00b7\n\3\f\3\16\3\u00ba\13\3\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\u00c1\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00cb\n\5\f\5\16"+
		"\5\u00ce\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00f6\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u00fd"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u0104\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0115\n\t\3\t\2\4\4\b\n\2\4\6\b\n\f\16"+
		"\20\2\2\2\u0141\2E\3\2\2\2\4\u0093\3\2\2\2\6\u00c0\3\2\2\2\b\u00c2\3\2"+
		"\2\2\n\u00f5\3\2\2\2\f\u00fc\3\2\2\2\16\u0103\3\2\2\2\20\u0114\3\2\2\2"+
		"\22\23\5\4\3\2\23\24\7\37\2\2\24\25\5\2\2\2\25F\3\2\2\2\26\27\7\16\2\2"+
		"\27\30\7=\2\2\30\31\7\n\2\2\31\32\5\2\2\2\32\33\7\17\2\2\33\34\5\2\2\2"+
		"\34F\3\2\2\2\35\36\7\16\2\2\36\37\7\21\2\2\37 \7=\2\2 !\7\"\2\2!\"\7="+
		"\2\2\"#\7)\2\2#$\5\16\b\2$%\7#\2\2%&\7\n\2\2&\'\5\2\2\2\'(\7\17\2\2()"+
		"\5\2\2\2)F\3\2\2\2*+\7\16\2\2+,\7\20\2\2,-\7=\2\2-.\7\"\2\2./\7=\2\2/"+
		"\60\7)\2\2\60\61\5\16\b\2\61\62\7#\2\2\62\63\7)\2\2\63\64\5\16\b\2\64"+
		"\65\7\n\2\2\65\66\5\2\2\2\66\67\7\17\2\2\678\5\2\2\28F\3\2\2\29:\7\16"+
		"\2\2:;\7\"\2\2;<\7=\2\2<=\7\r\2\2=>\7=\2\2>?\7#\2\2?@\7\n\2\2@A\5\2\2"+
		"\2AB\7\17\2\2BC\5\2\2\2CF\3\2\2\2DF\5\4\3\2E\22\3\2\2\2E\26\3\2\2\2E\35"+
		"\3\2\2\2E*\3\2\2\2E9\3\2\2\2ED\3\2\2\2F\3\3\2\2\2GH\b\3\1\2HI\7\33\2\2"+
		"IJ\7\"\2\2JK\5\4\3\2KL\7#\2\2LM\7&\2\2MN\5\2\2\2NO\7\'\2\2OP\7\35\2\2"+
		"PQ\7&\2\2QR\5\2\2\2RS\7\'\2\2S\u0094\3\2\2\2TU\7\4\2\2UV\5\4\3\2VW\7\5"+
		"\2\2WX\7&\2\2XY\7$\2\2YZ\7%\2\2Z[\7\36\2\2[\\\5\4\3\2\\]\7\6\2\2]^\7="+
		"\2\2^_\7(\2\2_`\7=\2\2`a\7\36\2\2ab\5\4\3\2bc\7\'\2\2c\u0094\3\2\2\2d"+
		"e\7\67\2\2ef\7\"\2\2fg\5\2\2\2gh\7#\2\2h\u0094\3\2\2\2ij\78\2\2jk\7\""+
		"\2\2kl\5\2\2\2lm\7#\2\2m\u0094\3\2\2\2no\7/\2\2op\7\"\2\2pq\5\2\2\2qr"+
		"\7#\2\2r\u0094\3\2\2\2st\7\60\2\2tu\7\"\2\2uv\5\2\2\2vw\7#\2\2w\u0094"+
		"\3\2\2\2xy\7\61\2\2yz\7\"\2\2z{\5\2\2\2{|\7#\2\2|\u0094\3\2\2\2}~\7\62"+
		"\2\2~\177\7\"\2\2\177\u0080\5\2\2\2\u0080\u0081\7#\2\2\u0081\u0094\3\2"+
		"\2\2\u0082\u0083\7\63\2\2\u0083\u0084\7\"\2\2\u0084\u0094\7#\2\2\u0085"+
		"\u0086\7\64\2\2\u0086\u0087\7\"\2\2\u0087\u0094\7#\2\2\u0088\u0089\7\65"+
		"\2\2\u0089\u008a\7\"\2\2\u008a\u008b\5\2\2\2\u008b\u008c\7#\2\2\u008c"+
		"\u0094\3\2\2\2\u008d\u008e\7\66\2\2\u008e\u008f\7\"\2\2\u008f\u0090\5"+
		"\2\2\2\u0090\u0091\7#\2\2\u0091\u0094\3\2\2\2\u0092\u0094\5\6\4\2\u0093"+
		"G\3\2\2\2\u0093T\3\2\2\2\u0093d\3\2\2\2\u0093i\3\2\2\2\u0093n\3\2\2\2"+
		"\u0093s\3\2\2\2\u0093x\3\2\2\2\u0093}\3\2\2\2\u0093\u0082\3\2\2\2\u0093"+
		"\u0085\3\2\2\2\u0093\u0088\3\2\2\2\u0093\u008d\3\2\2\2\u0093\u0092\3\2"+
		"\2\2\u0094\u00b8\3\2\2\2\u0095\u0096\f\32\2\2\u0096\u0097\7\7\2\2\u0097"+
		"\u00b7\5\4\3\33\u0098\u0099\f\31\2\2\u0099\u009a\7:\2\2\u009a\u00b7\5"+
		"\4\3\32\u009b\u009c\f\30\2\2\u009c\u009d\7\t\2\2\u009d\u00b7\5\4\3\31"+
		"\u009e\u009f\f\27\2\2\u009f\u00a0\7\b\2\2\u00a0\u00b7\5\4\3\30\u00a1\u00a2"+
		"\f\26\2\2\u00a2\u00a3\7\24\2\2\u00a3\u00b7\5\4\3\27\u00a4\u00a5\f\25\2"+
		"\2\u00a5\u00a6\7\27\2\2\u00a6\u00b7\5\4\3\26\u00a7\u00a8\f\24\2\2\u00a8"+
		"\u00a9\7\30\2\2\u00a9\u00b7\5\4\3\25\u00aa\u00ab\f\23\2\2\u00ab\u00ac"+
		"\7\31\2\2\u00ac\u00b7\5\4\3\24\u00ad\u00ae\f\22\2\2\u00ae\u00af\7\32\2"+
		"\2\u00af\u00b7\5\4\3\23\u00b0\u00b1\f\21\2\2\u00b1\u00b2\7\25\2\2\u00b2"+
		"\u00b7\5\4\3\22\u00b3\u00b4\f\20\2\2\u00b4\u00b5\7\26\2\2\u00b5\u00b7"+
		"\5\4\3\21\u00b6\u0095\3\2\2\2\u00b6\u0098\3\2\2\2\u00b6\u009b\3\2\2\2"+
		"\u00b6\u009e\3\2\2\2\u00b6\u00a1\3\2\2\2\u00b6\u00a4\3\2\2\2\u00b6\u00a7"+
		"\3\2\2\2\u00b6\u00aa\3\2\2\2\u00b6\u00ad\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6"+
		"\u00b3\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\5\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\5\b\5\2\u00bc\u00bd"+
		"\7(\2\2\u00bd\u00be\5\6\4\2\u00be\u00c1\3\2\2\2\u00bf\u00c1\5\b\5\2\u00c0"+
		"\u00bb\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\7\3\2\2\2\u00c2\u00c3\b\5\1\2"+
		"\u00c3\u00c4\5\n\6\2\u00c4\u00cc\3\2\2\2\u00c5\u00c6\f\4\2\2\u00c6\u00c7"+
		"\7\"\2\2\u00c7\u00c8\5\4\3\2\u00c8\u00c9\7#\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c5\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\t\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\13\2\2\u00d0\u00d1"+
		"\7=\2\2\u00d1\u00d2\7)\2\2\u00d2\u00d3\5\16\b\2\u00d3\u00d4\7\f\2\2\u00d4"+
		"\u00d5\5\2\2\2\u00d5\u00f6\3\2\2\2\u00d6\u00d7\7\20\2\2\u00d7\u00d8\7"+
		"=\2\2\u00d8\u00d9\7\"\2\2\u00d9\u00da\7=\2\2\u00da\u00db\7)\2\2\u00db"+
		"\u00dc\5\16\b\2\u00dc\u00dd\7#\2\2\u00dd\u00de\7)\2\2\u00de\u00df\5\16"+
		"\b\2\u00df\u00e0\7\f\2\2\u00e0\u00e1\5\2\2\2\u00e1\u00f6\3\2\2\2\u00e2"+
		"\u00f6\7=\2\2\u00e3\u00f6\7\3\2\2\u00e4\u00f6\7\22\2\2\u00e5\u00f6\7\23"+
		"\2\2\u00e6\u00f6\5\f\7\2\u00e7\u00e8\7\"\2\2\u00e8\u00f6\7#\2\2\u00e9"+
		"\u00ea\7$\2\2\u00ea\u00f6\7%\2\2\u00eb\u00ec\7\"\2\2\u00ec\u00ed\5\4\3"+
		"\2\u00ed\u00ee\7\r\2\2\u00ee\u00ef\5\4\3\2\u00ef\u00f0\7#\2\2\u00f0\u00f6"+
		"\3\2\2\2\u00f1\u00f2\7\"\2\2\u00f2\u00f3\5\2\2\2\u00f3\u00f4\7#\2\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00cf\3\2\2\2\u00f5\u00d6\3\2\2\2\u00f5\u00e2\3\2"+
		"\2\2\u00f5\u00e3\3\2\2\2\u00f5\u00e4\3\2\2\2\u00f5\u00e5\3\2\2\2\u00f5"+
		"\u00e6\3\2\2\2\u00f5\u00e7\3\2\2\2\u00f5\u00e9\3\2\2\2\u00f5\u00eb\3\2"+
		"\2\2\u00f5\u00f1\3\2\2\2\u00f6\13\3\2\2\2\u00f7\u00fd\7*\2\2\u00f8\u00fd"+
		"\7+\2\2\u00f9\u00fd\7,\2\2\u00fa\u00fd\7-\2\2\u00fb\u00fd\7.\2\2\u00fc"+
		"\u00f7\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2"+
		"\2\2\u00fc\u00fb\3\2\2\2\u00fd\r\3\2\2\2\u00fe\u00ff\5\20\t\2\u00ff\u0100"+
		"\7\36\2\2\u0100\u0101\5\16\b\2\u0101\u0104\3\2\2\2\u0102\u0104\5\20\t"+
		"\2\u0103\u00fe\3\2\2\2\u0103\u0102\3\2\2\2\u0104\17\3\2\2\2\u0105\u0115"+
		"\7 \2\2\u0106\u0115\7!\2\2\u0107\u0115\79\2\2\u0108\u0115\7<\2\2\u0109"+
		"\u0115\7;\2\2\u010a\u010b\7\"\2\2\u010b\u010c\5\16\b\2\u010c\u010d\7:"+
		"\2\2\u010d\u010e\5\16\b\2\u010e\u010f\7#\2\2\u010f\u0115\3\2\2\2\u0110"+
		"\u0111\7\"\2\2\u0111\u0112\5\16\b\2\u0112\u0113\7#\2\2\u0113\u0115\3\2"+
		"\2\2\u0114\u0105\3\2\2\2\u0114\u0106\3\2\2\2\u0114\u0107\3\2\2\2\u0114"+
		"\u0108\3\2\2\2\u0114\u0109\3\2\2\2\u0114\u010a\3\2\2\2\u0114\u0110\3\2"+
		"\2\2\u0115\21\3\2\2\2\fE\u0093\u00b6\u00b8\u00c0\u00cc\u00f5\u00fc\u0103"+
		"\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}