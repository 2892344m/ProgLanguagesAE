package ast;

public class ECase extends Expr {

    private Expr scrutinee;
    private Expr emptyCase;
    private String headBinder;
    private String tailBinder;
    private Expr consCase;

    public ECase(Expr scrutinee, Expr emptyCase, String headBinder, String tailBinder, Expr consCase) {
        this.scrutinee = scrutinee;
        this.emptyCase = emptyCase;
        this.headBinder = headBinder;
        this.tailBinder = tailBinder;
        this.consCase = consCase;
    }

    public Expr getScrutinee() {
        return scrutinee;
    }

    public Expr getEmptyCase() {
        return emptyCase;
    }

    public String getHeadBinder() {
        return headBinder;
    }

    public String getTailBinder() {
        return tailBinder;
    }

    public Expr getConsCase() {
        return consCase;
    }

    @Override
    public String toString() {
        return String.format("case %s of { [] -> %s | %s :: %s -> %s }",
            scrutinee, emptyCase, headBinder, tailBinder, consCase);
    }

}
