import ast.Colour;

public class IChangeColour extends Instruction {

    private Colour colour;

    public IChangeColour(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return String.format("SETCOL(%s)", colour.toString().toLowerCase());
    }

}
