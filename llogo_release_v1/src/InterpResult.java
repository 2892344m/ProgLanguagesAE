import java.util.List;
import ast.*;

public class InterpResult {
    private Value value;
    private List<Instruction> instructions;

    public InterpResult(Value value, List<Instruction> instructions) {
        this.value = value;
        this.instructions = instructions;
    }

    public Value getValue() {
        return value;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

}
