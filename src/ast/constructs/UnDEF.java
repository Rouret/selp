package ast.constructs;


import ast.State;

public class UnDEF extends Exp {

    private final Exp exp;

    public UnDEF(Exp value) {
        this.exp = value;
    }


    @Override
    public int eval(State<Integer> stateVariables) {
        return -1 * this.exp.eval(stateVariables);
    }

    @Override
    public String gen() {
        return "( -"+this.exp.gen()+")";
    }

    @Override
    public String toString() {
        return "UnDEF("+this.exp+")";
    }
}
