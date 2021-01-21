package parser.constructs;

import parser.State;

public class Var extends Exp {

    private final String varName;

    public Var(String varName) {
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public int eval(State<Integer> stateVariables, State<FunDef> stateFunDef) {
        return stateVariables.lookup(this.varName);
    }

    @Override
    public String toString() {
        return "VAR("+this.varName+")";
    }
}
