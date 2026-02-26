package ast;

public class TyColour extends Type {

    private TyColour() {
    }

    private static TyColour type = new TyColour();

    public static TyColour type() {
        return type;
    }

    @Override
    public String toString() {
        return "Colour";
    }
}
