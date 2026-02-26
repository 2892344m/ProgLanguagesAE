package ast;
public class EApp extends Expr {
    private Expr function;
    private Expr argument;
    public EApp(Expr function, Expr argument) {
        this.function = function;
        this.argument = argument;
    }
    public Expr getFunction() {
        return function;
    }
    public Expr getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return function + " " + argument;
    }

}
