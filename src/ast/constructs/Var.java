package ast.constructs;

import ast.State;

public class Var extends Exp {

    private final String varName;

    public Var(String varName) {
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public int eval(State<Integer> stateVariables) {
        return 0;
    }

    @Override
    public String gen() {
        return null;
    }

    @Override
    public String toString() {
        return "VAR("+this.varName+")";
    }
}
