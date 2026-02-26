package ast;

public class ELetPair extends Expr {
    private String param1;
    private String param2;
    private Expr subject;
    private Expr body;

    public ELetPair(String p1, String p2, Expr subject, Expr body) {
        this.param1 = p1;
        this.param2 = p2;
        this.subject = subject;
        this.body = body;
    }

    public String getParam1() {
        return param1;
    }
    public String getParam2() {
        return param2;
    }
    public Expr getSubject() {
        return subject;
    }
    public Expr getBody() {
        return body;
    }

    @Override
    public String toString() {
        return String.format("let (%s, %s) = %s in %s", param1, param2, subject, body);
    }

}

