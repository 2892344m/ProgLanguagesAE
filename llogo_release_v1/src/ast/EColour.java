package ast;

public class EColour extends Expr {

    private Colour colour;
    public EColour(Colour c) { 
        this.colour = c;
    }

    public Colour getColour() {
        return this.colour;
    }

    @Override
    public String toString() {
        return colour.toString().toLowerCase();
    }

}
