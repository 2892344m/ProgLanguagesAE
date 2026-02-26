package ast;

public class EBackward extends Expr {
    private final Expr amount;

    public EBackward(Expr amount) {
        this.amount = amount;
    }

    public Expr getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "backward(" + amount + ")";
    }

}
