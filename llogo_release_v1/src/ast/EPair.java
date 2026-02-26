package ast;

public class EPair extends Expr {
    private Expr e1;
    private Expr e2;
    public EPair(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    public Expr getFirst() {
        return e1;
    }
    public Expr getSecond() {
        return e2;
    }

    @Override
    public String toString() {
        return "(" + e1 + ", " + e2 + ")";
    }

}
