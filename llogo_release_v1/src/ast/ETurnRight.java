package ast;

public class ETurnRight extends Expr {
    private final Expr amount;

    public ETurnRight(Expr amount) {
        this.amount = amount;
    }

    public Expr getAmount() {
        return amount;
    }
    
    
    @Override
    public String toString() {
        return "right(" + amount + ")";
    }
    
}

