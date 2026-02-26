package ast;

public class TyColourList extends Type {

    private TyColourList() {
    }

    private static TyColourList type = new TyColourList();

    public static TyColourList type() {
        return type;
    }

    @Override
    public String toString() {
        return "ColourList";
    }


}
