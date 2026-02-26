package ast;

public class ELetRec extends Expr {
    private String functionName;
    private String param;
    private Type paramTy;
    private Type returnTy;
    private Expr subject;
    private Expr body;

    public ELetRec(String functionName, String param, Type paramTy, Type returnTy, Expr subject, Expr body) {
        this.functionName = functionName;
        this.param = param;
        this.paramTy = paramTy;
        this.returnTy = returnTy;
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

    public Type getReturnTy() {
        return returnTy;
    }

    public Expr getSubject() {
        return subject;
    }

    public Expr getBody() {
        return body;
    }

    @Override
    public String toString() {
        return String.format("let rec %s(%s: %s): %s = %s in %s", functionName, param, paramTy, returnTy, subject, body);
    }

}
