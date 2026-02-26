// Generated from LLogo.g4 by ANTLR 4.9.1

package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LLogoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LLogoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Sequence}
	 * labeled alternative in {@link LLogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(LLogoParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link LLogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(LLogoParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetFun}
	 * labeled alternative in {@link LLogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetFun(LLogoParser.LetFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetRec}
	 * labeled alternative in {@link LLogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetRec(LLogoParser.LetRecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetPair}
	 * labeled alternative in {@link LLogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetPair(LLogoParser.LetPairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseExpr}
	 * labeled alternative in {@link LLogoParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseExpr(LLogoParser.BaseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(LLogoParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PenDown}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenDown(LLogoParser.PenDownContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(LLogoParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cond}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(LLogoParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PenUp}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPenUp(LLogoParser.PenUpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Left}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft(LLogoParser.LeftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(LLogoParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(LLogoParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fst}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFst(LLogoParser.FstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Snd}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSnd(LLogoParser.SndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Right}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight(LLogoParser.RightContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lt}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLt(LLogoParser.LtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Eq}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(LLogoParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Gt}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGt(LLogoParser.GtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Case}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase(LLogoParser.CaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(LLogoParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Backward}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackward(LLogoParser.BackwardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(LLogoParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Forward}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForward(LLogoParser.ForwardContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetCol}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCol(LLogoParser.SetColContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Gte}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGte(LLogoParser.GteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RandCol}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRandCol(LLogoParser.RandColContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(LLogoParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lte}
	 * labeled alternative in {@link LLogoParser#base_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLte(LLogoParser.LteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cons}
	 * labeled alternative in {@link LLogoParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(LLogoParser.ConsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AppExpr}
	 * labeled alternative in {@link LLogoParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppExpr(LLogoParser.AppExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Fact}
	 * labeled alternative in {@link LLogoParser#app}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact(LLogoParser.FactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link LLogoParser#app}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(LLogoParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lambda}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(LLogoParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Rec}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRec(LLogoParser.RecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(LLogoParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LLogoParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(LLogoParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(LLogoParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ColourLit}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColourLit(LLogoParser.ColourLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unit}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(LLogoParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyList(LLogoParser.EmptyListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pair}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(LLogoParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link LLogoParser#prim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(LLogoParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Red}
	 * labeled alternative in {@link LLogoParser#colour}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRed(LLogoParser.RedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Blue}
	 * labeled alternative in {@link LLogoParser#colour}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlue(LLogoParser.BlueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Green}
	 * labeled alternative in {@link LLogoParser#colour}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreen(LLogoParser.GreenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pink}
	 * labeled alternative in {@link LLogoParser#colour}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPink(LLogoParser.PinkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Black}
	 * labeled alternative in {@link LLogoParser#colour}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlack(LLogoParser.BlackContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyFun}
	 * labeled alternative in {@link LLogoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyFun(LLogoParser.TyFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyPrim}
	 * labeled alternative in {@link LLogoParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyPrim(LLogoParser.TyPrimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyInt}
	 * labeled alternative in {@link LLogoParser#prim_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyInt(LLogoParser.TyIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyBool}
	 * labeled alternative in {@link LLogoParser#prim_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyBool(LLogoParser.TyBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyColour}
	 * labeled alternative in {@link LLogoParser#prim_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyColour(LLogoParser.TyColourContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyColourList}
	 * labeled alternative in {@link LLogoParser#prim_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyColourList(LLogoParser.TyColourListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyUnit}
	 * labeled alternative in {@link LLogoParser#prim_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyUnit(LLogoParser.TyUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyProduct}
	 * labeled alternative in {@link LLogoParser#prim_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyProduct(LLogoParser.TyProductContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TyParen}
	 * labeled alternative in {@link LLogoParser#prim_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyParen(LLogoParser.TyParenContext ctx);
}