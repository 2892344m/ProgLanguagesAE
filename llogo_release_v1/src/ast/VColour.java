package ast;

public class VColour extends Value {
    
    private Colour colour;
    public VColour(Colour c) { 
        this.colour = c;
    }

    public Expr toExpr() {
        return new EColour(colour);
    }

    public Colour getColour() {
        return this.colour;
    }

}
