import ast.*;

public class Desugar {

    public static Expr desugarExpr(Expr expr) {
        if (expr instanceof ELetFun) {
            ELetFun e = (ELetFun) expr;
            return new ELet(e.getParam(), desugarExpr(e.getSubject()), desugarExpr(e.getBody()));
        } else if (expr instanceof ELetRec) {
            ELetRec e = (ELetRec) expr;
            return new ELet(e.getParam(), desugarExpr(e.getSubject()), desugarExpr(e.getBody()));
        } else if (expr instanceof ELetPair) {
            ELetPair e = (ELetPair) expr;
            return new ELet(NameSource.genFreshName(), desugarExpr(e.getSubject()), desugarExpr(e.getBody()));
        } else {
            return expr;
        }
    }

}
