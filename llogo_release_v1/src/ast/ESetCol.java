package ast;

public class ESetCol extends Expr {
    private Expr colour;

    public ESetCol(Expr colour) {
        this.colour = colour;
    }

    public Expr getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "setCol(" + colour + ")";
    }

}


