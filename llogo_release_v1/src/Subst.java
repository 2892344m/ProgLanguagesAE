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
                String freshVar = NameSource.genFreshName();
                Expr newBody = swap(e.getBody(), e.getParameter(), freshVar);
                return new ELambda(freshVar, e.getParameterType(), subst(newBody, replacement, var));
            }
        } else if (expr instanceof ERec) {
            ERec e = (ERec) expr;
            if (e.getArgName().equals(var) || e.getFunName().equals(var)) {
                return e;
            } else {
                String freshArgName = NameSource.genFreshName();
                Expr freshBody = swap(e.getBody(), e.getArgName(), freshArgName);
                String freshFunName = NameSource.genFreshName();
                freshBody = swap(freshBody, e.getFunName(), freshFunName);
                return new ERec(freshFunName, freshArgName, e.getArgType(), e.getResultType(), subst(freshBody, replacement, var));
            }
        } else if (expr instanceof ELet) {
            ELet e = (ELet) expr;
            if (e.getBinder().equals(var)) {
                return new ELet(e.getBinder(), subst(e.getSubject(), replacement, var), e.getContinuation());
            } else {
                String freshBinder = NameSource.genFreshName();
                Expr freshSubject = swap(e.getSubject(), e.getBinder(), freshBinder);
                Expr freshContinuation = swap(e.getContinuation(), e.getBinder(), freshBinder);
                return new ELet(freshBinder, subst(freshSubject, replacement, var), subst(freshContinuation, replacement, var));
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
                String freshHead = NameSource.genFreshName();
                Expr freshScrut = swap(e.getScrutinee(), e.getHeadBinder(), freshHead);
                Expr freshEmpty = swap(e.getEmptyCase(), e.getHeadBinder(), freshHead);
                Expr freshCons = swap(e.getConsCase(), e.getHeadBinder(), freshHead);

                String freshTail = NameSource.genFreshName();
                freshScrut = swap(freshScrut, e.getTailBinder(), freshTail);
                freshEmpty = swap(freshEmpty, e.getTailBinder(), freshTail);
                freshCons = swap(freshCons, e.getTailBinder(), freshTail);

                return new ECase(
                    subst(freshScrut, replacement, var),
                    subst(freshEmpty, replacement, var),
                    freshHead,
                    freshTail,
                    subst(freshCons, replacement, var)
                );
            }
        } else if (expr instanceof ELetFun) {
            ELetFun e = (ELetFun) expr;
            if (e.getParam().equals(var)) {
                String freshFun = NameSource.genFreshName();
                Expr freshBody = swap(e.getBody(), e.getFunctionName(), freshFun);

                return new ELetFun(
                    freshFun,
                    e.getParam(),
                    e.getParamTy(),
                    e.getSubject(),
                    subst(freshBody, replacement, var)
                );
            } else if (e.getFunctionName().equals(var)) {
                String freshParam = NameSource.genFreshName();
                Expr freshSubject = swap(e.getSubject(), e.getParam(), freshParam);

                return new ELetFun(
                    e.getFunctionName(),
                    freshParam,
                    e.getParamTy(),
                    subst(freshSubject, replacement, var),
                    e.getBody()
                );
            } else {
                String freshFun = NameSource.genFreshName();
                Expr freshBody = swap(e.getBody(), e.getFunctionName(), freshFun);
                Expr freshSubject = swap(e.getSubject(), e.getFunctionName(), freshFun);

                String freshParam = NameSource.genFreshName();
                freshBody = swap(freshBody, e.getParam(), freshParam);
                freshSubject = swap(freshSubject, e.getParam(), freshParam);

                return new ELetFun(
                    freshFun,
                    freshParam,
                    e.getParamTy(),
                    subst(freshBody, replacement, var),
                    subst(freshSubject, replacement, var)
                );
            }
        } else if (expr instanceof ELetRec) {
            ELetRec e = (ELetRec) expr;
            if (e.getFunctionName().equals(var)) {
                return e;
            } else if (e.getParam().equals(var)) {
                String freshFun = NameSource.genFreshName();
                Expr freshBody = swap(e.getBody(), e.getFunctionName(), freshFun);

                return new ELetRec(
                    freshFun,
                    e.getParam(),
                    e.getParamTy(),
                    e.getReturnTy(),
                    e.getSubject(),
                    subst(freshBody, replacement, var)
                );
            } else {
                String freshFun = NameSource.genFreshName();
                Expr freshBody = swap(e.getBody(), e.getFunctionName(), freshFun);
                Expr freshSubject = swap(e.getSubject(), e.getFunctionName(), freshFun);

                String freshParam = NameSource.genFreshName();
                freshBody = swap(freshBody, e.getParam(), freshParam);
                freshSubject = swap(freshSubject, e.getParam(), freshParam);

                return new ELetRec(
                    freshFun,
                    freshParam,
                    e.getParamTy(),
                    e.getReturnTy(),
                    subst(freshSubject, replacement, var),
                    subst(freshBody, replacement, var)
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
                String freshParam1 = NameSource.genFreshName();
                Expr freshSubject = swap(e.getSubject(), e.getParam1(), freshParam1);
                Expr freshBody = swap(e.getBody(), e.getParam1(), freshParam1);

                String freshParam2 = NameSource.genFreshName();
                freshSubject = swap(freshSubject, e.getParam2(), freshParam2);
                freshBody = swap(freshBody, e.getParam2(), freshParam2);

                return new ELetPair(
                    freshParam1,
                    freshParam2,
                    subst(freshSubject, replacement, var),
                    subst(freshBody, replacement, var)
                );
            }
        } else if (expr instanceof ERandCol) {
            ERandCol e = (ERandCol) expr;
            return new ERandCol(subst(e.getColourList(), replacement, var));
        } else if (expr instanceof ESequence) {
            ESequence e = (ESequence) expr;
            return new ESequence(
                subst(e.getE1(), replacement, var),
                subst(e.getE2(), replacement, var)
            );
        } else if (expr instanceof EApp) {
            EApp e = (EApp) expr;
            return new EApp(
                subst(e.getFunction(), replacement, var),
                subst(e.getArgument(), replacement, var));
        } else if (expr instanceof EPair) {
            EPair e = (EPair) expr;
            return new EPair(
                subst(e.getFirst(), replacement, var),
                subst(e.getSecond(), replacement, var)
            );
        } else if (expr instanceof ECond) {
            ECond e = (ECond) expr;
            return new ECond(
                subst(e.getTest(), replacement, var),
                subst(e.getThenBranch(), replacement, var),
                subst(e.getElseBranch(), replacement, var)
            );
        } else if (expr instanceof EBinOp) {
            EBinOp e = (EBinOp) expr;
            return new EBinOp(
                subst(e.getE1(), replacement, var),
                e.getOp(),
                subst(e.getE2(), replacement, var)
            );
        } else if (expr instanceof ESetCol) {
            ESetCol e = (ESetCol) expr;
            return new ESetCol(subst(e.getColour(), replacement, var));
        } else if (expr instanceof EForward) {
            EForward e = (EForward) expr;
            return new EForward(subst(e.getAmount(), replacement, var));
        } else if (expr instanceof EBackward) {
            EBackward e = (EBackward) expr;
            return new EBackward(subst(e.getAmount(), replacement, var));
        } else if (expr instanceof ETurnRight) {
            ETurnRight e = (ETurnRight) expr;
            return new ETurnRight(subst(e.getAmount(), replacement, var));
        } else if (expr instanceof ETurnLeft) {
            ETurnLeft e = (ETurnLeft) expr;
            return new ETurnLeft(subst(e.getAmount(), replacement, var));
        } else if (expr instanceof EFst) {
            EFst e = (EFst) expr;
            return new EFst(subst(e.getPair(), replacement, var));
        } else if (expr instanceof ESnd) {
            ESnd e = (ESnd) expr;
            return new ESnd(subst(e.getPair(), replacement, var));
        } else {
            return expr;
        }
    }

}
