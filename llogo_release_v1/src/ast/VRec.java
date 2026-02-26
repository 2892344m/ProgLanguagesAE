package ast;

public class VRec extends Value {
    private String funName;
    private String argName;
    private Type argType;
    private Type resultType;
    private Expr body;
    public VRec(String funName, String argName, Type argType, Type resultType, Expr body) {
        this.funName = funName;
        this.argName = argName;
        this.argType = argType;
        this.resultType = resultType;
        this.body = body;
    }
    public String getFunName() {
        return funName;
    }
    public String getArgName() {
        return argName;
    }
    public Expr getBody() {
        return body;
    }
   
    public Type getArgType() {
        return argType;
    }
    public Type getResultType() {
        return resultType;
    }
    @Override
    public String toString() {
        return "(rec " + funName + "(" + argName + ": " + argType + "): " + resultType + " . " + body + " )";
    }

    public Expr toExpr() {
        return new ERec(funName, argName, argType, resultType, body);
    }

}
