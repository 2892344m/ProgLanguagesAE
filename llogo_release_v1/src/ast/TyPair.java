package ast;

public class TyPair extends Type {
    private Type ty1;
    private Type ty2;

    public TyPair(Type ty1, Type ty2) {
        this.ty1 = ty1;
        this.ty2 = ty2;
    }

    public Type getTy1() {
        return ty1;
    }

    public Type getTy2() {
        return ty2;
    }

    @Override
    public String toString() {
        return "(" + ty1 + " * " + ty2 + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ty1 == null) ? 0 : ty1.hashCode());
        result = prime * result + ((ty2 == null) ? 0 : ty2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TyPair other = (TyPair) obj;
        if (ty1 == null) {
            if (other.ty1 != null)
                return false;
        } else if (!ty1.equals(other.ty1))
            return false;
        if (ty2 == null) {
            if (other.ty2 != null)
                return false;
        } else if (!ty2.equals(other.ty2))
            return false;
        return true;
    }



}
