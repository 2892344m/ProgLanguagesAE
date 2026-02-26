package ast;

public class ESnd extends Expr {
    private Expr pair;
    public ESnd(Expr e) {
        this.pair = e;
    }
    public Expr getPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "snd(" + pair + ")";
    }

}
