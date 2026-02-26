package ast;

public class EBinOp extends Expr {

    public enum Op {
        ADD, SUB, MUL, DIV, GT, LT,
        AND, OR, EQ, LTE, GTE
    }

    private Expr e1;
    private Op op;
    private Expr e2;
    
    public EBinOp(Expr e1, Op op, Expr e2) {
        this.e1 = e1;
        this.op = op;
        this.e2 = e2;
    }

    public Expr getE1() {
        return e1;
    }

    public Op getOp() {
        return op;
    }
    
    public Expr getE2() {
        return e2;
    }

    private String opToString(Op op) {
        return switch (op) {
            case ADD -> "+";
            case SUB -> "-";
            case MUL -> "*";
            case DIV -> "/";
            case GT -> ">";
            case LT -> "<";
            case GTE -> ">=";
            case LTE -> "<=";
            case AND -> "&&";
            case OR -> "||";
            case EQ -> "==";
        };
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", e1, opToString(op), e2);
    }

    

    
}
