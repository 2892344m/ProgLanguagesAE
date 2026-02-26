package ast;

public class ELetFun extends Expr {
    private String functionName;
    private String param;
    private Type paramTy;
    private Expr subject;
    private Expr body;

    public ELetFun(String functionName, String param, Type paramTy, Expr subject, Expr body) {
        this.functionName = functionName;
        this.param = param;
        this.paramTy = paramTy;
        this.subject = subject;
        this.body = body;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getParam() {
        return param;
    }

    public Type getParamTy() {
        return paramTy;
    }

    public Expr getSubject() {
        return subject;
    }

    public Expr getBody() {
        return body;
    }

    @Override
    public String toString() {
        return String.format("let fun %s(%s: %s) = %s in %s", functionName, param, paramTy, subject, body);
    }

}
