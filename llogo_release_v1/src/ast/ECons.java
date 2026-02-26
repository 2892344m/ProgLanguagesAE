package ast;

public class ECons extends Expr {
    private Expr head;
    private Expr tail;
    public ECons(Expr head, Expr tail) {
        this.head = head;
        this.tail = tail;
    }
    public Expr getHead() {
        return head;
    }
    public Expr getTail() {
        return tail;
    }
 
    @Override
    public String toString() {
        return head + " :: " + tail;
    }

}


