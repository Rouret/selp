package parser.constructs;


import parser.State;

public class UnDEF extends Exp {

    private Exp exp;

    public UnDEF(Exp value) {
        this.exp = value;
    }


    @Override
    public int eval(State<Integer> stateVariables, State<FunDef> stateFunDef) {
        return -1 * this.exp.eval(stateVariables, stateFunDef);
    }

    @Override
    public String toString() {
        return "UnDEF("+this.exp+")";
    }
}
