public class ISetPen extends Instruction {
    private boolean penIsDown;
    public ISetPen(boolean penIsDown) {
        this.penIsDown = penIsDown;
    }

    public boolean penIsDown() {
        return penIsDown;
    }

    @Override
    public String toString() {
        return String.format("SETPEN(%s)", penIsDown ? "true" : "false");
    }

}

