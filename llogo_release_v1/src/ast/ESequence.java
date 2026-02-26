package ast;

public class ESequence extends Expr {
    private Expr e1;
    private Expr e2;
    public ESequence(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    public Expr getE1() {
        return e1;
    }
    public Expr getE2() {
        return e2;
    }

    @Override
    public String toString() {
        return e1 + "; " + e2;
    }

}
