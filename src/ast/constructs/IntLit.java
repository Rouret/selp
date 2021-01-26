package ast.constructs;

import ast.State;

public class IntLit extends Exp {

    private final int value;

    public IntLit(int value) {
        this.value = value;
    }

    @Override
    public String gen() {
        return String.valueOf(this.value);
    }

    @Override
    public String toString() {
        return "IntLit(" + this.value + ")";
    }

    @Override
    public int eval(State<Integer> stateVariables) {
        return value;
    }

}
