package ast;

public class VUnit extends Value {

    public VUnit() { }

    @Override
    public String toString() {
        return "()";
    }

    @Override
    public boolean equals(Object obj2) {
        return obj2 instanceof VUnit;
    }

    public Expr toExpr() {
        return new EUnit();
    }

}
