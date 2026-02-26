package ast;
public class ERandCol extends Expr {
    private Expr colourList;

    public ERandCol(Expr colourList) {
        this.colourList = colourList;
    }

    public Expr getColourList() {
        return colourList;
    }

    @Override
    public String toString() {
        return "randCol(" + colourList + ")";
    }
}
