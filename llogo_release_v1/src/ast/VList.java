package ast;

import java.util.List;

public class VList extends Value {
    private List<Value> contents;
    public VList(List<Value> contents) {
        this.contents = contents;
    }

    public List<Value> getContents() {
        return contents;
    }

    public Expr toExpr() {
        if (contents.isEmpty()) {
            return new ENil();
        } else {
            Value head = contents.get(0);
            List<Value> tail = contents.subList(1, contents.size());
            return new ECons(head.toExpr(), new VList(tail).toExpr());
        }
    }

}
