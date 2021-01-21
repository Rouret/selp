package parser.constructs;

public class IntLit extends Exp {

    private final int value;

    public IntLit(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IntLit("+this.value+")";
    }

    @Override
    public int eval() {
        return value;
    }
}
