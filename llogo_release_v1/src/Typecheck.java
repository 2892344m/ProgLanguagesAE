import ast.*;

public class Typecheck {

    private void checkType(Type expected, Type actual) {
        if (!actual.equals(expected)) {
            throw new TypeErrorException(String.format("Type mismatch: Expected %s but got %s", expected, actual));
        }
    }

    public Type typecheckExpr(Environment<Type> tyEnv, Expr e) {
        throw new RuntimeException("typecheckExpr (Typecheck.java): fill me in");
    }
}
