public class IMove extends Instruction {

    private int amount;

    public IMove(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("MOVE(%d)", amount);
    }

}

