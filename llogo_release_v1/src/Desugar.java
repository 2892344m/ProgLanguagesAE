import ast.*;

public class Desugar {

    public static Expr desugarExpr(Expr expr) {
        if (expr instanceof ELetFun) {
            ELetFun e = (ELetFun) expr;
            ELambda newLam = new ELambda(e.getParam(), e.getParamTy(), desugarExpr(e.getSubject()));
            return new ELet(e.getFunctionName(), newLam, desugarExpr(e.getBody()));
        } else if (expr instanceof ELetRec) {
            ELetRec e = (ELetRec) expr;
            ERec newRec = new ERec(
                e.getFunctionName(),
                e.getParam(),
                e.getReturnTy(),
                e.getParamTy(),
                desugarExpr(e.getSubject())
            );
            return new ELet(e.getFunctionName(), newRec, desugarExpr(e.getBody()));
        } else if (expr instanceof ELetPair) {
            ELetPair e = (ELetPair) expr;
            String funName = NameSource.genFreshName();
            Expr body = Subst.subst(e.getBody(), new EFst(e.getSubject()), e.getParam1());
            body = Subst.subst(body, new ESnd(e.getSubject()), e.getParam2());
            return new ELet(funName, desugarExpr(e.getSubject()), body);
        } else if (expr instanceof EApp) {
            EApp e = (EApp) expr;
            return new EApp(desugarExpr(e.getFunction()), desugarExpr(e.getArgument()));
        } else if (expr instanceof ELambda) {
            ELambda e = (ELambda) expr;
            return new ELambda(e.getParameter(), e.getParameterType(), desugarExpr(e.getBody()));
        } else if (expr instanceof EBinOp) {
            EBinOp e = (EBinOp) expr;
            return new EBinOp(desugarExpr(e.getE1()), e.getOp(), desugarExpr(e.getE2()));
        } else if (expr instanceof ECase) {
            ECase e = (ECase) expr;
            return new ECase(desugarExpr(e.getScrutinee()), desugarExpr(e.getEmptyCase()), e.getHeadBinder(), e.getTailBinder(), desugarExpr(e.getConsCase()));
        } else if (expr instanceof ECond) {
            ECond e = (ECond) expr;
            return new ECond(desugarExpr(e.getTest()), desugarExpr(e.getThenBranch()), desugarExpr(e.getElseBranch()));
        } else if (expr instanceof ECons) {
            ECons e = (ECons) expr;
            return new ECons(desugarExpr(e.getHead()), desugarExpr(e.getTail()));
        } else if (expr instanceof EForward) {
            EForward e = (EForward) expr;
            return new EForward(desugarExpr(e.getAmount()));
        } else if (expr instanceof EBackward) {
            EBackward e = (EBackward) expr;
            return new EBackward(desugarExpr(e.getAmount()));
        } else if (expr instanceof ETurnLeft) {
            ETurnLeft e = (ETurnLeft) expr;
            return new ETurnLeft(desugarExpr(e.getAmount()));
        } else if (expr instanceof ETurnRight) {
            ETurnRight e = (ETurnRight) expr;
            return new ETurnRight(desugarExpr(e.getAmount()));
        } else if (expr instanceof EFst) {
            EFst e = (EFst) expr;
            return new EFst(desugarExpr(e.getPair()));
        } else if (expr instanceof EPair) {
            EPair e = (EPair) expr;
            return new EPair(desugarExpr(e.getFirst()), desugarExpr(e.getSecond()));
        } else if (expr instanceof ERandCol) {
            ERandCol e = (ERandCol) expr;
            return new ERandCol(desugarExpr(e.getColourList()));
        } else if (expr instanceof ERec) {
            ERec e = (ERec) expr;
            return new ERec(e.getFunName(), e.getArgName(), e.getArgType(), e.getResultType(), desugarExpr(e.getBody()));
        } else if (expr instanceof ESequence) {
            ESequence e = (ESequence) expr;
            return new ESequence(desugarExpr(e.getE1()), desugarExpr(e.getE2()));
        } else if (expr instanceof ESetCol) {
            ESetCol e = (ESetCol) expr;
            return new ESetCol(desugarExpr(e.getColour()));
        } else if (expr instanceof ESnd) {
            ESnd e = (ESnd) expr;
            return new ESnd(desugarExpr(e.getPair()));
        } else  if (expr instanceof ELet) {
            ELet e = (ELet) expr;
            return new ELet(e.getBinder(), desugarExpr(e.getSubject()), desugarExpr(e.getContinuation()));
        } else {
            return expr;
        }
    }

}
