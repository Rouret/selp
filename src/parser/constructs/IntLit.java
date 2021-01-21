package parser.constructs;

import parser.State;

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
    public int eval(State<Integer> stateVariables) {
        return value;
    }
}
