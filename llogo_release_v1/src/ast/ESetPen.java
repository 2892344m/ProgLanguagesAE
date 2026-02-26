package ast;

public class ESetPen extends Expr {
    boolean isPenDown;

    public ESetPen(boolean isPenDown) {
        this.isPenDown = isPenDown;
    }

    public boolean isPenDown() {
        return this.isPenDown;
    }
  
    @Override
    public String toString() {
        if (isPenDown) {
            return "penDown()";
        } else {
            return "penUp()";
        }
    }

}

