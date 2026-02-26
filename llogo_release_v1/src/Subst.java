import ast.*;

public class Subst {

    private static String swapVar(String var, String var1, String var2) {
        if (var.equals(var1)) {
            return var2;
        } else if (var.equals(var2)) {
            return var1;
        } else {
            return var;
        }
    }
    public static Expr swap(Expr expr, String varFrom, String varTo) {
       if (expr instanceof EInt) {
            EInt e = (EInt) expr;
            return new EInt(e.getValue());
        } else if (expr instanceof EBool) {
            EBool e = (EBool) expr;
            return new EBool(e.getValue());
        } else if (expr instanceof EUnit) {
            return new EUnit();
        } else if (expr instanceof EVar) {
            EVar e = (EVar) expr;
            return new EVar(swapVar(e.getVar(), varFrom, varTo));
        } else if (expr instanceof EBinOp) {
            EBinOp e = (EBinOp) expr;
            return new EBinOp(swap(e.getE1(), varFrom, varTo), e.getOp(), swap(e.getE2(), varFrom, varTo));
        } else if (expr instanceof EApp) {
            EApp e = (EApp) expr;
            return new EApp(swap(e.getFunction(), varFrom, varTo), swap(e.getArgument(), varFrom, varTo));
        } else if (expr instanceof ELambda) {
            ELambda e = (ELambda) expr;
            return new ELambda(swapVar(e.getParameter(), varFrom, varTo),
                e.getParameterType(),
                swap(e.getBody(), varFrom, varTo));
        } else if (expr instanceof ENil) {
            return new ENil();
        } else if (expr instanceof ECond) {
            ECond e = (ECond) expr;
            return new ECond(swap(e.getTest(), varFrom, varTo), swap(e.getThenBranch(), varFrom, varTo), swap(e.getElseBranch(), varFrom, varTo));
        } else if (expr instanceof ECons) {
            ECons e = (ECons) expr;
            return new ECons(swap(e.getHead(), varFrom, varTo), swap(e.getTail(), varFrom, varTo));
        } else if (expr instanceof EFst) {
            EFst e = (EFst) expr;
            return new EFst(swap(e.getPair(), varFrom, varTo));
        } else if (expr instanceof ESnd) {
            ESnd e = (ESnd) expr;
            return new ESnd(swap(e.getPair(), varFrom, varTo));
        } else if (expr instanceof EPair) {
            EPair e = (EPair) expr;
            return new EPair(swap(e.getFirst(), varFrom, varTo), swap(e.getSecond(), varFrom, varTo));
        } else if (expr instanceof ERandCol) {
            ERandCol e = (ERandCol) expr;
            return new ERandCol(swap(e.getColourList(), varFrom, varTo));
        } else if (expr instanceof ESetCol) {
            ESetCol e = (ESetCol) expr;
            return new ESetCol(swap(e.getColour(), varFrom, varTo));
        } else if (expr instanceof ESetPen) {
            return expr;
        } else if (expr instanceof ESequence) {
            ESequence e = (ESequence) expr;
            return new ESequence(swap(e.getE1(), varFrom, varTo), swap(e.getE2(), varFrom, varTo));
        
        } else if (expr instanceof ELet) {
            ELet e = (ELet) expr;
            return new ELet(
                swapVar(e.getBinder(), varFrom, varTo),
                swap(e.getSubject(), varFrom, varTo),
                swap(e.getContinuation(), varFrom, varTo));
        } else if (expr instanceof ELetPair) {
            ELetPair e = (ELetPair) expr;
            return new ELetPair(
                    swapVar(e.getParam1(), varFrom, varTo),
                    swapVar(e.getParam2(), varFrom, varTo),
                swap(e.getSubject(), varFrom, varTo),
                swap(e.getBody(), varFrom, varTo));
        } else if (expr instanceof ELetFun) {
            ELetFun e = (ELetFun) expr;
            return new
                ELetFun(
                    swapVar(e.getFunctionName(), varFrom, varTo),
                    swapVar(e.getParam(), varFrom, varTo),
                    e.getParamTy(),
                    swap(e.getSubject(), varFrom, varTo),
                    swap(e.getBody(), varFrom, varTo));
        } else if (expr instanceof ELetRec) {
            ELetRec e = (ELetRec) expr;
            return new ELetRec(
                swapVar(e.getFunctionName(), varFrom, varTo),
                swapVar(e.getParam(), varFrom, varTo),
                e.getParamTy(),
                e.getReturnTy(),
                swap(e.getSubject(), varFrom, varTo),
                swap(e.getBody(), varFrom, varTo));
        } else if (expr instanceof EForward efwd) {
            return new EForward(swap(efwd.getAmount(), varFrom, varTo));
        } else if (expr instanceof EBackward ebwd) {
            return new EBackward(swap(ebwd.getAmount(), varFrom, varTo));
        } else if (expr instanceof ETurnLeft el) {
            return new ETurnLeft(swap(el.getAmount(), varFrom, varTo));
        } else if (expr instanceof ETurnRight er) {
            return new ETurnRight(swap(er.getAmount(), varFrom, varTo));
        } else if (expr instanceof EColour) {
            EColour e = (EColour) expr;
            return new EColour(e.getColour());
        } else if (expr instanceof ERec) {
            ERec e = (ERec) expr;
            return new ERec(
                swapVar(e.getFunName(), varFrom, varTo),
                swapVar(e.getArgName(), varFrom, varTo),
                e.getArgType(),
                e.getResultType(),
                swap(e.getBody(), varFrom, varTo));
        } else if (expr instanceof ECase) {
            ECase eCase = (ECase) expr;
            return new ECase(
                swap(eCase.getScrutinee(), varFrom, varTo),
                swap(eCase.getEmptyCase(), varFrom, varTo),
                swapVar(eCase.getHeadBinder(), varFrom, varTo),
                swapVar(eCase.getTailBinder(), varFrom, varTo),
                swap(eCase.getConsCase(), varFrom, varTo));
        } else {
            throw new RuntimeException("Invalid expression in Subst.java (swap): " + expr.toString());
        }
    }
 
    public static Expr subst(Expr expr, Expr replacement, String var) {
        if (expr instanceof EVar) {
            EVar e = (EVar) expr;
            if (e.getVar().equals(var)) return replacement;
            else return e;
        } else if (expr instanceof ELambda) {
            ELambda e = (ELambda) expr;
            if (e.getParameter().equals(var)) {
                return e;
            } else {
                return new ELambda(NameSource.genFreshName(), e.getParameterType(), subst(e.getBody(), replacement, var));
            }
        } else if (expr instanceof ERec) {
            ERec e = (ERec) expr;
            if (e.getArgName().equals(var) || e.getFunName().equals(var)) {
                return e;
            } else {
                return new ERec(NameSource.genFreshName(), NameSource.genFreshName(), e.getArgType(), e.getResultType(), subst(e.getBody(), replacement, var));
            }
        } else if (expr instanceof ELet) {
            ELet e = (ELet) expr;
            if (e.getBinder().equals(var)) {
                return new ELet(e.getBinder(), subst(e.getSubject(), replacement, var), e.getContinuation());
            } else {
                return new ELet(NameSource.genFreshName(), subst(e.getSubject(), replacement, var), subst(e.getContinuation(), replacement, var));
            }
        } else if (expr instanceof ECase) {
            ECase e = (ECase) expr;
            if (e.getHeadBinder().equals(var) || e.getTailBinder().equals(var)) {
                return new ECase(
                    subst(e.getScrutinee(), replacement, var),
                    subst(e.getEmptyCase(), replacement, var),
                    e.getHeadBinder(),
                    e.getTailBinder(),
                    e.getConsCase()
                );
            } else {
                return new ECase(
                    subst(e.getScrutinee(), replacement, var),
                    subst(e.getEmptyCase(), replacement, var),
                    NameSource.genFreshName(),
                    NameSource.genFreshName(),
                    subst(e.getConsCase(), replacement, var)
                );
            }
        } else if (expr instanceof ELetFun) {
            ELetFun e = (ELetFun) expr;
            if (e.getParam().equals(var)) {
                return new ELetFun(
                    NameSource.genFreshName(),
                    e.getParam(),
                    e.getParamTy(),
                    e.getSubject(),
                    subst(e.getBody(), replacement, var)
                );
            } else if (e.getFunctionName().equals(var)) {
                return new ELetFun(
                    e.getFunctionName(),
                    NameSource.genFreshName(),
                    e.getParamTy(),
                    subst(e.getSubject(), replacement, var),
                    e.getBody()
                );
            } else {
                return new ELetFun(
                    NameSource.genFreshName(),
                    NameSource.genFreshName(),
                    e.getParamTy(),
                    subst(e.getSubject(), replacement, var),
                    subst(e.getBody(), replacement, var)
                );
            }
        } else if (expr instanceof ELetRec) {
            ELetRec e = (ELetRec) expr;
            if (e.getFunctionName().equals(var)) {
                return e;
            } else if (e.getParam().equals(var)) {
                return new ELetRec(
                    NameSource.genFreshName(),
                    e.getParam(),
                    e.getParamTy(),
                    e.getReturnTy(),
                    e.getSubject(),
                    subst(e.getBody(), replacement, var)
                );
            } else {
                return new ELetRec(
                    NameSource.genFreshName(),
                    NameSource.genFreshName(),
                    e.getParamTy(),
                    e.getReturnTy(),
                    subst(e.getSubject(), replacement, var),
                    subst(e.getBody(), replacement, var)
                );
            }
        } else if (expr instanceof ELetPair) {
            ELetPair e = (ELetPair) expr;
            if (e.getParam1().equals(var) || e.getParam2().equals(var)) {
                return new ELetPair(
                    e.getParam1(),
                    e.getParam2(),
                    subst(e.getSubject(), replacement, var),
                    e.getBody()
                );
            } else {
                return new ELetPair(
                    NameSource.genFreshName(),
                    NameSource.genFreshName(),
                    subst(e.getSubject(), replacement, var),
                    subst(e.getBody(), replacement, var)
                );
            }
        } else {
            throw new RuntimeException("Invalid expression in Subst.java (subst): " + expr.toString());
        }
    }

}
