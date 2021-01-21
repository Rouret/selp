package parser.constructs;


public class UnDEF extends Exp {

    private final int value;

    public UnDEF(int value) {
        this.value = -value;
    }


    @Override
    public int eval() {
        return this.value;
    }

    @Override
    public String toString() {
        return "UnDEF("+this.value+")";
    }
}
