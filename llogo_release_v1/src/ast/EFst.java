package ast;

public class EFst extends Expr {
    private Expr pair;
    public EFst(Expr e) {
        this.pair = e;
    }
    public Expr getPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "fst(" + pair + ")";
    }

}
