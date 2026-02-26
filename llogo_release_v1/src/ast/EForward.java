package ast;

public class EForward extends Expr {
    private final Expr amount;

    public EForward(Expr amount) {
        this.amount = amount;
    }

    public Expr getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "forward(" + amount + ")";
    }

}
