package ast;
public class ELambda extends Expr {
    private String parameter;
    private Type parameterType;
    private Expr body;
    public ELambda(String parameter, Type parameterType, Expr body) {
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

    @Override
    public String toString() {
        return "\\" + parameter + ": " + parameterType + " . " + body;
    }

}

