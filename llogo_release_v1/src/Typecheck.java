import ast.*;

public class Typecheck {

    private void checkType(Type expected, Type actual) {
        if (!actual.equals(expected)) {
            throw new TypeErrorException(String.format("Type mismatch: Expected %s but got %s", expected, actual));
        }
    }

    public Type typecheckExpr(Environment<Type> tyEnv, Expr expr) {
        if (expr instanceof EInt e) {
            return TyInt.type();
        } else if (expr instanceof EBool) {
            return TyBool.type();
        } else if (expr instanceof ELambda) {
            ELambda e = (ELambda) expr;
            tyEnv = tyEnv.extend(e.getParameter(), e.getParameterType());
            Type B = typecheckExpr(tyEnv, e.getBody());
            return new TyFun(e.getParameterType(), B);
        } else if (expr instanceof ERec) {
            ERec e = (ERec) expr;
            tyEnv = tyEnv.extend(e.getArgName(), e.getArgType());
            tyEnv = tyEnv.extend(e.getFunName(), e.getResultType());
            Type B = typecheckExpr(tyEnv, e.getBody());
            checkType(e.getResultType(), B);
            return new TyPair(e.getArgType(), B);
        } else if (expr instanceof ELet) {
            ELet e = (ELet) expr;
            tyEnv = tyEnv.extend(e.getBinder(), typecheckExpr(tyEnv, e.getSubject()));
            return typecheckExpr(tyEnv, e.getContinuation());
        } else if (expr instanceof ELetFun) {
            ELetFun e = (ELetFun) expr;
            tyEnv = tyEnv.extend(e.getParam(), e.getParamTy());
            Type M = typecheckExpr(tyEnv, e.getSubject());
            tyEnv = tyEnv.extend(e.getFunctionName(), M);
            return typecheckExpr(tyEnv, e.getBody());
        } else if (expr instanceof ELetRec) {
            ELetRec e = (ELetRec) expr;
            tyEnv = tyEnv.extend(e.getParam(), e.getParamTy());
            tyEnv = tyEnv.extend(e.getFunctionName(), e.getReturnTy());
            typecheckExpr(tyEnv, e.getSubject());
            return typecheckExpr(tyEnv, e.getBody());
        } else if (expr instanceof EUnit) {
            return TyUnit.type();
        } else if (expr instanceof EColour) {
            return TyColour.type();
        } else if (expr instanceof EVar) {
            EVar e = (EVar) expr;
            return tyEnv.lookup(e.getVar());
        } else if (expr instanceof EApp) {
            EApp e = (EApp) expr;
            typecheckExpr(tyEnv, e.getArgument());
            return typecheckExpr(tyEnv, e.getFunction());
        } else if (expr instanceof ECond) {
            ECond e = (ECond) expr;
            checkType(TyBool.type(), typecheckExpr(tyEnv, e.getTest()));
            Type M = typecheckExpr(tyEnv, e.getThenBranch());
            Type N  = typecheckExpr(tyEnv, e.getElseBranch());
            checkType(N, M);
            return N;
        } else if (expr instanceof ENil) {
            return TyColourList.type();
        } else if (expr instanceof ECons) {
            ECons e = (ECons) expr;
            Type M = typecheckExpr(tyEnv, e.getHead());
            checkType(TyColour.type(), M);
            Type N = typecheckExpr(tyEnv, e.getTail());
            checkType(TyColourList.type(), N);
            return TyColourList.type();
        } else if (expr instanceof ECase) {
            ECase e = (ECase) expr;
            Type L = typecheckExpr(tyEnv, e.getScrutinee());
            checkType(TyColourList.type(), L);
            Type M = typecheckExpr(tyEnv, e.getEmptyCase());
            Type N = typecheckExpr(tyEnv, e.getConsCase());
            checkType(M, N);
            return M;
        } else if (expr instanceof EPair) {
            EPair e = (EPair) expr;
            Type M = typecheckExpr(tyEnv, e.getFirst());
            Type N = typecheckExpr(tyEnv, e.getSecond());
            return new TyPair(M, N);
        } else if (expr instanceof EFst) {
            EFst e = (EFst) expr;
            TyPair p = (TyPair) typecheckExpr(tyEnv, e.getPair());
            return p.getTy1();
        } else if (expr instanceof ESnd) {
            ESnd e = (ESnd) expr;
            TyPair p = (TyPair) typecheckExpr(tyEnv, e.getPair());
            return p.getTy2();   
        } else if (expr instanceof ESequence) {
            ESequence e = (ESequence) expr;
            checkType(TyUnit.type(), typecheckExpr(tyEnv, e.getE1()));
            return typecheckExpr(tyEnv, e.getE2());
        } else if (expr instanceof EForward) {
            EForward e = (EForward) expr;
            checkType(TyInt.type(), typecheckExpr(tyEnv, e.getAmount()));
            return TyUnit.type();
        } else if (expr instanceof EBackward) {
            EBackward e = (EBackward) expr;
            checkType(TyInt.type(), typecheckExpr(tyEnv, e.getAmount()));
            return TyUnit.type();
        } else if (expr instanceof ETurnLeft) {
            ETurnLeft e = (ETurnLeft) expr;
            checkType(TyInt.type(), typecheckExpr(tyEnv, e.getAmount()));
            return TyUnit.type();
        } else if (expr instanceof ETurnRight) {
            ETurnRight e = (ETurnRight) expr;
            checkType(TyInt.type(), typecheckExpr(tyEnv, e.getAmount()));
            return TyUnit.type();
        } else if (expr instanceof ESetPen) {
            return TyUnit.type();
        } else if (expr instanceof ESetCol) {
            ESetCol e = (ESetCol) expr;
            checkType(TyColour.type(), typecheckExpr(tyEnv, e.getColour()));
            return TyUnit.type();
        } else if (expr instanceof ERandCol) {
            ERandCol e = (ERandCol) expr;
            checkType(TyColourList.type(), typecheckExpr(tyEnv, e.getColourList()));   
            return TyUnit.type();         
        } else if (expr instanceof ELetPair) {
            ELetPair e = (ELetPair) expr;
            TyPair p = (TyPair)  typecheckExpr(tyEnv, e.getSubject());
            tyEnv = tyEnv.extend(e.getParam1(), p.getTy1());
            tyEnv = tyEnv.extend(e.getParam2(), p.getTy2());
            return typecheckExpr(tyEnv, e.getBody());
        } else if (expr instanceof EBinOp) {
            EBinOp e = (EBinOp) expr;
            Type t1 = typecheckExpr(tyEnv, e.getE1());
            Type t2 = typecheckExpr(tyEnv, e.getE2());
            checkType(t1, t2);
            switch (e.getOp()) {
                case ADD:
                    return TyInt.type();
                case AND:
                    return TyBool.type();
                case DIV:
                    return TyInt.type();
                case EQ:
                    return TyBool.type();
                case GT:
                    return TyBool.type();
                case GTE:
                    return TyBool.type();
                case LT:
                    return TyBool.type();
                case LTE:
                    return TyBool.type();
                case MUL:
                    return TyInt.type();
                case OR:
                    return TyBool.type();
                case SUB:
                    return TyInt.type();
            }
        } else {
            throw new TypeErrorException("Type Error: Unhandled Expression in (typecheckExpr): " + expr.getClass() + " \nInformation: " + expr.toString());
        }
        return null;
    }
}
