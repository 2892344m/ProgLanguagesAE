public class ITurn extends Instruction{

    private int amount;

    public ITurn(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("TURN(%d)", amount);
    }

}
