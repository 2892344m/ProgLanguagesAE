package ast;
public class VLambda extends Value {
    private String parameter;
    private Type parameterType;
    private Expr body;

    public VLambda(String parameter, Type parameterType, Expr body) {
        this.parameter = parameter;
        this.parameterType = parameterType;
        this.body = body;
    }
    public String getParameter() {
        return parameter;
    }
    public Type getParameterType() {
        return parameterType;
    }
    public Expr getBody() {
        return body;
    }

    public Expr toExpr() {
        return new ELambda(parameter, parameterType, body);
    }
  
}
