package ast;

public class TyFun extends Type {
    private Type paramType;
    private Type returnType;

    public TyFun(Type paramType, Type returnType) {
        this.paramType = paramType;
        this.returnType = returnType;
    }

    public Type getTy1() {
        return paramType;
    }

    public Type getTy2() {
        return returnType;
    }


    @Override
    public String toString() {
        return "(" + paramType + " -> " + returnType + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((paramType == null) ? 0 : paramType.hashCode());
        result = prime * result + ((returnType == null) ? 0 : returnType.hashCode());
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
        TyFun other = (TyFun) obj;
        if (paramType == null) {
            if (other.paramType != null)
                return false;
        } else if (!paramType.equals(other.paramType))
            return false;
        if (returnType == null) {
            if (other.returnType != null)
                return false;
        } else if (!returnType.equals(other.returnType))
            return false;
        return true;
    }


}
