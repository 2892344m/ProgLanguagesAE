package ast;

public class ETurnLeft extends Expr {
    private final Expr amount;

    public ETurnLeft(Expr amount) {
        this.amount = amount;
    }

    public Expr getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "left(" + amount + ")";
    }
    
}

