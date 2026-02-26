import antlr.*;
import antlr.LLogoParser.*;
import ast.*;
import ast.EBinOp.Op;
import org.antlr.v4.runtime.tree.ParseTree;

public class LLogoASTGeneratorVisitor {

    private class LLogoTypeVisitor extends LLogoBaseVisitor<Type> {

        @Override
        public Type visitTyBool(TyBoolContext ctx) {
            return TyBool.type();
        }

        @Override
        public Type visitTyColour(TyColourContext ctx) {
            return TyColour.type();
        }

        @Override
        public Type visitTyColourList(TyColourListContext ctx) {
            return TyColourList.type();
        }

        @Override
        public Type visitTyFun(TyFunContext ctx) {
            Type paramType = visit(ctx.prim_type());
            Type returnType = visit(ctx.type());
            return new TyFun(paramType, returnType);
        }

        @Override
        public Type visitTyInt(TyIntContext ctx) {
            return TyInt.type();
        }

        @Override
        public Type visitTyParen(TyParenContext ctx) {
            return visit(ctx.type());
        }

        @Override
        public Type visitTyPrim(TyPrimContext ctx) {
            return visit(ctx.prim_type());
        }

        @Override
        public Type visitTyProduct(TyProductContext ctx) {
            Type type1 = visit(ctx.type(0));
            Type type2 = visit(ctx.type(1));
            return new TyPair(type1, type2);
        }

        @Override
        public Type visitTyUnit(TyUnitContext ctx) {
            return TyUnit.type();
        }

    }

    private class LLogoExprVisitor extends LLogoBaseVisitor<Expr> {

        @Override
        public Expr visitAdd(AddContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.ADD, e2);
        }

        @Override
        public Expr visitAnd(AndContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.AND, e2);
        }

        @Override
        public Expr visitAppExpr(AppExprContext ctx) {
            return visit(ctx.app());
        }

        @Override
        public Expr visitApplication(ApplicationContext ctx) {
            Expr function = visit(ctx.app());
                Expr argument = visit(ctx.base_expr());
            return new EApp(function, argument);
        }

        @Override
        public Expr visitBackward(BackwardContext ctx) {
            Expr amount = visit(ctx.expr());
            return new EBackward(amount);
        }

        @Override
        public Expr visitBaseExpr(BaseExprContext ctx) {
            return visit(ctx.base_expr());
        }

        @Override
        public Expr visitBlack(BlackContext ctx) {
            return new EColour(Colour.BLACK);
        }

        @Override
        public Expr visitBlue(BlueContext ctx) {
            return new EColour(Colour.BLUE);
        }

        @Override
        public Expr visitColourLit(ColourLitContext ctx) {
            return visit(ctx.colour());
        }

        @Override
        public Expr visitCond(CondContext ctx) {
            Expr test = visit(ctx.base_expr());
            Expr thenBranch = visit(ctx.expr(0));
            Expr elseBranch = visit(ctx.expr(1));
            return new ECond(test, thenBranch, elseBranch);
        }

        @Override
        public Expr visitCons(ConsContext ctx) {
                Expr head = visit(ctx.app());
                Expr tail = visit(ctx.list());
            return new ECons(head, tail);
        }

        @Override
        public Expr visitDiv(DivContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.DIV, e2);
        }

        @Override
        public Expr visitEmptyList(EmptyListContext ctx) {
            return new ENil();
        }

        @Override
        public Expr visitEq(EqContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.EQ, e2);
        }

        @Override
        public Expr visitFact(FactContext ctx) {
            return visit(ctx.prim());
        }

        @Override
        public Expr visitFalse(FalseContext ctx) {
            return new EBool(false);
        }

        @Override
        public Expr visitForward(ForwardContext ctx) {
            Expr amount = visit(ctx.expr());
            return new EForward(amount);
        }

        @Override
        public Expr visitFst(FstContext ctx) {
            Expr pair = visit(ctx.expr());
            return new EFst(pair);
        }

        @Override
        public Expr visitGreen(GreenContext ctx) {
            return new EColour(Colour.GREEN);
        }

        @Override
        public Expr visitGt(GtContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.GT, e2);
        }

        @Override
        public Expr visitInt(IntContext ctx) {
            int value = Integer.parseInt(ctx.INT().getText());
            return new EInt(value);
        }

        @Override
        public Expr visitLambda(LambdaContext ctx) {
            String parameter = ctx.IDENT().getText();
            Type paramType = visitType(ctx.type());
            Expr body = visit(ctx.expr());
            return new ELambda(parameter, paramType, body);
        }

        @Override
        public Expr visitLeft(LeftContext ctx) {
            Expr amount = visit(ctx.expr());
            return new ETurnLeft(amount);
        }

        @Override
        public Expr visitLet(LetContext ctx) {
            String binder = ctx.IDENT().getText();
            Expr subject = visit(ctx.expr(0));
            Expr continuation = visit(ctx.expr(1));
            return new ELet(binder, subject, continuation);
        }

        @Override
        public Expr visitLetFun(LetFunContext ctx) {
            String functionName = ctx.IDENT(0).getText();
            String param = ctx.IDENT(1).getText();
            Type paramType = visitType(ctx.type());
            Expr subject = visit(ctx.expr(0));
            Expr body = visit(ctx.expr(1));
            return new ELetFun(functionName, param, paramType, subject, body);
        }

        @Override
        public Expr visitLetPair(LetPairContext ctx) {
            String param1 = ctx.IDENT(0).getText();
            String param2 = ctx.IDENT(1).getText();
            Expr subject = visit(ctx.expr(0));
            Expr body = visit(ctx.expr(1));
            return new ELetPair(param1, param2, subject, body);
        }

        @Override
        public Expr visitLetRec(LetRecContext ctx) {
            String functionName = ctx.IDENT(0).getText();
            String param = ctx.IDENT(1).getText();
            Type paramType = visitType(ctx.type(0));
            Type returnType = visitType(ctx.type(1));
            Expr subject = visit(ctx.expr(0));
            Expr body = visit(ctx.expr(1));
            return new ELetRec(functionName, param, paramType, returnType, subject, body);
        }

        @Override
        public Expr visitLt(LtContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.LT, e2);
        }

        @Override
        public Expr visitLte(LteContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.LTE, e2);
        }

        @Override
        public Expr visitGte(GteContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.GTE, e2);
        }

        @Override
        public Expr visitMul(MulContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.MUL, e2);
        }

        @Override
        public Expr visitOr(OrContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.OR, e2);
        }

        @Override
        public Expr visitPair(PairContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EPair(e1, e2);
        }

        @Override
        public Expr visitParens(ParensContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Expr visitPenDown(PenDownContext ctx) {
            return new ESetPen(true);
        }

        @Override
        public Expr visitPenUp(PenUpContext ctx) {
            return new ESetPen(false);
        }

        @Override
        public Expr visitPink(PinkContext ctx) {
            return new EColour(Colour.PINK);
        }

        @Override
        public Expr visitRandCol(RandColContext ctx) {
            Expr colourList = visit(ctx.expr());
            return new ERandCol(colourList);
        }

        @Override
        public Expr visitRec(RecContext ctx) {
            String functionName = ctx.IDENT(0).getText();
            String paramName = ctx.IDENT(1).getText();
            Type paramType = visitType(ctx.type(0));
            Type returnType = visitType(ctx.type(1));
            Expr body = visit(ctx.expr());
            return new ERec(functionName, paramName, paramType, returnType, body);
        }

        @Override
        public Expr visitRed(RedContext ctx) {
            return new EColour(Colour.RED);
        }

        @Override
        public Expr visitRight(RightContext ctx) {
            Expr amount = visit(ctx.expr());
            return new ETurnRight(amount);
        }

        @Override
        public Expr visitSequence(SequenceContext ctx) {
            Expr e1 = visit(ctx.base_expr());
            Expr e2 = visit(ctx.expr());
            return new ESequence(e1, e2);
        }

        @Override
        public Expr visitSetCol(SetColContext ctx) {
            Expr colour = visit(ctx.expr());
            return new ESetCol(colour);
        }

        @Override
        public Expr visitSnd(SndContext ctx) {
            Expr pair = visit(ctx.expr());
            return new ESnd(pair);
        }

        @Override
        public Expr visitSub(SubContext ctx) {
            Expr e1 = visit(ctx.base_expr(0));
            Expr e2 = visit(ctx.base_expr(1));
            return new EBinOp(e1, Op.SUB, e2);
        }

        @Override
        public Expr visitTrue(TrueContext ctx) {
            return new EBool(true);
        }

        @Override
        public Expr visitUnit(UnitContext ctx) {
            return new EUnit();
        }

        @Override
        public Expr visitVar(VarContext ctx) {
            String var = ctx.IDENT().getText();
            return new EVar(var);
        }

        private Type visitType(TypeContext ctx) {
            return new LLogoTypeVisitor().visit(ctx);
        }

        @Override
        public Expr visitCase(CaseContext ctx) {
            Expr scrutinee = visit(ctx.base_expr(0));
            Expr emptyCase = visit(ctx.base_expr(1));
            Expr consCase = visit(ctx.base_expr(2));
            String headBnd = ctx.IDENT(0).getText();
            String tailBnd = ctx.IDENT(1).getText();
            return new ECase(scrutinee, emptyCase, headBnd, tailBnd, consCase);
        }

    }

    public Expr visitProgram(ParseTree tree) {
        return ((new LLogoExprVisitor()).visit(tree));
    }
    
}
