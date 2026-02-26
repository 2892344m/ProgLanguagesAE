package ast;

public class VPair extends Value {
    private Value v1;
    private Value v2;
    public VPair(Value v1, Value v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    public Value getFirst() {
        return v1;
    }
    public Value getSecond() {
        return v2;
    }

    public Expr toExpr() {
        return new EPair(v1.toExpr(), v2.toExpr());
    }

    

}
